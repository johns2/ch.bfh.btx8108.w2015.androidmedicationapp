package ch.bfh.btx8108.w2015.androidmedicationapp2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MedicationNotification extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        mTextView = (TextView) findViewById(R.id.text);
    }
}
