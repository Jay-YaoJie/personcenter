# personcenter
 **Glide是一个快速高效的Android图片加载库**
   - 高斯模糊
   - 加载监听
   - 圆形图片
   -  图片缓存
   - 缩放图片
#### .gradle配置
```kotlin
   //Glide是一个快速高效的Android图片加载库 https://github.com/bumptech/glide
    implementation 'com.github.bumptech.glide:glide:4.10.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.10.0'
    //高斯模糊和圆角等 https://github.com/wasabeef/glide-transformations
    implementation 'jp.wasabeef:glide-transformations:4.1.0'
```

#### java （kotlin）源码
```kotlin
Glide.with(imageView.getContext())
        .asGif() // 只能加载gif文件
        // .asBitmap() // 将gif作为静态图加载
        .load(imageUrl) //加载图片地址，可以是本地，网络，资源 
        .transition(DrawableTransitionOptions.withCrossFade(500)) // 渐变
        .placeholder(R.drawable.ic_avatar_default)// 加载中图片
        .error(R.drawable.ic_avatar_default) // 加载失败图片
        .transforms(new CircleCrop()) // 圆形图片
        .transforms(new RoundedCorners(20)) // 圆角图片
       // .skipMemoryCache( true )//设置图片不加入到内存缓存
                          //DiskCacheStrategy.NONE :不缓存图片
                          //DiskCacheStrategy.SOURCE :缓存图片源文件
                          //DiskCacheStrategy.RESULT:缓存修改过的图片
                          //DiskCacheStrategy.ALL:缓存所有的图片，默认
        .diskCacheStrategy( DiskCacheStrategy.NONE )//设置图片不加入到磁盘缓存
   
         // 高斯模糊，参数1：模糊度；参数2：图片缩放x倍后再进行模糊,,centerCrop()、fitCenter()
        .apply(bitmapTransform(new BlurTransformation(50, 8)).centerCrop())
        //.centerCrop() //缩放图片会缩放图片让图片充满整个ImageView的边框，然后裁掉超出的部分
        //.fitCenter() //会缩放图片让两边都相等或小于ImageView的所需求的边框
        .listener(new RequestListener<Drawable>() { // 加载监听
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    }).into(imageView);
                    
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019112116223378.png)
[个人中心源码地址](https://github.com/Jay-YaoJie/personcenter.git)：https://github.com/Jay-YaoJie/personcenter.git
