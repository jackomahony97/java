# java
CA CS3318
Exercise 1: Refactoring
Refactoring is changing the structure of a program without changing it functionality. 
Refactoring must be performed carefully as errors can be introduced, especially when 
refactoring is done by hand.
Incorporate this code into your project, be sure to add this to the git repository. *
List how this code could cause problems, and how these problems would 
manifest themselves in the application at runtime. *
This code could cause problems as it doesn’t currently follow a defensive programming approach. 
Every class and method should be solely responsible for its own correctness and robustness.
This is currently not the case
For example, the code fails to:
1.	validate method parameters
This can cause problems at runtime if the method is passed a parameter that is legal by type but which the method cannot work with
2.	validate return values
This can cause problems at runtime if the method is passed a parameter that is legal by type but which the method cannot work with
3.	use assertions to detect impossible conditions
Even impossible conditions must be accounted for
4.	provide safe mutator method. For optimum safety mutators methods should have a public method which validates and then calls a private method. This allows the implementation of the private mutator to be changed without affecting the client 
5.	provide an accessor method to allow the client to see number of samples
Refactor the code to prevent or identify these problems using a defensive 
programming approach. Be sure to note these changes in your git repository. *

Exercise 2: Exceptions
Modify the custom exception IllegalRainfallDataSourceException to
include exception chaining. *
 Is there any opportunity for a programmatic introspection interface for this exception? If so refactor
IllegalRainfallDataSourceException to include it. *
Yes

Be sure to note these changes in your git repository. *

Exercise 3: Documenting the APIs
Document your APIs using Javadoc comments. What level of Javadoc comments are
necessary? Consider the cases of a developer using the PredictionRainfall API and the
PredictionDataSource API.
Javadoc comments are more like documentation than traditional comments. Any method or class that will be used by anyone aside from the developer requires Javadoc detailed comments in order to avoid confusion and time spent translating code
However in this case the client would be using the application and therefore the application should be heavily documented 

Is there a need to define any other custom exceptions to support the
RainfallDataSource or RainfallPrediction APIs? If so define these exceptions. Be
sure to note these exception classes in your git repository.
No

Exercise 4: Testing
This code did not use a test-driven development approach. Comment on whether you
think this is a weakness and where TDD could have benefited the development process.
I think this a weakness.
Main benefits of TDD are that every method is tested as the program is developed and errors are corrected. There are many parts of the code that could cause problems at runtime as I mentioned above in my answer to defensive programming. Many of the problems associated with this code not following a defensive programming approach could have been resolved during development if TDD had been implemented and had been followed. For example, with regard to mutator methods the code has no validation of the data the client uses. This could cause problems at runtime in the form of errors. Exceptions for improper data entry should be implemented. TDD also creates a detailed spec which is something this 
