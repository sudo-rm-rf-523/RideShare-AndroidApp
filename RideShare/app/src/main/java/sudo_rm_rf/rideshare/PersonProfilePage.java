package sudo_rm_rf.rideshare;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonProfilePage extends AppCompatActivity {

    private TextView dateView;
    private TextView timeView;
    private TextView fromPlaceView;
    private TextView toPlaceView;
    private TextView profile_name;
    private Button inviteButton;
    private CircleImageView imageView;
    private TextView distanceView;

    private boolean invitation_sent;
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
        fromPlaceView.setText(departure);
        toPlaceView.setText(arrival);
        imageView.setImageResource(b.getInt("picture"));
        profile_name.setText(name);


        System.out.println(arrival);
        System.out.println(name);
    }

    //Logic for switching the text in the Button.
    public void changeText(View view) {

        Context context = getApplicationContext();
        CharSequence text;
        int duration = Toast.LENGTH_SHORT;


        Button fb = (Button) findViewById(R.id.fb_button);
        fb.setBackgroundColor(getResources().getColor(R.color.grey));

        Button b = (Button) findViewById(R.id.invite_button);
        String button_text = b.getText().toString();

        if (!button_text.toUpperCase().contains("UNDO")) {
            invitation_sent = true;
            text = "You're invitation has been sent!";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            b.setText("Undo Invitation");
            fb.setBackgroundColor(getResources().getColor(R.color.fbcolor));
        } else {
            invitation_sent = false;
            text = "You're invitation has been recinded!";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            b.setText("Send Invitation");
            fb.setBackgroundColor(getResources().getColor(R.color.grey));
        }
    }

    public void makeToast(View view) {
        Context context = getApplicationContext();
        CharSequence text;
        int duration = Toast.LENGTH_SHORT;
           if (invitation_sent == false)
           {
               text = "You Must send an invite first ";
               Toast toast = Toast.makeText(context, text, duration);
               toast.show();
           }
        else if(invitation_sent == true)
        {
            text = "Open Facebook Messenger ";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }


    private void findViewsById() {
        dateView = (TextView) findViewById(R.id.leave_date);
        timeView = (TextView) findViewById(R.id.leave_time);
        fromPlaceView = (TextView) findViewById(R.id.from_place);
        toPlaceView = (TextView) findViewById(R.id.to_place);
        inviteButton = (Button) findViewById(R.id.invite_button);
        imageView = (CircleImageView) findViewById(R.id.user_profile_photo);
        profile_name = (TextView) findViewById(R.id.user_profile_name);
        distanceView = (TextView) findViewById(R.id.miles_away);
    }
}
