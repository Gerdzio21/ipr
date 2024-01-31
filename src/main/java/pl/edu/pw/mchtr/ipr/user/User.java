package pl.edu.pw.mchtr.ipr.user;

import java.io.File;
import java.util.Date;

public class User {
    private String email;
    private String name;
    private String country;
    private Date birthdate;
    private File photo;
    private String description;
    private boolean moderator;
    private boolean ban;

    public void updateDescription(String description){

    }
    public boolean updatePhoto(String photoPath){
        return false;
    }
    public void updateInfo(String a,String b, Date date){

    }
    public void grandModerator(boolean state){

    }
    public void blockUSer(boolean state){
    }


}
