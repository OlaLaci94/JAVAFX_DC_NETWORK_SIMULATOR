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
 * Controller class for simulatorVoting.fxml
 */
public class ControllerVoting implements ControlTemp, Initializable, Runnable {


    ScreenController screenController;
    VotingSimulation votingSimulation;

    @FXML
    private Button backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn;
    @FXML
    private StackPane stackPane;
    @FXML
    private ImageView snakeImgViw, dogImgViw, magnifyingGlassImgViw, commitmentImgViw, privateKeyImgViw, publicKeyImgViw, roundKeyImgViw, poolImgViw, messageImgViw, elephantImgViw, sharedKeyImgViw;
    @FXML
    private TextArea signatureVector1, signatureVector2, signatureVector3, signatureVector4, signatureVector5, signatureVector6, signatureVector7;
    @FXML
    private HBox signatureVector;
    @FXML
    private TextFlow textFlow;

    /**
     * Method of Initializable and passes in the widgets from the fxml file while checking they are injected correctly.
     *
     * @param fxmlFileLocation
     * @param resources
     */
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        assert backSimulatorBtn != null : "fx:id=\"backSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert pauseSimulatorBtn != null : "fx:id=\"pauseSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert playSimulatorBtn != null : "fx:id=\"playSimulatorBtn\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert stackPane != null : "fx:id=\"stackPane\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert snakeImgViw != null : "fx:id=\"snakeImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert elephantImgViw != null : "fx:id=\"elephantImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert dogImgViw != null : "fx:id=\"dogImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert privateKeyImgViw != null : "fx:id=\"privateKeyImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert publicKeyImgViw != null : "fx:id=\"publicKeyImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert roundKeyImgViw != null : "fx:id=\"roundKeyImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert poolImgViw != null : "fx:id=\"poolImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert messageImgViw != null : "fx:id=\"messageImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert textFlow != null : "fx:id=\"textFlow\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert signatureVector1 != null : "fx:id=\"signatureVector1\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert signatureVector2 != null : "fx:id=\"signatureVector2\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert signatureVector3 != null : "fx:id=\"signatureVector3\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert signatureVector4 != null : "fx:id=\"signatureVector4\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert signatureVector5 != null : "fx:id=\"signatureVector5\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert signatureVector6 != null : "fx:id=\"signatureVector6\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert signatureVector != null : "fx:id=\"signatureVector\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert sharedKeyImgViw != null : "fx:id=\"sharedKeyImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert commitmentImgViw != null : "fx:id=\"commitmentImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";
        assert magnifyingGlassImgViw != null : "fx:id=\"magnifyingGlassImgViw\" was not injected: check your FXML file 'simulatorKeyExchange.fxml'.";

    }

    /**
     *  Creates a VotingSimulation object to run the animations
     */
    public void run() {

        votingSimulation = new VotingSimulation(backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn, stackPane,
                snakeImgViw, dogImgViw, privateKeyImgViw, publicKeyImgViw, roundKeyImgViw, poolImgViw, messageImgViw, elephantImgViw,
                textFlow, signatureVector1, signatureVector2, signatureVector3, signatureVector4, signatureVector5, signatureVector6,
                signatureVector, sharedKeyImgViw, signatureVector7, commitmentImgViw, magnifyingGlassImgViw);
        playSimulatorBtn.setDisable(true);

    }

    /**
     *  Eventhandler for backSimulatorBtn
     */
    public void vSimBack() {
        for (int i = 0; i < votingSimulation.tranArrList.size(); i++) {

            Transition transition = votingSimulation.tranArrList.get(i);
            transition.stop();
        }
        votingSimulation.tranArrList.clear();
        screenController.setScreen(Main.mainScreenID);
    }

    /**
     *  Eventhandler for pauseSimulatorBtn
     */
    public void vSimPause() {
        for (Transition tran : votingSimulation.tranArrList) {

            if (tran.getStatus().equals(Animation.Status.RUNNING)) {
                tran.pause();
            } else {
                System.out.println(tran.toString() + "not");
            }
        }
        playSimulatorBtn.setDisable(false);
    }

    /**
     *  Eventhandler for playSimulatorBtn
     */
    public void vSimPlay() {
        for (Transition tran : votingSimulation.tranArrList) {

            if (tran.getStatus().equals(Animation.Status.PAUSED)) {
                tran.play();
            } else {
                System.out.println(tran.toString() + "not");
            }
        }
        playSimulatorBtn.setDisable(true);
    }


    /**
     * Implementation of ControlTemp interface
     *
     * @param screensController
     */
    public void setControlParent(ScreenController screensController) {
        screenController = screensController;

    }

}
