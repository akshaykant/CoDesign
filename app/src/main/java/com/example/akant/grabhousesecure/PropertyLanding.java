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

public class PropertyLanding extends AppCompatActivity {
    ImageView logout_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_landing);

        LinearLayout property1 = (LinearLayout) findViewById(R.id.property1);
        LinearLayout property2 = (LinearLayout) findViewById(R.id.property2);

        logout_button = (ImageView) findViewById(R.id.logout_icn);

        property1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PropertyLanding.this, getString(R.string.access), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PropertyLanding.this, BuyerLandingActivity.class);
                finish();
                startActivity(intent);
            }
        });

        property2.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                Toast.makeText(PropertyLanding.this, getString(R.string.access), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PropertyLanding.this, BuyerLandingActivity.class);
                finish();
                startActivity(intent);

            }
        });

        /*Setting the functionality for Logout Button*/
        logout_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(PropertyLanding.this, getString(R.string.logout), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PropertyLanding.this, LoginActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_property_landing, menu);
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
        Intent intent = new Intent(PropertyLanding.this, BuyerLandingActivity.class);
        finish();
        startActivity(intent);
    }
}
