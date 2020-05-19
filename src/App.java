import java.util.*;

public class App {
  public static void main(String[] args) {
    Championship championship = Championship.getInstance();
    Scanner scanner = new Scanner(System.in);
    String command;
    boolean next = false;
		System.out.println("Available commands: team '#teamname' / current_situation / stop_teams");
    while(next == false) {
      command = scanner.nextLine();
			String []instruction = command.split(" ");
    	switch(instruction[0]){
				case "stop_teams":
					try {
						if (championship.getTeams().size() < 4) {
							throw new InvalidTeamsNumberException();
						}	else {
							next = true;
						} 
					} catch(InvalidTeamsNumberException e) {
						System.out.println(e.getMessage());
					}

					break;

				case "current_situation" :
					championship.showRanking();
					break;
				
				case "team":
					try {
						championship.getTeams().add(new FootballTeam (instruction[1]));
						System.out.println("Team added successfully!");
					} catch(InvalidTeamNameException e){
						System.out.println(e.getMessage());
					}
					break;
				
				default: 
					System.out.println("Wrong command.");
					break;
    	}
    }
		
		System.out.println("Available commands: game 'team1' 'team2' 'team1 goals number' 'team2 goals number'" +
			 " / current_situation / finish_championship / restart"
		);
		while(true){
			command = scanner.nextLine();
			String []instruction = command.split(" ");

			switch(instruction[0]){
				case "current_situation":
					championship.showRanking();
					break;
				
				case "restart":
					championship.restart();
					break;
				
					case "finish_championship":
					championship.showRanking();
					
					System.out.println("The winning team is: " + 
						championship.getTeams().get(0).getTeamName()
					);
					return;

					case "game":
						championship.addGame(instruction[1], instruction[2], instruction[3], instruction[4]);
						break;
					default:
						System.out.println("Wrong command, please try again.");
						break;
			}
		}
  }
}
