package com.example.justdidit.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DAOSqlite {


    private SQLiteDatabase database;
    private final MySQLiteHelper dbHelper;
    private final String[] AllCollumns = {MySQLiteHelper.COLUMN_ID};

    DAOSqlite(Context context ) {dbHelper = new MySQLiteHelper(context);}

    // ouvrir la database:
    void open() throws SQLException {
        database = dbHelper.getWritetableDatabase();
    }
    // fermer la db

    void close() {dbHelper.close();}

}
