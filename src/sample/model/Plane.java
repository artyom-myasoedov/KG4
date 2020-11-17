package sample.model;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Plane {
    private final double weight;
    private final Color color;
    private final Rectangle rect;

    public Plane(Group group, double weight, Color color){
        this.weight = weight;
        this.color = color;
        rect = new Rectangle(weight, weight);
    }

    public Rectangle getRect() {
        return rect;
    }

    public double getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    public void draw(Group group){
        rect.setFill(color);
        group.getChildren().add(rect);
    }
}
