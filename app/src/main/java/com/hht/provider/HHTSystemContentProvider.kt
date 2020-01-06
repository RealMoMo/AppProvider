package com.hht.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import android.util.Log
import com.tencent.mmkv.MMKV

/**
 * @name HHTSystemContentProvider
 * @author Realmo
 * @email   momo.weiye@gmail.com
 * @version 1.0.0
 * @time 2020/1/2 19:28
 * @describe
 */
class HHTSystemContentProvider : ContentProvider() {


    companion object {
        const val NULL = "null"
        const val TAG = "hhtprovider"

        val lock = Any()
        const val PROVIDER_VERSION = "provider_version"
        const val CURRENT_VERSION = 1
        //val matcher: UriMatcher

        const val AUTHORITIES = "com.hht.function"

        const val TABLE_SYSTEM_FUNCTION = 100
        const val TABLE_SYSTEM_FUNCTION_WITH_ID = 110

        const val TABLE_SERCURE_FUNCTION = 101
        const val TABLE_SERCURE_FUNCTION_WITH_ID = 111

        const val TABLE_SOURCE_FUNCTION = 102
        const val TABLE_SOURCE_FUNCTION_WITH_ID = 112

        const val TABLE_WHITEBOARD_FUNCTION = 103
        const val TABLE_WHITEBOARD_FUNCTION_WITH_ID = 113

        const val TABLE_TOOLBAR_FUNCTION = 104
        const val TABLE_TOOLBAR_FUNCTION_WITH_ID = 114

        const val TABLE_TIME_FUNCTION = 105
        const val TABLE_TIME_FUNCTION_WITH_ID = 115

        const val TABLE_OTHER_FUNCTION = 106
        const val TABLE_OTHER_FUNCTION_WITH_ID = 116


        //val matcherMap: HashMap<Int, String>


        init {
//            matcher = UriMatcher(UriMatcher.NO_MATCH)
//            matcherMap = HashMap()
//
//            matcher.addURI(AUTHORITIES, HHTProviderHelper.SYSTEM_TABLE, TABLE_SYSTEM_FUNCTION)
//            //  # 代表数字 * 代表字符串
//            matcher.addURI(
//                AUTHORITIES,
//                HHTProviderHelper.SYSTEM_TABLE + "/#",
//                TABLE_SYSTEM_FUNCTION_WITH_ID
//            )
//            matcherMap.put(TABLE_SYSTEM_FUNCTION, HHTProviderHelper.SYSTEM_TABLE)
//            matcherMap.put(TABLE_SYSTEM_FUNCTION_WITH_ID, HHTProviderHelper.SYSTEM_TABLE)
//
//            matcher.addURI(AUTHORITIES, HHTProviderHelper.SECURE_TABLE, TABLE_SERCURE_FUNCTION)
//            //  # 代表数字 * 代表字符串
//            matcher.addURI(
//                AUTHORITIES,
//                HHTProviderHelper.SECURE_TABLE + "/#",
//                TABLE_SERCURE_FUNCTION_WITH_ID
//            )
//            matcherMap.put(TABLE_SERCURE_FUNCTION, HHTProviderHelper.SECURE_TABLE)
//            matcherMap.put(TABLE_SERCURE_FUNCTION_WITH_ID, HHTProviderHelper.SECURE_TABLE)
//
//            matcher.addURI(AUTHORITIES, HHTProviderHelper.SOURCE_TABLE, TABLE_SOURCE_FUNCTION)
//            //  # 代表数字 * 代表字符串
//            matcher.addURI(
//                AUTHORITIES,
//                HHTProviderHelper.SOURCE_TABLE + "/#",
//                TABLE_SOURCE_FUNCTION_WITH_ID
//            )
//            matcherMap.put(TABLE_SOURCE_FUNCTION, HHTProviderHelper.SOURCE_TABLE)
//            matcherMap.put(TABLE_SOURCE_FUNCTION_WITH_ID, HHTProviderHelper.SOURCE_TABLE)
//
//            matcher.addURI(
//                AUTHORITIES,
//                HHTProviderHelper.WHITEBOARD_TABLE,
//                TABLE_WHITEBOARD_FUNCTION
//            )
//            //  # 代表数字 * 代表字符串
//            matcher.addURI(
//                AUTHORITIES,
//                HHTProviderHelper.WHITEBOARD_TABLE + "/#",
//                TABLE_WHITEBOARD_FUNCTION_WITH_ID
//            )
//            matcherMap.put(TABLE_WHITEBOARD_FUNCTION, HHTProviderHelper.WHITEBOARD_TABLE)
//            matcherMap.put(TABLE_WHITEBOARD_FUNCTION_WITH_ID, HHTProviderHelper.WHITEBOARD_TABLE)
//
//            matcher.addURI(AUTHORITIES, HHTProviderHelper.TOOLBAR_TABLE, TABLE_TOOLBAR_FUNCTION)
//            //  # 代表数字 * 代表字符串
//            matcher.addURI(
//                AUTHORITIES,
//                HHTProviderHelper.TOOLBAR_TABLE + "/#",
//                TABLE_TOOLBAR_FUNCTION_WITH_ID
//            )
//            matcherMap.put(TABLE_TOOLBAR_FUNCTION, HHTProviderHelper.TOOLBAR_TABLE)
//            matcherMap.put(TABLE_TOOLBAR_FUNCTION_WITH_ID, HHTProviderHelper.TOOLBAR_TABLE)
//
//            matcher.addURI(AUTHORITIES, HHTProviderHelper.TIME_TABLE, TABLE_TIME_FUNCTION)
//            //  # 代表数字 * 代表字符串
//            matcher.addURI(
//                AUTHORITIES,
//                HHTProviderHelper.TIME_TABLE + "/#",
//                TABLE_TIME_FUNCTION_WITH_ID
//            )
//            matcherMap.put(TABLE_TIME_FUNCTION, HHTProviderHelper.TIME_TABLE)
//            matcherMap.put(TABLE_TIME_FUNCTION_WITH_ID, HHTProviderHelper.TIME_TABLE)
//
//            matcher.addURI(AUTHORITIES, HHTProviderHelper.OTHER_TABLE, TABLE_OTHER_FUNCTION)
//            //  # 代表数字 * 代表字符串
//            matcher.addURI(
//                AUTHORITIES,
//                HHTProviderHelper.OTHER_TABLE + "/#",
//                TABLE_OTHER_FUNCTION_WITH_ID
//            )
//            matcherMap.put(TABLE_OTHER_FUNCTION, HHTProviderHelper.OTHER_TABLE)
//            matcherMap.put(TABLE_OTHER_FUNCTION_WITH_ID, HHTProviderHelper.OTHER_TABLE)
        }
    }

    lateinit var dbHelper: HHTProviderHelper
    val mmkv by lazy {
        MMKV.defaultMMKV()
    }

    override fun onCreate(): Boolean {
        Log.v(TAG,"init")
        MMKV.initialize(context)
        synchronized(lock){
            //TODO version check and migrate data
            migrationData()
        }
        return false

    }

    override fun query(
        uri: Uri,
        projection: Array<String>?,
        selection: String?,
        selectionArgs: Array<String>?,
        sortOrder: String?
    ): Cursor? {
        synchronized(lock){
            val key = projection?.get(0)
            mmkv.decodeString(key,NULL)
            val cursor: MatrixCursor = MatrixCursor(projection,1)
            cursor.addRow(arrayOf(mmkv.decodeString(key,NULL)))
            cursor.setNotificationUri(context.contentResolver, uri)
            return cursor
        }
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {

        return uri
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        synchronized(lock) {
            val key = values?.get("key") as String
            val value = values?.get("value") as String
            val success = mmkv.encode(key, value)

            context.contentResolver.notifyChange(Uri.withAppendedPath(uri, key), null)
            return if (success) {
                1
            } else {
                0
            }
        }
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {

        return 0
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    /**
     * 迁移数据
     */
    private fun migrationData(){

        //
        if(mmkv.containsKey(PROVIDER_VERSION)){
            val systemProviderVersion = mmkv.decodeInt(PROVIDER_VERSION)
            if(systemProviderVersion == CURRENT_VERSION){
                return
            }else{
                doRealMigrationData(systemProviderVersion,CURRENT_VERSION)

                mmkv.encode(PROVIDER_VERSION, CURRENT_VERSION)
            }
        }else{
            //没有Version数据，是第一次加载数据库。需初始化数据。
            initNewestProviderData()

            mmkv.encode(PROVIDER_VERSION, CURRENT_VERSION)
        }
    }



    private fun doRealMigrationData(oldVersion:Int,newVersion:Int){

    }

    /**
     * 初始化最新版本Provider数据
     */
    private fun initNewestProviderData() {

    }
}