/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uwo.csd.cs2212.team07;

import java.util.ArrayList;

/**
 *
 * @author aiden
 */
public class testapi {


public static void main(String[] args) {
    
    try {
   ArrayList dawg = Api.getTimeSeriesData("2016-02-11", "heart", 1);
   System.out.println(dawg.toString());
}
    catch (Exception ex) {
        System.err.println("error");
    }
    
    
}
}
