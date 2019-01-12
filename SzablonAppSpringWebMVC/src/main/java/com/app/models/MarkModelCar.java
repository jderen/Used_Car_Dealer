package com.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MarkModelCar {
    @Id
    @GeneratedValue
    Long id;
    String model;
    String mark;
}
