package sudo_rm_rf.rideshare;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import sudo_rm_rf.rideshare.Driver;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<Driver> dataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewDestination;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.person_name);
            this.textViewDestination = (TextView) itemView.findViewById(R.id.person_destination);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.person_photo);
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

        String text = dataset.get(listPosition).getDeparture() + " • " + dataset.get(listPosition).getArrival();
        textViewName.setText(dataset.get(listPosition).getName());
        textViewDestination.setText(text);
        imageView.setImageResource(dataset.get(listPosition).getProfilePicture());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}