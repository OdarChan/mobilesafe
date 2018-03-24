package china.chan.mobilesafe;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by 64913 on 2018/3/19.
 */

public class FocusTextView extends TextView {
    public FocusTextView(Context context) {
        super(context);
    }

    public FocusTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FocusTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}




