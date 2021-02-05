package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private TextView HelloWorld;

    private Context mContext;

    Boolean aa = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HelloWorld = findViewById(R.id.HelloWorld);
        mContext = this;

        //check if miui
//        isMiUi();

        DeviceDetailUtil b; // A reference to B

        b = new DeviceDetailUtil(); // Creating object of class B

        Boolean aa = b.isMiUi();  // Calling a method contained in class B from class A

        if(aa==true){
            System.out.println("isMiUi " + aa.toString());
        }else{
            System.out.println("isMiUi " + aa.toString());
        }


        HelloWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext() , "test", Toast.LENGTH_SHORT);
//                startActivity(new Intent(android.provider.Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS));

//                BatteryOptimization(getApplicationContext());
//                openPowerSettings(mContext);
                System.out.println("this is clicked");

                try {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsConfigActivity"));
                    intent.putExtra("package_name", getPackageName());
                    intent.putExtra("package_label", getText(R.string.app_name));
                    startActivity(intent);
                } catch (ActivityNotFoundException a) {
                    System.out.println(a.toString());
                }

            }
        });






    }

    public static void BatteryOptimization(Context context){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent intent = new Intent();
            String packageName = context.getPackageName();
            PowerManager pm = (PowerManager) context.getSystemService(POWER_SERVICE);
            if (!pm.isIgnoringBatteryOptimizations(packageName)) {
                intent.setAction(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                context.startActivity(intent);
            }
        }
    }

    private void openPowerSettings(Context context) {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
        context.startActivity(intent);
    }


}