package com.jeff.personcenter.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.jeff.personcenter.R

/**
 * author : Jeff  5899859876@qq.com
 * Csdn :https://blog.csdn.net/Jeff_YaoJie
 * Github: https://github.com/Jay-YaoJie
 * Created :  2019-11-21.
 * description ：自定义LinearLayout
 */
class NavBar : LinearLayout {
    var inputview_input_icon: Int = 0
    internal lateinit var inputview_input_hint: String
    var inputview_is_pass: Boolean = false

    var right_icon: Int = 0
    internal lateinit var inflate: View
    internal lateinit var imageView: ImageView
    internal lateinit var editText: TextView
    internal lateinit var tv_search: View


    constructor(mContext: Context) : super(mContext, null) {
        init(mContext, null)
    }

    constructor(mContext: Context, attrs: AttributeSet) : super(mContext, attrs, 0) {
        init(mContext, attrs)
    }

    constructor(mContext: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        mContext,
        attrs,
        defStyleAttr
    ) {
        init(mContext, attrs)
    }


    private fun init(context: Context, attrs: AttributeSet?) {
        if (attrs == null) {
            return
        }

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.nav)
        inputview_input_icon = typedArray.getResourceId(R.styleable.nav_icon, R.mipmap.ic_launcher)
        right_icon = typedArray.getResourceId(R.styleable.nav_right_icon, R.mipmap.ic_launcher)
        inputview_input_hint = typedArray.getString(R.styleable.nav_hint).toString()
        typedArray.recycle()

        inflate = LayoutInflater.from(context).inflate(R.layout.nav_bar, this, false)
        //imageView=  (ImageView)inflate.findViewById(R.id.tou);
        editText = inflate.findViewById(R.id.title) as TextView
        imageView = inflate.findViewById(R.id.back) as ImageView
        imageView.setImageResource(inputview_input_icon)
        editText.text = inputview_input_hint
        //editText.setInputType(inputview_is_pass?);
        addView(inflate)

    }
}