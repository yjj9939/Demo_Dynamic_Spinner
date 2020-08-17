package sg.edu.rp.c346.id18054367.demodynamicspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    Spinner spn1;
    Spinner spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);


        // Initialise the Arraylist
        alNumbers = new ArrayList<>();
        /*
        alNumbers.add("2");
        alNumbers.add("4");
        alNumbers.add("6");

         */
        //Get the string-array and store as an Array
        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);

        //Convert Array to List and add to the ArrayList
        alNumbers.addAll(Arrays.asList(strNumbers));

        // Create an ArrayAdapter using default Spinner layout and the ArrayList
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        // Bind the ArrayAdapter to the Spinner
        spn2.setAdapter(aaNumbers);



        btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = spn1.getSelectedItemPosition();
                        alNumbers.clear();

                /*//Approach 1
                if (pos == 0){
                    alNumbers.add("2");
                    alNumbers.add("4");
                    alNumbers.add("6");
                } else {
                    alNumbers.add("1");
                    alNumbers.add("3");
                    alNumbers.add("5");
                }

                 */


                //Approach 2
                if (pos == 0){
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);

                    //Convert Array to List and add to the ArrayList
                    alNumbers.addAll(Arrays.asList(strNumbers));
                } else {
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);

                    //Convert Array to List and add to the ArrayList
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }

                aaNumbers.notifyDataSetChanged();
            }
        });

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String[] strNumbers = new String[2];
                alNumbers.clear();
                switch (position){
                    case 0:
                        strNumbers = getResources().getStringArray(R.array.even_numbers);
                        spn2.setSelection(2);
                        break;
                    case 1:
                        strNumbers = getResources().getStringArray(R.array.odd_numbers);
                        spn2.setSelection(1);
                        break;
                }
                alNumbers.addAll(Arrays.asList(strNumbers));
                aaNumbers.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
