package ch.bfh.btx8108.w2015.androidmedicationapp2.fragmentController;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ch.bfh.btx8108.w2015.androidmedicationapp2.R;
import ch.bfh.btx8108.w2015.androidmedicationapp2.databaseController.MedicationCatalog;

public class AddMedication extends Fragment {
        /**
         *
         * @Created by mossd1@bfh.ch on 03.12.2015
         *
         * @param savedInstanceState Returns the saved instance state of the app
         */

        AutoCompleteTextView acTextView; //Used to put in an medicament.
        String[] medicaments = null; //Used for whole list of existing medicaments.



        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.activity_new_medicament, null);

        }

        @Override
        public void onViewCreated(final View view, final Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            //Fills the ArrayList medicaments for the auto complete
            getMedicamentCatalog();

            //Connects the autoCompleteTextView from the view with the object here
            acTextView = (AutoCompleteTextView)view.findViewById(R.id.autoCompleteTextView);
            ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.select_dialog_item, medicaments);

            //Sets the number of characters that have to be put in before auto complete turns on
            acTextView.setThreshold(3);
            acTextView.setAdapter(adapter);

        }



        //Reads a file and puts every line in the ArrayList medicaments which will be used for the autoCompleteTextView.
        public void getMedicamentCatalog(){

            MedicationCatalog catalog = new MedicationCatalog();
            medicaments = catalog.getList();

            /*BufferedReader br = null;
            try{
                br = new BufferedReader(new FileReader(new File("/data/data/ch.bfh.btx8108.w2015/katalog.txt")));

                String line = null;
                while((line = br.readLine()) != null){
                    medicaments.add(line);
                }
            }catch(FileNotFoundException e){
                System.out.println("File not found");
            } catch (IOException e) {
                e.printStackTrace();
            }*/


        }

}
