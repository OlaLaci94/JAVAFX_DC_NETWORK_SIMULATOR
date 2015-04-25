package simulator;

import javafx.animation.Animation;
import javafx.animation.Transition;
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
 * Created by Ola Laci on 21/04/2015.
 */
public class ControllerKeyExchange implements ControlTemp, Initializable, Runnable
{

    ScreenController screenController;
    DiffieHelmanKeyExchange dhKeyExchange;

    @FXML
    private Button backSimulatorBtn, playSimulatorBtn,pauseSimulatorBtn;
    @FXML
    private TextFlow textFlow;
    @FXML
    private ImageView dogImgViw, elephantImgViw, dogPrivateKey, dogPublicKey, elephantPrivateKey, elephantPublicKey, alphaImgViw, pImgViw;
    @FXML
    private StackPane stackPane;






    public void initialize(URL fxmlFileLocation, ResourceBundle resources)
    {
        // initialize your logic here: all @FXML variables will have been injected
        assert backSimulatorBtn != null : "fx:id=\"backSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert pauseSimulatorBtn != null : "fx:id=\"pauseSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert playSimulatorBtn != null : "fx:id=\"playSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert stackPane != null : "fx:id=\"stackPane\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert textFlow != null : "fx:id=\"textFlow\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert elephantImgViw != null : "fx:id=\"elephantImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert dogPrivateKey != null : "fx:id=\"dogPrivateKey\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert dogImgViw != null : "fx:id=\"dogImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert dogPublicKey != null : "fx:id=\"dogPublicKey\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert elephantPrivateKey != null : "fx:id=\"elephantPrivateKey\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert elephantPublicKey != null : "fx:id=\"elephantPublicKey\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert alphaImgViw != null : "fx:id=\"alphaImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert pImgViw != null : "fx:id=\"pImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";


    }

    public void run(){

        dhKeyExchange = new DiffieHelmanKeyExchange(backSimulatorBtn, playSimulatorBtn,pauseSimulatorBtn, textFlow, dogImgViw,
                elephantImgViw, dogPrivateKey, dogPublicKey, elephantPrivateKey, elephantPublicKey, alphaImgViw, pImgViw, stackPane);

        playSimulatorBtn.setDisable(true);

    }

    public void backKey()
    {
        for(int i = 0; i<dhKeyExchange.tranArrList.size(); i++){

            Transition transition = dhKeyExchange.tranArrList.get(i);
            transition.stop();
        }
        dhKeyExchange.tranArrList.clear();
        screenController.setScreen(Main.mainScreenID);
    }

    public void pauseKey(){
        for(Transition tran: dhKeyExchange.tranArrList){

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
        for(Transition tran: dhKeyExchange.tranArrList){

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
