package com.example.justdidit.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    //creation de columns et element de la db
   static final String Table_Taches = "taches";
   static final String COLUMN_ID = "_id";
   static  final String COLUMN_Titre  = "Titre";
   static  final String COLUMN_Description  = "Description";
   static  final String COLUMN_DateDebut  = "DateDebut";
   static  final String COLUMN_DateFin  = "DateDebut";
   static  final String COLUMN_Retard  = "Retard";
   static  final String COLUMN_NbJourRetard  = "NbJourRetard";

    //params

    private static final String DATABASE_NAME = "taches.db";
    private static final int DATABASE_VERSION = 1;

    // creation des commande initiaux sql
    private static final String DATABASE_DROP_TABLE_IF_EXIT = "drop table if exists "
            + Table_Taches ;
    private static final String DATABASE_CREATE = "create table "
            + Table_Taches
            + "(" + COLUMN_ID + " integer primary key autoincrement,"
            + COLUMN_Titre + " text not null, "
            + COLUMN_Description + " text, "
            + COLUMN_DateDebut + " text, "
            + COLUMN_DateFin + " text, "
            + COLUMN_Retard + " integer, "
            + COLUMN_NbJourRetard + " integer"
            + ");";

    MySQLiteHelper(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION );
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(), "updating db version from : " + oldVersion
                + " to "+ newVersion + " it will destroy all old data"  );
        db.execSQL(DATABASE_DROP_TABLE_IF_EXIT);
        onCreate(db);
    }
}
