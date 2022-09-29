package com.yaoke.youshangyun_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import cn.jpush.android.api.JPushInterface;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "油尚行";
    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            Bundle bundle = intent.getExtras();
//            Log.d(TAG, "[MyReceiver] onReceive - " + intent.getAction() +
//                    ", extras: " + printBundle(bundle));
            if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
                String regId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
                Log.d(TAG,"接收Registration Id : " + regId);

            } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
                Log.d(TAG,"接收到推送下来的自定义消息: "
                        + bundle.getString(JPushInterface.EXTRA_MESSAGE));
            } else if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction())) {
                // 回调处理
                Log.d(TAG, "CALLBACK");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "抛出异常：" + e.getMessage());
        }
    }
}
