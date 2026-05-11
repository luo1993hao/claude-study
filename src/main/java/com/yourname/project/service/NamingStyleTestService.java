package com.yourname.project.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * 命名风格测试服务类
 * 包含CCR001-CCR007各类命名问题，用于测试代码评审插件
 */
public class NamingStyleTestService {

    // CCR001: 常量命名不使用SCREAMING_SNAKE_CASE
    private static final int max_cache_size = 100;
    private static final String default_user_name = "guest";
    private static final boolean is_debug_mode = true;

    // CCR002: 类成员变量命名不规范
    private String UserName;
    private int user_age;
    private List<String> USER_LIST;

    // 正常命名的变量作为对照
    private String email;
    private int status;

    /**
     * CCR003: 方法命名不规范 - 使用下划线
     */
    public void get_user_info() {
        System.out.println("获取用户信息");
    }

    /**
     * CCR003: 方法命名不规范 - 首字母大写
     */
    public void UpdateUserStatus() {
        System.out.println("更新用户状态");
    }

    /**
     * CCR004: 局部变量命名不规范
     */
    public void processData() {
        // 不规范命名
        String User_Name = "test";
        int USER_AGE = 25;
        List<String> item_list = new ArrayList<>();

        // 使用变量避免编译警告
        System.out.println(User_Name + ": " + USER_AGE);
        item_list.add("test");
    }

    /**
     * CCR005: 参数命名不规范
     */
    public void createOrder(String User_name, int Order_amount, String Address_info) {
        System.out.println("创建订单: " + User_name + ", " + Order_amount);
    }

    /**
     * 正常方法作为对照
     */
    public void normalMethod(String userName, int orderAmount) {
        System.out.println("正常方法: " + userName + ", " + orderAmount);
    }

    /**
     * CCR006: 布尔变量命名不规范 - 缺少is/has/can前缀
     */
    public void checkUserStatus() {
        boolean deleted = false;  // 应该是isDeleted
        boolean active = true;    // 应该是isActive
        boolean admin = false;    // 应该是isAdmin

        if (deleted) {
            System.out.println("用户已删除");
        }
    }

    /**
     * CCR007: 集合变量命名不规范 - 没有使用复数形式
     */
    public void processUserList() {
        // 不规范命名
        List<String> user = new ArrayList<>();  // 应该是users
        Map<String, Object> order = new HashMap<>();  // 应该是orders

        user.add("test1");
        order.put("id", 1);

        // CCR004: 循环变量命名不规范
        for (int I = 0; I < user.size(); I++) {  // 应该是i
            System.out.println(user.get(I));
        }
    }

    /**
     * 包含多种命名问题的内部类
     */
    public class user_data {  // CCR001: 类名应该用PascalCase
        private String user_name;
        private int USER_AGE;

        public void set_user_name(String name) {  // CCR003
            this.user_name = name;
        }

        public String get_user_name() {  // CCR003
            return this.user_name;
        }
    }

    /**
     * 包含命名问题的枚举
     */
    public enum user_status {  // CCR001: 枚举名应该用PascalCase
        active,  // CCR001: 枚举值应该用SCREAMING_SNAKE_CASE
        inactive,
        deleted
    }

    /**
     * 测试所有命名问题
     */
    public void testAllNamingIssues() {
        get_user_info();
        UpdateUserStatus();
        processData();
        createOrder("test", 100, "address");
        checkUserStatus();
        processUserList();

        user_data data = new user_data();
        data.set_user_name("test");

        user_status status = user_status.active;
        System.out.println("Status: " + status);
    }
}
