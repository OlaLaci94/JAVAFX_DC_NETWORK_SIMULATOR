package simulator;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *  Controller class for simulatorThreeLayout.fxml. Handles all logic of this specific screen
 */
public class ControllerThree implements ControlTemp, Initializable, Runnable
{

    ScreenController controller;
    BasicIdeaSimulation basicIdeaSimulation;

    @FXML
    private Button threeSimPauseBtn, threeSimBackBtn, threeSimPlayBtn;
    @FXML
    private ImageView snakeCryptographer, elephantCryptographer, dogCryptographer, coinImgViw, snakeSpeechBubbleSame, snakeSpeechBubbleDifferent,
            elephantSpeechBubble, dogSpeechBubble, coinTailsImgViw;
    @FXML
    private StackPane simThreeStackPane;
    @FXML
    private TextFlow textFlow;



    /**
     *  Implementation of Initializable interface-- connects widgets to their fxml file and adds some listeners for those widgets
     *
     * @param fxmlFileLocation
     * @param resources
     */
    @FXML
    public void initialize(URL fxmlFileLocation, ResourceBundle resources){

        assert threeSimPauseBtn != null : "fx:id=\"threeSimPauseBtn\" was not injected: check your FXML file 'simulatorThreeLayout.fxml'.";
        assert snakeCryptographer != null : "fx:id=\"snakeCryptographer\" was not injected: check your FXML file 'simulatorThreeLayout.fxml'.";
        assert threeSimBackBtn != null : "fx:id=\"threeSimBackBtn\" was not injected: check your FXML file 'simulatorThreeLayout.fxml'.";
        assert threeSimPlayBtn != null : "fx:id=\"threeSimPlayBtn\" was not injected: check your FXML file 'simulatorThreeLayout.fxml'.";
        assert elephantCryptographer != null : "fx:id=\"elephantCryptographer\" was not injected: check your FXML file 'simulatorThreeLayout.fxml'.";
        assert dogCryptographer != null : "fx:id=\"dogCryptographer\" was not injected: check your FXML file 'simulatorThreeLayout.fxml'.";
        assert simThreeStackPane != null : "fx:id=\"simThreeStackPane\" was not injected: check your FXML file 'simulatorThreeLayout.fxml'.";
        assert textFlow != null : "fx:id=\"textFlow\" was not injected: check your FXML file 'simulatorThreeLayout.fxml'.";
        assert coinImgViw != null : "fx:id=\"coinImgViw\" was not injected: check your FXML file 'simulatorThreeLayout.fxml'.";
        assert elephantSpeechBubble != null : "fx:id=\"elephantSpeechBubble\" was not injected: check your FXML file 'simulatorThreeLayout.fxml'.";
        assert dogSpeechBubble != null : "fx:id=\"dogSpeechBubble\" was not injected: check your FXML file 'simulatorThreeLayout.fxml'.";
        assert snakeSpeechBubbleSame != null : "fx:id=\"snakeSpeechBubbleSame\" was not injected: check your FXML file 'simulatorThreeLayout.fxml'.";
        assert snakeSpeechBubbleDifferent != null : "fx:id=\"snakeSpeechBubbleDifferent\" was not injected: check your FXML file 'simulatorThreeLayout.fxml'.";
        assert coinTailsImgViw != null : "fx:id=\"coinTailsImgViw\" was not injected: check your FXML file 'simulatorThreeLayout.fxml'.";
    }

    /**
     *  Creates a BasicIdeaSimulation object to run the animation
     */
    public void run(){

        basicIdeaSimulation = new BasicIdeaSimulation(coinTailsImgViw,
                snakeCryptographer,
                elephantCryptographer,
                dogCryptographer,
                coinImgViw,
                simThreeStackPane,
                textFlow, elephantSpeechBubble, dogSpeechBubble, snakeSpeechBubbleSame, snakeSpeechBubbleDifferent);

        threeSimPlayBtn.setDisable(true);

    }
    /**
     *  Eventhandler of threeSimBackBtn
     */
    public void threeSimBack(){

        for(int i = 0; i<basicIdeaSimulation.tranArrList.size(); i++){

            Transition transition = basicIdeaSimulation.tranArrList.get(i);
            transition.stop();
        }
        basicIdeaSimulation.tranArrList.clear();
        controller.setScreen(Main.mainScreenID);
    }

    /**
     *  Eventhandler of threeSimPauseBtn
     */
    public void threeSimPause(){

        for(Transition tran: basicIdeaSimulation.tranArrList){

           if( tran.getStatus().equals(Animation.Status.RUNNING)){
               tran.pause();
           }
            else{
               System.out.println(tran.toString()+ "not");
           }
        }
        threeSimPlayBtn.setDisable(false);
    }




    /**
     *  Eventhandler of threeSimPlayBtn
     */
    public void threeSimPlay(){

        for(Transition tran: basicIdeaSimulation.tranArrList)
        {
            if( tran.getStatus().equals(Animation.Status.PAUSED)){
                tran.play();
            }
            else{
                System.out.println(tran.toString()+ "not");
            }
        }
        threeSimPlayBtn.setDisable(true);

    }

    /**
     *  Implementation of ControlTemp interface
     * @param screensController
     */
    public void setControlParent(ScreenController screensController)
    {
        this.controller = screensController;
    }

}
