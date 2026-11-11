package org.example.observer;

import org.example.Book;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public class SseObserver implements Observer<Book> {

    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;
    }

    @Override
    public void update(Book book) {
        try {
            emitter.send(book, MediaType.APPLICATION_JSON);
        } catch (Exception e) {
            emitter.completeWithError(e);
        }
    }
}