/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.hitachi.justware.practice.filter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author 康太
 */
@WebFilter("/*")
public class LogFilter implements Filter {
    public void init(FilterConfig config){
    }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        PrintWriter logWriter = null;
        
        try{
            Date servletStart = new Date();
            Date servletEnd = null;
            
            File logFile = new File("C:/Users/康太/Documents/NetBeansProjects/PracticeProject/logs");
            logFile.createNewFile();
            FileWriter logFileWriter = new FileWriter("C:/Users/康太/Documents/NetBeansProjects/PracticeProject/logs/filter.log", true);
            logWriter = new PrintWriter( new BufferedWriter( logFileWriter ) );
            logWriter.println( servletStart.toString() + ":サーブレット実行開始" );
            try {
                chain.doFilter(request, response);
            } finally {
                servletEnd = new Date();
                logWriter.println( servletEnd.toString() + ":サーブレット実行終了" );
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            logWriter.close();
        }
        
    }
    
    public void destroy(){
    }
    
}
