package capture;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class CaptureController {

    //Define Output as TextFile
    private final PrintStream o = new PrintStream(new File("AAT7.csv"));
    private final PrintStream console = System.out;


    //Define FXML Elements
    @FXML
    private TextField captureTextbox;

    @FXML
    private Label captureText;


    @FXML
    private Button buttonRestart;

    public CaptureController() throws FileNotFoundException {
    }

    @FXML
    void onKeyPressed(KeyEvent event) {
        //Difference Code
        System.setOut(o);

        System.out.println(event.getText() + "," + "DOWN ," + System.currentTimeMillis());
    }

    @FXML
    void onKeyReleased(KeyEvent event) {
        //Difference Code
        System.setOut(o);
        System.out.println(event.getText() + "," + "UP ," + System.currentTimeMillis());
    }

    @FXML
    void restart(ActionEvent event) {
        System.setOut(console);
        System.out.println("Restart Button Hit");
        captureTextbox.clear();
    }


}
