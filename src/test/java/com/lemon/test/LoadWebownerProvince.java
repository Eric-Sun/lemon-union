package com.lemon.test;

import com.lemon.union.core.Constants;

import java.sql.*;
import java.util.List;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-4-11
 * Time: 下午3:20
 * To change this template use File | Settings | File Templates.
 */
public class LoadWebownerProvince {
    private static String url = "jdbc:mysql://211.144.137.66:3306/lemon2";
    private static String user = "lemon";
    private static String password = "lemon001)(";
    private static Connection conn = null;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        String s1 = "select wid from lem_webowner";
        PreparedStatement pstmt = conn.prepareStatement(s1);
        ResultSet rs = pstmt.executeQuery(s1);
        List<Long> list = new ArrayList<Long>();
        while (rs.next()) {
            list.add(rs.getLong(1));
        }
        rs.close();
        pstmt.close();
        list.clear();
        list.add(1073L);
        for (Long wid : list) {
            for (String p : Constants.provinceMap.keySet()) {
                String s3 = "select count(1) from webowner_province where wid=? and province=?";
                PreparedStatement p3 = conn.prepareStatement(s3);
                p3.setLong(1, wid);
                p3.setString(2, Constants.provinceMap.get(p));
                ResultSet rs3 = p3.executeQuery();
                rs3.next();
                int count = rs3.getInt(1);
                if (count == 1)
                    continue;
                String s2 = "insert into webowner_province (wid,province,province2) values(?,?,?)";
                PreparedStatement p2 = conn.prepareStatement(s2);
                p2.setLong(1, wid);
                p2.setString(3, p);
                p2.setString(2, Constants.provinceMap.get(p));
                p2.executeUpdate();
                p2.close();
                ;
            }
        }
        conn.close();
    }
}
