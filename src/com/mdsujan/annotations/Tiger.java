package com.mdsujan.annotations;

@Wild
public class Tiger extends Animal {
    private String meatPerDay;

    public Tiger() {
    }

    public Tiger(String name, String gender, String stapleFood, String meatPerDay) {
        super(name, gender, stapleFood);
        this.meatPerDay = meatPerDay;
    }

    public String getMeatPerDay() {
        return meatPerDay;
    }

    public void setMeatPerDay(String meatPerDay) {
        this.meatPerDay = meatPerDay;
    }

    @Override
    public String toString() {
        return super.toString() + "Tiger{" +
                "meatPerDay='" + meatPerDay + '\'' +
                '}';
    }

    @Override
    public void speak() {
        System.out.println("Roarrrrr!!!");
    }
}
