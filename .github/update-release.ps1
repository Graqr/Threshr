
# verify tools are available
<#
.SYNOPSIS
adds latest tag to pom and readme in either current or provided directory. replaces the previous tag.
#>

$ErrorActionPreference = 'SilentlyContinue'
if  (!$(git --version)){
    $ErrorActionPreference = 'Continue'
    Write-Error "git is not installed "
}
$ErrorActionPreference = 'Stop'
if ($null -ne $args[0] | Out-Null) {
    Test-Path $args[0] -PathType Container | Out-Null
    $path = $args[0]
}else {
    $path = Get-Location
}
@("$($path)/pom.xml", "$($path)/README.md") | ForEach-Object {Test-Path -Path $_ -PathType Leaf} | Out-Null
Function checkforTagNull(){
    <#
    .SYNOPSIS
    checks if a tag at a given index is null

    .OUTPUTS
    Stops script if null and prints error message.
    Returns tag at given iteration.

    .EXAMPLE
    # When a repo has a plethora of tags and you want to get the latest tag.
    $> checkForTagNull(-1)
    2.8.45

    .EXAMPLE
    # When a repo doesn't have more than one tag and you query the second to last tag.
    $> checkForTagNull(-2)
    tag iteration -2 does not exist
    #>
    [CmdletBinding()]
    param (
        [Parameter(Mandatory=$true)]
        [int]
        $index
    )
    $tag = $(git tag --sort=taggerdate)[$index]
    if($null -eq $tag | Out-Null){
        Write-Error "tag iteration $($index) does not exist"
    }
    return $tag
}

$tags = @(-2, -1) | ForEach-Object {checkforTagNull $_} | ForEach-Object {$_.Replace("v","")}

@("$($path)/pom.xml", "$($path)/README.md") | ForEach-Object {
    $(Get-Content $_).Replace($tags[0], $tags[1]).Replace("-SNAPSHOT", "") | Set-Content $_
}
