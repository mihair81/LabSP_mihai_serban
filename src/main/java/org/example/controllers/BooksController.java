package org.example.controllers;

import org.example.Book;
import org.example.commands.CommandContext;
import org.example.commands.CreateBookCommand;
import org.example.commands.DeleteBookCommand;
import org.example.commands.GetAllBooksCommand;
import org.example.commands.GetBookByIdCommand;
import org.example.commands.UpdateBookCommand;
import org.example.persistence.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final CommandContext context;

    // Spring injecteaza repository-ul (prin adapter), iar controllerul il da mai departe in context
    public BooksController(CrudRepository<Book, Integer> booksRepository) {
        this.context = new CommandContext(booksRepository);
    }

    @GetMapping
    public List<Book> getAll() {
        return new GetAllBooksCommand(context).execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Integer id) {
        return new GetBookByIdCommand(context).execute(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody Book book) {
        Book created = new CreateBookCommand(context).execute(book);
        return ResponseEntity.created(URI.create("/books/" + created.getId())).body(created.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book book) {
        return new UpdateBookCommand(context).execute(new UpdateBookCommand.Request(id, book))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return new DeleteBookCommand(context).execute(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
