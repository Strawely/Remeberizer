package com.example.solom.rememberizer

import android.content.Context
import android.graphics.BitmapFactory
import android.widget.ImageButton
import com.example.solom.rememberizer.R

class CustomImageButton(context: Context) : ImageButton(context) {

    private var content:Int
    private var shown:Boolean
    private var bmpOptions: BitmapFactory.Options

    init {

        content = 0
        shown = false
        bmpOptions = BitmapFactory.Options()
        bmpOptions.inSampleSize = 5
        scaleType = ScaleType.FIT_XY
        setImageBitmap(BitmapFactory.decodeResource(getContext().resources, R.drawable.backgr, bmpOptions))
    }

    override fun isShown():Boolean{
        return shown
    }

    fun getContent():Int{
        return content
    }

    fun setContent(content:Int){
        this.content = content
    }

    fun setShown(){
        shown = !shown
        if (shown){
            setImageBitmap(BitmapFactory.decodeResource(context.resources, content, bmpOptions))
        }else{
            setImageBitmap(BitmapFactory.decodeResource(context.resources, R.drawable.backgr, bmpOptions))
        }
    }
}
