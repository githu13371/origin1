package ru.sapteh.Dao;

import java.util.List;

public interface Dao <Entity,Integer> {
    Entity findById(Integer id);
    List<Entity> findAll();
    void save(Entity entity);
    void update(Entity entity);
    void delete(Entity entity);

}