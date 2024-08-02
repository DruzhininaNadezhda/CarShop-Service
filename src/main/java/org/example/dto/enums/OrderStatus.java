package org.example.dto.enums;

public enum OrderStatus {
    NotProcessed("NotProcessed"),
    Processed("Processed"),
    Closed("Closed");
    private final String status;

    public String getStatus() {
        return status;
    }

    OrderStatus(String status) {
        this.status = status;
    }

    public static OrderStatus getStatus(String orderStatus) {
        if (orderStatus == null) return null;
        for (OrderStatus status : OrderStatus.values()) {
            if (status.status.equals(orderStatus)) return status;
        }
        return null;
    }
}
