package com.example.smartvanproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RequestAcceptAction extends AppCompatActivity {
   // TextView text1,text2,text3;
    String j,k,l;
    //Button noaccept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_accept_action);
       // text1=findViewById(R.id.text60);
       // text2=findViewById(R.id.text61);
        //text3=findViewById(R.id.text62);
   //     text.setText(getIntent().getStringExtra("requestId"));
//        noaccept=findViewById(R.id.Noaccept);
//        //yesaccept=findViewById(R.id.Yesaccept);
//        noaccept.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(RequestAcceptAction.this, VanOwnerDashboard.class);
//                startActivity(i);
//            }
//        });

        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null){
            j=(String)b.get("requestId");
            k=(String)b.get("vanId");
            l=(String)b.get("childId");
            //text1.setText(j);
            //text2.setText(k);
            //text3.setText(l);
        }

    }


    public void onAccept(View view) {
        RequestAcceptActionBackend bg=new RequestAcceptActionBackend(this);
        bg.execute(j,l,k);
    }
}