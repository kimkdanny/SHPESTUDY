package study.shpe.com.shpestudy.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.List;

import study.shpe.com.shpestudy.CreateFormActivity;
import study.shpe.com.shpestudy.R;
import study.shpe.com.shpestudy.WriteOnScreenActivity;
import study.shpe.com.shpestudy.adapter.DerpAdapter;
import study.shpe.com.shpestudy.model.DerpData;
import study.shpe.com.shpestudy.model.ListItem;

public class ListActivity extends AppCompatActivity implements DerpAdapter.ItemClickCallback {
    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";

    private RecyclerView recyclerView;
    private DerpAdapter adapter;
    private ArrayList<ListItem> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_list);


        System.out.println("REached this");

        recyclerView = (RecyclerView) findViewById(R.id.rec_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listData = (ArrayList) DerpData.getListData();
        adapter = new DerpAdapter(listData,this);

        System.out.println("HERE LIST " + listData.size());
        recyclerView.setAdapter(adapter);
        adapter.setItemClickCallback(this);
        customActionBar();
    }

    public void shpepoint(View v){
        Intent i = new Intent(this,WriteOnScreenActivity.class);
        startActivity(i);
        finish();
    }
    public void newevent(View v){
        Intent i = new Intent(this,CreateFormActivity.class);
        startActivity(i);
        finish();
    }

    public void feed(View v){
        Intent i = new Intent(this,ListActivity.class);
        startActivity(i);
        finish();
    }



    public void customActionBar(){
        final LayoutInflater inflater = (LayoutInflater) this
                .getSupportActionBar().getThemedContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View customActionBarView = inflater.inflate(
                R.layout.navigation, null);
        customActionBarView.findViewById(R.id.title);



        final android.support.v7.app.ActionBar actionBar = this.getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM, ActionBar.DISPLAY_SHOW_CUSTOM |
                ActionBar.DISPLAY_SHOW_HOME |
                ActionBar.DISPLAY_SHOW_TITLE);

        actionBar.setCustomView(customActionBarView,
                new ActionBar.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                )
        );
    }
    @Override
    public void onItemClick(int p) {
        ListItem item = (ListItem) listData.get(p);

        Intent i = new Intent(this, DetailActivity.class);

        Bundle extras = new Bundle();
        extras.putString("NAME", item.name);
        extras.putString("PLACE", item.place);
        extras.putString("TIME", item.time);
        extras.putString("DATE", item.date);
        extras.putString("DESCRIPTION", item.description);

        i.putExtra(BUNDLE_EXTRAS, extras);

        startActivity(i);
    }

}