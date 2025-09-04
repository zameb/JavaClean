# Clean Architecture in Java
This repository compiles clean architecture best practices applied to the Java ecosystem. 
This does not mean it is the single "correct" way to organize applications; on the contrary, it is open to contributions and feedback that can make it better. 

While my primary expertise lies in the .NET stack, I believe it's core principles of clean architecture are highly transferable to Java.

## Prerequisites
- **JDK (Java Development Kit)**: Includes the Java compiler (javac), runtime, and development tools.
- **NetBeans, IntelliJ IDEA Community, or another IDE**.

### Install the JDK
There are different Java distributions:
- **Oracle JDK**: Heavier, automatic installation in C:\, commercial restrictions.
- **OpenJDK**: Binaries only, requires installation.
- **Temurin / Zulu**: OpenJDK + ready-to-use binaries, portable ZIP, free updates. Ideal for getting started and personal projects.

The official Java site is Oracle, but for a lighter version that doesn't require a commercial license, it's better to install an OpenJDK like Zulu or Temurin.

To download Temurin, choose the version corresponding to your operating system:
https://adoptium.net/temurin/releases/

If you download an installer, it will handle the system variables and the path. If you use the ZIP version for Windows, you will need to do the following:

1. Extract the files to a path on your disk.
2. Create the `JAVA_HOME` environment variable with the previous path.
3. Add `%JAVA_HOME%\bin` to the system PATH.

### NetBeans
It is a lighter alternative to other IDEs and will be the primary one used in the examples.
The installer or binaries can be obtained from:

https://netbeans.apache.org/front/main/download/

After downloading, follow the installer steps.

### Alternative: IntelliJ
IntelliJ is a highly recommended IDE for Java application development, although it requires more hardware resources and can feel slow on some machines.

Download the installer from:
https://www.jetbrains.com/idea/download/#section=windows

Run it and follow the installation steps.

## Sample Application
The sample application is called **Event Reminder**. The main goal is to register events that can later trigger notifications. 
It's functionality is very similar to a calendar but designed for sharing globally relevant events.

For example, the draw for the World Cup will take place on December 5, 2025, at 12:00 pm local time in Washington. 
Would anyone be interested in watching that event live? 
If so, a user can create the event and share it with other users, or users could search among existing events. 
Each user will see the event in their own local time and can subscribe.

### Package Organization
*   **eventreminder** (Root Package)
    *   **domain**
        *   entities
        *   exceptions
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
    *   **presentation**
        *   bootstrap
        *   controllers
        *   mappers

## Clean Code Principles

While I am happy to adhere to team-specific rules in collaborative environments, the following principles guide this project's codebase:

*   **Small, Focused Methods**
    *   Strive for methods that are concise and do one thing well. A method should be readable without scrolling.
    *   Break long methods into smaller, private helper methods. This is a primary refactoring technique for improving readability.
    *   **Watch for this signal:** A cluster of private methods often hints at a hidden responsibility or concept within your class. 
        When you notice this, it's a strong candidate for extraction into its own class, reinforcing the Single Responsibility Principle (SRP).
*   **Prefer Clear Code over Comments**
    *   Code should be self-documenting. Avoid comments that simply restate what the code is doing (Don't Repeat Yourself - DRY).
    *   Comments are not maintained by the compiler and can easily become outdated, leading to misinformation.
    *   Comments clutters otherwise clean and concise classes. Express intent through clear naming and structure instead.
*   **Use `var` for Improved Readability**
    *   Use `var` for local variables whenever possible, not only when the type is obvious from the right-hand side of the assignment 
        (e.g., `var user = userService.getUser(id);`). This emphasizes the *what* (a user) over the *how* (the specific implementation type) at a high level.
    *   This practice encourages meaningful variable and method names. The context should make the usage without knowing the specific type.
        High-level code benefits from hiding implementation details. The need for specific type information should naturally lead you to the method's implementation.
