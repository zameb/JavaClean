[Back](https://github.com/zameb/JavaClean#readme)
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
