package china.chan.mobilesafe;

import android.app.Application;

import org.xutils.x;

/**
 * Created by 64913 on 2018/3/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
