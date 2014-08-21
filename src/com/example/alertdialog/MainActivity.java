package com.example.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Button simpleButton;
    private Button simplelistButton;
    private Button singlechoiceButton;
    private Button multichoiceButton;
    private TextView show;
    private static final String[] items = new String[] {
        "A", "B", "C"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        show = (TextView)findViewById(R.id.tv_show);
        simpleButton = (Button)findViewById(R.id.btn_simple);
        simpleButton.setOnClickListener(new simpleButtonListener());
        
        simplelistButton = (Button)findViewById(R.id.btn_simplelist);
        simplelistButton.setOnClickListener(new simplelistButtonListener());

        singlechoiceButton = (Button)findViewById(R.id.btn_singlechoice);
        singlechoiceButton.setOnClickListener(new singlechoiceButtonListener());

        multichoiceButton = (Button)findViewById(R.id.btn_multichoice);
        multichoiceButton.setOnClickListener(new multichoiceButtonListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void simple(View view) {
    }
    
    class simpleButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
            .setTitle("Simple AlertDialog")
            .setIcon(R.drawable.ic_launcher)
            .setMessage("Test Message");
            
            setPositiveButton(builder);
            setNegativeButton(builder)
            .create()
            .show();
        }
    }
    
    class simplelistButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
            .setTitle("Simple List AlertDialog")
            .setIcon(R.drawable.ic_launcher)
            .setItems(items, new OnClickListener() {
                
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    show.setText("You selected " + items[which]);
                }
            });
            
            setPositiveButton(builder);
            setNegativeButton(builder)
            .create()
            .show();
        }
    }
    
    class singlechoiceButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
            .setTitle("Single Choice AlertDialog")
            .setIcon(R.drawable.ic_launcher)
            .setSingleChoiceItems(items, 1, new OnClickListener() {
                
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    show.setText("You selected " + items[which]);
                }
            });

            setPositiveButton(builder);
            setNegativeButton(builder)
            .create()
            .show();
        }
    }
    
    class multichoiceButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
            .setTitle("Multiple Choice AlertDialog")
            .setIcon(R.drawable.ic_launcher)
            .setMultiChoiceItems(items, new boolean[] { false, true, false, true}, null);

            setPositiveButton(builder);
            setNegativeButton(builder)
            .create()
            .show();
            
        }
    }
    
    private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder) {
        return builder.setPositiveButton("Yes", new OnClickListener() {
            
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("You clicked 'Yes' button ");
            }
        });
    }
    
    private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder) {
        return builder.setNegativeButton("No", new OnClickListener() {
            
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("You clicked 'No' button ");
            }
        });
    }
    
}
