package Interfaces;

public interface MethodsList<T> {
    final String BIDIRECTIONAL_MODE = "bidirectional";
    final String DIRECTIONAL_MODE = "directional";

    void add(T data, boolean insert_next);
    void insert(T data, int index);
    void replace(T data, int index);
    void sort(String method_algorithm);

    void destroy();
    void delete(T data);
}
