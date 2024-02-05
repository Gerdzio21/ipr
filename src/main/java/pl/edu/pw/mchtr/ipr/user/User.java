package pl.edu.pw.mchtr.ipr.user;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class User {
    private String email;
    private String name;
    private String country;
    private Date birthdate;
    private File photo;
    private String description;
    private boolean moderator;
    private boolean ban;

    public User() {
        this(UUID.randomUUID().toString());
    }
    public User(String name){
        this.name = name;
        this.country = "Unknown";
        this.birthdate = new Date();
        this.photo = null;
        this.description = "";
        this.moderator = false;
        this.ban = false;

    }

    public void updateDescription(String description){

    }
    public boolean updatePhoto(String photoPath){
        return false;
    }
    public void updateInfo(String a,String b, Date date){

    }
    public void grandModerator(boolean state){

    }
    public void blockUser(boolean state){
    }
    public String getName(){
        return name;
    }


    public String getCountry() {
        return country;
    }

    public Date getBirthDate() {
        return birthdate;
    }

    public void setName(String newName){
        name= newName;
    }


    public void setCountry(String newCountry) {
        country = newCountry;
    }

    public void setBirthDate(Date newBirthDate) {
        birthdate = newBirthDate;
    }

    public Map<String, String> getUserMap() {
        Map<String, String> userMap = new HashMap<>();
        userMap.put("email", this.email);
        userMap.put("Name", this.name);
        userMap.put("Country", this.country);
        userMap.put("Birth", this.birthdate.toString());
        userMap.put("description", this.description);
        return userMap;
    }
}
