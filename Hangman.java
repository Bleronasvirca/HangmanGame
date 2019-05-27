//**Hangman game*//
public class Hangman {
   private HiddenWords hiddenWord;
   private Figure figure;
   private EnteryExit enteryExit;
   public Hangman() {
      hiddenWord = new HiddenWords();
      enteryExit = new EnteryExit();
      figure = new Figure();
   }
   public void startTheGame() {
      boolean continuePlaying = true;
      while (continuePlaying) {
         figure.startDrawing(hiddenWord.returnTheHiddenWord());
         do {
            try {
               char sh = enteryExit.readTheLetter();
               boolean correct = hiddenWord.aContainsTheLetter(sh);
               figure.update(correct);
               enteryExit.display(hiddenWord.returnTheHiddenWord()+"\n");
               enteryExit.display("Wrong letters: " + hiddenWord.returnTheWrongLettersThatYouHaveTried()+"\n");
               if (!TheGameIsNotOver()) {
                  boolean theSolutionWasDescovered = hiddenWord.theSolutionWasDescovered();
                  enteryExit.displayWinLoss(theSolutionWasDescovered);
                  if (!theSolutionWasDescovered) {
                     String theRightSolution = hiddenWord.returnTheSolution();
                     enteryExit.display("Solution: " + theRightSolution+"\n");
                  
                  }
                  continuePlaying = enteryExit.playAgain();//n
                  if (continuePlaying) {
                     hiddenWord.pickAWord();
                     hiddenWord.hideTheWord();
                  
                     hiddenWord.deleteTheWrongLettersThatYouHaveTried();
                     figure.startDrawing(hiddenWord.returnTheHiddenWord());
                  
                  }
               }
            } catch (Exception ex) {
               enteryExit.display(ex.toString()+"\n");
               figure.drawItAgain();
               enteryExit.display(hiddenWord.returnTheHiddenWord()+"\n");
               enteryExit.display("Wrong letters: " + hiddenWord.returnTheWrongLettersThatYouHaveTried()+"\n");
            }
         } while (TheGameIsNotOver());
      }
   }
   public boolean TheGameIsNotOver() {
      return hiddenWord.thereIsStillToBeDiscovered() && !figure.theFigureIsCompleted();
   }
   public static void main(String[] args) throws Exception {
      Hangman hangman = new Hangman();
      hangman.startTheGame();
   }
   
}