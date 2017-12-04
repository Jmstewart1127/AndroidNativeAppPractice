package com.example.jake.nativeapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jake.nativeapp.service.Calculator;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText editText = findViewById(R.id.editText);

        final TextView textView = findViewById(R.id.textView);

        final TextView firstNumber = findViewById(R.id.firstNumber);

        final TextView secondNumber = findViewById(R.id.secondNumber);

        final TextView operator = findViewById(R.id.operator);

        final Calculator c = new Calculator();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), editText.getText(), LENGTH_SHORT).show();
                secondNumber.setText(editText.getText());
                c.setFirst(firstNumber.getText());
                c.setSecond(secondNumber.getText());
                if (c.getAdd()) {
                    textView.setText(c.add());
                    c.setAdd(false);
                } else {
                    textView.setText(c.subtract());
                    c.setSubtract(false);
                }
            }
        });

        Button subtract = findViewById(R.id.subtract);
        subtract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), editText.getText(), LENGTH_SHORT).show();
                firstNumber.setText(editText.getText());
                c.setSubtract(true);
                operator.setText("-");
                editText.setText("");
            }
        });

        Button add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), editText.getText(), LENGTH_SHORT).show();
                firstNumber.setText(editText.getText());
                c.setAdd(true);
                operator.setText("+");
                editText.setText("");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
