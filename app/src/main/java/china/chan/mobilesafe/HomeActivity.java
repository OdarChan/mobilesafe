package china.chan.mobilesafe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 64913 on 2018/3/16.
 */
public class HomeActivity extends AppCompatActivity{
    private GridView gv_home;
    private String[] mTitleStr;
    private int[] mDrawableIds;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initUI();
        initData();
    }

    private void initData() {
        mTitleStr = new String[]{
                "手机防盗", "通信卫士", "软件管理", "进程管理", "流量统计", "手机杀毒", "缓存清理", "高级工具", "设置工具"
        };
        mDrawableIds = new int[]{
                R.drawable.home_safe, R.drawable.home_callmsgsafe, R.drawable.home_apps,
                R.drawable.home_taskmanager, R.drawable.home_netmanager, R.drawable.home_trojan,
                R.drawable.home_sysoptimize, R.drawable.home_tools, R.drawable.home_settings
        };

        gv_home.setAdapter(new MyAdapter());
        gv_home.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        showDialog();
                        break;
                    case 8:
                        Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                        startActivity(intent);

                        break;






                }
            }
        });




    }

    private void showDialog() {

        String psd = SpUtils.getString(this, ConstantValue.MOBILE_SAVE_PSD, "");
        if (TextUtils.isEmpty(psd)){
            showSetPsdDialog();
        }else {
            showConfirmPsdDialog();
        }


    }

    private void showConfirmPsdDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog dialog = builder.create();
        final View view = View.inflate(this, R.layout.dialog_confirm_psd, null);
        dialog.setView(view, 0, 0, 0, 0);
        dialog.show();

        Button bt_sumbit = (Button)view.findViewById(R.id.bt_submit);
        Button bt_cancle = (Button)view.findViewById(R.id.bt_cancle);

        bt_sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_confirm_pad = (EditText) view.findViewById(R.id.et_confirm_pad);

                String confirmPad = et_confirm_pad.getText().toString();

                if(!TextUtils.isEmpty(Md5Util.encoder(confirmPad))){
                    String pad = SpUtils.getString(getApplicationContext(), ConstantValue.MOBILE_SAVE_PSD, "");
                    if (pad.equals(confirmPad)) {

                        Intent intent = new Intent(getApplicationContext(), SetupOverActivity.class);
                        startActivity(intent);
                        dialog.dismiss();

                        SpUtils.getString(getApplicationContext(), ConstantValue.MOBILE_SAVE_PSD, pad);

                    }else {
                        ToastUtil.show(getApplicationContext(), "确认密码错误 ");
                    }
                }else {
                    ToastUtil.show(getApplicationContext(), "请输入密码");
                }


            }
        });

        bt_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


    }

    private void showSetPsdDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog dialog = builder.create();
        final View view = View.inflate(this, R.layout.dialog_set_psd, null);
        dialog.setView(view, 0, 0, 0, 0);
        dialog.show();

        Button bt_sumbit = (Button)view.findViewById(R.id.bt_submit);
        Button bt_cancle = (Button)view.findViewById(R.id.bt_cancle);

        bt_sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_set_pad = (EditText) view.findViewById(R.id.et_set_pad);
                EditText et_confirm_pad = (EditText) view.findViewById(R.id.et_confirm_pad);

                String pad = et_set_pad.getText().toString();
                String confirmPad = et_confirm_pad.getText().toString();

                if(!TextUtils.isEmpty(pad) && !TextUtils.isEmpty(confirmPad)){
                    if (pad.equals(confirmPad)) {

                        Intent intent = new Intent(getApplicationContext(), SetupOverActivity.class);
                        startActivity(intent);
                        dialog.dismiss();

                        SpUtils.getString(getApplicationContext(), ConstantValue.MOBILE_SAVE_PSD, Md5Util.encoder(confirmPad));

                    }else {
                        ToastUtil.show(getApplicationContext(), "确认密码错误 ");
                    }
                }else {
                    ToastUtil.show(getApplicationContext(), "请输入密码");
                }


            }
        });

        bt_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });



    }

    private void initUI() {
        gv_home = (GridView)findViewById(R.id.gv_home);
    }


    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mTitleStr.length;
        }

        @Override
        public Object getItem(int position) {
            return mTitleStr[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(getApplicationContext(), R.layout.gridview_item, null);
            TextView tv_title = (TextView)view.findViewById(R.id.tv_title);
            ImageView iv_icon = (ImageView)view.findViewById(R.id.iv_icon);

            tv_title.setText(mTitleStr[position]);
            iv_icon.setBackgroundResource(mDrawableIds[position]);
            return view;
        }
    }
}
