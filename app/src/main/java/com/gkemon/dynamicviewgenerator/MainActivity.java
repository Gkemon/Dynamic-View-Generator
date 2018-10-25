package com.gkemon.dynamicviewgenerator;

import android.content.Context;
import android.icu.util.LocaleData;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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



                LinearLayout mainlinearLayout = findViewById(R.id.main_layout);


                if(totalView<=4) {

                    mainlinearLayout.setOrientation(LinearLayout.HORIZONTAL);

                    for (int i = 0; i < totalView; i++) {


                        View myButton;

                        LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);

                        myButton = inflater.inflate(R.layout.item_view, null);

                        myButton.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Log.d("GK","Click");
                            }
                        });


                        myButton.setLayoutParams(new LinearLayout.LayoutParams(
                                0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

                        myButton.setId(i);



                        mainlinearLayout.addView(myButton);





                    }


                }
                else {
                    int totalLinearLayout=totalView/4;
                    int extraItem=totalView%4;
                    int hight=0,width=0;

                    mainlinearLayout.setOrientation(LinearLayout.VERTICAL);

                    for(int i=0;i<totalLinearLayout;i++){
                        LinearLayout linearLayout1 = new LinearLayout(MainActivity.this);


                        for (int j = 0; j < 4; j++) {


                            View myButton;
                            LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(MainActivity.this.LAYOUT_INFLATER_SERVICE);
                            myButton = inflater.inflate(R.layout.item_view, null);
                            myButton.setLayoutParams(new LinearLayout.LayoutParams(
                                    0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

                            myButton.setId(i*5+j);

                            myButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public
                                void onClick(View v) {
                                    Log.d("GK","ID : "+v.getId());
                                }
                            });

                            linearLayout1.addView(myButton);



                        }

                        mainlinearLayout.addView(linearLayout1);

                    }

                    LinearLayout linearLayout1 = new LinearLayout(MainActivity.this);
                     linearLayout1.setLayoutParams(new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));


                     //adding even item(Extra item)

                    for(int k=0;k<extraItem;k++){

                        View myButton;
                        LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(MainActivity.this.LAYOUT_INFLATER_SERVICE);
                        myButton = inflater.inflate(R.layout.item_view, null);

                        myButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public
                            void onClick(View v) {
                                Log.d("GK","ID : "+v.getId());
                            }
                        });

                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        params.weight = 1.0f;
                        params.gravity = Gravity.CENTER;

                        myButton.setLayoutParams(params);

                        myButton.setId(totalLinearLayout*4+k);

                        linearLayout1.addView(myButton);


                    }

                    mainlinearLayout.addView(linearLayout1);

                }


                if(totalView==0){

                    mainlinearLayout.removeAllViews();
                }

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
