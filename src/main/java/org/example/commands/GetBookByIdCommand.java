package org.example.commands;

import org.example.Book;

import java.util.Optional;

public class GetBookByIdCommand implements Command<Integer, Optional<Book>> {

    private final CommandContext context;

    public GetBookByIdCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Optional<Book> execute(Integer id) {
        return context.getBooksRepository().findById(id);
    }
}
