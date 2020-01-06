package com.hht.provider

import android.content.Context
import android.database.ContentObserver
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hht.provider.lib.HHTSetting
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    lateinit var observer: FreezeObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observer = FreezeObserver(this)
        observer.registerObserver()
    }


    override fun onResume() {
        super.onResume()
        HHTSetting.System.putString(this.contentResolver,"realmo","haha")
        //HHTSetting.System.getString(this.contentResolver,"realmo")
    }


    inner class FreezeObserver(val context: Context) : ContentObserver(Handler()) {

        fun registerObserver() {
            context.getContentResolver().registerContentObserver(
                HHTSetting.System.getUriFor("realmo"),
                true,
                this
            )
        }

        override fun onChange(selfChange: Boolean) {
            Log.d("realmo","had change:"+HHTSetting.System.getString(context.contentResolver,"realmo"));
        }
    }

    fun test(view: View) {

        HHTSetting.System.putString(this.contentResolver,"realmo", Random(10).nextInt().toString())
    }


}
