/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auteco.msnumber.models;

import java.io.Serializable;

/**
 *
 * @author Cipriano Armando Gonzalez Ramirez <ciprianoagonzalez038@gmail.com>
 */
public class CalculateRequest implements Serializable {
    
    
    private String operator;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
    
    
}
