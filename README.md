## Configuration


### Set Environment

By default the tests run the web browser on the remote [selenium grid](./docs/GRID.md)

In `gradle.properties` uncomment and set `browserEnv` to one of the following `local`, `grid`
```
    browserEnv = $browserEnv
```
 
### Set Browser

By default the tests run the chrome browser

In `gradle.properties` uncomment and set `browserName` to one of the following:

* chrome
* firefox

```
    browserName = $browser
```

### Set Endpoints

#### Base url

By default the web ui tests run against `localhost:8080`

In `gradle.properties` uncomment and set `baseUrl` to one of the following:

```
    baseUrl = $url
```

#### Rest

By default the rest api tests run against `dns:///localhost:6565`

In `gradle.properties` uncomment and set `restEnv` to one of the following:

```
    restEnv = $restEnv
```

#### GRPC

By default the grpc api tests run against `localhost:8082`

In `gradle.properties` uncomment and set `grpcEnv` to one of the following:

```
    grpcEnv = $grpcEnv
```

## Run TDD Tests

These tests leverage a variety of open source technologies, for more info review (./build.gradle)

* Selenium
* Rest Assured
* Java
* TestNG
* Gradle
* WebDriverManager

### IntelliJ

* Navigate to `/src/test/java/com/ecommerce/storefront/tdd/*` or `/src/test/java/com/ecommerce/services/*`
* Select the test you want to run either in the project window OR test class
  * Right click and select
    * `Run'test_name'` OR  
    * `Debug'test_name'`
  * Use the keyboard shortcut
    * `^+Shift+R` to run
    * `^+Shift+D` to debug


### Command Line

In terminal, navigate to project root and type

To run end to end shakedown(regression) tests
This will run all tests tagged with `@Test(groups = {"e2eShakedown"})`

 ```
 ./gradlew clean test -Pe2eShakedown -PbrowserEnv=$browserEnv -PbrowserMode=$browserMode -PbrowserView=$browserView -PbrowserType=$browserType -PbrowserVersion=$version -PbaseUrl=$baseUrl -PgrpcEnv=$grpcEnv -PrestEnv=$restEnv --parallel --max-workers=8

```

To run api shakedown(regression) tests
This will run all tests tagged with `@Test(groups = {"apiShakedown"})`

 ```
 ./gradlew clean test -PapiShakedown -PgrpcEnv=$grpcEnv -PrestEnv=$restEnv --parallel --max-workers=8

```

To run end to end smoke tests
This will run all tests tagged with `@Test(groups = {"e2eSmoke"})`
 ```
 ./gradlew clean test -Pe2eSmoke -PbrowserEnv=$browserEnv -PbrowserMode=$browserMode -PbrowserView=$browserView -PbrowserType=$browserType -PbrowserVersion=$version -PbaseUrl=$baseUrl -PgrpcEnv=$grpcEnv -PrestEnv=$restEnv --parallel --max-workers=8

```

To run api smoke tests
This will run all tests tagged with `@Test(groups = {"apiSmoke"})`
 ```
 ./gradlew clean test -PapiSmoke -PgrpcEnv=$grpcEnv -PrestEnv=$restEnv --parallel --max-workers=8

```

To run a specific set of test(s)

* Add the `groupName` to the test annotation i.e. `@Test(groups = {"groupName"})`
* In the test->useTestNG section of (./build.gradle) add the following conditional
* `if (project.hasProperty('groupName')) { includeGroups 'groupName' }`
* run the command `./gradlew clean test -PgroupName`


## Run BDD Tests

These tests leverage a variety of open source technologies, for more info review (./build.gradle)

* Gherkin
* Cucumber
* Selenium
* Java
* TestNG
* Gradle
* WebDriverManager
* PicoContainers

### IntelliJ

This is a one time setup:

* In IntelliJ, open Run->Edit Configurations
* Click the `edit templates` option (wrench icon)
* Select `cucumber java`
* On the configuration panel on the right add the following
 * VM Options: `-DbrowserEnv=[see browserEnv section] -DbaseUrl=[see baseUrl section]`
 * Apply changes

 
* Navigate to `/src/test/java/com/ecommerce/storefront/bdd/*`
* Select the test you want to run either in the project window OR test class
  * Right click and select
    * `Run'test_name'` OR  
    * `Debug'test_name'`
  * Use the keyboard shortcut
    * `^+Shift+R` to run
    * `^+Shift+D` to debug

### Command Line

In terminal, navigate to project root and type

To run shakedown(regression) tests
This will run all features tagged with `@e2eShakedown`

 ```
  ./gradlew cucumber -Dcucumber.options="--tags @e2eShakedown" -PbrowserEnv=$browserEnv -PbrowserMode=$browserMode -PbrowserView=$browserView -PbrowserType=$browserType -PbrowserVersion=$version -PbaseUrl=$baseUrl -PgrpcEnv=$grpcEnv -PrestEnv=$restEnv --parallel --max-workers=8

```

To run smoke tests
This will run all features tagged with `@e2esmoke`
 ```
  ./gradlew cucumber -Dcucumber.options="--tags @e2esmoke" -PbrowserEnv=$browserEnv -PbrowserMode=$browserMode -PbrowserView=$browserView -PbrowserType=$browserType -PbrowserVersion=$version -PbaseUrl=$baseUrl -PgrpcEnv=$grpcEnv -PrestEnv=$restEnv --parallel --max-workers=8

```

To run a specific set of test(s)

* Add the `groupName` to the feature annotation i.e. `@groupName`
* run the command ` ./gradlew cucumber -Dcucumber.options="--tags @groupName"`
