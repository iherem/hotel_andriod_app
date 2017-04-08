package com.example.aofguk.hotel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by AOfGUK on 8/4/2560.
 */

public class LoginActivity2 extends AppCompatActivity  {
    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity2);
        username = (EditText)findViewById(R.id.editText6);
        password = (EditText)findViewById(R.id.editText7);
        Button mEmailSignInButton = (Button) findViewById(R.id.login_button);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Your Email: "+username.getText().toString());
                System.out.println("Your password: "+password.getText().toString());
                new CheckLogin().execute(username.getText().toString(), password.getText().toString());
            }
        });
    }

    public class CheckLogin extends AsyncTask<String,String,String> {
        String z = "";
        int status = 0;
        Boolean isSuccess = false;
        Connection con = null;
        @Override
        protected void onPostExecute(String r)
        {
            if(isSuccess)
            {
                Toast.makeText(LoginActivity2.this , z , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity2.this, MainActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(LoginActivity2.this , z , Toast.LENGTH_LONG).show();
            }
            if(status == 1){
                username.setError("Require Email");
                password.setError("Require Password");
            }else if(status == 2){
                username.setText("");
                password.setText("");
            }
            username.requestFocus();
        }
        @Override
        protected String doInBackground(String... params){
            String usernam = params[0];
            String passwordd = params[1];
            if(usernam.trim().equals("")|| passwordd.trim().equals("")){
                z = "Please enter Email and Password";
                status = 1;
            }
            else {
                try {
                    con = ConnectionBuilder.getConntection();
                    if (con == null) {
                        z = "Check Your Internet Access!";
                    }
                    else {
                        String sql = "select * from users where username = ? and password = ?";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1, usernam);
                        ps.setString(2, passwordd);
                        ResultSet rs = ps.executeQuery();
                        if(rs.next()) {
                            z = "Login successful";
                            isSuccess=true;
                            con.close();
                        }
                        else {
                            z = "Invalid Credentials!";
                            status = 2;
                            isSuccess = false;
                        }
                    }
                }
                catch (Exception ex) {
                    isSuccess = false;
                    z = ex.getMessage();
                }
            }
            return z;
        }
    }

}
