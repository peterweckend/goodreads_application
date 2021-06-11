# goodreads_application



<hr/>
Book Listing Exercise

The purpose of this exercise is to test your familiarity with Java client and server development.  You'll be building a small book listing app using frameworks of your choice and the Goodreads' public API. 

Functional Requirements

The client app will accept the following command line arguments:
--help Output a usage message and exit
-s, --search TERMS Search the Goodreads' API and display the results on screen.
Results must include author, title, and a link or display of the image of the book
--field FIELD where FIELD is one of "author" or "title", or "all" (default)
Field to search on
-p NUMBER if you choose to implement pagination, display the _NUMBER_ page of results
-h, --host HOSTNAME the hostname or ip address where the server can be found, should default to 127.0.0.1
However they chose to implement command line arguments, it should be explained in a help message if I run the app improperly. as long as I can specify all the arguments listed in the functional requirements the format does not matter

There should be a server app as well. The server app should provide REST endpoints that the client communicates with. 

The server should listen on a non-restricted port and the client should connect to that port.

The client should not directly contact the Goodreads API.


System Requirements

The application must be written in Java
The application must include a gradle or maven file that builds the project along with its dependencies.

You may use any Java frameworks / libraries that you see fit

The client should parse the command line arguments and treat anything unexpected as an error. Errors that occur during processing should be logged and the user should be presented with a message asking them to retry.

Non-Requirements

Security measures, including user authentication / authorization

Unit testing

UX, as long as the application is usable.  As this is just an exercise the UX can be command-line only or use a console or
  GUI framework of your choice

Logging, with the exception of errors

Misc Notes

https://www.goodreads.com/api/index#search.books (Key: RDfV4oPehM6jNhxfNQzzQ, Secret: fu8fQ5oGQEDlwiICw45dGSuxiu13STyIrxY0Rb6ibI).

The Goodreads search API returns XML. Transform the XML into JSON and only send what your app will need

Be sure to document your code, especially cases where you might have made a different choice in a 'real' application

Upon completion, be sure that your code is accessible through a git repo, and provide the link to that repo to Dotdash

Bonus Points

Include pagination in the interface.
