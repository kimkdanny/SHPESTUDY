package study.shpe.com.shpestudy.model;

import android.support.v7.widget.RecyclerView;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import study.shpe.com.shpestudy.DerpEvent;
import study.shpe.com.shpestudy.R;
import study.shpe.com.shpestudy.adapter.DerpAdapter;

/**
 * Created by christian on 5/14/16.
 */
public class DerpData {
    private static final String[] titles = {"Nothingness cannot be defined",
            "Time is like a river made up of the events which happen, and a violent stream; " +
                    "for as soon as a thing has been seen, it is carried away, and another comes" +
                    " in its place, and this will be carried away too,",
            "But when I know that the glass is already broken, every minute with it is precious.",
            "For me, it is far better to grasp the Universe as it really is than to persist in" +
                    " delusion, however satisfying and reassuring.",
            "The seeker after the truth is not one who studies the writings of the ancients and," +
                    " following his natural disposition, puts his trust in them, but rather the" +
                    " one who suspects his faith in them and questions what he gathers from them," +
                    " the one who submits to argument and demonstration, and not to the " +
                    "sayings of a human being whose nature is fraught with all kinds " +
                    "of imperfection and deficiency.",
            "You must take personal responsibility. You cannot change the circumstances, the" +
                    " seasons, or the wind, but you can change yourself. That is something you" +
                    " have charge of."
    };
    private static final String[] subTitles = {"Bruce Lee",
            "Marcus Aurelius",
            "Meng Tzu",
            "Ajahn Chah",
            "Carl Sagan",
            "Alhazen",
            "Jim Rohn"

    };
    private static final int icon = R.drawable.ic_star_black_24dp;

    public static List<ListItem> getListData() {
        final List<ListItem> data = new ArrayList<>();
/*
        //Repeat process 4 times, so that we have enough data to demonstrate a scrollable
        //RecyclerView
        for (int x = 0; x < 4; x++) {
            //create ListItem with dummy data, then add them to our List
            for (int i = 0; i < titles.length; i++) {
                ListItem item = new ListItem();
                item.setTitle(titles[i]);
                item.setSubTitle(subTitles[i]);
                data.add(item);
            }
        }
*/
        final ArrayList<DerpEvent> al = new ArrayList<DerpEvent>();
        Firebase ref = new Firebase("https://shpestudy.firebaseio.com/").child("shpestudy");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    DerpEvent event = child.getValue(DerpEvent.class);

                    /*
                    ListItem item = new ListItem();
                     item.setTitle(titles[i]);
                     item.setSubTitle(subTitles[i]);
                     data.add(item);

                    */
                    ListItem item = new ListItem();
                    item.capacity=event.capacityText;
                    item.date=event.month + "/" + event.day;
                    item.description = event.description;
                    item.name = event.nameText;
                    item.place = event.placeText;
                    item.time = event.hour + ": " + event.minute;


                    Calendar now = Calendar.getInstance();
                    System.out.println("here");
                    if(event.month < now.get(Calendar.MONTH)){
                        child.getRef().removeValue();
                    }
                    else{
                        if(event.month == now.get(Calendar.MONTH)){
                            if(event.day < now.get(Calendar.DAY_OF_MONTH)){
                                child.getRef().removeValue();
                            }
                            else {
                                System.out.println("add");
                                data.add(item);
                            }
                        }
                        else{
                            System.out.println("add2");
                            data.add(item);
                        }
                    }
                    /*
                    al.add(event);
                    System.out.println(event.nameText);
                    */

                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        return data;
    }
}