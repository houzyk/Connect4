public class Player {
  private String title;
  private boolean status = false;

  public Player (String title) {
    this.title = title;
  }

  public boolean getStatus () { return this.status; }
  public void setStatus (boolean status) { this.status = status; }
  public String getTitle () { return this.title; }

  public String move () {
    return Interface.getUserInput();
  }
}
