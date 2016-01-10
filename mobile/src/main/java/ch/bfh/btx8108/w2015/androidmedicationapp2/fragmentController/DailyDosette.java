package ch.bfh.btx8108.w2015.androidmedicationapp2.fragmentController;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ch.bfh.btx8108.w2015.androidmedicationapp2.R;

/**
 * Created by johns2@bfh.ch on 03.12.2015.
 */
public class DailyDosette extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_daily_dosette,container,false);
        return v;
    }
}
