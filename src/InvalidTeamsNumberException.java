public class InvalidTeamsNumberException extends Exception{
  public InvalidTeamsNumberException(){
    super("The championship must have at least 4 teams");
  }
  
}