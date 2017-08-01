/*
 * Person.java
 * 
 * Created on Oct 26, 2007, 9:34:48 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajb.ehospital.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Employee extends Person {
    private String employeeType;

    private String employeeNumber;
    private String bankName;
    private String rdoCode;
    private double monthlyLoan;

    private String studentNumber;
    private String gradeLevel;

    private String accountNumber;
    private Date hiredDate;
    private String department;
    private String status;
    private String position;

    private double basicPay;
    private int sickLeaveBenefit;
    private int vacLeaveBenefit;
    private int restDay1;
    private int restDay2;

    private String pagibigNumber;
    private String philhealthNumber;

    private String specialization;
    private String prcLicenseNumber;
    private Date prcValidUntil;
    private Date prcRegistrationDate;
    private String prcLevel;
}
