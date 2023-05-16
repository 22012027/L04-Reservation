package sg.edu.rp.c346.id22012027.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewReservation;
    EditText editTextName;
    EditText editTextMobileNumber;
    EditText editTextNoOfPeople;
    TextView textViewDate;
    DatePicker datePicker;
    TextView textViewTime;
    TimePicker timePicker;
    CheckBox checkBoxYes;
    CheckBox checkBoxNo;
    TextView textViewSmokingArea;
    Button buttonConfirm;
    Button buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewReservation=findViewById(R.id.textViewReservation);
        editTextName=findViewById(R.id.editTextName);
        editTextMobileNumber=findViewById(R.id.editTextMobileNumber);
        editTextNoOfPeople=findViewById(R.id.editTextNoOfPeople);
        textViewDate=findViewById(R.id.textViewDate);
        datePicker=findViewById(R.id.datePicker);
        textViewTime=findViewById(R.id.textViewTime);
        timePicker=findViewById(R.id.timePicker);
        checkBoxYes=findViewById(R.id.checkBoxYes);
        checkBoxNo=findViewById(R.id.checkBoxNo);
        textViewSmokingArea=findViewById(R.id.textViewSmokingArea);
        buttonConfirm=findViewById(R.id.buttonConfirm);
        buttonReset=findViewById(R.id.buttonReset);

        datePicker.updateDate(2023, 5, 1);
        timePicker.setHour(19);
        timePicker.setMinute(30);

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.updateDate(2023, 5, 1);
                timePicker.setHour(19);
                timePicker.setMinute(30);
                editTextName.setText(" ");
                editTextMobileNumber.setText(" ");
                editTextNoOfPeople.setText(" ");
                checkBoxYes.setChecked(false);
                checkBoxNo.setChecked(false);
            }
        });

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextName.getText().toString().trim().length() != 0 && editTextMobileNumber.getText().toString().trim().length() != 0 && editTextNoOfPeople.getText().toString().trim().length() != 0) {
                    if (checkBoxYes.isChecked() && checkBoxNo.isChecked() == false) {
                        String time = String.format("%02d:%02d", timePicker.getHour(), timePicker.getMinute());
                        String date = String.format("%d/%d/%d", datePicker.getDayOfMonth(), datePicker.getMonth(), datePicker.getYear());
                        String message= "Name: " + editTextName.getText().toString() + "\n" + "Mobile Number: " + editTextMobileNumber.getText().toString() + "\n" + "No Of People: " + editTextNoOfPeople.getText().toString() + "\n" + "Date: " + date + "Time: " + time + "Smoking Area: Yes" + "\n";
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                    else if (checkBoxNo.isChecked() && checkBoxYes.isChecked() == false) {
                        String time = String.format("%02d:%02d", timePicker.getHour(), timePicker.getMinute());
                        String date = String.format("%d/%d/%d", datePicker.getDayOfMonth(), datePicker.getMonth(), datePicker.getYear());
                        String message= "Name: " + editTextName.getText().toString() + "\n" + "Mobile Number: " + editTextMobileNumber.getText().toString() + "\n" + "No Of People: " + editTextNoOfPeople.getText().toString() + "\n" + "Date: " + date + "Time: " + time + "Smoking Area: No" + "\n";
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Not able to select both", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Something is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}