public class InvalidTeamNameException extends Exception {
  public InvalidTeamNameException() {
    super("This team name is incorrect. It must contain letters");
  }
}