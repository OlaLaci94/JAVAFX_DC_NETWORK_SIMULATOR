package simulator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *  Controller class for simulatorFourLayout.fxml. Handles all logic of this specific screen
 */
public class ControllerFour implements ControlTemp, Initializable {

    ScreenController controller;
    @FXML
    private Button backSimulatorBtn;
    @FXML
    private Button pauseSimulatorBtn;
    @FXML
    private ImageView snakeImgViw;
    @FXML
    private ImageView elephantImgViw;
    @FXML
    private TextArea textArea;
    @FXML
    private ImageView dogImgViw;
    @FXML
    private ImageView squirrelImgViw;

    /**
     *  Implementation of ControlTemp interface
     * @param screensController
     */
    public void setControlParent(ScreenController screensController)
    {
        controller = screensController;

    }
    /**
     *  Implementation of Initializable interface-- connects widgets to their fxml file and adds some listeners for those widgets
     *
     * @param fxmlFileLocation
     * @param resources
     */
    @FXML
    public void initialize(URL fxmlFileLocation, ResourceBundle resources)
    {
    // initialize your logic here: all @FXML variables will have been injected
        assert backSimulatorBtn != null : "fx:id=\"backSimulatorBtn\" was not injected: check your FXML file 'simulatorFourLayout.fxml'.";
        assert pauseSimulatorBtn != null : "fx:id=\"pauseSimulatorBtn\" was not injected: check your FXML file 'simulatorFourLayout.fxml'.";
        assert snakeImgViw != null : "fx:id=\"snakeImgViw\" was not injected: check your FXML file 'simulatorFourLayout.fxml'.";
        assert elephantImgViw != null : "fx:id=\"elephantImgViw\" was not injected: check your FXML file 'simulatorFourLayout.fxml'.";
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'simulatorFourLayout.fxml'.";
        assert dogImgViw != null : "fx:id=\"dogImgViw\" was not injected: check your FXML file 'simulatorFourLayout.fxml'.";
        assert squirrelImgViw != null : "fx:id=\"squirrelImgViw\" was not injected: check your FXML file 'simulatorFourLayout.fxml'.";






    }

    public void fourSimBack()
    {
        controller.setScreen(Main.mainScreenID);
    }

    public void fourSimPause(){

    }

    public void fourSimPlay(){


    }


}
