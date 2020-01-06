package com.hht.provider.lib;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
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

    private static final String TAG  = "provider_lib";

    private static final String TRUE_STR = "1";
    private static final String FALSE_STR = "0";

    private static final int TRUE_VALUE = 1;
    private static final int FALSE_VALUE = 0;


    public static final class System extends NameValueTable{


        public static final Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/system");


        public static String getString(ContentResolver resolver, String name){
            return getString(CONTENT_URI,resolver,name);
        }


        public static boolean putString(ContentResolver resolver, String name, String value){

            return putString(resolver,CONTENT_URI,name,value);
        }


        public static int getInt(ContentResolver resolver, String name){
            return Integer.parseInt(getString(CONTENT_URI,resolver,name));
        }

        public static boolean putInt(ContentResolver resolver, String name, int value){
            return putString(resolver,CONTENT_URI,name,value+"");
        }

        public static boolean getBoolean(ContentResolver resolver, String name){
            return Integer.parseInt(getString(CONTENT_URI,resolver,name)) == TRUE_VALUE;
        }

        public static boolean putBoolean(ContentResolver resolver, String name, boolean value){
            return putString(resolver,CONTENT_URI,name,value? TRUE_STR : FALSE_STR);
        }

        public static Uri getUriFor(String name) {

            return getUriFor(CONTENT_URI, name);
        }

        /**
         * 主题类型
         */
        public static final String THEME_TYPE ="theme_type";
        /**
         * 主题资源包路径
         */
        public static final String THEME_RES_PATH ="theme_res_path";
        /**
         * 日期格式
         */
        public static final String DATE_FORMAT ="date_format";

    }


    public static final class Secure extends NameValueTable{

        public static final String AUTHORITY = "com.hht.function";


        public static final Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/secure");


        public static String getString(ContentResolver resolver, String name){
            return getString(CONTENT_URI,resolver,name);
        }


        public static boolean putString(ContentResolver resolver, String name, String value){

            return putString(resolver,CONTENT_URI,name,value);
        }


        public static int getInt(ContentResolver resolver, String name){
            return Integer.parseInt(getString(CONTENT_URI,resolver,name));
        }

        public static boolean putInt(ContentResolver resolver, String name, int value){
            return putString(resolver,CONTENT_URI,name,value+"");
        }

        public static boolean getBoolean(ContentResolver resolver, String name){
            return Integer.parseInt(getString(CONTENT_URI,resolver,name)) == TRUE_VALUE;
        }

        public static boolean putBoolean(ContentResolver resolver, String name, boolean value){
            return putString(resolver,CONTENT_URI,name,value? TRUE_STR : FALSE_STR);
        }

        public static Uri getUriFor(String name) {

            return getUriFor(CONTENT_URI, name);
        }

        /**
         * 锁屏万能密码
         */
        public static final String LOCK_SCREEN_MASTER_PASSKEY ="lock_screen_master_passkey";
        /**
         * 锁屏密码
         */
        public static final String LOCK_SCREEN_PASSKEY ="lock_screen_passkey";
        /**
         * 是否在锁屏界面中
         */
        public static final String LOCK_SCREEN_STATUS = "lock_screen_status";
        /**
         *  QuickSetting是否可用
         */

        public static final String QUICKSETTING_ENABLE ="quicksetting_enable";
        /**
         *  Setting是否可用
         */
        public static final String SETTING_ENABLE ="setting_enable";
        /**
         * 清除过时会议资料期限
         */
        public static final String CLEAR_FILE_TIME ="clear_file_time";
        /**
         * OTA部署环境
         */
        public static final String OTA_SERVER_ENVIROMENT ="ota_servce_enviroment";

    }


    public static final class Source extends NameValueTable{

        public static final String AUTHORITY = "com.hht.function";


        public static final Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/source");


        public static String getString(ContentResolver resolver, String name){
            return getString(CONTENT_URI,resolver,name);
        }


        public static boolean putString(ContentResolver resolver, String name, String value){

            return putString(resolver,CONTENT_URI,name,value);
        }


        public static int getInt(ContentResolver resolver, String name){
            return Integer.parseInt(getString(CONTENT_URI,resolver,name));
        }

        public static boolean putInt(ContentResolver resolver, String name, int value){
            return putString(resolver,CONTENT_URI,name,value+"");
        }

        public static boolean getBoolean(ContentResolver resolver, String name){
            return Integer.parseInt(getString(CONTENT_URI,resolver,name)) == TRUE_VALUE;
        }

        public static boolean putBoolean(ContentResolver resolver, String name, boolean value){
            return putString(resolver,CONTENT_URI,name,value? TRUE_STR : FALSE_STR);
        }

        public static Uri getUriFor(String name) {

            return getUriFor(CONTENT_URI, name);
        }

        /**
         * 当前信号源对应系统信号源Enum.ordianl
         */
        public static final String CURRENT_SOURCE_ORDINAL ="current_source_ordinal";
        /**
         * 当前信号源名称
         * 如：Hdmi1,OPS等
         */
        public static final String CURRENT_SOURCE_TYPE ="current_source_type";
        /**
         * FAVORITE 信号源对应系统信号源Enum.ordianl
         */
        public static final String FAVORITE_SOURCE_ORDINAL ="favorite_source_ordinal";
        /**
         * FAVORITE 信号源名称
         */
        public static final String FAVORITE_SOURCE_TYPE ="favorite_source_type";
        /**
         * 上次信号源对应系统信号源Enum.ordianl
         */
        public static final String LAST_SOURCE_ORDINAL ="last_source_ordinal";
        /**
         * 上次信号源名称
         */
        public static final String LAST_SOURCE_TYPE ="last_source_type";
        /**
         * HomeSource
         */
        public static final String HOME_SOURCE_TYPE ="home_source_type";
        /**
         * PC信号源自定义名称
         */
        public static final String PC_RENAME ="pc_rename";
        /**
         * HDMI_Front信号源自定义名称
         */
        public static final String HDMI_FRONT_RENAME ="hdmi_front_rename";
        /**
         * HDMI1信号源自定义名称
         */
        public static final String HDMI1_RENAME ="hdmi1_rename";
        /**
         * HDMI2信号源自定义名称
         */
        public static final String HDMI2_RENAME ="hdmi2_rename";
        /**
         * HDMI3信号源自定义名称
         */
        public static final String HDMI3_RENAME ="hdmi3_rename";
        /**
         * TYPE C信号源自定义名称
         */
        public static final String TYPE_C_RENAME ="type_c_rename";
        /**
         * VGA信号源自定义名称
         */
        public static final String VGA_RENAME ="vga_rename";
        /**
         * DP信号源自定义名称
         */
        public static final String DP_RENAME ="dp_rename";


    }


    public static final class WhiteBoard extends NameValueTable{

        public static final String AUTHORITY = "com.hht.function";


        public static final Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/whiteboard");


        public static String getString(ContentResolver resolver, String name){
            return getString(CONTENT_URI,resolver,name);
        }


        public static boolean putString(ContentResolver resolver, String name, String value){

            return putString(resolver,CONTENT_URI,name,value);
        }


        public static int getInt(ContentResolver resolver, String name){
            return Integer.parseInt(getString(CONTENT_URI,resolver,name));
        }

        public static boolean putInt(ContentResolver resolver, String name, int value){
            return putString(resolver,CONTENT_URI,name,value+"");
        }

        public static boolean getBoolean(ContentResolver resolver, String name){
            return Integer.parseInt(getString(CONTENT_URI,resolver,name)) == TRUE_VALUE;
        }

        public static boolean putBoolean(ContentResolver resolver, String name, boolean value){
            return putString(resolver,CONTENT_URI,name,value? TRUE_STR : FALSE_STR);
        }

        public static Uri getUriFor(String name) {

            return getUriFor(CONTENT_URI, name);
        }

        /**
         * 是否正在批注中
         */
        public static final String IS_ANNOTATIONING ="is_annotationing";
        /**
         * 护眼书写
         */
        public static final String WRITING_PROTECTION ="writing_protection";

    }



    public static final class Toolbar extends NameValueTable{

        public static final String AUTHORITY = "com.hht.function";


        public static final Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/toolbar");


        public static String getString(ContentResolver resolver, String name){
            return getString(CONTENT_URI,resolver,name);
        }


        public static boolean putString(ContentResolver resolver, String name, String value){

            return putString(resolver,CONTENT_URI,name,value);
        }


        public static int getInt(ContentResolver resolver, String name){
            return Integer.parseInt(getString(CONTENT_URI,resolver,name));
        }

        public static boolean putInt(ContentResolver resolver, String name, int value){
            return putString(resolver,CONTENT_URI,name,value+"");
        }

        public static boolean getBoolean(ContentResolver resolver, String name){
            return Integer.parseInt(getString(CONTENT_URI,resolver,name)) == TRUE_VALUE;
        }

        public static boolean putBoolean(ContentResolver resolver, String name, boolean value){
            return putString(resolver,CONTENT_URI,name,value? TRUE_STR : FALSE_STR);
        }

        public static Uri getUriFor(String name) {

            return getUriFor(CONTENT_URI, name);
        }

        /**
         * 左侧ToolBar是否可用
         */
        public static final String LEFT_BAR_OPEN ="left_bar_open";
        /**
         * 右侧ToolBar是否可用
         */
        public static final String RIGHT_BAR_OPEN ="right_bar_open";
        /**
         * ToolBar是否可用
         */
        public static final String BAR_OPEN ="bar_open";
        /**
         * ToolBar大小模式
         */
        public static final String BAR_SIZE ="bar_size";

    }


    //TODO 处理定时开关机的时间数据 是否采用标准的sql处理？？？
    public static final class Time extends NameValueTable{

        public static final String AUTHORITY = "com.hht.function";


        public static final Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/time");


        public static String getString(ContentResolver resolver, String name){
            return getString(CONTENT_URI,resolver,name);
        }


        public static boolean putString(ContentResolver resolver, String name, String value){

            return putString(resolver,CONTENT_URI,name,value);
        }


        public static int getInt(ContentResolver resolver, String name){
            return Integer.parseInt(getString(CONTENT_URI,resolver,name));
        }

        public static boolean putInt(ContentResolver resolver, String name, int value){
            return putString(resolver,CONTENT_URI,name,value+"");
        }

        public static boolean getBoolean(ContentResolver resolver, String name){
            return Integer.parseInt(getString(CONTENT_URI,resolver,name)) == TRUE_VALUE;
        }

        public static boolean putBoolean(ContentResolver resolver, String name, boolean value){
            return putString(resolver,CONTENT_URI,name,value? TRUE_STR : FALSE_STR);
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
            return getString(CONTENT_URI,resolver,name);
        }


        public static boolean putString(ContentResolver resolver, String name, String value){

            return putString(resolver,CONTENT_URI,name,value);
        }


        public static int getInt(ContentResolver resolver, String name){
            return Integer.parseInt(getString(CONTENT_URI,resolver,name));
        }

        public static boolean putInt(ContentResolver resolver, String name, int value){
            return putString(resolver,CONTENT_URI,name,value+"");
        }

        public static boolean getBoolean(ContentResolver resolver, String name){
            return Integer.parseInt(getString(CONTENT_URI,resolver,name)) == TRUE_VALUE;
        }

        public static boolean putBoolean(ContentResolver resolver, String name, boolean value){
            return putString(resolver,CONTENT_URI,name,value? TRUE_STR : FALSE_STR);
        }

        public static Uri getUriFor(String name) {

            return getUriFor(CONTENT_URI, name);
        }

        /**
         *  Freeze标志
         */
        public static final String FREEZE ="freeze";
        /**
         * Pause标志
         */
        public static final String PAUSE="pause";
        /**
         * SoundOnly标志
         */
        public static final String SOUND_ONLY ="sound_only";
        /**
         * 滤蓝光标志
         */
        public static final String BLUELIGHT_FILTER ="bluelight_filter";
        /**
         * 滤蓝光等级
         */
        public static final String BLUELIGHT_FILTER_VALUE ="bluelight_filter_value";

    }


    /**
     * Common base for tables of name/value settings.
     */
    public static class NameValueTable implements BaseColumns {

        public static final String AUTHORITY = "com.hht.function";

        public static final String NAME = "key";
        public static final String VALUE = "value";

        protected static boolean putString(ContentResolver resolver, Uri uri,
                                           String name, String value) {

            try {
            ContentValues conValue = new ContentValues();
            conValue.put(NAME, name);
            conValue.put(VALUE, value);
            resolver.update(uri,conValue,null,null);
            return true;
            } catch (SQLException e) {
                Log.w(TAG, "Can't set key " + name + " in " + uri, e);
                return false;
            }

        }

        protected static String getString(Uri uri,ContentResolver resolver, String name){
            Cursor cursor = resolver.query(uri,new String[]{name},null,null,null);
            String value = null;
            if(cursor == null){
                return value;
            }
            cursor.moveToFirst();
            value = cursor.getString(cursor.getColumnIndex(name));
            cursor.close();

            return value;
        }

        public static Uri getUriFor(Uri uri, String name) {

            if(name == null){
                return uri;
            }

            if(name.isEmpty()){
                return uri;
            }

            return Uri.withAppendedPath(uri, name);
        }
    }

}
