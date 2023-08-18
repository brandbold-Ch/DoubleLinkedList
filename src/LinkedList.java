import Interfaces.MethodsList;
import NodeStructure.Node;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;


public class LinkedList extends Node implements MethodsList, Iterable<Node> {

    public static final String BIDIRECTIONAL_MODE = "bidirectional";
    public static final String DIRECTIONAL_MODE = "directional";
    private Node outset;
    private final String select;

    public LinkedList(String function_to_use){
        this.outset = null;
        this.select = function_to_use;
    }

    @Override
    public void add(Object data) {
        Node aux;

        if (listEmpty()){
            this.outset = new Node(data, null, null, this.item++);
        }else {
            aux = this.outset;
            while (aux.getNext() != null){
                aux = aux.getNext();
            }
            aux.setNext(new Node(data, null, (isBoth())?aux:null, this.item++));
        }
        this.items++;
    }

    @Override
    public void destroy() {
        this.outset = null;
    }

    @Override
    public void insert(Object data, int index) {
        Node aux = this.outset;
        if (!listEmpty()){
            while (aux != null){
                if (aux.getNext().getItem() == index){
                    aux.setNext(new Node(data, aux.getNext(), (isBoth())?aux:null, aux.getNext().getItem()));
                    if (isBoth()){
                        aux.getNext().getNext().setBefore(aux.getNext());
                    }
                    break;
                }
                aux = aux.getNext();
            }
        }
        this.items++;
    }

    @Override
    public void replace(Object data, int index) {
        Node aux = this.outset;
        if (!listEmpty()){
            while (aux != null){
                if (aux.getItem() == index){
                    aux.setData(data);
                    break;
                }
                aux = aux.getNext();
            }
        }
    }

    @Override
    public void addFront(Object data) {
        Node aux;

        if (listEmpty()){
            this.outset = new Node(data, null, null, this.item++);
        }else {

            System.out.println(this.outset.getData());
            this.outset = new Node(data, this.outset, (isBoth())?this.outset:null, this.item++);
            System.out.println(this.outset.getData());
        }
        this.items++;
    }

    private boolean isBoth(){
        return this.select.equals(LinkedList.BIDIRECTIONAL_MODE);
    }

    public String listInMode(){
        return this.select;
    }

    @Override
    public void delete(Object data) {

    }

    @Override
    public boolean listEmpty() {
        return this.outset == null;
    }

    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node>() {
            Node assistant = outset;
            @Override
            public boolean hasNext() {
                return assistant != null;
            }

            @Override
            public Node next() {
                if (hasNext()){
                    Node aux = assistant;
                    assistant = assistant.getNext();
                    return aux;
                }else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Node> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Node> spliterator() {
        return Iterable.super.spliterator();
    }
}
