package com.yaoke.youshangyun_app;


public class MyAppJpush extends Application {
    private static final String TAG = "MyApp";
    public static MyApp context;
    private static boolean isAllowDebug;


    @Override
    public void onCreate() {
        super.onCreate();
        isAllowDebug = false;
        context = this;// 赋值
        initJpush();

    }


    /**
     * 初始化 极光推送
     */
    private void initJpush() {
        JPushInterface.setDebugMode(isAllowDebug);//是否是debug模式
        JPushInterface.init(this);
    }

    public static Context getContext() {
        return context;
    }

}