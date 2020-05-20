Small app used for implementing OOP's basic concepts and very basic thread functionalities.\

* The app's flow:
1. after the app is started, the user has 3 commands that he can use: `team 'teamName'` (for adding a team), `current_situation` (for the current situation of the existing teams) or `stop_teams` to stop addming teams. The minimum number of teams required is 4.\
2. when `stop_teams` is executed successfully another 3 commands can be used: `game 'team1Name' 'team2Name' 'team1Goals' 'team2Goals'` (which is used to add a new game's results; the winning team gets 3 points, the losing one gets 0; if it's a tie, both of the teams get 1 point each), `restart` (to restart everything added at this point), `current_situation` (for showing the current stats of all the teams), `finish_championship` (to end the championship; the winnig team will be showed + all the teams with their stats). If two teams have the same number of points, then those 2 are ranked based on the number of goals they had scored.

* Exceptions:\
Exceptions are used for implementing guidelines for various aspects, like the team name which cannot be empty or contain only numbers, a team cannot play against itself, etc.
