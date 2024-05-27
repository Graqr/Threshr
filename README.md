<!-- Header -->
<img src="../header_logo.svg" alt="Threshr - The Target Grocery Harvester" width="500">


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

Threshr is a wrapper library for Target Corporation's redsky api. The redsky api has endpoints for querying product and store information. This includes fulfillment options, pricing, vendors, etc.


## Install

This project's artifacts are hosted on GitHub. Follow [these instructions] in order to include threshr in your maven or
gradle projects.
<ul>
<details><summary>My summary of GitHub's Instructions</summary>
    <ol>
    At the time of writing this, GitHub doesn't support using GitHub-hosted artifacts without first authenticating. You can do this in two steps:
    <li>Generate a personal access token with <code>read:packages</code> <a href="https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token">privileges</a>. </li>
    <li>Add <code><a href="../settings.xml">settings.xml</a></code> to your <code>~/.m2/</code> directory (swapping Batman's name and password for your GitHub user and the token from step 1</li>
    </ol>
</details>
</ul>

#### Include as a Maven Dependency
```xml
<dependency>
  <groupId>com.graqr</groupId>
  <artifactId>threshr</artifactId>
  <version>0.0.12</version>
</dependency>
```
#### Include as a Gradle dependency
```groovy
compile "com.graqr:threshr:0.0.12"
```

#### Environment Variables

You'll need to add api `key` and `CHANNEL` values to environment variables `THRESHR_KEY` and `THRESHR_CHANNEL`. I like using a `.env` file like the one below.
```properties
THRESHR_KEY=BatKey
THRESHR_CHANNEL=WEB
```
> :warning: Environment Variables on windows must be assigned as an environment variable, ie `$env:foo`.
<details><summary id="api-key">How to find a key for the redsky api</summary><ul>

In the network tab in your browser's dev tools, search for any endpoints from the `redsky.target.com` domain. Below I'm in firefox, from whose context menu I'm given the option to copy an api call's parameters.

![redsky_network-tab_firefox.gif](media%2Fredsky_network-tab_firefox.gif)
</ul></details>

## Usage

Threshr doesn't support all redsky endpoints (not yet). There are three endpoints currently supported:

```java
List<ProductSummary> 	fetchProductSummaries(TargetStore targetStore, Tcin tcin);
List<ProductSummary> 	fetchProductSummaries(TargetStore targetStore, String... tcin) throws ThreshrException;
```
```java
Product 	fetchProductDetails(TargetStore targetStore, String tcin);
```
```java
NearbyStores 	queryStoreLocations(Place place); // default values for limit and within
NearbyStores 	queryStoreLocations(int limit, int within, Place place);
```

___

### Want to get involved?

See our [contributing] doc before taking a whack at any [open issues]. Also be sure to read the [Testing README](../src/test/groovy/com/graqr/threshr/README.md) for some tips and tricks. We'd love for you to work with us!

<!--top bar-->
[Bugs]:https://sonarcloud.io/api/project_badges/measure?project=Graqr_Threshr&metric=bugs
[BugsLink]:https://sonarcloud.io/summary/new_code?id=Graqr_Threshr
[open issues]:https://github.com/Graqr/Threshr/issues"open-issues"
[contributing]:../Contributing.md
[GitHub code size in bytes]:https://img.shields.io/github/languages/code-size/Graqr/Threshr?style=plastic%20project-size%20
[download link]:https://github.com/Graqr/Threshr/archive/refs/heads/main.zip
[license]:https://img.shields.io/github/license/Graqr/Threshr?style=plastic"GPL-3-License"
[license file]:../LICENSE
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
