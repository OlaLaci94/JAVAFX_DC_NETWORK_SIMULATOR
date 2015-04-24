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
public class VotingSimulation extends Movement {


    Button backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn;
    StackPane stackPane;
    ImageView snakeImgViw, elephantImgViw;
    TextArea textArea;

    public VotingSimulation(Button backSimulatorBtn, Button pauseSimulatorBtn, Button playSimulatorBtn, StackPane stackPane,
                           ImageView snakeImgViw, ImageView elephantImgViw, TextArea textArea){


        this.backSimulatorBtn = backSimulatorBtn;
        this.pauseSimulatorBtn = pauseSimulatorBtn;
        this.playSimulatorBtn = playSimulatorBtn;
        this.stackPane = stackPane;
        this.snakeImgViw = snakeImgViw;
        this.elephantImgViw = elephantImgViw;
        this.textArea = textArea;


        tranArrList = new ArrayList<Transition>();

        textArea.setText("This illustration will showcase how the dining cryptographer principle can be used in a boardroom voting scenario. It " +
                "will explain that it ensures each participant can only vote once by creating a vector that has a size equal to the of the " +
                "participants.");

        part1();

    }


    public void part1(){

        textArea.setText("Each participant chooses a secret key and a complementary public key, and participants compute their shared keys- using " +
                "Diffie Hellman key exchange");

        textArea.setText("Slot reservation round consists of each participant choosing their binary vector position. If the total sum of 1's is " +
                "less than 1, we can identify that there were collisions and therefore need to repeat; if the total sum is equal to the number of " +
                "participants, and every participant can identify their unique position, we can conclude that it was successful; if the total sum is " +
                "greater than the number of participants or a participant cannot locate their unique position, we can conclude that the protocol " +
                "has been violated and that we need to investigate.");

        textArea.setText("Voting consists of each participant computing their round keys and compute commitments, while one participant broadcasts " +
                "the counter keeping record of all rounds within the session. The participants then all compute, publish and check their commitments, " +
                "using a provided equation. If a formula does not hold, then the protocol has been violated and we need to investigate this");

        textArea.setText("When the participants accepted the commitments, they published their exponents which are then verified. The participants " +
                "verify the exponent and the sum of vectors is the ballot of participants.");

        textArea.setText("");
    }
}


