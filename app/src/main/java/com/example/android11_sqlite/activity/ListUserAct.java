package com.example.android11_sqlite.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android11_sqlite.R;
import com.example.android11_sqlite.database.DBHelper;

public class ListUserAct extends AppCompatActivity {

    private DBHelper db;
    private Cursor c;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        db = new DBHelper(this);
        ListView lvUser = (ListView) findViewById(R.id.lvUser);

        c = db.getAllUser();
        adapter = new SimpleCursorAdapter(this, R.layout.item_user, c, new String[]{
                DBHelper.EXPENSE_NAME, DBHelper.EXPENSE_DES, DBHelper.EXPENSE_CONTENT, DBHelper.EXPENSE_TOTAL, DBHelper.EXPENSE_DATE}, new int[]{
                R.id.tvName, R.id.tvDes, R.id.tvContent, R.id.tvTotal, R.id.tvDate}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );
        lvUser.setAdapter(adapter);

//        lvUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Cursor cursor = (Cursor) adapter.getItem(position);
//                String name = cursor.getString(cursor.getColumnIndex(DBHelper.EXPENSE_NAME));
//                String des = cursor.getString(cursor.getColumnIndex(DBHelper.EXPENSE_DES));
//                String content = cursor.getString(cursor.getColumnIndex(DBHelper.EXPENSE_CONTENT));
//                String total = cursor.getString(cursor.getColumnIndex(DBHelper.EXPENSE_TOTAL));
//                String date = cursor.getString(cursor.getColumnIndex(DBHelper.EXPENSE_DATE));
//
//                Intent intent = new Intent(ListUserAct.this, UpdateAct.class);
//                intent.putExtra(DBHelper.EXPENSE_NAME, name);
//                intent.putExtra(DBHelper.EXPENSE_DES, des);
//                intent.putExtra(DBHelper.EXPENSE_CONTENT, content);
//                intent.putExtra(DBHelper.EXPENSE_TOTAL, total);
//                intent.putExtra(DBHelper.EXPENSE_DATE, date);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        c = db.getAllUser();
        adapter.changeCursor(c);
        adapter.notifyDataSetInvalidated();
        db.close();
    }
}