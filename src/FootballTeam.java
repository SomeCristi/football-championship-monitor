public class FootballTeam implements Comparable<FootballTeam>{
  private String teamName;
  private int gamesPlayed, homeGamesNo, awayGamesNo, goalsScored, goalesTaken, points;

  public FootballTeam() {}

  public FootballTeam(String teamName) throws InvalidTeamNameException {
    if ((teamName.length() == 0) || (teamName.trim().matches("[0-9]+"))){
      throw new InvalidTeamNameException();
    } else {
      this.teamName = teamName;
    }
  }

  // sort FootballTeam objects by points
  // if the two teams have the same points, then order by goals
  @Override
  public int compareTo(FootballTeam team) {
    if (this.points == team.points) {
      return this.goalsScored - team.goalsScored;
    } else {
      return this.points - team.points;
    }
  }

  public String toString(){
    return getTeamName() + "\t" + getGamesPlayed() + 
    "\t" + getHomeGamesNo() + "\t" + getAwayGamesNo() + 
    "\t" + getGoalsScored() + "\t" + getGoalsTaken() + "\t" + getPoints();
  }

  public void resetStats(){
    gamesPlayed = 0;
    homeGamesNo = 0;
    awayGamesNo = 0;
    goalsScored = 0;
    goalesTaken = 0;
    points = 0;
  }

  public String getTeamName(){
    return this.teamName;
  }

  public int getGamesPlayed(){
    return this.gamesPlayed;
  }

  public int getHomeGamesNo(){
    return this.homeGamesNo;
  }

  public int getAwayGamesNo(){
    return this.awayGamesNo;
  }

  public int getGoalsScored(){
    return this.goalsScored;
  }

  public int getGoalsTaken(){
    return this.goalesTaken;
  }

  public int getPoints(){
    return this.points;
  }

  public void addGame(int goalsScored, int goalsTaken, int homeGame, int awayGame){
    this.gamesPlayed += 1;
    this.homeGamesNo += homeGame;
    this.awayGamesNo += awayGame;
    this.goalsScored = goalsScored;
    this.goalesTaken = goalsTaken;

    if (goalsScored > goalsTaken){
      this.points += 3;
    } else if (goalsScored == goalesTaken){
      this.points += 1;
    }

  }
  
}