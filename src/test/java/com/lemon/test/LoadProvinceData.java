package com.lemon.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-4-10
 * Time: 下午6:48
 * To change this template use File | Settings | File Templates.
 */
public class LoadProvinceData {


    private static String url = "jdbc:mysql://localhost:3306/lemon2";
    private static String user = "lemon";
    private static String password = "lemon001)(";
    private static String fileName = "d:\\hd.txt";

    private static Connection conn = null;

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = null;
        List<O> list = new ArrayList<O>();
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(",");
            O o = new O();
            o.mobile = arr[0];
            o.province = arr[1];
            o.city = arr[2];
            list.add(o);
        }

        System.out.println(list.size());
        for (O o : list) {
            String sql = "insert into api_haoduan (mobile,length,province,city,type) values (?,7,?,?,'移动')";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, o.mobile);
            pstmt.setString(2, o.province);
            pstmt.setString(3, o.city);
            pstmt.execute();
            pstmt.close();
        }
        System.out.println("ok");
        conn.close();
        ;

    }
}

class O {
    public String mobile;
    public String province;
    public String city;
}