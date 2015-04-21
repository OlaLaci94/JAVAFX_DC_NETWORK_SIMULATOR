package simulator;


import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import  javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 *
 */
public class BasicIdeaSimulation extends Movement
{
    //global variables used within the class
    ImageView dogCryptographer, coinImgViw, snakeCryptographer, elephantCryptographer, elephantSpeechBubble,
            dogSpeechBubble, snakeSpeechBubbleSame, snakeSpeechBubbleDifferent;
    StackPane simThreeStackPane;
    TextArea simThreeTextArea;
    String currentText;
    ExecutorService pool;
    Double textAreaAfterx, textAreax, textAreaDbx;

    /**
     *  constructor links the widgets here to the widgets in the controller class, and starts animation
     *
     * @param snakeCryptographer
     * @param elephantCryptographer
     * @param dogCryptographer
     * @param coinImgViw
     * @param simThreeStackPane
     * @param simThreeTextArea
     * @param elephantSpeechBubble
     * @param dogSpeechBubble

     */
    public BasicIdeaSimulation(ImageView snakeCryptographer,  ImageView elephantCryptographer,  ImageView dogCryptographer,  ImageView coinImgViw,
                               StackPane simThreeStackPane,  TextArea simThreeTextArea, ImageView elephantSpeechBubble,
                               ImageView dogSpeechBubble,ImageView snakeSpeechBubbleSame, ImageView snakeSpeechBubbleDifferent ) {

        this.snakeCryptographer = snakeCryptographer;
        this.elephantCryptographer = elephantCryptographer;
        this.dogCryptographer = dogCryptographer;
        this.simThreeStackPane = simThreeStackPane;
        this.simThreeTextArea = simThreeTextArea;
        this.coinImgViw = coinImgViw;
        this.elephantSpeechBubble = elephantSpeechBubble;
        this.dogSpeechBubble = dogSpeechBubble;
        this.snakeSpeechBubbleSame = snakeSpeechBubbleSame;
        this.snakeSpeechBubbleDifferent = snakeSpeechBubbleDifferent;

        textAreaDbx = simThreeTextArea.getTranslateX();
        tranArrList = new ArrayList<Transition>();

        currentText = "Three cryptographers have dinner at their favourite restaurant. They are promptly informed that the " +
                "bill has been paid for anonymously. The cryptographers want to know whether a fellow cryptographer paid " +
                "or if the NSA paid. They respect each others anonymity so devise a plan that would not reveal which cryptographer paid- " +
                "if one of the cryptographers had paid";
        simThreeTextArea.setText(currentText);

        pool = Executors.newSingleThreadExecutor();

        pool.execute(new Runnable() {
            @Override
            public void run()
            {
                basicThree0();
            }
        });

    }

    /**
     * creates second section of animation
     */
    public void basicThree1()
    {

        simThreeTextArea.setText("Now the elephant flips her coin- which only the elephant and the snake can see");
        scaleTransition(4000.0, simThreeTextArea, 2.0, 2.0, 2, true);
        scaleTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                fadeTransition(2000.0,dogCryptographer,1.0,0.0,1,false);
                translateTransitionX(2000.0, snakeCryptographer, snakeCryptographer.getX(), snakeCryptographer.getX()-(simThreeStackPane.getWidth()/5)*4, 1, false);
//                translateTransitionX(2000.0, elephantCryptographer, elephantCryptographer.getX(), elephantCryptographer.getX()-100, 1, false);
                textAreax = simThreeTextArea.getTranslateX();
                textAreaAfterx = simThreeTextArea.getTranslateX()+350;
                translateTransitionX(500.0, coinImgViw, coinImgViw.getX(), coinImgViw.getX()-(simThreeStackPane.getWidth()/15)*8,1, false);
                rotateTransition(1000.0, snakeCryptographer, 1, 0.0, 180.0, 1, false);

                translateTransitionX(2000.0, simThreeTextArea, simThreeTextArea.getTranslateX(),textAreaAfterx , 1, false);
//                rotateTransition(1000.0, elephantCryptographer, 1, 0.0, 180.0, 1, false);
                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                         coinImgViw.setVisible(true);
//                        scaleTransition(2000.0, simThreeTextArea,1.0,1.5,2,true);

                        simThreeTextArea.setText("The coin lands on heads and both cryptographers see that. However the snake has no way of seeing it");


                        rotateTransition(500.0, coinImgViw, 0,0.0, 720.0, 4, false);
                        translateTransitionY(2000.0, coinImgViw, coinImgViw.getY(), coinImgViw.getY() - 500, 1, true);

                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                rotateTransition(500.0, coinImgViw, 0, 0.0, 720.0, 4, false);
                                translateTransitionY(1500.0, coinImgViw, coinImgViw.getY() - 500, coinImgViw.getY(), 1, true);

                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        sleeping(1000.0);
                                        coinImgViw.setVisible(false);
                                        translateTransitionX(2000.0, snakeCryptographer, dogCryptographer.getX()-(simThreeStackPane.getWidth()/5)*4, dogCryptographer.getX(), 1, false);
                                        translateTransitionX(2000.0, elephantCryptographer, elephantCryptographer.getX()-100, elephantCryptographer.getX(), 1, false);
                                        translateTransitionX(2000.0, simThreeTextArea, textAreaAfterx, textAreax, 1, false);
                                        fadeTransition(2000.0,dogCryptographer,0.0,1.0,1,false);

                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {
                                                basicThree2();
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
     * creates fourth section of animation
     */
    public void basicThree3(){

        simThreeTextArea.setText("If the NSA has paid, the three cryptographers are all honest and say whether the two coin flips they " +
                "have witnessed were the same or different. The cryptographers will all be aware that the NSA paid because their is an even number" +
                "of cryptographers which are stating different ");
        scaleTransition(8000.0, simThreeTextArea, 2.5, 2.5, 2, true);
        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                elephantSpeechBubble.setVisible(true);
                dogSpeechBubble.setVisible(true);
                snakeSpeechBubbleDifferent.setVisible(true);
                sleeping(1000.0);

                fadeTransition(1000.0, elephantCryptographer, 1.0,0.5,1,true);
                fadeTransition(1000.0, dogCryptographer, 1.0,0.5,1,true);
                fadeTransition(1000.0, snakeCryptographer, 1.0,0.5,1,true);
                fadeTransition(1000.0, elephantCryptographer, 0.5,1.0,1,true);
                fadeTransition(1000.0, dogCryptographer, 0.5,1.0,1,true);
                fadeTransition(1000.0, snakeCryptographer, 0.5,1.0,1,true);
                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        simThreeTextArea.setText("However if a cryptographer paid, that cryptographer will say the opposite to the truth. This will create " +
                                "a situtaion where there is an odd number of cryptographers saying different- so all cryptographers know that a cryptographer paid, " +
                                "however do not know which cryptographer paid");
                        scaleTransition(8000.0, simThreeTextArea, 2.5, 2.5, 2, true);
                        sleeping(2000.0);
                        snakeSpeechBubbleDifferent.setVisible(false);
                        snakeSpeechBubbleSame.setVisible(true);

                        rotateTransition(2000.0, snakeCryptographer,2, 0.0, 360.0, 1, true);
                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                                simThreeTextArea.setText("As you can see here, the snake paid. However there is no way the other two cryptographers can" +
                                        "ever know that it was the snake. This is the principle that DC- nets are based on");
                                scaleTransition(8000.0, simThreeTextArea, 2.5, 2.5, 2, true);
                                sleeping(1000.0);
                            }
                        });

                    }
                });
            }
        });

    }

    /**
     * creates third section of animation
     */
    public void basicThree2() {

        simThreeTextArea.setText("Now the snake flips her coin- which only the snake and the dog can see");
        scaleTransition(4000.0, simThreeTextArea, 2.0, 2.0, 2, true);

// scaleTransition(4000.0, simThreeTextArea, 2.0, 2.0, 2, true);
        scaleTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fadeTransition(2000.0, elephantCryptographer, 1.0, 0.0, 1, false);
                translateTransitionX(2000.0, snakeCryptographer, snakeCryptographer.getX(), snakeCryptographer.getX() - (simThreeStackPane.getWidth() / 5) * 4, 1, false);
                translateTransitionX(2000.0, dogCryptographer, dogCryptographer.getX(), dogCryptographer.getX() + (simThreeStackPane.getWidth() / 5) * 4, 1, false);

                textAreax = simThreeTextArea.getTranslateX();
                textAreaAfterx = simThreeTextArea.getTranslateX() + (simThreeStackPane.getWidth() / 5) * 1;
                translateTransitionX(500.0, coinImgViw, coinImgViw.getX(), coinImgViw.getX() - (simThreeStackPane.getWidth() / 2) * 1, 1, false);
                rotateTransition(1000.0, snakeCryptographer, 1, 0.0, 180.0, 1, false);
                rotateTransition(1000.0, dogCryptographer, 1, 0.0, 180.0, 1, false);
                translateTransitionX(2000.0, simThreeTextArea, simThreeTextArea.getTranslateX(), textAreaAfterx, 1, false);

                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        coinImgViw.setVisible(true);
// scaleTransition(2000.0, simThreeTextArea,1.0,1.5,2,true);

                        simThreeTextArea.setText("The coin lands on heads and both cryptographers see that. However the snake has no way of seeing it");
                        rotateTransition(500.0, coinImgViw, 0, 0.0, 720.0, 4, false);
                        translateTransitionY(2000.0, coinImgViw, coinImgViw.getY(), coinImgViw.getY() - 500, 1, true);

                        tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                rotateTransition(500.0, coinImgViw, 0, 0.0, 720.0, 4, false);
                                translateTransitionY(1500.0, coinImgViw, coinImgViw.getY() - 500, coinImgViw.getY(), 1, true);

                                tranArrList.get(tranArrList.size() - 1).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        sleeping(1000.0);

                                        coinImgViw.setVisible(false);

                                        translateTransitionX(2000.0, snakeCryptographer, snakeCryptographer.getX() + (simThreeStackPane.getWidth() / 5) * 4, dogCryptographer.getX(), 1, false);
                                        translateTransitionX(2000.0, dogCryptographer, dogCryptographer.getX() - (simThreeStackPane.getWidth() / 5) * 4, dogCryptographer.getX(), 1, false);
                                        translateTransitionX(2000.0, simThreeTextArea, textAreaAfterx, textAreax, 1, false);
                                        fadeTransition(2000.0, elephantCryptographer, 0.0, 1.0, 1, false);

                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {
                                                basicThree3();
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
     * creates first section of animation
     */
    public void basicThree0()
    {
        scaleTransition(6000.0, simThreeTextArea,2.0,2.0,2,true);

        scaleTransition.setOnFinished(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                fadeTransition(2000.0,snakeCryptographer,1.0,0.0,1,false);
                translateTransitionX(2000.0, dogCryptographer, dogCryptographer.getX(), dogCryptographer.getX()+900, 1, false);
                translateTransitionX(2000.0, elephantCryptographer, elephantCryptographer.getX(), elephantCryptographer.getX()+100, 1, false);
                textAreax = simThreeTextArea.getTranslateX();
                textAreaAfterx = simThreeTextArea.getTranslateX()-350;
                translateTransitionX(2000.0, simThreeTextArea, simThreeTextArea.getTranslateX(),textAreaAfterx , 1, false);

                tranArrList.get(2).setOnFinished(new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent event)
                    {

                        coinImgViw.setVisible(true);
                        simThreeTextArea.setText("The coin lands on heads and both cryptographers see that. However the snake has no way of seeing it");

                        rotateTransition(1000.0, elephantCryptographer, 1, 0.0, 180.0, 1, false);
                        rotateTransition(500.0, coinImgViw, 0,0.0, 720.0, 4, false);
                        translateTransitionY(2000.0, coinImgViw, coinImgViw.getY(), coinImgViw.getY() - 500, 1, true);
                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                rotateTransition(500.0, coinImgViw, 0, 0.0, 720.0, 4, false);
                                translateTransitionY(1500.0, coinImgViw, coinImgViw.getY()-500, coinImgViw.getY(), 1, true);

                                tranArrList.get(9).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        sleeping(1000.0);

                                        coinImgViw.setVisible(false);
                                        translateTransitionX(2000.0, dogCryptographer, dogCryptographer.getX()+900, dogCryptographer.getX(), 1, false);
                                        translateTransitionX(2000.0, elephantCryptographer, elephantCryptographer.getX()+100, elephantCryptographer.getX(), 1, false);
                                        translateTransitionX(2000.0, simThreeTextArea, textAreaAfterx, textAreax, 1, false);
                                        fadeTransition(2000.0,snakeCryptographer,0.0,1.0,1,false);

                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {
                                                pool.execute(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        basicThree1();
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
