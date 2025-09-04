# Clean Architecture in Java
This repository compiles clean architecture best practices applied to the Java ecosystem. 
This does not mean it is the single "correct" way to organize applications; on the contrary, it is open to contributions and feedback that can make it better. 

While my primary expertise lies in the .NET stack, I believe it's core principles of clean architecture are highly transferable to Java.

### Package Organization
*   **eventreminder** (Root Package)
    *   **[domain](src/main/java/com/kipuig/eventreminder/domain#readme)**
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

## Sample Application
The sample application is called **Event Reminder**. The main goal is to register events that can later trigger notifications. 
It's functionality is very similar to a calendar but designed for sharing globally relevant events.

For example, the draw for the World Cup will take place on December 5, 2025, at 12:00 pm local time in Washington. 
Would anyone be interested in watching that event live? 
If so, a user can create the event and share it with other users, or users could search among existing events. 
Each user will see the event in their own local time and can subscribe.

*   [Prerequisites](prerequisites.md)
*   [Clean Code Principles](claeancode.md)
