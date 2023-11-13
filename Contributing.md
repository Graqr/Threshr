# Contributing

By participating in this project, you agree to abide our
[code of conduct](CODE_OF_CONDUCT.md).

## Set up your machine

[//]: # (TODO: remnove azul, add blurb on windows config for Graal )
`threshr` is written in [Java](https://www.azul.com/modern-cloud-enterprise/) using
Oracle's [GraalVM](https://github.com/oracle/graal) and uses [Maven](https://maven.apache.org/what-is-maven.html) to
handle dependencies.

Prerequisites:

- [Java 17.0.8](https://sdkman.io/jdks#graalvm) in graal's flavor Graal (community edition)
- [Maven 3.8.6](https://maven.apache.org/install.html)

Other things you might need to run the tests:

- [Docker](https://www.docker.com/)

[//]: # (TODO: add docker configuration)

Create your own fork of `threshr`, then clone your fork anywhere:

```shell
git clone git@github.com:Graqr/Threshr.git
```

`cd` into the directory and install the dependencies:

```shell
mvn clean compile
```

## Branch off of main

It's a good practice not to put your changes in the main branch. Branch naming conventions aren't enforced, but I
personally like naming my branches with a `tag`/`task` convention. See [Create a commit](#create-a-commit).

See our [style guide](https://github.com/Graqr#general-styling-guide) for supported coding practices.
## Test your change

Adequate acceptance testing is to be included with pull requests for new code. See
our [style guide](https://github.com/Graqr#testing) for our testing standards.

```sh
mvn clean test
```

## Validate `threshr` builds

```sh
mvn clean install
```


## Create a commit

Commit messages should be well formatted and conform to [Conventional Commits](https://www.conventionalcommits.org).

## Submit a pull request

Push your branch to your `threshr` fork and open a pull request against the original `threshr` main branch.
