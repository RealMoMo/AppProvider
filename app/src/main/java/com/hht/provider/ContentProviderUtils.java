package com.hht.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;


/**
 * @author RealMo
 * @version 2.0
 * @date 创建时间：2018-4-23 上午11:00:54
 * @parameter
 * @return
 */
public class ContentProviderUtils {
    //ContentProvider的uri
    public static final String SETTING_CONTENT_PROVIDER_URI="content://mstar.hv.usersetting/functionsetting";
    public static final String SYSTEM_THEME = "system_theme";

    /**
     * 更新ContentProvider的数据
     *
     * @param context
     * @param uriAddress
     * @param indexName  字段:如 bEnableLeftFloatBar
     * @param value      封装常用了类型String Boolean Float Integer Long
     *                   值
     * @return 更新的数目
     */
    public static int doUpdate(Context context, String uriAddress,
                               String indexName, Object value) {
        Uri uri = Uri.parse(uriAddress);
        ContentResolver resolver = context.getContentResolver();
        ContentValues conValue = new ContentValues();
        if (value instanceof Boolean) {
            conValue.put(indexName, (Boolean) value);
        } else if (value instanceof Float) {
            conValue.put(indexName, (Float) value);
        } else if (value instanceof Integer) {
            conValue.put(indexName, (Integer) value);
        } else if (value instanceof Long) {
            conValue.put(indexName, (Long) value);
        } else {
            conValue.put(indexName, (String) value);
        }


        try {
            int count = resolver.update(uri, conValue, null, null);

            return count;
        } catch (Exception exception) {

            return 0;
        }

    }


    /**
     * 查询返回Integer值 ContentProvider第一条的数据
     *
     * @param context
     * @param uriAddress
     * @param indexName
     * @return
     */
    public static int doQueryInteger(Context context, String uriAddress,
                                     String indexName) {
        Uri uri = Uri.parse(uriAddress);
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = resolver.query(uri, null, null, null, null);


        if(cursor == null){
            return -1;
        }
        int value = 0;
        cursor.moveToFirst();
        value = cursor.getInt(cursor.getColumnIndex(indexName));
        cursor.close();

        return value;
    }


    /**
     * 查询返回String值 ContentProvider单个字段值的数据
     *
     * @param context
     * @param uriAddress
     * @param indexName
     * @return
     */
    public static String doQueryString(Context context, String uriAddress,
                                       String indexName) {
        Uri uri = Uri.parse(uriAddress);
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = resolver.query(uri, null, null, null, null);


        if(cursor == null){
            return "";
        }
        String value;
        cursor.moveToFirst();
        value = cursor.getString(cursor.getColumnIndex(indexName));

        cursor.close();

        return value;
    }


}
