package sudo_rm_rf.rideshare;

/**
 * This is a helper class for the Driver Activity, it defines helper methods and other utility functions to
 * parse and decode JSON files.
 *
 * Created by Jerry J on 11/9/16.
 */

import android.content.Context;
import android.widget.ImageView;

import junit.framework.Assert;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;


public class Driver {

    final private static int[] images = {R.drawable.jerry_james, R.drawable.brian_bailey, R.drawable.man, R.drawable.man_2, R.drawable.man_3, R.drawable.the_man, R.drawable.woman, R.drawable.woman_1, R.drawable.woman_2, R.drawable.woman_3};


    //Declaring private instance variables.
    private String name;
    private String departure;
    private String distance;
    private String arrival;
    private String time;
    private String date;
    private double latDeparture;
    private double lonDeparture;
    private double latArrival;
    private double lonArrival;
    private int    numPassengers;
    private int profilePicture;


    //Declaring the relevant getters and setters.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public double getLatDeparture() {
        return latDeparture;
    }

    public void setLatDeparture(double latDeparture) {
        this.latDeparture = latDeparture;
    }

    public double getLonDeparture() {
        return lonDeparture;
    }

    public void setLonDeparture(double lonDeparture) {
        this.lonDeparture = lonDeparture;
    }

    public double getLatArrival() {
        return latArrival;
    }

    public void setLatArrival(double latArrival) {
        this.latArrival = latArrival;
    }

    public double getLonArrival() {
        return lonArrival;
    }

    public void setLonArrival(double lonArrival) {
        this.lonArrival = lonArrival;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    public String getTime() {return time;}

    public void setTime(String time) {this.time = time;}

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}


    public int getProfilePicture() {return profilePicture; }

    public String getDistance(){return distance;}



    public static ArrayList<Driver> getdriversFromFile(String filename, Context context){
        final ArrayList<Driver> driverList = new ArrayList<>();

        try {
            // Load data
            String jsonString = loadJsonFromAsset("drivers.json", context);
            JSONObject json = new JSONObject(jsonString);
            JSONArray drivers = json.getJSONArray("drivers");

            // Get Recipe objects from data
            for(int i = 0; i < drivers.length(); i++){
                //Declare a new Driver object.
                Driver driver = new Driver();

                driver.name = drivers.getJSONObject(i).getString("name");
                driver.departure = drivers.getJSONObject(i).getString("departure");
                driver.arrival = drivers.getJSONObject(i).getString("arrival");
                driver.latDeparture = drivers.getJSONObject(i).getDouble("latDepart");
                driver.lonDeparture = drivers.getJSONObject(i).getDouble("lonDepart");
                driver.latArrival = drivers.getJSONObject(i).getDouble("latDepart");
                driver.lonArrival = drivers.getJSONObject(i).getDouble("lonDepart");
                driver.numPassengers = drivers.getJSONObject(i).getInt("numPassengers");
                driver.profilePicture =  images[drivers.getJSONObject(i).getInt("image")];
                driver.time = drivers.getJSONObject(i).getString("time");
                driver.date = drivers.getJSONObject(i).getString("date");
                driver.distance = drivers.getJSONObject(i).getString("distanceAway");
                driverList.add(driver);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return driverList;
    }

    //Method that loads JSON from the specific file.
    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }



}
