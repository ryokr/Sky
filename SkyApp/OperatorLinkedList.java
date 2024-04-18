import java.util.ArrayList;
import java.util.List;

public class OperatorLinkedList {
   // public static void main(String[] args) {
   //    Data data = new Data("data");
   //    OperatorLinkedList list = data.getListOperator();
   //    list.printList();
   //    System.out.println();
   //    time(list, 50);
   //    list.printList();
   // }

   private Node head;

   public OperatorLinkedList() {
      this.head = null;
   }

   public Node getHead() {
      return head;
   }

   public void addOrUpdate(Integer time, Integer key) {
      Node newNode = new Node(new Operator(time, new ArrayList<>(List.of(key))));
      if (head == null) {
         head = newNode;
         return;
      }

      Node curr = head;
      while (curr != null) {
         if (curr.getOperator().getTime().equals(time)) {
            ArrayList<Integer> updatedKeyList = new ArrayList<>(curr.getOperator().getListKey());
            updatedKeyList.add(key);
            curr.getOperator().setListKey(updatedKeyList);
            return;
         }
         curr = curr.getNext();
      }

      curr = head;
      while (curr.getNext() != null) {
         curr = curr.getNext();
      }
      curr.setNext(newNode);
   }

   public void printList() {
      Node curr = head;
      while (curr != null) {
         Operator op = curr.getOperator();
         Integer time = op.getTime();
         ArrayList<Integer> keyList = op.getListKey();

         System.out.print(time + " [");
         for (int i = 0; i < keyList.size(); i++) {
            if (i != 0) {
               System.out.print(",");
            }
            System.out.print(keyList.get(i));
         }
         System.out.println("]");

         curr = curr.getNext();
      }
   }

   public static OperatorLinkedList time(OperatorLinkedList list, int speed) {
      Node curr = list.getHead();
      while (curr != null) {
         Operator op = curr.getOperator();
         Integer time = op.getTime();
         op.setTime(time*100/speed);

         curr = curr.getNext();
      }
      return list;
   }
}
