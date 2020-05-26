# Maven Template for Appian Plug-in
This repository contains a Maven based template for building Appian plug-ins

## How to use this template
1. Request a new GitHub repository for your plug-in
1. Download a copy (not clone) of this repository
1. Update the following
    1. pom.xml
        1. Update sections marked with `COMPLETE_ME`
    1. README.md
        1. Update title and description at top of this file
        1. Remove this section (`How to use this template`)

# Updating Project
## Setup Maven
Download and configure [Apache Maven](https://maven.apache.org)

## Setup Eclipse
1. Open Eclipse
1. File > Import > Maven > Existing Maven Projects
1. Under `Root Directory` choose the location you copied this repo to
1. Click Finish

## Adding Dependencies
Runtime and compile time dependencies are managed in `pom.xml`. Each dependency is added to the `<dependencies>` section. An optional `<scope>` specifies when Maven makes the dependency available in the classpath (for example `test` scope means it's only available to test sources, not main plug-in sources, `provided` means Appian or application server provide it in other words it is listed [here](https://docs.appian.com/suite/help/latest/Custom_Plug-in_Packages.html))

If the dependency is required at runtime add it to `jar.xml` in `/src/assembly` otherwise you will experience a `ClassNotFoundException` when running the plug-in within Appian. The `<groupId>` and `<artifactId>` you just added to `pom.xml` needs adding into the `<includes>` section (commented out by default).

# Building
## Development Build
To create a plug-in jar for testing, run the following Maven command:
* `mvn clean package`
* The jar can be found in `/target`

## Release Build
To create a new public release, run the following Maven commands:
* `mvn release:clean`
* `mvn release:prepare -DautoVersionSubmodules=true -DpushChanges=false`
* `git push origin master --tags`
* The release jar can be found in `/target`