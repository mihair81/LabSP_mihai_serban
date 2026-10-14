package org.example;

import java.awt.Dimension;

public class ImageProxy implements Element, Picture {

    private final String url;
    private final Dimension dim = new Dimension(800, 600);
    private Image realImage; // se creeaza doar cand e nevoie

    public ImageProxy(String url) {
        this.url = url;
    }

    private Image loadImage() {
        if (realImage == null) {
            realImage = new Image(url);
        }
        return realImage;
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public Dimension dim() {
        return dim;
    }

    @Override
    public String content() {
        return loadImage().content();
    }

    public void render() {
        loadImage().render();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}