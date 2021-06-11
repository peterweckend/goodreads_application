# GoodReads Application

### To run the server: 
Navigate to `/goodreads_application/server` in the terminal and run `./mvnw spring-boot:run`. The server will start listening at http://localhost:8080
### To run the client: 
Navigate to `/goodreads_application/client` in the terminal and run `./mvnw spring-boot:run -Dspring-boot.run.arguments="--search=the food lab,--field=title,--host=localhost,-p=1"` (replacing the example arguments with other values as needed - see Functional Requirements below for more info)
<hr/>

Both the client and the server use Spring and Maven. (JDK 11.0.11, Maven 3.8.1)

Upon receiving the command line arguments on run, the client will send a request to the API endpoint of the server. The server will then send a request to GoodReads, parse the results, and return the appropriate values to the client, who will display the book search result values both on the command line and in the log files.

Both the client and the server log exceptions to the command line and to log files. 
The server's log files are located in `/goodreads_application/server/logs/serverLogs.log`. Similarly, the client's log files are located in `/goodreads_application/client/logs/clientLogs.log`.

For any questions, feel free to contact me at peterweckend@gmail.com

<hr/>

### Functional Requirements and command line argument information

The client app will accept the following command line arguments (comma separated):

`--help` (Output a usage message and exit)

`-s=TERMS,--search=TERMS` (Search the Goodreads' API and display the results on screen.
Results must include author, title, and a link or display of the image of the book)

`--field=FIELD` (Field to search on, where FIELD is one of "author" or "title", or "all", where "all" is the default)

`-p=NUMBER` (if you choose to implement pagination, display the _NUMBER_ page of results, defaults to 1)

`-h=HOSTNAME,--host=HOSTNAME` (the hostname or ip address where the server can be found, should default to 127.0.0.1)

There should be a server app as well. The server app should provide REST endpoints that the client communicates with. 

The server should listen on a non-restricted port and the client should connect to that port.

The client should not directly contact the Goodreads API.

### System Requirements

The application must be written in Java
The application must include a gradle or maven file that builds the project along with its dependencies.

You may use any Java frameworks / libraries that you see fit

The client should parse the command line arguments and treat anything unexpected as an error. Errors that occur during processing should be logged and the user should be presented with a message asking them to retry.

### Non-Requirements

Security measures, including user authentication / authorization

Unit testing

UX, as long as the application is usable.  As this is just an exercise the UX can be command-line only or use a console or
  GUI framework of your choice

Logging, with the exception of errors

### Misc Notes

https://www.goodreads.com/api/index#search.books (Key: RDfV4oPehM6jNhxfNQzzQ).

The Goodreads search API returns XML. Transform the XML into JSON and only send what your app will need

Be sure to document your code, especially cases where you might have made a different choice in a 'real' application

Upon completion, be sure that your code is accessible through a git repo, and provide the link to that repo to Dotdash

### Bonus Points

Include pagination in the interface.
