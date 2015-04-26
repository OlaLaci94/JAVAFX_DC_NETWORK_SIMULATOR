package simulator;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

/**
 * Created by Ola Laci on 22/04/2015.
 */
public class ManyParticipantsAnimation extends Movement {

    private Button backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn;
    private StackPane stackPane;
    private ImageView roundKeyImgViw, sharedKeyImgViw, poolImgViw1, dogImgViw;
    private TextFlow textFlow;
    private TextArea signatureVector1, signatureVector2, signatureVector3, signatureVector4, signatureVector5, signatureVector6;
    private HBox signatureVector;


    public ManyParticipantsAnimation(ImageView poolImgViw1, Button backSimulatorBtn, Button pauseSimulatorBtn, Button playSimulatorBtn, StackPane stackPane,
                                     ImageView roundKeyImgViw, ImageView sharedKeyImgViw, ImageView dogImgViw,
                                     TextFlow textFlow, HBox signatureVector, TextArea signatureVector1, TextArea signatureVector2,
                                     TextArea signatureVector3, TextArea signatureVector4, TextArea signatureVector5, TextArea signatureVector6) {


        this.backSimulatorBtn = backSimulatorBtn;
        this.pauseSimulatorBtn = pauseSimulatorBtn;
        this.playSimulatorBtn = playSimulatorBtn;
        this.stackPane = stackPane;
        this.roundKeyImgViw = roundKeyImgViw;
        this.sharedKeyImgViw = sharedKeyImgViw;
        this.dogImgViw = dogImgViw;
        this.textFlow = textFlow;
        this.poolImgViw1 = poolImgViw1;
        this.signatureVector = signatureVector;
        this.signatureVector1 = signatureVector1;
        this.signatureVector2 = signatureVector2;
        this.signatureVector3 = signatureVector3;
        this.signatureVector4 = signatureVector4;
        this.signatureVector5 = signatureVector5;
        this.signatureVector6 = signatureVector6;


        tranArrList = new ArrayList<Transition>();

        part1();
    }


    public void part1() {

        Text text = new Text("The Dining Cryptographers Protocol can be applied to any number of participants.");

        textFlow.getChildren().setAll(text);
        scaleTransition(2750.0, textFlow, 1.5, 1.5, 2, true);

        scaleTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                dogImgViw.setVisible(true);

                Text text = new Text("Every participant has a shared key with every other participant. Diffie Hellman key exchange protocol can be " +
                        "used to compute this.");

                textFlow.getChildren().setAll(text);
                scaleTransition(3000.0, textFlow, 1.5, 1.5, 2, true);


                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        Text text = new Text("The key values are placed into a vector. Note that the corresponding shared key in the same position will " +
                                "cancel this one.");

                        textFlow.getChildren().setAll(text);

                        signatureVector.setVisible(true);
                        signatureVector1.setVisible(true);
                        signatureVector2.setVisible(true);
                        signatureVector3.setVisible(true);
                        signatureVector4.setVisible(true);
                        signatureVector5.setVisible(true);
                        signatureVector6.setVisible(true);

                        roundKeyImgViw.setVisible(true);
                        translateTransitionX(2500.0, roundKeyImgViw, roundKeyImgViw.getX(), roundKeyImgViw.getX() + stackPane.getWidth() / 2, 1, false);
                        fadeTransition(2500.0, roundKeyImgViw, 1.0, 0.0, 1, false);

                        scaleTransition(2750.0, textFlow, 1.5, 1.5, 2, true);

                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                Text text = new Text("To broadcast a message the participant applies the function XOR on a random position in the vector.");
                                textFlow.getChildren().setAll(text);

                                scaleTransition(3000.0, textFlow, 1.5, 1.5, 2, true);

                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        signatureVector6.setText("key(dog,fish)XOR(M)");
                                        scaleTransition(3000.0, signatureVector6, 1.5, 1.5, 2, true);
                                        scaleTransition.setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {

                                                Text text = new Text("This altered vector is broadcasted, creating a pool of the collection of vectors- as all participants must broadcast their vectors," +
                                                        " regardless of whether they wish to broadcast a message in that round.");

                                                textFlow.getChildren().setAll(text);
                                                fadeTransition(3000.0, dogImgViw, 1.0, 0.0, 1, false);
                                                scaleTransition(3500.0, textFlow, 1.5, 1.5, 2, true);

                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent event) {

                                                        poolImgViw1.setVisible(true);
                                                        translateTransitionY(3000.0, signatureVector, signatureVector.getTranslateY(), signatureVector.getTranslateY() - stackPane.getHeight() / 2, 1, false);
                                                        fadeTransition(3000.0, signatureVector, 1.0, 0.0, 1, false);

                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                            @Override
                                                            public void handle(ActionEvent event) {

                                                                Text text1 = new Text("A new vector is formed containing the set of messages broadcast in that round- there can be at most n messages- where n is the " +
                                                                        "number of participants. Provided that all message position selections were unique, the new vector will contain all broadcasted messages of that round.");

                                                                textFlow.getChildren().setAll(text1);
                                                                fadeTransition(2750.0, poolImgViw1, 1.0, 0.0, 1, false);
                                                                scaleTransition(4750.0, textFlow, 1.5, 1.5, 2, true);

                                                                signatureVector1.setText("M");
                                                                signatureVector2.setText("M");
                                                                signatureVector3.setText("M");
                                                                signatureVector4.setText("M");
                                                                signatureVector5.setText("M");
                                                                signatureVector6.setText("M");

                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                    @Override
                                                                    public void handle(ActionEvent event) {


                                                                        fadeTransition(2000.0, signatureVector, 0.0, 1.0, 1, false);
                                                                        Text text = new Text("When two participants choose the same position vector to broadcast in, a collision occurs and their messages are " +
                                                                                "lost. A reservation round where they all agree on alloted slots, before broadcasting is a possible solution to this problem.");

                                                                        textFlow.getChildren().setAll(text);
                                                                        scaleTransition(3750.0, textFlow, 1.5, 1.5, 2, true);
                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                            @Override
                                                                            public void handle(ActionEvent event) {
                                                                                fadeTransition(2000.0, signatureVector, 1.0, 0.0, 1, false);


                                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                    @Override
                                                                                    public void handle(ActionEvent event) {

                                                                                        Text text = new Text("The End.");

                                                                                        textFlow.getChildren().setAll(text);

                                                                                    }
                                                                                });

                                                                            }
                                                                        });

                                                                    }
                                                                });
                                                            }
                                                        });


                                                    }
                                                });


                                            }
                                        });


                                    }
                                });

                            }
                        });

                    }
                });


            }
        });


    }

}
