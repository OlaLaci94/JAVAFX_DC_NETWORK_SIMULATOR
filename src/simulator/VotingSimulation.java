package simulator;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

/**
 * Created by Ola Laci on 23/04/2015.
 */
public class VotingSimulation extends Movement {


    Button backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn;
    StackPane stackPane;
    ImageView snakeImgViw, elephantImgViw, dogImgViw, privateKeyImgViw, publicKeyImgViw, roundKeyImgViw, poolImgViw, messageImgViw, sharedKeyImgViw;
    TextArea textArea, signatureVector1,signatureVector2,signatureVector3,signatureVector4,signatureVector5,signatureVector6;
    HBox signatureVector;

    public VotingSimulation(Button backSimulatorBtn, Button pauseSimulatorBtn, Button playSimulatorBtn, StackPane stackPane,
                            ImageView snakeImgViw,ImageView dogImgViw,ImageView privateKeyImgViw,ImageView publicKeyImgViw,ImageView roundKeyImgViw,
                            ImageView poolImgViw, ImageView messageImgViw, ImageView elephantImgViw, TextArea textArea,
                            TextArea signatureVector1,TextArea signatureVector2,TextArea signatureVector3,TextArea signatureVector4,TextArea signatureVector5,
                            TextArea signatureVector6, HBox signatureVector, ImageView sharedKeyImgViw){

        this.backSimulatorBtn = backSimulatorBtn;
        this.pauseSimulatorBtn = pauseSimulatorBtn;
        this.playSimulatorBtn = playSimulatorBtn;
        this.stackPane = stackPane;
        this.snakeImgViw = snakeImgViw;
        this.elephantImgViw = elephantImgViw;
        this.textArea = textArea;
        this.dogImgViw = dogImgViw;
        this.privateKeyImgViw = privateKeyImgViw;
        this.publicKeyImgViw = publicKeyImgViw;
        this.roundKeyImgViw = roundKeyImgViw;
        this.poolImgViw = poolImgViw;
        this.messageImgViw = messageImgViw;
        this.sharedKeyImgViw = sharedKeyImgViw;
        this.signatureVector1 = signatureVector1;
        this.signatureVector2 = signatureVector2;
        this.signatureVector3 = signatureVector3;
        this.signatureVector4 = signatureVector4;
        this.signatureVector5 = signatureVector5;
        this.signatureVector6 = signatureVector6;
        this.signatureVector = signatureVector;

        tranArrList = new ArrayList<Transition>();

        textArea.setText("This illustration will showcase how the dining cryptographer principle can be used in a boardroom voting scenario. It " +
                "will explain that it ensures each participant can only vote once by creating a vector that has a size equal to the of the " +
                "participants.");

        part1();

    }


    public void part1(){

        scaleTransition(4500.0, textArea, 2.0,2.0,2,true);
        scaleTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Text t = new Text("bi red");
                t.setFill(Color.AQUA);
                Text tt = new Text("hjnmk");
                tt.setFill(Color.BLUE);
              TextFlow text = new TextFlow(t,tt);
              
              textArea.setText(StringBuilder);


            }
        });

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


