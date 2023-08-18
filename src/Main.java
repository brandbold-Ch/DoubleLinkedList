import NodeStructure.Node;

public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList(LinkedList.BIDIRECTIONAL_MODE);

        list.addFront(3);
        list.addFront(8);
        list.addFront(6);
        list.addFront(5);
        list.add(19);
        //list.insert(12, 0);


        for (Node run : list){
           System.out.println(run.getItem() + " : " + run.getData());
        }

        System.out.println("Pesa: " + list.getItems());
        System.out.println(list.listInMode());

    }
}