package com.hht.provider.test

import android.content.Context
import android.database.ContentObserver
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hht.provider.lib.HHTSetting

class MainActivity : AppCompatActivity() {

    lateinit var observer: SystemObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observer = SystemObserver(this)
        observer.registerObserver()
    }

    fun getProvider(view: View) {
        Log.d("realmo","freeze:"+HHTSetting.System.getString(this.contentResolver,HHTSetting.Other.FREEZE))
        Log.d("realmo","pause:"+ HHTSetting.System.getString(this.contentResolver,HHTSetting.Other.PAUSE))
        Log.d("realmo","bluelight:"+ HHTSetting.System.getString(this.contentResolver,HHTSetting.Other.BLUELIGHT_FILTER))
        Log.d("realmo","newline:"+ HHTSetting.System.getString(this.contentResolver,"newline"))
    }

    fun setProvider(view: View) {
        HHTSetting.System.putString(this.contentResolver,HHTSetting.Other.FREEZE,"1")
        HHTSetting.System.putString(this.contentResolver,HHTSetting.Other.PAUSE,"11")
        HHTSetting.System.putString(this.contentResolver,HHTSetting.Other.BLUELIGHT_FILTER,"99")

    }


    inner class SystemObserver(val context: Context) : ContentObserver(Handler()) {

        fun registerObserver() {
            context.getContentResolver().registerContentObserver(
                HHTSetting.System.getUriFor(null),
                true,
                this
            )
        }

        override fun onChange(selfChange: Boolean) {
            Log.d("realmo","had change");
        }
    }


}
