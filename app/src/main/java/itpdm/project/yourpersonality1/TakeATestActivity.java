package itpdm.project.yourpersonality1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class TakeATestActivity extends AppCompatActivity {
    TextView subtitleGet1;
    Button btntaketest;
    Animation btt, bttdua, bttlga, imgalpha;
    ImageView imgget1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_a_test);

        btt = AnimationUtils.loadAnimation(this,R.anim.btt);
        bttdua = AnimationUtils.loadAnimation(this,R.anim.bttdua);
        bttlga = AnimationUtils.loadAnimation(this,R.anim.bttlga);
        imgalpha = AnimationUtils.loadAnimation(this,R.anim.imgalpha);


        btntaketest = (Button) findViewById(R.id.btntaketest);
        subtitleGet1 = (TextView) findViewById(R.id.subtitleGet1);
        imgget1 = (ImageView) findViewById(R.id.imgget1);


        btntaketest.startAnimation(bttdua);
        subtitleGet1.startAnimation(bttlga);
        imgget1.startAnimation(imgalpha);

    }

    public void tappedTakeATest(View view) {
        Intent intent = new Intent(TakeATestActivity.this,MainActivity.class);
        startActivity(intent);
    }
}