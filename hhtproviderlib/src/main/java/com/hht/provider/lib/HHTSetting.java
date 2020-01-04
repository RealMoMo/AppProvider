package com.hht.provider.lib;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.SQLException;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * @author Realmo
 * @version 1.0.0
 * @name HHTProvider
 * @email momo.weiye@gmail.com
 * @time 2020/1/4 14:18
 * @describe
 */
public class HHTSetting {

    private static final String TAG  = "realmo";




    public static final class System extends NameValueTable{

        public static final String AUTHORITY = "com.hht.function";


        public static final Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/system");


        public static String getString(ContentResolver resolver, String name){
            return null;
        }


        public static boolean putString(ContentResolver resolver, String name, String value){
            return false;
        }


        public static int getInt(ContentResolver resolver, String name){
            return -1;
        }

        public static boolean putInt(ContentResolver resolver, String name, int value){
            return false;
        }

        public static boolean getBoolean(ContentResolver resolver, String name){
            return false;
        }

        public static boolean putBoolean(ContentResolver resolver, String name, int value){
            return false;
        }

        public static Uri getUriFor(String name) {

            return getUriFor(CONTENT_URI, name);
        }


        public static final String THEME_TYPE ="theme_type";
        public static final String THEME_RES_PATH ="theme_res_path";
        public static final String DATE_FORMAT ="date_format";

    }


    public static final class Secure extends NameValueTable{

        public static final String AUTHORITY = "com.hht.function";


        public static final Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/secure");


        public static String getString(ContentResolver resolver, String name){
            return null;
        }


        public static boolean putString(ContentResolver resolver, String name, String value){
            return false;
        }


        public static int getInt(ContentResolver resolver, String name){
            return -1;
        }

        public static boolean putInt(ContentResolver resolver, String name, int value){
            return false;
        }

        public static boolean getBoolean(ContentResolver resolver, String name){
            return false;
        }

        public static boolean putBoolean(ContentResolver resolver, String name, int value){
            return false;
        }

        public static Uri getUriFor(String name) {

            return getUriFor(CONTENT_URI, name);
        }


        public static final String LOCK_SCREEN_MASTER_PASSKEY ="lock_screen_master_passkey";
        public static final String LOCK_SCREEN_PASSKEY ="lock_screen_passkey";
        public static final String QUICKSETTING_ENABLE ="quicksetting_enable";
        public static final String CLEAR_FILE_TIME ="clear_file_time";
        public static final String OTA_SERVER_ENVIROMENT ="ota_servce_enviroment";

    }


    public static final class Source extends NameValueTable{

        public static final String AUTHORITY = "com.hht.function";


        public static final Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/source");


        public static String getString(ContentResolver resolver, String name){
            return null;
        }


        public static boolean putString(ContentResolver resolver, String name, String value){
            return false;
        }


        public static int getInt(ContentResolver resolver, String name){
            return -1;
        }

        public static boolean putInt(ContentResolver resolver, String name, int value){
            return false;
        }

        public static boolean getBoolean(ContentResolver resolver, String name){
            return false;
        }

        public static boolean putBoolean(ContentResolver resolver, String name, int value){
            return false;
        }

        public static Uri getUriFor(String name) {

            return getUriFor(CONTENT_URI, name);
        }


        public static final String CURRENT_SOURCE_ORDINAL ="current_source_ordinal";
        public static final String CURRENT_SOURCE_TYPE ="current_source_type";
        public static final String FAVORITE_SOURCE_ORDINAL ="favorite_source_ordinal";
        public static final String FAVORITE_SOURCE_TYPE ="favorite_source_type";
        public static final String LAST_SOURCE_ORDINAL ="last_source_ordinal";
        public static final String LAST_SOURCE_TYPE ="last_source_type";
        public static final String HOME_SOURCE_TYPE ="home_source_type";
        public static final String PC_RENAME ="pc_rename";
        public static final String HDMI_FRONT_RENAME ="hdmi_front_rename";
        public static final String HDMI1_RENAME ="hdmi1_rename";
        public static final String HDMI2_RENAME ="hdmi2_rename";
        public static final String HDMI3_RENAME ="hdmi3_rename";
        public static final String TYPE_C_RENAME ="type_c_rename";
        public static final String VGA_RENAME ="vga_rename";
        public static final String DP_RENAME ="dp_rename";


    }


    public static final class WhiteBoard extends NameValueTable{

        public static final String AUTHORITY = "com.hht.function";


        public static final Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/whiteboard");


        public static String getString(ContentResolver resolver, String name){
            return null;
        }


        public static boolean putString(ContentResolver resolver, String name, String value){
            return false;
        }


        public static int getInt(ContentResolver resolver, String name){
            return -1;
        }

        public static boolean putInt(ContentResolver resolver, String name, int value){
            return false;
        }

        public static boolean getBoolean(ContentResolver resolver, String name){
            return false;
        }

        public static boolean putBoolean(ContentResolver resolver, String name, int value){
            return false;
        }

        public static Uri getUriFor(String name) {

            return getUriFor(CONTENT_URI, name);
        }


        public static final String IS_ANNOTATIONING ="is_annotationing";
        public static final String WRITING_PROTECTION ="writing_protection";

    }



    public static final class Toolbar extends NameValueTable{

        public static final String AUTHORITY = "com.hht.function";


        public static final Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/toolbar");


        public static String getString(ContentResolver resolver, String name){
            return null;
        }


        public static boolean putString(ContentResolver resolver, String name, String value){
            return false;
        }


        public static int getInt(ContentResolver resolver, String name){
            return -1;
        }

        public static boolean putInt(ContentResolver resolver, String name, int value){
            return false;
        }

        public static boolean getBoolean(ContentResolver resolver, String name){
            return false;
        }

        public static boolean putBoolean(ContentResolver resolver, String name, int value){
            return false;
        }

        public static Uri getUriFor(String name) {

            return getUriFor(CONTENT_URI, name);
        }


        public static final String LEFT_BAR_OPEN ="left_bar_open";
        public static final String RIGHT_BAR_OPEN ="right_bar_open";
        public static final String BAR_OPEN ="bar_open";
        public static final String BAR_SIZE ="bar_size";

    }


    //TODO 处理定时开关机的时间数据 是否采用标准的sql处理？？？
    public static final class Time extends NameValueTable{

        public static final String AUTHORITY = "com.hht.function";


        public static final Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/time");


        public static String getString(ContentResolver resolver, String name){
            return null;
        }


        public static boolean putString(ContentResolver resolver, String name, String value){
            return false;
        }


        public static int getInt(ContentResolver resolver, String name){
            return -1;
        }

        public static boolean putInt(ContentResolver resolver, String name, int value){
            return false;
        }

        public static boolean getBoolean(ContentResolver resolver, String name){
            return false;
        }

        public static boolean putBoolean(ContentResolver resolver, String name, int value){
            return false;
        }

        public static Uri getUriFor(String name) {

            return getUriFor(CONTENT_URI, name);
        }




    }


    public static final class Other extends NameValueTable{

        public static final String AUTHORITY = "com.hht.function";


        public static final Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/other");


        public static String getString(ContentResolver resolver, String name){
            return null;
        }


        public static boolean putString(ContentResolver resolver, String name, String value){
            return false;
        }


        public static int getInt(ContentResolver resolver, String name){
            return -1;
        }

        public static boolean putInt(ContentResolver resolver, String name, int value){
            return false;
        }

        public static boolean getBoolean(ContentResolver resolver, String name){
            return false;
        }

        public static boolean putBoolean(ContentResolver resolver, String name, int value){
            return false;
        }

        public static Uri getUriFor(String name) {

            return getUriFor(CONTENT_URI, name);
        }


        public static final String FREEZE ="freeze";
        public static final String PAUSE="pause";
        public static final String SOUND_ONLY ="sound_only";
        public static final String BLUELIGHT_FILTER ="bluelight_filter";
        public static final String BLUELIGHT_FILTER_VALUE ="bluelight_filter_value";

    }


    /**
     * Common base for tables of name/value settings.
     */
    public static class NameValueTable implements BaseColumns {
        public static final String NAME = "name";
        public static final String VALUE = "value";

        protected static boolean putString(ContentResolver resolver, Uri uri,
                                           String name, String value) {
            // The database will take care of replacing duplicates.
            try {
                ContentValues values = new ContentValues();
                values.put(NAME, name);
                values.put(VALUE, value);
                resolver.insert(uri, values);
                return true;
            } catch (SQLException e) {
                Log.w(TAG, "Can't set key " + name + " in " + uri, e);
                return false;
            }
        }

        public static Uri getUriFor(Uri uri, String name) {
            return Uri.withAppendedPath(uri, name);
        }
    }

}
