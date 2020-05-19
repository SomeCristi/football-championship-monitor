import java.util.*;

public class Championship {
  private ArrayList<FootballTeam> teams = new ArrayList<>();
  private static Championship SINGLETON;

  private Championship(){}

  public static Championship getInstance() {
    if (SINGLETON == null) {
      SINGLETON = new Championship();
    }

    return SINGLETON;
  }

  public ArrayList<FootballTeam> getTeams(){
    return this.teams;
  }

  public void showRanking() {
    System.out.println("The championship ranking is: ");
    int i = 1;
    Collections.sort(teams, Collections.reverseOrder());
    for(FootballTeam t : teams) {
      System.out.println("R" + "\t" + "T" + "\t"  + "GP" + "\t" + "HG" + "\t" + "AG" + "\t" + "GS" + "\t" + "GT" + "\t" + "Points");
      System.out.println(i + ". " + "\t" + t.toString());
      i += 1;
    }
  }
  
  public int findTeamIndex(String teamName){
    for(FootballTeam t : teams){
        if(t.getTeamName().equals(teamName)){
            return teams.indexOf(t);
        }
    }
    return -1;
  }

  public void restart(){
    for(FootballTeam t : teams) {
      t.resetStats();
    }
    System.out.println("Championship restarted!");
  }

  public void addGame(String team1Name, String team2Name, String t1Goals, String t2Goals){
    try {
      int team1Goals = Integer.parseInt(t1Goals);
      int team2Goals = Integer.parseInt(t2Goals);
      
      if (!t1Goals.matches("\\d+") || !t2Goals.matches("\\d+") ||
        team1Goals < 0 || team2Goals < 0 || 
        team1Goals > 15 || team2Goals > 15
      ) {
        throw new InvalidGameFormat("Goal number must be an integer between 0 and 15");
      } else {
        int team1Index = findTeamIndex(team1Name);
        int team2Index = findTeamIndex(team2Name);
  
        if (team1Index == -1 || team2Index == -1){
          throw new InvalidGameFormat("One or both of the team names are incorrect");
        } else if (team1Index == team2Index){
          throw new InvalidGameFormat("A team cannot play against itself.");
        } else {
          teams.get(team1Index).addGame(team1Goals, team2Goals, 1, 0);
          teams.get(team2Index).addGame(team2Goals, team1Goals, 0, 1);
          System.out.println("Game added successfully");
        }
      }
    } catch (InvalidGameFormat | NumberFormatException e){
      System.out.println(e.getMessage());
    }
  }

}