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
- JShell cmd prompt start with cmd JShell and exit with cmd /exit

![Alt text](/screenshots/jshell_start_exit.JPG?raw=true "Start and exit from JShell")

- you can type any valid expression on JShell which is give you results

![Alt text](/screenshots/jshell_basic_examples.JPG?raw=true "JShell expression examples")

- JShell also supports to execute methods and statements, on JShell semicolon after single statements in optional 
- JShell support threading code statements as well as try-catch statements

![Alt text](/screenshots/jshell_statements.JPG?raw=true "JShell statements examples")

#### JShell Declaration
- With JShell it is even possible to declare variable, methods and classes inside of JShell. 
- we can declare variable same as normal java programming, int x = 1, reassign it to x = 2
- /vars /methods commands helps to list out how much variables and methods we already defined.

![Alt text](/screenshots/jshell_declaration.JPG?raw=true "JShell declaration examples")

#### JShell Env tips
- /save sessionName.jsh -> use for save session
- /open sessionName.jsh -> use for open session
- /open normal.java -> open java file
- /types tell the type of class/variable
- 

## Stream API improvements
- There are four methods added into Stream interface
	1. Stream<T> takeWhile(Predicate<? super T> predicate)
	   - this method accept a collection and choose those elements which is match with given predicates as a inputs.
	2. Stream<T> dropWhile(Predicate<? super T> predicate)
	   - in other hand dropWhile method will work opposite to takeWhile method. 
	3. static Stream<T> ofNullable(T t) 
	   - This is static factory method in Stream interface. 
	   - this method is help to create 0 or 1 element streams. 
	   - when you pass a null value then it returns empty stream. if argument value is not null then stream produce exactly one element. 
	   - this function is very useful to those APIs who return null in construction of Stream pipelines.	
	4. static Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next) 
	   - This static method you can use to construct new stream. 
	   - Stream interface have already one iterate method without hasNext parameter.

- Note : takeWhile and dropWhile methods work well with ordered streams so you may find unexpected results with unordered streams so we need to take care that stream should be ordered before use this methods.

#### New Collectors in Stream API
- Java 9 added two new advance collectors 
	1. filtering
	- this is a static method and it returns a collector and take two arguments predicate and downstream collector
	2. flatMapping
	- this collector also accept two parameters and return a collector. 

## Additional methods in optional
	- optional now contains some additional methods like stream(), ifPresentOrElse(), or().
	- It means optional now contains stream features as well.
TODO : add examples

## Small language changes
	- underscore in identifier is legal
	```
		String _ = "underscore"; //valid now
	```
	- improvement in try-with-resources
	 - here you can use already created resources with try()
	- better generic type interface for anonymous class
	```
		List<anything> lis = new ArrayList<>() { 
		  //code 
		}
	```
	- private interface methods
	- 