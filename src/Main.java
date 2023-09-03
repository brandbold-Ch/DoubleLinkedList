import NodeStructure.Node;

import static Interfaces.MethodsList.DIRECTIONAL_MODE;

public class Main {

    public static void main(String[] args) throws Exception {

        UtilLinkedList<Integer> list = new UtilLinkedList<>(DIRECTIONAL_MODE);

        list.add(24, true);
        list.add(25, true);
        list.add(26, true);
        list.add(27, true);
        list.add(28, true);
        list.add(29, true);
        list.add(30, true);
        list.add(50, false);
        list.delete(30);
        list.delete(24);
        list.delete(29);


        for (Node run : list){
           System.out.println(run.getItem() + " : " + run.getData());
        }

        System.out.println("Pesa: " + list.getItems());
        System.out.println(list.listInsertMode());
        System.out.println(list.getList().getData());
        System.out.println(list.objectTypeUse());

    }
}