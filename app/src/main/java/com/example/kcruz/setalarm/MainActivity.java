package com.example.kcruz.setalarm;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TimePicker time = findViewById(R.id.tp_time);
        final EditText alarmName= findViewById((R.id.etxt_alarm_name);
        Button btnSet = findViewById(R.id.btn_set);

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Aqui esta el intent
                Intent intentAlarm = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, alarmName.getText().toString())
                        .putExtra(AlarmClock.EXTRA_HOUR, time.getCurrentHour())
                        .putExtra(AlarmClock.EXTRA_MINUTES, time.getCurrentMinute());

                if(intentAlarm.resolveActivity(getPackageManager()) != null)
                    startActivity(intentAlarm);

            }
        });
    }

}
