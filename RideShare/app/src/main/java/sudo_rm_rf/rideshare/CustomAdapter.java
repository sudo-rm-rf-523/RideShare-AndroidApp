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
import com.google.android.gms.vision.text.Text;
import com.google.android.gms.wallet.PaymentMethodTokenizationType;

import java.util.ArrayList;

import sudo_rm_rf.rideshare.Driver;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<Driver> dataset;
    private boolean is_done;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewDestination;
        TextView textViewDistance;
        TextView textViewArrival;
        ImageView imageViewIcon;
        Driver driver;
        boolean payment;


        public MyViewHolder(final View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.person_name);
            this.textViewDestination = (TextView) itemView.findViewById(R.id.person_departure);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.person_photo);
            this.textViewArrival = (TextView) itemView.findViewById(R.id.person_arrival);
            this.textViewDistance = (TextView) itemView.findViewById(R.id.miles_away);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle b = new Bundle();
                    b.putString("name", driver.getName());
                    b.putString("departure", driver.getDeparture());
                    b.putString("arrival", driver.getArrival());
                    b.putString("time", driver.getTime());
                    b.putString("date", driver.getDate());
                    b.putInt("picture", driver.getProfilePicture());
                    b.putString("distance", driver.getDistance());
                    Intent cur;
                    if (!payment)
                        cur = new Intent(itemView.getContext(),PersonProfilePage.class);
                    else
                        cur = new Intent(itemView.getContext(), PaymentActivity.class);
                    cur.putExtras(b);
                    itemView.getContext().startActivity(cur);
                }
            });
        }


    }

    public CustomAdapter(ArrayList<Driver> data, boolean is_fin) {

        this.dataset = data;
        this.is_done = is_fin;
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
        TextView textViewDistance = holder.textViewDistance;
        ImageView imageView = holder.imageViewIcon;
        TextView textViewArrival = holder.textViewArrival;


        String depart = dataset.get(listPosition).getDeparture();
        String distance = dataset.get(listPosition).getDistance();
        String arrival = dataset.get(listPosition).getArrival();
        holder.driver = dataset.get(listPosition);
        holder.payment = is_done;

        textViewName.setText(dataset.get(listPosition).getName());
        textViewDestination.setText(depart);
        textViewArrival.setText(arrival);
        imageView.setImageResource(dataset.get(listPosition).getProfilePicture());
        textViewDistance.setText(distance);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}