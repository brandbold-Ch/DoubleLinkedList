package Interfaces;

import NodeStructure.Node;

public interface NodeRequirements {

    Object getData();
    void setData(Object data);

    Node getNext();
    Node getBefore();

    void setNext(Node next);
    void setBefore(Node previous);
}
