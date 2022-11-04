package com.lottenc.taximoa.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;


public class KakaoTaxi {
    @Id
    private String id;
    private Integer service_fare;
    private Integer toll;
    private Integer platform_fee;
    private String use_code;
    private LocalDateTime call_time;
    private LocalDateTime departure_time;
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
    private List<Double> departure_location;
    private List<Double> arrival_location;
    private String taxi_company_name;
    private String taxi_kind;
    private String vertical_code;
    private Integer item_id;
    private Integer total_distance;
    private Integer dropoff_location_gap;
    private String reason;

    public KakaoTaxi() {}
    public KakaoTaxi(KakaoTaxi source) {
        copyProperties(source, this);
    }
    public KakaoTaxi(KakaoTaxiBuilder kakaoTaxiBuilder) {
        this.id = kakaoTaxiBuilder.id;
        this.service_fare = kakaoTaxiBuilder.service_fare;
        this.toll = kakaoTaxiBuilder.toll;
        this.platform_fee = kakaoTaxiBuilder.platform_fee;
        this.use_code = kakaoTaxiBuilder.use_code;
        this.call_time = kakaoTaxiBuilder.call_time;
        this.departure_time = kakaoTaxiBuilder.departure_time;
        this.arrival_time = kakaoTaxiBuilder.arrival_time;
        this.departure_point = kakaoTaxiBuilder.departure_point;
        this.arrival_point = kakaoTaxiBuilder.arrival_point;
        this.member_id = kakaoTaxiBuilder.member_id;
        this.member_name = kakaoTaxiBuilder.member_name;
        this.member_identifier = kakaoTaxiBuilder.member_identifier;
        this.member_department = kakaoTaxiBuilder.member_department;
        this.group_id = kakaoTaxiBuilder.group_id;
        this.group_name = kakaoTaxiBuilder.group_name;
        this.car_model = kakaoTaxiBuilder.car_model;
        this.car_number = kakaoTaxiBuilder.car_number;
        this.departure_location = kakaoTaxiBuilder.departure_location;
        this.arrival_location = kakaoTaxiBuilder.arrival_location;
        this.taxi_company_name = kakaoTaxiBuilder.taxi_company_name;
        this.taxi_kind = kakaoTaxiBuilder.taxi_kind;
        this.vertical_code = kakaoTaxiBuilder.vertical_code;
        this.item_id = kakaoTaxiBuilder.item_id;
        this.total_distance = kakaoTaxiBuilder.total_distance;
        this.dropoff_location_gap = kakaoTaxiBuilder.dropoff_location_gap;
        this.reason = kakaoTaxiBuilder.reason;
    }

    public String getId() {
        return id;
    }

    public Integer getService_fare() {
        return service_fare;
    }

    public Integer getToll() {
        return toll;
    }

    public Integer getPlatform_fee() {
        return platform_fee;
    }

    public String getUse_code() {
        return use_code;
    }

    public LocalDateTime getCall_time() {
        return call_time;
    }

    public LocalDateTime getDeparture_time() {
        return departure_time;
    }

    public LocalDateTime getArrival_time() {
        return arrival_time;
    }

    public String getDeparture_point() {
        return departure_point;
    }

    public String getArrival_point() {
        return arrival_point;
    }

    public String getMember_id() {
        return member_id;
    }

    public String getMember_name() {
        return member_name;
    }

    public String getMember_identifier() {
        return member_identifier;
    }

    public String getMember_department() {
        return member_department;
    }

    public String getGroup_id() {
        return group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public String getCar_model() {
        return car_model;
    }

    public String getCar_number() {
        return car_number;
    }

    public List<Double> getDeparture_location() {
        return departure_location;
    }

    public List<Double> getArrival_location() {
        return arrival_location;
    }

    public String getTaxi_company_name() {
        return taxi_company_name;
    }

    public String getTaxi_kind() {
        return taxi_kind;
    }

    public String getVertical_code() {
        return vertical_code;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public Integer getTotal_distance() {
        return total_distance;
    }

    public Integer getDropoff_location_gap() {
        return dropoff_location_gap;
    }

    public String getReason() {
        return reason;
    }

    public static class KakaoTaxiBuilder {
        private String id;
        private Integer service_fare;
        private Integer toll;
        private Integer platform_fee;
        private String use_code;
        private LocalDateTime call_time;
        private LocalDateTime departure_time;
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
        private List<Double> departure_location;
        private List<Double> arrival_location;
        private String taxi_company_name;
        private String taxi_kind;
        private String vertical_code;
        private Integer item_id;
        private Integer total_distance;
        private Integer dropoff_location_gap;
        private String reason;

        public KakaoTaxiBuilder(String id) {
            this.id = id;
        }

        public KakaoTaxiBuilder id(String id) {
            this.id = id;
            return this;
        }

        public KakaoTaxiBuilder service_fare(Integer service_fare) {
            this.service_fare = service_fare;
            return this;
        }

        public KakaoTaxiBuilder toll(Integer toll) {
            this.toll = toll;
            return this;
        }

        public KakaoTaxiBuilder platform_fee(Integer platform_fee) {
            this.platform_fee = platform_fee;
            return this;
        }

        public KakaoTaxiBuilder use_code(String use_code) {
            this.use_code = use_code;
            return this;
        }

        public KakaoTaxiBuilder call_time(LocalDateTime call_time) {
            this.call_time = call_time;
            return this;
        }

        public KakaoTaxiBuilder departure_time(LocalDateTime departure_time) {
            this.departure_time = departure_time;
            return this;
        }

        public KakaoTaxiBuilder arrival_time(LocalDateTime arrival_time) {
            this.arrival_time = arrival_time;
            return this;
        }

        public KakaoTaxiBuilder departure_point(String departure_point) {
            this.departure_point = departure_point;
            return this;
        }

        public KakaoTaxiBuilder arrival_point(String arrival_point) {
            this.arrival_point = arrival_point;
            return this;
        }

        public KakaoTaxiBuilder member_id(String member_id) {
            this.member_id = member_id;
            return this;
        }

        public KakaoTaxiBuilder member_name(String member_name) {
            this.member_name = member_name;
            return this;
        }

        public KakaoTaxiBuilder member_identifier(String member_identifier) {
            this.member_identifier = member_identifier;
            return this;
        }

        public KakaoTaxiBuilder member_department(String member_department) {
            this.member_department = member_department;
            return this;
        }

        public KakaoTaxiBuilder group_id(String group_id) {
            this.group_id = group_id;
            return this;
        }

        public KakaoTaxiBuilder group_name(String group_name) {
            this.group_name = group_name;
            return this;
        }

        public KakaoTaxiBuilder car_model(String car_model) {
            this.car_model = car_model;
            return this;
        }

        public KakaoTaxiBuilder car_number(String car_number) {
            this.car_number = car_number;
            return this;
        }

        public KakaoTaxiBuilder departure_location(List<Double> departure_location) {
            this.departure_location = departure_location;
            return this;
        }

        public KakaoTaxiBuilder arrival_location(List<Double> arrival_location) {
            this.arrival_location = arrival_location;
            return this;
        }

        public KakaoTaxiBuilder taxi_company_name(String taxi_company_name) {
            this.taxi_company_name = taxi_company_name;
            return this;
        }

        public KakaoTaxiBuilder taxi_kind(String taxi_kind) {
            this.taxi_kind = taxi_kind;
            return this;
        }

        public KakaoTaxiBuilder vertical_code(String vertical_code) {
            this.vertical_code = vertical_code;
            return this;
        }

        public KakaoTaxiBuilder item_id(Integer item_id) {
            this.item_id = item_id;
            return this;
        }

        public KakaoTaxiBuilder total_distance(Integer total_distance) {
            this.total_distance = total_distance;
            return this;
        }

        public KakaoTaxiBuilder dropoff_location_gap(Integer dropoff_location_gap) {
            this.dropoff_location_gap = dropoff_location_gap;
            return this;
        }

        public KakaoTaxiBuilder reason(String reason) {
            this.reason = reason;
            return this;
        }

        public KakaoTaxiBuilder(KakaoTaxi kakaoTaxi) {
            this.id = kakaoTaxi.getId();
            this.service_fare = kakaoTaxi.getService_fare();
            this.toll = kakaoTaxi.getToll();
            this.platform_fee = kakaoTaxi.getPlatform_fee();
            this.use_code = kakaoTaxi.getUse_code();
            this.call_time = kakaoTaxi.getCall_time();
            this.departure_time = kakaoTaxi.getDeparture_time();
            this.arrival_time = kakaoTaxi.getDeparture_time();
            this.departure_point = kakaoTaxi.getDeparture_point();
            this.arrival_point = kakaoTaxi.getArrival_point();
            this.member_id = kakaoTaxi.getMember_id();
            this.member_name = kakaoTaxi.getMember_name();
            this.member_identifier = kakaoTaxi.getMember_identifier();
            this.member_department = kakaoTaxi.getMember_department();
            this.group_id = kakaoTaxi.getGroup_id();
            this.group_name = kakaoTaxi.getGroup_name();
            this.car_model = kakaoTaxi.getCar_model();
            this.car_number = kakaoTaxi.getCar_number();
            this.departure_location = kakaoTaxi.getDeparture_location();
            this.arrival_location = kakaoTaxi.getArrival_location();
            this.taxi_company_name = kakaoTaxi.getTaxi_company_name();
            this.taxi_kind = kakaoTaxi.getTaxi_kind();
            this.vertical_code = kakaoTaxi.getVertical_code();
            this.item_id = kakaoTaxi.getItem_id();
            this.total_distance = kakaoTaxi.getTotal_distance();
            this.dropoff_location_gap = kakaoTaxi.getDropoff_location_gap();
            this.reason = kakaoTaxi.getReason();
        }
        public KakaoTaxi build() { return new KakaoTaxi(this);}
    }

    @Override
    public String toString() {
        return "KakaoTaxi{" +
                "id='" + id + '\'' +
                ", service_fare=" + service_fare +
                ", toll=" + toll +
                ", platform_fee=" + platform_fee +
                ", use_code='" + use_code + '\'' +
                ", call_time=" + call_time +
                ", departure_time=" + departure_time +
                ", arrival_time=" + arrival_time +
                ", departure_point='" + departure_point + '\'' +
                ", arrival_point='" + arrival_point + '\'' +
                ", member_id='" + member_id + '\'' +
                ", member_name='" + member_name + '\'' +
                ", member_identifier='" + member_identifier + '\'' +
                ", member_department='" + member_department + '\'' +
                ", group_id='" + group_id + '\'' +
                ", group_name='" + group_name + '\'' +
                ", car_model='" + car_model + '\'' +
                ", car_number='" + car_number + '\'' +
                ", departure_location=" + departure_location +
                ", arrival_location=" + arrival_location +
                ", taxi_company_name='" + taxi_company_name + '\'' +
                ", taxi_kind='" + taxi_kind + '\'' +
                ", vertical_code='" + vertical_code + '\'' +
                ", item_id=" + item_id +
                ", total_distance=" + total_distance +
                ", dropoff_location_gap=" + dropoff_location_gap +
                ", reason='" + reason  + '\'' +
                '}';
    }
}