package ch.bfh.btx8108.w2015.androidmedicationapp2.fragmentController;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import ch.bfh.btx8108.w2015.androidmedicationapp2.MainView;
import ch.bfh.btx8108.w2015.androidmedicationapp2.R;
import ch.bfh.btx8108.w2015.androidmedicationapp2.models.MedicationPlan;

/**
 * @Created by johns2@bfh.ch on 03.12.2015.
 */
public class DailyList extends Fragment {
private FloatingActionButton addMedicationButton;
private ArrayList<MedicationPlan> medicationPlan;
private ArrayList<String> medicationPlanNames;

    private FragmentActivity myContext;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_daily_list, container, false);
        return v;
    }

    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        medicationPlanNames = getArguments().getStringArrayList("MEDICATIONPLAN");

        // We get the ListView component from the layout
        ListView listView = (ListView) view.findViewById(R.id.dailyListView);

        //Array adapter provides data of the ArrayList to the ListView
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.getContext(),
                android.R.layout.simple_list_item_1, medicationPlanNames);
        listView.setAdapter(arrayAdapter);

        addMedicationButton = (FloatingActionButton) view.findViewById(R.id.fab);
        addMedicationButton.setOnClickListener(addMedicationHandler);
    }

    public void initMedicationPlan(ArrayList<MedicationPlan> medicationsList){
        this.medicationPlan = medicationsList;
    }

    View.OnClickListener addMedicationHandler = new View.OnClickListener() {
        public void onClick(View v) {
            MainView activity = (MainView) getActivity();
            myContext = activity;
            FragmentManager fragmentManager = myContext.getSupportFragmentManager();
            activity.openAddMedicationsFragment(fragmentManager);
        }
    };
}
