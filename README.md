The API consists of two endpoints documented with swagger.

The POST to "/games" creates a new game, it has it's own dto with the fields needed to create a game.

The POST to "/games/{id}/events" is used to handle the user interaction with the game that he/she's playing.

Both endpoints return a object of the type GameDto, it is mapped from the Game object (with the GameDtoMapper) that the services return.
This decision was taken so we only show the fields that we want the client to see (eg: don't send mines positions).

Most of the logic is delegated into the business objects, at the moment the service just makes a simple validation.

Since a major part of the logic is inside the entities, most of the test are also about them.