package ch.bfh.btx8108.w2015.androidmedicationapp2.fragmentController;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ch.bfh.btx8108.w2015.androidmedicationapp2.R;

/**
 * Created by johns2@bfh.ch on 03.12.2015.
 */
public class DailyDosette extends Fragment {
    private double[] dailyDosetteNumbers;
    private double morningNumber;
    private TextView morningNumberField;
    private double noonNumber;
    private TextView noonNumberField;
    private double eveningNumber;
    private TextView eveningNumberField;
    private double nightNumber;
    private TextView nightNumberField;
    private String todaysDate;
    private TextView todaysDateField;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_daily_dosette,container,false);
        return v;
    }

    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dailyDosetteNumbers = getArguments().getDoubleArray("DOSETTENUMBERS");
        morningNumber = dailyDosetteNumbers[0];
        morningNumberField = (TextView)view.findViewById(R.id.dailyDosetteMorningText);
        morningNumberField.setText(String.valueOf(morningNumber));
        noonNumber = dailyDosetteNumbers[1];
        noonNumberField = (TextView)view.findViewById(R.id.dailyDosetteNoonText);
        noonNumberField.setText(String.valueOf(noonNumber));
        eveningNumber = dailyDosetteNumbers[2];
        eveningNumberField = (TextView)view.findViewById(R.id.dailyDosetteEveningText);
        eveningNumberField.setText(String.valueOf(eveningNumber));
        nightNumber = dailyDosetteNumbers[3];
        nightNumberField = (TextView)view.findViewById(R.id.dailyDosetteNightText);
        nightNumberField.setText(String.valueOf(nightNumber));
        todaysDateField = (TextView)view.findViewById(R.id.todaysDate);
        todaysDate = (String)android.text.format.DateFormat.format("dd.MM.yyyy", new java.util.Date());
        todaysDateField.setText(todaysDate);
    }
}
