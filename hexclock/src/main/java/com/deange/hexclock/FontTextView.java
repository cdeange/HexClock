package com.deange.hexclock;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

public class FontTextView extends TextView {

    public FontTextView(final Context context) {
        this(context, null);
    }

    public FontTextView(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FontTextView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);

        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FontTextView, defStyle, 0);

        String fontName = null;
        if (a != null) {
            fontName = a.getString(R.styleable.FontTextView_fontName);
            a.recycle();
        }

        if (isInEditMode()) {
            // Fix to view the TextFontView in resource previewer
            return;
        }

        if (!TextUtils.isEmpty(fontName)) {
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), fontName));
        }
    }
}
