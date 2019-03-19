# simple-game-service

This is very simple service that returns an id and text for a game that is requested in the 'name' query parameter.
e.g. http://localhost:8080/game?name=Chess should return json containing following fields:
{"id":some number,"text":"some string"}

If there is no query parameter then the game endpoint by default sets game to Sudoku, e.g.  http://localhost:8080/game should return json containing following fields:
{"id":some number,"text":"some string"}

id is a counter that increases by a certain amount every time a request is made to the server.

## Prerequisites:
1. Git
2. Java 8
3. Access to commandline to run commands.
4. Internet connection to download dependencies.
5. An IDE such as Eclipse.

## Steps:
1. Fork the repo in github.com using your github account. If you dont have a github account, please create one and then fork the repo.
2. Once you fork the repo, it should be available on your account now. Click the 'Clone or Download' button to copy the link.
3. Clone the repo on your machine. 
4. Use a build tool such as maven or gradle (binaries are provided in the repo for help but its not necessary to use them) to produce a jar file.
5. Run the jar using java cmd.
6. Access the server using an http client.

## Tasks:
1. Come up with **functional tests** for the application.
2. Write tests/assertions in your favorite programming language. 
3. Open a pull request for code review.
