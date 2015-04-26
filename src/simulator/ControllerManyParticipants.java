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
 *  Controller class for simulatorManyParticipants.fxml
 */
public class ControllerManyParticipants implements ControlTemp, Initializable, Runnable {

    ScreenController screenController;
    ManyParticipantsAnimation manyParticipantsAnimation;

    @FXML
    private Button backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn;
    @FXML
    private StackPane stackPane;
    @FXML
    private ImageView roundKeyImgViw, sharedKeyImgViw, poolImgViw, dogImgViw, poolImgViw1;
    @FXML
    private TextFlow textFlow;
    @FXML
    private HBox signatureVector;
    @FXML
    private TextArea signatureVector1, signatureVector2, signatureVector3, signatureVector4, signatureVector5, signatureVector6;

    /**
     *  Method of Initializable and passes in the widgets from the fxml file while checking they are injected correctly.
     * @param fxmlFileLocation
     * @param resources
     */
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        assert backSimulatorBtn != null : "fx:id=\"backSimulatorBtn\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert pauseSimulatorBtn != null : "fx:id=\"pauseSimulatorBtn\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert playSimulatorBtn != null : "fx:id=\"playSimulatorBtn\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert stackPane != null : "fx:id=\"stackpane\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert roundKeyImgViw != null : "fx:id=\"roundKeyImgViw\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert sharedKeyImgViw != null : "fx:id=\"sharedKeyImgViw\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert poolImgViw != null : "fx:id=\"poolImgViw\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert dogImgViw != null : "fx:id=\"dogImgViw\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert textFlow != null : "fx:id=\"textFlow\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert signatureVector != null : "fx:id=\"signatureVector\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert signatureVector1 != null : "fx:id=\"signatureVector1\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert signatureVector2 != null : "fx:id=\"signatureVector2\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert signatureVector3 != null : "fx:id=\"signatureVector3\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert signatureVector4 != null : "fx:id=\"signatureVector4\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert signatureVector5 != null : "fx:id=\"signatureVector5\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert signatureVector6 != null : "fx:id=\"signatureVector6\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";


    }

    /**
     *  Created a ManyParticipantsAnimation object to run the animations
     */
    public void run() {
        manyParticipantsAnimation = new ManyParticipantsAnimation(poolImgViw1, backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn, stackPane,
                roundKeyImgViw, sharedKeyImgViw, dogImgViw,
                textFlow, signatureVector, signatureVector1, signatureVector2,
                signatureVector3, signatureVector4, signatureVector5, signatureVector6);
        playSimulatorBtn.setDisable(true);

    }

    /**
     * Eventhandler of backSimulatorBtn
     */
    public void cMPSimBack() {
        for (int i = 0; i < manyParticipantsAnimation.tranArrList.size(); i++) {

            Transition transition = manyParticipantsAnimation.tranArrList.get(i);
            transition.stop();
        }
        manyParticipantsAnimation.tranArrList.clear();
        screenController.setScreen(Main.mainScreenID);
    }

    /**
     *  Eventhandler of pauseSimulatorBtn
     */
    public void cMPSimPause() {
        for (Transition tran : manyParticipantsAnimation.tranArrList) {

            if (tran.getStatus().equals(Animation.Status.RUNNING)) {
                tran.pause();
            } else {
                System.out.println(tran.toString() + "not");
            }
        }

        //get the button
        playSimulatorBtn.setDisable(false);
    }

    /**
     *  Eventhandler of playSimulatorBtn
     */
    public void cMPSimPlay() {
        for (Transition tran : manyParticipantsAnimation.tranArrList) {

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
