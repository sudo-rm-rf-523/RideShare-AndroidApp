package sudo_rm_rf.rideshare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PersonProfilePage extends AppCompatActivity {

    private TextView dateView;
    private TextView timeView;
    private TextView fromPlaceView;
    private TextView toPlaceView;
    private Button inviteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_profile_page);

        findViewsById();

        Bundle b = getIntent().getExtras();
        String arrival = b.getString("arrival");
        String departure = b.getString("departure");
        String name = b.getString("name");
        String time = b.getString("time");
        String date = b.getString("date");

        dateView.setText(date);
        timeView.setText(time);
        //fromPlaceView.setText(departure);
        //toPlaceView.setText(arrival);

        System.out.println(arrival);
        System.out.println(name);
    }

    private void findViewsById() {
        dateView = (TextView) findViewById(R.id.leave_date);
        timeView = (TextView) findViewById(R.id.leave_time);
        fromPlaceView = (TextView) findViewById(R.id.from_place);
        toPlaceView = (TextView) findViewById(R.id.to_place);
        inviteButton = (Button) findViewById(R.id.invite_button);
    }
}
