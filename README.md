<img src="header_logo.svg" alt="Threshr - The Target Grocery Harvester" width="500">

[![build badge]][build link]
[![GitHub code size in bytes]][download link]
[![license]][license file]
[![GitHub last commit]][commit history]
[![GitHub commit activity]][commit frequency]

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
    <li>Add <code><a href="settings.xml">settings.xml</a></code> to your <code>~/.m2/</code> directory (swapping Batman's name and password for your GitHub user and the token from step 1</li>
    </ol>
</details>
</ul>

#### Include as a Maven Dependency
```xml
<dependency>
  <groupId>com.graqr</groupId>
  <artifactId>threshr</artifactId>
  <version>0.0.8</version>
</dependency>
```
#### Include as a Gradle dependency
```groovy
compile "com.graqr:threshr:0.0.8"
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

See our [contributing] doc before taking a whack at any [open issues]. Also be sure to read the [Testing README](src/test/groovy/com/graqr/threshr/README.md) for some tips and tricks. We'd love for you to work with us!


[these instructions]:https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry

[build badge]:https://img.shields.io/github/actions/workflow/status/Graqr/Threshr/mvn-test_push_all.yml?style=plastic&logo=github&label=Build&link=https%3A%2F%2Fgithub.com%2FGraqr%2FThreshr%2Factions%20build-status%20

[build link]:https://github.com/Graqr/Threshr/actions/workflows/mvn-package_pr,push_main.yml?query=branch%3Amain

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
