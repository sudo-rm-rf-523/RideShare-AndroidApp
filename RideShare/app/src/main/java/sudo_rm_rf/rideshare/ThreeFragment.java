package sudo_rm_rf.rideshare;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;



public class ThreeFragment extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<Driver> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;

    public ThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_two, container, false);
        recyclerView = (RecyclerView) myView.findViewById(R.id.my_recycler_view);

        //Set the layout and animation for this activity.
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Get the data of the Drivers.
        data = Driver.getdriversFromFile("drivers.json", getActivity());
        data = new ArrayList<Driver>(data.subList(8,data.size()-1));

        //Set the adapter
        adapter = new CustomAdapter(data, true);
        recyclerView.setAdapter(adapter);
        return myView;
    }
}
