# HotStart
how to hot start app  [相关文档](http://blog.csdn.net/DanteStones/article/details/51112588)

##android:windowBackground
更改背景主要配置
```xml
<!-- style.xml -->
<style name="AppTheme.Launcher">
    <item name="android:windowBackground">@drawable/launcher_screen</item>
</style>
```
##LayerDrawable
使用layerDrawable来绘制背景
```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android" android:opacity="opaque">
    <!-- 背景颜色设置为白色-->
    <item android:drawable="@android:color/white" />
    <!-- 位于屏幕中央的logo图片-->
    <item>
        <bitmap
            android:gravity="center"
            android:dither="true"
            android:antialias="true"
            android:filter="true"
            android:src="@drawable/onepiece" />
    </item>
</layer-list>
```


##运行效果
![](https://github.com/haibuzou/HotStart/raw/master/art/result.gif) 
