# This library is DEFUNCT
Use [Discord4J v3](https://discord4j.com) instead!

This library was created for Discord4J v2 which is no longer supported or maintained.

# Module-Loader-Plus [![Download](https://jitpack.io/v/Discord4J-Addons/Module-Loader-Plus.svg?style=flat-square)](https://jitpack.io/#Discord4J-Addons/Module-Loader-Plus)
This loads modules already class-loaded in the Discord4J classpath.

## Adding ModuleLoader+ as a dependency
NOTE: This requires Discord4J to be added as a project dependency. [See here for instructions on how to do that](https://github.com/austinv11/Discord4J#adding-discord4j-as-a-dependency-for-a-project).

### With Maven:
```xml
  <dependency>
    <groupId>com.github.Discord4J-Addons</groupId>
    <artifactId>Module-Loader-Plus</artifactId>
    <version>VERSION_HERE</version>
  </dependency>
```

### With Gradle:
```groovy
dependencies {
  compile 'com.github.Discord4J-Addons:Module-Loader-Plus:VERSION_HERE'
}
```

## Why should I use ModuleLoader+?
Modularization is a great tool for software development. But by default, Discord4J only automatically loads modules which are compiled
into their own .jars and placed in a "modules" directory, great for making a bot completely modular for the end user. However, 
modules can also be utilized internally, allowing developers to organize different parts of their bot and easily enable/disable them. So
ModuleLoader+ was created to allow for modules in the classpath of the bot (i.e. within the main bot's .jar or loaded as a dependency) to
be automatically loaded as Discord4J modules.

## Why wasn't this feature included in Discord4J itself?
This was not included in Discord4J itself because it adds an additional dependency and a lot of overhead. The process of locating modules
this way is (relatively and unnescessarily) time-consuming. While for many cases this shouldn't matter, I felt this feature would better work as an optional thing.
