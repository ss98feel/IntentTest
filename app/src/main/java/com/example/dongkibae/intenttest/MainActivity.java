package com.example.dongkibae.intenttest;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private Button btn ;
    private Button btn1;
    private Button btn2;
    private LinearLayout side;
    private RelativeLayout mask;
    private Animation Showleft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        btn1 = (Button) findViewById(R.id.button_message);
        btn2 = (Button) findViewById(R.id.button_address);
        side = (LinearLayout) findViewById(R.id.sideLayout);
        mask = (RelativeLayout) findViewById(R.id.maskLayout);
        Showleft = AnimationUtils.loadAnimation(this, R.anim.left_in);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                side.setVisibility(View.VISIBLE);
                side.startAnimation(Showleft);
                mask.setVisibility(View.VISIBLE);


            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra("sms_body", "data");
                intent.setType("text/plain");
                startActivity(intent.createChooser(intent, "공유"));


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Address_Intent = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
                startActivity(Address_Intent);// 주소록 이동


            }
        });
    }
}
