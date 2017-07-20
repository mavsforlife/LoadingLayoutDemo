# LoadingLayoutDemo

[简介](https://mavsforlife.github.io/2017/07/20/loadingLayoutDemo/)

![image](https://github.com/mavsforlife/LoadingLayoutDemo/blob/master/app/src/main/assets/simple_use.gif)

#### 用法
loadingLayout继承自frameLayout，默认有loading_view, empty_view, error_view三层，允许添加一层content_view.

xml中引入loadingLayout。

代码如下：

> 可以通过`errorView`、`emptyView`、`loadingView`三个属性来加载特定的页面

```
<com.victor.loadinglayout.LoadingLayout
            android:id="@+id/loading_layout"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:errorView="@layout/error_view_demo2"
            app:emptyView="@layout/empty_view_demo2">

            <TextView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:gravity="center"
                android:text="@string/content"/>

</com.victor.loadinglayout.LoadingLayout>
 ```
 
 
java代码如下：errorView和emptyView中可以给重新加载按钮设置点击事件。

```
loadingLayout = (LoadingLayout) findViewById(R.id.loading_layout);

loadingLayout
        .setOnEmptyClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingLayout.showLoading();
            }
        })
        .setOnErrorClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingLayout.showLoading();
            }
        })
        .showContent();
 ```

api：

```
showContent();      //显示内容页
showError();        //显示错误页
showEmpty();        //显示空页面
showLoading();      //显示加载页
```

你也可以在java代码中通过set方法设置errorView/emptyView

```
loadingLayout
        .setEmptyView(R.layout.empty_view_demo)
        .setErrorView(R.layout.error_view_demo)
        .setOnEmptyClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingLayout.showLoading();
            }
        })
        .setOnErrorClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingLayout.showLoading();
            }
        })
        .showContent();

```

![image](https://github.com/mavsforlife/LoadingLayoutDemo/blob/master/app/src/main/assets/tab.gif)

如果项目中遇到这种多个tab页面，每个页面的文字不同，
可以使用`setEmptyText` 和 `setErrorText`方法，修改默认emptyView/errorView的文字提示。

代码如下：

```
loadingLayout
        .setErrorView(R.layout.error_view_demo)
        .setEmptyText(String.format(getString(R.string.tab_n_no_data), tabPosition))
        .setErrorText(String.format(getString(R.string.tab_n_error), tabPosition));
```

#### note
- 自定义emptyView时，需要提供一个textView，并将id设置为`btn_empty`
 
- 自定义errorView时，需要提供一个点击按钮，必须将该button的id设为`btn_error`，
再提供一个textView，将id设置为`tv_error`

eg.

> empty_view

```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/no_data"
        android:layout_above="@id/btn_empty"
        android:layout_centerHorizontal="true"/>

    <Button
        android:id="@id/btn_empty"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/special_jump"
        android:layout_centerInParent="true"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:paddingTop="100dp"
        android:text="tip：通过set方法设置的empty_view"
        android:layout_below="@id/btn_empty"
        android:layout_centerHorizontal="true"/>
</RelativeLayout>
```

> error_view

```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <Button
        android:id="@id/btn_error"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/special_jump"
        android:layout_centerInParent="true"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:paddingTop="100dp"
        android:text="tip：通过set方法设置的error_view"
        android:layout_below="@id/btn_error"
        android:layout_centerHorizontal="true"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/network_error"
        android:layout_above="@+id/btn_error"
        android:layout_centerHorizontal="true"
        android:id="@id/tv_error" />
</RelativeLayout>
```