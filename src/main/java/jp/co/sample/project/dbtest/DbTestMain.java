/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.hitachi.justware.dbtest;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author 康太
 */
public class DbTestMain {
    private static String  sql = "update emp5 set name='tiger' where id = 1";
    
    public static void main(String[] args){
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try(Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","gef4nxs9");
            PreparedStatement stmt = connection.prepareStatement(sql);
                ){
            
            connection.setAutoCommit(false);
            stmt.executeUpdate();
            
            connection.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
