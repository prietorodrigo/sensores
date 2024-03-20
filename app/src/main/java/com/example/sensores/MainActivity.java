package com.example.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    Sensor accelerometer;
    SensorManager sensorManager;
    float sensorX;

    private float textSize = 18.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener((SensorEventListener) this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        TextView tFrase = findViewById(R.id.tFrase);
        tFrase.setTextSize(textSize);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        sensorX = sensorEvent.values[0];

        TextView tFrase = (TextView) findViewById(R.id.tFrase);

        tFrase.setTextSize((sensorX + 10)*7);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}