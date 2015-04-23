package simulator;

import javafx.animation.Transition;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

/**
 * Created by Ola Laci on 23/04/2015.
 */
public class DiscoSimulation extends Movement {


    Button backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn;
    StackPane stackPane;
    ImageView snakeImgViw, elephantImgViw;
    TextArea textArea;

    public DiscoSimulation(Button backSimulatorBtn, Button pauseSimulatorBtn, Button playSimulatorBtn, StackPane stackPane,
                           ImageView snakeImgViw, ImageView elephantImgViw, TextArea textArea){


        this.backSimulatorBtn = backSimulatorBtn;
        this.pauseSimulatorBtn = pauseSimulatorBtn;
        this.playSimulatorBtn = playSimulatorBtn;
        this.stackPane = stackPane;
        this.snakeImgViw = snakeImgViw;
        this.elephantImgViw = elephantImgViw;
        this.textArea = textArea;


        tranArrList = new ArrayList<Transition>();
    }
}
