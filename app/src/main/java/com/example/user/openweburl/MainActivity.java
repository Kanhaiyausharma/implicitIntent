package com.example.user.openweburl;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button hitme;
    Button getmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hitme = (Button) findViewById(R.id.hitme);
        getmap = (Button) findViewById(R.id.getMap);

        hitme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="http://www.udacity.com";
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
                startActivity(intent);
            }
        });

        getmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address="Birla college kalyan";
                Uri.Builder builder = new Uri.Builder();
                builder.scheme("geo").path("0,0").query(address);

                Uri addressurl= builder.build();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(addressurl);

                if (intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }

            }
        });
    }





}
