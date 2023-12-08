<img src="Threshr-header.svg" alt="Threshr - The Target Grocery Harvester" width="250">

[![build badge]][build link]
[![GitHub code size in bytes]][download link]
[![license]][license file]
[![GitHub last commit]][commit history]
[![GitHub commit activity]][commit frequency]

## Summary

Threshr is a cross-platform cli tool capable of querying product information from varying grocery stores.

### Table of Contents

- [Install Instructions](#install)
- [Contributing](#want-to-get-involved)

### Install

<details><summary>Windows</summary>
    <ol>
        <li>Download latest windows <a href="https://github.com/Graqr/Threshr/releases/latest">binary</a></li>
        <li>Move executable to dedicated directory, ie <code>C:\Program Files\threshr\</code></li>
        <li>Add directory to your PATH</li>

```PowerShell
"C:\Program Files\threshr\" |
if (!($env:Path -like "*$_*"))
{
    $env:Path = "$( $env:Path );$_"
}
```

</ol>
</details>

<details><summary>Linux</summary>
<ol>
        <li>Download latest linux <a href="https://github.com/Graqr/Threshr/releases/latest">binary</a></li>
        <li>Add to <code>$HOME\bin\</code> directory</li>
</details>

### Want to get involved?

See our [contributing] doc before taking a whack at any [open issues]. We'd love for you to work with us!


[build badge]:https://img.shields.io/github/actions/workflow/status/Graqr/Threshr/maven.yml?style=plastic&logo=github&label=Github%20CI%20with%20Maven&link=https%3A%2F%2Fgithub.com%2FGraqr%2FThreshr%2Factions%20build-status%20

[build link]:https://github.com/Graqr/Threshr/actions/workflows/maven.yml

[open issues]:https://github.com/Graqr/Threshr/issues"open-issues"

[contributing]:Contributing.md

[GitHub code size in bytes]:https://img.shields.io/github/languages/code-size/Graqr/Threshr?style=plastic%20project-size%20

[download link]:https://github.com/Graqr/Threshr/archive/refs/heads/main.zip

[license]:https://img.shields.io/github/license/Graqr/Threshr?style=plastic"GPL-3-License"

[license file]:LICENSE

[GitHub last commit]:https://img.shields.io/github/last-commit/Graqr/Threshr/main?style=plastic%20most-recent-commit

[commit history]:https://github.com/Graqr/Threshr/commits/main

[GitHub commit activity]:https://img.shields.io/github/commit-activity/y/Graqr/Threshr?style=plastic"commit-frequency"

[commit frequency]:https://github.com/Graqr/Threshr/graphs/code-frequency
