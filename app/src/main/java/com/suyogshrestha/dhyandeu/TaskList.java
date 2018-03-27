package com.suyogshrestha.dhyandeu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskList extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView tasklist;
    String[] tasks = {"Java","Python","AI"};
    ArrayList<String> listoftasks = new ArrayList<String>(Arrays.asList(tasks));
    EditText editText = findViewById(R.id.addTaskinput);
    Button button = findViewById(R.id.addtaskbutton);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        tasklist = findViewById(R.id.ListTaskID);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listoftasks);
        tasklist.setAdapter(arrayAdapter);
        tasklist.setOnItemClickListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTask = editText.getText().toString();
                listoftasks.add(newTask);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView textView = (TextView) view;
        Toast.makeText(this,"you clicked on "+ textView.getText() + i, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,Timer.class);
        startActivity(intent);
    }
}
