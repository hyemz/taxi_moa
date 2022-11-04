package com.lottenc.taximoa.repository;

import com.lottenc.taximoa.domain.KakaoTaxi;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class KakaoTaxiJdbcRepository implements KakaoTaxiRepository{
    private JdbcTemplate jdbcTemplate;

    private RowMapper<KakaoTaxi> kakaoTaxiMampper = (rs, rowNum) -> {

        KakaoTaxi kakaoTaxi = new KakaoTaxi.KakaoTaxiBuilder(rs.getString("id"))
                .service_fare(rs.getInt("service_fare"))
                .toll(rs.getInt("toll"))
                .platform_fee(rs.getInt("platform_fee"))
                .use_code(rs.getString("use_code"))
                .call_time(rs.getTimestamp("call_time").toLocalDateTime())
                .departure_time(rs.getTimestamp("departure_time").toLocalDateTime())
                .arrival_time(rs.getTimestamp("arrival_time").toLocalDateTime())
                .departure_point(rs.getString("departure_point"))
                .arrival_point(rs.getString("arrival_point"))
                .member_id(rs.getString("member_id"))
                .member_name(rs.getString("member_name"))
                .member_identifier(rs.getString("member_identifier"))
                .member_department(rs.getString("member_department"))
                .group_id(rs.getString("group_id"))
                .group_name(rs.getString("group_name"))
                .car_model(rs.getString("car_model"))
                .car_number(rs.getString("car_number"))
                .departure_location(List.of(rs.getDouble("departure_location_lat")
                        , rs.getDouble("departure_location_lng")))
                .arrival_location(List.of(rs.getDouble("arrival_location_lat")
                        , rs.getDouble("arrival_location_lng")))
                .taxi_company_name(rs.getString("taxi_company_name"))
                .taxi_kind(rs.getString("taxi_kind"))
                .vertical_code(rs.getString("vertical_code"))
                .item_id(rs.getInt("item_id"))
                .total_distance(rs.getInt("total_distance"))
                .dropoff_location_gap(rs.getInt("dropoff_location_gap"))
                .reason(rs.getString("reason"))
                .build();
        return kakaoTaxi;
    };

    public KakaoTaxiJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<KakaoTaxi> findAll() {
        return jdbcTemplate.query("select * from kakaoTaxi order by call_time desc"
                , this.kakaoTaxiMampper);
    }

    @Override
    public Optional<KakaoTaxi> findByEmpNo(String empno) {
        return Optional.empty();
    }

    @Override
    public Optional<KakaoTaxi> findById(String id) {
        List<KakaoTaxi> listKakaoTaxi = jdbcTemplate.query("select * from kakaoTaxi where id = ?"
                , this.kakaoTaxiMampper
                , id);
        if(!listKakaoTaxi.isEmpty()) return Optional.of(listKakaoTaxi.get(0));
        else return Optional.empty();
    }

    @Override
    public Optional<KakaoTaxi> findLastData() {
        List<KakaoTaxi> listKakaoTaxi = jdbcTemplate.query("select * from kakaoTaxi order by call_time desc limit 1"
                , this.kakaoTaxiMampper);
        if(!listKakaoTaxi.isEmpty()) return Optional.of(listKakaoTaxi.get(0));
        else return Optional.empty();
    }

    @Override
    public List<KakaoTaxi> findEmptyReasonData() {
        return jdbcTemplate.query("select * from kakaoTaxi where reason is null or reason = '' order by call_time desc"
                , this.kakaoTaxiMampper);
    }

    @Override
    public void update(KakaoTaxi kakaoTaxi) {
        jdbcTemplate.update(
                "update kakaotaxi set reason = ? where id = ? "
                , kakaoTaxi.getReason()
                , kakaoTaxi.getId()
        );
    }

    @Override
    public void insert(KakaoTaxi kakaoTaxi) {
        String sql = "insert into kakaotaxi(id, service_fare, toll, platform_fee, "
                + "use_code, call_time, departure_time, arrival_time, departure_point, arrival_point, member_id, "
                + "member_name, member_identifier, member_department, group_id, group_name, car_model, car_number, "
                + "departure_location_lat, departure_location_lng, arrival_location_lat, arrival_location_lng, "
                + "taxi_company_name, taxi_kind, vertical_code, item_id, total_distance, dropoff_location_gap, reason) "
                + " values (?, ? ,?, ?, ?, ?, ?, ?, ? ,?, ?, ? ,?, ?, ?, ?, ?, ?, ? ,?, ?, ? ,?, ?, ?, ?, ?, ?, ?)";
        int result = jdbcTemplate.update(sql
                , kakaoTaxi.getId()
                , kakaoTaxi.getService_fare()
                , kakaoTaxi.getToll()
                , kakaoTaxi.getPlatform_fee()
                , kakaoTaxi.getUse_code()
                , kakaoTaxi.getCall_time()
                , kakaoTaxi.getDeparture_time()
                , kakaoTaxi.getArrival_time()
                , kakaoTaxi.getDeparture_point()
                , kakaoTaxi.getArrival_point()
                , kakaoTaxi.getMember_id()
                , kakaoTaxi.getMember_name()
                , kakaoTaxi.getMember_identifier()
                , kakaoTaxi.getMember_department()
                , kakaoTaxi.getGroup_id()
                , kakaoTaxi.getGroup_name()
                , kakaoTaxi.getCar_model()
                , kakaoTaxi.getCar_number()
                , kakaoTaxi.getDeparture_location().get(0)
                , kakaoTaxi.getDeparture_location().get(1)
                , kakaoTaxi.getArrival_location().get(0)
                , kakaoTaxi.getArrival_location().get(1)
                , kakaoTaxi.getTaxi_company_name()
                , kakaoTaxi.getTaxi_kind()
                , kakaoTaxi.getVertical_code()
                , kakaoTaxi.getItem_id()
                , kakaoTaxi.getTotal_distance()
                , kakaoTaxi.getDropoff_location_gap()
                , "");
    }
}
