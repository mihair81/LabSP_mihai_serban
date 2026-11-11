package org.example.commands;

import org.example.Author;
import org.example.Book;

import java.util.Optional;

public class UpdateBookCommand implements Command<UpdateBookCommand.Request, Optional<Book>> {

    public record Request(Integer id, Book book) {
    }

    private final CommandContext context;

    public UpdateBookCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Optional<Book> execute(Request input) {
        return context.getBooksRepository().findById(input.id()).map(existing -> {
            existing.setTitle(input.book().getTitle());
            existing.getAuthors().clear();
            for (Author author : input.book().getAuthors()) {
                existing.addAuthor(new Author(author.getName(), author.getSurname()));
            }
            return context.getBooksRepository().save(existing);
        });
    }
}
