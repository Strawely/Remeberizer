package com.example.solom.rememberizer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageButton;

public class CustomButton extends ImageButton {

    private int content;

    private boolean shown;

    private BitmapFactory.Options bmpOptions;

    public CustomButton(Context context) {
        super(context);
        bmpOptions = new BitmapFactory.Options();
        bmpOptions.inSampleSize = 5;
        setScaleType(ScaleType.FIT_XY);
        setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.backgr, bmpOptions));
    }

    public boolean isShown(){
        return shown;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public void setShown() {
        shown = !shown;
        if(shown){
            setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), content, bmpOptions));
        }
        else {
            setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(), R.drawable.backgr, bmpOptions));
        }
    }
}
