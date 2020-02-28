#### Heroku links

https://devigetminesweeper.herokuapp.com/api/v1/games

	{
		"playerName": "seba",
		"size": 5,
		"mines": 6
	}


https://devigetminesweeper.herokuapp.com/api/v1/games/{gameId}/events

	{
		"row" : 0,
		"column" : 3,
		"event" : "LEFT_CLICK"
	}


#### Decisions and notes
The API consists of two endpoints documented with swagger.

The POST to "/games" creates a new game, it has it's own dto with the fields needed to create a game.

The POST to "/games/{id}/events" is used to handle the user interaction with the game that he/she's playing.

Both endpoints return a object of the type **GameDto**, it is mapped from the **Game** object that the services return.
This decision was taken so we only show the fields that we want the client to see (eg: don't send mines positions).

Most of the logic is delegated into the business objects, at the moment the service just makes a simple validation.

Since a major part of the logic is inside the entities, most of the test are also about them.

#### About the Python client

It still needs a lot of love. I'm quite new in python, I didn't know if makings classes for this case is ok (everyone says that in python classes are not encouraged), but I wanted to give the user the chance to maintain the connection configuration (URL) state.
Also I don't have experience making libraries for third parts, and maybe there are a lot of good practices that I'm not aware of.



