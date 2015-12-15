package ch.bfh.btx8108.w2015.androidmedicationapp2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Medicaments extends Fragment {

    /**
     * This method creates a fragment for the medication list
     *
     * @param savedInstanceState Returns the saved instance state of the app
     */
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_medicaments,null);
    }
}