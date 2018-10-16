package com.onpu.jsonsimple.Recycler;

/**
 * Created by Admin on 10.10.2018.
 */

public class Item {
    private int image;
    private String text;

    public Item(int image, String text) {
        this.image = image;
        this.text = text;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
