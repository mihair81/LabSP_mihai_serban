package org.example.persistence;

import java.util.List;
import java.util.Optional;

// Abstractizarea operatiilor de care au nevoie straturile de sus,
// independenta de Spring Data JPA.
public interface CrudRepository<T, ID> {

    T save(T entity);

    Optional<T> findById(ID id);

    List<T> findAll();

    void deleteById(ID id);
}
