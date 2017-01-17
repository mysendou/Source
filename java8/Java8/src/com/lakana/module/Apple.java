package com.lakana.module;

import java.awt.*;

/**
 * Created by Jeff.Ma on 1/6/2017.
 */
public class Apple {
    private long id;
    private Color color;
    private float weight;
    private String origin;

    public Apple () {

    }

    public Apple (long id, Color color, float weight, String origin) {
        this.id = id;
        this.color = color;
        this.weight = weight;
        this.origin = origin;
    }

    public void setId (long id) {
        this.id = id;
    }

    public void setColor (Color color) {
        this.color = color;
    }

    public void setWeight (float weight) {
        this.weight = weight;
    }

    public void setOrigin (String origin) {
        this.origin = origin;
    }

    public long getId () {
        return id;
    }

    public Color getColor () {
        return color;
    }

    public float getWeight () {
        return weight;
    }

    public String getOrigin () {
        return origin;
    }

    @Override
    public String toString () {
        return "Apple{" +
                "id=" + id +
                ", color=" + color +
                ", weight=" + weight +
                ", origin='" + origin + '\'' +
                '}';
    }
}
