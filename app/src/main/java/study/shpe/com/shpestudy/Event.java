package study.shpe.com.shpestudy;

/**
 * Created by nguyen on 5/7/2016.
 */
class Event {

    String nameText;
    String placeText;
    String description;
    int capacityText;
    int day, month;
    int hour, minute;


    public Event(String nameText, String placeText, int capacityText, int day, int month,
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

    public Event() {

    }
}