package sample.model;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.List;

public class Roundness implements IModel {

    private List<Plane> planes;
    private Point2D center;
    private int planeSize;
    private Group group;
    private int radius;

    public Roundness() {
        this.planes = new ArrayList<>();
        center = Point2D.ZERO;
        group = new Group();
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public Point2D getCenter() {
        return center;
    }

    public void setCenter(Point2D center) {
        this.center = center;
        group.setLayoutX(center.getX());
        group.setLayoutY(center.getY());
    }

    public int getPlaneSize() {
        return planeSize;
    }

    public void setPlaneSize(int planeSize) {
        this.planeSize = planeSize;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    private void createPlanes() {
        planes.add(new Plane(group, planeSize, Color.YELLOW));
        planes.add(new Plane(group, planeSize, Color.RED));
        planes.add(new Plane(group, planeSize, Color.BLUE));
        planes.get(1).getRect().getTransforms().
                addAll(new Rotate(90, Rotate.X_AXIS));
        planes.get(2).getRect().getTransforms().
                addAll(new Rotate(90, Rotate.X_AXIS), new Rotate(90, Rotate.Y_AXIS));
        planes.get(1).getRect().setTranslateX(radius);
        planes.get(2).getRect().setTranslateY(radius);
        planes.get(0).getRect().setTranslateX(radius);
        planes.get(0).getRect().setTranslateY(radius);
        planes.get(0).getRect().setTranslateZ(-radius);


    }

    public void createRounds() {
        for (int i = 0; i <= 45; i++) {
            Rectangle rect = new Rectangle(planeSize, 2);
            rect.setFill(Color.GRAY);
            rect.setTranslateX(radius);
            rect.setTranslateY(i / 1.5 * Math.sin(i * Math.PI / 180));
            rect.setTranslateZ(-i / 1.5 * Math.cos(i * Math.PI / 180));
            rect.getTransforms().add(new Rotate(i * Math.PI / 180, Rotate.X_AXIS));
            group.getChildren().add(rect);
        }

        for (int i = 0; i <= 45; i++) {
            Rectangle rect = new Rectangle(planeSize, 2);
            rect.setFill(Color.GRAY);
            rect.setTranslateX(radius);
            rect.setTranslateY(i / 1.5 * Math.sin(i * Math.PI / 180));
            rect.setTranslateZ(-i / 1.5 * Math.cos(i * Math.PI / 180));
            rect.getTransforms().add(new Rotate(90, Rotate.X_AXIS));
            rect.getTransforms().add(new Rotate(i * Math.PI / 180, Rotate.Z_AXIS));
            group.getChildren().add(rect);
        }

        for (int i = 0; i <= 45; i++) {
            Rectangle rect = new Rectangle(planeSize, 2);
            rect.setFill(Color.GRAY);

            rect.setTranslateZ(planeSize);
            rect.setTranslateY(i / 1.5 * Math.sin(i * Math.PI / 180));
            rect.setTranslateX(-i / 1.5 * Math.cos(i * Math.PI / 180) + 20);
            rect.getTransforms().add(new Rotate(90, Rotate.Y_AXIS));
            rect.getTransforms().add(new Rotate(i * Math.PI / 180, Rotate.X_AXIS));
            group.getChildren().add(rect);
        }

        for (int i = 0; i <= 45; i++) {
            Rectangle rect = new Rectangle(planeSize, 2);
            rect.setFill(Color.GRAY);

            rect.setTranslateZ(planeSize);
            rect.setTranslateY(i / 1.5 * Math.sin(i * Math.PI / 180));
            rect.setTranslateX(-i / 1.5 * Math.cos(i * Math.PI / 180) + 20);
            rect.getTransforms().add(new Rotate(90, Rotate.Y_AXIS));
            rect.getTransforms().add(new Rotate(90, Rotate.X_AXIS));
            rect.getTransforms().add(new Rotate(i * Math.PI / 180, Rotate.X_AXIS));
            group.getChildren().add(rect);
        }

        for (int i = 0; i <= 45; i++) {
            Rectangle rect = new Rectangle(planeSize, 2);
            rect.setFill(Color.GRAY);

            rect.setTranslateY(radius);
            rect.setTranslateZ(i / 1.5 * Math.sin(i * Math.PI / 180) - 20);
            rect.setTranslateX(-i / 1.5 * Math.cos(i * Math.PI / 180) + 20);
            rect.getTransforms().add(new Rotate(90, Rotate.Z_AXIS));
            rect.getTransforms().add(new Rotate(i * Math.PI / 180, Rotate.Y_AXIS));
            group.getChildren().add(rect);
        }

        for (int i = 0; i <= 45; i++) {
            Rectangle rect = new Rectangle(planeSize, 2);
            rect.setFill(Color.GRAY);

            rect.setTranslateY(20);
            rect.setTranslateZ(i / 1.5 * Math.sin(i * Math.PI / 180) - radius);
            rect.setTranslateX(-i / 1.5 * Math.cos(i * Math.PI / 180) + radius);
            rect.getTransforms().add(new Rotate(90, Rotate.Z_AXIS));
            rect.getTransforms().add(new Rotate(90, Rotate.X_AXIS));
            rect.getTransforms().add(new Rotate(i * Math.PI / 180, Rotate.Y_AXIS));
            group.getChildren().add(rect);
        }

        for (int i = 0; i <= 30; i++) {
            for (int j = 0; j < 45; j += 2) {
                Rectangle rect1 = new Rectangle(2, 2);
                rect1.setFill(Color.GRAY);
                rect1.setTranslateX(-radius * 1.5 * Math.sin(j * Math.PI / 180) * Math.cos(3 * i * Math.PI / 180) + 20);
                rect1.setTranslateY(-radius * 1.5 * Math.sin(j * Math.PI / 180) * Math.sin(3 * i * Math.PI / 180) + 20);
                rect1.setTranslateZ(-radius * 2 * 1.5 * Math.cos(j * Math.PI / 180) + 44);
                rect1.getTransforms().addAll(new Rotate(j * Math.PI / 180, Rotate.X_AXIS),
                        new Rotate(3 * i * Math.PI / 180, Rotate.Y_AXIS), new Rotate(45, Rotate.Y_AXIS));
                group.getChildren().add(rect1);
            }
        }

    }

    public void clear() {
        group.getChildren().clear();
    }

    public void draw() {
        createPlanes();
        createRounds();
        planes.forEach(plane -> plane.draw(group));
    }

    @Override
    public Group get() {
        return group;
    }
}
