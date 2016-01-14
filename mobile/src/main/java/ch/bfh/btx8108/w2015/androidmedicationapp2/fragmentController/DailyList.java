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

import ch.bfh.btx8108.w2015.androidmedicationapp2.MainView;
import ch.bfh.btx8108.w2015.androidmedicationapp2.R;

/**
 * @Created by johns2@bfh.ch on 03.12.2015.
 */
public class DailyList extends Fragment {
private FloatingActionButton addMedicationButton;
    private FragmentActivity myContext;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_daily_list, container, false);
        return v;
    }

    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addMedicationButton = (FloatingActionButton) view.findViewById(R.id.fab);
        addMedicationButton.setOnClickListener(addMedicationHandler);
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
