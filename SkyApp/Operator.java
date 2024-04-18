import java.util.ArrayList;

public class Operator {
   private Integer time;
   private ArrayList<Integer> listKey;

   public Operator(Integer time, ArrayList<Integer> listKey) {
      this.time = time;
      this.listKey = listKey;
   }

   public Integer getTime() {
      return time;
   }

   public ArrayList<Integer> getListKey() {
      return listKey;
   }

   public void setTime(Integer time) {
      this.time=time;
   }

   public void setListKey(ArrayList<Integer> listKey) {
      this.listKey = listKey;
   }
}