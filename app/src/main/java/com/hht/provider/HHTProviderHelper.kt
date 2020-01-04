package com.hht.provider

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.logging.Level.CONFIG

/**
 * @name HHTProviderHelper
 * @author Realmo
 * @email   momo.weiye@gmail.com
 * @version 1.0.0
 * @time 2020/1/2 19:28
 * @describe
 */
class HHTProviderHelper : SQLiteOpenHelper{


    companion object {
        const val DBNAME = "hht_function.db"
        /**
         * system function 数据表
         */
        const val SYSTEM_TABLE = "system"

        /**
         * secure function 数据表
         */
        const val SECURE_TABLE = "secure"

        /**
         *  source function 数据表
         */
        const val SOURCE_TABLE = "source"

        /**
         * whiteboard function 数据表
         */
        const val WHITEBOARD_TABLE = "whiteboard"

        /**
         * toolbar function 数据表
         */
        const val TOOLBAR_TABLE = "toolbar"

        /**
         * time function 数据表
         */
        const val TIME_TABLE = "time"

        /**
         * other function 数据表
         */
        const val OTHER_TABLE = "other"


        val STARTVERSION = 1
        val CURRENTVERSION = 1
    }


    constructor(context: Context) : super(context, DBNAME,null, CURRENTVERSION)


    override fun onCreate(db: SQLiteDatabase?) {
        //TODO using stringbuilder

        //system table
        db?.execSQL("CREATE TABLE IF NOT EXISTS " + SYSTEM_TABLE + "(" + //
                "_id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "theme_type INTEGER NOT NULL ," +
                "theme_res_path INTEGER NOT NULL ," +
                "date_format TEXT NOT NULL )");

        //secure table
        db?.execSQL("CREATE TABLE IF NOT EXISTS " + SECURE_TABLE + "(" + //
                "_id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "lock_screen_master_passkey TEXT NOT NULL ," +
                "lock_screen_passkey TEXT NOT NULL ," +
                "quicksetting_enable INTEGER NOT NULL ," +
                "clear_file_time INTEGER NOT NULL ," +
                "ota_servce_enviroment INTEGER NOT NULL )")


        //source table
        db?.execSQL("CREATE TABLE IF NOT EXISTS " + SOURCE_TABLE + "(" + //
                "_id INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "current_source_ordinal INTEGER NOT NULL ," +
                "current_source_type TEXT NOT NULL ," +
                "favorite_source_ordinal INTEGER NOT NULL ," +
                "favorite_source_type TEXT NOT NULL ," +
                "last_source_ordinal INTEGER NOT NULL ," +
                "last_source_type TEXT NOT NULL ," +
                "home_source_type INTEGER NOT NULL ," +
                "pc_rename TEXT NOT NULL ," +
                "hdmi_front_rename TEXT NOT NULL ," +
                "hdmi1_rename TEXT NOT NULL ," +
                "hdmi2_rename TEXT NOT NULL ," +
                "hdmi3_rename TEXT NOT NULL ," +
                "type_c_rename TEXT NOT NULL ," +
                "vga_rename TEXT NOT NULL ," +
                "dp_rename TEXT NOT NULL )")


        //whiteboard table
        db?.execSQL("CREATE TABLE IF NOT EXISTS " + WHITEBOARD_TABLE + "(" + //
                "_id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "is_annotationing INTEGER NOT NULL ," +
                "writing_protection INTEGER NOT NULL )")


        //toolbar table
        db?.execSQL("CREATE TABLE IF NOT EXISTS " + TOOLBAR_TABLE + "(" + //
                "_id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "left_bar_open INTEGER NOT NULL ," +
                "right_bar_open INTEGER NOT NULL ," +
                "bar_open INTEGER NOT NULL ," +
                "bar_size INTEGER NOT NULL )")


        //time table
//        db?.execSQL("CREATE TABLE IF NOT EXISTS " + TIME_TABLE + "(" + //
//                "_id INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
//                "BAR_HIDEN INTEGER NOT NULL ," + // 1: bar hiden
//                "BAR_SIZE INTEGER NOT NULL ," + // 2: bar size
//                "SOURCE_MENU_KEY INTEGER NOT NULL ," + // 3: sourcemenu key
//                "SOURCE_MENU_VALUE TEXT NOT NULL )")  // 4: sourcemenu value


        //other table
        db?.execSQL("CREATE TABLE IF NOT EXISTS " + OTHER_TABLE + "(" + //
                "_id INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "freeze INTEGER NOT NULL ," +
                "pause INTEGER NOT NULL ," +
                "sound_only INTEGER NOT NULL ," +
                "bluelight_filter INTEGER NOT NULL ," +
                "bluelight_filter_value INTEGER NOT NULL  )")



        //TODO init default data
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //TODO upgrade
    }

}