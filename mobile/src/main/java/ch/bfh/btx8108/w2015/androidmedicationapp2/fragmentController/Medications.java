package ch.bfh.btx8108.w2015.androidmedicationapp2.fragmentController;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import ch.bfh.btx8108.w2015.androidmedicationapp2.R;

public class Medications extends Fragment {
private ArrayList<Medications> medicationsList;
    /**
     *
     * @Created by johns2@bfh.ch on 03.12.2015.
     * This method creates a fragment for the medication list
     *
     * @param savedInstanceState Returns the saved instance state of the app
     */
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_medicaments,null);
    }

    public void onViewCreated(final View view, final Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        // We get the ListView component from the layout
        ListView listView = (ListView) view.findViewById(R.id.medicamentsListView);

        //Array adapter provides data of the ArrayList to the ListView
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.getContext(),
                android.R.layout.simple_list_item_1, medicationsList);
        listView.setAdapter(arrayAdapter);
    }

    public void initMedicationsList(ArrayList<Medications> medicationsList){
        this.medicationsList = medicationsList;
    }
}