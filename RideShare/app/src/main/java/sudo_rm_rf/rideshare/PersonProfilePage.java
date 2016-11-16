package sudo_rm_rf.rideshare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PersonProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_profile_page);

        Bundle b = getIntent().getExtras();
        String arrival = b.getString("arrival");
        String name = b.getString("name");

        System.out.println(arrival);
        System.out.println(name);
    }
}
