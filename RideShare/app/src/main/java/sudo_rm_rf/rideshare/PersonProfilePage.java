package sudo_rm_rf.rideshare;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by Jon on 11/14/2016.
 */

public class PersonProfilePage extends AppCompatActivity {

    private TextView date;
    private TextView time;
    private TextView fromPlace;
    private TextView toPlace;
    private Button inviteButton;

    private boolean isClicked = true;
    private LinearLayout linearLayout;
    private PopupWindow popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_profile_page);

        findViewsById();

        linearLayout = new LinearLayout(this);
        popup = new PopupWindow(this);

        inviteButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(isClicked) {
                    isClicked = false;
                    popup.showAtLocation(linearLayout, Gravity.CENTER, 10, 10);
                    popup.update(50, 50, 320, 90);
                }
                else {
                    isClicked = true;
                    popup.dismiss();
                }
            }

        });

    }

    private void findViewsById() {
        date = (TextView) findViewById(R.id.leave_date);
        time = (TextView) findViewById(R.id.leave_time);
        fromPlace = (TextView) findViewById(R.id.from_place);
        toPlace = (TextView) findViewById(R.id.to_place);
        inviteButton = (Button) findViewById(R.id.invite_button);
    }
}
