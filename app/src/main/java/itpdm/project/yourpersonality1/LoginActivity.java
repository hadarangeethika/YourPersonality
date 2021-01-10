package itpdm.project.yourpersonality1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import itpdm.project.yourpersonality1.data.DbHelper;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btnLogin;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        btnLogin = findViewById(R.id.login);
        db = new DbHelper(this);
    }

    public void tappedLogin(View view) {
        String user = username.getText().toString();
        String pass = password.getText().toString();

        if (user.equals("")||pass.equals(""))
            Toast.makeText(LoginActivity.this,"Please enter all the fields!",Toast.LENGTH_SHORT).show();
        else {
            Boolean checkUserPass = db.checkUsernamePassword(user,pass);
            if (checkUserPass==true){
                Toast.makeText(LoginActivity.this,"Login Successful!",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),Dashboard1.class);
                startActivity(i);
            }else {
                Toast.makeText(LoginActivity.this,"Invalid credentials!",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void tappedToRegister(View view) {
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}