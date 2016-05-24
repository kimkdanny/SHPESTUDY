package study.shpe.com.shpestudy;
import java.util.Map;
import java.util.List;
/**
 * Created by Eduardo on 5/14/2016.
 */
public class User {
    String name;
    String email;
    List<Map<String,String>> eventAttended;
    public User(){

    }

    public String getEmail(){
        return email;
    }

    public String getName(){
        return name;
    }
}
