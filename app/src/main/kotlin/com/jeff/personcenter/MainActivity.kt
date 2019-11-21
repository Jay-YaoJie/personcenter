package com.jeff.personcenter

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.bumptech.glide.Glide
import android.os.Bundle

import android.graphics.drawable.Drawable
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import jp.wasabeef.glide.transformations.BlurTransformation
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //头像背景
        Glide.with(this)
            .load(R.drawable.nodown) //加载图片地址，可以是本地，网络，资源
         //  .transition(DrawableTransitionOptions.withCrossFade(500)) // 渐变
            //.placeholder(R.drawable.nodown)// 加载中图片
           // .error(R.drawable.nodown) // 加载失败图片

            // 高斯模糊，参数1：模糊度；参数2：图片缩放x倍后再进行模糊
         //  .apply(bitmapTransform(BlurTransformation(25, 8))  .centerCrop())
         //   .centerCrop()
            .into(h_back)
        //头像
        Glide.with(this)
            .load(R.drawable.nodown) //加载图片地址，可以是本地，网络，资源
            .placeholder(R.drawable.nodown)// 加载中图片
            .error(R.drawable.nodown) // 加载失败图片
            .transforms( CircleCrop()) // 圆形图片
            .into(h_head)

    }
}
