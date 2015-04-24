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
public class ArbitraryLengthAnimation extends Movement {

    Button backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn;
    StackPane stackPane;
    ImageView snakeImgViw, elephantImgViw;
    TextArea textArea;

    public ArbitraryLengthAnimation(Button backSimulatorBtn, Button pauseSimulatorBtn, Button playSimulatorBtn, StackPane stackPane,
                                    ImageView snakeImgViw, ImageView elephantImgViw, TextArea textArea){


        this.backSimulatorBtn = backSimulatorBtn;
        this.pauseSimulatorBtn = pauseSimulatorBtn;
        this.playSimulatorBtn = playSimulatorBtn;
        this.stackPane = stackPane;
        this.snakeImgViw = snakeImgViw;
        this.elephantImgViw = elephantImgViw;
        this.textArea = textArea;

        tranArrList = new ArrayList<Transition>();

        textArea.setText("The following illustration will show how to transmit messages of arbitrary length with unconditional anonymity. The protocol can work on any number of " +
                "participants, and it is assumed that messages have been authenticated via digital signatures. Also, in practice a reservation round" +
                " would be necessary for handling collisions. This protocol is similar to the Arbitrary Alphabet protocol and knowledge of that is " +
                "assumed.");

        part1();


    }

    public void part1(){

        textArea.setText("The DC net is assembled using a parameter generation function by a trusted entity- which satisfies the Decisional " +
                "Bilinear Diffie Hellman problem - and therefore uses both admissible linear maps and elliptic curve based algebraic groups. " +
                "There is also a publicly known random number generator which takes the length of the messages as input. The key distribution " +
                "function distributes the necessary keys to all participants.");

        textArea.setText("The output vector is constructed in the same way as for the Arbitrary Alphabet- the participant chooses a random position within their pad " +
                "and performs the function XOR MESSAGE with that specific partial pad. The auxiliary verification data is then computed by every " +
                "participant generating a non interactive random challenge which adds half of the partial pads to a set- ensuring the partial pad with the" +
                "message is not included. Each participant then outputs the vector, the subset- containing half of the partial pads- and the participants " +
                "secret key. This allows any verifier to verify the correctness of the subset- and therefore the vector, while maintaining the anonymity of " +
                "the senders message.  ");

        textArea.setText("Message extraction is performed taking the output vectors of all participants and computing the necessary inverse " +
                "equations which outputs the set of messages- which contains at most n messages- where n is the number of participants.");

        textArea.setText("If any participants fail to produce a correct output vector - or do not output a vector- the set of other players can " +
                "produce a correct output vector by combining their shared keys with the missing participant. Polynomial interpolation allows anyone "+
                " to recompute the pads of the missing participant.");



    }
}
