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
 * Created by Ola Laci on 23/04/2015.
 */
public class ControllerDisco implements ControlTemp, Initializable, Runnable{

    ScreenController screenController;
    DiscoSimulation discoSimulation;
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


    public void initialize(URL fxmlFileLocation, ResourceBundle resources){

        // initialize your logic here: all @FXML variables will have been injected
        assert backSimulatorBtn != null : "fx:id=\"backSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert pauseSimulatorBtn != null : "fx:id=\"pauseSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert playSimulatorBtn != null : "fx:id=\"playSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert stackPane != null : "fx:id=\"stackPane\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert snakeImgViw != null : "fx:id=\"snakeImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert elephantImgViw != null : "fx:id=\"elephantImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";


    }


    public void run(){

        discoSimulation = new DiscoSimulation(backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn, stackPane,
                snakeImgViw, elephantImgViw, textArea);

        playSimulatorBtn.setDisable(true);


    }

    public void cDSimBack()
    {
        for(int i = 0; i<discoSimulation.tranArrList.size(); i++){

            Transition transition = discoSimulation.tranArrList.get(i);
            transition.stop();
        }
        discoSimulation.tranArrList.clear();
        screenController.setScreen(Main.mainScreenID);
    }

    public void cDSimPause()
    {
        for(Transition tran: discoSimulation.tranArrList){

            if( tran.getStatus().equals(Animation.Status.RUNNING)){
                tran.pause();
            }
            else{
                System.out.println(tran.toString()+ "not");
            }
        }
        playSimulatorBtn.setDisable(false);
    }

    public void cDSimPlay()
    {
        for(Transition tran: discoSimulation.tranArrList){

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
