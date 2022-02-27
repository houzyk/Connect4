public class ComputerPlayer extends Player {

  public ComputerPlayer() {
    super("Computer");
  }

  @Override
  public String move () {
    int move = (int) Math.floor((Math.random()*6) + 1);
    return String.valueOf(move);
  }
}
