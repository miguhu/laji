package com.example.lzz;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.fragment.app.FragmentActivity;

public class  DBOpenHelper2 extends SQLiteOpenHelper {
    //定义创建数据表dict的SQL语句
    final String CREATE_TABLE_SQL =
            "create table dict(_id integer primary key autoincrement , word , detail)";

    public DBOpenHelper2(FragmentActivity context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version); //重写构造方法并设置工厂为null
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL); //创建垃圾信息表
    }
    @Override
    // 重写基类的onUpgrade()方法，以便数据库版本更新
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //提示版本更新并输出旧版本信息与新版本信息
        System.out.println("---版本更新-----" + oldVersion + "--->" + newVersion);
    }
}

