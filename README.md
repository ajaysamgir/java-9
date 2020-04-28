# java-9
This repository contains  practical examples of java programs using java 9 version features

### What is Modularity?
#### Problems before Java 9 with classpaths
- Before java-9 there is no structure in class path, so if you need to find out if any class is missing in class path then we can not able to find it compile-time in a class path.
- there is no separation between JARs at all, they are using flat classpath. So JVM pull all the classes from class path when execution is starts and when programs demand any class and that class is available in multiple versions then JVM don't look the version and just pick the class from class path which is first in a queue.
- there is no encapsulation in classpath.
- Modularity is easy to understand, decrease the maintainability, easy to fix bugs and flexible for change.

#### Module
- A module has a name and it groups related code and is self-contained.
- Module system is completely optional

#### Module Descriptors
- Module descriptor define in module-info.java file. it starts with module keyword and follow by name of the module. 

```
module java.base {
	exports java.utils
	exports java.lang
	exports java.io
	...
}
```
- exports keyword use for define the sub-module which needs to be use in application
- some modules are dependent on another modules do we need to define that dependent modules also.
- required keyword use for define dependency

```
module java.sql {
	exports java.sql
	exports javax.sql
	
	required java.logging
	required java.xml
}
```

- java.sql module dependent on java.logging
- JDK 9 have more than 90 modules itself, we can check via cmd using java --list-modules

#### Migration from java < 8 to java 9
- When migrating classpath based application to Java 9 modular based application you can just keep using a classpath as is. when the classpath is loaded, a module constructed called the unnamed module and all jar files with their containing classes as if they are part of this unnamed module. 
- unnamed module is very special inside the virtual machine, it automatically gets dependencies to the modules in modular JDK. So it doesn't really matter which JDK types your application or your libraries using.
- if your application is use some private libraries e.g sun.security classes then JDK <8 will give you warning message for awareness and security. but JDK 9 will work fine without any warning as well as they manage encapsulation and security with there own.

#### JShell
- JShell is a REPL(Read Eval Print Loop) for java language.
- this words defines the interactive programming environment where you can quickly prototype new java code.
- Read -> Type your code i.e input
- Eval -> execute your code
- Print -> see results i.e output
- Loop -> interactively redefine.
- JShell is use all just plain java so need to use any new language feature and JShell mainly use for just quick execution.
##### Use of JShell
- Quick test : Many time we need to just play with few line of codes for understand what they exactly do, e.g Regex pattern checks, string operations, mathematical operations etc. so instead of creating whole class, main method etc we can use JShell instead
- Exploring APIs : sometime we see lots of new api's and if you want to play arround with them then no need to write whole applications just fire request from REPL.
- Teaching Tool : If somebody wants to learn about java you often have to explain about IDEs, tools, compilers etc. all are create complexity and lengthy process so Now with JShell you just fire of the REPL.

#### JShell overview
- JShell cmd prompt start with cmd jshell and exit with cmd /exit
- ![Alt text](/screenshots/jshell_start_exit.jpg?raw=true "Start and exit from jshell")
- 

#### 