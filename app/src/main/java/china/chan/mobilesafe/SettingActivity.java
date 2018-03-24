package china.chan.mobilesafe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by 64913 on 2018/3/19.
 */
public class SettingActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting );

        initUpdate();

    }

    private void initUpdate() {
        final SettingItemView siv_update = (SettingItemView)findViewById(R.id.siv_update);
        boolean open_update = SpUtils.getBoolean(this, ConstantValue.OPEN_UPDATE, false);
        siv_update.setCheck(open_update);

        siv_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isChecked = siv_update.isChecked();
                siv_update.setCheck(!isChecked);

                SpUtils.putBoolean(getApplicationContext(), ConstantValue.OPEN_UPDATE, !isChecked);
            }
        });



    }
}
