package org.example.commands;

import org.example.Book;

import java.util.List;

public class GetAllBooksCommand implements Command<Void, List<Book>> {

    private final CommandContext context;

    public GetAllBooksCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public List<Book> execute(Void input) {
        return context.getBooksRepository().findAll();
    }
}
