package com.auteco.msnumber.service;

/**
 *
 * @author Cipriano Armando Gonzalez Ramirez <ciprianoagonzalez038@gmail.com>
 */
public interface IOperatorService {
    void addNumber(Double number);
    double calculate(String operator) throws Exception;
}
