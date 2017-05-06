package com.example.even.displayaccelerometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
//import android.os.PowerManager;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
//import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mSensor;
//    private PowerManager mPowerManager;
//    private PowerManager.WakeLock mWakeLock;
//    private WindowManager mWindowManager;
//    private Window mWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
//        mPowerManager = (PowerManager) getSystemService(POWER_SERVICE);
//        mWakeLock = mPowerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,getClass().getName());

        //Window w = this.getWindow();
       // w.setFlags(WindowManager.FLAG_KEEP_SCREEN_ON,);
        //mSimulationView = new SimulationView(this);

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
//        mWakeLock.acquire();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        mSensorManager.registerListener(this,mSensor,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mSensorManager.unregisterListener(this);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //mWakeLock.release();
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy)
    {
        //Do something
    }

    @Override
    public final void onSensorChanged(SensorEvent event)
    {
        //Do something
        if(event.sensor.getType()!=Sensor.TYPE_LIGHT)
            return;
        Float xAxis = event.values[0];
//        Float yAxis = event.values[1];
//        Float zAxis = event.values[2];
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setText(xAxis.toString());
//        TextView textView2 = (TextView) findViewById(R.id.textView2);
//        textView2.setText(yAxis.toString());
//        TextView textView3 = (TextView) findViewById(R.id.textView3);
//        textView3.setText(zAxis.toString());
    }
}
