package sudo_rm_rf.rideshare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.plus.model.people.Person;

import java.util.ArrayList;

import sudo_rm_rf.rideshare.Driver;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<Driver> dataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewDestination;
        TextView textViewArrival;
        ImageView imageViewIcon;
        Driver driver;


        public MyViewHolder(final View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.person_name);
            this.textViewDestination = (TextView) itemView.findViewById(R.id.person_departure);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.person_photo);
            this.textViewArrival = (TextView) itemView.findViewById(R.id.person_arrival);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle b = new Bundle();
                    b.putString("name", driver.getName());
                    b.putString("arrival", driver.getArrival());
                    Intent cur = new Intent(itemView.getContext(),PersonProfilePage.class);
                    cur.putExtras(b);
                    itemView.getContext().startActivity(cur);
                }
            });
        }


    }

    public CustomAdapter(ArrayList<Driver> data) {

        this.dataset = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_profile, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewDestination = holder.textViewDestination;
        ImageView imageView = holder.imageViewIcon;
        TextView textViewArrival = holder.textViewArrival;


        String depart = dataset.get(listPosition).getDeparture();
        String arrival = dataset.get(listPosition).getArrival();
        holder.driver = dataset.get(listPosition);

        textViewName.setText(dataset.get(listPosition).getName());
        textViewDestination.setText(depart);
        textViewArrival.setText(arrival);
        imageView.setImageResource(dataset.get(listPosition).getProfilePicture());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}