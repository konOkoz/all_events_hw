package de.ait.hw.repositories;

import de.ait.hw.models.User;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

    void save(T entity);

    List<T> findAll();

    Optional<T> findById(Long id);

    void delete(T entity);

    // TODO: удалить когда подключим базу данных
    void clear();

}
