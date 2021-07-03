/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auteco.msnumber.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cipriano Armando Gonzalez Ramirez <ciprianoagonzalez038@gmail.com>
 */
@Service
@Scope("singleton")
public class OperatorService implements IOperatorService {

    List<Double> numberList = new ArrayList<>();

    @Async
    public void addNumber(Double number) {
        if (number != null) {
            numberList.add(number);
        }
    }

    public double calculate(String operator) throws Exception {
        double rta = 0;

        switch (operator) {
            case "+":
                rta = add();
                break;

            case "-":
                rta = subtract();
                break;

            case "*":
                rta = multiply();
                break;

            case "/": 
                try {
                    rta = divide();
                } catch (Exception ex) {
                    throw new Exception("");
                }
                break;
                
            default:
                throw new Exception("Operador no válido");
        }

        return rta;
    }

    private double add() {
        double rta = getFirstValue();
        boolean first = true;
        for (Double it : numberList) {
            if (!first) {
                rta = rta + it;
                
            } else {
                first = false;
            }
        }

        return rta;
    }

    private double subtract() {
        double rta = getFirstValue();
        boolean first = true;
        for (Double it : numberList) {
            if (!first) {
                rta = rta - it;
            } else {
                first = false;
            }

        }

        return rta;
    }

    private double multiply() {
        double rta = getFirstValue();
        boolean first = true;
        for (Double it : numberList) {
            if (!first) {
                rta = rta * it;
            } else {
                first = false;
            }

        }

        return rta;
    }

    private double divide() throws Exception {
        double rta = getFirstValue();
        boolean first = true;
        for (Double it : numberList) {
            if (!first) {
                rta = rta / it;
            } else {
                first = false;
            }

        }

        return rta;
    }

    private double getFirstValue() {
        return !numberList.isEmpty() ? numberList.get(0) : 0;
    }
}
