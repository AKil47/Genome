package analyze;


import analyze.functions.varExtractor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

class fileExporter {
    //New varExtractor Object(Needs to be constructed)
    private varExtractor varExtractor = new varExtractor();

    //Import ArrayLists

//Constructor
    public fileExporter(analyze.functions.varExtractor varExtractor) {
        this.varExtractor = varExtractor;
    }

    public void csvExport() {
        //Set output to file
        PrintStream o = null;
        try {
            o = new PrintStream(new File("Export.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintStream console = System.out;
        System.setOut(o);


        //HEADING
        System.out.println("Key,Action,Time,,,Duration,,Seek,,Latency");
        //Initialize Latency ArrayLists and Incrementing Variable
        int x = 1;
        varExtractor.initLatency();
        try {
            for (int i = 0; i < varExtractor.getKey().size(); i++) {
                if ((i & 1) == 0) {
                    //EVEN CODE (SEEK)(DOWN)
                    if(i >= 2 && i != varExtractor.getSeek().size()) {
                        //TODO Add Latency to top line
                        if ((x & 1) == 0) {
                            //Add Latency
                            System.setOut(o);
                            System.out.println((varExtractor.getKey().get(i) + "," + varExtractor.getAction().get(i) + "," + varExtractor.getTime().get(i) + ",,,,,") + (varExtractor.getSeek(i)) + (",," + varExtractor.getLatency(i-x)));
                        }
                        else {
                            //No Latency
                            System.setOut(o);
                            System.out.println((varExtractor.getKey().get(i) + "," + varExtractor.getAction().get(i) + "," + varExtractor.getTime().get(i) + ",,,,,") + (varExtractor.getSeek(i)));
                        }
                    } else {
                        System.setOut(o);
                        System.out.println((varExtractor.getKey().get(i) + "," + varExtractor.getAction().get(i) + "," + varExtractor.getTime().get(i) + ",,,,,"));
                    }

                } else {
                    //ODD CODE (DURATION)(UP)
                    if ((x & 1) == 0) {
                        //Add Latency
                        System.setOut(o);
                        System.out.println((varExtractor.getKey().get(i) + "," + varExtractor.getAction().get(i) + "," + varExtractor.getTime().get(i) + ",,,") + (varExtractor.getDuration(i)) + (",,,," + varExtractor.getLatency(i-x)));
                    }
                    else {
                        //No Latency
                        System.setOut(o);
                        System.out.println((varExtractor.getKey().get(i) + "," + varExtractor.getAction().get(i) + "," + varExtractor.getTime().get(i) + ",,,") + (varExtractor.getDuration(i)));
                    }
                    x++;
                }

            }

        } catch (Exception e) {
            System.setOut(console);
            System.out.println(e);
        }


    }


    //Constructor


}
