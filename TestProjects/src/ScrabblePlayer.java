public class ScrabblePlayer {
  private String mHand;

  public ScrabblePlayer(String s) {
    mHand = s;
  }

  public String getHand() {
   return mHand;
  }

  public void addTile(char tile) {
    // Adds the tile to the hand of the player
    mHand += tile;
  }

  public boolean hasTile(char tile) {
   return mHand.indexOf(tile) > -1;
  }
  public int getTileCount(char a) {
    int count = 0;
    char[] hand = mHand.toCharArray();
    for(char c: mHand.toCharArray()) {
     if(c == a) count++;
    }
    return count;
  }
  public static void main(String[] args) {
	  ScrabblePlayer player = new ScrabblePlayer("Treehouse");
	  System.out.print(player.getTileCount('e'));
  }
}