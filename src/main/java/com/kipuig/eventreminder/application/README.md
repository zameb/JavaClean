[Back](https://github.com/zameb/JavaClean#readme)
# Application

The application layer allows us to define the flow of each use case through which the system can be interacted with.  
Use cases can be grouped into service classes.  

This layer should only be aware of the domain and must remain completely agnostic of any kind of infrastructure.

This layer is responsible for the following:

- **Use cases / Services**:
  - **Users**: Register, Update, Delete, Recover password
  - **Events**: Search, Create, Update, Delete, Subscribe
  - **Subscriptions**: List, Delete
  - **Plans**: Change plan
- **Infrastructure interfaces**
- **DTOs with immutable records**
- **Application exceptions**
- **Unit testing (JUnit + Mockito)**  

Interfaces must be declared in the layer that actually uses them—in this case, the application layer.  
The reasons are:

- It ensures that no domain class depends on interfaces that are only used by the application layer.  
- The domain must remain as agnostic as possible, even with respect to persistence or external mechanisms.  
- A single domain can be consumed by different applications, so it would not make sense to burden it with interfaces that are specific to each of them.  

The application layer knows nothing about the infrastructure, but it does define the interfaces it will work with.  
This is the basic idea of the **Dependency Inversion Principle (DIP)**.  

An important restriction in this layer is that it must never receive nor expose domain classes to the presentation layer, although it does use them internally to execute use cases.  
To communicate with the presentation layer, immutable DTOs defined as `record`s are used instead of `class`es.  

To transform our DTOs into domain objects, we can use mapping classes or a library that performs the mapping automatically.  
Personally, I find it clearer to perform mappings through classes that expose static methods.

