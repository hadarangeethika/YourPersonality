package itpdm.project.yourpersonality1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN=3000;

    //Variables
    Animation topAnim, bottomAnim;
    ImageView imageTop,imageBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Animation
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);


        imageTop=findViewById(R.id.topImage);
        imageBottom=findViewById(R.id.bottomImage);

        imageTop.setAnimation(topAnim);
        imageBottom.setAnimation(bottomAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,first1Activity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}