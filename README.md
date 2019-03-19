# simple-game-service

This is very simple service that returns an id and text for a game that is requested in the 'name' query parameter.
e.g. http://localhost:8080/game?name=Chess should return json containing following fields:
{"id":some number,"text":"some string"}

If there is no query parameter then the game endpoint by default sets game to Sudoku, e.g.  http://localhost:8080/game should return json containing following fields:
{"id":some number,"text":"some string"}

id is a counter that increases by a certain amount every time a request is made to the server.

Prerequisites:
1. Git
2. Java 8
3. Access to commandline to run commands.
4. Internet connection to download dependencies.
5. An IDE such as Eclipse.

Steps:
1. Fork the repo in github.com using your github account. If you dont have a github account, please create one and then fork the repo.
2. Once you fork the repo, it should be available on your account now. Click the 'Clone or Download' button to copy the link.
3. Clone the repo on your machine. e.g. git clone https://github.com/ `<your-user-name`>/simple-game-service.git
4. Use a build tool such as maven or gradle (binaries are provided in the repo for help but its not necessary to use them) to produce a jar file. e.g. ./mvnw clean install
5. Run the jar using java cmd. e.g. java -jar target/simple-game-service-0.1.0.jar
6. Access the server using an http client. e.g. use rest-assured to get to http://localhost:8080/game 

Tasks:
1. Write the follwong **functional tests** in your favorite programming language (hit the server from the test and then write assertions):
    1. Find out the text that is displayed when the game endpoint is accessed without a query parameter. Write a test to verify that this text is displayed when the game endpoint is accessed without a query parameter.  
    2. Find out the id after hitting game endpoint 7 times. If id increases in a certain pattern, write a test to verify that the game endpoint follows the pattern you have determined.
    3. Find out the text that is displayed when game endpoint is accessed with a name query parameter. Write a test to verify that this text is displayed when the game endpoint is accessed with the name query parameter.
2. Open a pull request for code review. Use the following git commands if required: 
	1. git add .
	2. git commit -m 'adding tests'
	3. git push
	4. Head on over to the repository on GitHub.com where your project lives. e.g. https://github.com/ `<your-user-name`>/simple-game-service
	5. You will see a msg 'This branch is 1 commit ahead of hbahuguna2:master' below 'Clone or download' green button.  
	6. Clicking on 'Pull Request' link next to msg above sends you to a page where you can compare changes. Click 'Create pull request' button and enter a title and optional description.
	7. When you’re ready typing out title and description, click on 'Create pull request'. This should create a Pull Request and we should be able to review it.
