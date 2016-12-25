# CoffeeAdapter

[TOC]

## 设计理念
**CoffeeAdapter**被设计为在一个单独的.java文件中使用。不建议以匿名内部类的方式，在Activiy、Fragment中使用。

## 添加依赖
**Gradle:**
```
compile 'com.drolmen:CoffeeAdapter:0.1.0'
```
**Maven**
```
<dependency>
  <groupId>com.drolmen</groupId>
  <artifactId>CoffeeAdapter</artifactId>
  <version>0.1.0</version>
  <type>pom</type>
</dependency>
```

## 使用
        
### 单布局

### 多布局

### 添加HeaderView 和 FooterView
```java
//添加必须在调用RecyclerView#setAdapter方法之前
adapter.addHeaderView(headerView) ;     //添加HeaderView
adapter.addFooterView(headerView) ;     //添加FooterView
recyclerview.setAdapter(adapter);          
```

### 设置点击事件
```
adapter.setViewClickListener(R.id.alertBtn, new OnRvItemClickListener<Student>() {
    //do someThings
});
```