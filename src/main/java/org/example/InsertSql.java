package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertSql {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtable", "root", "1234");
        Statement stm = con.createStatement();
        FileReader fin = new FileReader("src/main/resources/data.txt");
        BufferedReader bin = new BufferedReader(fin);
        String reader = bin.readLine();
        String sql,id,name,age,data[];
        while(reader!=null){
            data = reader.split(";");
            id = data[0].trim();
            name = data[1].trim();
            age = data[2].trim();
            sql = "Insert into Dummy values("+id+",'"+name+"',"+age+")";
            stm.execute(sql);
            System.out.println("Done");
            reader = bin.readLine();
        }
    }
}
