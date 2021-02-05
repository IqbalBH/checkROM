package com.example.myapplication;

import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeviceDetailUtil {

    Boolean bb = false;


    public static boolean isMiUi() {
        System.out.println("isMiUi");

//        CharSequence a = getSystemProperty("ro.miui.ui.version.name");
//        if (!TextUtils.isEmpty(a)){
//
//            return true;
//        } else{
//            return false;
//        }


        return !TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name"));

    }

    public static String getSystemProperty(String propName) {
        String line;
        BufferedReader input = null;
        try {
            java.lang.Process p = Runtime.getRuntime().exec("getprop " + propName);
            input = new BufferedReader(new InputStreamReader(p.getInputStream()), 1024);
            line = input.readLine();
            input.close();
        } catch (IOException ex) {
            return null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if(!line.isEmpty()){
            System.out.println("what is this " + line);
        }else{
            System.out.println("what is this line no value ");
        }


        System.out.println("what is this 2  " + propName);
        return line;

    }


}
