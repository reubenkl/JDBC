package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchSql {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtable", "root", "1234");
        Statement stm = con.createStatement();
        String sql = "Select * from dummy";
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            System.out.print("Id:"+rs.getInt("id")+", ");
            System.out.print("Name:"+rs.getString("name")+", ");
            System.out.print("Age:"+rs.getInt("age")+", ");
            System.out.println();
        }
        System.out.println("Done");
    }
}
