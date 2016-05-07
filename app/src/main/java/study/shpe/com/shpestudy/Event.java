package study.shpe.com.shpestudy;

/**
 * Created by nguyen on 5/7/2016.
 */
class Event {

    String nameText;
    String placeText;
    int capacityText;
    int day, month;
    int hour, minute;


    public Event(String nameText, String placeText, int capacityText, int day, int month,
                 int hour, int minute) {
        this.nameText = nameText;
        this.placeText = placeText;
        this.capacityText = capacityText;
        this.day = day;
        this.month = month;
        this.hour = hour;
        this.minute = minute;

    }

}