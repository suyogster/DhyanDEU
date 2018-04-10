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


import java.util.ArrayList;


public class TaskList extends AppCompatActivity {


    ArrayList<String> itemList;
    ArrayAdapter<String> adapter;
    EditText itemText;
    Button addButton;
    Button deleteButton;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);


        listView = findViewById(R.id.TaskListView);
        itemText = (EditText)findViewById(R.id.editasklist);
        addButton = findViewById(R.id.addtaskbutton);

        itemList = new ArrayList<>();

        adapter = new ArrayAdapter<String>(TaskList.this,android.R.layout.simple_list_item_1,itemList);



            View.OnClickListener addListener = new View.OnClickListener() {


                @Override
                public void onClick(View v) {

                    itemList.add(itemText.getText().toString());

                    itemText.setText("");
                    adapter.notifyDataSetChanged();
                }
            };

            addButton.setOnClickListener(addListener);
            listView.setAdapter(adapter);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(TaskList.this, Timer.class);
                    startActivity(intent);
                }
            });

            listView.setAdapter(adapter);

            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    itemList.remove(position);
                    adapter.notifyDataSetChanged();
                    return true;
                }
            });

    }


}
