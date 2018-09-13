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
public class VariableCheck {
    public static int staticNumber = 1;

    public int instanceNumber = 1;

    public void addNumber(){
        staticNumber++;
        instanceNumber++;
    }

    public void addmitNumber( String instanceName ){
        System.out.println( instanceNumber + "variableNumber:" );
        System.out.println( "Static Number is " + staticNumber );
        System.out.println( "Instance Number is " + instanceNumber );
    }

}
