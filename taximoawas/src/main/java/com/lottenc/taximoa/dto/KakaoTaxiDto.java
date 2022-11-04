package com.lottenc.taximoa.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lottenc.taximoa.domain.KakaoTaxi;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
public class KakaoTaxiDto {
    private String id;
    private Integer service_fare;
    private Integer toll;
    private Integer platform_fee;
    private String use_code;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime call_time;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime departure_time;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime arrival_time;
    private String departure_point;
    private String arrival_point;
    private String member_id;
    private String member_name;
    private String member_identifier;
    private String member_department;
    private String group_id;
    private String group_name;
    private String car_model;
    private String car_number;
    private LocationVo departure_location;
    private LocationVo arrival_location;
    private String taxi_company_name;
    private String taxi_kind;
    private String vertical_code;
    private Integer item_id;
    private Integer total_distance;
    private Integer dropoff_location_gap;
    private String reason;

    public KakaoTaxi convertKakaoTaxi() {
        return new KakaoTaxi.KakaoTaxiBuilder(this.id)
                .service_fare(this.service_fare)
                .toll(this.toll)
                .platform_fee(this.platform_fee)
                .use_code(this.use_code)
                .call_time(this.call_time)
                .departure_time(this.departure_time)
                .arrival_time(this.arrival_time)
                .departure_point(this.departure_point)
                .arrival_point(this.arrival_point)
                .member_id(this.member_id)
                .member_name(this.member_name)
                .member_identifier(this.member_identifier)
                .member_department(this.member_department)
                .group_id(this.group_id)
                .group_name(this.group_name)
                .car_model(this.car_model)
                .car_number(this.car_number)
                .departure_location(List.of(this.departure_location.getLat(), this.departure_location.getLng()))
                .arrival_location(List.of(this.arrival_location.getLat(), this.arrival_location.getLng()))
                .taxi_company_name(this.taxi_company_name)
                .taxi_kind(this.taxi_kind)
                .vertical_code(this.vertical_code)
                .item_id(this.item_id)
                .total_distance(this.total_distance)
                .dropoff_location_gap(this.dropoff_location_gap)
                .reason(this.reason)
                .build();

    }
}
