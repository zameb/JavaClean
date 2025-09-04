[Back](https://github.com/zameb/JavaClean#readme)
# Domain
To build the domain of our application, we rely on pure Java concepts, without using any external libraries.
The domain should not know any of the other layers (infra, application or presentation)

Our domain consists of the following elements:

- **Entities**: `User`, `Event`, `Subscription`, `PlanType`
  - **Business rules**:
    - PlanType.**FREE** → up to 5 events
    - PlanType.**PREMIUM** → up to 100 events
    - PlanType.**PREMIUM** → allows creation of recurring events
- **Domain exceptions**
- **Unit testing (JUnit)**

A domain class must be protected against inconsistencies from the moment it is created.  
Initially, we can use generic exceptions, but domain-specific exceptions can be introduced to make it much easier to detect and trace problems.  

A class can have more than one constructor, but ideally only one should perform the initialization work.  
The others should call it to avoid duplicated code that could later become a source of errors.  

Each domain class must have unit tests that validate its creation and the enforcement of its rules.  
