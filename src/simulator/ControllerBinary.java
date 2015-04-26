package simulator;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ola Laci on 26/04/2015.
 */
public class ControllerBinary implements ControlTemp, Initializable, Runnable {

    ScreenController screenController;
    BinaryAnimation binaryAnimation;

    @FXML
    private Button backSimulatorBtn, playSimulatorBtn,pauseSimulatorBtn;
    @FXML
    private TextFlow textFlow;
    @FXML
    private ImageView dogImgViw, elephantImgViw, dogPublicKey, elephantPublicKey, messageImgViw, poolImgViw, roundKeysImgViw, thetaImgViw;
    @FXML
    private StackPane stackPane;

    /**
     * Method of Initializable and passes in the widgets from the fxml file while checking they are injected correctly.
     * @param fxmlFileLocation
     * @param resources
     */
    public void initialize(URL fxmlFileLocation, ResourceBundle resources){

        assert backSimulatorBtn != null : "fx:id=\"backSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert pauseSimulatorBtn != null : "fx:id=\"pauseSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert playSimulatorBtn != null : "fx:id=\"playSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert stackPane != null : "fx:id=\"stackPane\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert textFlow != null : "fx:id=\"textFlow\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert elephantImgViw != null : "fx:id=\"elephantImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert messageImgViw != null : "fx:id=\"messageImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert dogImgViw != null : "fx:id=\"dogImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert dogPublicKey != null : "fx:id=\"dogPublicKey\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert elephantPublicKey != null : "fx:id=\"elephantPublicKey\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert poolImgViw != null : "fx:id=\"poolImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert roundKeysImgViw != null : "fx:id=\"roundKeysImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert thetaImgViw != null : "fx:id=\"thetaImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";


    }


    public void run(){

        binaryAnimation = new BinaryAnimation(backSimulatorBtn, playSimulatorBtn,pauseSimulatorBtn, textFlow, dogImgViw, elephantImgViw,
                dogPublicKey, elephantPublicKey,  messageImgViw, stackPane, poolImgViw, roundKeysImgViw, thetaImgViw);


    }



    public void backKey(){

        for(int i = 0; i<binaryAnimation.tranArrList.size(); i++){

            Transition transition = binaryAnimation.tranArrList.get(i);
            transition.stop();
        }
        binaryAnimation.tranArrList.clear();
        screenController.setScreen(Main.mainScreenID);

    }

    public void pauseKey(){
        for(Transition tran: binaryAnimation.tranArrList){

            if( tran.getStatus().equals(Animation.Status.RUNNING)){
                tran.pause();
            }
            else{
                System.out.println(tran.toString()+ "not");
            }
        }

        playSimulatorBtn.setDisable(false);


    }

    public void playKey(){
        for(Transition tran: binaryAnimation.tranArrList){

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
