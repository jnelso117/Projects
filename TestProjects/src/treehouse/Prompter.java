package treehouse;
import java.io.Console;
public class Prompter {

	  private Game mGame;
	  
	  public Prompter(Game game) {
	    mGame = game;
	    
	  }
	  
	  public void play() {
		  while(mGame.getRemainingTries() > 0 && !mGame.isSolved()) {
			  displayProgress();
			  promptForGuess();
		  }
		  if (mGame.isSolved()) {
			  System.out.printf("Congrats! You won with %d tries remaining", mGame.getRemainingTries());
		  }
		  else {
			  System.out.printf("Aw shucks, it was %s.  :(\n", mGame.getAnswer());
		  }
	  }
	  
	 public boolean promptForGuess() {
	  Console console = System.console(); 
	  boolean isHit = false;
	  boolean isValidGuess = false;
	  while(! isValidGuess){
	  String guessAsString = console.readLine("Enter a letter: ");
	  char guess = guessAsString.charAt(0);
	  
	  try {
		  isHit = mGame.applyGuess(guessAsString);
		  isValidGuess = true;
	  } catch (IllegalArgumentException iae) {
		  console.printf("%s. Please Try Again. \n", iae.getMessage());
	  }
	  }
	  return isHit;
	 }
	  public void displayProgress() {
	    System.out.printf("You have %d tries left to solve:  %s\n", mGame.getRemainingTries(), mGame.getCurrentProgress());
	  }
	  public static void main(String[] args) 
	  {
	    Game game = new Game("Treehouse");
	  }
	  
	}