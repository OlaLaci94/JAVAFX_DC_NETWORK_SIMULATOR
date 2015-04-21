package simulator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 *  Controller class for MainLayout.fxml. Handles all logic of this specific screen
 */
public class Controller implements ControlTemp, Initializable
{
    ScreenController controller;
    ArrayList cryptographerList;
    int number;

//    ControllerKeyExchange controllerKeyExchange;

    @FXML
    private Button okMainBtn;
    @FXML
    private Slider numOfCrypSlider;
    @FXML
    private RadioButton crypRadioBtn;
    @FXML
    private RadioButton nsaRadioBtn;



    /**
     *  Implementation of ControlTemp interface
     * @param screensController
     */
    public void setControlParent(ScreenController screensController)
    {
        this.controller = screensController;

    }

    /**
     *  Eventhandler of okMainBtn
     */
    public void HandleMainGo()
    {
        switchNumberOfCryp();
    }


    /**
     *  Implementation of Initializable interface-- connects widgets to their fxml file and adds some listeners for those widgets
     *
     * @param fxmlFileLocation
     * @param resources
     */
    @FXML
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        // initialize your logic here: all @FXML variables will have been injected
        assert okMainBtn != null : "fx:id=\"okMainBtn\" was not injected: check your FXML file 'MainLayout.fxml'.";
        assert numOfCrypSlider != null : "fx:id=\"numOfCrypSlider\" was not injected: check your FXML file 'MainLayout.fxml'.";
        assert crypRadioBtn != null : "fx:id=\"crypRadioBtn\" was not injected: check your FXML file 'MainLayout.fxml'.";
        assert nsaRadioBtn != null : "fx:id=\"nsaRadioBtn\" was not injected: check your FXML file 'MainLayout.fxml'.";

    }


    /**
     *  Checks the value of number -- numOfCrypSlider user input-- and sets the screen according to the input
     */
    public void switchNumberOfCryp()
    {

        //takes the numOfCrypSlider input and sets the value to number
        number = (int) numOfCrypSlider.getValue();
        numOfCrypSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                number = newValue.intValue();

            }
        });


        switch (number)
        {
            case 3:


//                controller.loadScreen(Main.keyExchangeScreenID, Main.keyExchangeScreenFile);
//                Thread keyExchangeThrd = new Thread(controller.controllerKeyExchange);
//                keyExchangeThrd.start();
//                controller.setScreen(Main.keyExchangeScreenFile);
                System.out.println("after controller.setScreen");
                controller.loadScreen(Main.threeCrypScreenID, Main.threeCrypScreenFile);
                Thread controlThreeThrd = new Thread(controller.controllerThree);
                controlThreeThrd.start();
                controller.setScreen(Main.threeCrypScreenID);



                break;
            case 4:
                controller.setScreen(Main.fourCrypScreenID);
                break;
            case 5:
                controller.loadScreen(Main.keyExchangeScreenID, Main.keyExchangeScreenFile);
                Thread keyExchangeThrd = new Thread(controller.controllerKeyExchange);
                keyExchangeThrd.start();
                controller.setScreen(Main.keyExchangeScreenID);
                break;
            case 6:
               break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            default:
                System.out.println(" switchNumberOfCryp not working; in default case");
                break;
        }

    }
}
