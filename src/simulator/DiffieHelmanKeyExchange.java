package simulator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * Created by Ola Laci on 21/04/2015.
 */
public class DiffieHelmanKeyExchange extends Movement{

    Button backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn;
    StackPane stackPane;
    ImageView snakeImgViw, elephantImgViw, dogImgViw;
    TextArea textArea, elephantTextArea, snakeTextArea;


    public DiffieHelmanKeyExchange(Button backSimulatorBtn, Button pauseSimulatorBtn, Button playSimulatorBtn, StackPane stackPane,
                                   ImageView snakeImgViw, ImageView elephantImgViw, ImageView dogImgViw, TextArea textArea,
                                   TextArea elephantTextArea, TextArea snakeTextArea){


        this.backSimulatorBtn = backSimulatorBtn;
        this.pauseSimulatorBtn = pauseSimulatorBtn;
        this.playSimulatorBtn = playSimulatorBtn;
        this.stackPane = stackPane;
        this.snakeImgViw = snakeImgViw;
        this.elephantImgViw = elephantImgViw;
        this.dogImgViw = dogImgViw;
        this.textArea = textArea;
        this.elephantTextArea = elephantTextArea;
        this.snakeTextArea = snakeTextArea;





    }



}
