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
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ola Laci on 22/04/2015.
 */
public class ControllerManyParticipants implements ControlTemp, Initializable, Runnable
{

    ScreenController screenController;
    ManyParticipantsAnimation manyParticipantsAnimation;

    @FXML
    private Button backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn;
    @FXML
    private StackPane stackPane;
    @FXML
    private ImageView elephantImgViw, snakeImgViw, dogImgViw, crocodileImgViw, penguinImgViw, chickenImgViw, pandaImgViw, squirrelImgViw;
    @FXML
    private TextArea elephantVector1, elephantVector2, elephantVector3, elephantVector4, elephantVector5, elephantVector6,
            reservationVector1, reservationVector2, reservationVector3, reservationVector4, reservationVector5, reservationVector6,
            reservationVector7, cryptographerVector1, cryptographerVector2, cryptographerVector3, cryptographerVector4, cryptographerVector5,
            cryptographerVector6,  cryptographer2Vector1, cryptographer2Vector2, cryptographer2Vector3, cryptographer2Vector4,
            cryptographer2Vector5, cryptographer2Vector6,  cryptographer3Vector1, cryptographer3Vector2, cryptographer3Vector3,
            cryptographer3Vector4, cryptographer3Vector5, cryptographer3Vector6,  cryptographer4Vector1, cryptographer4Vector2,
            cryptographer4Vector3, cryptographer4Vector4, cryptographer4Vector5, cryptographer4Vector6,  cryptographer5Vector1,
            cryptographer5Vector2, cryptographer5Vector3, cryptographer5Vector4, cryptographer5Vector5, cryptographer5Vector6,
            cryptographer6Vector1, cryptographer6Vector2, cryptographer6Vector3, cryptographer6Vector4, cryptographer6Vector5, cryptographer6Vector6,
             mPTextArea;
    @FXML
    private HBox elephantVector, reservationVector, cryptographerVector, cryptographer2Vector, cryptographer3Vector;
    @FXML
    private VBox cryptographer4Vector, cryptographer5Vector, cryptographer6Vector;

    public void initialize(URL fxmlFileLocation, ResourceBundle resources){

        // initialize your logic here: all @FXML variables will have been injected
        assert backSimulatorBtn != null : "fx:id=\"backSimulatorBtn\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert pauseSimulatorBtn != null : "fx:id=\"pauseSimulatorBtn\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert playSimulatorBtn != null : "fx:id=\"playSimulatorBtn\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert stackPane != null : "fx:id=\"stackpane\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert elephantImgViw != null : "fx:id=\"elephantImgViw\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert squirrelImgViw != null : "fx:id=\"squirrelImgViw\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert snakeImgViw != null : "fx:id=\"snakeImgViw\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert dogImgViw != null : "fx:id=\"dogImgViw\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert crocodileImgViw != null : "fx:id=\"crocodileImgViw\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert penguinImgViw != null : "fx:id=\"penguinImgViw\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert chickenImgViw != null : "fx:id=\"chickenImgViw\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert pandaImgViw != null : "fx:id=\"pandaImgViw\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert elephantVector != null : "fx:id=\"elephantVector\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert reservationVector != null : "fx:id=\"reservationVector\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographerVector != null : "fx:id=\"cryptographerVector\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer2Vector != null : "fx:id=\"cryptographer2Vector\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer3Vector != null : "fx:id=\"cryptographer3Vector\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer4Vector != null : "fx:id=\"cryptographer4Vector\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer5Vector != null : "fx:id=\"cryptographer5Vector\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer6Vector != null : "fx:id=\"cryptographer6Vector\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert elephantVector1 != null : "fx:id=\"elephantVector1\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert elephantVector2 != null : "fx:id=\"elephantVector2\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert elephantVector3 != null : "fx:id=\"elephantVector3\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert elephantVector4 != null : "fx:id=\"elephantVector4\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert elephantVector5 != null : "fx:id=\"elephantVector5\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert elephantVector6 != null : "fx:id=\"elephantVector6\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert reservationVector7 != null : "fx:id=\"reservationVector7\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert reservationVector6 != null : "fx:id=\"reservationVector6\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert reservationVector5 != null : "fx:id=\"reservationVector5\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert reservationVector4 != null : "fx:id=\"reservationVector4\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert reservationVector3 != null : "fx:id=\"reservationVector3\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert reservationVector2 != null : "fx:id=\"reservationVector2\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert reservationVector1 != null : "fx:id=\"reservationVector1\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographerVector1 != null : "fx:id=\"cryptographerVector1\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographerVector2 != null : "fx:id=\"cryptographerVector2\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographerVector3 != null : "fx:id=\"cryptographerVector3\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographerVector4 != null : "fx:id=\"cryptographerVector4\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographerVector5 != null : "fx:id=\"cryptographerVector5\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographerVector6 != null : "fx:id=\"cryptographerVector6\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer2Vector1 != null : "fx:id=\"cryptographerVector1\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer2Vector2 != null : "fx:id=\"cryptographerVector2\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer2Vector3 != null : "fx:id=\"cryptographerVector3\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer2Vector4 != null : "fx:id=\"cryptographerVector4\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer2Vector5 != null : "fx:id=\"cryptographerVector5\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer2Vector6 != null : "fx:id=\"cryptographerVector6\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer3Vector1 != null : "fx:id=\"cryptographerVector1\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer3Vector2 != null : "fx:id=\"cryptographerVector2\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer3Vector3 != null : "fx:id=\"cryptographerVector3\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer3Vector4 != null : "fx:id=\"cryptographerVector4\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer3Vector5 != null : "fx:id=\"cryptographerVector5\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer3Vector6 != null : "fx:id=\"cryptographerVector6\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer4Vector1 != null : "fx:id=\"cryptographerVector1\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer4Vector2 != null : "fx:id=\"cryptographerVector2\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer4Vector3 != null : "fx:id=\"cryptographerVector3\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer4Vector4 != null : "fx:id=\"cryptographerVector4\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer4Vector5 != null : "fx:id=\"cryptographerVector5\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer4Vector6 != null : "fx:id=\"cryptographerVector6\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer5Vector1 != null : "fx:id=\"cryptographerVector1\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer5Vector2 != null : "fx:id=\"cryptographerVector2\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer5Vector3 != null : "fx:id=\"cryptographerVector3\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer5Vector4 != null : "fx:id=\"cryptographerVector4\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer5Vector5 != null : "fx:id=\"cryptographerVector5\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer5Vector6 != null : "fx:id=\"cryptographerVector6\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
         assert cryptographer6Vector1 != null : "fx:id=\"cryptographerVector1\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer6Vector2 != null : "fx:id=\"cryptographerVector2\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer6Vector3 != null : "fx:id=\"cryptographerVector3\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer6Vector4 != null : "fx:id=\"cryptographerVector4\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer6Vector5 != null : "fx:id=\"cryptographerVector5\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert cryptographer6Vector6 != null : "fx:id=\"cryptographerVector6\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";
        assert mPTextArea != null : "fx:id=\"mPTextArea\" was not injected: check your FXML file 'simulatorManyParticipants.fxml'.";







    }



    public void run(){

        manyParticipantsAnimation = new ManyParticipantsAnimation(squirrelImgViw, elephantImgViw, snakeImgViw, dogImgViw, crocodileImgViw, penguinImgViw, chickenImgViw, pandaImgViw, backSimulatorBtn, pauseSimulatorBtn, playSimulatorBtn, stackPane,
                elephantVector1, elephantVector2, elephantVector3, elephantVector4, elephantVector5, elephantVector6,
                reservationVector1, reservationVector2, reservationVector3, reservationVector4, reservationVector5, reservationVector6,
                reservationVector7, cryptographerVector1, cryptographerVector2, cryptographerVector3, cryptographerVector4, cryptographerVector5,
                cryptographerVector6,  cryptographer2Vector1, cryptographer2Vector2, cryptographer2Vector3, cryptographer2Vector4,
                cryptographer2Vector5, cryptographer2Vector6,  cryptographer3Vector1, cryptographer3Vector2, cryptographer3Vector3,
                cryptographer3Vector4, cryptographer3Vector5, cryptographer3Vector6,  cryptographer4Vector1, cryptographer4Vector2,
                cryptographer4Vector3, cryptographer4Vector4, cryptographer4Vector5, cryptographer4Vector6,  cryptographer5Vector1,
                cryptographer5Vector2, cryptographer5Vector3, cryptographer5Vector4, cryptographer5Vector5, cryptographer5Vector6,
                cryptographer6Vector1, cryptographer6Vector2, cryptographer6Vector3, cryptographer6Vector4, cryptographer6Vector5, cryptographer6Vector6,
                 mPTextArea, elephantVector, reservationVector, cryptographerVector, cryptographer2Vector, cryptographer3Vector,
                cryptographer4Vector, cryptographer5Vector, cryptographer6Vector);

        playSimulatorBtn.setDisable(true);

    }


    public void cMPSimBack()
    {
        for(int i = 0; i<manyParticipantsAnimation.tranArrList.size(); i++){

            Transition transition = manyParticipantsAnimation.tranArrList.get(i);
            transition.stop();
        }
        manyParticipantsAnimation.tranArrList.clear();
        screenController.setScreen(Main.mainScreenID);
    }

    public void cMPSimPause(){
        for(Transition tran: manyParticipantsAnimation.tranArrList){

            if( tran.getStatus().equals(Animation.Status.RUNNING)){
                tran.pause();
            }
            else{
                System.out.println(tran.toString()+ "not");
            }
        }

        //get the button
        playSimulatorBtn.setDisable(false);
    }

    public void cMPSimPlay(){
        for(Transition tran: manyParticipantsAnimation.tranArrList){

            if( tran.getStatus().equals(Animation.Status.PAUSED)){
                tran.play();
            }
            else{
                System.out.println(tran.toString()+ "not");
            }
        }

        //get the button
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
