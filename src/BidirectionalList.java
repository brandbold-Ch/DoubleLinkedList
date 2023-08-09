import Interfaces.MethodsList;
import Linked.Node;

public class BidirectionalList extends Node implements MethodsList {

    public BidirectionalList(){}

    @Override
    public void addFront(int data) {
        Node aux = getNext();

        if (listEmpty()){
            setNext(new Node(data, null, null));
        }else {
            setNext(new Node(data, this.next, aux));
        }
    }

    @Override
    public void crash() {

    }

    @Override
    public void insert(int data, byte index) {

    }

    @Override
    public void delete(int data) {

    }

    @Override
    public void addLast(int data) {

    }

    @Override
    public void printFront() {
        Node auxiliar = getNext();
        if (!listEmpty()){
            while (auxiliar != null){
                System.out.print(auxiliar.getData() + " -> ");
                auxiliar = auxiliar.getNext();
            }
        }
    }

    @Override
    public void printLast() {
        Node auxiliar = getNext();
        if (!listEmpty()){
            while (auxiliar != null){
                System.out.print(auxiliar.getData() + " <- ");
                auxiliar = auxiliar.getPrevious();
            }
        }
    }

    @Override
    public boolean listEmpty() {
        return this.next == null;
    }
}
