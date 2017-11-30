package analyze;

import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


class fileImporter {
    //Init File Browser JFX Objects
    private final FileChooser fileChooser = new FileChooser();    //TODO Add FXML elements to constructor
    private final ArrayList key = new ArrayList(); private final ArrayList time = new ArrayList(); private final ArrayList action = new ArrayList();


    //CSV Import to Array
    public ArrayList[] importCSV (File selectedFile) {
        //CSV Import Code Goes Here
        try {
            Scanner file = new Scanner(selectedFile);
            //file.useDelimiter(",");
            file.useDelimiter(",|\r\n");

            while(file.hasNext()) {
                //Populate Variables
                key.add(file.next());
                action.add(file.next());
                time.add(file.next());

            }




        }
        catch (Exception e) {
            //Initialize Alert Box Window
            Alert errorAlertBox = new Alert(Alert.AlertType.ERROR);
            errorAlertBox.setTitle("Error");
            switch(e.toString()) {
                case "java.lang.NullPointerException":
                    errorAlertBox.setContentText("Please Select a File");
                    errorAlertBox.showAndWait();
                    break;
                case "java.util.NoSuchElementException":
                    errorAlertBox.setContentText("NoSuchElementException");
                    errorAlertBox.showAndWait();
                    break;
                default:
                    e.printStackTrace();
            }
        }
        //Consolidate ArrayLists into Single ArrayList
        ArrayList[] columns = new ArrayList[3];
        columns[0] = key;
        columns[1] = action;
        columns[2] = time;
        return columns;


    }

    //File Manager Import
    public File openFile () {
        //File Manager Code Goes Here
        System.out.println("File Manager Opened");
        return fileChooser.showOpenDialog(null);
    }

    //Constructor
    public fileImporter() {
    }
}
