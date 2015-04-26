package simulator;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

/**
 * Created by Ola Laci on 26/04/2015.
 */
public class BinaryAnimation extends Movement {

    Button backSimulatorBtn, playSimulatorBtn, pauseSimulatorBtn;
    TextFlow textFlow;
    ImageView dogImgViw, elephantImgViw, dogPublicKey, elephantPublicKey, messageImgViw, poolImgViw, roundKeysImgViw, thetaImgViw;
    StackPane stackPane;

    public BinaryAnimation(Button backSimulatorBtn, Button playSimulatorBtn,Button pauseSimulatorBtn, TextFlow textFlow, ImageView dogImgViw,
                           ImageView elephantImgViw, ImageView dogPublicKey, ImageView elephantPublicKey,  ImageView messageImgViw,
                           StackPane stackPane, ImageView poolImgViw, ImageView roundKeysImgViw, ImageView thetaImgViw)
    {

        this.backSimulatorBtn = backSimulatorBtn;
        this.pauseSimulatorBtn = pauseSimulatorBtn;
        this.playSimulatorBtn = playSimulatorBtn;
        this.stackPane = stackPane;
        this.textFlow = textFlow;
        this.elephantImgViw = elephantImgViw;
        this.dogImgViw = dogImgViw;
        this.textFlow = textFlow;
        this.dogPublicKey = dogPublicKey;
        this.messageImgViw = messageImgViw;
        this.elephantPublicKey = elephantPublicKey;
        this.poolImgViw = poolImgViw;
        this.roundKeysImgViw = roundKeysImgViw;
        this.thetaImgViw = thetaImgViw;

        tranArrList = new ArrayList<Transition>();

        simulation();





    }


    public void simulation(){


        fadeTransition(100.0, dogImgViw,1.0,0.0,1,false);
        fadeTransition(100.0, dogPublicKey,1.0,0.0,1,false);
        fadeTransition(100.0, elephantPublicKey,1.0,0.0,1,false);
        fadeTransition(100.0, poolImgViw,1.0,0.0,1,false);
        fadeTransition(100.0, roundKeysImgViw,1.0,0.0,1,false);
        fadeTransition(100.0, messageImgViw,1.0,0.0,1,false);
        fadeTransition(100.0, thetaImgViw,1.0,0.0,1,false);
        fadeTransition(100.0, poolImgViw,1.0,0.0,1,false);

        Text text = new Text("This illustration will demonstrate how the XOR function operates and how it is used in the Dining Cryptographers protocol.");

        textFlow.getChildren().setAll(text);
        scaleTransition(3050.0, textFlow, 1.5,1.5,2,true);
        scaleTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                Text text = new Text("Each participant will agree on a secret shared key with every other participant. The Diffie Hellman Key Exchange " +
                        "Protocol is commonly used in practice. ");

                textFlow.getChildren().setAll(text);
                fadeTransition(2000.0, dogImgViw,0.0,1.0,1,false);
                scaleTransition(3050.0, textFlow, 1.5,1.5,2,true);

                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        fadeTransition(2000.0, dogPublicKey,0.0,1.0,1,false);
                        fadeTransition(2000.0, elephantPublicKey,0.0,1.0,1,false);

                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                                Text text = new Text("A ciphertext will be produced from computing the sum of all of the participants shared secret keys.");

                                textFlow.getChildren().setAll(text);
                                scaleTransition(3050.0, textFlow, 1.5,1.5,2,true);

                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        translateTransitionX(2000.0, dogPublicKey, dogPublicKey.getX(), dogPublicKey.getX()+stackPane.getWidth()/2, 1, false);
                                        translateTransitionX(2000.0, elephantPublicKey, dogPublicKey.getX(), dogPublicKey.getX()-stackPane.getWidth()/2, 1, false);

                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {

                                                fadeTransition(1000.0, dogPublicKey, 1.0,0.0,1,false);
                                                fadeTransition(1000.0, elephantPublicKey, 1.0,0.0,1,false);
                                                fadeTransition(2000.0, roundKeysImgViw, 0.0,1.0,1,false);

                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent event) {

                                                        Text text = new Text("If the participant wishes to broadcast a message, they add the message to the ciphertext- altering the ciphertext (theta)");

                                                        textFlow.getChildren().setAll(text);
                                                        scaleTransition(3050.0, textFlow, 1.5,1.5,2,true);

                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                            @Override
                                                            public void handle(ActionEvent event) {

                                                                fadeTransition(2000.0, messageImgViw,0.0,1.0,1,false);
                                                                translateTransitionY(2500.0, roundKeysImgViw, roundKeysImgViw.getY(), roundKeysImgViw.getY() + (stackPane.getHeight() / 3)*2, 1, false);

                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                    @Override
                                                                    public void handle(ActionEvent event) {
                                                                        fadeTransition(2500.0, roundKeysImgViw,1.0,0.0,1,false);
                                                                        fadeTransition(2500.0, messageImgViw,1.0,0.0,1,false);

                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                            @Override
                                                                            public void handle(ActionEvent event) {

                                                                                fadeTransition(500.0, thetaImgViw,0.0,1.0,1,false);

                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                    @Override
                                                                                    public void handle(ActionEvent event) {

                                                                                        Text text = new Text("Every participant must broadcast their ciphertext- whether they are broadcasting a message or not. These ciphertexts are pooled together and the XOR function is applied.");


                                                                                        textFlow.getChildren().setAll(text);
                                                                                        scaleTransition(3050.0, textFlow, 1.5,1.5,2,true);

                                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                            @Override
                                                                                            public void handle(ActionEvent event) {

                                                                                                fadeTransition(1000.0, poolImgViw,0.0,1.0,1,false);

                                                                                                translateTransitionY(2000.0, thetaImgViw, thetaImgViw.getY(), thetaImgViw.getY()-(stackPane.getHeight()/3)*2,1,false);
                                                                                                fadeTransition(2000.0, thetaImgViw, 1.0,0.0,1,false);

                                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                    @Override
                                                                                                    public void handle(ActionEvent event) {

                                                                                                        fadeTransition(1000.0, poolImgViw,1.0,0.0,1,false);
                                                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                            @Override
                                                                                                            public void handle(ActionEvent event) {
                                                                                                                Text text = new Text("The XOR function causes the keys to cancel - as each key is inputed twice. Leaving only the message.");


                                                                                                                textFlow.getChildren().setAll(text);
                                                                                                                scaleTransition(3750.0, textFlow, 1.5,1.5,2,true);

                                                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                    @Override
                                                                                                                    public void handle(ActionEvent event) {
                                                                                                                        Text text = new Text("Note that if more than one message is transmitted- a collision occurs- Message extraction is impossible.");


                                                                                                                        textFlow.getChildren().setAll(text);
                                                                                                                        scaleTransition(3750.0, textFlow, 1.5,1.5,2,true);

                                                                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
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
