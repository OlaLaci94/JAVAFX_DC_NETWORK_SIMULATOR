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
    public static String fourCrypScreenID = "ControllerFour.java";
    public static String fourCrypScreenFile = "simulatorFourLayout.fxml";
    public static String keyExchangeScreenID = "ControllerKeyExchange.java";
    public static String keyExchangeScreenFile = "simulatorKeyExchange.fxml";
    public static String manyParticipantsScreenID = "ControllerManyParticipants.java";
    public static String manyParticipantsScreenFile = "simulatorManyParticipants.fxml";

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
    public void start(final Stage primaryStage) throws Exception
    {
        //creates new ScreenController object- the only one used within project
        screenController = new ScreenController();
        //loads the different screens to the screenController
        screenController.loadScreen(Main.mainScreenID, Main.mainScreenFile);
        screenController.loadScreen(Main.threeCrypScreenID, Main.threeCrypScreenFile);
        screenController.loadScreen(Main.keyExchangeScreenID, Main.keyExchangeScreenFile);
        screenController.loadScreen(Main.fourCrypScreenID,Main.fourCrypScreenFile);
        screenController.loadScreen(Main.manyParticipantsScreenID, Main.manyParticipantsScreenFile);


        //sets initial screen
        screenController.setScreen(mainScreenID);
        //creates new Group and adds all of screenControllers components to it.
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
