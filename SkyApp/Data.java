import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Data {
   private String folderName;
   private String fileName;

   public Data(String folderName, String fileName) {
      this.folderName = folderName;
      this.fileName = fileName;
   }

   public String getData() {
      String filePath = "H:\\Code\\Code\\xSubjects\\T2\\OOP\\Java\\A\\Sky\\" + folderName + "\\" + fileName + ".txt";

      StringBuilder sb = new StringBuilder();

      try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
         String line;
         while ((line = reader.readLine()) != null) {
            sb.append(line);
         }
         reader.close();
      } catch (IOException e) {
         e.printStackTrace();
      }

      String fullString = sb.toString();
      int startIndex = fullString.indexOf("[{", 1);
      int endIndex = fullString.indexOf("}]", startIndex) + 2;

      return fullString.trim().substring(startIndex, endIndex);
   }

   public OperatorLinkedList getListOperator(int keyType) {
      OperatorLinkedList list = new OperatorLinkedList();

      String input = new Data(folderName, fileName).getData();
      input = input.substring(2, input.length() - 2); // Remove outside brackets
      String[] keyPresses = input.split("\\},\\{"); // Splitby " },{ "

      for (String keyPress : keyPresses) {
         String[] keyValuePairs = keyPress.split(",");
         int time = Integer.parseInt(keyValuePairs[0].split(":")[1]); // Extract the time value
         int key = Integer.parseInt(keyValuePairs[1].split(":")[1].replace("\"", "").substring(4));
         list.addOrUpdate(time, convertKey(key, keyType));
      }

      return list;
   }

   public static int convertKey(int key, int type) {
      int[] keys = null;

      switch (type) {
         // SKY PC
         case 0:
            int[] keys0 = {
                  KeyEvent.VK_Y, KeyEvent.VK_U, KeyEvent.VK_I,
                  KeyEvent.VK_O, KeyEvent.VK_P, KeyEvent.VK_H,
                  KeyEvent.VK_J, KeyEvent.VK_K, KeyEvent.VK_L,
                  KeyEvent.VK_SEMICOLON, KeyEvent.VK_N, KeyEvent.VK_M,
                  KeyEvent.VK_COMMA, KeyEvent.VK_PERIOD, KeyEvent.VK_SLASH };

            keys = keys0;
            break;
         // SKY WEB
         case 1:
            int[] keys1 = {
                  KeyEvent.VK_Q, KeyEvent.VK_W, KeyEvent.VK_E,
                  KeyEvent.VK_R, KeyEvent.VK_T, KeyEvent.VK_A,
                  KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_F,
                  KeyEvent.VK_G, KeyEvent.VK_Z, KeyEvent.VK_X,
                  KeyEvent.VK_C, KeyEvent.VK_V, KeyEvent.VK_B };

            keys = keys1;
            break;
         // PIANO WEB
         case 2:
            int[] keys2 = {
                  KeyEvent.VK_T, KeyEvent.VK_Y, KeyEvent.VK_U,
                  KeyEvent.VK_I, KeyEvent.VK_O, KeyEvent.VK_P,
                  KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D,
                  KeyEvent.VK_F, KeyEvent.VK_G, KeyEvent.VK_H,
                  KeyEvent.VK_J, KeyEvent.VK_K, KeyEvent.VK_L };

            keys = keys2;
            break;
      }

      switch (key) {
         case 0:
            return keys[0];
         case 1:
            return keys[1];
         case 2:
            return keys[2];
         case 3:
            return keys[3];
         case 4:
            return keys[4];
         case 5:
            return keys[5];
         case 6:
            return keys[6];
         case 7:
            return keys[7];
         case 8:
            return keys[8];
         case 9:
            return keys[9];
         case 10:
            return keys[10];
         case 11:
            return keys[11];
         case 12:
            return keys[12];
         case 13:
            return keys[13];
         case 14:
            return keys[14];
         case 15:
         //    return KeyEvent.VK_SPACE;
         // case 16:
         //    return KeyEvent.VK_SPACE;
         // case 17:
         //    return KeyEvent.VK_SPACE;
         // case 18:
         //    return KeyEvent.VK_SPACE;
         // case 19:
         //    return KeyEvent.VK_SPACE;
         case 24:
            return KeyEvent.VK_ENTER;
         case 25:
            return KeyEvent.VK_TAB;
         default:
            return KeyEvent.VK_ESCAPE;
      }
   }
}
