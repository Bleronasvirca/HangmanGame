import java.util.Random;
public class HiddenWords {
   private String [] listOfTheWords;
   private String hiddenWord = "";//_ o _ o _ a
   private String generateWord = ""; //kosova
   private Random random;
   private String theWrongLettersThatYouHaveTried = "";
   private int theNumberOfHiddenWords = 10;
   public HiddenWords() {
      random = new Random();
      initializeTheListOfTheWords();
      pickAWord();
      hideTheWord();
   }
   public void pickAWord() {
      int randomIndex = random.nextInt(theNumberOfHiddenWords); // we generate a random number
   // from the string/range we get a word with indexrandom
      generateWord = listOfTheWords[randomIndex];
   
      hiddenWord = "";
   
   }
   public boolean aContainsTheLetter(char letter) {
      boolean find = false;
      String temp = hiddenWord;//k o _ o _ _
      for (int fromIndex = 0; fromIndex < generateWord.length(); fromIndex++) {
         int indexLetterIsFound = generateWord.indexOf(letter, fromIndex);
         if (indexLetterIsFound != -1) {
            find = true;
            int hiddenWordIndex = 2 * indexLetterIsFound;
            temp = replace(temp,hiddenWordIndex,letter);
            fromIndex = indexLetterIsFound; //kerkimi i ardhshem prej ku eshte gjete
         } else {
            break;
         }
      }
      hiddenWord = temp;
      if (!find) {
         submitAWrongLetter(letter);
      }
      return find;
   }
   public void hideTheWord() {
      for (int i = 0; i < generateWord.length(); i++) {
         hiddenWord += "_ ";
      }
   }
   public void initializeTheListOfTheWords() {
      listOfTheWords = new String[theNumberOfHiddenWords];
      int i = 0;
      listOfTheWords[i] = "synchronized"; i++;
      listOfTheWords[i] = "implements"; i++;
      listOfTheWords[i] = "volatile"; i++;
      listOfTheWords[i] = "throws"; i++;
      listOfTheWords[i] = "finally"; i++;
      listOfTheWords[i] = "import"; i++;
      listOfTheWords[i] = "extends"; i++;
      listOfTheWords[i] = "private"; i++;
      listOfTheWords[i] = "abstract"; i++;
      listOfTheWords[i] = "try"; 
      
      
   }
   public String returnTheHiddenWord() {
      return hiddenWord;
   }
   public boolean theSolutionWasDescovered() {
      return !thereIsStillToBeDiscovered();
   }
   public boolean thereIsStillToBeDiscovered () {
      return hiddenWord.contains("_");
   }
   public void submitAWrongLetter(char c) {
      if (theWrongLettersThatYouHaveTried.indexOf("" + c) == -1) {
         theWrongLettersThatYouHaveTried += c+",";
      }
   }
   public String returnTheWrongLettersThatYouHaveTried() {
      return theWrongLettersThatYouHaveTried;
   }
   public void deleteTheWrongLettersThatYouHaveTried() {
      theWrongLettersThatYouHaveTried = "";
   }
   public String returnTheSolution() {
      String sb = "";
      for (int i = 0; i < generateWord.length(); i++) {
         if (i != 0) {
            sb += " ";
         }
         sb+=generateWord.charAt(i);
      }
      return sb;
   }
   public String replace(String str, int index, char replace){
      if(str==null){
         return str;
      }else if(index<0 || index>=str.length()){
         return str;
      }
   
      char[] chars = str.toCharArray();
      chars[index] = replace;
      return String.valueOf(chars);
   }
}