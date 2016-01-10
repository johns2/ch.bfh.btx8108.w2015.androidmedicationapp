package ch.bfh.btx8108.w2015.androidmedicationapp2.fragmentController;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ch.bfh.btx8108.w2015.androidmedicationapp2.R;

public class Export extends Fragment {
        /**
         *
         * @Created by johns2@bfh.ch at 03.12.2015
         * This method creates a fragment for the export feature
         *
         * @param savedInstanceState Returns the saved instance state of the app
         */
        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.activity_export, null);
        }
}
