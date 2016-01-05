package ch.bfh.btx8108.w2015.androidmedicationapp2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Settings extends Fragment {
        /**
         *
         * @Created by johns2@bfh.ch at 03.12.2015.
         * This method creates a fragment for the settings
         *
         * @param savedInstanceState Returns the saved instance state of the app
         */
        private TextView mTextView;
        private String mString;
        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                  return inflater.inflate(R.layout.activity_settings, null);
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
                super.onViewCreated(view, savedInstanceState);

                UserData UserList = new UserData(this.getContext());

                mString = UserList.getAllUsers().get(0);
                mTextView = (TextView)view.findViewById(R.id.settings_UserName);

                mTextView.setText(mString);
        }
}
