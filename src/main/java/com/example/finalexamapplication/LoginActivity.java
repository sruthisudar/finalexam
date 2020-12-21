package com.example.finalexamapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText user,password;
    Button login;
    ArrayList<Member> memberList = new ArrayList<Member>();
    public static String memberName="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fillData();
        user=findViewById(R.id.userName);
        password=findViewById(R.id.password);
        login=findViewById(R.id.loginBtn);
        login.setOnClickListener(this);


    }
    public void fillData(){
        memberList.add(new Member(123456,"user1","User","password1"));
        memberList.add(new Member(567890,"Sruthi Sudar","sruthisudar","password20"));
}

    @Override
    public void onClick(View v) {
        String verify = verifyLogin(user.getText().toString(),password.getText().toString());
        if (verify.isEmpty())
            Toast.makeText(getApplicationContext(),"Invalid username or pssword",Toast.LENGTH_LONG).show();
        else
        {
            memberName=verify;
            //navigate to the MainActivity
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);

        }

    }
    public String verifyLogin(String username, String password){
        for(int i=0;i<memberList.size();i++)
            if(username.equals(memberList.get(i).getUserName()))
                if(password.equals(memberList.get(i).getPassword()))
                    return memberList.get(i).getName();
        return "";
    }


}

