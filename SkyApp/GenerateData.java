import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateData {
   public static void main(String[] args) {
      writeJsonDataToFile("Data\\Bing.txt");
   }
   public static void writeJsonDataToFile(String fileName) {
      Random random = new Random();
      int timeIncrement = 200;
      int currentTime = 0;

      try (FileWriter writer = new FileWriter(fileName)) {
         
         writer.write("[{[");
         // Write 15 times with random values for num
         
         for (int i = 0; i < 20; i++) {
            writeJsonLine(writer, currentTime, random.nextInt(15) + 1, false);
            currentTime += timeIncrement;
         }

         // Write 5 times with num as 25
         for (int i = 0; i < 5; i++) {
            writeJsonLine(writer, currentTime, 25, false);
            currentTime += timeIncrement;
         }

         // Write 1 time with num as 24
         writeJsonLine(writer, currentTime, 24, false);
         currentTime += timeIncrement;

         
         // Write 20 times with random values for num
         for (int i = 0; i < 20; i++) {
            writeJsonLine(writer, currentTime, random.nextInt(15) + 1, false);
            currentTime += timeIncrement;
         }

         // Write 1 time with num as 24
         writeJsonLine(writer, currentTime, 24, true);
         writer.write("]}]");

      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static void writeJsonLine(FileWriter writer, int time, int num, boolean isEnd) throws IOException {
      String jsonLine = "{\"time\":" + time + ",\"key\":\"1Key" + num + "\"}";

      writer.write(jsonLine);
      if (!isEnd) {
         writer.write(",");
      }
   }
}
