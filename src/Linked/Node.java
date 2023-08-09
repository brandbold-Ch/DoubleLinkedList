package Linked;

import Interfaces.NodeRequirements;

public class Node implements NodeRequirements {

    public int data;
    public Node next, previous;

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    public Node(int data, Node previous){
        this.data = data;
        this.next = previous;
    }

    public Node(){}

    @Override
    public int getData() {
        return this.data;
    }

    @Override
    public void setData(int data) {
        this.data = data;
    }

    @Override
    public Node getNext() {
        return this.next;
    }

    @Override
    public Node getPrevious() {
        return this.previous;
    }

    @Override
    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
