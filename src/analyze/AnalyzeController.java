package analyze;

import analyze.functions.Sorter;
import analyze.functions.varExtractor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;



public class AnalyzeController {


    //Initialize Parsing Objects
    private final Sorter sorter = new Sorter();


    //Initialize File Import Object
    private final fileImporter fileImporter = new fileImporter();

    //Initialize varExtractor
    private final varExtractor varExtractor = new varExtractor();

    //Initialize Exporter Hi VCS
    private final Exporter exporter = new Exporter(varExtractor);


    @FXML
    private TextArea logBox;

    @FXML
    private Button buttonFilter;

    @FXML
    private Button buttonExport;

    @FXML
    private Button buttonFileSelector;

    @FXML
    void filterData(ActionEvent event) {
        System.out.println("Data Filter Triggered");
        //varExtractor.getDuration();
        //varExtractor.getSeek();;
    }

    @FXML
    void exportData(ActionEvent event) {
        //ExportData
        exporter.csvExport();
        System.out.println(varExtractor.getKey().size());

    }


    @FXML
    void showFileChooser(ActionEvent event) {
        System.out.println("File Dialog");
        //Import Data, Organize it, and transfer it into the varExtractor
        varExtractor.importArray(sorter.sort(logBox, fileImporter.importCSV(fileImporter.openFile())));
    }


}
