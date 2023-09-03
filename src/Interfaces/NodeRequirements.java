package Interfaces;

import NodeStructure.Node;

public interface NodeRequirements<T> {

    T getData();
    void setData(T data);

    Node<T> getNext();
    Node<T> getBefore();

    void setNext(Node<T> next);
    void setBefore(Node<T> previous);
}
