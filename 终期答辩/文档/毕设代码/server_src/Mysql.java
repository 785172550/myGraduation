package cn.outofmemory.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class Mysql {
    public static void main(String arg[]) {
        try {
            Connection con = null; //定义一个MYSQL链接对象
            Class.forName("com.mysql.jdbc.Driver").newInstance(); //MYSQL驱动
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CCLion4", "root", "root"); //链接本地MYSQL
            System.out.print("yes");
        } catch (Exception e) {
            System.out.print("MYSQL ERROR:" + e.getMessage());
        }

    }
}


class Test{   
    public static void main(String []args){        
        System.out.println("test input main arguments");       
        System.out.println(args[0]+"        "+args[1]);        
        System.out.println("end of main");    
     }    
 }