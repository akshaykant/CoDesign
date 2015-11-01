package com.example.akant.grabhousesecure;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class KeyLandingActivity extends AppCompatActivity {
    ImageView logout_button;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_landing);
        mContext = this;

        LinearLayout key1 = (LinearLayout) findViewById(R.id.key1);

        logout_button = (ImageView) findViewById(R.id.logout_icn);

        key1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

     /*NFC Validation Check*/

                NfcManager manager = (NfcManager) mContext.getSystemService(Context.NFC_SERVICE);
                NfcAdapter adapter = manager.getDefaultAdapter();
                if (adapter != null && adapter.isEnabled()) {

                    Toast.makeText(KeyLandingActivity.this, getString(R.string.access), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    startActivity(intent);

                }
                else
                {
                    new AlertDialog.Builder(mContext)
                            .setTitle(getResources().getString(R.string.NFCEnabled))
                            .setMessage(getResources().getString(R.string.enableNFC))
                            .setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    startActivityForResult(new Intent(android.provider.Settings.ACTION_NFC_SETTINGS), 0);
                                }

                            })
                            .setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(mContext, getString(R.string.NFCEnabled), Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(mContext, BuyerLandingActivity.class);
                                    startActivity(intent);
                                    finish();
                                }

                            })
                            .show();
                }

            }
        });


        /*Setting the functionality for Logout Button*/
        logout_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(KeyLandingActivity.this, getString(R.string.logout), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(KeyLandingActivity.this, LoginActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_key_landing, menu);
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

        Intent intent = new Intent(KeyLandingActivity.this, BuyerLandingActivity.class);
        finish();
        startActivity(intent);
    }
}
