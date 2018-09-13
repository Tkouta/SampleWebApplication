/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.sample.project.memoryCheck;

/**
 *
 * @author 康太
 */
public class VariableNumberTest {
    public static void main(String[] args){
        VariableCheck v1 = new VariableCheck();
        VariableCheck v2 = new VariableCheck();

        v1.addNumber();
        v2.addNumber();

        v1.addmitNumber("v1");
        v2.addmitNumber("v2");
    }


}
