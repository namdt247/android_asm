package com.example.android11_sqlite.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android11_sqlite.R;
import com.example.android11_sqlite.database.DBHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    private EditText edName;
//    private EditText edDes;
//    private Button btRegister;
//    private Spinner spinner;
//    private DBHelper db;
//    private CheckBox checkBox;

    private EditText edName;
    private EditText edDes;
    private EditText edContent;
    private EditText edTotal;
    private EditText edDate;
    private Button btAdd;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        db = new DBHelper(this);
        db.getReadableDatabase();
    }

    private void initView() {
//        edName = (EditText) findViewById(R.id.edUser);
//        edDes = (EditText) findViewById(R.id.edDes);
//        btRegister = (Button) findViewById(R.id.btRegister);
//        checkBox = (CheckBox) findViewById(R.id.ck);
//        btRegister.setOnClickListener(this);

        edName = findViewById(R.id.edName);
        edDes = findViewById(R.id.edDes);
        edContent = findViewById(R.id.edContent);
        edTotal = findViewById(R.id.edTotal);
        edDate = findViewById(R.id.edDate);
        btAdd = findViewById(R.id.btAdd);

        btAdd.setOnClickListener(this);

//        String[] genders = {"Male", "Female", "Unknown"};
//        spinner = (Spinner) findViewById(R.id.spinner);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genders);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        if (v == btAdd) {
            onRegister();
        }
    }

    private void onRegister() {
//        if (edName.getText().toString().isEmpty()) {
//            Toast.makeText(this, "Please enter username", Toast.LENGTH_LONG).show();
//            return;
//        }
//
//        if (!checkBox.isChecked()) {
//            Toast.makeText(this, "Please agree rules", Toast.LENGTH_LONG).show();
//            return;
//        }
//
//        String isAdd = db.addUser(edName.getText().toString(), spinner.getSelectedItem().toString(),
//                edDes.getText().toString());
//        Toast.makeText(this, isAdd, Toast.LENGTH_LONG).show();
//
//        Intent intent = new Intent(MainActivity.this, ListUserAct.class);
//        startActivity(intent);

        if (edName.getText().toString().isEmpty()) {
            Toast.makeText(this, "Nhập tên chi tiêu", Toast.LENGTH_LONG).show();
            return;
        }

        if (edTotal.getText().toString().isEmpty()) {
            Toast.makeText(this, "Nhập số tiền", Toast.LENGTH_LONG).show();
            return;
        }

        if (edDate.getText().toString().isEmpty()) {
            Toast.makeText(this, "Nhập thời gian", Toast.LENGTH_LONG).show();
            return;
        }

        boolean isAdd = db.addExpense(edName.getText().toString(), edDes.getText().toString(),
                edContent.getText().toString(), edTotal.getText().toString(), edDate.getText().toString(), 1);

        if (isAdd == true) {
            Toast.makeText(this, "Thành công", Toast.LENGTH_LONG).show();
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.main_content, fragmentList, FragmentList.class.getName())
//                    .commit();
            Intent intent = new Intent(MainActivity.this, ListUserAct.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Thất bại", Toast.LENGTH_LONG).show();
        }
    }
}