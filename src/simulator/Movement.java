package simulator;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * Created by Ola Laci on 21/04/2015.
 */
public class Movement {

        ScaleTransition scaleTransition;
        FadeTransition fadeTransition;
        TranslateTransition translateTransitionX, translateTransitionY;
        RotateTransition rotateTransition;
        ArrayList<Transition> tranArrList;


        /**
         * creates a TranslateTransition object for x movement(left and right) and alters it to the input parameters, plays the transition and adds it to the tranArrList.
         *
         * @param time
         * @param node
         * @param from
         * @param to
         * @param cycleCount
         * @param autoReverse
         */
        public void translateTransitionX(Double time, Node node, Double from, Double to, int cycleCount, boolean autoReverse){

            translateTransitionX = new TranslateTransition(Duration.millis(time), node);
            translateTransitionX.setFromX(from);
            translateTransitionX.setToX(to);
            translateTransitionX.setCycleCount(cycleCount);
            translateTransitionX.setAutoReverse(autoReverse);
            translateTransitionX.play();
            tranArrList.add(translateTransitionX);
        }

        /**
         * creates a TranslateTransition object for y movement(up and down) and alters it to the input parameters, plays the transition and adds it to the tranArrList.
         * @param time
         * @param node
         * @param from
         * @param to
         * @param cycleCount
         * @param autoReverse
         */
        public void translateTransitionY(Double time, Node node, Double from, Double to, int cycleCount, boolean autoReverse){

            translateTransitionY = new TranslateTransition(Duration.millis(time), node);
            translateTransitionY.setFromY(from);
            translateTransitionY.setToY(to);
            translateTransitionY.setCycleCount(cycleCount);
            translateTransitionY.setAutoReverse(autoReverse);
            translateTransitionY.play();
            tranArrList.add(translateTransitionY);
        }


        /**
         * creates a ScaleTransition object and alters it to the input parameters, plays the transition and adds it to the tranArrList.
         * @param time
         * @param node
         * @param setToX
         * @param setToY
         * @param cycleCount
         * @param autoReverse
         */
        public void scaleTransition(Double time, Node node, Double setToX, Double setToY, int cycleCount, boolean autoReverse){

            scaleTransition =new ScaleTransition(Duration.millis(time), node);
            scaleTransition.setToX(setToX);
            scaleTransition.setToY(setToY);
            scaleTransition.setCycleCount(cycleCount);
            scaleTransition.setAutoReverse(autoReverse);
            scaleTransition.play();
            tranArrList.add(scaleTransition);
        }

        /**
         * creates a FadeTransition object and alters it to the input parameters, plays the transition and adds it to the tranArrList.
         * @param time
         * @param node
         * @param from
         * @param to
         * @param cycleCount
         * @param autoReverse
         */
        public void fadeTransition(Double time, Node node, Double from, Double to, int cycleCount, boolean autoReverse){

            fadeTransition = new FadeTransition(Duration.millis(time), node);
            fadeTransition.setFromValue(from);
            fadeTransition.setToValue(to);
            fadeTransition.setCycleCount(cycleCount);
            fadeTransition.setAutoReverse(autoReverse);
            fadeTransition.play();
            tranArrList.add(fadeTransition);
        }

        /**
         *  creates a RotateTransition object and alters it to the input parameters, plays the transition and adds it to the tranArrList.
         * @param time
         * @param node
         * @param point
         * @param from
         * @param to
         * @param cycleCount
         * @param autoReverse
         */
        public void rotateTransition(Double time, Node node, int point, Double from, Double to, int cycleCount, boolean autoReverse)
        {
            rotateTransition = new RotateTransition(Duration.millis(time), node);
            switch(point)
            {
                case 0: rotateTransition.setAxis(Rotate.X_AXIS);
                    break;
                case 1: rotateTransition.setAxis(Rotate.Y_AXIS);
                    break;
                case 2: rotateTransition.setAxis(Rotate.Z_AXIS);
                    break;
                default:
                    System.out.println("Error in rotateTransition. in default point case!!!!");
            }
            rotateTransition.setFromAngle(from);
            rotateTransition.setToAngle(to);
            rotateTransition.setInterpolator(Interpolator.LINEAR);
            rotateTransition.setCycleCount(cycleCount);
            rotateTransition.setAutoReverse(autoReverse);
            rotateTransition.play();
            tranArrList.add(rotateTransition);

        }

        /**
         *  causes the thread to sleep for parameter time. Used for timing purposes within the animation.
         *
         * @param time
         */
        public void sleeping(Double time)
        {
            long newTime = time.longValue();
            try
            {
                Thread.sleep(newTime);
            }
            catch (InterruptedException e)
            {

            }

        }





}
