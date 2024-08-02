package org.example.dto.enums;

public enum CarStatus {
    free("free"),
    sold("sold"),
    forService("forService");
    private final String status;

    public String getStatus() {
        return status;
    }

    CarStatus(String status) {
        this.status = status;
    }

    public static CarStatus getStatus(String carStatus) {
        if (carStatus == null) return null;
        for (CarStatus status : CarStatus.values()) {
            if (status.status.equals(carStatus)) return status;
        }
        return null;
    }
}
