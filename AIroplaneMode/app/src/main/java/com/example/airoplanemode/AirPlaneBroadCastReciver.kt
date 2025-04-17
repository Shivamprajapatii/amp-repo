package com.example.airoplanemode

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirPlaneBroadCast :BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val isAirPlaneModeEnable = intent?.getBooleanExtra("state",false)

        if(isAirPlaneModeEnable == true){
                Toast.makeText(context,"AirplaneMode Enable",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context,"AirplaneMode Disable",Toast.LENGTH_LONG).show();

        }
    }


}