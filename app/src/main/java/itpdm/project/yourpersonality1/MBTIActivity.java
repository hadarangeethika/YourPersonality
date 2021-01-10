package itpdm.project.yourpersonality1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MBTIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_b_t_i);
    }

    public void tappedBackToDash1(View view) {
        Intent intent = new Intent(MBTIActivity.this,Dashboard1.class);
        startActivity(intent);
    }
}