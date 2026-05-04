package com.yourname.project.badcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这是一个故意写得很烂的类，用于测试代码评审插件
 * 包含各种常见的代码问题
 */
public class BadCodeExample {

    // 硬编码密码和敏感信息 - 安全问题
    private static final String DB_PASSWORD = "root123";
    private static final String API_KEY = "sk-abc123xyz789";
    private static final String SECRET_TOKEN = "my-secret-token-2024";
    private String dbUrl = "jdbc:mysql://localhost:3306/mydb?user=root&password=root123";

    // 魔法数字
    private int a = 100;
    private int b = 200;
    private int c = 300;

    // 未使用的变量
    private String unusedVar1 = "unused1";
    private int unusedVar2 = 0;
    private List<String> unusedList = new ArrayList<>();
    private Map<String, Object> unusedMap = new HashMap<>();
    private Date unusedDate = new Date();
    private Calendar unusedCalendar = Calendar.getInstance();

    // 空的构造函数
    public BadCodeExample() {
        // 空构造函数，什么都不做
    }

    /**
     * SQL注入漏洞 - 安全问题
     */
    public User findUserById(String userId) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = DriverManager.getConnection(dbUrl);
            stmt = conn.createStatement();
            // 直接拼接SQL，存在注入漏洞
            String sql = "SELECT * FROM users WHERE id = " + userId + " AND name = '" + userId + "'";
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            // 空异常捕获 - 吞掉异常
        }

        return user;
    }

    /**
     * XSS漏洞 - 安全问题
     */
    public String getUserInput(HttpServletRequest request) {
        // 直接获取用户输入，不进行任何验证或过滤
        String input = request.getParameter("userInput");
        return input; // 直接返回，存在XSS风险
    }

    /**
     * 大函数，超过50行 - 代码质量问题
     */
    public void processUserData(String data) {
        // 这个函数太长了，有很多深层嵌套
        if (data != null) {
            if (data.length() > 0) {
                if (data.contains("user")) {
                    for (int i = 0; i < data.length(); i++) {
                        if (i % 2 == 0) {
                            if (i < 100) {
                                if (i > 50) {
                                    // 深层嵌套，超过4层
                                    String substring = data.substring(i, i + 1);
                                    if (substring.equals("a")) {
                                        System.out.println("Found 'a' at position " + i);
                                    } else if (substring.equals("b")) {
                                        System.out.println("Found 'b' at position " + i);
                                    } else if (substring.equals("c")) {
                                        System.out.println("Found 'c' at position " + i);
                                    } else {
                                        System.out.println("Found other char at position " + i);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // 更多嵌套的代码
        if (data.startsWith("test")) {
            if (data.endsWith("end")) {
                if (data.length() > 10) {
                    if (data.contains("middle")) {
                        // 深层嵌套
                        for (int j = 0; j < 100; j++) {
                            if (j > 0) {
                                if (j % 3 == 0) {
                                    System.out.println("j is divisible by 3: " + j);
                                }
                            }
                        }
                    }
                }
            }
        }

        // 魔法数字到处都是
        int x = 100;
        int y = 200;
        int z = x + y + 300;
        if (z > 500) {
            if (z < 700) {
                if (z == 600) {
                    System.out.println("z equals 600");
                }
            }
        }

        // 未使用的局部变量
        String unusedLocal1 = "test";
        int unusedLocal2 = 123;
        List<String> unusedLocalList = new ArrayList<>();

        // 控制台日志语句
        System.out.println("Processing user data");
        System.out.println("Data length: " + data.length());
        System.out.println("Data content: " + data);
        System.err.println("Error log");
    }

    /**
     * 重复代码 - 代码质量问题
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(dbUrl);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM users";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        } catch (Exception e) {
            // 空异常捕获
        }

        return users;
    }

    /**
     * 重复代码 - 与上面的方法几乎相同
     */
    public List<User> getActiveUsers() {
        List<User> users = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(dbUrl);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE active = 1";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        } catch (Exception e) {
            // 空异常捕获
        }

        return users;
    }

    /**
     * N+1查询问题 - 性能问题
     */
    public List<Order> getUserOrders(int userId) {
        List<Order> orders = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(dbUrl);
            stmt = conn.createStatement();

            // 第一次查询获取订单
            String sql = "SELECT * FROM orders WHERE user_id = " + userId;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setUserId(rs.getInt("user_id"));
                order.setAmount(rs.getDouble("amount"));

                // N+1问题：每个订单再查询一次用户信息
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery("SELECT * FROM users WHERE id = " + order.getUserId());
                if (rs2.next()) {
                    User user = new User();
                    user.setId(rs2.getInt("id"));
                    user.setName(rs2.getString("name"));
                    order.setUser(user);
                }

                orders.add(order);
            }
        } catch (Exception e) {
            // 空异常捕获
        }

        return orders;
    }

    /**
     * 不好的命名 - 可读性问题
     */
    public int calc(int a, int b, int c) {
        int x = a + b;
        int y = x * c;
        int z = y - a;
        int w = z / b;
        int v = w + c;
        int u = v - a;
        int t = u * b;
        int s = t - c;
        int r = s + a;
        int q = r - b;
        int p = q + c;
        int o = p - a;
        int n = o * b;
        int m = n - c;
        int l = m + a;
        int k = l - b;
        int j = k + c;
        int i = j - a;
        int h = i * b;
        int g = h - c;
        int f = g + a;
        int e = f - b;
        int d = e + c;

        return d;
    }

    /**
     * 资源泄漏 - 未关闭连接
     */
    public void readFile(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            // 未关闭这些资源

            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            // 空异常捕获
        } catch (IOException e) {
            // 空异常捕获
        }
    }

    /**
     * 资源泄漏 - FileWriter未关闭
     */
    public void writeFile(String filePath, String content) {
        try {
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(content);
            bw.newLine();
            bw.write("End of file");

            // 未关闭bw和fw

        } catch (IOException e) {
            // 空异常捕获
        }
    }

    /**
     * 空方法 - 不做任何事
     */
    public void doNothing() {

    }

    /**
     * 返回null的方法 - 可能导致NullPointerException
     */
    public String getNullString() {
        return null;
    }

    /**
     * 不安全的HTTP连接
     */
    public String fetchData(String url) {
        try {
            URL apiUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();

            // 未设置超时时间
            conn.setRequestMethod("GET");

            Scanner scanner = new Scanner(conn.getInputStream());
            String response = scanner.useDelimiter("\\A").next();
            scanner.close();

            return response;

        } catch (Exception e) {
            // 空异常捕获
            return null;
        }
    }

    /**
     * 参数未验证
     */
    public int calculate(int a, int b, int c, int d, int e, int f) {
        // 参数太多，超过5个
        // 没有验证参数范围

        int result = a + b + c + d + e + f;

        if (result > 1000000) {
            if (result < 2000000) {
                if (result % 2 == 0) {
                    if (result % 3 == 0) {
                        if (result % 5 == 0) {
                            // 深层嵌套
                            return result / 2;
                        }
                    }
                }
            }
        }

        return result;
    }

    /**
     * 线程安全问题
     */
    private int counter = 0;

    public void incrementCounter() {
        // 非线程安全的操作
        counter = counter + 1;
    }

    public int getCounter() {
        return counter;
    }

    /**
     * 不好的日期处理
     */
    public String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // SimpleDateFormat不是线程安全的
        return sdf.format(date);
    }

    /**
     * 使用deprecated方法
     */
    public Date createDate() {
        Date date = new Date(2024, 5, 4); // deprecated constructor
        return date;
    }

    // 内部类，用于测试
    public static class User {
        private int id;
        private String name;
        private String email;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public static class Order {
        private int id;
        private int userId;
        private double amount;
        private User user;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }
}