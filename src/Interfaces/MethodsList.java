package Interfaces;

public interface MethodsList {

    void add(Object data);
    void destroy();
    void insert(Object data, int index);
    void replace(Object data, int index);
    void addFront(Object data);
    void delete(Object data);
    boolean listEmpty();
}
