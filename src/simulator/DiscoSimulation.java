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

        textArea.setText("The following illustration will showcase how to achieve computationally secure serviceability  " +
                "and unconditional untraceability. This is implemented through the use of digital signatures and claw free " +
                "permutation pairs. This scheme was created to prevent honest participants from being incorrectly labelled as dishonest- " +
                "and consequently removed from the group, and ensuring that any honest participant can broadcast a message " +
                "successfully within a period of time.");

        part1();

    }


    public void part1(){


        textArea.setText("Each participant uses two distinct generators to create a claw free pair and then publishes them- including a zero " +
                "knowledge proof of its correctness. If other participants deem this proof as incorrect, they will be labelled an attacker " +
                "and dealt with accordingly.");

        textArea.setText("Each participant computes an authentication tree for one time signatures for every other participant in the session and " +
                        "publishes the root.");

        textArea.setText("A participant signs a message by creating a signature that can be divided into the number of other participants. Each " +
                "distinct section is proof for a specific participant in the session.");

        textArea.setText("Each participant which receives a message can check and authenticate the correctness of the components known to them, " +
                "but all the while maintaining unconditional sender and receiver untraceability.");

        textArea.setText("Each honest participant who receives a signature, sends it back to the sender. If an honest participant receives a forged " +
                "signature, they will compare the forged signature with the corresponding correct signature, identifying any collisions with the correct signature. " +
                "Any collisions found are published and honest participants accept the proof of forgery if the collisions proof can be substantiated. ");


        textArea.setText("If a participant is labelled an attacker, first offenders will usually lose specific keys- as everyone deserves a second " +
                "chance. However second and multiple offenders are usually removed from the session altogether.");
    }


}
