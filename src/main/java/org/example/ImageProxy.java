package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

import java.awt.Dimension;

@Entity
public class ImageProxy extends BaseElement implements Picture {

    private String url;

    @Transient
    private Dimension dim = new Dimension(800, 600);

    // imaginea reala se creeaza doar cand e nevoie si nu se salveaza in baza de date
    @Transient
    private Image realImage;

    protected ImageProxy() {
    }

    public ImageProxy(String url) {
        this.url = url;
    }

    private Image loadImage() {
        if (realImage == null) {
            realImage = new Image(url);
        }
        return realImage;
    }

    public String getUrl() {
        return url;
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
