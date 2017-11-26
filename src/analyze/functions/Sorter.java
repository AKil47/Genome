package analyze.functions;

import javafx.scene.control.TextArea;

import java.util.ArrayList;


public class Sorter {

    //Sort Function
    public ArrayList[] sort(TextArea logBox, ArrayList columns[]) {

        //Extract ArrayLists from Columns Array
        ArrayList key = columns[0];
        ArrayList action = columns[1];
        ArrayList time = columns[2];

        //Create "Good" ArrayLists for Clean Data
        ArrayList goodKey = new ArrayList(); ArrayList goodAction = new ArrayList(); ArrayList goodTime = new ArrayList();

        for (int i = 0; i < key.size(); i++) {  //Advance array location
            boolean isMatched = false;
            int j = 1;
            if (action.get(i).toString().equals("DOWN")) {   //if the next value is down
                String currentKey = key.get(i).toString();
                String currentAction = action.get(i).toString();
                String currentTime = time.get(i).toString();
                while (!isMatched && i + j <= key.size()) {  //Search Array for value
                    //Traverse for match
                    if (currentKey.equals(key.get(i + j).toString()) && action.get(i + j).toString().equals("UP")) {   //If a match is found
                        isMatched = true;
                        //System.out.println(currentKey + ", " + currentAction + ", " + currentTime);
                        logBox.appendText(currentKey + ", " + currentAction + ", " + currentTime + "\r\n");
                        goodKey.add(currentKey);goodAction.add(currentAction);goodTime.add(currentTime);
                        //System.out.println(key.get(i + j).toString() + ", " + action.get(i + j).toString() + ", " + time.get(i + j).toString());
                        logBox.appendText(key.get(i+ j).toString() + ", " + action.get(i+ j).toString() + ", " + time.get(i+ j).toString() + "\r\n");
                        goodKey.add(key.get(i+ j).toString());goodAction.add(action.get(i+ j).toString());goodTime.add(time.get(i+ j).toString());
                    } else {
                        j++;
                    }
                }
            }
        }
        //Consolidate ArrayLists into ArrayList[]
        ArrayList[] goodColumns = new ArrayList[3];
        goodColumns[0] = goodKey;
        goodColumns[1] = goodAction;
        goodColumns[2] = goodTime;
        return goodColumns;
    }

    //Constructor
    public Sorter() {
        //Constructor Stuff goes here
    }

}
