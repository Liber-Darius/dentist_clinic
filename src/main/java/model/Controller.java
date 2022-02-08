package model;

public interface Controller<T,Tid> {
    void addObj(T elem);
    void deleteObj(T elem);
    void updateObj(T elem, Tid id);
    T searchObj (Tid id);
    Iterable<T> FindAll();

}
