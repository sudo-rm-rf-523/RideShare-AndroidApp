package sudo_rm_rf.rideshare;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
//import android.icu.text.SimpleDateFormat;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import android.content.Intent;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import android.view.View.OnClickListener;
import java.util.Calendar;
import java.util.Locale;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class OneFragment extends Fragment implements View.OnClickListener {

    //UI References
    private EditText fromDateEtxt;
    private EditText toDateEtxt;
    private EditText timeEtxt;
    private  EditText fromPlace;
    private EditText toPlace;
    private Spinner mspin;
    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;
    private TimePickerDialog timePickerDialog;
    private boolean fromPlaceclicked = false;
    private boolean toPlaceclicked = false;
    private SimpleDateFormat dateFormatter;

    private int mYear, mMonth, mDay, mHour, mMinute;

    private static final int PLACE_PICKER_REQUEST = 1;
    private static final LatLngBounds BOUNDS_MOUNTAIN_VIEW = new LatLngBounds(
            new LatLng(37.398160, -122.180831), new LatLng(37.430610, -121.972090));

    RadioGroup radio_group;


    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);



    }

    private void findViewsById(View myView) {
        fromDateEtxt = (EditText) myView.findViewById(R.id.etxt_fromdate);
        fromDateEtxt.setInputType(InputType.TYPE_NULL);
        fromDateEtxt.requestFocus();
        //toDateEtxt = (EditText) myView.findViewById(R.id.etxt_todate);
        //toDateEtxt.setInputType(InputType.TYPE_NULL);
        timeEtxt = (EditText) myView.findViewById(R.id.etxt_time);
        timeEtxt.setInputType(InputType.TYPE_NULL);

        fromPlace = (EditText) myView.findViewById(R.id.from_place);
        fromPlace.setInputType(InputType.TYPE_NULL);
        toPlace = (EditText) myView.findViewById(R.id.to_place);
        toPlace.setInputType(InputType.TYPE_NULL);

        mspin=(Spinner) myView.findViewById(R.id.spinner1);
        Integer[] items = new Integer[]{1,2,3,4};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getActivity(),android.R.layout.simple_spinner_item, items);
        mspin.setAdapter(adapter);

    }


    @Override
    public void onClick(View view) {
        if(view == fromDateEtxt) {
            fromDatePickerDialog.show();
        } else if(view == timeEtxt) {
            timePickerDialog.show();
        }
//        else if (view == toDateEtxt)
//        {
//            //toDatePickerDialog.show();
//        }
    }

    private void setDateTimeField() {

        fromPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    fromPlaceclicked = true;
                    PlacePicker.IntentBuilder intentBuilder =
                            new PlacePicker.IntentBuilder();
                    intentBuilder.setLatLngBounds(BOUNDS_MOUNTAIN_VIEW);
                    Intent intent = intentBuilder.build(getActivity());
                    startActivityForResult(intent, PLACE_PICKER_REQUEST);

                } catch (GooglePlayServicesRepairableException
                        | GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

        toPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    toPlaceclicked = true;
                    PlacePicker.IntentBuilder intentBuilder =
                            new PlacePicker.IntentBuilder();
                    intentBuilder.setLatLngBounds(BOUNDS_MOUNTAIN_VIEW);
                    Intent intent = intentBuilder.build(getActivity());
                    startActivityForResult(intent, PLACE_PICKER_REQUEST);

                } catch (GooglePlayServicesRepairableException
                        | GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fromDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        Calendar toCalendar = Calendar.getInstance();
//        toDatePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
//
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                Calendar newDate = Calendar.getInstance();
//                newDate.set(year, monthOfYear, dayOfMonth);
//                toDateEtxt.setText(dateFormatter.format(newDate.getTime()));
//            }
//
//        }, toCalendar.get(Calendar.YEAR), toCalendar.get(Calendar.MONTH), toCalendar.get(Calendar.DAY_OF_MONTH));

        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        timePickerDialog = new TimePickerDialog(getActivity(),
                new TimePickerDialog.OnTimeSetListener() {

                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        timeEtxt.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);



    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View myView = inflater.inflate(R.layout.fragment_one, container, false);
        final Button v = (Button) myView.findViewById(R.id.button);
        final Button last = (Button) myView.findViewById(R.id.button2);
        dateFormatter = new java.text.SimpleDateFormat("dd-MM-yyyy", Locale.US);
        findViewsById(myView);
        setDateTimeField();
        fromDateEtxt.setOnClickListener(this);
        //toDateEtxt.setOnClickListener(this);
        timeEtxt.setOnClickListener(this);
        v.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (fromDateEtxt.getText().length() == 0)
                {
                    fromDateEtxt.setError("Please enter a starting date");
                }
                if (fromPlace.getText().length() == 0)
                {
                    fromPlace.setError("Please enter a starting place");
                }
                if (toPlace.getText().length() == 0)
                {
                    toPlace.setError("Please enter a destination");
                }
                if (timeEtxt.getText().length() == 0) {

                    timeEtxt.setError("Please enter a convenient time");
                }
                 else {
                    Intent intent = new Intent(getActivity(), NewsFeed.class);
                    startActivity(intent);
                }
            }

        });

        last.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                fromPlace.setText("Champaign");
                toPlace.setText("Chicago");
            }
        });
        //radio_group = (RadioGroup) myView.findViewById(R.id.trip_type);
        //radio_group.check(0);

        return myView;
    }

//    public void onRadioButtonClicked(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.one_way:
//                if (checked)
//                    toDateEtxt.setEnabled(false);
//                    toDateEtxt.setVisibility(View.GONE);
//                    // Pirates are the best
//                    break;
//            case R.id.round_trip:
//                if (checked)
//                    // Ninjas rule
//                    toDateEtxt.setEnabled(true);
//                    toDateEtxt.setVisibility(View.VISIBLE);
//                    break;
//        }
//    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {

        if (requestCode == PLACE_PICKER_REQUEST
                && resultCode == Activity.RESULT_OK) {

            final Place place = PlacePicker.getPlace(getActivity(), data);
            final CharSequence name = place.getName();
            final CharSequence address = place.getAddress();
            String attributions = (String) place.getAttributions();
            if (attributions == null) {
                attributions = "";
            }

            String temp = name.toString() + address.toString().replaceAll("\\)", "");
            if (fromPlaceclicked == true) {
                fromPlace.setText(name.toString());
                fromPlaceclicked = false;
            }
            else
            {
                toPlace.setText(name.toString());
                toPlaceclicked = false;
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}
