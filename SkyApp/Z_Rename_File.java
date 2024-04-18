import java.io.File;

public class Z_Rename_File {
   public static void main(String[] args) {
      String folderPath = "H:\\Code\\Code\\xSubjects\\T2\\OOP\\Java\\A\\Sky\\Name";
      File[] files = new File(folderPath).listFiles();

      for (File file : files) {
         if (file.isFile()) {
            String fileName = file.getName();
            String newFileName = fileName.replace(" ", "_");
            File newFile = new File(folderPath + File.separator + newFileName);

            if (file.renameTo(newFile)) {
               System.out.println("File renamed successfully: " + newFileName);
            } else {
               System.out.println("Failed to rename file: " + fileName);
            }
         }
      }
   }
}
