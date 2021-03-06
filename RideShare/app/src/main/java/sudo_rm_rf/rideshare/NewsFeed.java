package sudo_rm_rf.rideshare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewsFeed extends AppCompatActivity {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<Driver> data;
    static View.OnClickListener myOnClickListener;
    private static List<Integer> removedItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        getSupportActionBar().setDisplayOptions(android.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.news_feed_action_bar);


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        //Set the layout and animation for this activity.
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Get the data of the Drivers.
        data = Driver.getdriversFromFile("drivers.json", this);
        data = new ArrayList<Driver>(data.subList(0,6));

        //Set the adapter
        adapter = new CustomAdapter(data, false);
        recyclerView.setAdapter(adapter);


    }



//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                // app icon in action bar clicked; go home
//                Intent intent = new Intent(this, NewsFeed.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }



}
