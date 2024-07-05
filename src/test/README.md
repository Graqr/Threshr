# Threshr Tests

In order to contribute to tests for Threshr, you'll need a few things:
- Some time on your hands
- A decent test editor or an IDE (I suggest intellij's ce edition)
- jdk installed with [JAVA_HOME configured appropriately](https://github.com/Graqr/Threshr/blob/f3e71c53302d3e451bf1292ea35c7559cb4ff695/Contributing.md)
- [A Docker environment supported by Testcontainers.](https://java.testcontainers.org/supported_docker_environment/)

### Environment Variables
Threshr looks for some values from environment variables. those are listed below.

<details><summary id="windows-tips">Tip for Windows Users</summary>
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
            <td><strong>Description</strong></td>
        </tr>
        <tr>
            <td><i>THRESHR_KEY</i></td>
            <td><i>no default value</i></td>
            <td>bearer token used when querying any redsky api endpoints</td>
        </tr>
        <tr>
            <td><i>THRESHR_CHANNEL</i></td>
            <td><code>WEB</code></td>
            <td><i>This variable is to be deprecated, see <a href="https://github.com/Graqr/Threshr/issues/136">issue 136</a>.</i></td>
        </tr>
        <tr>
            <td><i>LOGGER_LEVELS_</i><code>package_name</code></td>
            <td>Default values provided in the <a href="https://github.com/Graqr/Threshr/blob/edb0553ffb8a3d5205b6afb56f6a6822961767b7/src/main/resources/logback.xml">log config</a></td>
            <td>See <a href="#log-levels">log-levels</a>. </td>
        </tr>
        </tbody>
    </table>
</div>

### Run Tests

From the root directory, populate the environment variables and use the maven wrapper to execute the tests.

<h4> If using scripts from <a href="#windows-tips">tips for windows users</a> section</h4>

```PowerShell
source .env
Start-DevTerminal
./mvnw clean test
```

<h4> else</h4>

```shell
. .env #or however you've set env variables
./mvnw clean test
```


#### Log-Levels
By default, Threshr's log level is set to Info. You can define log levels for packages by defining the variable package name as a variable, swapping `.` for `_` and prepending with `LOGGER_LEVELS`. As an example, to enable debug logging for the micronaut httpclient you'd create this variable and assignment:
```properties
LOGGER_LEVELS_IO_MICRONAUT_HTTP_CLIENT=DEBUG
```