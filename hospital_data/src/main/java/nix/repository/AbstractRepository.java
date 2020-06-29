package nix.repository;

import nix.data.AbstractData;

import java.util.List;

public interface AbstractRepository<T extends AbstractData<T>>{
    void save(T t);
    T findById(String id);
    List<T> findAll();
    void update(T t);
    void remove(String id);

}
