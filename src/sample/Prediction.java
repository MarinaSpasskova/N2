package sample;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Prediction {
    private HashMap<String, ArrayList<String>> allZodiacSingsAndPrediction = new HashMap<>();
    private Set<String> receivedDates = new HashSet<>();

    public void createPredictionList (String fileName) {
        try {
            File file = new File(getClass().getClassLoader().getResource(fileName).getFile()
            );
            String stringOfList = FileUtils.readFileToString(file, "utf-8");
            JSONArray predictionList = new JSONArray(stringOfList);
            for (int i = 0; i < predictionList.length(); i++) {
                JSONObject predictionJSON = (JSONObject) predictionList.get(i);
                String zodiacSingName = (String) predictionJSON.get("name");
                String dayPrediction = (String) predictionJSON.get("prediction");
                ArrayList allPrediction = new ArrayList();
                allPrediction.add(dayPrediction);
                allZodiacSingsAndPrediction.put(zodiacSingName, allPrediction);
            }
        } catch (IOException ex) {
            System.out.println("Error during reading " + fileName + ex.getMessage());
        }
    }

    public HashMap getAllZodiacSingAndPrediction () {
        return allZodiacSingsAndPrediction;
    }

    public ArrayList getallPredictiont(String zodiacSingName) {
        return allZodiacSingsAndPrediction.get(zodiacSingName);
    }

    public HashSet getActualDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        String actualTime = dateFormat.format(new Date());
        receivedDates.add(actualTime);
        return (HashSet) receivedDates;
    }

}
