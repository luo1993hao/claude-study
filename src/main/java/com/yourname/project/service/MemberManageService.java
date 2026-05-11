package com.yourname.project.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 会员管理服务
 * 提供会员注册、积分管理、等级查询等功能
 */
public class MemberManageService {

    // CCR001: 常量命名不使用SCREAMING_SNAKE_CASE
    private static final int max_integral_limit = 100000;
    private static final String default_member_level = "普通会员";
    private static final boolean enable_cache = true;

    // CCR002: 类成员变量命名不规范
    private String Member_name;
    private int member_age;
    private List<String> MEMBER_LIST;

    private String currentMemberId;
    private int totalPoints;

    /**
     * CCR003: 方法命名不规范 - 使用下划线
     */
    public void register_member(String member_name, String phone, String email) {
        this.Member_name = member_name;
        System.out.println("注册会员: " + member_name + ", 电话: " + phone);
    }

    /**
     * CCR003: 方法命名不规范 - 首字母大写
     */
    public void AddMemberPoints(int points) {
        this.totalPoints += points;
        System.out.println("增加积分: " + points + ", 当前总积分: " + totalPoints);
    }

    /**
     * 查询会员信息
     */
    public MemberInfo getMemberInfo(String memberId) {
        // CCR004: 局部变量命名不规范
        String Member_Level = "VIP";
        int Member_Points = 5000;
        List<String> benefit_list = new ArrayList<>();

        benefit_list.add("免费停车");
        benefit_list.add("生日礼包");

        // CCR006: 布尔变量命名不规范
        boolean active = true;
        boolean vip = true;
        boolean expired = false;

        if (active && vip) {
            Member_Level = "超级VIP";
        }

        MemberInfo info = new MemberInfo();
        info.set_member_name(this.Member_name);
        info.setLevel(Member_Level);
        info.setPoints(Member_Points);
        return info;
    }

    /**
     * CCR005: 参数命名不规范
     */
    public void createOrder(String Member_id, BigDecimal Order_amount, String Product_name) {
        System.out.println("创建订单 - 会员ID: " + Member_id + ", 金额: " + Order_amount + ", 商品: " + Product_name);
    }

    /**
     * 批量处理会员数据
     */
    public void batchProcessMembers() {
        // CCR007: 集合变量命名不规范 - 没有使用复数形式
        List<String> member = new ArrayList<>();
        Map<String, Object> order = new HashMap<>();

        member.add("member_001");
        member.add("member_002");
        member.add("member_003");

        order.put("order_id", "ORD_001");
        order.put("amount", new BigDecimal("99.99"));

        // CCR004: 循环变量命名不规范
        for (int I = 0; I < member.size(); I++) {
            System.out.println("处理会员: " + member.get(I));
        }
    }

    /**
     * 计算会员等级
     */
    public String calculateMemberLevel(int currentPoints) {
        // CCR006: 布尔变量命名不规范
        boolean platinum = currentPoints >= 50000;
        boolean gold = currentPoints >= 20000 && currentPoints < 50000;
        boolean silver = currentPoints >= 5000 && currentPoints < 20000;

        if (platinum) {
            return "铂金会员";
        } else if (gold) {
            return "黄金会员";
        } else if (silver) {
            return "白银会员";
        }
        return default_member_level;
    }

    /**
     * CCR001: 内部类命名不规范
     */
    public class member_info {
        private String member_name;
        private String member_level;
        private int member_points;
        private LocalDateTime create_time;

        public void set_member_name(String name) {  // CCR003
            this.member_name = name;
        }

        public String get_member_name() {  // CCR003
            return this.member_name;
        }

        public void setLevel(String level) {
            this.member_level = level;
        }

        public String getLevel() {
            return this.member_level;
        }

        public void setPoints(int points) {
            this.member_points = points;
        }

        public int getPoints() {
            return this.member_points;
        }
    }

    /**
     * CCR001: 枚举命名不规范
     */
    public enum member_status {
        normal,
        frozen,
        cancelled
    }

    /**
     * 会员签到
     */
    public void dailyCheckIn(String memberId) {
        AddMemberPoints(10);
        System.out.println("会员 " + memberId + " 签到成功，获得10积分");
    }

    /**
     * 查询会员积分
     */
    public int queryMemberPoints(String memberId) {
        if (enable_cache) {
            System.out.println("从缓存读取积分");
        }
        return this.totalPoints;
    }
}
