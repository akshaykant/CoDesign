package com.example.akant.grabhousesecure;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    TextView reset;
    TextView systemInfo;
    EditText userID;
    EditText password;
    Context mContext;
    private String userId;
    private String psswd;
    private char[] userIdChars;
    private char[] psswdChars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*to stop default animation*/
        getWindow().setWindowAnimations(0);

        setContentView(R.layout.activity_login);
        mContext = this;
        userID = (EditText) findViewById(R.id.user_id);
        password = (EditText) findViewById(R.id.password);


        password.setFilters(new InputFilter[] {new InputFilter.LengthFilter(21)});





        /*Getting the reference of the login button and providing interaction to it */
        loginButton = (Button) findViewById(R.id.rst_submit_btn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (isNonEmpty()) {

                        if(userID.getText().toString().equalsIgnoreCase("ayush") && password.getText().toString().equalsIgnoreCase("aaaa")){

                            Intent intent = new Intent(mContext, SellerLandingActivity.class);
                            finish();
                            startActivity(intent);
                        }
                        else   if (userID.getText().toString().equalsIgnoreCase("akshay") && password.getText().toString().equalsIgnoreCase("aaaa")){
                            Intent intent = new Intent(mContext, BuyerLandingActivity.class);
                            finish();
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(mContext, getString(R.string.Invalid), Toast.LENGTH_LONG).show();
                        }

                    }
                userID.getText().clear();
                password.getText().clear();
            }


        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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


    /*This method checks if the user entered the valid credentials or not.*/
    private boolean isNonEmpty() {
        /*get a reference to the EditText so that we can read in the value typed by the user*/
        EditText userID = (EditText) findViewById(R.id.user_id);
        EditText password = (EditText) findViewById(R.id.password);
        boolean isempty = true;

        /*Validating the User ID to be non-empty*/
        if (userID.getText().toString().length() == 0) {
            userID.setError(getString(R.string.userId));

            /*Setting the color of the EditText line as Red*/
            Drawable d = userID.getBackground();
            d.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);

            //setTheme(R.style.EditTextBottomLineError);

            isempty = false;

        }
        /*Validating the Password to be non-empty*/
        if (password.getText().toString().length() == 0) {
            password.setError(getString(R.string.pwdEmpty));

            /*Setting the color of the EditText line as Red*/
            Drawable d = password.getBackground();
            d.setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);

            isempty = false;
        }
        return isempty;

    }




    @Override
    public void onBackPressed() {
        Intent intent = new Intent(mContext, SplashActivity.class);
        finish();
        startActivity(intent);
    }

}
