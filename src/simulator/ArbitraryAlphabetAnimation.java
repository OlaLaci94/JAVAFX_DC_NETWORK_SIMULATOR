package simulator;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

/**
 * Created by Ola Laci on 23/04/2015.
 */
public class ArbitraryAlphabetAnimation extends Movement {

    Button backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn;
    StackPane stackPane;
    ImageView snakeImgViw, elephantImgViw, keyImgViw, keyImgViw1, poolImgViw, alphaImgViw;
    TextArea textArea, partialPad1,partialPad2,partialPad3,partialPad4,partialPad5,partialPad6;
    HBox vector;

    public ArbitraryAlphabetAnimation(Button backSimulatorBtn, Button pauseSimulatorBtn, Button playSimulatorBtn, StackPane stackPane,
                                      ImageView alphaImgViw, ImageView poolImgViw, ImageView snakeImgViw, ImageView elephantImgViw, ImageView keyImgViw, ImageView keyImgViw1, TextArea textArea,
                                      TextArea partialPad1, TextArea partialPad2, TextArea partialPad3, TextArea partialPad4, TextArea partialPad5,
                                      TextArea partialPad6, HBox vector)
    {
        this.backSimulatorBtn = backSimulatorBtn;
        this.pauseSimulatorBtn = pauseSimulatorBtn;
        this.playSimulatorBtn = playSimulatorBtn;
        this.stackPane = stackPane;
        this.snakeImgViw = snakeImgViw;
        this.elephantImgViw = elephantImgViw;
        this.poolImgViw = poolImgViw;
        this.textArea = textArea;
        this.keyImgViw = keyImgViw;
        this.keyImgViw1 = keyImgViw1;
        this.partialPad1 = partialPad1;
        this.partialPad2 = partialPad2;
        this.partialPad3 = partialPad3;
        this.partialPad4 = partialPad4;
        this.partialPad5 = partialPad5;
        this.partialPad6 = partialPad6;
        this.vector = vector;
        this.alphaImgViw = alphaImgViw;

        /**
         * illustration breakdown:
         *
         * Empty screen-- textfield saying parameter generation appears and cryptographers appear. -- textfield saying key generation appears and
         * visual of keys supplied to cryptographers. -- Message posting textfield appears and partial pad vecotor appears, then auzilary data appears.--
         * this is posted and combined with several other vectors-- verification function appears and shows how auxillary data works (ie zero knowledge
         * proof explanation-- message extraction: keys cancel each other out-- pad reconstruction: pooling all participants shred keys with participant i forms
         * pad reconstructed.
         */

        tranArrList = new ArrayList<Transition>();

        textArea.setText("The DC net illustrated will show the protocol details of transmitting an algebraic group element with unconditional anonymity" +
                " on a reliable broadcast channel. The protocol can work on any number of participants, and it is" +
                " assumed that messages have been authenticated  in some form-  digital signatures are commonly used in practice. This DC net" +
                " variant is also known as a short DC net.");
        part1();

    }

    public void part1(){

        scaleTransition(4500.0, textArea, 2.0, 2.0, 2, true);
        scaleTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                elephantImgViw.setVisible(true);

                rotateTransition(1500.0, elephantImgViw, 1, 0.0, 180.0, 1, false);
                textArea.setText("A trusted entity- the elephant- executes the parameter generation function which outputs the set of parameters required for setup. ");

                scaleTransition(3500.0, textArea, 1.5, 1.5, 2, true);

                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        fadeTransition(1000.0, elephantImgViw, 1.0, 0.0, 1, false);
                        snakeImgViw.setVisible(true);
                        rotateTransition(1500.0, snakeImgViw, 1, 0.0, 360.0, 1, true);
                        textArea.setText("The snake represents every participant in the session and so each participant will follow this protocol.");
                        scaleTransition(2500.0, textArea, 1.5, 1.5, 2, true);

                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                textArea.setText("Key generation function yields a private and complementary public key for each participant. Each private " +
                                        "key is shared with a corresponding participant to form the shared key pair.");
                                scaleTransition(3500.0, textArea, 1.5, 1.5, 2, true);
                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        keyImgViw.setVisible(true);
                                        scaleTransition(1000.0, keyImgViw, 1.25, 1.25, 2, true);

                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {

                                                textArea.setText("Each participant computes a partial pad with every other participant. The vector these partial pads are " +
                                                        "contained in are known as a vector.");

                                                keyImgViw.setVisible(false);

                                                scaleTransition(2500.0, textArea, 1.75, 1.75, 2, true);
                                                vector.setVisible(true);
                                                partialPad1.setVisible(true);
                                                partialPad2.setVisible(true);
                                                partialPad3.setVisible(true);
                                                partialPad4.setVisible(true);
                                                partialPad5.setVisible(true);
                                                partialPad6.setVisible(true);

                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent event) {
                                                        scaleTransition(1500.0, vector, 1.25, 1.25, 2, true);

                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                            @Override
                                                            public void handle(ActionEvent event) {
                                                                textArea.setText("They choose a random partial pad and apply the XOR function of its value with the message they wish to broadcast. The new vector is now called the " +
                                                                        "output vector.");

                                                                scaleTransition(2500.0, textArea, 1.25, 1.25, 2, true);

                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                    @Override
                                                                    public void handle(ActionEvent event) {


                                                                        partialPad6.setText("M XOR W(snake,cat)");
                                                                        scaleTransition(2000.0, partialPad6, 1.5, 1.5, 2, true);

                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                            @Override
                                                                            public void handle(ActionEvent event) {

                                                                                textArea.setText("Some subsidiary data is then computed consisting of the participants identity and a valid proof of the correctness of " +
                                                                                        "the vector. This subsidiary data is posted with the output data. The participants pool all of their output data.");
                                                                                scaleTransition(3500.0, textArea, 1.5, 1.5, 2, true);

                                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                    @Override
                                                                                    public void handle(ActionEvent event) {
                                                                                        alphaImgViw.setVisible(true);
                                                                                        scaleTransition(1500.0, alphaImgViw, 1.25, 1.25, 2, true);

                                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                            @Override
                                                                                            public void handle(ActionEvent event) {
                                                                                                poolImgViw.setVisible(true);
                                                                                                textArea.setVisible(false);
                                                                                                translateTransitionY(3500.0, vector, vector.getTranslateY(), vector.getTranslateY() - stackPane.getWidth() / 5, 1, false);
                                                                                                fadeTransition(3500.0, vector, 1.0, 0.0, 1, false);
                                                                                                translateTransitionY(3500.0, alphaImgViw, alphaImgViw.getTranslateY(), alphaImgViw.getTranslateY() - stackPane.getWidth() / 5, 1, false);
                                                                                                fadeTransition(3500.0, alphaImgViw, 1.0, 0.0, 1, false);

                                                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                    @Override
                                                                                                    public void handle(ActionEvent event) {
                                                                                                        poolImgViw.setVisible(false);
                                                                                                        System.out.println("textarea.setVisible(true)");
                                                                                                        textArea.setVisible(true);
                                                                                                        textArea.setText("A verification function can be called to verify the output vector- using the subsidiary data provided, which outputs " +
                                                                                                                "1 if it is indeed valid. This function can be called by any player.");
                                                                                                        scaleTransition(3000.0, textArea, 1.5, 1.5, 2, true);

                                                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                            @Override
                                                                                                            public void handle(ActionEvent event) {
                                                                                                                textArea.setText("Once all participants have posted, the set of messages broadcast can be extracted using the necessary mathematical proofs, creating a vector of the set of messages.");
                                                                                                                scaleTransition(2000.0, textArea, 1.5, 1.5, 2, true);
                                                                                                                partialPad1.setText("MESSAGE");
                                                                                                                partialPad2.setText("MESSAGE");
                                                                                                                partialPad3.setText("MESSAGE");
                                                                                                                partialPad4.setText("MESSAGE");
                                                                                                                partialPad5.setText("MESSAGE");
                                                                                                                partialPad6.setText("MESSAGE");
                                                                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                    @Override
                                                                                                                    public void handle(ActionEvent event) {
                                                                                                                        poolImgViw.setVisible(true);
                                                                                                                        textArea.setVisible(false);
                                                                                                                        translateTransitionY(3500.0, vector, vector.getTranslateY(), vector.getTranslateY() + stackPane.getWidth() / 5, 1, false);
                                                                                                                        fadeTransition(3500.0, vector, 0.0, 1.0, 1, false);



                                                                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                    @Override
                                                                                                                    public void handle(ActionEvent event) {

                                                                                                                        poolImgViw.setVisible(false);
                                                                                                                        System.out.println("textarea.setVisible(true)");
                                                                                                                        textArea.setVisible(true);

                                                                                                                        textArea.setText("If a participant failed to broadcast, the honest participants can pool their shared partial pads with the dishonest " +
                                                                                                                                "participants to reconstruct the missing vector. Anyone can verify the correctness of these values.");

                                                                                                                        scaleTransition(3000.0, textArea, 2.0,2.0,2,true);
//
                                                                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                            @Override
                                                                                                                            public void handle(ActionEvent event) {
                                                                                                                                textArea.setText("The End.");
                                                                                                                                scaleTransition(2000.0, textArea,2.0,2.0,2,true);

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

                                    }
                                });

                            }
                        });

                    }
                });

//                textArea.setText("The DC net is assembled using a parameter generation function by a trusted entity- which satisfies the " +
//                        "Decisional Bilinear Diffie Hellman problem - and therefore uses both admissible linear maps and elliptic curve " +
//                        "based algebraic groups. The key generation is performed using a function which takes in a specification parameter- " +
//                        "one for each participant, then produces and distributes a public and secret key for each participant. Each private key " +
//                        "is shared between two participants i and j- creating key(i,j).");
//
//                textArea.setText("Each participant is assumed to have a trustworthy global counter of the session and a specification containing all participants " +
//                        "this session");
//
//                textArea.setText("Every participant of the session then posts the output vector and subsidiary data; the output vector consists of " +
//                        "the pad with one partial pad which contains the generated key XOR the MESSAGE that the participant wishes to post; the subsidiary " +
//                        "data contains the participants identity and proof of the posted vectors correctness.");
//
//                textArea.setText("Message extraction is performed taking the output vectors of all participants and computing the necessary inverse " +
//                        "equations which outputs the set of messages- which contains at most n messages- where n is the number of participants.");
//
//                textArea.setText("If any participants fail to produce a correct output vector - or do not output a vector- the set of other players can " +
//                        "produce a correct output vector by combining their shared keys with the missing participant. Polynomial interpolation allows any "+
//                "participant to recompute the pads of the missing participant.");
//
//                textArea.setText("This showcases how to maintain the non interactivity feature of DC nets while maintaining high detection " +
//                        "and identification of cheating players with a fault recovery overhead of only one additional broadcast round.");
            }
        });



    }
}
