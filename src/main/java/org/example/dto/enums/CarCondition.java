package org.example.dto.enums;


public enum CarCondition {
    NewCar("NewCar"),
    UsedCar("UsedCar");
    private final String condition;

    public String getCondition2() {
        if (condition!=null){
        return condition;
        }return "";
    }

    CarCondition(String condition) {
        this.condition = condition;
    }

    public static CarCondition getCondition(String carCondition) {
        if (carCondition == null) return null;
        for (CarCondition condition : CarCondition.values()) {
            if (condition.condition.equals(carCondition)) return condition;
        }
        return null;
    }
}