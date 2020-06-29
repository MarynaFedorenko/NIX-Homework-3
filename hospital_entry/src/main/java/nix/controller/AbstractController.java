package nix.controller;

import nix.data.AbstractData;

import java.util.List;

public interface AbstractController <T extends AbstractData<T>>  {
    void saveOrUpdate(T t);
    T findById(String id);
    List<T> findAll();
    void remove(String id);
}
