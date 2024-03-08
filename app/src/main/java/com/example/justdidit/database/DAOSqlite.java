package com.example.justdidit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.justdidit.Tache;

public class DAOSqlite {


    private SQLiteDatabase database;
    private final MySQLiteHelper dbHelper;
    private final String[] AllCollumns = {MySQLiteHelper.COLUMN_ID};

    public DAOSqlite(Context context ) {dbHelper = new MySQLiteHelper(context);}

    // ouvrir la database:
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }
    // fermer la db

    public void close() {dbHelper.close();}

    public long insertTache(Tache tache) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_Titre, tache.getTitle());
        values.put(MySQLiteHelper.COLUMN_Description, tache.getDescription());
        values.put(MySQLiteHelper.COLUMN_DateDebut, tache.getDateDeDebut().toString() );
        values.put(MySQLiteHelper.COLUMN_DateFin, tache.getDateFin().toString());
        values.put(MySQLiteHelper.COLUMN_Retard, tache.getRetard());
        values.put(MySQLiteHelper.COLUMN_NbJourRetard, tache.getNbJourRetard());

        // Inserting Row
        long insertId = database.insert(MySQLiteHelper.Table_Taches, null, values);
        return insertId;
    }
}
