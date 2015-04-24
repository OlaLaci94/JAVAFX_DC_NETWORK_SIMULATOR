package simulator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 *  Controller class for MainLayout.fxml. Handles all logic of this specific screen
 */
public class Controller implements ControlTemp, Initializable
{
    ScreenController screenController;
    int number;
    ObservableList<String> options;

    @FXML
    private Button okMainBtn;
    @FXML
    private ListView<String> listview;




    /**
     *  Implementation of ControlTemp interface
     * @param screensController
     */
    public void setControlParent(ScreenController screensController)
    {
        this.screenController = screensController;

    }

    /**
     *  Eventhandler of okMainBtn
     */
    public void HandleMainGo()
    {

        switchScenario();
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
//        assert listView != null : "fx:id=\"listView\" was not injected: check your FXML file 'MainLayout.fxml'.";

        options = FXCollections.observableArrayList(
                "Basic Protocol", " Diffie Hellman Key Exchange", "Many Participants", "Arbitrary Alphabet", "Arbitrary Message Length and Disco Problem");

        listview.setItems(options);



    }


    /**
     *  Checks the value of number -- numOfCrypSlider user input-- and sets the screen according to the input
     */
    public void switchScenario()
    {

        int number = listview.getSelectionModel().getSelectedIndex();

        switch (number)
        {
            case 0:

//                screenController.loadScreen(Main.votingScreenID, Main.votingScreenFile);
//                Thread votingThrd = new Thread(screenController.controllerVoting);
//                votingThrd.start();
//                screenController.setScreen(Main.votingScreenID);


                System.out.println("after controller.setScreen");
//                screenController.loadScreen(Main.threeCrypScreenID, Main.threeCrypScreenFile);
//                Thread controlThreeThrd = new Thread(screenController.controllerThree);
//                controlThreeThrd.start();
//                screenController.setScreen(Main.threeCrypScreenID);
//                break;

            case 1:
                screenController.loadScreen(Main.votingScreenID, Main.votingScreenFile);
                Thread votingThrd = new Thread(screenController.controllerVoting);
                votingThrd.start();
                screenController.setScreen(Main.votingScreenID);


//                System.out.println("in case 4");
//                screenController.loadScreen(Main.arbitraryAlphabetScreenID, Main.arbitraryAlphabetScreenFile);
//                Thread arbitraryAlphabetThrd = new Thread(screenController.controllerArbitraryAlphabet);
//                arbitraryAlphabetThrd.start();
//                screenController.setScreen(Main.arbitraryAlphabetScreenID);
                break;

            case 2:
                screenController.loadScreen(Main.keyExchangeScreenID, Main.keyExchangeScreenFile);
                Thread keyExchangeThrd = new Thread(screenController.controllerKeyExchange);
                keyExchangeThrd.start();
                screenController.setScreen(Main.keyExchangeScreenID);
                break;

            case 3:
                screenController.loadScreen(Main.manyParticipantsScreenID, Main.manyParticipantsScreenFile);
                Thread manyParticipantsThrd = new Thread(screenController.controllerManyParticipants);
                manyParticipantsThrd.start();
                screenController.setScreen(Main.manyParticipantsScreenID);
               break;
            case 4:
//                screenController.loadScreen(Main.votingScreenID, Main.votingScreenFile);
//                Thread votingThrd = new Thread(screenController.controllerVoting);
//                votingThrd.start();
//                screenController.setScreen(Main.votingScreenID);
                break;

            case 5:
                screenController.loadScreen(Main.discoScreenID, Main.discoScreenFile);
                Thread discoThrd = new Thread(screenController.controllerDisco);
                discoThrd.start();
                screenController.setScreen(Main.discoScreenID);

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
