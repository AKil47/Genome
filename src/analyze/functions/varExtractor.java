package analyze.functions;

import java.util.ArrayList;


public class varExtractor {

    //Initialize and Extract ArrayList
    private ArrayList key;
    private ArrayList action;
    private ArrayList time;

    //Initialize Array For Export
    private final ArrayList seek = new ArrayList();
    private final ArrayList latency = new ArrayList();

    public void importArray (ArrayList[] columns) {
        key = columns[0];
        action = columns[1];
        time = columns[2];

        //Seek Time
        for (int x = 1; x< key.size()/2; x++) {
            //System.out.println(key.get(((2*x)-1)) + " → " + key.get((2*x)) + ": ");
            //System.out.println(Long.parseLong(time.get((2*x)).toString()) - Long.parseLong(time.get(((2*x)-1)).toString()));
            seek.add(Long.parseLong(time.get((2*x)).toString()) - Long.parseLong(time.get(((2*x)-1)).toString()));
            System.out.println(seek);
        }
        //System.out.println(seek);
    }


    //Duration
    public long getDuration(int x) {

        //for (int i = 1; i <= key.size(); i+=2) {
            //System.out.println(/*key.get(i) + ": " + */(Long.parseLong(time.get(i).toString()) - Long.parseLong(time.get(i-1).toString())));
        //}

        return Long.parseLong(time.get(x).toString()) - Long.parseLong(time.get(x-1).toString());
    }

    //Seek Time
    private int j = 1;
    public long getSeek(int i) {

        if (i != seek.size() - 1){
            j++;
            return Long.parseLong(seek.get(i-j).toString());
        }
        else {return 0;}

    }

    //TODO Latency
    public void initLatency() {
        //DOWN
        for (int x = 2; x <= key.size()/2; x+=2 ) {
            //System.out.println(key.get((2*x)-4) + " → " + key.get((2*x)-2) + ": ");
            //System.out.println(Long.parseLong(time.get((2*x)-2).toString()) - Long.parseLong(time.get((2*x)-4).toString()));
            latency.add(Long.parseLong(time.get((2*x)-2).toString()) - Long.parseLong(time.get((2*x)-4).toString())); //DOWN
            latency.add(Long.parseLong(time.get((2*x)-1).toString()) - Long.parseLong(time.get((2*x)-3).toString())); //UP

        }

    }

    public String getLatency(int r) {
        return latency.get(r).toString();
    }

    //Getters

    public ArrayList getKey() {
        return key;
    }

    public ArrayList getAction() {
        return action;
    }

    public ArrayList getTime() {
        return time;
    }

    public ArrayList getSeek() {
        return seek;
    }

    public varExtractor() {

    }
}
