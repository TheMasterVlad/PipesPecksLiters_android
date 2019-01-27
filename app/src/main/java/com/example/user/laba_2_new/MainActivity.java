package com.example.user.laba_2_new;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // convert pipes
    private float convertPipesToPecks(float val) {
        return (float) (val * 54.18);
    }
    private float convertPipesToLiters(float val) {
        return (float) (val * 477.33);
    }

        // convert pecks
    private float convertPecksToPipes(float val) {
            return (float) (val / 54.18);
        }
    private float convertPecksToLiters(float val) {
        return (float) (val * 8.81);
    }

    // convert liters
    private float convertLitersToPipes(float val) {
        return (float) (val / 477.33);
    }
    private float convertLitersToPecks(float val) {
        return (float) (val / 8.81);
    }

    public void onClick(View view) {

        RadioButton pipesRB = (RadioButton) findViewById(R.id.rb_pipes);
        RadioButton pecksRB = (RadioButton) findViewById(R.id.rb_pecks);
        EditText inputEditText = (EditText) findViewById(R.id.txt_val);
        TextView TextOr = (TextView) findViewById(R.id.txt_or);
        Button btnConv = (Button) findViewById(R.id.btn_convert);
        btnConv.setEnabled(false);

        if (inputEditText.getText().length() == 0 ) {
            Toast.makeText(getApplicationContext(), "Enter Value!",
                    Toast.LENGTH_LONG).show();
            return;
        }

        float inputValue = Float.parseFloat(inputEditText.getText().toString());


        String pipesCheck1 = (inputValue + " = " + String
                .valueOf(convertPipesToPecks(inputValue)) + " Pecks ");
        String pipesCheck2 = ("OR " + String.valueOf(convertPipesToLiters(inputValue)) + " Liters ");
        String pecksCheck1 = (inputValue + " = " + String
                .valueOf(convertPecksToPipes(inputValue)) + " Pipes") ;
        String pecksCheck2 = (" OR " + String.valueOf(convertPecksToLiters(inputValue)) + " Liters ");
        String litersCheck1 = (inputValue + " = " + String
                .valueOf(convertLitersToPipes(inputValue)) + " Pipes") ;
        String litersCheck2 = (" OR " + String.valueOf(convertLitersToPecks(inputValue)) + " Pecks ");
        if (pipesRB.isChecked()) {
           inputEditText.setText(pipesCheck1);
            TextOr.setText(pipesCheck2);

        } else if (pecksRB.isChecked())
        {
           inputEditText.setText(pecksCheck1);
            TextOr.setText(pecksCheck2);
        }
        else {
            inputEditText.setText(litersCheck1);
            TextOr.setText(litersCheck2);
        }
    }


    public void onClick_clear(View view){
          EditText inputEditText = (EditText) findViewById(R.id.txt_val);
        TextView TextOr = (TextView) findViewById(R.id.txt_or);
        Button btnConv = (Button) findViewById(R.id.btn_convert);
        btnConv.setEnabled(true);
        inputEditText.setText("");
        TextOr.setText("");

    }
}
