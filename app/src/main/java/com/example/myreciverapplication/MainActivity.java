package com.example.myreciverapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    MyReciverBroadCast obj=new MyReciverBroadCast();

    public static class MyReciverBroadCast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            if("com.example.mysenderapplication.ACTION_SEND".equals(intent.getAction()))
            {
                String key="com.example.mysenderapplication.EXTRA";
                String value=intent.getStringExtra(key);
                Toast.makeText(context, "Reciver Application "+value, Toast.LENGTH_SHORT).show();
            }


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter = new IntentFilter("com.example.mysenderapplication.ACTION_SEND");
        registerReceiver(obj,intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        //unregisterReceiver(obj);

    }
}