/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auteco.msnumber.controller;

import com.auteco.msnumber.models.ApiResponse;
import com.auteco.msnumber.models.CalculateRequest;
import com.auteco.msnumber.service.IOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cipriano Armando Gonzalez Ramirez <ciprianoagonzalez038@gmail.com>
 */
@RestController
@RequestMapping("/auteco")
public class OperatorController {
    @Autowired
    IOperatorService service;
    
    
    @PostMapping("addnumber/{number}")
    public ResponseEntity<ApiResponse> addNumber(@PathVariable Double number){
        try {
            service.addNumber(number);
            return new ResponseEntity<>(new ApiResponse.ok().data("ok").build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse.error().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("calculate")
    public ResponseEntity<ApiResponse> calculate(@RequestBody CalculateRequest datosFirma){
        try {
            return new ResponseEntity<>(new ApiResponse.ok().data(service.calculate(datosFirma.getOperator())).build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse.error().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
