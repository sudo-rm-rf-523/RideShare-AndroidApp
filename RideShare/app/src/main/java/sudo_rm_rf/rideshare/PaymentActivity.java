package sudo_rm_rf.rideshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentActivity extends AppCompatActivity {

    Button venmo, paypal, cash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        cash = (Button) findViewById(R.id.paybycash);
        cash.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                startActivity(new Intent(PaymentActivity.this, FeedbackActivity.class));
            }
        });

        venmo = (Button) findViewById(R.id.paybycash);
        venmo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                startActivity(new Intent(PaymentActivity.this, FeedbackActivity.class));
            }
        });

        paypal = (Button) findViewById(R.id.paybycash);
        paypal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                startActivity(new Intent(PaymentActivity.this, FeedbackActivity.class));
            }
        });

    }


}
