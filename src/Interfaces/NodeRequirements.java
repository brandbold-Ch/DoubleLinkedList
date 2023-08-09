package Interfaces;

import Linked.Node;

public interface NodeRequirements {

    int getData();
    void setData(int data);

    Node getNext();
    Node getPrevious();

    void setNext(Node next);
    void setPrevious(Node previous);
}
