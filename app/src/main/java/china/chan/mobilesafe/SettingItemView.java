package china.chan.mobilesafe;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by 64913 on 2018/3/20.
 */

public class SettingItemView extends RelativeLayout {
    private  TextView tv_des;
    private  CheckBox cb_box;
    private String tag = "SettingItemView";
    private static final String NAMESPACE = "http://schemas.android.com/apk/res-auto/china.chan.mobilesafe.SettingItemView";

    public SettingItemView(Context context) {
        this(context, null);
    }

    public SettingItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SettingItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = View.inflate(context, R.layout.setting_item_view, null);
        this.addView(view);
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        tv_des = (TextView) findViewById(R.id.tv_des);
        cb_box = (CheckBox) findViewById(R.id.cb_box);

        initAttrs(attrs);

    }

    private void initAttrs(AttributeSet attrs) {
        /**
        Log.i(tag, "attrs.getAttributeCount()" + attrs.getAttributeCount());
        for (int i = 0; i < attrs.getAttributeCount(); i++){
            Log.i(tag, "name = " + attrs.getAttributeName(i));
            Log.i(tag, "value = " + attrs.getAttributeValue(i));
            Log.i(tag, "======================================");
        }
        **/

        String destitle = attrs.getAttributeValue(NAMESPACE, "destitle");
        String desoff = attrs.getAttributeValue(NAMESPACE, "desoff");
        String deson = attrs.getAttributeValue(NAMESPACE, "deson");

        Log.i(tag, destitle);
        Log.i(tag, desoff);
        Log.i(tag, deson);

    }

    public boolean isChecked() {

        return cb_box.isChecked();
    }

    public void setCheck(boolean isChecked) {

        cb_box.setChecked(isChecked);

        if (isChecked()) {
            tv_des.setText("自动更新已开启");
        } else {
            tv_des.setText("自动更新已关闭");
        }
    }







}
