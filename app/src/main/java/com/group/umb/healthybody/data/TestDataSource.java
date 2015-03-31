package com.group.umb.healthybody.data;

/**
 * Created by tomashavlas on 31.3.2015.
 */
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.group.umb.healthybody.domain.Test;

public class TestDataSource {

    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_POCET_BRUSAKOV, MySQLiteHelper.COLUMN_POCET_DREPOV, MySQLiteHelper.COLUMN_POCET_KLIKOV };

    public TestDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Test createTest(Integer pocet_brusakov, Integer pocet_drepov, Integer pocet_klikov) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_POCET_BRUSAKOV, pocet_brusakov);
        values.put(MySQLiteHelper.COLUMN_POCET_DREPOV, pocet_drepov);
        values.put(MySQLiteHelper.COLUMN_POCET_KLIKOV, pocet_klikov);
        long insertId = database.insert(MySQLiteHelper.TABLE_TEST, null, values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_TEST, allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Test newComment = cursorToTest(cursor);
        cursor.close();
        return newComment;
    }

    public Test getLatest() {
        Cursor cursor = database.query(MySQLiteHelper.TABLE_TEST, allColumns, null, null, null, null, null);
        if (cursor.isAfterLast())
            return null;
        cursor.moveToLast();
        Test latest = cursorToTest(cursor);
        cursor.close();
        return latest;
    }

    private Test cursorToTest(Cursor cursor) {
        Test test = new Test();
        test.setId(cursor.getLong(0));
        test.setPocetBrusakov(cursor.getInt(1));
        test.setPocetDrepov(cursor.getInt(2));
        test.setPocetKlikov(cursor.getInt(3));
        return test;
    }
}

