LAB 5 REQUIREMENTS (Solved compulsory entirely (load function has an error)

Compulsory (1p)

Create an object-oriented model of the problem. You should have at least the following classes: Catalog and Item. The items should have at least a unique identifier, a title and its location. Consider using an interface or an abstract class in order to describe the items in a catalog.
Implement the following methods representing commands that will manage the content of the catalog:
add: adds a new entry into the catalog;
toString: a textual representation of the catalog;
save: saves the catalog to an external file using JSON format; you may use Jackson or other library;
load: loads the catalog from an external file.


Homework (2p)
Represent the commands using classes instead of methods. Use an interface or an abstract class in order to desribe a generic command.
Implement the commands load, list, view, report (create the classes AddCommand, ListCommand, etc.).
list: prints the list of items on the screen;
view: opens an item using the native operating system application (see the Desktop class);
report: creates (and opens) an HTML report representing the content of the catalog.
Use a template engine such as FreeMarker or Velocity, in order to create the HTML report.
(+1p) Use Apache Tika in order to extract metadata from your catalog items and implement the command info in order to display them.
The application will signal invalid date or the commands that are not valid using custom exceptions.
The final form of the application will be an executable JAR archive. Identify the generated archive and launch the application from the console, using the JAR.


Bonus (2p)
Suppose there is an official set of concepts (keywords) C, and that each item has a list of such concepts (example of such a classification system). Evolve your model in order to support this new feature.
Write an algorithm that determines the smallest set of items that covers all the concepts in C. You may want to read this or even this.
Create large instances of the problem and test your algorithm.