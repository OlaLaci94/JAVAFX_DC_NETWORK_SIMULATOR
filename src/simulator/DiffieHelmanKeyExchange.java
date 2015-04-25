package simulator;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

/**
 * Created by Ola Laci on 21/04/2015.
 */
public class DiffieHelmanKeyExchange extends Movement{

   Button backSimulatorBtn, playSimulatorBtn,pauseSimulatorBtn;
   TextFlow textFlow;
  ImageView dogImgViw, elephantImgViw, dogPrivateKey, dogPublicKey, elephantPrivateKey, elephantPublicKey, alphaImgViw, pImgViw;
    StackPane stackPane;

    public DiffieHelmanKeyExchange(Button backSimulatorBtn, Button playSimulatorBtn,Button pauseSimulatorBtn, TextFlow textFlow, ImageView dogImgViw,
                                   ImageView elephantImgViw,ImageView dogPrivateKey, ImageView dogPublicKey, ImageView elephantPrivateKey,
                                   ImageView elephantPublicKey, ImageView alphaImgViw, ImageView pImgViw, StackPane stackPane){


        this.backSimulatorBtn = backSimulatorBtn;
        this.pauseSimulatorBtn = pauseSimulatorBtn;
        this.playSimulatorBtn = playSimulatorBtn;
        this.stackPane = stackPane;
        this.textFlow = textFlow;
        this.elephantImgViw = elephantImgViw;
        this.dogImgViw = dogImgViw;
        this.dogPrivateKey = dogPrivateKey;
        this.dogPublicKey = dogPublicKey;
        this.elephantPrivateKey = elephantPrivateKey;
        this.elephantPublicKey = elephantPublicKey;
        this.alphaImgViw = alphaImgViw;
        this.pImgViw = pImgViw;

        tranArrList = new ArrayList<Transition>();

        simulation();
    }


    public void simulation(){

        Text text = new Text("A public key algorithm that allows two participants to establish a shared secret key - illustrated in the Dining " +
                "Cryptographers protocol as the coin toss.");
//        text.fontProperty().setValue(Font.font(30.0));
        textFlow.getChildren().setAll(text);
        scaleTransition(2750.0, textFlow, 1.5,1.5,2,true);

        scaleTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dogImgViw.setVisible(true);
//
                scaleTransition(1500.0, dogImgViw, 1.25,1.25,2,true);

                Text text1 = new Text("The dog generates a ");
                Text text2 = new Text("prime number");
                text2.setFill(Color.PURPLE);
                Text text3 = new Text(" and an integer ");
                Text text4 = new Text("alpha ");
                text4.setFill(Color.RED);
                Text text5 = new Text("and sends them to the elephant.");
                textFlow.getChildren().setAll(text1, text2, text3, text4, text5);

                scaleTransition(2750.0, textFlow, 1.5,1.5,2,true);

                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        elephantImgViw.setVisible(true);
                        scaleTransition(1500.0, elephantImgViw, 1.25,1.25,2,true);



                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        pImgViw.setVisible(true);
                        alphaImgViw.setVisible(true);
                        scaleTransition(1500.0, pImgViw, 1.25, 1.25, 2, true);
                        scaleTransition(1500.0, alphaImgViw, 1.25,1.25,2,true);

                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                        translateTransitionX(2000.0, pImgViw, pImgViw.getX(), pImgViw.getX() + (stackPane.getWidth() / 7) * 6, 1, false);
                        translateTransitionX(2000.0, alphaImgViw, alphaImgViw.getX(), alphaImgViw.getX() + (stackPane.getWidth() / 7) * 6, 1, false);

                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                fadeTransition(2500.0, pImgViw, 1.0,0.0, 1,false);
                                fadeTransition(2500.0, alphaImgViw, 1.0,0.0, 1,false);

                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        Text text1 = new Text("The dog generates a random number - his ");
                                        Text text2 = new Text("private key.");
                                        text2.setFill(Color.GOLD);
                                        Text text3 = new Text(" The elephant also generates a random number - her ");
                                        Text text4 = new Text("private key.");
                                        text4.setFill(Color.GREEN);
                                        textFlow.getChildren().setAll(text1, text2, text3, text4);

                                        scaleTransition(2750.0, textFlow, 1.5, 1.5, 2, true);

                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {
                                                dogPrivateKey.setVisible(true);
                                                elephantPrivateKey.setVisible(true);
                                                scaleTransition(1000.0, dogPrivateKey, 1.25, 1.25, 2, true);
                                                scaleTransition(1000.0, elephantPrivateKey, 1.25, 1.25, 2, true);

                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent event) {
                                                        fadeTransition(1000.0,dogPrivateKey, 1.0,0.0,1,false);
                                                        fadeTransition(1000.0,elephantPrivateKey, 1.0,0.0,1,false);

                                                        Text text1 = new Text("The dog computes his  ");
                                                        Text text2 = new Text("public key");
                                                        text2.setFill(Color.GOLD);
                                                        Text text3 = new Text(" by applying a function on his ");
                                                        Text text4 = new Text("private key,");
                                                        text4.setFill(Color.GREEN);
                                                        Text text5 = new Text("prime number,");
                                                        text4.setFill(Color.PURPLE);
                                                        Text text6 = new Text(" and ");
                                                        Text text7 = new Text("alpha.");
                                                        text4.setFill(Color.RED);
                                                        textFlow.getChildren().setAll(text1, text2, text3, text4, text5, text6, text7);

                                                        scaleTransition(3750.0, textFlow, 1.5, 1.5, 2, true);


                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                            @Override
                                                            public void handle(ActionEvent event) {

                                                                dogPublicKey.setVisible(true);
                                                                elephantPublicKey.setVisible(true);

                                                                Text text = new Text("The elephant also computes her ");
                                                                Text text1 = new Text("public key");
                                                                text1.setFill(Color.GREEN);
                                                                Text text8 = new Text(" in the same way.");
                                                                textFlow.getChildren().setAll(text,text1, text8);
                                                                scaleTransition(1800.0, textFlow, 1.5,1.5,2,true);

                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                    @Override
                                                                    public void handle(ActionEvent event) {

                                                                        Text text9 = new Text("The dog and elephant exchange public keys.");
                                                                        textFlow.getChildren().setAll(text9);
                                                                        scaleTransition(2000.0, textFlow, 1.5,1.5,2,true);

                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                            @Override
                                                                            public void handle(ActionEvent event) {

                                                                                translateTransitionX(2500.0, dogPublicKey, dogPublicKey.getX(), dogPublicKey.getX()+(2*(stackPane.getWidth()/3)), 1, false);
                                                                                translateTransitionX(2500.0, elephantPublicKey, elephantPublicKey.getX(), elephantPublicKey.getX()-(2*(stackPane.getWidth()/3)), 1, false);

                                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                    @Override
                                                                                    public void handle(ActionEvent event) {

                                                                                        fadeTransition(2000.0, dogPublicKey,1.0,0.0,1,false);
                                                                                        fadeTransition(2000.0, elephantPublicKey,1.0,0.0,1,false);

                                                                                        Text text10 = new Text("The dog computes the shared key by performing a function with inputs: the elephants public key, his private" +
                                                                                                " key and the prime number.");
                                                                                        textFlow.getChildren().setAll(text10);
                                                                                        scaleTransition(2500.0, textFlow, 1.5,1.5,2, true );

                                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                            @Override
                                                                                            public void handle(ActionEvent event) {

                                                                                                Text text10 = new Text("The elephant computes the shared key by performing a function with inputs: the dogs public key, her private" +
                                                                                                        " key and the prime number.");
                                                                                                textFlow.getChildren().setAll(text10);
                                                                                                scaleTransition(2500.0, textFlow, 1.5,1.5,2, true );

                                                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                    @Override
                                                                                                    public void handle(ActionEvent event) {
                                                                                                        Text tt = new Text("The End.");
                                                                                                        textFlow.getChildren().setAll(tt);
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
    public void part1()
    {
//        rotateTransition(500.0, elephantImgViw,1,0.0,180.0,1,false);
//        scaleTransition(7000.0, textArea,2.0,2.0,2,true);
//        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                fadeTransition(1000.0, dogImgViw, 1.0,0.0,1,false);
//                scaleTransition(1000.0, elephantImgViw, 1.25, 1.25, 1, true);
//                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(ActionEvent event) {
//                        elephantTextArea.setVisible(true);
//                        elephantTextArea.setText("Chooses a prime number p and an integer i. The elephant then sends these two values to the snake - " +
//                                "over the insecure channel so the dog (and others) may have access to these values");
//                        scaleTransition(2500.0, elephantTextArea, 1.5,1.5,1, true);
//                        sleeping(1000.0);
//                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
//                            @Override
//                            public void handle(ActionEvent event) {
//                                textArea.setText("The elephant and snake each generate a random number(less than p)- referred to as E and S respectively.");
//                                scaleTransition(3000.0, textArea, 1.5,1.5,1,true);
//                                sleeping(1000.0);
//                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
//                                    @Override
//                                    public void handle(ActionEvent event) {
//
//                                        elephantTextArea.setText("Computes (i^E mod p) and sends this to the snake over the insecure channel.");
//                                        scaleTransition(2500.0, elephantTextArea, 1.25,1.25,1, true);
//                                        sleeping(1000.0);
//                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
//                                            @Override
//                                            public void handle(ActionEvent event) {
//                                                sleeping(1000.0);
//                                                snakeTextArea.setVisible(true);
//                                                scaleTransition(1000.0, snakeImgViw, 1.25, 1.25, 1, true);
//                                                snakeTextArea.setText("Computes (i^S mod p) and sends this to the elephant over the insecure channel.");
//                                                scaleTransition(2500.0, snakeTextArea, 1.25,1.25,1, true);
//                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                    @Override
//                                                    public void handle(ActionEvent event) {
//                                                        sleeping(1000.0);
//                                                        snakeTextArea.setText("Now the snake can securely know the key by computing: ((i^E mod p)^S mod p).");
//                                                        scaleTransition(2500.0, snakeTextArea, 1.25,1.25,1, true);
//                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                            @Override
//                                                            public void handle(ActionEvent event) {
//                                                                sleeping(1000.0);
//                                                                elephantTextArea.setText("Now the elephant can securely know the key by computing: ((i^S mod p)^E mod p)).");
//                                                                scaleTransition(2500.0, elephantTextArea, 1.25,1.25,1, true);
//                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                                    @Override
//                                                                    public void handle(ActionEvent event) {
//
//                                                                       textArea.setText("This protocol allows the elephant and snake to generate and share the key over an insecure channel " +
//                                                                               "while knowing that the dog- and anyone else - cannot feasibly compute their shared key. This is the most " +
//                                                                               "desirable form of key exchange that will be assumed throughout these illustrations. However, there are obviously" +
//                                                                               "other key generation and exchange protocols. ");
//                                                                        scaleTransition(2500.0, textArea, 2.0,2.0,1, true);
//                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
//                                                                            @Override
//                                                                            public void handle(ActionEvent event) {
//
//                                                                            }
//                                                                        });
//                                                                    }
//                                                                });
//
//                                                            }
//                                                        });
//                                                    }
//                                                });
//
//                                            }
//                                        });
//
//                                    }
//                                });
//
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
    }

}
