package itpdm.project.yourpersonality1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpeningActivity extends AppCompatActivity {
    Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        click = findViewById(R.id.button);
    }

    public void tappedClick(View view) {
        Intent i = new Intent(OpeningActivity.this,first1Activity.class);
        startActivity(i);
    }
}