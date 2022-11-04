package com.lottenc.taximoa.dto;

public class LocationVo {
    private Double lat;
    private Double lng;

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

    @Override
    public String toString() {
        return "LocationVo [" +
                "lat=" + lat +
                ", lng=" + lng +
                ']';
    }


}
