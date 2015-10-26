package com.example.kieran.fall2015_recyclerviews.activities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.kieran.fall2015_recyclerviews.R;

import java.util.ArrayList;

/**
 * Created by Kieran on 9/27/2015.
 */
public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ViewHolder> {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView recycler_item_text;
        public CheckBox recycler_item_checkbox;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            recycler_item_text = (TextView) itemView.findViewById(R.id.recycler_item_text);
            recycler_item_checkbox = (CheckBox) itemView.findViewById(R.id.recycler_item_checkbox);
        }
    }

    // Variables for data
    private ArrayList<String> listData;
    private ArrayList<Boolean> checkedItems;

    public RecyclerListAdapter(ArrayList<String> data, ArrayList<Boolean> checks){
        listData = data;
        checkedItems = checks;
    }

    @Override
    public RecyclerListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View recyclerItemView = inflater.inflate(R.layout.recycler_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(recyclerItemView);
        return viewHolder;
    }

    @Override
    // Involves populating data into the item through holder
    public void onBindViewHolder(RecyclerListAdapter.ViewHolder viewHolder, int position) {
        String todoItem = listData.get(position);
        boolean isChecked = checkedItems.get(position);

        // Set item views based on the data model
        TextView textView = viewHolder.recycler_item_text;
        textView.setText(todoItem);

        // Set checkbox state
        CheckBox checkBox = viewHolder.recycler_item_checkbox;
        checkBox.setChecked(isChecked);
    }

    public int getItemCount() {
        return listData.size();
    }

}
