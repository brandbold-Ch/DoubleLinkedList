package NodeStructure;

import Interfaces.NodeRequirements;

public class Node<T> implements NodeRequirements<T> {

    private T data;
    public Node<T> next, before;
    protected int items, item;

    public Node(T data, Node<T> next, Node<T> before, int index){
        this.data = data;
        this.next = next;
        this.before = before;
        this.item = index;
    }

    public Node(){}

    @Override
    public T getData() {
        return this.data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public Node<T> getNext() {
        return this.next;
    }

    @Override
    public Node<T> getBefore() {
        return this.before;
    }

    @Override
    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public void setBefore(Node<T> previous) {
        this.before = previous;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getItems() {
        return items;
    }
}
