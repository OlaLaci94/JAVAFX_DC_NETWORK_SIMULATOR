package simulator;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ola Laci on 23/04/2015.
 */
public class ControllerArbitraryAlphabet implements ControlTemp, Initializable, Runnable {

    ScreenController screenController;
    ArbitraryAlphabetAnimation arbitraryAlphabetAnimation;

    @FXML
    private Button backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn;
    @FXML
    private StackPane stackPane;
    @FXML
    private ImageView snakeImgViw, elephantImgViw, keyImgViw,keyImgViw1, poolImgViw, alphaImgViw, mapImgVw, mathImgViw;
    @FXML
    private TextArea partialPad1,partialPad2,partialPad3,partialPad4,partialPad5,partialPad6;
    @FXML
    private HBox vector;
    @FXML
    private TextFlow textflow;

    public void initialize(URL fxmlFileLocation, ResourceBundle resources){

        // initialize your logic here: all @FXML variables will have been injected
        assert backSimulatorBtn != null : "fx:id=\"backSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert pauseSimulatorBtn != null : "fx:id=\"pauseSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert playSimulatorBtn != null : "fx:id=\"playSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert stackPane != null : "fx:id=\"stackPane\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert snakeImgViw != null : "fx:id=\"snakeImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert poolImgViw != null : "fx:id=\"poolImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert elephantImgViw != null : "fx:id=\"elephantImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert keyImgViw != null : "fx:id=\"keyImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert keyImgViw1 != null : "fx:id=\"keyImgViw1\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert vector != null : "fx:id=\"vector\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert partialPad1 != null : "fx:id=\"partialPad1\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert partialPad2 != null : "fx:id=\"partialPad2\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert partialPad3 != null : "fx:id=\"partialPad3\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert partialPad4 != null : "fx:id=\"partialPad4\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert partialPad5 != null : "fx:id=\"partialPad5\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert partialPad6 != null : "fx:id=\"partialPad6\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert alphaImgViw != null : "fx:id=\"alphaImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert textflow != null : "fx:id=\"textflow\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert mapImgVw != null : "fx:id=\"mapImgVw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert mathImgViw != null : "fx:id=\"mathImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";





    }


    public void run()
    {
        arbitraryAlphabetAnimation = new ArbitraryAlphabetAnimation( backSimulatorBtn,  pauseSimulatorBtn,  playSimulatorBtn,  stackPane,
                 poolImgViw, snakeImgViw,  elephantImgViw,  keyImgViw,  keyImgViw1,  textflow, partialPad1,  partialPad2,  partialPad3,  partialPad4,
                 partialPad5, partialPad6, vector, mapImgVw, alphaImgViw, mathImgViw);

        playSimulatorBtn.setDisable(true);
    }

    public void aASimBack()
    {
        for(int i = 0; i<arbitraryAlphabetAnimation.tranArrList.size(); i++){

            Transition transition = arbitraryAlphabetAnimation.tranArrList.get(i);
            transition.stop();
        }
        arbitraryAlphabetAnimation.tranArrList.clear();
        screenController.setScreen(Main.mainScreenID);
    }

    public void aASimPause()
    {
        for(Transition tran: arbitraryAlphabetAnimation.tranArrList){

            if( tran.getStatus().equals(Animation.Status.RUNNING)){
                tran.pause();
            }
            else{
                System.out.println(tran.toString()+ "not");
            }
        }
        playSimulatorBtn.setDisable(false);
    }

    public void aASimPlay()
    {
        for(Transition tran: arbitraryAlphabetAnimation.tranArrList){

            if( tran.getStatus().equals(Animation.Status.PAUSED)){
                tran.play();
            }
            else{
                System.out.println(tran.toString()+ "not");
            }
        }
        playSimulatorBtn.setDisable(true);
    }



    /**
     *  Implementation of ControlTemp interface
     * @param screensController
     */
    public void setControlParent(ScreenController screensController)
    {
        screenController = screensController;

    }



}
