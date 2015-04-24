package simulator;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

/**
 * Created by Ola Laci on 23/04/2015.
 */
public class ArbitraryAlphabetAnimation extends Movement {

    Button backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn;
    StackPane stackPane;
    ImageView snakeImgViw, elephantImgViw;
    TextArea textArea;

    public ArbitraryAlphabetAnimation(Button backSimulatorBtn, Button pauseSimulatorBtn, Button playSimulatorBtn, StackPane stackPane,
                                      ImageView snakeImgViw, ImageView elephantImgViw, TextArea textArea){

        this.backSimulatorBtn = backSimulatorBtn;
        this.pauseSimulatorBtn = pauseSimulatorBtn;
        this.playSimulatorBtn = playSimulatorBtn;
        this.stackPane = stackPane;
        this.snakeImgViw = snakeImgViw;
        this.elephantImgViw = elephantImgViw;
        this.textArea = textArea;

        tranArrList = new ArrayList<Transition>();

        textArea.setText("The DC net illustrated will show how an algebraic group element can be transmitted with unconditional anonymity- replacing the binary values " +
                "we have seen transmitted in previous animations. The protocol can work on any number of participants, and it is assumed that " +
                        "messages have been authenticated via digital signatures. Also, in practice a reservation round would be necessary for " +
                        "handling collisions.");
        part1();


    }

    public void part1(){

        scaleTransition(4500.0, textArea, 2.0, 2.0, 2, true);
        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.setText("The DC net is assembled using a parameter generation function by a trusted entity- which satisfies the " +
                        "Decisional Bilinear Diffie Hellman problem - and therefore uses both admissible linear maps and elliptic curve " +
                        "based algebraic groups. The key generation is performed using a function which takes in a specification parameter- " +
                        "one for each participant, then produces and distributes a public and secret key for each participant. Each private key " +
                        "is shared between two participants i and j- creating key(i,j).");

                textArea.setText("Each participant is assumed to have a trustworthy global counter of the session and a specification containing all participants " +
                        "this session");

                textArea.setText("Every participant of the session then posts the output vector and subsidiary data; the output vector consists of " +
                        "the pad with one partial pad which contains the generated key XOR the MESSAGE that the participant wishes to post; the subsidiary " +
                        "data contains the participants identity and proof of the posted vectors correctness.");

                textArea.setText("Message extraction is performed taking the output vectors of all participants and computing the necessary inverse " +
                        "equations which outputs the set of messages- which contains at most n messages- where n is the number of participants.");

                textArea.setText("If any participants fail to produce a correct output vector - or do not output a vector- the set of other players can " +
                        "produce a correct output vector by combining their shared keys with the missing participant. Polynomial interpolation allows any "+
                "participant to recompute the pads of the missing participant.");

                textArea.setText("This showcases how to maintain the non interactivity feature of DC nets while maintaining high detection " +
                        "and identification of cheating players with a fault recovery overhead of only one additional broadcast round.");
            }
        });



    }
}
