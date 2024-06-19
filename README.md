<!-- Header -->
<img src="header_logo.svg" alt="Threshr - The Target Grocery Harvester" width="500">


[![GitHub code size in bytes]][download link]
[![license]][license file]
[![GitHub last commit]][commit history]
[![GitHub commit activity]][commit frequency]
<details>
    <summary>
        <a href="https://sonarcloud.io/summary/new_code?id=Graqr_Threshr">
            <img src="https://sonarcloud.io/images/project_badges/sonarcloud-white.svg" \
                style="vertical-align: middle" \
                alt="SonarCloud"/>
        </a>
    </summary><br>

&emsp;[![Quality Gate Status]][Quality Gate Status link]
<ul>

### Security
[![Security Rating]][Security Rating link]
[![Code Smells]][Code Smells Link]
[![Bugs]][Bugs link]
[![Coverage]][Coverage Link]
[![Vulnerabilities]][Vulnerabilities link]

### Usability / Maintainability
[![Reliability Rating]][Reliability Rating link]
[![Duplicated Lines]][Duplicated Lines Link]
[![Lines of Code]][Lines of Code link]
[![Technical Debt]][Technical Debt link]


<br></ul>
</details>

<!--Body-->

## Summary

Threshr is a wrapper library for various grocery store api's. This includes querying specific store pricing and product data.

### Projects using threshr

Other projects using threshr include other graqr projects like the [threshr cli] and [harvester]

## Install

Threshr is available to jvm projects via [maven central].

<details><summary>Maven</summary>

```xml
<dependency>
  <groupId>com.graqr</groupId>
  <artifactId>threshr</artifactId>
  <version>0.0.12</version>
</dependency>
```

</details>

<details><summary>Gradle</summary>

```groovy
implementation group: 'com.graqr', name: 'threshr', version: '0.0.12'
```
</details>

<details><summary>Gradle Kotlin</summary>

```kotlin
implementation("com.graqr:threshr:0.0.12")
```
</details>

> [!NOTE] 
> See the [testing README] for more information about all the needed environment variables, as well as tips and best practices.

### Want to get involved?

See our [contributing] doc before taking a whack at any [open issues]. Also be sure to read the [testing README] for some tips and tricks. We'd love for you to work with us!

<!--top bar-->
[Bugs]:https://sonarcloud.io/api/project_badges/measure?project=Graqr_Threshr&metric=bugs
[BugsLink]:https://sonarcloud.io/summary/new_code?id=Graqr_Threshr
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

<!--Sonar Cloud Stuff-->
[Quality Gate Status]:https://sonarcloud.io/api/project_badges/quality_gate?project=Graqr_Threshr
[Quality Gate Status link]:https://sonarcloud.io/summary/new_code?id=Graqr_Threshr
[Code Smells]:https://sonarcloud.io/api/project_badges/measure?project=Graqr_Threshr&metric=code_smells
[Code Smells Link]:https://sonarcloud.io/summary/new_code?id=Graqr_Threshr
[Coverage]:https://sonarcloud.io/api/project_badges/measure?project=Graqr_Threshr&metric=coverage
[Coverage Link]:https://sonarcloud.io/summary/new_code?id=Graqr_Threshr
[Duplicated Lines]:https://sonarcloud.io/api/project_badges/measure?project=Graqr_Threshr&metric=duplicated_lines_density
[Duplicated Lines Link]:https://sonarcloud.io/summary/new_code?id=Graqr_Threshr
[Reliability Rating]:https://sonarcloud.io/api/project_badges/measure?project=Graqr_Threshr&metric=reliability_rating
[Reliability Rating link]:https://sonarcloud.io/summary/new_code?id=Graqr_Threshr
[Vulnerabilities]:https://sonarcloud.io/api/project_badges/measure?project=Graqr_Threshr&metric=vulnerabilities
[Vulnerabilities link]:https://sonarcloud.io/summary/new_code?id=Graqr_Threshr
[Security Rating]:https://sonarcloud.io/api/project_badges/measure?project=Graqr_Threshr&metric=security_rating
[Security Rating link]:https://sonarcloud.io/summary/new_code?id=Graqr_Threshr
[Bugs]:https://sonarcloud.io/api/project_badges/measure?project=Graqr_Threshr&metric=bugs
[Bugs link]:https://sonarcloud.io/summary/new_code?id=Graqr_Threshr
[Lines of Code]:https://sonarcloud.io/api/project_badges/measure?project=Graqr_Threshr&metric=ncloc
[Lines of Code link]:https://sonarcloud.io/summary/new_code?id=Graqr_Threshr
[Technical Debt]:https://sonarcloud.io/api/project_badges/measure?project=Graqr_Threshr&metric=sqale_index
[Technical Debt link]:https://sonarcloud.io/summary/new_code?id=Graqr_Threshr

<!--All the other links-->
[these instructions]:https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry
[testing README]:src\test\groovy\com\graqr\threshr\README.md
[maven central]:https://central.sonatype.com/artifact/com.graqr/threshr/overview
[threshr cli]:https://github.com/Graqr/threshr-cli
[harvester]:https://github.com/Graqr/Harvester