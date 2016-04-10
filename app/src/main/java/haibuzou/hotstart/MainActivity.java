package haibuzou.hotstart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_Lanoucher);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
