# Threshr Tests
Assuming your environment is setup to build a graalvm image and all that goes with building Threshr, these tests require file inputs.

### Environment Variables
Aside from the environment variables needed to build threshr, variables can be used to specify data to use in testing. These variables are found in `application.yml` at the repo's resource root directory. 

<details><summary>Tip for Windows Users</summary>
<ul>
<ul>

> :warning: You'll need Windows Terminal and winget on your machine for this setup. In good news, you may have these installed and not know it.

</ul>
The GraalVM requires the visual studio sdk in order to work. Graal has some instructions on getting this all setup. I'd suggest going through with the winget installer, it does the same thing doesn't require your input. 
<ul>

```PowerShell
winget install Microsoft.VisualStudio.2022.Community
```
</ul>
After installing, your Windows terminal will have a couple new profiles, one named `Develop PowerShell for VS 2022`. Begin adding a new profile based on this new one to find the commandline executable used for this profile. It will read something like:
<ul>

```sh
powershell.exe -NoExit -Command \
  "&{Import-Module """C:\Program Files\Microsoft Visual Studio\2022\Community\Common7\Tools\Microsoft.VisualStudio.DevShell.dll"""; \
   Enter-VsDevShell a33f35bb \ 
    -SkipAutomaticLocation \
    -DevCmdArguments """-arch=x64 -host_arch=x64"""}"
```
</ul>

All we need from this entry is that string given after the `Enter-VsDevShell` command (in the previous example, `a33f35bb`). This relies on <code><a href="https://github.com/Jonathan-Zollinger/powershell-profile/blob/c60d48da035977267ac523baf2ec4d15c16e8e68/bin.ps1#L1-L26">Add-ToPath</a></code>.
<ul>

```PowerShell
function Start-DevTerminal {
    <#
    .SYNOPSIS
    Configures shell to use a fully fledged java dev environment

    .DESCRIPTION
    Adds JAVA_HOME, GRAALVM_HOME and MAVEN_HOME variables and verifies they're each on system's PATH. 
    Imports VScode dev shell module and calls Enter-VsDevShell

    .PARAMETER Java
    Path to graalvm directory, defaults to ~\.jdks\graalvm-ce-17

    .PARAMETER Maven
    Path to maven directory, defaults to 'C:\Program Files\Apache Maven\'

    .EXAMPLE
    # Valid use could be as simple as calling with no args
    Start-DevTerminal

    #>
    [CmdletBinding()]
    param (
        [Parameter()]
        [String]
        [ValidateScript({ Test-Path -Path $_ -PathType Container })]
        $Java = "$($HOME)\.jdks\graalvm-ce-17",
        [Parameter()]
        [String]
        [ValidateScript({ Test-Path -Path $_ -PathType Container })]
        $Maven = "C:\Program Files\Apache Maven\"
    )
    @("JAVA_HOME", "GRAALVM_HOME") | ForEach-Object { 
        [System.Environment]::SetEnvironmentVariable($_, $Java)
    }
    [System.Environment]::SetEnvironmentVariable("MAVEN_HOME", "C:\Program Files\Apache Maven\")
    $devShellGeneratedName = "a33f35bb"
    Add-ToPath "$env:JAVA_HOME\bin"
    Add-ToPath "$env:MAVEN_HOME\bin"

    Import-Module "C:\Program Files\Microsoft Visual Studio\2022\Community\Common7\Tools\Microsoft.VisualStudio.DevShell.dll"
    Enter-VsDevShell  $devShellGeneratedName -SkipAutomaticLocation -DevCmdArguments "-arch=x64 -host_arch=x64"
}
```
</ul>
</ul>
</details>

### Default values and Test Data

<blockquote>Check out my <code><a href="https://github.com/Jonathan-Zollinger/powershell-profile/blob/c60d48da035977267ac523baf2ec4d15c16e8e68/bin.ps1#L29-L49">source</a></code> function to make using a .env file easier on windows.</blockquote>

<div class="tg-wrap">
    <table>
        <tbody>
        <tr>
            <td><strong>Variable Name</strong></td>
            <td><strong>Default Value</strong></td>
            <td><strong>File Content</strong></td>
        </tr>
        <tr>
            <td><i>TEST_DATASOURCES_FILE_STORES</i></td>
            <td>nearby_stores.json</td>
            <td>Emulated return json from the redsky `nearby_stores_v1` endpoint</td>
        </tr>
        <tr>
            <td><i>TEST_DATASOURCES_FILE_CATEGORIES</i></td>
            <td>target_categories.txt</td>
            <td>Target categories scraped from html on target's "all categories" page</td>
        </tr>
        <tr>
            <td><i>TEST_DATASOURCES_DEFAULT_URL</i></td>
            <td>full jdbc-formatted url</td>
            <td>no default value is provided for this</td>
        </tr>
        </tbody>
    </table>
</div>

### Run Tests

From the root directory, populate the environment variables and use the maven wrapper to execute the tests.
```PowerShell
source .env
Start-DevTerminal
./mvnw test
```
#### Log Levels
By default, Threshr's log level is set to Info. You can define log levels for packages by defining the variable package name as a variable, swapping `.` for `_` and prepending with `LOGGER_LEVELS`. As an example, to enable debug logging for the micronaut httpclient you'd create this variable and assignment:
```properties
LOGGER_LEVELS_IO_MICRONAUT_HTTP_CLIENT=DEBUG
```
