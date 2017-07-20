# LoadingLayoutDemo

![image](https://github.com/mavsforlife/LoadingLayoutDemo/blob/master/app/src/main/assets/simple_use.gif)

#### 用法
loadingLayout继承自frameLayout，默认有loading_view, empty_view, error_view三层，允许添加一层content_view.
xml中引入loadingLayout。

代码如下：

可以通过`errorView`、`emptyView`、`loadingView`三个属性来加载特定的页面
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

![image] (https://github.com/mavsforlife/LoadingLayoutDemo/blob/master/app/src/main/assets/tab.gif)

如果项目中遇到这种多个tab页面，每个页面的文字不同，
可以使用`setEmptyText`方法，修改默认emptyView的文字提示。

代码如下：
```
loadingLayout
        .setErrorView(R.layout.error_view_demo)
        .setEmptyText(String.format(getString(R.string.tab_n_no_data), tabPosition))
        .setErrorText(String.format(getString(R.string.tab_n_error), tabPosition));
```

