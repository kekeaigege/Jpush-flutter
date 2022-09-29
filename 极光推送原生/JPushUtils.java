package com.yaoke.youshangyun_app;

import android.content.Context;

import java.util.Set;

import cn.jpush.android.api.JPushInterface;

public class JPushUtils {
    /**
     * 初始化 极光推送
     */
    private void initJpush(Context context) {
        JPushInterface.setDebugMode(true);//是否是debug模式
        JPushInterface.init(context);
    }
    /**
     * 获取注册ID，推送的token令牌
     */
    public static String getRegistrationID(Context context) {
        return JPushInterface.getRegistrationID(context);
    }
    /**
     * 获取连接状态，是否已连接
     */
    public static boolean isConnected(Context context) {
        return JPushInterface.getConnectionState(context);
    }

    //===========暂停/恢复推送===============//

    /**
     * 停止推送
     */
    public static void stopPush(Context context) {
        JPushInterface.stopPush(context);
    }

    /**
     * 停止推送
     */
    public static void resumePush(Context context) {
        JPushInterface.resumePush(context);
    }

    /**
     * 获取推送是否停止
     */
    public static boolean isPushStopped(Context context) {
        return JPushInterface.isPushStopped(context);
    }
    //===========别名alias操作===============//

    /**
     * 绑定别名 JPushInterface.setAlias(Context context, int sequence, String alias);
     */
    public static void bindAlias(Context context,int sequence,String alias) {
        JPushInterface.setAlias(context, sequence, alias);
    }

    /**
     * 解绑别名 JPushInterface.deleteAlias(Context context, int sequence);
     */
    public static void unBindAlias(Context context, int sequence) {
        JPushInterface.deleteAlias(context, sequence);
    }


    /**
     * 获取别名 JPushInterface.getAlias(Context context, int sequence);
     */
    public static void getAlias(Context context, int sequence) {
        JPushInterface.getAlias(context, sequence);
    }

    //===========标签tags操作===============//

    /**
     * 增加标签 JPushInterface.addTags(Context context, int sequence, Set<String> tags);
     *
     * @param tags
     */
    public static void addTags(Context context, int sequence, Set<String> tags) {
        JPushInterface.addTags(context,sequence,tags);
    }

    /**
     * 删除标签 JPushInterface.deleteTags(Context context, int sequence, Set<String> tags);
     *
     * @param tags
     */
    public static void deleteTags(Context context, int sequence, Set<String> tags) {
        JPushInterface.deleteTags(context,sequence, tags);
    }
    /**
     * 清除所有标签 JPushInterface.cleanTags(Context context, int sequence);
     */
    public static void cleanTags(Context context, int sequence) {
        JPushInterface.cleanTags(context, sequence);
    }

    /**
     * 查询指定 tag 与当前用户绑定的状态 JPushInterface.checkTagBindState(Context context, int sequence, String tag);
     *
     * @param tag
     */
    public static void checkTagBindState(Context context, int sequence, String tag) {
        JPushInterface.checkTagBindState(context, sequence, tag);
    }

}
