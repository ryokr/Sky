import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.io.File;

public class Player {
   public static void main(String[] args) {
      bingPoint();
   }

   public static void bingPoint() {
      Robot robot;

      try {
         robot = new Robot();

         isAltTab(robot, 1);

         // for (int i = 0; i < 15; i++) {
         // robot.delay(1000);

         // if (i % 2 == 1) {
         // Data data = new Data("Data", "Bing");
         // OperatorLinkedList list = OperatorLinkedList.time(data.getListOperator(1),xwt
         // 200);
         // Run(list, robot);
         // } else {
         // GenerateData.writeJsonDataToFile("Data\\Bing.txt");
         // }
         // }

         Data data = new Data("Formated", "1_Way_Back_Home");
         OperatorLinkedList list = OperatorLinkedList.time(data.getListOperator(1), 90);
         Run(list, robot);
         isAltTab(robot, 1);

      } catch (AWTException a) {
         System.out.println("Meow :<");
      }
   }

   public static void playAllSong() {
      File[] musicFolder = new File("Formated").listFiles();
      int start = 20;

      for (int i = start; i < musicFolder.length; i++) {
         File song = musicFolder[i];
         Data data = new Data("Formated", song.getName().substring(0, song.getName().length() - 4));
         OperatorLinkedList list = OperatorLinkedList.time(data.getListOperator(1), 110);
         Robot robot;

         try {
            robot = new Robot();
            if (i == start)
               isAltTab(robot, 1);
            Run(list, robot);

         } catch (AWTException a) {
            System.out.println("Meow :<");
         }
      }
   }

   public static void Run(OperatorLinkedList list, Robot robot) {
      int timer = 0;
      Node curr = list.getHead();
      Node prev = null;

      while (curr != null && timer != -1) {
         Integer prevTime;
         Integer currTime = curr.getOperator().getTime();
         Integer nextTime;

         prevTime = (prev == null) ? 0 : prev.getOperator().getTime();
         nextTime = (curr.getNext() == null) ? -1 : curr.getNext().getOperator().getTime();

         if (timer == currTime) {
            robot.delay(currTime - prevTime);
            press(curr.getOperator().getListKey(), robot);
         }

         prev = curr;
         curr = curr.getNext();
         timer = nextTime;
      }
   }

   public static void isAltTab(Robot robot, int option) {
      if (option != 0) {
         robot.delay(1000);
         robot.keyPress(KeyEvent.VK_ALT);
         robot.keyPress(KeyEvent.VK_TAB);
         robot.keyRelease(KeyEvent.VK_ALT);
         robot.keyRelease(KeyEvent.VK_TAB);
         robot.delay(500);
      }
      return;
   }

   public static void executeMG(OperatorLinkedList list, Robot robot, int round) {
      int i = 0;
      isAltTab(robot, 1);

      while (i < round) {
         Run(list, robot);
         robot.delay(2500);
         i++;
      }
   }

   public static void press(ArrayList<Integer> keyList, Robot robot) {
      int delay = 24;
      if (keyList.size() == 1) {
         robot.keyPress(keyList.get(0));
         robot.delay(delay);
         robot.keyRelease(keyList.get(0));
      } else if (keyList.size() == 2) {
         robot.keyPress(keyList.get(0));
         robot.keyPress(keyList.get(1));
         robot.delay(delay);
         robot.keyRelease(keyList.get(0));
         robot.keyRelease(keyList.get(1));
      } else if (keyList.size() == 3) {
         robot.keyPress(keyList.get(0));
         robot.keyPress(keyList.get(1));
         robot.keyPress(keyList.get(2));
         robot.delay(delay);
         robot.keyRelease(keyList.get(0));
         robot.keyRelease(keyList.get(1));
         robot.keyRelease(keyList.get(2));
      } else if (keyList.size() == 4) {
         robot.keyPress(keyList.get(0));
         robot.keyPress(keyList.get(1));
         robot.keyPress(keyList.get(2));
         robot.keyPress(keyList.get(3));
         robot.delay(delay);
         robot.keyRelease(keyList.get(0));
         robot.keyRelease(keyList.get(1));
         robot.keyRelease(keyList.get(2));
         robot.keyRelease(keyList.get(3));
      }
   }
}
