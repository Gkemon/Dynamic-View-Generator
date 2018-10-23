package com.gkemon.dynamicviewgenerator;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public
class MainActivity extends AppCompatActivity {

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText=(EditText)findViewById(R.id.edit_text);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Integer totalView;

                if(!s.toString().equals(""))totalView=Integer.valueOf(s.toString());
                else totalView=0;

                LinearLayout linearLayout = findViewById(R.id.main_layout);
                for(int i=0;i<totalView;i++){


                    View myButton = new ConstraintLayout(MainActivity.this);

                    LayoutInflater inflater = (LayoutInflater)   MainActivity.this.getSystemService(MainActivity.this.LAYOUT_INFLATER_SERVICE);
                    myButton = inflater.inflate(R.layout.item_view, null);

                    myButton.setLayoutParams(new LinearLayout.LayoutParams(
                            0,LinearLayout.LayoutParams.WRAP_CONTENT,1));
                    linearLayout.addView(myButton);
                    myButton.setId(i);

                }

                if(totalView==0)linearLayout.removeAllViews();

                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {




                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {

                // TODO Auto-generated method stub
            }
        });


    }
}
