package simulator;

/**
 * Created by Ola Laci on 15/04/2015.
 */

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import java.io.IOException;
import java.util.HashMap;


/**
 * Created by Ola Laci on 15/04/2015.
 */
public class ScreenController extends StackPane
{
    private HashMap<String, Node> screenMap;
    ControllerThree controllerThree;
    ControllerKeyExchange controllerKeyExchange;
     ControlTemp myControllerTemp;

    /**
     *  creates ScreenController object which is of type Stackpane
     */
    protected ScreenController()
    {
        super();
        screenMap  = new HashMap<String, Node>();
    }

    /**
     *  adds screen specified to screenMap (HashMap created in this class)
     * @param name
     * @param screen
     */
    public void addScreen(String name, Node screen)
    {
        screenMap.put(name,screen);
    }


    /**
     *  loads screen onto window
     * @param name
     * @param resource
     * @return
     */
    public Boolean loadScreen(String name, String resource)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadedScreen = (Parent) fxmlLoader.load();
            myControllerTemp = ((ControlTemp) fxmlLoader.getController());
            myControllerTemp.setControlParent(this);
            addScreen(name, loadedScreen);

            if(resource.equals(Main.threeCrypScreenFile))
            {
                controllerThree = (ControllerThree) fxmlLoader.getController();

            }
            else if(resource.equals(Main.keyExchangeScreenFile))
            {
                controllerKeyExchange = (ControllerKeyExchange) fxmlLoader.getController();

            }

            return true;
        }
        catch (IOException e)
        {
            return false;
        }
    }

    /**
     *     takes in the ID of the screen as a parameter and sets it to window
     * @param name
     * @return
     */
    public boolean setScreen(final String name){

         //checks screen has been previously loaded
        if(screenMap.get(name)!= null)
        {
            final DoubleProperty opacityProperty = opacityProperty();

            //there is more than one screen-- transition between them-- common background so simple load and unload of components
            if (!getChildren().isEmpty())
            {
                //fadeout animation of setting the screen
                Timeline fadeTimeLine = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(opacityProperty, 1.0)),
                        new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event)
                            {
                                //remove previous screen
                                getChildren().remove(0);
                                // add new screen
                                getChildren().add(0, screenMap.get(name));

                                //animation fade in of new screen
                                Timeline fadeInTimeline = new Timeline(new KeyFrame((Duration.millis(1000)), new KeyValue(opacityProperty, 1.0)),
                                        new KeyFrame(new Duration(1000), new KeyValue(opacityProperty, 1.0)));
                                fadeInTimeline.play();

                            }
                        }, new KeyValue(opacityProperty, 0.0)));
                fadeTimeLine.play();
            }
            else    //first screen to be displayed
            {

                setOpacity(0.0);

                getChildren().add(screenMap.get(name));

                //animation fade in of screen
                Timeline fadeInTimeline = new Timeline(new KeyFrame((Duration.ZERO), new KeyValue(opacityProperty, 1.0)),
                        new KeyFrame(new Duration(1000), new KeyValue(opacityProperty, 1.0)));
                fadeInTimeline.play();
            }
            return true;
        }
        else
        {
            return  false;
        }

    }

    /**
     *  unloads screen from screenMap
     * @param name
     * @return
     */
    public Boolean unloadScreen(String name){

        if(screenMap.remove(name)==null){
            return  false;
        }
        else{
            return true;
        }


    }





    }








