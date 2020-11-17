package sample.model;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.List;

public class TriplePlane implements IModel {

    private List<Plane> planes;
    private Point2D center;
    private int planeSize;
    private Group group;


    public TriplePlane() {
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

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getPlaneSize() {
        return planeSize;
    }

    public void setPlaneSize(int planeSize) {
        this.planeSize = planeSize;
    }

    public void clear() {
     group.getChildren().clear();
    }

    private void createPlanes() {
        planes.add(new Plane(group, planeSize, Color.YELLOW));
        planes.add(new Plane(group, planeSize, Color.RED));
        planes.add(new Plane(group, planeSize, Color.BLUE));
        planes.get(1).getRect().getTransforms().
                addAll(new Rotate(90, Rotate.X_AXIS));
        planes.get(2).getRect().getTransforms().
                addAll(new Rotate(90, Rotate.X_AXIS), new Rotate(90, Rotate.Y_AXIS));

    }

    public void draw() {
        createPlanes();
        planes.forEach(plane -> plane.draw(group));
    }

    @Override
    public Group get() {
        return group;
    }
}
