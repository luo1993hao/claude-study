package com.yourname.project.common;

/**
 * 常量类
 */
public class Constants {

    private Constants() {
        // 私有构造函数，防止实例化
    }

    /**
     * 逻辑删除常量
     */
    public static final int DELETED = 1;
    public static final int NOT_DELETED = 0;

    /**
     * Redis Key 前缀
     */
    public static final String REDIS_KEY_PREFIX = "project:";

}
