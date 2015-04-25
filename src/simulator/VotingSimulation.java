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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.util.ArrayList;

/**
 * Created by Ola Laci on 23/04/2015.
 */
public class VotingSimulation extends Movement {


    Button backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn;
    StackPane stackPane;
    ImageView snakeImgViw, elephantImgViw, magnifyingGlassImgViw, dogImgViw, privateKeyImgViw, publicKeyImgViw, roundKeyImgViw, poolImgViw,commitmentImgViw, messageImgViw, sharedKeyImgViw;
    TextArea  signatureVector1,signatureVector2,signatureVector3,signatureVector4,signatureVector5,signatureVector6, signatureVector7;
    HBox signatureVector;
    TextFlow textFlow;

    public VotingSimulation(Button backSimulatorBtn, Button pauseSimulatorBtn, Button playSimulatorBtn, StackPane stackPane,
                            ImageView snakeImgViw,ImageView dogImgViw,ImageView privateKeyImgViw,ImageView publicKeyImgViw,ImageView roundKeyImgViw,
                            ImageView poolImgViw, ImageView messageImgViw, ImageView elephantImgViw, TextFlow textFlow,
                            TextArea signatureVector1,TextArea signatureVector2,TextArea signatureVector3,TextArea signatureVector4,TextArea signatureVector5,
                            TextArea signatureVector6, HBox signatureVector, ImageView sharedKeyImgViw, TextArea signatureVector7, ImageView commitmentImgViw,
                            ImageView magnifyingGlassImgViw){

        this.backSimulatorBtn = backSimulatorBtn;
        this.pauseSimulatorBtn = pauseSimulatorBtn;
        this.playSimulatorBtn = playSimulatorBtn;
        this.stackPane = stackPane;
        this.snakeImgViw = snakeImgViw;
        this.elephantImgViw = elephantImgViw;
        this.textFlow = textFlow;
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
        this.signatureVector7 = signatureVector7;
        this.commitmentImgViw = commitmentImgViw;
        this.magnifyingGlassImgViw = magnifyingGlassImgViw;

        tranArrList = new ArrayList<Transition>();


        Text t = new Text("This illustration will showcase how the dining cryptographer principle can be used in a boardroom voting scenario which satisfies " +
                "several security requirements: perfect ballot secrecy, self- tallying, universal verifiability, fairness, allows each voter to vote exactly " +
                "once, transcript withdrawal, technology independent and open source. ");

//        t.setFill(Color.AQUA);
//        Text tt = new Text("tfgyhujiko");
//        tt.setFill(Color.CHOCOLATE);
        textFlow.getChildren().setAll(t);


        part1();

    }


    public void part1(){

        scaleTransition(4500.0, textFlow, 2.0,2.0,2,true);
        scaleTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Text t = new Text("Every participant- the dog- in the session chooses a ");
                Text keyt = new Text("public key ");
                keyt.setFill(Color.BLUE);
                Text tt = new Text("and a ");
                Text keytt = new Text("private key. ");
                keytt.setFill(Color.YELLOW);
                Text ttt = new Text("Participants use the Diffie Hellman Key Exchange Protocol to compute their pairwise ");
                Text keyttt = new Text("shared keys.");
                keyttt.setFill(Color.FORESTGREEN);

                textFlow.getChildren().setAll(t, keyt, tt, keytt, ttt, keyttt);

                dogImgViw.setVisible(true);
                publicKeyImgViw.setVisible(true);
                privateKeyImgViw.setVisible(true);

                scaleTransition(2500.0, textFlow, 2.0,2.0,2,true);
                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        scaleTransition(1000.0, dogImgViw, 1.25,1.25,2,true);
                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                        translateTransitionX(2000.0, privateKeyImgViw, privateKeyImgViw.getX(), privateKeyImgViw.getX()-stackPane.getWidth()/2,1,false);
                        translateTransitionX(2000.0, publicKeyImgViw, publicKeyImgViw.getX(), publicKeyImgViw.getX()+stackPane.getWidth()/2,1,false);
                        rotateTransition(1000.0, privateKeyImgViw, 1, 0.0,360.0,2,false);
                        rotateTransition(1000.0, publicKeyImgViw, 1, 0.0,360.0,2,false);

                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                                sharedKeyImgViw.setVisible(true);
                                privateKeyImgViw.setVisible(false);
                                publicKeyImgViw.setVisible(false);
                                scaleTransition(1750.0, sharedKeyImgViw, 1.15,1.15,2,true);

                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        translateTransitionX(2000.0, dogImgViw, dogImgViw.getX(), dogImgViw.getX()+stackPane.getWidth()/3, 1,false);


                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        sharedKeyImgViw.setVisible(false);

                                        Text text = new Text("Each participant chooses a random position within their binary vector and adds a non zero " +
                                                "coordinate to that position.");
                                        textFlow.getChildren().setAll(text);

                                        signatureVector.setVisible(true);
                                        signatureVector1.setVisible(true);
                                        signatureVector2.setVisible(true);
                                        signatureVector3.setVisible(true);
                                        signatureVector4.setVisible(true);
                                        signatureVector5.setVisible(true);
                                        signatureVector6.setVisible(true);
                                        System.out.println("after setting signature vector to visible");

                                        scaleTransition(2000.0, textFlow, 1.25,1.25,2,true);

                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {

                                                scaleTransition(1500.0, signatureVector6, 1.5,1.5,2, true);
                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent event) {

                                                        Text text = new Text("Each participant then broadcasts these vectors and they are ");
                                                        Text text1 = new Text("pooled ");
                                                        text1.setFill(Color.BLUE);
                                                        Text text2 = new Text("together to produce a new vector containing the set of all messages- " +
                                                                "just like in the DC Network broadcast round.");
                                                        textFlow.getChildren().setAll(text, text1,text2);
                                                        scaleTransition(2750.0, textFlow, 1.5,1.5,2,true);

                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                            @Override
                                                            public void handle(ActionEvent event) {
                                                                poolImgViw.setVisible(true);
                                                                translateTransitionY(2000.0, signatureVector, signatureVector.getTranslateY(), signatureVector.getTranslateY() - (stackPane.getHeight()/3)*2, 1, false);
                                                                fadeTransition(2000.0, signatureVector, 1.0, 0.0, 1, false);

                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                    @Override
                                                                    public void handle(ActionEvent event) {
                                                                        signatureVector1.setText("1");
                                                                        signatureVector2.setText("1");
                                                                        signatureVector3.setText("1");
                                                                        signatureVector4.setText("1");
                                                                        signatureVector5.setText("1");
                                                                        signatureVector6.setText("1");

                                                                        poolImgViw.setVisible(false);
                                                                        Text text3 = new Text("If the number of 1's in the generated vector is equal to the number of participants, and every participant identifies their number " +
                                                                                "1, slot reservation was successful.");
                                                                        textFlow.getChildren().setAll(text3);
                                                                        scaleTransition(2000.0, textFlow, 1.5,1.5,2, true);

                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                            @Override
                                                                            public void handle(ActionEvent event) {

                                                                                translateTransitionY(500.0, signatureVector, signatureVector.getTranslateY(), signatureVector.getTranslateY()+(stackPane.getHeight()/3)*2, 1, false);
                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                    @Override
                                                                                    public void handle(ActionEvent event) {

//                                                                                poolImgViw.setVisible(true);
                                                                                translateTransitionY(2000.0, signatureVector, signatureVector.getTranslateY()+(stackPane.getHeight()/3)*2, signatureVector.getTranslateY() , 1, false);
                                                                                fadeTransition(2000.0, signatureVector, 0.0,1.0, 1, false);

                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                    @Override
                                                                                    public void handle(ActionEvent event) {
                                                                                        scaleTransition(1850.0,signatureVector,1.35,1.35,2,true);
                                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                            @Override
                                                                                            public void handle(ActionEvent event) {
//                                                                                                poolImgViw.setVisible(false);
                                                                                                Text text = new Text("If the number of 1's in the generated vector is less than the number of participants, collisions have occurred," +
                                                                                                        " resulting in an unsuccessful slot reservation round and a repetition of the protocol.");
                                                                                                textFlow.getChildren().setAll(text);
                                                                                                scaleTransition(2000.0, textFlow, 1.5,1.5,2, true);

                                                                                                signatureVector1.setText("1");
                                                                                                signatureVector2.setText("0");
                                                                                                signatureVector3.setText("1");
                                                                                                signatureVector4.setText("1");
                                                                                                signatureVector5.setText("0");
                                                                                                signatureVector6.setText("1");

                                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                    @Override
                                                                                                    public void handle(ActionEvent event) {

//

//                                                                                                        translateTransitionY(2000.0, signatureVector, signatureVector.getTranslateY(), signatureVector.getTranslateY() + (stackPane.getHeight() / 3) * 2, 1, false);
                                                                                                        fadeTransition(2000.0, signatureVector, 0.0,1.0, 1, false);
                                                                                                                scaleTransition(1500.0, signatureVector,1.25,1.25,2,true);

                                                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                            @Override
                                                                                                            public void handle(ActionEvent event) {
//                                                                                                                poolImgViw.setVisible(false);
                                                                                                                Text text = new Text("If the number of 1's in the generated vector is more than the number of participants, cor a participant cannot," +
                                                                                                                        " identify their position, someone has violated the protocol and an investigation stage must occur.");
                                                                                                                textFlow.getChildren().setAll(text);
                                                                                                                scaleTransition(2000.0, textFlow, 1.5, 1.5, 2, true);

                                                                                                                signatureVector1.setText("1");
                                                                                                                signatureVector2.setText("1");
                                                                                                                signatureVector3.setText("1");
                                                                                                                signatureVector4.setText("1");
                                                                                                                signatureVector5.setText("1");
                                                                                                                signatureVector6.setText("1");
                                                                                                                signatureVector7.setText("1");

                                                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                    @Override
                                                                                                                    public void handle(ActionEvent event) {

//                                                                                                                        poolImgViw.setVisible(true);
//                                                                                                                        translateTransitionY(500.0, signatureVector, signatureVector.getTranslateY(), signatureVector.getTranslateY()+(stackPane.getHeight()/3)*2, 1, false);

                                                                                                                        scaleTransition(2000.0, signatureVector,1.5,1.5,2,true);
                                                                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                            @Override
                                                                                                                            public void handle(ActionEvent event) {

                                                                                                                                fadeTransition(2000.0, signatureVector, 0.0,1.0, 1, false);

                                                                                                                                signatureVector7.setVisible(true);
//
                                                                                                                                scaleTransition(1500.0, signatureVector,1.25,1.25,2,true);

                                                                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                            @Override
                                                                                                                            public void handle(ActionEvent event) {

                                                                                                                        Text text = new Text("After a successful reservation round, the participants compute their respective ");
                                                                                                                         Text text1 = new Text("message, ");
                                                                                                                                text1.setFill(Color.CHOCOLATE);
                                                                                                                                Text text4 = new Text("round key and ");
                                                                                                                                Text text5 = new Text("commitment.");
                                                                                                                                text5.setFill(Color.GOLD);

                                                                                                                        textFlow.getChildren().setAll(text, text1, text4, text5);
                                                                                                                        scaleTransition(2500.0, textFlow, 1.5,1.5,2, true);

                                                                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                                    @Override
                                                                                                                                    public void handle(ActionEvent event) {
                                                                                                                                        fadeTransition(1000.0, signatureVector, 1.0,0.0, 1,false);
                                                                                                                                        messageImgViw.setVisible(true);
                                                                                                                                        roundKeyImgViw.setVisible(true);
                                                                                                                                        translateTransitionX(2500.0, messageImgViw, messageImgViw.getX(), messageImgViw.getX()-(stackPane.getWidth()/2.5), 1, false);
                                                                                                                                        translateTransitionX(2500.0, roundKeyImgViw, roundKeyImgViw.getX(), roundKeyImgViw.getX()+(stackPane.getWidth()/2.5), 1, false);
                                                                                                                                        rotateTransition(1250.0, messageImgViw,1,0.0,360.0,2,false);
                                                                                                                                        rotateTransition(1250.0, roundKeyImgViw,1,0.0,360.0,2,false);

                                                                                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                                            @Override
                                                                                                                                            public void handle(ActionEvent event) {

                                                                                                                                                commitmentImgViw.setVisible(true);
                                                                                                                                                messageImgViw.setVisible(false);
                                                                                                                                                roundKeyImgViw.setVisible(false);

                                                                                                                                                Text text6 = new Text("The ");
                                                                                                                                                Text text7 = new Text("commitments ");
                                                                                                                                                text7.setFill(Color.GOLD);
                                                                                                                                                Text text8 = new Text("are published and checked. If the commitments hold, the participants publish their exponent vectors- " +
                                                                                                                                                        "which after verification form the ballot of participants.");
                                                                                                                                                textFlow.getChildren().setAll(text6, text7, text8);

                                                                                                                                                scaleTransition(4500.0, textFlow, 2.0,2.0,2,true);

                                                                                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                                                    @Override
                                                                                                                                                    public void handle(ActionEvent event) {

                                                                                                                                                        Text text9 = new Text("If a commitment does not hold, someone has violated the protocol and an investigation stage is performed.");
                                                                                                                                                        textFlow.getChildren().setAll(text9);
                                                                                                                                                        scaleTransition(2000.0, textFlow, 1.5,1.5,2, true);

                                                                                                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                                                            @Override
                                                                                                                                                            public void handle(ActionEvent event) {
                                                                                                                                                                magnifyingGlassImgViw.setVisible(true);
                                                                                                                                                                scaleTransition(1850.0, magnifyingGlassImgViw, 2.0,2.0,2,true);



                                                                                                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                                                                    @Override
                                                                                                                                                                    public void handle(ActionEvent event) {
                                                                                                                                                                        Text text10 = new Text("All the participants publish all of their round keys, which allows dishonest participants to be " +
                                                                                                                                                                                "correctly identified and removed.");
                                                                                                                                                                        textFlow.getChildren().addAll(text10);
                                                                                                                                                                        scaleTransition(3500.0, textFlow, 1.75,1.75,2,true );

                                                                                                                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                                                                                            @Override
                                                                                                                                                                            public void handle(ActionEvent event) {
                                                                                                                                                                                Text text = new Text("The End.");
                                                                                                                                                                                textFlow.getChildren().setAll(text);
//                                                                                                                                                                                scaleTransition(3500.0, textFlow, 1.75,1.75,2,true );


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

//        textArea.setText("Each participant chooses a secret key and a complementary public key, and participants compute their shared keys- using " +
//                "Diffie Hellman key exchange");
//
//        textArea.setText("Slot reservation round consists of each participant choosing their binary vector position. If the total sum of 1's is " +
//                "less than 1, we can identify that there were collisions and therefore need to repeat; if the total sum is equal to the number of " +
//                "participants, and every participant can identify their unique position, we can conclude that it was successful; if the total sum is " +
//                "greater than the number of participants or a participant cannot locate their unique position, we can conclude that the protocol " +
//                "has been violated and that we need to investigate.");
//
//        textArea.setText("Voting consists of each participant computing their round keys and compute commitments, while one participant broadcasts " +
//                "the counter keeping record of all rounds within the session. The participants then all compute, publish and check their commitments, " +
//                "using a provided equation. If a formula does not hold, then the protocol has been violated and we need to investigate this");
//
//        textArea.setText("When the participants accepted the commitments, they published their exponents which are then verified. The participants " +
//                "verify the exponent and the sum of vectors is the ballot of participants.");
//
//        textArea.setText("");
    }
}


