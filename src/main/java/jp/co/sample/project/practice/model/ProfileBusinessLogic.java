/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.hitachi.justware.practice.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 康太
 */
public class ProfileBusinessLogic {
    
    public static Integer ageAddmit( String birthDay ){
        Date today = new Date();
        Date birthday = null;

        SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMdd" );
        try {
            birthday = sdf.parse( birthDay );
        }catch (ParseException e) {

        }

        Integer age = today.getYear() - birthday.getYear();
        if(today.getMonth() < birthday.getMonth()){
            age--;
        } else if(today.getMonth() == birthday.getMonth()){
            if(today.getDay() < birthday.getDay()){
                age--;
            }
        }
        return age;
    }
    
}
