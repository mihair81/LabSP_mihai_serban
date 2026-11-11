package org.example.observer;

// Subject: tine lista de observatori si ii anunta
public interface Subject<T> {

    void attach(Observer<T> observer);

    void detach(Observer<T> observer);

    void notifyObservers();
}