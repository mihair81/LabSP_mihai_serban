package org.example.commands;

public class DeleteBookCommand implements Command<Integer, Boolean> {

    private final CommandContext context;

    public DeleteBookCommand(CommandContext context) {
        this.context = context;
    }

    @Override
    public Boolean execute(Integer id) {
        if (context.getBooksRepository().findById(id).isEmpty()) {
            return false;
        }
        context.getBooksRepository().deleteById(id);
        return true;
    }
}
