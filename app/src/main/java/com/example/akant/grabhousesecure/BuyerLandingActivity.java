package com.example.akant.grabhousesecure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BuyerLandingActivity extends AppCompatActivity {

    ImageView logout_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_landing);


        LinearLayout property = (LinearLayout) findViewById(R.id.property);
        LinearLayout key = (LinearLayout) findViewById(R.id.key);

        logout_button = (ImageView) findViewById(R.id.logout_icn);

        property.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyerLandingActivity.this, PropertyLanding.class);
                finish();
                startActivity(intent);
            }
        });

        key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyerLandingActivity.this, KeyLandingActivity.class);
                finish();
                startActivity(intent);

            }
        });

        /*Setting the functionality for Logout Button*/
        logout_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(BuyerLandingActivity.this, getString(R.string.logout), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(BuyerLandingActivity.this, LoginActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_buyer_landing, menu);
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
    @Override
    public void onBackPressed() {
        Toast.makeText(BuyerLandingActivity.this, getString(R.string.logout), Toast.LENGTH_LONG).show();
        Intent intent = new Intent(BuyerLandingActivity.this, LoginActivity.class);
        finish();
        startActivity(intent);
    }
}
