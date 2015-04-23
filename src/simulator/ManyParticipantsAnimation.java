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
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * Created by Ola Laci on 22/04/2015.
 */
public class ManyParticipantsAnimation extends Movement {

    private Button backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn;
    private StackPane stackPane;
    private ImageView squirrelImgViw, elephantImgViw, snakeImgViw, dogImgViw, crocodileImgViw, penguinImgViw, chickenImgViw, pandaImgViw;
    private TextArea elephantVector1, elephantVector2, elephantVector3, elephantVector4, elephantVector5, elephantVector6,
            reservationVector1, reservationVector2, reservationVector3, reservationVector4, reservationVector5, reservationVector6,
            reservationVector7, cryptographerVector1, cryptographerVector2, cryptographerVector3, cryptographerVector4, cryptographerVector5,
            cryptographerVector6, cryptographer2Vector1, cryptographer2Vector2, cryptographer2Vector3, cryptographer2Vector4,
            cryptographer2Vector5, cryptographer2Vector6,  cryptographer3Vector1, cryptographer3Vector2, cryptographer3Vector3,
            cryptographer3Vector4, cryptographer3Vector5, cryptographer3Vector6,  cryptographer4Vector1, cryptographer4Vector2,
            cryptographer4Vector3, cryptographer4Vector4, cryptographer4Vector5, cryptographer4Vector6,  cryptographer5Vector1,
            cryptographer5Vector2, cryptographer5Vector3, cryptographer5Vector4, cryptographer5Vector5, cryptographer5Vector6, cryptographer5Vector7,
            cryptographer6Vector1, cryptographer6Vector2, cryptographer6Vector3, cryptographer6Vector4, cryptographer6Vector5, cryptographer6Vector6,  mPTextArea;
    private HBox elephantVector, reservationVector, cryptographerVector, cryptographer2Vector, cryptographer3Vector;
    private VBox cryptographer4Vector, cryptographer5Vector, cryptographer6Vector;

    public ManyParticipantsAnimation(ImageView squirrelImgViw, ImageView elephantImgViw,ImageView snakeImgViw,ImageView dogImgViw, ImageView crocodileImgViw,ImageView penguinImgViw, ImageView chickenImgViw, ImageView pandaImgViw, Button backSimulatorBtn,
                                     Button pauseSimulatorBtn, Button playSimulatorBtn, StackPane stackPane,
                                     TextArea elephantVector1, TextArea elephantVector2, TextArea elephantVector3, TextArea elephantVector4, TextArea elephantVector5, TextArea elephantVector6,
                                     TextArea reservationVector1, TextArea reservationVector2, TextArea reservationVector3,TextArea reservationVector4, TextArea reservationVector5, TextArea reservationVector6,
                                     TextArea reservationVector7, TextArea cryptographerVector1, TextArea cryptographerVector2,TextArea cryptographerVector3, TextArea cryptographerVector4, TextArea cryptographerVector5,
                                     TextArea cryptographerVector6,  TextArea cryptographer2Vector1,TextArea cryptographer2Vector2, TextArea cryptographer2Vector3, TextArea cryptographer2Vector4,
                                     TextArea cryptographer2Vector5, TextArea cryptographer2Vector6, TextArea cryptographer3Vector1, TextArea cryptographer3Vector2, TextArea cryptographer3Vector3,
                                     TextArea cryptographer3Vector4, TextArea cryptographer3Vector5, TextArea cryptographer3Vector6, TextArea cryptographer4Vector1, TextArea cryptographer4Vector2,
                                     TextArea cryptographer4Vector3, TextArea cryptographer4Vector4, TextArea cryptographer4Vector5,TextArea cryptographer4Vector6,  TextArea cryptographer5Vector1,
                                     TextArea cryptographer5Vector2, TextArea cryptographer5Vector3, TextArea cryptographer5Vector4,TextArea cryptographer5Vector5, TextArea cryptographer5Vector6,
                                     TextArea cryptographer6Vector1,TextArea cryptographer6Vector2, TextArea cryptographer6Vector3, TextArea cryptographer6Vector4, TextArea cryptographer6Vector5, TextArea cryptographer6Vector6,
                                      TextArea mPTextArea, HBox elephantVector, HBox reservationVector, HBox cryptographerVector, HBox cryptographer2Vector, HBox cryptographer3Vector,
                                     VBox cryptographer4Vector,VBox cryptographer5Vector, VBox cryptographer6Vector){

       this.backSimulatorBtn = backSimulatorBtn;
        this.pauseSimulatorBtn = pauseSimulatorBtn;
        this.playSimulatorBtn = playSimulatorBtn;
        this.stackPane = stackPane;
        this.elephantImgViw = elephantImgViw;
        this.squirrelImgViw = squirrelImgViw;
        this.snakeImgViw = snakeImgViw;     this.dogImgViw = dogImgViw;     this.crocodileImgViw = crocodileImgViw;     this.penguinImgViw = penguinImgViw;
        this.chickenImgViw = chickenImgViw;     this.pandaImgViw = pandaImgViw;     this.elephantVector1 = elephantVector1;     this.elephantVector2 = elephantVector2;     this.elephantVector3 = elephantVector3;
        this.elephantVector4 = elephantVector4;     this.elephantVector5 = elephantVector5;     this.elephantVector6 = elephantVector6;
        this.reservationVector1 = reservationVector1;       this.reservationVector2 = reservationVector2;       this.reservationVector3 = reservationVector3;       this.reservationVector4 = reservationVector4;
        this.reservationVector5 = reservationVector5;       this.reservationVector6 = reservationVector6;       this.reservationVector7 = reservationVector7;       this.cryptographerVector1 = cryptographerVector1;
        this.cryptographerVector2 = cryptographerVector2;       this.cryptographerVector3 = cryptographerVector3;       this.cryptographerVector4 = cryptographerVector4;       this.cryptographerVector5 = cryptographerVector5;
        this.cryptographerVector6 = cryptographerVector6;            this.cryptographer2Vector1 = cryptographer2Vector1;     this.cryptographer2Vector2 = cryptographer2Vector2;
        this.cryptographer2Vector3 = cryptographer2Vector3;     this.cryptographer2Vector4 = cryptographer2Vector4;     this.cryptographer2Vector5 = cryptographer2Vector5;     this.cryptographer2Vector6 = cryptographer2Vector6;
        this.cryptographer3Vector1 = cryptographer3Vector1;
        this.cryptographer3Vector2 = cryptographer3Vector2;     this.cryptographer3Vector3 = cryptographer3Vector3;     this.cryptographer3Vector4 = cryptographer3Vector4;     this.cryptographer3Vector5 = cryptographer3Vector5;     this.cryptographer3Vector6 = cryptographer3Vector6;
        this.cryptographer4Vector1 = cryptographer4Vector1;     this.cryptographer4Vector2 = cryptographer4Vector2;     this.cryptographer4Vector3 = cryptographer4Vector3;
        this.cryptographer4Vector4 = cryptographer4Vector4;     this.cryptographer4Vector5 = cryptographer4Vector5;     this.cryptographer4Vector6 = cryptographer4Vector6;
        this.cryptographer5Vector1 = cryptographer5Vector1;     this.cryptographer5Vector2 = cryptographer5Vector2;     this.cryptographer5Vector3 = cryptographer5Vector3; this.cryptographer5Vector4 = cryptographer5Vector4;
        this.cryptographer5Vector5 = cryptographer5Vector5;     this.cryptographer5Vector6 = cryptographer5Vector6;     this.cryptographer5Vector7 = cryptographer5Vector7;     this.cryptographer6Vector1 = cryptographer6Vector1;
        this.cryptographer6Vector2 = cryptographer6Vector2;     this.cryptographer6Vector3 = cryptographer6Vector3;     this.cryptographer6Vector4 = cryptographer6Vector4;     this.cryptographer6Vector5 = cryptographer6Vector5;
        this.cryptographer6Vector6 = cryptographer6Vector6;     this.mPTextArea = mPTextArea;
        this.elephantVector = elephantVector;       this.reservationVector = reservationVector;     this.cryptographerVector = cryptographerVector;     this.cryptographer2Vector = cryptographer2Vector;
        this.cryptographer3Vector = cryptographer3Vector;       this.cryptographer4Vector = cryptographer4Vector;       this.cryptographer5Vector = cryptographer5Vector;       this.cryptographer6Vector = cryptographer6Vector;

        tranArrList = new ArrayList<Transition>();

        part1();
    }

    public void part1(){

        mPTextArea.setText("How do we extend this protocol to more than three participants? We use the same steps, but it becomes more " +
                "complex. ");
        scaleTransition(5000.0, mPTextArea, 1.5,1.5, 2, true);

        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fadeTransition(1000.0, dogImgViw, 1.0,0.0,1, false);
                fadeTransition(1000.0, crocodileImgViw, 1.0,0.0,1, false);
                fadeTransition(1000.0, penguinImgViw, 1.0,0.0,1, false);
                fadeTransition(1000.0, chickenImgViw, 1.0,0.0,1, false);
                fadeTransition(1000.0, pandaImgViw, 1.0,0.0,1, false);
                fadeTransition(1000.0, elephantImgViw, 1.0,0.0,1, false);
                fadeTransition(1000.0, squirrelImgViw, 1.0,0.0,1, false);
                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        mPTextArea.setText("Each pair of participants generates and exchanges a shared key. We will assume they are" +
                                " using the Diffie Hellman key exchange protocol. So each participant has a unique shared key with every" +
                                " other participant. They place these keys in an ordered vector of values - which we will refer to as " +
                                "a pad.");
                        scaleTransition(3500.0, mPTextArea, 1.5,1.5,2,true);
                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                scaleTransition(1500.0, snakeImgViw, 1.25,1.25,2,true);
                                mPTextArea.setText("If the snake was part of a DC net consisting of seven people, her vector would look like " +
                                        "this.  ");
                                scaleTransition(2500.0, mPTextArea, 1.5,1.5,2,true);
                                elephantVector.setVisible(true);
                                sleeping(1000.0);
                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {

                                        scaleTransition(1500.0, elephantVector, 2.0,2.0,2,true);

                                elephantVector1.setText("key(snake, elephant)");
                                elephantVector2.setText("key(snake, penguin)");
                                elephantVector3.setText("key(snake, crocodile)");
                                elephantVector4.setText("key(snake, chicken)");
                                elephantVector5.setText("key(snake, panda)");
                                elephantVector6.setText("key(snake, dog)");

                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        mPTextArea.setText("The snake would then choose a random position within that vector and XOR the value of the message she " +
                                                "wishes to broadcast. ");

                                        scaleTransition(2500.0, mPTextArea, 1.5,1.5,2,true);
                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {
                                                elephantVector6.setText("key(snake, dog) XOR MESSAGE");
                                                scaleTransition(4500.0, elephantVector6, 3.5,3.5,2,true);

                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent event) {
                                                        mPTextArea.setText("In the broadcast, all participants will broadcast their vectors, where all shared keys will cancel " +
                                                                "each other out, leaving only the messages the participants wished to broadcast. Provided that the keys are secret " +
                                                                "the anonymity of the sender is unconditional.");

                                                        scaleTransition(4500.0, mPTextArea, 1.5,1.5,2,true);
                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                            @Override
                                                            public void handle(ActionEvent event) {



                                                        cryptographerVector.setVisible(true);
                                                        cryptographer2Vector.setVisible(true);
                                                        cryptographer3Vector.setVisible(true);
                                                        cryptographer4Vector.setVisible(true);
                                                        cryptographer5Vector.setVisible(true);
                                                        cryptographer6Vector.setVisible(true);

                                                        cryptographerVector1.setText("key(elephant, snake) XOR MESSAGE");
                                                        cryptographerVector2.setText("key(elephant, penguin)");
                                                        cryptographerVector3.setText("key(elephant, crocodile)");
                                                        cryptographerVector4.setText("key(elephant, chicken)");
                                                        cryptographerVector5.setText("key(elephant, panda)");
                                                        cryptographerVector6.setText("key(elephant, dog)");

                                                        cryptographer2Vector1.setText("key(penguin, snake) ");
                                                        cryptographer2Vector2.setText("key(penguin, elephant)");
                                                        cryptographer2Vector3.setText("key(penguin, crocodile) XOR MESSAGE");
                                                        cryptographer2Vector4.setText("key(penguin, chicken)");
                                                        cryptographer2Vector5.setText("key(penguin, panda)");
                                                        cryptographer2Vector6.setText("key(penguin, dog)");

                                                                cryptographer3Vector1.setText("key(crocodile, snake) ");
                                                                cryptographer3Vector2.setText("key(crocodile, elephant)");
                                                                cryptographer3Vector3.setText("key(crocodile, penguin)");
                                                                cryptographer3Vector4.setText("key(crocodile, chicken)");
                                                                cryptographer3Vector5.setText("key(crocodile, panda) XOR MESSAGE");
                                                                cryptographer3Vector6.setText("key(crocodile, dog)");

                                                                cryptographer4Vector1.setText("key(panda, snake) ");
                                                                cryptographer4Vector2.setText("key(panda, elephant)");
                                                                cryptographer4Vector3.setText("key(panda, crocodile)");
                                                                cryptographer4Vector4.setText("key(panda, chicken)");
                                                                cryptographer4Vector5.setText("key(panda, penguin) ");
                                                                cryptographer4Vector6.setText("key(panda, dog) XOR MESSAGE");

                                                                cryptographer5Vector1.setText("key(chicken, snake) ");
                                                                cryptographer5Vector2.setText("key(chicken, elephant) XOR MESSAGE");
                                                                cryptographer5Vector3.setText("key(chicken, penguin)");
                                                                cryptographer5Vector4.setText("key(chicken, crocodile)");
                                                                cryptographer5Vector5.setText("key(chicken, panda)");
                                                                cryptographer5Vector6.setText("key(chicken, dog)");

                                                                cryptographer6Vector1.setText("key(dog, snake) ");
                                                                cryptographer6Vector2.setText("key(dog, elephant)");
                                                                cryptographer6Vector3.setText("key(dog, penguin)");
                                                                cryptographer6Vector4.setText("key(dog, chicken)");
                                                                cryptographer6Vector5.setText("key(dog, panda) XOR MESSAGE");
                                                                cryptographer6Vector6.setText("key(dog, crocodile)");


                                                                scaleTransition(2000.0, elephantVector, 1.25,1.25,2, true);
                                                                scaleTransition(2000.0, cryptographerVector, 1.25,1.25,2, true);
                                                                scaleTransition(2000.0, cryptographer2Vector, 1.25,1.25,2, true);
                                                                scaleTransition(2000.0, cryptographer3Vector, 1.25,1.25,2, true);
                                                                scaleTransition(2000.0, cryptographer4Vector, 1.25,1.25,2, true);
                                                                scaleTransition(2000.0, cryptographer5Vector, 1.25,1.25,2, true);
                                                                scaleTransition(2000.0, cryptographer6Vector, 1.25,1.25,2, true);

                                                                System.out.println("finsihed setting text");
                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                    @Override
                                                                    public void handle(ActionEvent event) {
                                                                        System.out.println("before fadetransition");
                                                                        fadeTransition(1500.0, elephantVector, 1.0,0.0,1,false);
                                                                        fadeTransition(1500.0, cryptographerVector, 1.0,0.0,1,false);
                                                                        fadeTransition(1500.0, cryptographer2Vector, 1.0,0.0,1,false);
                                                                        fadeTransition(1500.0, cryptographer3Vector, 1.0,0.0,1,false);
                                                                        fadeTransition(1500.0, cryptographer4Vector, 1.0,0.0,1,false);
                                                                        fadeTransition(1500.0, cryptographer5Vector, 1.0,0.0,1,false);
                                                                        fadeTransition(1500.0, cryptographer6Vector, 1.0,0.0,1,false);

                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                            @Override
                                                                            public void handle(ActionEvent event) {

                                                                                mPTextArea.setText("However, a problem arises. What if two participant choose the same place in the vector- then the messages might XOR" +
                                                                                        " each other out. So, before the broadcasting round, there is a reservation round which forces the participants to a position " +
                                                                                        "in the vector that they wish to broadcast in. This round is repeated until there are no conflicts- two participants wishing to " +
                                                                                        "broadcast in the same round.");
                                                                                scaleTransition(4500.0, mPTextArea, 1.5,1.5,2,true);
                                                                                tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                    @Override
                                                                                    public void handle(ActionEvent event) {

                                                                                        reservationVector.setVisible(true);
                                                                                        reservationVector1.setText("snake");
                                                                                        reservationVector2.setText("elephant");
                                                                                        reservationVector3.setText("dog");
                                                                                        reservationVector4.setText("panda");
                                                                                        reservationVector5.setText("crocodile");
                                                                                        reservationVector6.setText("chicken");
                                                                                        reservationVector7.setText("penguin");


                                                                                        scaleTransition(2500.0, reservationVector, 1.5,1.5,2,true);
                                                                                        tranArrList.get(tranArrList.size()-1).setOnFinished(new EventHandler<ActionEvent>() {
                                                                                            @Override
                                                                                            public void handle(ActionEvent event) {

                                                                                                mPTextArea.setText("This protocol can be applied to as many participants as you would like.");
                                                                                                scaleTransition(2500.0, mPTextArea, 1.5,1.5,2,true);
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
