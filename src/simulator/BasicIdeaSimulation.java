package simulator;


import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

/**
 *  The model in mvc for basic protocol. Takes input parameters from ControllerThree and runs the actual animation.
 *
 */
public class BasicIdeaSimulation extends Movement {
    //global variables used within the class
    ImageView dogCryptographer, coinImgViw, snakeCryptographer, elephantCryptographer, elephantSpeechBubble,
            dogSpeechBubble, snakeSpeechBubbleSame, snakeSpeechBubbleDifferent, coinTailsImgViw;
    StackPane simThreeStackPane;
    TextFlow textFlow;
    Double elephantPos;

    /**
     * constructor links the widgets here to the widgets in the controller class, and starts animation
     *
     * @param snakeCryptographer
     * @param elephantCryptographer
     * @param dogCryptographer
     * @param coinImgViw
     * @param simThreeStackPane
     * @param textFlow
     * @param elephantSpeechBubble
     * @param dogSpeechBubble
     */
    public BasicIdeaSimulation(ImageView coinTailsImgViw, ImageView snakeCryptographer, ImageView elephantCryptographer, ImageView dogCryptographer, ImageView coinImgViw,
                               StackPane simThreeStackPane, TextFlow textFlow, ImageView elephantSpeechBubble,
                               ImageView dogSpeechBubble, ImageView snakeSpeechBubbleSame, ImageView snakeSpeechBubbleDifferent) {

        this.snakeCryptographer = snakeCryptographer;
        this.elephantCryptographer = elephantCryptographer;
        this.dogCryptographer = dogCryptographer;
        this.simThreeStackPane = simThreeStackPane;
        this.textFlow = textFlow;
        this.coinImgViw = coinImgViw;
        this.elephantSpeechBubble = elephantSpeechBubble;
        this.dogSpeechBubble = dogSpeechBubble;
        this.snakeSpeechBubbleSame = snakeSpeechBubbleSame;
        this.snakeSpeechBubbleDifferent = snakeSpeechBubbleDifferent;
        this.coinTailsImgViw = coinTailsImgViw;

        tranArrList = new ArrayList<Transition>();

        part1();

    }

    /**
     *  First part of the animation
     */
    public void part1() {

        Text text = new Text("Three cryptographers are notified that arrangements for their dinner bill were made anonymously." +
                "They devise a protocol which allows them to determine whether the NSA, or a cryptographer paid- while " +
                "maintaining the cryptographers anonymity.");
        textFlow.getChildren().setAll(text);
        scaleTransition(3500.0, textFlow, 1.75, 1.75, 2, true);

        scaleTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                snakeCryptographer.setVisible(true);
                elephantCryptographer.setVisible(true);
                elephantPos = elephantCryptographer.getX();
                dogCryptographer.setVisible(true);

                Text text = new Text("The protocol consists of three consecutive coin flips and statements regarding their outcome.");
                textFlow.getChildren().setAll(text);
                scaleTransition(2500.0, textFlow, 1.75, 1.75, 2, true);

                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        fadeTransition(2000.0, snakeCryptographer, 1.0, 0.0, 1, false);
                        translateTransitionX(2000.0, elephantCryptographer, elephantCryptographer.getX(), elephantCryptographer.getX() + simThreeStackPane.getWidth() / 3, 1, false);

                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                                Text text = new Text("The first coin flip is enacted by the dog, ensuring that the outcome is visible only to the dog and the elephant.");
                                textFlow.getChildren().setAll(text);

                                coinImgViw.setVisible(true);
                                scaleTransition(2500.0, textFlow, 1.75, 1.75, 2, true);
                                rotateTransition(500.0, coinImgViw, 0, 0.0, 720.0, 5, false);
                                translateTransitionY(2500.0, coinImgViw, coinImgViw.getY(), coinImgViw.getY() - simThreeStackPane.getHeight() / 3 * 2, 1, true);

                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        rotateTransition(500.0, coinImgViw, 0, 0.0, 720.0, 5, false);
                                        translateTransitionY(2500.0, coinImgViw, coinImgViw.getY() - simThreeStackPane.getHeight() / 3 * 2, coinImgViw.getY(), 1, true);

                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {

                                                Text text = new Text("The dog and the elephant register that the coin had an outcome of heads.");
                                                textFlow.getChildren().setAll(text);

                                                scaleTransition(2500.0, textFlow, 1.75, 1.75, 2, true);

                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent event) {
                                                        fadeTransition(2000.0, dogCryptographer, 1.0, 0.0, 1, false);
                                                        fadeTransition(2000.0, snakeCryptographer, 0.0, 1.0, 1, false);
                                                        fadeTransition(2000.0, coinImgViw, 1.0, 0.0, 1, false);
                                                        translateTransitionX(2000.0, elephantCryptographer, elephantCryptographer.getTranslateX(), elephantCryptographer.getX() - simThreeStackPane.getWidth() / 3, 1, false);
                                                        rotateTransition(2000.0, elephantCryptographer, 1, 0.0, 180.0, 1, false);

                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                            @Override
                                                            public void handle(ActionEvent event) {

                                                                Text text = new Text("The second coin flip is enacted by the elephant, ensuring that the outcome is visible only to the elephant and the snake.");
                                                                textFlow.getChildren().setAll(text);

                                                                coinTailsImgViw.setVisible(true);
                                                                scaleTransition(2500.0, textFlow, 1.75, 1.75, 2, true);

                                                                rotateTransition(500.0, coinTailsImgViw, 0, 0.0, 720.0, 5, false);
                                                                translateTransitionY(2500.0, coinTailsImgViw, coinTailsImgViw.getY(), coinTailsImgViw.getY() - simThreeStackPane.getHeight() / 3 * 2, 1, true);
//
                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                    @Override
                                                                    public void handle(ActionEvent event) {
                                                                        rotateTransition(500.0, coinTailsImgViw, 0, 0.0, 720.0, 5, false);
                                                                        translateTransitionY(2500.0, coinTailsImgViw, coinTailsImgViw.getY() - simThreeStackPane.getHeight() / 3 * 2, coinTailsImgViw.getY(), 1, true);

                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                            @Override
                                                                            public void handle(ActionEvent event) {
                                                                                fadeTransition(2000.0, coinTailsImgViw, 1.0, 0.0, 1, false);
                                                                                Text text = new Text("The elephant and the snake register that the coin had an outcome of tails.");
                                                                                textFlow.getChildren().setAll(text);

                                                                                scaleTransition(2500.0, textFlow, 1.75, 1.75, 2, true);

                                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                    @Override
                                                                                    public void handle(ActionEvent event) {

                                                                                        fadeTransition(2000.0, dogCryptographer, 0.0, 1.0, 1, false);
                                                                                        fadeTransition(2000.0, elephantCryptographer, 1.0, 0.0, 1, false);

                                                                                        Text text = new Text("The third coin flip is enacted by the snake, ensuring that the outcome is visible only to the snake and the dog.");
                                                                                        textFlow.getChildren().setAll(text);

                                                                                        fadeTransition(2000.0, coinImgViw, 0.0, 1.0, 1, false);
//
                                                                                        scaleTransition(2500.0, textFlow, 1.75, 1.75, 2, true);
                                                                                        rotateTransition(500.0, coinImgViw, 0, 0.0, 720.0, 5, false);
                                                                                        translateTransitionY(2500.0, coinImgViw, coinImgViw.getY(), coinImgViw.getY() - simThreeStackPane.getHeight() / 3 * 2, 1, true);
//
                                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                            @Override
                                                                                            public void handle(ActionEvent event) {

                                                                                                rotateTransition(500.0, coinImgViw, 0, 0.0, 720.0, 5, false);
                                                                                                translateTransitionY(2500.0, coinImgViw, coinImgViw.getY() - simThreeStackPane.getHeight() / 3 * 2, coinImgViw.getY(), 1, true);

                                                                                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                    @Override
                                                                                                    public void handle(ActionEvent event) {

                                                                                                        Text text = new Text("The snake and the dog register that the coin had an outcome of heads.");
                                                                                                        textFlow.getChildren().setAll(text);

                                                                                                        scaleTransition(2500.0, textFlow, 1.75, 1.75, 2, true);

                                                                                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                                            @Override
                                                                                                            public void handle(ActionEvent event) {
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
        });


    }

    /**
     * Second part of animation
     */
    public void part2() {

        fadeTransition(1000.0, coinImgViw, 1.0, 0.0, 1, false);
        fadeTransition(2000.0, elephantCryptographer, 0.0, 1.0, 1, false);
        translateTransitionX(2000.0, elephantCryptographer, elephantCryptographer.getTranslateX(), elephantPos, 1, false);
        rotateTransition(2000.0, elephantCryptographer, 1, 180.0, 360.0, 1, true);
        Text text = new Text("The cryptographers now state whether the outcomes of the two coin flips they witnessed were the same or different outcomes.");
        textFlow.getChildren().setAll(text);

        scaleTransition(2500.0, textFlow, 1.75, 1.75, 2, true);

        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dogSpeechBubble.setVisible(true);
                elephantSpeechBubble.setVisible(true);
                snakeSpeechBubbleDifferent.setVisible(true);

                Text text = new Text("If the NSA paid, the cryptographers are all honest, and there is an even number of \"different\" stated. This " +
                        "informs everyone that the NSA paid");
                textFlow.getChildren().setAll(text);

                scaleTransition(2500.0, textFlow, 1.75, 1.75, 2, true);
                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {


                        fadeTransition(1500.0, snakeSpeechBubbleDifferent, 1.0, 0.0, 1, false);
                        scaleTransition(2000.0, snakeCryptographer, 1.35, 1.35, 2, true);
                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                                Text text = new Text("If a cryptographer paid, that cryptographer will state the opposite to the truth, resulting in an odd number of " +
                                        "\"different\" stated. This informs everyone that a cryptographer paid.");
                                textFlow.getChildren().setAll(text);

                                snakeSpeechBubbleSame.setVisible(true);
                                scaleTransition(1500.0, snakeSpeechBubbleSame, 1.25, 1.25, 2, true);
                                scaleTransition(2500.0, textFlow, 1.25, 1.25, 2, true);
                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        Text text = new Text("However, without knowing the coin flip outcomes, no one can determine which cryptographer paid- creating unconditional " +
                                                "anonymity.");
                                        textFlow.getChildren().setAll(text);
                                        scaleTransition(2500.0, textFlow, 1.5, 1.5, 2, true);

                                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {


                                                fadeTransition(2000.0, dogCryptographer, 1.0, 0.0, 1, false);
                                                fadeTransition(2000.0, elephantCryptographer, 1.0, 0.0, 1, false);
                                                fadeTransition(2000.0, snakeCryptographer, 1.0, 0.0, 1, false);
                                                fadeTransition(2000.0, dogSpeechBubble, 1.0, 0.0, 1, false);
                                                fadeTransition(2000.0, elephantSpeechBubble, 1.0, 0.0, 1, false);
                                                fadeTransition(2000.0, snakeSpeechBubbleSame, 1.0, 0.0, 1, false);

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

}
