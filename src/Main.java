public class Main {
    public static void main(String[] args) {
        BidirectionalList list = new BidirectionalList();

        list.addFront(3);
        list.addFront(8);
        list.addFront(6);
        list.addFront(5);

        list.printFront();
        //System.out.println(list.getNext().getNext().getNext().getNext().getNext().getData());
        System.out.println();
        list.printLast();
       //System.out.println(list.getNext().getData());
    }
}