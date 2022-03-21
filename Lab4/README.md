LAB 4 

Solved compulsory entirely.

Compulsory (1p)

Create a Maven project.
Create an object-oriented model of the problem. Streets have names and lengths, intersections have names. A street joins two intersections.
Create the streets and the intersections of the problem described in the example. Use streams in order to easily create the intersections.
Create a list of streets, using LinkedList implementation and sort it by the length, using a comparator expressed as a lambda-expression or method reference. Make sure all the objects are comparable.
Create a set of intersections, using a HashSet implementation. Verify the property that a Set does not contain duplicates.


Homework (2p)
Create a class that describes the city.
Using Java Stream API, write a query that display all the streets that are longer than a specified value and join at least 3 streets.
Use a third-party library in order to generate random fake names for intersections and streets.
You may use this package of JGraphT in order to solve the problem (or other library).
Note: A personal implementation of the algorithm will be will be scored extra (+1p).


Bonus (2p)
The city hall wants to regularly inspect the surveillance cameras, sending a maintenance car to go through it all.
Implement an algorithm that determines the route of the maintenance car, in order to minimize the total length. The algorithm must run fast and should not find a solution that is twice as bad than the optimum route.
You may want to read this.
Create a random problem generator, making sure that the lengths between intersections satisfy the triangle inequality.