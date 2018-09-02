/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.hitachi.justware.staticInitializer;

/**
 *
 * @author 康太
 */
public class Age {
    public static Integer age = 23;
    
    public static Integer getAge(){
        System.out.println("年齢をreturnします。");
        return age;
    }
    
}
