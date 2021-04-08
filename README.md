# Logger

The small library for logging which supports different priorities and strategies.

[![build](https://github.com/NikolayMenzhulin/Logger/actions/workflows/ci-build.yml/badge.svg)](https://github.com/NikolayMenzhulin/Logger/actions/workflows/ci-build.yml) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.nikolaymenzhulin/logger/badge.svg?)](https://maven-badges.herokuapp.com/maven-central/com.github.nikolaymenzhulin/logger) [![License](https://img.shields.io/badge/license-Apache%202.0-dark.svg)](http://www.apache.org/licenses/LICENSE-2.0)
## Usage

Logger works with strategies that must be extends from [LoggerStrategy](https://github.com/NikolayMenzhulin/Logger/blob/main/library/src/main/java/com/github/nikolaymenzhulin/logger/strategies/strategy/base/LoggerStrategy.kt) interface. The library already provides the two realisations: [TimberLoggerStrategy](https://github.com/NikolayMenzhulin/Logger/blob/main/library/src/main/java/com/github/nikolaymenzhulin/logger/strategies/strategy/TimberLoggerStrategy.kt) based on [Timber](https://github.com/JakeWharton/timber) and [TestLoggerStrategy](https://github.com/NikolayMenzhulin/Logger/blob/main/library/src/main/java/com/github/nikolaymenzhulin/logger/strategies/strategy/TestLoggerStrategy.kt) orientired on using in tests. In addition to these, you can implement your own. By default Logger uses TimberLoggerStrategy.  

Use the following example of code to add strategies:
```kotlin
Logger.strategies.add(TimberLoggerStrategy())

// or

val strategies = listOf(TimberLoggerStrategy(), SomeOtherLoggerStrategy())
Logger.strategies.addAll(strategies)
```
`Logger.strategies` is actually a MutableList, so when you working with it you can use all the same methods the regular MutableList has.  

The code for adding strategies is better placed in the application class of your app.  
When you try using Logger without strategies it will be throw IllegalStateException.

After adding strategies use the following example of code to log something what you need:
```kotlin
// Logging uses TimberLoggerStrategy.

Logger.d("Hello world!") // Print "Hello World!" to DEBUG channel of Logcat.

Logger.e(Exception("Error message")) // Print the exception with the message "Error message" and the stacktrace to ERROR channel of Logcat.

Logger.i("Info with args: arg1=%s, arg2=%s", 1, 2) // Print "Info with args: arg1=1, arg2=2" to INFO channel of Logcat.

// etc.
```

## Download

**Step 1.** Add the Maven Central repository to your build file:
```groovy
allprojects {
    repositories {
        mavenCentral()
    }
}
```

**Step 2.** Add the dependency:
```groovy
dependencies {
    implementation 'com.github.nikolaymenzhulin:logger:1.1.1'
}
```

## License

```
Copyright © 2021 Nikolay Menzhulin.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
