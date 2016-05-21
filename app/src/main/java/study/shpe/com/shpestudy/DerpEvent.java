package study.shpe.com.shpestudy;

/**
 * Created by nguyen on 5/7/2016.
 */
public class DerpEvent {

    public String nameText;
    public String placeText;
    public String description;
    public int capacityText;
    public int day, month;
    public int hour, minute;


    public DerpEvent(String nameText, String placeText, int capacityText, int day, int month,
                     int hour, int minute, String description) {
        this.nameText = nameText;
        this.placeText = placeText;
        this.capacityText = capacityText;
        this.day = day;
        this.month = month;
        this.hour = hour;
        this.minute = minute;
        this.description = description;

    }

    public DerpEvent() {

    }

}