package NodeStructure;

import Interfaces.NodeRequirements;

public class Node implements NodeRequirements {

    private Object data;
    public Node next, before;
    protected int items, item;

    public Node(Object data, Node next, Node before, int index){
        this.data = data;
        this.next = next;
        this.before = before;
        this.item = index;
    }

    public Node(Object data){
        this.data = data;
    }

    public Node(){}

    @Override
    public Object getData() {
        return this.data;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public Node getNext() {
        return this.next;
    }

    @Override
    public Node getBefore() {
        return this.before;
    }

    @Override
    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public void setBefore(Node previous) {
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
