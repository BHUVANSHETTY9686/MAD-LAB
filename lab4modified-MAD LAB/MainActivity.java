import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    WallpaperManager wallpaperManager;
    Button b;
    Handler handler = new Handler();
    Integer loopv = new Integer(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

        b = (Button)findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.postDelayed(runnable , 3000);
            }
        });
    }

    private Runnable runnable = new Runnable() {
        @SuppressLint("ResourceType")
        @Override
        public void run() {
            if(loopv==1)
            {
                try {
                    wallpaperManager.setResource(R.drawable.one);
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                loopv = 2;
            }
            else if(loopv==2)
            {
                try {
                    wallpaperManager.setResource(R.drawable.two);
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                loopv = 3;
            }
            else if(loopv==3)
            {
                try {
                    wallpaperManager.setResource(R.drawable.intro);
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                loopv = 1;
            }
            handler.postDelayed(runnable , 3000);
        }
    };
}
