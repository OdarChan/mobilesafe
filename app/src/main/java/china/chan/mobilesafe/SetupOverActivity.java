package china.chan.mobilesafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by 64913 on 2018/3/23.
 */

public class SetupOverActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean setup_over = SpUtils.getBoolean(this, ConstantValue.SETUP_OVER, false);
        if (setup_over){
            setContentView(R.layout.setup_over);
        }else {
            Intent intent = new Intent(this, Setup1OverActivity.class);
            startActivity(intent);

            finish();

        }

    }
}
