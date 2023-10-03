# Behavioral Patterns

[TOC]

## Chain of responsibility

More info can be found [here](https://refactoring.guru/design-patterns/chain-of-responsibility)

### Concepts

- Decouple sender and receiver objects
- Receiver contains reference to next receiver
- Promotes loose coupling. We can add links to the chain without rewriting large portions of the logic
- It is ok of there is no handler for a particular request
- Hierarchical in nature
- Example:
    - java.util.logging.Logger#log()
    - javax.servlet.Filter#doFilter()
    - Spring Security Filter Chain

### Design

- Chain of receiver objects
- Handler is Interface based
- ConcreteHandler for each implementation/receiver
- Each handler has a reference to the next

### UML

![chain of responsibility](src/main/resources/chain%20of%20responsibility%20pattern.png)

#### Roles

- **Handler**: Declares the interface, common for all concrete handlers. It usually contains just a single method for
  handling requests, but sometimes it may also have another method for setting the next handler on the chain.
- **Concrete Handlers**: Contain the actual code for processing requests. Upon receiving a request, each handler must
  decide whether to process it and, additionally, whether to pass it along the chain. Handlers are usually
  self-contained and immutable, accepting all necessary data just once via the constructor.
- **Client**: May compose chains just once or compose them dynamically, depending on the application’s logic. Note that
  a request can be sent to any handler in the chain — it doesn't have to be the first one.

### Example

See code under [chain of responsibility package](src/main/java/com/victoria/behavioral/chainresponsability)

### Pitfalls

- Handling/Handler guarantee: we cannot guarantee that a handler will handle the request
- Runtime configuration risk
- Chain length/performance issues

## Command

More info can be found [here](https://refactoring.guru/design-patterns/command)

### Concepts

- Encapsulates each request as an Object
- Object-oriented callback
- Decouple sender from processor
- Often used for "undo" functionality
- Examples:
    - java.lang.Runnable
    - javax.swing.Action

### Design

- Object per command(verb)
- Command interface
- Execute method
- "Undo" method
- Sometimes uses Reflection to achieve more decoupling

### UML

![command](src/main/resources/command%20pattern.png)

#### Roles

- **Invoker or sender**: Responsible for initiating the request. This class must have a reference to the Command
  interface. The
  sender triggers that command instead of sending the request directly to the receiver. Note that the sender isn’t
  responsible for creating the command object. Usually, it gets a pre-created command from the client via the
  constructor.
- **Command**: Usually declares just a single method for executing the command.
- **Concrete Commands**: Implement various kinds of requests. A concrete command isn’t supposed to perform the work on
  its own, but rather to pass the call to one of the business logic objects. However, for the sake of simplifying the
  code, these classes can be merged. Parameters required to execute a method on a receiving object can be declared as
  fields in the concrete command. You can make command objects immutable by only allowing the initialization of these
  fields via the constructor.
- **Receiver**: The class that contains some business logic. Almost any object may act as a receiver. Most commands only
  handle the details of how a request is passed to the receiver, while the receiver itself does the actual work.

### Example

![command example](src/main/resources/command%20example.png)

See code under [command package](src/main/java/com/victoria/behavioral/command)

### Pitfalls

- Dependence on other patterns (generally used with other patterns)
- Multiple commands
- Make use of Memento to handle state
- Prototype pattern for copies (handle history)




