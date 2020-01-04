package com.hht.provider

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri

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
        val matcher: UriMatcher
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


        val matcherMap: HashMap<Int, String>


        init {
            matcher = UriMatcher(UriMatcher.NO_MATCH)
            matcherMap = HashMap()

            matcher.addURI(AUTHORITIES, HHTProviderHelper.SYSTEM_TABLE, TABLE_SYSTEM_FUNCTION)
            //  # 代表数字 * 代表字符串
            matcher.addURI(
                AUTHORITIES,
                HHTProviderHelper.SYSTEM_TABLE + "/#",
                TABLE_SYSTEM_FUNCTION_WITH_ID
            )
            matcherMap.put(TABLE_SYSTEM_FUNCTION, HHTProviderHelper.SYSTEM_TABLE)
            matcherMap.put(TABLE_SYSTEM_FUNCTION_WITH_ID, HHTProviderHelper.SYSTEM_TABLE)

            matcher.addURI(AUTHORITIES, HHTProviderHelper.SECURE_TABLE, TABLE_SERCURE_FUNCTION)
            //  # 代表数字 * 代表字符串
            matcher.addURI(
                AUTHORITIES,
                HHTProviderHelper.SECURE_TABLE + "/#",
                TABLE_SERCURE_FUNCTION_WITH_ID
            )
            matcherMap.put(TABLE_SERCURE_FUNCTION, HHTProviderHelper.SECURE_TABLE)
            matcherMap.put(TABLE_SERCURE_FUNCTION_WITH_ID, HHTProviderHelper.SECURE_TABLE)

            matcher.addURI(AUTHORITIES, HHTProviderHelper.SOURCE_TABLE, TABLE_SOURCE_FUNCTION)
            //  # 代表数字 * 代表字符串
            matcher.addURI(
                AUTHORITIES,
                HHTProviderHelper.SOURCE_TABLE + "/#",
                TABLE_SOURCE_FUNCTION_WITH_ID
            )
            matcherMap.put(TABLE_SOURCE_FUNCTION, HHTProviderHelper.SOURCE_TABLE)
            matcherMap.put(TABLE_SOURCE_FUNCTION_WITH_ID, HHTProviderHelper.SOURCE_TABLE)

            matcher.addURI(
                AUTHORITIES,
                HHTProviderHelper.WHITEBOARD_TABLE,
                TABLE_WHITEBOARD_FUNCTION
            )
            //  # 代表数字 * 代表字符串
            matcher.addURI(
                AUTHORITIES,
                HHTProviderHelper.WHITEBOARD_TABLE + "/#",
                TABLE_WHITEBOARD_FUNCTION_WITH_ID
            )
            matcherMap.put(TABLE_WHITEBOARD_FUNCTION, HHTProviderHelper.WHITEBOARD_TABLE)
            matcherMap.put(TABLE_WHITEBOARD_FUNCTION_WITH_ID, HHTProviderHelper.WHITEBOARD_TABLE)

            matcher.addURI(AUTHORITIES, HHTProviderHelper.TOOLBAR_TABLE, TABLE_TOOLBAR_FUNCTION)
            //  # 代表数字 * 代表字符串
            matcher.addURI(
                AUTHORITIES,
                HHTProviderHelper.TOOLBAR_TABLE + "/#",
                TABLE_TOOLBAR_FUNCTION_WITH_ID
            )
            matcherMap.put(TABLE_TOOLBAR_FUNCTION, HHTProviderHelper.TOOLBAR_TABLE)
            matcherMap.put(TABLE_TOOLBAR_FUNCTION_WITH_ID, HHTProviderHelper.TOOLBAR_TABLE)

            matcher.addURI(AUTHORITIES, HHTProviderHelper.TIME_TABLE, TABLE_TIME_FUNCTION)
            //  # 代表数字 * 代表字符串
            matcher.addURI(
                AUTHORITIES,
                HHTProviderHelper.TIME_TABLE + "/#",
                TABLE_TIME_FUNCTION_WITH_ID
            )
            matcherMap.put(TABLE_TIME_FUNCTION, HHTProviderHelper.TIME_TABLE)
            matcherMap.put(TABLE_TIME_FUNCTION_WITH_ID, HHTProviderHelper.TIME_TABLE)

            matcher.addURI(AUTHORITIES, HHTProviderHelper.OTHER_TABLE, TABLE_OTHER_FUNCTION)
            //  # 代表数字 * 代表字符串
            matcher.addURI(
                AUTHORITIES,
                HHTProviderHelper.OTHER_TABLE + "/#",
                TABLE_OTHER_FUNCTION_WITH_ID
            )
            matcherMap.put(TABLE_OTHER_FUNCTION, HHTProviderHelper.OTHER_TABLE)
            matcherMap.put(TABLE_OTHER_FUNCTION_WITH_ID, HHTProviderHelper.OTHER_TABLE)
        }
    }

    lateinit var dbHelper: HHTProviderHelper


    override fun onCreate(): Boolean {
        dbHelper = HHTProviderHelper(context)
        if (dbHelper != null) {
            return true
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
        val matchType = matcher.match(uri)
        val db = dbHelper.writableDatabase
        var cursor: Cursor? = null
        when (matchType) {
            in TABLE_SYSTEM_FUNCTION..TABLE_OTHER_FUNCTION -> {
                cursor = db.query(
                    matcherMap.get(matchType), projection, selection,
                    selectionArgs, null, null, sortOrder
                )
            }
            else -> {
                val id = ContentUris.parseId(uri)
                var where = "_id=" + id
                if (selection != null) {
                    where = " and " + selection
                }
                cursor = db.query(
                    matcherMap.get(matchType), projection, where,
                    selectionArgs, null, null, sortOrder
                )
            }
        }
        cursor?.setNotificationUri(context.contentResolver, uri)
        return cursor
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val matchType = matcher.match(uri)
        val db = dbHelper.writableDatabase
        var id: Long = -1
        when (matchType) {
            in TABLE_SYSTEM_FUNCTION..TABLE_OTHER_FUNCTION -> {
                id = db.insert(matcherMap.get(matchType), null, values)
            }
        }
        val result = ContentUris.withAppendedId(uri, id)
        context.contentResolver.notifyChange(uri, null)
        return result
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        val matchType = matcher.match(uri)
        val db = dbHelper.writableDatabase
        var updateCount = 0
        when (matchType) {
            in TABLE_SYSTEM_FUNCTION..TABLE_OTHER_FUNCTION -> {
                updateCount =
                    db.update(matcherMap.get(matchType), values, selection, selectionArgs)
            }
            else -> {
                val id = ContentUris.parseId(uri)
                var where = "_id=" + id
                if (selection != null) {
                    where = " and " + selection
                }
                updateCount = db.update(matcherMap.get(matchType), values, where, selectionArgs)
            }
        }
        context.contentResolver.notifyChange(uri, null)
        return updateCount
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val matchType = matcher.match(uri)
        val db = dbHelper.writableDatabase
        var delCount = 0
        when (matchType) {
            in TABLE_SYSTEM_FUNCTION..TABLE_OTHER_FUNCTION -> {
                delCount = db.delete(matcherMap.get(matchType), selection, selectionArgs)
            }
            else -> {
                val id = ContentUris.parseId(uri)
                var where = "_id=" + id
                if (selection != null) {
                    where = " and " + selection
                }
                delCount = db.delete(matcherMap.get(matchType), where, selectionArgs)
            }
        }
        context.contentResolver.notifyChange(uri, null)
        return delCount
    }

    override fun getType(uri: Uri): String? {
        return null
    }
}