import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class FormatData {
   public static void main(String[] args) {
      processingData();
   }

   public static void processingData() {
      String path = "cc";
      String out = "lilcc\\";

      File[] folder = new File(path).listFiles();

      for (File file : folder) {
         writeData(readData(path + "\\" + file.getName()), out + file.getName());

      }
   }

   private static String readData(String path) {
      StringBuilder data = null;
      try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
         String line = reader.readLine();
         reader.close();

         data = new StringBuilder();
         char[] arr = line.toCharArray();

         for (int i = 0; i < arr.length; i++) {
            int v = Integer.valueOf(arr[i]);
            if (v >= 48 && v <= 58 || v >= 97 && v <= 123 || v >= 65 && v <= 91 || v == 34 || v == 44 || v == 93
                  || v == 125)
               data.append(arr[i]);
         }
      } catch (IOException e) {
      }
      return data.toString();
   }

   private static void writeData(String data, String path) {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
         writer.write(data);
         writer.close();
      } catch (IOException e) {
         System.out.println("Meow :<");
      }
   }
}