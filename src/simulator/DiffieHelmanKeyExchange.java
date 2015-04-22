package simulator;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

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


        tranArrList = new ArrayList<Transition>();

        textArea.setText("DC- nets were initially created assuming a reliable broadcast network. This is however computationally unrealistic." +
                "The keys (coin toss) must be kept secret or unconditional security cannot be maintained. So, we use a public key scheme- known " +
                "as the Diffie-Hellman key exchange. We shall see how the elephant and snake can share a key in a secure manner even over an insecure channel.");


        part1();


    }


    public void part1(){

        rotateTransition(500.0, elephantImgViw,1,0.0,180.0,1,false);
        scaleTransition(7000.0, textArea,2.0,2.0,2,true);
        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fadeTransition(1000.0, dogImgViw, 1.0,0.0,1,false);
                scaleTransition(1000.0, elephantImgViw, 1.25, 1.25, 1, true);
                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        elephantTextArea.setVisible(true);
                        elephantTextArea.setText("Chooses a prime number p and an integer i. The elephant then sends these two values to the snake - " +
                                "over the insecure channel so the dog (and others) may have access to these values");
                        scaleTransition(2500.0, elephantTextArea, 1.5,1.5,1, true);
                        sleeping(1000.0);
                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                textArea.setText("The elephant and snake each generate a random number(less than p)- referred to as E and S respectively.");
                                scaleTransition(3000.0, textArea, 1.5,1.5,1,true);
                                sleeping(1000.0);
                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        elephantTextArea.setText("Computes (i^E mod p) and sends this to the snake over the insecure channel.");
                                        scaleTransition(2500.0, elephantTextArea, 1.25,1.25,1, true);
                                        sleeping(1000.0);
                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {
                                                sleeping(1000.0);
                                                snakeTextArea.setVisible(true);
                                                scaleTransition(1000.0, snakeImgViw, 1.25, 1.25, 1, true);
                                                snakeTextArea.setText("Computes (i^S mod p) and sends this to the elephant over the insecure channel.");
                                                scaleTransition(2500.0, snakeTextArea, 1.25,1.25,1, true);
                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent event) {
                                                        sleeping(1000.0);
                                                        snakeTextArea.setText("Now the snake can securely know the key by computing: ((i^E mod p)^S mod p).");
                                                        scaleTransition(2500.0, snakeTextArea, 1.25,1.25,1, true);
                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                            @Override
                                                            public void handle(ActionEvent event) {
                                                                sleeping(1000.0);
                                                                elephantTextArea.setText("Now the elephant can securely know the key by computing: ((i^S mod p)^E mod p)).");
                                                                scaleTransition(2500.0, elephantTextArea, 1.25,1.25,1, true);
                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                    @Override
                                                                    public void handle(ActionEvent event) {

                                                                       textArea.setText("This protocol allows the elephant and snake to generate and share the key over an insecure channel " +
                                                                               "while knowing that the dog- and anyone else - cannot feasibly compute their shared key. This is the most " +
                                                                               "desirable form of key exchange that will be assumed throughout these illustrations. However, there are obviously" +
                                                                               "other key generation and exchange protocols. ");
                                                                        scaleTransition(2500.0, textArea, 2.0,2.0,1, true);
                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                            @Override
                                                                            public void handle(ActionEvent event) {

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
