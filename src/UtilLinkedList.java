import Interfaces.MethodsList;
import NodeStructure.Node;
import java.util.Iterator;
//import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;


public class UtilLinkedList<T> extends Node<T> implements MethodsList<T>, Iterable<Node<T>> {

    private Node<T> outset;
    private final String select;

    public UtilLinkedList(String insertion_method) throws Exception {
        this.outset = null;

        if (insertion_method.equals(BIDIRECTIONAL_MODE) || insertion_method.equals(DIRECTIONAL_MODE)){
            this.select = insertion_method;
        }
        else {
            throw new Exception("Not permission instance");
        }
    }

    private void addRight(T data) {
        Node<T> aux = this.outset;

        if (listEmpty()){
            this.outset = new Node<>(data, null, null, this.item++);
        }else {
            while (aux.getNext() != null){
                aux = aux.getNext();
            }
            Node<T> parser = (isBoth()) ? aux : null;
            aux.setNext(new Node<>(data, null, parser, this.item++));
        }
        this.items++;
    }

    private void addLeft(T data) {
        Node<T> parser = (isBoth()) ? this.outset : null;

        if (listEmpty()){
            this.outset = new Node<>(data, null, null, this.item++);
        }else {
            this.outset = new Node<>(data, this.outset, parser, this.item++);
        }
        this.items++;
    }

    private boolean isBoth(){
        return this.select.equals(BIDIRECTIONAL_MODE);
    }

    public String listInsertMode(){
        return this.select;
    }

    public Node<T> getList(){
        return this.outset;
    }

    private void reorder() {
        Node<T> aux = this.outset;
        int count = 0;

        while (aux != null){
            aux.setItem(count);
            aux = aux.getNext();
            count++;
        }
    }

    public String objectTypeUse(){
        return String.valueOf(this.getList().getData().getClass());
    }

    //public void insert_list_exist(UtilLinkedList<? extends ArrayList> list){}

    @Override
    public void sort(String method_algorithm){}

    @Override
    public void destroy() {
        this.outset = null;
        this.items = 0;
        this.item = 0;
    }

    @Override
    public void add(T data, boolean insert_next) {
        if (insert_next){
            addRight(data);
        }
        else {
            addLeft(data);
        }
    }

    @Override
    public void insert(T data, int index) {
        Node<T> aux = this.outset;
        Node<T> parser = (isBoth()) ? aux : null;

        if (!listEmpty()){
            if (index == 0){
                add(data, false);

            } else if (index == this.items) {
                add(data, true);

            } else if (index > this.items) {
                throw new NoSuchElementException("Not found index");

            } else {
                while (aux != null){
                    if (aux.getNext().getItem() == index){
                        aux.setNext(new Node<>(data, aux.getNext(), parser, aux.getNext().getItem()));

                        if (isBoth()){
                            aux.getNext().getNext().setBefore(aux.getNext());
                        }
                        break;
                    }
                    aux = aux.getNext();
                }
            }
        }else {
            throw new StackOverflowError("List empty");
        }
        reorder();
        this.items++;
    }

    @Override
    public void replace(T data, int index) {
        Node<T> aux = this.outset;

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
    public void delete(T data) {
        Node<T> aux = this.outset;

        if (!listEmpty()){
            if (aux.getData() == data){
                this.outset = this.outset.getNext();

            }else {
                while (aux != null){
                    if (aux.getNext().getData() == data){
                        aux.setNext(aux.getNext().getNext());
                        break;
                    }
                    aux = aux.getNext();
                }
            }
        }else {
            throw new StackOverflowError("List empty");
        }
        reorder();
        this.items--;
    }

    private boolean listEmpty() {
        return this.outset == null;
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return new Iterator<>() {
            Node<T> assistant = outset;

            @Override
            public boolean hasNext() {
                return assistant != null;
            }

            @Override
            public Node<T> next() {
                if (hasNext()) {
                    Node<T> aux = assistant;
                    assistant = assistant.getNext();
                    return aux;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Node<T>> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Node<T>> spliterator() {
        return Iterable.super.spliterator();
    }
}
