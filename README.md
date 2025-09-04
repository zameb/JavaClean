# Clean Architecture in Java
This repository compiles clean architecture best practices applied to the Java ecosystem. 
This does not mean it is the single "correct" way to organize applications; on the contrary, it is open to contributions and feedback that can make it better. 

My primary stack is .NET, so I might miss some specific nuances, but I believe that, in general, years of knowledge in .NET and C# are highly transferable to the Java ecosystem.

## Prerequisites
- **JDK (Java Development Kit)**: Includes the Java compiler (javac), runtime, and development tools.
- **NetBeans, IntelliJ IDEA Community, or another IDE**.

## Install the JDK
There are different Java distributions:
- **Oracle JDK**: Heavier, automatic installation in C:\, commercial restrictions.
- **OpenJDK**: Binaries only, requires a very manual installation.
- **Temurin / Zulu**: OpenJDK + ready-to-use binaries, portable ZIP, free updates. Ideal for getting started and personal projects.

The official Java site is Oracle, but for a lighter version that doesn't require a commercial license, it's better to install an OpenJDK like Zulu or Temurin.

To download Temurin, choose the version corresponding to your operating system:
https://adoptium.net/temurin/releases/

If you download an installer, it will handle the system variables and the path. If you use the ZIP version for Windows, you will need to do the following:

1. Extract the files to a path on your disk.
2. Create the `JAVA_HOME` environment variable with the previous path.
3. Add `%JAVA_HOME%\bin` to the system PATH.

## NetBeans
It is a lighter alternative to other IDEs and will be the primary one used in the examples.
The installer or binaries can be obtained from:

https://netbeans.apache.org/front/main/download/

After downloading, follow the installer steps.

## Alternative: IntelliJ
IntelliJ is a highly recommended IDE for Java application development, although it requires more hardware resources and can feel slow on some machines.

Download the installer from:
https://www.jetbrains.com/idea/download/#section=windows

Run it and follow the installation steps.

## Sample Application
The sample application is called **Event Reminder**. Its objective is to register events that can later trigger notifications. It's functionality is very similar to a calendar but designed for sharing globally relevant events.

For example, the draw for the World Cup will take place on December 5, 2025, at 12:00 pm local time in Washington. Would anyone be interested in watching that event live? If so, a user can create the event and share it with other users, or users could search among existing events. Each user will see the event in their own local time and can subscribe.

The source code is in the following repository:
https://github.com/zameb/JavaClean

## Package Organization
*   **eventreminder** (Root Package)
    *   **presentation**
        *   bootstrap
        *   controllers
        *   mappers
    *   **application**
        *   services
        *   interfaces
        *   dtos
        *   exceptions
        *   mappers
    *   **infrastructure**
        *   **persistence**
            *   interface
            *   implementation
            *   entities
            *   mappers
        *   email
        *   logs
    *   **domain**
        *   entities
        *   exceptions
    *   **test**
        *   integrationtest
        *   architecturaltest

## To create the project in NetBeans:
1. Select **New Project** / **Java with Maven** / **Java Application**.
2. Choose a name and path for the project. Example: `com.mycompany.eventreminder`.

This will create a project organized within a Java package: `com.mycompany.eventreminder`.

Maven acts as a process orchestrator. It is responsible for delegating compilation to javac, downloading dependencies, running tests, packaging, and running the application. Maven's configuration is registered in the `pom.xml` file.

Gradle also exists as an alternative to Maven and is configured with `build.gradle` or `build.gradle.kts` files.
