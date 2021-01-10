package itpdm.project.yourpersonality1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Dashboard1 extends AppCompatActivity {
    TextView persoanlityTest, savedResults, mbti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard1);

        persoanlityTest = findViewById(R.id.tvPersonalityTest);
        savedResults = findViewById(R.id.savedResults);
        mbti = findViewById(R.id.mbti);
        mbti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Dashboard1.this,MBTIActivity.class);
                startActivity(intent1);
            }
        });
        persoanlityTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard1.this,TakeATestActivity.class);
                startActivity(intent);
            }
        });
        savedResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Dashboard1.this,viewResultsActivity.class);
                startActivity(i1);
            }
        });
    }
}