package org.example.persistence;

import org.example.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

// Adapteaza repository-ul Spring Data JPA la interfata noastra CrudRepository
@Component
public class BooksRepositoryAdapter implements CrudRepository<Book, Integer> {

    private final BooksRepository jpaRepository;

    public BooksRepositoryAdapter(BooksRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Book save(Book book) {
        return jpaRepository.save(book);
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        jpaRepository.deleteById(id);
    }
}
