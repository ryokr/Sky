class Node {
   private Operator data;
   private Node next;

   public Node(Operator data) {
      this.data = data;
      this.next = null;
   }

   public Operator getOperator() {
      return data;
   }

   public Node getNext() {
      return next;
   }

   public void setNext(Node next) {
      this.next = next;
   }
}