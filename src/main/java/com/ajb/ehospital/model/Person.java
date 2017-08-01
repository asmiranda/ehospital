/*
 * Person.java
 *
 * Created on Nov 15, 2007, 5:15:38 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajb.ehospital.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class Person extends AbstractIBean implements Serializable {
    @Id
    private String id;

    private String parentId;

    private String lastName;
    private String firstName;
    private String middleInitial;
    private String gender;
    private String maritalStatus;
    private Date birthDate;
    private int age;
    private String placeOfBirth;
    private String citizenship;
    private String religion;
    private String email;
    private String tinNumber;
    private String sssNumber;
    private String occupation;
    private String spouse;
    private String weight;
    private String height;
    private String bloodType;
    private int childCount;

    private PersonGuardian mother;
    private PersonGuardian father;
    private PersonGuardian guardian;

    private List<Address> addresses;
    private List<Contact> contactList;

    private String userid;
    private String tempPass;
    private boolean isActive = true;

}
