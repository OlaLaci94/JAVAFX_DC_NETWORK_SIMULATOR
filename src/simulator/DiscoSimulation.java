package simulator;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;

/**
 *
 */
public class DiscoSimulation extends Movement {

    Button backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn;
    StackPane stackPane;
    ImageView snakeImgViw, elephantImgViw, clawImgViw, treeImgViw, hImgViw, thetaImgViw, messageImgViw;
    TextArea textArea, signatureVector1, signatureVector2, signatureVector3, signatureVector4, signatureVector5, signatureVector6;
    HBox signatureVector;

    public DiscoSimulation(Button backSimulatorBtn, Button pauseSimulatorBtn, Button playSimulatorBtn, StackPane stackPane, ImageView messageImgViw, ImageView thetaImgViw,
                           ImageView snakeImgViw, ImageView elephantImgViw, TextArea textArea, HBox signatureVector, TextArea signatureVector1,
                           TextArea signatureVector2, TextArea signatureVector3, TextArea signatureVector4, TextArea signatureVector5,
                           TextArea signatureVector6, ImageView clawImgViw, ImageView treeImgViw, ImageView hImgViw) {


        this.backSimulatorBtn = backSimulatorBtn;
        this.pauseSimulatorBtn = pauseSimulatorBtn;
        this.playSimulatorBtn = playSimulatorBtn;
        this.stackPane = stackPane;
        this.snakeImgViw = snakeImgViw;
        this.elephantImgViw = elephantImgViw;
        this.textArea = textArea;
        this.signatureVector = signatureVector;
        this.signatureVector1 = signatureVector1;
        this.signatureVector2 = signatureVector2;
        this.signatureVector3 = signatureVector3;
        this.signatureVector4 = signatureVector4;
        this.signatureVector5 = signatureVector5;
        this.signatureVector6 = signatureVector6;
        this.clawImgViw = clawImgViw;
        this.treeImgViw = treeImgViw;
        this.hImgViw = hImgViw;
        this.thetaImgViw = thetaImgViw;
        this.messageImgViw = messageImgViw;

        tranArrList = new ArrayList<Transition>();

        textArea.setText("The following illustration will showcase how to achieve computationally secure serviceability  " +
                "and unconditional untraceability on messages of arbitrary length. This is implemented through the use of digital signatures and claw free " +
                "permutation pairs, and a hash function. This scheme was created to prevent honest participants from being incorrectly labelled as dishonest- " +
                "and consequently removed from the group, and ensuring that any honest participant can broadcast a message " +
                "successfully within a period of time.");

        part1();

    }


    public void part1() {

        scaleTransition(6500.0, textArea, 2.0, 2.0, 2, true);
        scaleTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.setText("Each participant uses two distinct generators to create a claw free pair and then publishes them- including a zero " +
                        "knowledge proof of its correctness- for each participant pair, that it exists in. If other participants deem this proof as incorrect, they will " +
                        "be labelled an attacker and dealt with accordingly.");
                scaleTransition(3750.0, textArea, 1.75, 1.75, 2, true);


                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        clawImgViw.setVisible(true);
                        rotateTransition(500.0, clawImgViw, 1, 0.0, 180.0, 1, false);
                        System.out.println("clawimg: " + clawImgViw);

                        translateTransitionX(3000.0, clawImgViw, clawImgViw.getTranslateX(), clawImgViw.getTranslateX() - stackPane.getWidth() / 1.5, 1, false);
                        fadeTransition(3000.0, clawImgViw, 1.0, 0.0, 1, false);
//                        rotateTransition(1800.0, clawImgViw, 1, 0.0,360.0, 1, true);

                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                                textArea.setText("Each participant computes an authentication tree for one time signatures for every other participant in the session and " +
                                        "publishes the root.");
                                treeImgViw.setVisible(true);
                                scaleTransition(2750.0, textArea, 1.85, 1.85, 2, true);

                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        scaleTransition(2000.0, treeImgViw, 1.25, 1.25, 2, true);

                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {
                                                fadeTransition(500.0, treeImgViw, 1.0, 0.0, 1, false);
                                                textArea.setText("The snake wants to sign a message of length n. The hash function takes the message as input to produce a message " +
                                                        "with a fixed length. This is the protocol used to send messages of arbitrary length in a DC network. ");

                                                scaleTransition(3000.0, textArea, 2.0, 2.0, 2, true);
                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent event) {
                                                        messageImgViw.setVisible(true);
                                                        hImgViw.setVisible(true);
                                                        translateTransitionX(4000.0, hImgViw, hImgViw.getTranslateX(), hImgViw.getTranslateX() + (stackPane.getWidth() / 5) * 4, 1, false);
                                                        rotateTransition(1000.0, hImgViw, 1, 0.0, 360.0, 4, true);

                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                            @Override
                                                            public void handle(ActionEvent event) {
                                                                messageImgViw.setVisible(false);
                                                                hImgViw.setVisible(false);
                                                                thetaImgViw.setVisible(true);
                                                                scaleTransition(1000.0, thetaImgViw, 1.2, 1.2, 1, true);

                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                    @Override
                                                                    public void handle(ActionEvent event) {
                                                                        textArea.setText("The new message (theta) is then inputed into an encoding function which computes the signature as a whole- and the specific " +
                                                                                "parts for each participant.");
                                                                        fadeTransition(1000.0, thetaImgViw, 1.0, 0.0, 1, false);
                                                                        scaleTransition(2500.0, textArea, 1.9, 1.9, 1, true);


                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                            @Override
                                                                            public void handle(ActionEvent event) {

                                                                                signatureVector.setVisible(true);
                                                                                signatureVector1.setVisible(true);
                                                                                signatureVector2.setVisible(true);
                                                                                signatureVector3.setVisible(true);
                                                                                signatureVector4.setVisible(true);
                                                                                signatureVector5.setVisible(true);
                                                                                signatureVector6.setVisible(true);
                                                                                textArea.setText("Every receiver of the message can now check the authenticity of the message by checking their specific segment " +
                                                                                        "of the signature and other public values");
                                                                                scaleTransition(2500.0, signatureVector, 1.25, 1.25, 2, true);

                                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                    @Override
                                                                                    public void handle(ActionEvent event) {
                                                                                        textArea.setText("Each honest participant who receives a signature from the snake sends it back. If an honest participant receives a forged " +
                                                                                                "signature, they will compare the forged signature with the corresponding correct signature, identifying any collisions with the correct " +
                                                                                                "signature. Any collisions found are published and honest participants accept the proof of forgery if the collisions proof can be " +
                                                                                                "substantiated. ");

                                                                                        scaleTransition(5500.0, textArea, 1.75, 1.75, 2, true);

                                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                            @Override
                                                                                            public void handle(ActionEvent event) {

                                                                                                translateTransitionX(2000.0, signatureVector, signatureVector.getTranslateX(), signatureVector.getTranslateX() + stackPane.getWidth() / 2, 1, false);
                                                                                                fadeTransition(2000.0, signatureVector, 1.0, 0.0, 1, false);

                                                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                    @Override
                                                                                                    public void handle(ActionEvent event) {
                                                                                                        textArea.setText("The End.");
                                                                                                        scaleTransition(2500.0, textArea, 2.0, 2.0, 2, true);
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
                });


            }
        });


//
//        textArea.setText("A participant signs a message by creating a signature that can be divided into the number of other participants. Each " +
//                "distinct section is proof for a specific participant in the session.");
//
//        textArea.setText("Each participant which receives a message can check and authenticate the correctness of the components known to them, " +
//                "but all the while maintaining unconditional sender and receiver untraceability.");
//
//        textArea.setText("Each honest participant who receives a signature, sends it back to the sender. If an honest participant receives a forged " +
//                "signature, they will compare the forged signature with the corresponding correct signature, identifying any collisions with the correct signature. " +
//                "Any collisions found are published and honest participants accept the proof of forgery if the collisions proof can be substantiated. ");
//
//
//        textArea.setText("If a participant is labelled an attacker, first offenders will usually lose specific keys- as everyone deserves a second " +
//                "chance. However second and multiple offenders are usually removed from the session altogether.");
    }


}
