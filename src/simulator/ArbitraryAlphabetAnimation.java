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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

/**
 * Created by Ola Laci on 23/04/2015.
 */
public class ArbitraryAlphabetAnimation extends Movement {

    Button backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn;
    StackPane stackPane;
    ImageView snakeImgViw, elephantImgViw, keyImgViw, keyImgViw1, poolImgViw, mapImgVw, alphaImgViw, mathImgViw;
    TextArea partialPad1, partialPad2, partialPad3, partialPad4, partialPad5, partialPad6;
    HBox vector;
    TextFlow textflow;

    public ArbitraryAlphabetAnimation(Button backSimulatorBtn, Button pauseSimulatorBtn, Button playSimulatorBtn, StackPane stackPane,
                                      ImageView poolImgViw, ImageView snakeImgViw, ImageView elephantImgViw, ImageView keyImgViw, ImageView keyImgViw1, TextFlow textflow,
                                      TextArea partialPad1, TextArea partialPad2, TextArea partialPad3, TextArea partialPad4, TextArea partialPad5,
                                      TextArea partialPad6, HBox vector, ImageView mapImgVw, ImageView alphaImgViw, ImageView mathImgViw) {
        this.backSimulatorBtn = backSimulatorBtn;
        this.pauseSimulatorBtn = pauseSimulatorBtn;
        this.playSimulatorBtn = playSimulatorBtn;
        this.stackPane = stackPane;
        this.snakeImgViw = snakeImgViw;
        this.elephantImgViw = elephantImgViw;
        this.poolImgViw = poolImgViw;
        this.textflow = textflow;
        this.keyImgViw = keyImgViw;
        this.keyImgViw1 = keyImgViw1;
        this.partialPad1 = partialPad1;
        this.partialPad2 = partialPad2;
        this.partialPad3 = partialPad3;
        this.partialPad4 = partialPad4;
        this.partialPad5 = partialPad5;
        this.partialPad6 = partialPad6;
        this.vector = vector;
        this.mapImgVw = mapImgVw;
        this.alphaImgViw = alphaImgViw;
        this.mathImgViw = mathImgViw;


        tranArrList = new ArrayList<Transition>();



        animationPart1();

    }

    public void animationPart1() {
        fadeTransition(100.0, elephantImgViw,1.0,0.0, 1, false);
        fadeTransition(100.0, mapImgVw,1.0,0.0, 1, false);
        fadeTransition(100.0, mathImgViw,1.0,0.0, 1, false);
        Text text = new Text("This illustration will identify the protocol details of transmitting an algebraic group element in a DC network. " +
                "Implementations of this are known as Short DC Networks.");

        textflow.getChildren().setAll(text);
        scaleTransition(3500.0, textflow, 1.65, 1.65, 2, true);

        scaleTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                rotateTransition(500.0, elephantImgViw,1,0.0,180.0,1,false);
                fadeTransition(3500.0, elephantImgViw,0.0,1.0, 1, false);

                Text text = new Text("Setup is achieved by a trusted entity - elephant -  executing a parameter generation function which uses bilinear mapping as " +
                         "a basic tool in its construction. ");

                textflow.getChildren().setAll(text);
                scaleTransition(3500.0,textflow,1.5,1.5,2,true);


                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

//                        scaleTransition(2000.0, elephantImgViw, 1.35,1.35,2,true);
                        fadeTransition(1000.0, textflow,1.0,0.0, 1, false);
                        Text text1 = new Text("");
                        textflow.getChildren().setAll(text1);
                        fadeTransition(1500.0, mapImgVw,0.0,1.0, 1, false);
//                        scaleTransition(1500.0, mapImgVw,1.5,1.5,2,true);





                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {


                                fadeTransition(1500.0, mapImgVw, 1.0,0.0,1,false);
                                fadeTransition(1500.0, textflow, 0.0,1.0,1,false);
                                fadeTransition(1500.0, elephantImgViw, 1.0,0.0,1,false);


                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        Text text1 = new Text("Each  ");
                                        Text text2 = new Text("participant");
                                        text2.setFill(Color.GREEN);
                                        Text text3 = new Text(" is provided with a");
                                        Text text4 = new Text(" public key ");
                                        text4.setFill(Color.GOLD);
                                        Text text5 = new Text("and a set of secret keys: the shared key.");
                                        textflow.getChildren().setAll(text1, text2, text3,text4, text5);

                                        keyImgViw.setVisible(true);
                                        keyImgViw1.setVisible(true);
                                        snakeImgViw.setVisible(true);
                                        scaleTransition(3500.0, textflow, 1.5,1.5, 2,true);

                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {

                                                Text text1 = new Text("The snake constructs a vector consisting of the keys.");
                                                fadeTransition(2000.0, keyImgViw,1.0,0.0,1,false);
                                                textflow.getChildren().setAll(text1);

                                                vector.setVisible(true);
                                                partialPad1.setVisible(true);
                                                partialPad2.setVisible(true);
                                                partialPad3.setVisible(true);
                                                partialPad4.setVisible(true);
                                                partialPad5.setVisible(true);
                                                partialPad6.setVisible(true);
                                                scaleTransition(3500.0, textflow, 1.5,1.5, 2,true);

                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent event) {

                                                        translateTransitionY(2000.0, keyImgViw1, keyImgViw1.getY(),keyImgViw1.getY()+(stackPane.getHeight()/4)*3, 1,false);

                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                            @Override
                                                            public void handle(ActionEvent event) {

                                                                translateTransitionX(2000.0, keyImgViw1, keyImgViw1.getX(), keyImgViw1.getX()+stackPane.getWidth()/1.5, 1, false);
                                                                fadeTransition(2000.0, keyImgViw1, 1.0,0.0, 1, false);
                                                                Text text6 = new Text(" Then XOR their message with a randomly chosen position.");
                                                                textflow.getChildren().setAll(text6);
                                                                scaleTransition(3500.0, textflow, 1.5,1.5, 2,true);

                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                    @Override
                                                                    public void handle(ActionEvent event) {

                                                                        partialPad6.setText("W(snake,cat)(6)XOR(M)");
                                                                        scaleTransition(2000.0, partialPad6, 1.5,1.5, 2,true);
                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                    @Override
                                                                    public void handle(ActionEvent event) {

                                                                        Text text5 = new Text("Subsidiary data");
                                                                        text5.setFill(Color.RED);
                                                                        Text text6 = new Text(" containing the snakes identity and validity proof regarding the vector is added to the output and posted. ");

                                                                        textflow.getChildren().setAll(text5, text6);
                                                                                scaleTransition(2000.0, textflow, 1.5,1.5, 2,true);

                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                    @Override
                                                                                    public void handle(ActionEvent event) {

                                                                                        alphaImgViw.setVisible(true);
                                                                                        scaleTransition(1000.0, alphaImgViw,1.2,1.2,2, true);
                                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                            @Override
                                                                                            public void handle(ActionEvent event) {


                                                                                                translateTransitionY(1000.0, alphaImgViw, alphaImgViw.getY(), alphaImgViw.getY()+stackPane.getHeight()/5, 1, false);
                                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                    @Override
                                                                                                    public void handle(ActionEvent event) {

                                                                                                        translateTransitionX(2000.0, alphaImgViw, alphaImgViw.getX(), alphaImgViw.getX()+stackPane.getWidth()/1.5, 1, false);
                                                                                                        fadeTransition(2000.0, alphaImgViw, 1.0,0.0, 1, false);

                                                                                                        part2();



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

    /**
     * second part of animation - verficication, extraction and reconstruction
     */
    public void part2(){


        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Text text = new Text("All outputs - from every participant in the session - are pooled together.");
                textflow.getChildren().setAll(text);
                scaleTransition(3500.0, textflow, 1.5,1.5,2, true);

                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        poolImgViw.setVisible(true);
                        fadeTransition(100.0, textflow,1.0,0.0,1,false);
                        translateTransitionY(2000.0, vector, vector.getTranslateY(), vector.getTranslateY()-stackPane.getHeight()/2,1,false);
                        fadeTransition(2000.0, vector,1.0,0.0,1,false);

                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                Text text1 = new Text("");
                                textflow.getChildren().setAll(text1);
                                fadeTransition(100.0, textflow, 0.0, 1.0, 1, false);

                                fadeTransition(2000.0, poolImgViw, 1.0,0.0,1,false);

                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        Text text1 = new Text("Anyone can verify the correctness of the subsidiary data for each participants output, and consequently verifying the correctness of the vector.");
                                        textflow.getChildren().setAll(text1);
                                        fadeTransition(2000.0, snakeImgViw, 1.0,0.0,1,false);
                                        scaleTransition(3500.0,textflow, 1.5,1.5,2,true);

                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {

                                                Text text1 = new Text("An extraction function computes the necessary mathematical equations to produce a vector containing the set of " +
                                                        "broadcasted messages. This set of messages is the output of this extraction function.");
                                                textflow.getChildren().setAll(text1);
                                                scaleTransition(3500.0,textflow, 1.5,1.5,2,true);

                                                partialPad1.setText("(M)");
                                                partialPad2.setText("(M)");
                                                partialPad3.setText("(M)");
                                                partialPad4.setText("(M)");
                                                partialPad5.setText("(M)");
                                                partialPad6.setText("(M)");

                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent event) {

                                                        fadeTransition(1500.0, textflow,1.0,0.0,1,false);
                                                        fadeTransition(1500.0,mathImgViw, 0.0,1.0,1, false);

                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                            @Override
                                                            public void handle(ActionEvent event) {

                                                                Text text2 = new Text("");
                                                                textflow.getChildren().setAll(text2);

                                                                fadeTransition(2500.0, vector, 0.0, 1.0, 1, false);
                                                                fadeTransition(2500.0,mathImgViw, 1.0,0.0,1, false);
                                                                fadeTransition(2500.0, textflow, 0.0, 1.0, 1, false);

                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                    @Override
                                                                    public void handle(ActionEvent event) {

                                                                        fadeTransition(2000.0, vector, 1.0, 0.0, 1, false);


                                                                        Text text1 = new Text("The vectors of all participants are required. If some participants do not publish their output vectors, the honest participants can reconstruct their vectors by providing all " +
                                                                                "of the dishonest participants shared secrets.");
                                                                        textflow.getChildren().setAll(text1);
                                                                        scaleTransition(4500.0,textflow, 1.5,1.5,2,true);

                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                            @Override
                                                                            public void handle(ActionEvent event) {

                                                                                Text text1 = new Text("The End.");
                                                                                textflow.getChildren().setAll(text1);


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
//    public void part1(){
//
//        scaleTransition(4500.0, textArea, 2.0, 2.0, 2, true);
//        scaleTransition.setOnFinished(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//
//                elephantImgViw.setVisible(true);
//
//                rotateTransition(1500.0, elephantImgViw, 1, 0.0, 180.0, 1, false);
//                textArea.setText("A trusted entity- the elephant- executes the parameter generation function which outputs the set of parameters required for setup. ");
//
//                scaleTransition(3500.0, textArea, 1.5, 1.5, 2, true);
//
//                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(ActionEvent event) {
//
//                        fadeTransition(1000.0, elephantImgViw, 1.0, 0.0, 1, false);
//                        snakeImgViw.setVisible(true);
//                        rotateTransition(1500.0, snakeImgViw, 1, 0.0, 360.0, 1, true);
//                        textArea.setText("The snake represents every participant in the session and so each participant will follow this protocol.");
//                        scaleTransition(2500.0, textArea, 1.5, 1.5, 2, true);
//
//                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                            @Override
//                            public void handle(ActionEvent event) {
//                                textArea.setText("Key generation function yields a private and complementary public key for each participant. Each private " +
//                                        "key is shared with a corresponding participant to form the shared key pair.");
//                                scaleTransition(3500.0, textArea, 1.5, 1.5, 2, true);
//                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                    @Override
//                                    public void handle(ActionEvent event) {
//                                        keyImgViw.setVisible(true);
//                                        scaleTransition(1000.0, keyImgViw, 1.25, 1.25, 2, true);
//
//                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                            @Override
//                                            public void handle(ActionEvent event) {
//
//                                                textArea.setText("Each participant computes a partial pad with every other participant. The vector these partial pads are " +
//                                                        "contained in are known as a vector.");
//
//                                                keyImgViw.setVisible(false);
//
//                                                scaleTransition(2500.0, textArea, 1.75, 1.75, 2, true);
//                                                vector.setVisible(true);
//                                                partialPad1.setVisible(true);
//                                                partialPad2.setVisible(true);
//                                                partialPad3.setVisible(true);
//                                                partialPad4.setVisible(true);
//                                                partialPad5.setVisible(true);
//                                                partialPad6.setVisible(true);
//
//                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                    @Override
//                                                    public void handle(ActionEvent event) {
//                                                        scaleTransition(1500.0, vector, 1.25, 1.25, 2, true);
//
//                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                            @Override
//                                                            public void handle(ActionEvent event) {
//                                                                textArea.setText("They choose a random partial pad and apply the XOR function of its value with the message they wish to broadcast. The new vector is now called the " +
//                                                                        "output vector.");
//
//                                                                scaleTransition(2500.0, textArea, 1.25, 1.25, 2, true);
//
//                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                                    @Override
//                                                                    public void handle(ActionEvent event) {
//
//
//                                                                        partialPad6.setText("M XOR W(snake,cat)");
//                                                                        scaleTransition(2000.0, partialPad6, 1.5, 1.5, 2, true);
//
//                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                                            @Override
//                                                                            public void handle(ActionEvent event) {
//
//                                                                                textArea.setText("Some subsidiary data is then computed consisting of the participants identity and a valid proof of the correctness of " +
//                                                                                        "the vector. This subsidiary data is posted with the output data. The participants pool all of their output data.");
//                                                                                scaleTransition(3500.0, textArea, 1.5, 1.5, 2, true);
//
//                                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                                                    @Override
//                                                                                    public void handle(ActionEvent event) {
//                                                                                        alphaImgViw.setVisible(true);
//                                                                                        scaleTransition(1500.0, alphaImgViw, 1.25, 1.25, 2, true);
//
//                                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                                                            @Override
//                                                                                            public void handle(ActionEvent event) {
//                                                                                                poolImgViw.setVisible(true);
//                                                                                                textArea.setVisible(false);
//                                                                                                translateTransitionY(3500.0, vector, vector.getTranslateY(), vector.getTranslateY() - stackPane.getWidth() / 5, 1, false);
//                                                                                                fadeTransition(3500.0, vector, 1.0, 0.0, 1, false);
//                                                                                                translateTransitionY(3500.0, alphaImgViw, alphaImgViw.getTranslateY(), alphaImgViw.getTranslateY() - stackPane.getWidth() / 5, 1, false);
//                                                                                                fadeTransition(3500.0, alphaImgViw, 1.0, 0.0, 1, false);
//
//                                                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                                                                    @Override
//                                                                                                    public void handle(ActionEvent event) {
//                                                                                                        poolImgViw.setVisible(false);
//                                                                                                        System.out.println("textarea.setVisible(true)");
//                                                                                                        textArea.setVisible(true);
//                                                                                                        textArea.setText("A verification function can be called to verify the output vector- using the subsidiary data provided, which outputs " +
//                                                                                                                "1 if it is indeed valid. This function can be called by any player.");
//                                                                                                        scaleTransition(3000.0, textArea, 1.5, 1.5, 2, true);
//
//                                                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                                                                            @Override
//                                                                                                            public void handle(ActionEvent event) {
//                                                                                                                textArea.setText("Once all participants have posted, the set of messages broadcast can be extracted using the necessary mathematical proofs, creating a vector of the set of messages.");
//                                                                                                                scaleTransition(2000.0, textArea, 1.5, 1.5, 2, true);
//                                                                                                                partialPad1.setText("MESSAGE");
//                                                                                                                partialPad2.setText("MESSAGE");
//                                                                                                                partialPad3.setText("MESSAGE");
//                                                                                                                partialPad4.setText("MESSAGE");
//                                                                                                                partialPad5.setText("MESSAGE");
//                                                                                                                partialPad6.setText("MESSAGE");
//                                                                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                                                                                    @Override
//                                                                                                                    public void handle(ActionEvent event) {
//                                                                                                                        poolImgViw.setVisible(true);
//                                                                                                                        textArea.setVisible(false);
//                                                                                                                        translateTransitionY(3500.0, vector, vector.getTranslateY(), vector.getTranslateY() + stackPane.getWidth() / 5, 1, false);
//                                                                                                                        fadeTransition(3500.0, vector, 0.0, 1.0, 1, false);
//
//
//
//                                                                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                                                                                    @Override
//                                                                                                                    public void handle(ActionEvent event) {
//
//                                                                                                                        poolImgViw.setVisible(false);
//                                                                                                                        System.out.println("textarea.setVisible(true)");
//                                                                                                                        textArea.setVisible(true);
//
//                                                                                                                        textArea.setText("If a participant failed to broadcast, the honest participants can pool their shared partial pads with the dishonest " +
//                                                                                                                                "participants to reconstruct the missing vector. Anyone can verify the correctness of these values.");
//
//                                                                                                                        scaleTransition(3000.0, textArea, 2.0,2.0,2,true);
////
//                                                                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                                                                                            @Override
//                                                                                                                            public void handle(ActionEvent event) {
//                                                                                                                                textArea.setText("The End.");
//                                                                                                                                scaleTransition(2000.0, textArea,2.0,2.0,2,true);
//
//                                                                                                                            }
//                                                                                                                        });
//                                                                                                                            }
//                                                                                                                        });
//                                                                                                                    }
//                                                                                                                });
//                                                                                                            }
//                                                                                                        });
//                                                                                                    }
//                                                                                                });
//                                                                                            }
//                                                                                        });
//
//                                                                                    }
//                                                                                });
//                                                                            }
//                                                                        });
//                                                                    }
//                                                                });
//
//
//                                                            }
//                                                        });
//
//                                                    }
//                                                });
//
//                                            }
//                                        });
//
//                                    }
//                                });
//
//                            }
//                        });
//
//                    }
//                });
//
////                textArea.setText("The DC net is assembled using a parameter generation function by a trusted entity- which satisfies the " +
////                        "Decisional Bilinear Diffie Hellman problem - and therefore uses both admissible linear maps and elliptic curve " +
////                        "based algebraic groups. The key generation is performed using a function which takes in a specification parameter- " +
////                        "one for each participant, then produces and distributes a public and secret key for each participant. Each private key " +
////                        "is shared between two participants i and j- creating key(i,j).");
////
////                textArea.setText("Each participant is assumed to have a trustworthy global counter of the session and a specification containing all participants " +
////                        "this session");
////
////                textArea.setText("Every participant of the session then posts the output vector and subsidiary data; the output vector consists of " +
////                        "the pad with one partial pad which contains the generated key XOR the MESSAGE that the participant wishes to post; the subsidiary " +
////                        "data contains the participants identity and proof of the posted vectors correctness.");
////
////                textArea.setText("Message extraction is performed taking the output vectors of all participants and computing the necessary inverse " +
////                        "equations which outputs the set of messages- which contains at most n messages- where n is the number of participants.");
////
////                textArea.setText("If any participants fail to produce a correct output vector - or do not output a vector- the set of other players can " +
////                        "produce a correct output vector by combining their shared keys with the missing participant. Polynomial interpolation allows any "+
////                "participant to recompute the pads of the missing participant.");
////
////                textArea.setText("This showcases how to maintain the non interactivity feature of DC nets while maintaining high detection " +
////                        "and identification of cheating players with a fault recovery overhead of only one additional broadcast round.");
//            }
//        });
//


//}
}
