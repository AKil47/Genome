package analyze.functions;

import java.util.ArrayList;


public class varExtractor {

    //Initialize and Extract ArrayList
    private ArrayList key;
    //private ArrayList action;
    private ArrayList time;

    public void importArray (ArrayList[] columns) {
        key = columns[0];
        //action = collumns[1];
        time = columns[2];
    }


    //Duration
    public void getDuration() {
        for (int i = 1; i <= key.size(); i+=2) {
            System.out.println(key.get(i) + ": " + (Long.parseLong(time.get(i).toString()) - Long.parseLong(time.get(i-1).toString())));
        }
    }

    //Seek Time
    public void getSeek() {
        for (int x = 1; x< key.size()/2; x++) {
            System.out.println(key.get(((2*x)-1)) + " → " + key.get((2*x)) + ": ");
            System.out.println(Long.parseLong(time.get((2*x)).toString()) - Long.parseLong(time.get(((2*x)-1)).toString()));

        }
    }

    //TODO Latency
    public void getLatency(boolean isDown) {
        if (isDown) {
            //Down
            for (int x = 2; x <= key.size()/2; x+=2 ) {
                System.out.println(key.get((2*x)-4) + " → " + key.get((2*x)-2) + ": ");
                System.out.println(Long.parseLong(time.get((2*x)-2).toString()) - Long.parseLong(time.get((2*x)-4).toString()));
            }
        } else {
            //TODO Up
            for (int x = 2; x <= key.size()/2; x+=2 ) {
                System.out.println(key.get((2*x)-3) + " → " + key.get((2*x)-1) + ": ");
                System.out.println(Long.parseLong(time.get((2*x)-1).toString()) - Long.parseLong(time.get((2*x)-3).toString()));
            }

        }




    }



    //Constructor
    public varExtractor() {

    }
}
