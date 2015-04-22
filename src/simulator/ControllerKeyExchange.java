package simulator;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

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
    private Button backSimulatorBtn;
    @FXML
    private Button  pauseSimulatorBtn;
    @FXML
    private Button playSimulatorBtn;
    @FXML
    private StackPane stackPane;
    @FXML
    private ImageView snakeImgViw;
    @FXML
    private ImageView elephantImgViw;
    @FXML
    private TextArea textArea;
    @FXML
    private ImageView dogImgViw;
    @FXML
    private TextArea elephantTextArea;
    @FXML
    private TextArea snakeTextArea;




    public void initialize(URL fxmlFileLocation, ResourceBundle resources)
    {
        // initialize your logic here: all @FXML variables will have been injected
        assert backSimulatorBtn != null : "fx:id=\"backSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert pauseSimulatorBtn != null : "fx:id=\"pauseSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert playSimulatorBtn != null : "fx:id=\"playSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert stackPane != null : "fx:id=\"stackPane\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert snakeImgViw != null : "fx:id=\"snakeImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert elephantImgViw != null : "fx:id=\"elephantImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert dogImgViw != null : "fx:id=\"dogImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert elephantTextArea != null : "fx:id=\"elephantTextArea\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert snakeTextArea != null : "fx:id=\"snakeTextArea\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";


    }

    public void run(){

        dhKeyExchange = new DiffieHelmanKeyExchange(backSimulatorBtn,  pauseSimulatorBtn,  playSimulatorBtn,  stackPane,
                 snakeImgViw,  elephantImgViw,  dogImgViw,  textArea, elephantTextArea,  snakeTextArea);

        playSimulatorBtn.setDisable(true);

    }

    public void kESimBack()
    {
        for(int i = 0; i<dhKeyExchange.tranArrList.size(); i++){

            Transition transition = dhKeyExchange.tranArrList.get(i);
            transition.stop();
        }
        dhKeyExchange.tranArrList.clear();
        screenController.setScreen(Main.mainScreenID);
    }

    public void kESimPause(){
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

    public void kESimPlay(){
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
