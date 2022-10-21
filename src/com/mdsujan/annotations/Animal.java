package com.mdsujan.annotations;

public class Animal {
    private String name;
    private String gender;
    private String stapleFood;

    public Animal() {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Animal(String name, String gender, String stapleFood) {
        this.name = name;
        this.gender = gender;
        this.stapleFood = stapleFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStapleFood() {
        return stapleFood;
    }

    public void setStapleFood(String stapleFood) {
        this.stapleFood = stapleFood;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", stapleFood='" + stapleFood + '\'' +
                '}';
    }

    public void speak(){
        System.out.println("This animal is speaking in their language");
    }
}
