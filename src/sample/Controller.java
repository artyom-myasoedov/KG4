package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sample.model.Roundness;
import sample.model.TriplePlane;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Pane pane;

    @FXML
    private Button button;

    @FXML
    void initialize() {
        final Group[] group = {new Group()};
        TriplePlane triplePlane = new TriplePlane();
        triplePlane.setGroup(group[0]);
        triplePlane.setCenter(new Point2D(300, 300));
        triplePlane.setPlaneSize(170);
        triplePlane.draw();
        pane.getChildren().add(triplePlane.get());
        new Camera(group[0]);
        Roundness roundness = new Roundness();
        roundness.setRadius(20);
        roundness.setPlaneSize(triplePlane.getPlaneSize() - roundness.getRadius());

        button.setOnAction(ActiveEvent -> {
            triplePlane.clear();
            roundness.setCenter(triplePlane.getCenter());
            roundness.setGroup(group[0]);
            roundness.draw();

        });

    }
}
