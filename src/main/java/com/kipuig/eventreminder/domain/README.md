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

## Domain Exceptions

There is an idea that a user error is not something exceptional, and therefore something less disruptive, such as the Result Pattern, should be used.  
However, this is not the right approach: while a user error itself may not be *exceptional*, it becomes exceptional once it reaches the domain.  
This means that the upper layers (the frontend and the interface layer) have failed to filter the error or completely ignored implementing a mechanism to prevent it.

Domain exceptions are semantically appropriate to interrupt the flow as soon as such a problem is detected.

For example, the generic `IllegalStateException` may be adequate when the subscription limit has been reached, but it is even better to define a custom exception such as `SubscriptionLimitsException`.  
This makes failures explicit and allows precise tracking.

The Result Pattern, on the other hand, is suitable when we need to execute an alternative flow depending on the outcome of an operation.  
In this case, the consumer of the result must know what to do, since this pattern delegates the responsibility of deciding how to handle it to the caller.  
If there is no clear alternative flow, there is no point in implementing this pattern.
