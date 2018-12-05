package com.example.pipid.urmoney;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String ROBOT_COST = "robot_cost";
    public static final String COST_MONEY = "cost_money";
    public static final String COST_DATE = "cost_date";
    public static final String COST_TITLE = "cost_title";

    public DatabaseHelper(Context context) {
        super(context, ROBOT_COST, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists "+ROBOT_COST+"(" +
                "id integer primary key, " +
                "cost_title varchar, " +
                "cost_date varchar, " +
                COST_MONEY + " varchar)");
    }
    public void insertCost(CostBean costBean){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COST_TITLE,costBean.costTitle);
        cv.put(COST_DATE,costBean.costDate);
        cv.put(COST_MONEY,costBean.costMoney);
        database.insert(ROBOT_COST,null, cv);
    }

    public Cursor getAllCostDate(){
        SQLiteDatabase database = getWritableDatabase();
        return database.query(ROBOT_COST,null,null,null,null,null,"" + COST_DATE+" ASC");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
