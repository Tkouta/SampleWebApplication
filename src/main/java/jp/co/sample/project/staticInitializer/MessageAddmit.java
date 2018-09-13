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
public class MessageAddmit {
    public static void main(String[] args){
        System.out.println("staticイニシャライザのテストを開始します。");
        StringBuilder profile = Initializer.message();
        System.out.println( profile + "は、staticイニシャライザについて理解しました。" );
    }

}
