public class Figure {
   private int partsForDrawing = 0;
   private String[] parts = {" |\n",
   " O\n",
   "/","|","\\\n",
   "/", " \\\n"};
   public void update(boolean correct) {
      drawTheBase();
      if (partsForDrawing < parts.length) {
         if (!correct) {
            partsForDrawing++;
         }
         for (int i = 0; i < partsForDrawing; i++) {
            System.out.print(parts[i]);
         }
      }
      displayNewRows();
   }
   public void drawItAgain() {
      drawTheBase();
      for (int i = 0; i < partsForDrawing; i++) {
         System.out.print(parts[i]);
      }
      displayNewRows();
   }
   public void displayNewRows() {
      int rowsThatWeNeed = parts.length - partsForDrawing;
      for (int i = 0; i < rowsThatWeNeed; i++) {
         System.out.println();
      }
   }
   public boolean theFigureIsCompleted() {
      return partsForDrawing == parts.length;
   }
   public void drawTheBase() {
      System.out.println("==================");
   }
   public void startDrawing(String hiddenWord) {
      delete();
      drawTheBase();
      displayNewRows();
      System.out.println(hiddenWord);
   }
   private void delete() {
      partsForDrawing = 0;
   }
}
