package org.example.commands;

import org.example.Author;
import org.example.Book;

public class CreateBookCommand implements Command<Book, Book> {

    private final CommandContext context;

    public CreateBookCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Book execute(Book input) {
        // cream o carte noua, ca sa nu se foloseasca id-uri trimise de client
        Book book = new Book(input.getTitle());
        for (Author author : input.getAuthors()) {
            book.addAuthor(new Author(author.getName(), author.getSurname()));
        }
        return context.getBooksRepository().save(book);
    }
}
