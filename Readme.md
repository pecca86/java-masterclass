# NOTES

## Naming conventions
### Packages:
        - always lower case
        - unique name
        - instant domain name reversed (com.pekka.app)
        - no dashes, instead underscore
### Class names:
        - CamelCase
### Method/Variable name:
        - mixedCase
### Constants:
        - final ALL_UPPER
### Type params (generics)
        - E -element, K - key, T - type, V - value, S,U,V - 2nd, 3rd 4th types

## Packages
    - We put related code into same package
    - Packages creates a new namespace, so we can have classes with the same names
    - Classes within packages can have unrestricted access to other classes within the same package
    - If you package your code into a JAR file (non-executable), you can import that as a library into another project and reuse the code

## Scope
### Inner Class scope
    - A inner class can access its parents class' attributes (member variables) and vice versa
### Visibility / access modifiers of a class / method / var:
        - public = visible outside the class / package
        - private = only visible within the class where it is declared
        - protected = visible within own package and subclasses (even if they are in another package)
        - package private = top level class cannot be private, inner classes can. If you remove the public keyword, the class will become package private
### static keyword:
        - a static variable makes all instances of the class share the same variable in memory
        - a static method is a Class method, which can be accessed by calling the class without having to create an instance of it
### final keyword:
        - Can be modified once (when created)
        - public final class, no subclass can be (extended) initialized using this class (Math class as an example)
        - Disabling method Override can be a good security measure (example in Password class):
            - Can be done by declaring a method with the final keyword
### Static initializers:
        - static { //code }
        - Declared in the order written in class

## Collections
    - LinkedHashSet = Keeps elements in order
    - Some Collection search methods requires the class to implement the compareTo method
    - Objects that are used as Keys in a Map, needs to implement equals() and hashcode() to make them unique
        - If two object compare equal, they MUST HAVE the same hashcode
        - If you don't want subclasses to be able to override parent class' equals, mark it as final. It's better to always say subclass is unequal.

## Immutable classes
    - Once object is create, there are no mechanisms for altering it
    - Object needs to have all needed data set in constructor and have final attributes with no setters
    - Effectively a Java Record

## Exceptions
    - Handled and unhandled exceptions
        - Unhandled when the possible exception is set in the method signature

## I/O
    - FileWriter, Scanner, BufferedReader / Writer
    - BufferedWriter is better when writing alot of data to disk, since it writes it in chunks
    - DataStream object reads streams of data (duh!), when reading from a file, need to check for EOF
### Serialization:
        - You can serialize and deserialize an object that is implementing the Serializable interface
        - This allows us to later retrieve and recreate that object from the data saved in the file
        - It is always best practice to give the object your own ID for serialization. Otherwise, different compilers might deserialize the object wrongly.
        - If the serializable class has fields containing other classes, those too need to be serializable! (Unless they are primitives)
        - Once the object has been serialized with an UID, it can only be deserialized with the same one, this will throw a InvalidClassException.
        - Object instances will be unique to a file, but not across files (Two exact copies of String can't exist in same file but can exist in two different ones).
### Random Access File:
        - Reads binary data from a given offset
        - File pointer is at 0 when a file is created or opened
### Java NIO:
        - Creates non-blocking threads -> improves performance in some cases.
        - Handles data in blocks, one block processed at a time using channels / buffers / selectors.
        - Recommended to use the Path class when handling files.
        - Everything that needs to be written is in memory, so can be slow.
        - Good if you need to have many working threads.
        - Absolute and relative reads:
            - Absolute reads do not change buffer position after read
        - WHEN SOMETHING GOES WRONG - FLIP() !
        - Path => File or Dir, Absolute or Relative
            - Path interface was created to address the following shortcomings in Java.io:
                = Java.io has poor exception signatures
                = File.rename() works differently on different OS's
                = No support for symbolic links
                = No support for file metadata
                = Poor performance when working with lots of data
                = Walking through dir tree problematic, since no support for symbolic links
        - Walking a file tree:
            - When creating new files and folders, use preVisitDirectory
            - When deleting files and folders, use postVisitDirectory
        - JAVA NIO vs. JAVA IO:
            - Java NIO better when accessing the File System
            - Java IO can be better when Reading / Writing files

## Concurrency
### Terminology:
#### Process       = Unit of execution in own memory protected space (heap)
#### Thread        = Unit of execution within a process, every thread created by a process shares its memory and files
#### Thread stack  = Memory that only a that thread can access
#### Atomic action = Thread won't be suspended before completing THE WHOLE action
### Threads in Java
     - JVM / Scheduler decides when each process / thread gets CPU time
#### Runnable vs. Thread interface / implementation:
        - Runnable more often used and implemented in the Java API
        - Runnable more flexible
#### Thread joins:
        - Joined threads will wait for each thread to execute its tasks before continuing
#### Thread synchronization:
        - set method to be synced with synchronized keyword
        - Critical section = when a shared resource can potentially be accessed by more than one thread
        - Thread safe = the developer has done the sync work for us, so we don't have to implement it
        - We should only sync the sections that need to be synced
        - A developer should be aware of the fact that a thread can be stopped after every operation
        - Atomic operations cannot be suspended before the work is ready:
            = MyOjb = MyOjb2
            = Reading primitive values (except long and double)
            = Reading & writing volatile variables
#### Synchronized method drawbacks:
        - Must start and end in same method block (cannot access it from other methods)
        - A blocked thread will stand idle until the resource is unlocked and can't do other work
        - We cannot timeout the thread until we get the lock
        - Not a set order which thread gets the shared resource, when the lock is released
#### Starvation:
        - To mitigate starvation situations (where one thread does not get any CPU time), we can use fair locks etc.
        - Fair locks can be slower, since there is more overhead in seeing to that every thread gets CPU time.
        - Choosing to mitigate starvation, should be considered against the cost of its performance
#### Live lock:
        - Threads continue looping while waiting for another lock to be freed, while this is waiting for the looping's lock to be freed
### Atomic operations in Java:
        - myObj = myObj2
        - myInt = 10
        - long & double are NOT atomic
        - an operation of eg., increasing a counter like counter++ involves the following steps:
            1. Read the value of counter
            2. Add 1 to the counter
            3. Write value back to memory
 ### Thread issues:
        - Value in memory vs. CPU cache can be out of sync
        - using 'volatile' keyword in front of a variable ensures that the value will also be written into memory

## Lambdas
    - Anonymous function / method
    - consists of three parts:
        1. Error token
        2. Body (code that we want to run)
        3.
    - Lambdas as so: new Thread(()-> System.out.println("Hey")).start(); can only be run with interfaces that only have one method.
    These interfaces are also called functional interfaces.

## Functions
    - A functional Interface, is an interface only implementing one method, thus making it suitable for lambdas
    - A CONSUMER<T> is a functional interface
        - consumer does not return any value
    - Many consumer and predicate interface are generic
    - There are also double consumers, int, double consumers etc.
### SUPPLIER
        - Does return a value
### PREDICATE return true / false
### FUNCTION interface takes one value and returns another
        - We create functions in order to pass methods that accepts and returns a value to a method in of form of a lambda
        w/o having to create an interface & a class that implements the interface.
    - Functions can be used instead of methods, for smaller parts of code that vary
    - Also useful when using callback (data fetching -> data ready -> specifics of what to do with the data varies)
    - Example:
        Function<Image, Image> resizeAlg1 = (Image i) -> { // Resize algo 1 };
        Function<Image, Image> resizeAlg2 = (Image i) -> { // Resize algo 2 };

        public List<Image> runWhenDone(Function<Image, Image> resize) {
            for (Image i : images) {
                resizedImages.add(resize.apply(image));
            }
        }
    - Here we can define which image resize algorithm we want the function to use
    - Functions can be chained
    - Basically Functions are the building blocks of Lambdas
    - Basic Function built into Java:
        ```
                          Method       Args        Returns value               Chainable
        1. Consumer     - accept(),    1-2 args,   Does not return a value,    can be chained)
        2. Supplier     - get(),       0 args,     Does return a value,        can't be chained)
        3. Predicate    - test(),      1-2 args,   Yes - boolean,              can be chained
        4. Function     - apply(),     1-2 args,   Yes,                        Yes
        5. UnaryOperator- depends,     1,          Yes,                        Yes

        ```
    - Criteria for Interface to be functional:
        - It can only have one SINGLE method that MUST be implemented
        - Other methods must have default implementations
## STREAM API
    - A Java Stream is a sequence of computation
    - Map Method wants a function, NOT a Bi-function
    - Stream end in Terminal operations, between that and the start of the pipeline are Intermediate operations
    - Stream interface cannot be used on mixed types
    - Mapping a single value to mulitple objects can be done using flatmap (flattens nested arrays)
    - Streams are lazelly evaluated, nothing happens if there is no terminal operation

### LAMBDA BEST PRACTICES
    - MAKE IT HUMAN READABLE!
    - KEEP CONSISTENS IN LAMBDA STYLING!

## REGEX

### Matches
- Matches method requires the WHOLE string to match
- ^ matches beginning, $ matches end

### replaceAll
- replaceAll("[ab]", "X") would replace alla 'a' and 'b' with 'X'
- myString.replaceAll("[23][a-z]", "REPLACED")); >> Replaces all 2 or 3 that are preceded by 'a' or 'z' with the string 'REPLACED'
