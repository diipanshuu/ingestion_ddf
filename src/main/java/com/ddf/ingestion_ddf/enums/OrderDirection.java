package com.ddf.ingestion_ddf.enums;

/**
 * Enum representing the direction for ordering.
 */
public enum OrderDirection {
    ASC("asc"),
    DESC("desc");

    private final String direction;

    OrderDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
