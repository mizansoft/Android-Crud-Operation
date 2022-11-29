package com.example.applicationdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText id, name,email;
MyHelper helper;
Student student;
List<Student> list;
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id=findViewById(R.id.stid);
        name= findViewById(R.id.stname);
        email =findViewById(R.id.stemail);
        helper = new MyHelper(getApplicationContext());
        listView = findViewById(R.id.simplelistview);
    }


    // save method call button
    public void  save (View view){
        student = new Student(Integer.parseInt(id.getText().toString()),name.getText().toString(), email.getText().toString());
        helper.doSave(student);
        show(view);
        Toast.makeText(this, "Save" , Toast.LENGTH_LONG).show();

    }

    // update button call
    public void  update (View view){
        student = new Student(Integer.parseInt(id.getText().toString()),name.getText().toString(), email.getText().toString());
        helper.doUpdate(student);
        show(view);
        Toast.makeText(this, "updated" , Toast.LENGTH_LONG).show();

    }

    // delete button call
    public void  delete (View view){
        student = new Student();
        student.setId(Integer.parseInt(id.getText().toString()));
        helper.doDelete(student);
        show(view);
        Toast.makeText(this, "Deleted" , Toast.LENGTH_LONG).show();

    }

    public void  show(View view){
      list =  helper.allStudent();
      //student = list.get(0);
        String s="";
        MyAdapter adapter = new MyAdapter(getApplicationContext(), list);
        listView.setAdapter(adapter);



    }
}