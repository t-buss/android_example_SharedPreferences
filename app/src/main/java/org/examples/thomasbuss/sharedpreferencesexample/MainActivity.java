package org.examples.thomasbuss.sharedpreferencesexample;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSave(View view) {
        EditText keyEditText = (EditText) findViewById(R.id.keyText);
        EditText valueEditText = (EditText) findViewById(R.id.valueText);

        String keyString = keyEditText.getText().toString();
        String valueString = valueEditText.getText().toString();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();

        edit.putString(keyString, valueString);

        edit.apply();
        // or:
        // edit.commit();
    }

    public void onLoad(View view) {
        TextView keyTextView = (TextView) findViewById(R.id.keyText);
        TextView valueTextView = (TextView) findViewById(R.id.valueText);

        String keyString = keyTextView.getText().toString();
        String valueString = getPreferences(MODE_PRIVATE).getString(keyString, "");
        valueTextView.setText(valueString);
    }
}
