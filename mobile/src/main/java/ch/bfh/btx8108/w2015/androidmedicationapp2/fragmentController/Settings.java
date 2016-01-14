package ch.bfh.btx8108.w2015.androidmedicationapp2.fragmentController;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import ch.bfh.btx8108.w2015.androidmedicationapp2.MainView;
import ch.bfh.btx8108.w2015.androidmedicationapp2.R;
import ch.bfh.btx8108.w2015.androidmedicationapp2.models.User;

public class Settings extends Fragment {
        /**
         *
         * @Created by johns2@bfh.ch on 03.12.2015.
         * This method creates a fragment for the settings
         *
         * @param savedInstanceState Returns the saved instance state of the app
         */
        private User currentUser;
        private TextView currentUserNameField;
        private String currentUsername;
        private Switch muteSwitch;
        private Switch notificationsSwitch;
        private Switch vibrationSwitch;
        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                return inflater.inflate(R.layout.activity_settings, null);
        }

        @Override
        public void onViewCreated(final View view, final Bundle savedInstanceState) {
                super.onViewCreated(view, savedInstanceState);
                currentUser = (User)getArguments().getParcelable("USERDATA");
                currentUsername = currentUser.getUsername();
                currentUserNameField = (TextView)view.findViewById(R.id.settings_UserName);
                currentUserNameField.setText(currentUsername);

                muteSwitch = (Switch)view.findViewById(R.id.settings_switchMute);
                muteSwitch.setChecked(currentUser.getMute());
                muteSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                currentUser.setMute(isChecked);
                                MainView activity = (MainView) getActivity();
                                activity.updateCurrentUserObject(view.getContext(), currentUser);
                        }
                });

                notificationsSwitch = (Switch)view.findViewById(R.id.settings_switchNotifications);
                notificationsSwitch.setChecked(currentUser.getNotificationSound());
                notificationsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                currentUser.setNotificationSound(isChecked);
                                MainView activity = (MainView) getActivity();
                                activity.updateCurrentUserObject(view.getContext(), currentUser);
                        }
                });

                vibrationSwitch = (Switch)view.findViewById(R.id.settings_switchVibration);
                vibrationSwitch.setChecked(currentUser.getNotificationVibration());
                vibrationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                currentUser.setNotificationVibration(isChecked);
                                MainView activity = (MainView) getActivity();
                                activity.updateCurrentUserObject(view.getContext(), currentUser);
                        }
                });
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
                outState.putParcelable("USERDATA", currentUser);
                super.onSaveInstanceState(outState);
        }



}
