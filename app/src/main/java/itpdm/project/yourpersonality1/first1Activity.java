package itpdm.project.yourpersonality1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class first1Activity extends AppCompatActivity {
    TextView subtitleGet;
    Button btngetstarted;
    Animation btt, bttdua, bttlga, imgalpha;
    ImageView imgget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first1);

        btt = AnimationUtils.loadAnimation(this,R.anim.btt);
        bttdua = AnimationUtils.loadAnimation(this,R.anim.bttdua);
        bttlga = AnimationUtils.loadAnimation(this,R.anim.bttlga);
        imgalpha = AnimationUtils.loadAnimation(this,R.anim.imgalpha);


        subtitleGet = (TextView) findViewById(R.id.subtitleGet);
        btngetstarted = (Button) findViewById(R.id.btngetstarted);
        imgget = (ImageView) findViewById(R.id.imgget);


        subtitleGet.startAnimation(bttdua);
        btngetstarted.startAnimation(bttlga);
        imgget.startAnimation(imgalpha);

    }

    public void tappedGetStarted(View view) {
        Intent intent = new Intent(first1Activity.this,LoginActivity.class);
        startActivity(intent);
    }
}