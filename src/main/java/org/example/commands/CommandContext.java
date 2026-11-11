package org.example.commands;

import org.example.Book;
import org.example.persistence.CrudRepository;

// Contextul comenzilor: tine repository-ul de care au nevoie
public class CommandContext {

    private final CrudRepository<Book, Integer> booksRepository;

    public CommandContext(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }

    public CrudRepository<Book, Integer> getBooksRepository() {
        return booksRepository;
    }
}
