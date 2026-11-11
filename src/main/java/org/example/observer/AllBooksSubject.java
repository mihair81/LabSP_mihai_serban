package org.example.observer;

import org.example.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class AllBooksSubject implements Subject<Book> {

    private final List<Observer<Book>> observers = new CopyOnWriteArrayList<>();
    private volatile Book latestBook;

    @Override
    public void attach(Observer<Book> observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer<Book> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer<Book> observer : observers) {
            observer.update(latestBook);
        }
    }

    public void add(Book book) {
        this.latestBook = book;
        notifyObservers();
    }

    public Book getState() {
        return latestBook;
    }
}