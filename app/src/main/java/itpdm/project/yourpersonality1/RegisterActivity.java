package itpdm.project.yourpersonality1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import itpdm.project.yourpersonality1.data.DbHelper;

public class RegisterActivity extends AppCompatActivity {
    EditText etUsername, etPassword, etRePassword;
    Button btnRegister;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.username1);
        etPassword = findViewById(R.id.password1);
        etRePassword = findViewById(R.id.rePassword);
        btnRegister = findViewById(R.id.register);
        db = new DbHelper(this);

    }

    public void tappedLoginText(View view) {
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }

    public void tappedRegister(View view) {
        String user = etUsername.getText().toString();
        String pass = etPassword.getText().toString();
        String rePass = etRePassword.getText().toString();

        if (user.equals("")||pass.equals("")||rePass.equals(""))
            Toast.makeText(RegisterActivity.this,"Please enter all the fields!",Toast.LENGTH_SHORT).show();
        else {
            if (pass.equals(rePass)){
                Boolean checkUser = db.checkUsername(user);
                if (checkUser==false){
                    Boolean insert = db.insertUser(user,pass);
                    if (insert==true){
                        Toast.makeText(RegisterActivity.this,"Registered Successfully!",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(),Dashboard1.class);
                        startActivity(i);
                    }else {
                        Toast.makeText(RegisterActivity.this,"Registration failed!",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegisterActivity.this,"User already exists! Please sign in!",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(RegisterActivity.this,"Passwords do not match!",Toast.LENGTH_SHORT).show();
            }
        }
    }
}