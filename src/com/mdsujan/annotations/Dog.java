package com.mdsujan.annotations;

@Domestic
public class Dog extends Animal {
    private String bonesPerDay;

    public Dog() {
    }

    public Dog(String name, String gender, String stapleFood, String bonesPerDay) {
        super(name, gender, stapleFood);
        this.bonesPerDay = bonesPerDay;
    }

    public String getBonesPerDay() {
        return bonesPerDay;
    }

    public void setBonesPerDay(String bonesPerDay) {
        this.bonesPerDay = bonesPerDay;
    }

    @Override
    public String toString() {
        return super.toString() + "Dog{" +
                "bonesPerDay='" + bonesPerDay + '\'' +
                '}';
    }

    @Override
    public void speak() {
        System.out.println("Borf!..Borf!..");
    }
}
