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
public class ControllerDisco implements ControlTemp, Initializable, Runnable{

    ScreenController screenController;
    DiscoSimulation discoSimulation;

    @FXML
    private Button  pauseSimulatorBtn, playSimulatorBtn, backSimulatorBtn;
    @FXML
    private HBox signatureVector;
    @FXML
    private TextFlow textFlow;
    @FXML
    private StackPane stackPane;
    @FXML
    private ImageView elephantImgViw, clawImgViw, treeImgViw, hImgViw, thetaImgViw, snakeImgViw, messageImgViw;
    @FXML
    private TextArea signatureVector1, signatureVector2,signatureVector3,signatureVector4,signatureVector5,signatureVector6;


    public void initialize(URL fxmlFileLocation, ResourceBundle resources){

        // initialize your logic here: all @FXML variables will have been injected
        assert backSimulatorBtn != null : "fx:id=\"backSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert pauseSimulatorBtn != null : "fx:id=\"pauseSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert playSimulatorBtn != null : "fx:id=\"playSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert stackPane != null : "fx:id=\"stackPane\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert snakeImgViw != null : "fx:id=\"snakeImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert elephantImgViw != null : "fx:id=\"elephantImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert textFlow != null : "fx:id=\"textFlow\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert signatureVector1 != null : "fx:id=\"signatureVector1\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert signatureVector2 != null : "fx:id=\"signatureVector2\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert signatureVector3 != null : "fx:id=\"signatureVector3\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert signatureVector4 != null : "fx:id=\"signatureVector4\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert signatureVector5 != null : "fx:id=\"signatureVector5\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert signatureVector6 != null : "fx:id=\"signatureVector6\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert clawImgViw != null : "fx:id=\"clawImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert treeImgViw != null : "fx:id=\"treeImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert hImgViw != null : "fx:id=\"hImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert signatureVector != null : "fx:id=\"signatureVector\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert thetaImgViw != null : "fx:id=\"thetaImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert messageImgViw != null : "fx:id=\"messageImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";



    }


    public void run(){

        discoSimulation = new DiscoSimulation(backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn, stackPane,messageImgViw, thetaImgViw,
                snakeImgViw, elephantImgViw, textFlow, signatureVector,signatureVector1,signatureVector2,signatureVector3,signatureVector4,
                signatureVector5,signatureVector6, clawImgViw, treeImgViw, hImgViw);

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
