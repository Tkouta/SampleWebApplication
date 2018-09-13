/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.sample.project.staticInitializer;

/**
 *
 * @author 康太
 */
public class Initializer {
    static{
        System.out.println("staticイニシャライザを実行しました。");
    }

    public static StringBuilder message(){
        System.out.println("名前と年齢をreturnします。");

        StringBuilder sb = new StringBuilder();

        String name = "高橋康太";
        String age = null;

        age = Age.getAge().toString();

        sb.append(name);
        sb.append(age);

        return sb;
    }
}
