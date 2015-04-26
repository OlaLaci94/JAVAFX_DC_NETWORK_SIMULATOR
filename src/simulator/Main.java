package simulator;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    public static String mainScreenID = "Controller.java";
    public static String mainScreenFile = "MainLayout.fxml";
    public static String threeCrypScreenID = "ControllerThree.java";
    public static String threeCrypScreenFile = "simulatorThreeLayout.fxml";
    public static String keyExchangeScreenID = "ControllerKeyExchange.java";
    public static String keyExchangeScreenFile = "simulatorKeyExchange.fxml";
    public static String binaryScreenID = "ControllerBinary.java";
    public static String binaryScreenFile = "simulatorBinary.fxml";
    public static String manyParticipantsScreenID = "ControllerManyParticipants.java";
    public static String manyParticipantsScreenFile = "simulatorManyParticipants.fxml";
    public static String arbitraryAlphabetScreenID = "ControllerArbitraryAlphabet.java";
    public static String arbitraryAlphabetScreenFile = "simulatorArbitraryAlphabet.fxml";
     public static String discoScreenID = "ControllerDisco.java";
    public static String discoScreenFile = "simulatorDisco.fxml";
    public static String votingScreenID = "ControllerVoting.java";
    public static String votingScreenFile = "simulatorVoting.fxml";
    ScreenController screenController;
    Scene scene;
    Group root;


    /**
     *  Main entry point of the application.
     *  Loads screen to be used throughout runtime; sets the initial screen and shows the stage.
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //creates new ScreenController object- the only one used within project
        screenController = new ScreenController();
        //loads the different screens to the screenController
        screenController.loadScreen(Main.mainScreenID, Main.mainScreenFile);
        screenController.loadScreen(Main.threeCrypScreenID, Main.threeCrypScreenFile);
        screenController.loadScreen(Main.keyExchangeScreenID, Main.keyExchangeScreenFile);
        screenController.loadScreen(Main.arbitraryAlphabetScreenID, Main.arbitraryAlphabetScreenFile);
         screenController.loadScreen(Main.manyParticipantsScreenID, Main.manyParticipantsScreenFile);
        screenController.loadScreen(Main.discoScreenID, Main.discoScreenFile);
        screenController.loadScreen(Main.votingScreenID, Main.votingScreenFile);
        screenController.loadScreen(Main.binaryScreenID, binaryScreenFile);

        //sets initial screen
        screenController.setScreen(mainScreenID);

        //creates new Group and adds all of scre`enControllers components to it.
        root = new Group();
        root.getChildren().addAll(screenController);


         //creates new scene
        scene = new Scene(root,1500,800);
        //binds stage and scene height and width to ensure scene covers all avaliable space
        screenController.prefHeightProperty().bind(scene.heightProperty());
        screenController.prefWidthProperty().bind(scene.widthProperty());

        //sets the scene
        primaryStage.setScene(scene);



        //shows the stage
        primaryStage.show();

        primaryStage.setTitle("Dining Cryptographers Simulator");

        //stops program running after user has closed the window
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

    }

    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}
