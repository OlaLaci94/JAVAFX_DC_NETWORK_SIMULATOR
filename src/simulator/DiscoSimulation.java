package simulator;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

/**
 *
 */
public class DiscoSimulation extends Movement {

    Button  pauseSimulatorBtn, playSimulatorBtn, backSimulatorBtn;
    HBox signatureVector;
    TextFlow textFlow;
    StackPane stackPane;
    ImageView dogCryptographer, gImgViw, messageImgViw, piImgViw, eImgViw, hImgViw, functionImgViw, treeImgViw;
    TextArea signatureVector1, signatureVector2,signatureVector3,signatureVector4,signatureVector5,signatureVector6;

    public DiscoSimulation(Button pauseSimulatorBtn, Button playSimulatorBtn, Button backSimulatorBtn, HBox signatureVector,TextFlow textFlow,
                           StackPane stackPane,ImageView dogCryptographer,ImageView gImgViw,ImageView messageImgViw,ImageView piImgViw,
                           ImageView eImgViw,ImageView hImgViw,ImageView functionImgViw,ImageView treeImgViw,TextArea signatureVector1,
                           TextArea signatureVector2,TextArea signatureVector3,TextArea signatureVector4,TextArea signatureVector5,TextArea signatureVector6) {


        this.backSimulatorBtn = backSimulatorBtn;
        this.pauseSimulatorBtn = pauseSimulatorBtn;
        this.playSimulatorBtn = playSimulatorBtn;
        this.stackPane = stackPane;
        this.dogCryptographer = dogCryptographer;
        this.gImgViw = gImgViw;
        this.textFlow = textFlow;
        this.signatureVector = signatureVector;
        this.signatureVector1 = signatureVector1;
        this.signatureVector2 = signatureVector2;
        this.signatureVector3 = signatureVector3;
        this.signatureVector4 = signatureVector4;
        this.signatureVector5 = signatureVector5;
        this.signatureVector6 = signatureVector6;
        this.piImgViw = piImgViw;
        this.treeImgViw = treeImgViw;
        this.hImgViw = hImgViw;
        this.eImgViw = eImgViw;
        this.messageImgViw = messageImgViw;
        this.functionImgViw = functionImgViw;

        tranArrList = new ArrayList<Transition>();

//        textArea.setText("The following illustration will showcase how to achieve computationally secure serviceability  " +
//                "and unconditional untraceability on messages of arbitrary length. This is implemented through the use of digital signatures and claw free " +
//                "permutation pairs, and a hash function. This scheme was created to prevent honest participants from being incorrectly labelled as dishonest- " +
//                "and consequently removed from the group, and ensuring that any honest participant can broadcast a message " +
//                "successfully within a period of time.");

//        part1();

        animationPart1();
    }



    public void animationPart1(){

        fadeTransition(100.0, dogCryptographer, 1.0,0.0,1,false);
        fadeTransition(100.0, gImgViw, 1.0,0.0,1,false);
        fadeTransition(100.0, messageImgViw, 1.0,0.0,1,false);
        fadeTransition(100.0, piImgViw, 1.0,0.0,1,false);
        fadeTransition(100.0, eImgViw, 1.0,0.0,1,false);
        fadeTransition(100.0, hImgViw, 1.0,0.0,1,false);
        fadeTransition(100.0, functionImgViw, 1.0,0.0,1,false);
        fadeTransition(100.0, treeImgViw, 1.0,0.0,1,false);


        Text text = new Text("This illustration will showcase how the dining cryptographer protocol can be executed without the reliable broadcast " +
                "assumption, while still ensuring unconditional untraceability and computationally secure serviceability.");

        textFlow.getChildren().setAll(text);
        scaleTransition(4500.0, textFlow, 1.5,1.5,2,true);
        scaleTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Text text = new Text("A variant of the hiding function (theta) generator provides each participant with two hiding functions for each other participant " +
                        "in the session");
                Text text1 = new Text(" (pi");
                text1.setFill(Color.AQUA);
                Text text2 = new Text(" and sigma).");
                fadeTransition(3500.0, dogCryptographer, 0.0, 1.0, 1, false);

                textFlow.getChildren().setAll(text, text1, text2);
                scaleTransition(4500.0, textFlow, 1.5,1.5,2,true);
                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        fadeTransition(1500.0, gImgViw, 0.0,1.0,1,false);

                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                                fadeTransition(1500.0, eImgViw, 0.0,1.0,1,false);
                                fadeTransition(1500.0, piImgViw, 0.0,1.0,1,false);

                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        Text text = new Text("A variant of the ");
                                        Text text1 = new Text("hash generator ");
                                        text1.setFill(Color.GREENYELLOW);
                                        Text text2 = new Text("provides each participant with a hash function ");

                                        textFlow.getChildren().setAll(text, text1, text2);
                                        scaleTransition(4500.0, textFlow, 1.5,1.5,2,true);

                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {
                                                fadeTransition(1500.0, hImgViw, 0.0,1.0,1,false);

                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent event) {

                                                        fadeTransition(1500.0, gImgViw, 1.0,0.0,1,false);
                                                        fadeTransition(1500.0, eImgViw, 1.0,0.0,1,false);
                                                        fadeTransition(1500.0, piImgViw, 1.0,0.0,1,false);
                                                        fadeTransition(1500.0, hImgViw, 1.0,0.0,1,false);

                                                        Text text = new Text("Each participant sends a zero knowledge proof to each other participant " +
                                                                "it is in a pair with, proving the validity of the hiding functions. ");

                                                        textFlow.getChildren().setAll(text);
                                                        scaleTransition(4500.0, textFlow, 1.5,1.5,2,true);

                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                            @Override
                                                            public void handle(ActionEvent event) {

                                                                fadeTransition(2000.0, treeImgViw,0.0,1.0,1,false);
                                                                Text text = new Text("Each participant computes an authentication tree of one time signatures for every other participant in the session " +
                                                                        "and publishes the root. ");

                                                                textFlow.getChildren().setAll(text);
                                                                scaleTransition(4500.0, textFlow, 1.5,1.5,2,true);

                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                    @Override
                                                                    public void handle(ActionEvent event) {

                                                                        Text text = new Text("To sign a message of arbitrary length, the message undergoes a hash function.");
                                                                        fadeTransition(2000.0, treeImgViw, 1.0,0.0,1,false);
                                                                        fadeTransition(2000.0, messageImgViw, 0.0,1.0,1,false);
                                                                        fadeTransition(2000.0, hImgViw, 0.0,1.0,1,false);

                                                                        textFlow.getChildren().setAll(text);
                                                                        scaleTransition(4500.0, textFlow, 1.5,1.5,2,true);
                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                            @Override
                                                                            public void handle(ActionEvent event) {

                                                                                translateTransitionX(2000.0, hImgViw, hImgViw.getX(), hImgViw.getX()-stackPane.getWidth()/2, 1 ,false);

                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                    @Override
                                                                                    public void handle(ActionEvent event) {

                                                                                        Text text = new Text("The message is then inputed into an encoding function which alters the message" +
                                                                                                " to consist of the message and subsidiary data that can authenticate message- with respect to the root " +
                                                                                                "of the authentication tree of that specific recipient");

                                                                                        fadeTransition(500.0, hImgViw, 1.0,0.0,1,false);

                                                                                        textFlow.getChildren().setAll(text);
                                                                                        scaleTransition(4500.0, textFlow, 1.5,1.5,2,true);

                                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                            @Override
                                                                                            public void handle(ActionEvent event) {

                                                                                                fadeTransition(1500.0, functionImgViw,0.0,1.0,1,false);
                                                                                                translateTransitionX(2500.0, messageImgViw,messageImgViw.getX(), messageImgViw.getX()+stackPane.getWidth()/2,1,false);

                                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                    @Override
                                                                                                    public void handle(ActionEvent event) {


                                                                                                        fadeTransition(1000.0, messageImgViw,1.0,0.0,1,false);
                                                                                                        Text text = new Text("Remember, this is repeated with slightly different values for each participant. The output of the encoding functions " +
                                                                                                                "are now placed in a vector which is broadcast to every participant in the session.");

                                                                                                        fadeTransition(500.0, messageImgViw, 1.0,0.0,1,false);

                                                                                                        textFlow.getChildren().setAll(text);
                                                                                                        scaleTransition(4500.0, textFlow, 1.5,1.5,2,true);

                                                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                            @Override
                                                                                                            public void handle(ActionEvent event) {

                                                                                                                signatureVector.setVisible(true);
                                                                                                                signatureVector1.setVisible(true);
                                                                                                                signatureVector2.setVisible(true);
                                                                                                                signatureVector3.setVisible(true);
                                                                                                                signatureVector4.setVisible(true);
                                                                                                                signatureVector5.setVisible(true);
                                                                                                                signatureVector6.setVisible(true);

                                                                                                                translateTransitionX(1250.0, functionImgViw, functionImgViw.getX(), functionImgViw.getX()-stackPane.getWidth()/3,1,false);

                                                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                    @Override
                                                                                                                    public void handle(ActionEvent event) {

                                                                                                                        translateTransitionY(2000.0, functionImgViw, functionImgViw.getY(), functionImgViw.getY()+stackPane.getHeight(),1,false);
                                                                                                                        fadeTransition(2000.0, functionImgViw, 1.0,0.0,1,false);

                                                                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                            @Override
                                                                                                                            public void handle(ActionEvent event) {

                                                                                                                                signatureVector1.setText("M");
                                                                                                                                signatureVector2.setText("M");
                                                                                                                                signatureVector3.setText("M");
                                                                                                                                signatureVector4.setText("M");
                                                                                                                                signatureVector5.setText("M");
                                                                                                                                signatureVector6.setText("M");

                                                                                                                                scaleTransition(2000.0, signatureVector, 1.5,1.5,1,false);

                                                                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                                    @Override
                                                                                                                                    public void handle(ActionEvent event) {

                                                                                                                                        fadeTransition(1000.0, signatureVector,1.0,0.0,1,false);
                                                                                                                                        Text text = new Text("All participants access the message by looking in the signature of the " +
                                                                                                                                                "vector specifically created for them. They authenticate the message and then send the signature back.");

                                                                                                                                        textFlow.getChildren().setAll(text);
                                                                                                                                        scaleTransition(4500.0, textFlow, 1.5,1.5,2,true);

                                                                                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                                            @Override
                                                                                                                                            public void handle(ActionEvent event) {
                                                                                                                                                Text text = new Text("The participant that created the signature checks his original values to ensure there were no collisions- meaning that his " +
                                                                                                                                                        "signature has not been forged at any point. If a collision has occurred, all participants accept that the signature scheme has been forged. ");

                                                                                                                                                textFlow.getChildren().setAll(text);
                                                                                                                                                scaleTransition(4500.0, textFlow, 1.5,1.5,2,true);

                                                                                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                                                    @Override
                                                                                                                                                    public void handle(ActionEvent event) {
                                                                                                                                                        Text text = new Text("If at any point during this scenario, authentication does not succeed, or proof of forgery emerges, the protocol is broken " +
                                                                                                                                                                "and participants stop transmitting.");

                                                                                                                                                        textFlow.getChildren().setAll(text);
                                                                                                                                                        scaleTransition(4500.0, textFlow, 1.5,1.5,2,true);

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
                                });


                            }
                        });
                    }
                });

            }
        });

    }
//    public void part1() {
//
//        scaleTransition(6500.0, textArea, 2.0, 2.0, 2, true);
//        scaleTransition.setOnFinished(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                textArea.setText("Each participant uses two distinct generators to create a claw free pair and then publishes them- including a zero " +
//                        "knowledge proof of its correctness- for each participant pair, that it exists in. If other participants deem this proof as incorrect, they will " +
//                        "be labelled an attacker and dealt with accordingly.");
//                scaleTransition(3750.0, textArea, 1.75, 1.75, 2, true);
//
//
//                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(ActionEvent event) {
//
//                        clawImgViw.setVisible(true);
//                        rotateTransition(500.0, clawImgViw, 1, 0.0, 180.0, 1, false);
//                        System.out.println("clawimg: " + clawImgViw);
//
//                        translateTransitionX(3000.0, clawImgViw, clawImgViw.getTranslateX(), clawImgViw.getTranslateX() - stackPane.getWidth() / 1.5, 1, false);
//                        fadeTransition(3000.0, clawImgViw, 1.0, 0.0, 1, false);
////                        rotateTransition(1800.0, clawImgViw, 1, 0.0,360.0, 1, true);
//
//                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                            @Override
//                            public void handle(ActionEvent event) {
//
//                                textArea.setText("Each participant computes an authentication tree for one time signatures for every other participant in the session and " +
//                                        "publishes the root.");
//                                treeImgViw.setVisible(true);
//                                scaleTransition(2750.0, textArea, 1.85, 1.85, 2, true);
//
//                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                    @Override
//                                    public void handle(ActionEvent event) {
//
//                                        scaleTransition(2000.0, treeImgViw, 1.25, 1.25, 2, true);
//
//                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                            @Override
//                                            public void handle(ActionEvent event) {
//                                                fadeTransition(500.0, treeImgViw, 1.0, 0.0, 1, false);
//                                                textArea.setText("The snake wants to sign a message of length n. The hash function takes the message as input to produce a message " +
//                                                        "with a fixed length. This is the protocol used to send messages of arbitrary length in a DC network. ");
//
//                                                scaleTransition(3000.0, textArea, 2.0, 2.0, 2, true);
//                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                    @Override
//                                                    public void handle(ActionEvent event) {
//                                                        messageImgViw.setVisible(true);
//                                                        hImgViw.setVisible(true);
//                                                        translateTransitionX(4000.0, hImgViw, hImgViw.getTranslateX(), hImgViw.getTranslateX() + (stackPane.getWidth() / 5) * 4, 1, false);
//                                                        rotateTransition(1000.0, hImgViw, 1, 0.0, 360.0, 4, true);
//
//                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                            @Override
//                                                            public void handle(ActionEvent event) {
//                                                                messageImgViw.setVisible(false);
//                                                                hImgViw.setVisible(false);
//                                                                thetaImgViw.setVisible(true);
//                                                                scaleTransition(1000.0, thetaImgViw, 1.2, 1.2, 1, true);
//
//                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                                    @Override
//                                                                    public void handle(ActionEvent event) {
//                                                                        textArea.setText("The new message (theta) is then inputed into an encoding function which computes the signature as a whole- and the specific " +
//                                                                                "parts for each participant.");
//                                                                        fadeTransition(1000.0, thetaImgViw, 1.0, 0.0, 1, false);
//                                                                        scaleTransition(2500.0, textArea, 1.9, 1.9, 1, true);
//
//
//                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                                            @Override
//                                                                            public void handle(ActionEvent event) {
//
//                                                                                signatureVector.setVisible(true);
//                                                                                signatureVector1.setVisible(true);
//                                                                                signatureVector2.setVisible(true);
//                                                                                signatureVector3.setVisible(true);
//                                                                                signatureVector4.setVisible(true);
//                                                                                signatureVector5.setVisible(true);
//                                                                                signatureVector6.setVisible(true);
//                                                                                textArea.setText("Every receiver of the message can now check the authenticity of the message by checking their specific segment " +
//                                                                                        "of the signature and other public values");
//                                                                                scaleTransition(2500.0, signatureVector, 1.25, 1.25, 2, true);
//
//                                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                                                    @Override
//                                                                                    public void handle(ActionEvent event) {
//                                                                                        textArea.setText("Each honest participant who receives a signature from the snake sends it back. If an honest participant receives a forged " +
//                                                                                                "signature, they will compare the forged signature with the corresponding correct signature, identifying any collisions with the correct " +
//                                                                                                "signature. Any collisions found are published and honest participants accept the proof of forgery if the collisions proof can be " +
//                                                                                                "substantiated. ");
//
//                                                                                        scaleTransition(5500.0, textArea, 1.75, 1.75, 2, true);
//
//                                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                                                            @Override
//                                                                                            public void handle(ActionEvent event) {
//
//                                                                                                translateTransitionX(2000.0, signatureVector, signatureVector.getTranslateX(), signatureVector.getTranslateX() + stackPane.getWidth() / 2, 1, false);
//                                                                                                fadeTransition(2000.0, signatureVector, 1.0, 0.0, 1, false);
//
//                                                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                                                                    @Override
//                                                                                                    public void handle(ActionEvent event) {
//                                                                                                        textArea.setText("The End.");
//                                                                                                        scaleTransition(2500.0, textArea, 2.0, 2.0, 2, true);
//                                                                                                    }
//                                                                                                });
//
//                                                                                            }
//                                                                                        });
//                                                                                    }
//                                                                                });
//
//                                                                            }
//                                                                        });
//
//                                                                    }
//                                                                });
//
//                                                            }
//                                                        });
//
//
//                                                    }
//                                                });
//
//
//                                            }
//                                        });
//                                    }
//                                });
//
//                            }
//                        });
//
//                    }
//                });
//
//
//            }
//        });
//
//
////
////        textArea.setText("A participant signs a message by creating a signature that can be divided into the number of other participants. Each " +
////                "distinct section is proof for a specific participant in the session.");
////
////        textArea.setText("Each participant which receives a message can check and authenticate the correctness of the components known to them, " +
////                "but all the while maintaining unconditional sender and receiver untraceability.");
////
////        textArea.setText("Each honest participant who receives a signature, sends it back to the sender. If an honest participant receives a forged " +
////                "signature, they will compare the forged signature with the corresponding correct signature, identifying any collisions with the correct signature. " +
////                "Any collisions found are published and honest participants accept the proof of forgery if the collisions proof can be substantiated. ");
////
////
////        textArea.setText("If a participant is labelled an attacker, first offenders will usually lose specific keys- as everyone deserves a second " +
////                "chance. However second and multiple offenders are usually removed from the session altogether.");
//    }


}
