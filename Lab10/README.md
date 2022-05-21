Lab10 - Solved compulsory


Compulsory (1p)

Create the project for the server application.
Implement the class responsible with the creation of a ServerSocket running at a specified port. The server will receive requests (commands) from clients and it will execute them.
Create a class that will be responsible with communicating with a client Socket. The communication will be on a separate thread. If the server receives the command stop it will stop and will return to the client the respons "Server stopped", otherwise it return: "Server received the request ... ".
Create the project for the client application.
A client will read commands from the keyboard and it will send them to the server. The client stops when it reads from the keyboard the string "exit".