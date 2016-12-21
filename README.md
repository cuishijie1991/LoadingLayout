LoadingLayout
===
---
一个简单轻量的FrameLayout布局，封装了开发中常用的加载页面、结果页面、无结果页面、错误页面的切换。 允许设置工程的默认页面布局,也可以自定义设置对应页面布局。免去了在项目开发中不断要Copy各种默认状态页面并要进行显示隐藏的麻烦，欢迎使用~    
A smiple and lightweight frameLayout which handles the switching between LoadingLayout、 resultLayout、noResultLayout and errorLayout in your project. It is easy to define your default or custom layouts and will really reduce much pain from boring copy codes.Welcome to use
             
             
##效果图
----
![effect gif](https://github.com/cuishijie1991/LoadingLayout/blob/master/loadinglayout.gif)    


##用法
----
* Copy LoadingLayout.java 并添加到自己到工程。在变量定义的地方可以添加项目对应的默认页面布局   

    ```
    //TODO define your default loadingView, noResultView, netErrorView below And just define it in the xml layout when u need a custom layout some time   
    private static final int defaultLoadingResId = 0;
    private static final int defaultNoResultResId = 0;
    private static final int defaultNetErrorResId = 0;
    ```

* Copy res/values/attrs.xml中的LoadingLayout样式到自己工程。如需自定义个别页面的布局，通过添加属性来实现

    ```
    <com.csj.loadinglayout.LoadingLayout
        android:id="@+id/loadingLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
    
        <!-- define below when needs custom layout -->
        app:loadingLayout="@layout/default_loading_layout"
        app:netErrorClickableView="@+id/clickableView"
        app:netErrorLayout="@layout/default_net_error_layout"
        app:noResultLayout="@layout/default_no_result_layout">

        <LinearLayout
            android:id="@+id/contentPanel"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical" />

    </com.csj.loadinglayout.LoadingLayout>

    ```   
* 常用API, 详见demo
 
    ```
    showLoading()
    showResult()
    showNoResult()
    showNetError()
    setOnNetErrorClickListener(OnClickListener)
    ```
*  和ScrollView类似，只允许添加一个子View
    
