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
    private Set<String> receivedDaysOfWeek = new HashSet<>();
    private  String horoscopeForToday;
    private String actualDate;
    private int dayOfWeek;

    //To clean up later!!!!!!!!
    public String getZodiacSingsName (String name) {
        return name;
    }

    public void createPredictionList (String fileName) {
        try {
            File file = new File(getClass().getClassLoader().getResource(fileName).getFile()
            );
            String stringOfList = FileUtils.readFileToString(file, "utf-8");
            JSONArray predictionList = new JSONArray(stringOfList);
            for (int i = 0; i < predictionList.length(); i++) {
                JSONObject predictionJSON = (JSONObject) predictionList.get(i);
                String zodiacSingName = predictionJSON.optString("name");
                String dayPrediction = predictionJSON.optString("prediction");
                if (!allZodiacSingsAndPrediction.containsKey(zodiacSingName)) {
                    allZodiacSingsAndPrediction.put(zodiacSingName, new ArrayList<>());
                    allZodiacSingsAndPrediction.get(zodiacSingName).add(dayPrediction);
                }
                else {
                    allZodiacSingsAndPrediction.get(zodiacSingName).add(dayPrediction);
                }
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

    public String addActualDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
        actualDate = dateFormat.format(new Date());
        receivedDaysOfWeek.add(actualDate);
        return actualDate;
    }

    public int getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    public String getHoroscopeForToday (String zodiacSingName) {
        //We have to write (getDayOfWeek()-1) because first day of week=1 but no 0
        horoscopeForToday = allZodiacSingsAndPrediction.get(zodiacSingName).get(getDayOfWeek()-1);
        return horoscopeForToday;
    }

   public static void main(String[] args) {
        Prediction pred = new Prediction();
        pred.createPredictionList("Prediction.json");
        String today = pred.addActualDate();
        String name = pred.getZodiacSingsName("Scorpion");
        pred.getDayOfWeek();
        System.out.println("Nietzsche`s horoscope for "  + name + " for today " +  today
                + " is " + pred.getHoroscopeForToday("Scorpion"));

    }
}
