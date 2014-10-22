package com.example.brett.collections_internet;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import android.app.AlertDialog;
import android.content.DialogInterface;


public class main extends Activity
{

    private Boolean flag = false;
    private Map<String, String> m1 = new HashMap<String,String>();

//    *************MENU STUFF**************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//  ****************END***********MENU STUFF*******************



//  ************CLASS FUNCTIONS*********************
    public void addUserInput(View v)
    {

        EditText keyET = (EditText) findViewById(R.id.editText1);
        EditText valueET = (EditText) findViewById(R.id.editText2);

        if(m1.containsKey(keyET.getText().toString()))
            duplicateKeyAttempt();
        else
        {
            this.m1.put(keyET.getText().toString(), valueET.getText().toString());
            TextView tv = (TextView) findViewById(R.id.textView1);
            tv.setText(printMap());
        }
    }

    public void duplicateKeyAttempt()
    {
        // change text box
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText(getString(R.string.duplicate_key_message));

        // clear user inputs
        EditText et1 = (EditText) findViewById(R.id.editText1);
        et1.setText("");
        EditText et2 = (EditText) findViewById(R.id.editText2);
        et2.setText("");

    }

    public void clearMap(View v)
    {
        // clear the map
        this.m1.clear();
        // change text box
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText(getString(R.string.textView1));
    }


    public String printMap()
        {
        String text ="";
        if(!this.m1.isEmpty())
        {
            Set keys = this.m1.keySet();
            for (Iterator i = keys.iterator(); i.hasNext();)
            {
                String newline = "Key: [";
                String key = (String) i.next();
                newline += key;
                newline +=  "] -> Value: [";
                newline +=  this.m1.get(key);
                newline += "]\n";
                text += newline;
            }


//            Iterator it = this.m1.entrySet().iterator();
//            while (it.hasNext())
//            {
//                Map.Entry pairs = (Map.Entry) it.next();
//                text += (pairs.getKey() + " = " + pairs.getValue() + "\n");
//                it.remove(); // avoids a ConcurrentModificationException
//            }
        }
        else
        {
            text = "the Map is empty";
        }

        return text;
    }




}
