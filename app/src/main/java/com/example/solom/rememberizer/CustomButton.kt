package com.example.solom.rememberizer

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageButton
import android.widget.ImageView

class CustomButton(context: Context) : ImageButton(context) {

    var content: Int = 0
    private var shown: Boolean = false
    private val bmpOptions: BitmapFactory.Options

    init {
        bmpOptions = BitmapFactory.Options()
        bmpOptions.inSampleSize = 5
        scaleType = ImageView.ScaleType.FIT_XY
        setImageBitmap(BitmapFactory.decodeResource(getContext().resources, R.drawable.backgr, bmpOptions))
    }

    override fun isShown(): Boolean {
        return shown
    }

    fun setShown() {
        shown = !shown
        if (shown) {
            setImageBitmap(BitmapFactory.decodeResource(context.resources, content, bmpOptions))
        } else {
            setImageBitmap(BitmapFactory.decodeResource(context.resources, R.drawable.backgr, bmpOptions))
        }
    }
}
