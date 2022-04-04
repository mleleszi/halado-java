package com.example.springbatch.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
public class PersonDto {
    private String name;
    private Double points;

    public PersonDto() {
    }

    public PersonDto(String name, Double points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}
