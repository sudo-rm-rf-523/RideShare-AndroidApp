package sudo_rm_rf.rideshare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class NewsFeed extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mListView = (ListView) findViewById(R.id.driver_list_view);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);
    }
}
