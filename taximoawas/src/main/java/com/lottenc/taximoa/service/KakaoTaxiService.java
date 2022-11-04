package com.lottenc.taximoa.service;

import com.lottenc.taximoa.domain.KakaoTaxi;
import com.lottenc.taximoa.kakaomobility.b2b.KakaoMobilityClient;
import com.lottenc.taximoa.repository.KakaoTaxiRepository;
import com.lottenc.taximoa.service.exception.NotFoundEntityException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class KakaoTaxiService {
    private KakaoTaxiRepository kakaoTaxiRepository;

    public KakaoTaxiService(KakaoTaxiRepository kakaoTaxiRepository) {
        this.kakaoTaxiRepository = kakaoTaxiRepository;
    }

    public List<KakaoTaxi> findKakaoTaxiAll() {
        return kakaoTaxiRepository.findAll();
    }

    public List<KakaoTaxi> findEmptyReasonData() { return kakaoTaxiRepository.findEmptyReasonData(); }

    public KakaoTaxi findKakaoTaxiById(String id) {
        return kakaoTaxiRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException(id));
    }
    @Transactional
    public void insertKakaoTaxi(List<KakaoTaxi> listKakaoTaxi) {
        listKakaoTaxi.forEach(taxi -> {
            if(!kakaoTaxiRepository.findById(taxi.getId()).isPresent()) {
                kakaoTaxiRepository.insert(taxi);
            }
        });
    }

    @Transactional
    public KakaoTaxi modify(KakaoTaxi kakaoTaxi) {
        kakaoTaxiRepository.update(kakaoTaxi);
        return kakaoTaxi;
    }

    @Transactional
    @Scheduled(cron = "0 0/30 4,23 * * *")
    public void syncKakaoTaxiData() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        KakaoTaxi lastTaxi = kakaoTaxiRepository.findLastData()
                .orElse(new KakaoTaxi.KakaoTaxiBuilder("none").call_time(LocalDateTime.parse("2019-01-01 00:00:00", formatter)).build());
        KakaoMobilityClient client = new KakaoMobilityClient();

        String startDt = lastTaxi.getCall_time().minusDays(5).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String endDt = LocalDateTime.now().minusDays(5).format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        String result = client.orders(startDt, endDt);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObj = (JSONObject) jsonParser.parse(result);

        JSONArray jsonArray = (JSONArray)jsonObj.get("orders");

        List<KakaoTaxi> listKakao = new ArrayList<>();
        for(int i=0;i<jsonArray.size();i++) {
            JSONObject data = (JSONObject)jsonArray.get(i);

            if (!data.get("group_id").toString().equals("MSNIXO0D")) continue;

            String tdeparture_time = data.get("departure_time").toString();
            String tarrival_time = data.get("arrival_time").toString();
            String tcall_time = data.get("call_time").toString();

            JSONParser tempParser1 = new JSONParser();
            JSONParser tempParser2 = new JSONParser();
            JSONObject tmpObj1 = (JSONObject) tempParser1.parse(data.get("departure_location").toString());
            JSONObject tmpObj2 = (JSONObject) tempParser2.parse(data.get("arrival_location").toString());



            KakaoTaxi taxi = new KakaoTaxi.KakaoTaxiBuilder(data.get("id").toString())
                    .service_fare(Integer.valueOf(data.get("service_fare") == null ? "" : data.get("service_fare").toString()))
                    .toll(Integer.valueOf(data.get("toll") == null ? "" : data.get("toll").toString()))
                    .platform_fee(Integer.valueOf(data.get("platform_fee") == null ? "" : data.get("platform_fee").toString()))
                    .use_code(data.get("use_code") == null ? "" : data.get("use_code").toString())
                    .call_time(LocalDateTime.parse(tcall_time, formatter))
                    .departure_time(LocalDateTime.parse(tdeparture_time, formatter))
                    .arrival_time(LocalDateTime.parse(tarrival_time, formatter))
                    .departure_point(data.get("departure_point") == null ? "" : data.get("departure_point").toString())
                    .arrival_point(data.get("arrival_point") == null ? "" : data.get("arrival_point").toString())
                    .member_id(data.get("member_id") == null ? "" : data.get("member_id").toString())
                    .member_name(data.get("member_name") == null ? "" : data.get("member_name").toString())
                    .member_identifier(data.get("member_identifier") == null ? "" : data.get("member_identifier").toString())
                    .member_department(data.get("member_department") == null ? "" : data.get("member_department").toString())
                    .group_id(data.get("group_id") == null ? "" : data.get("group_id").toString())
                    .group_name(data.get("group_name") == null ? "" : data.get("group_name").toString())
                    .car_model(data.get("car_model") == null ? "" : data.get("car_model").toString())
                    .car_number(data.get("car_number") == null ? "" : data.get("car_number").toString())
                    .departure_location(List.of(Double.valueOf(tmpObj1.get("lat").toString())
                            , Double.valueOf(tmpObj1.get("lng").toString())))
                    .arrival_location(List.of(Double.valueOf(tmpObj2.get("lat").toString())
                            , Double.valueOf(tmpObj2.get("lng").toString())))
                    .taxi_company_name(data.get("taxi_company_name") == null ? "" : data.get("taxi_company_name").toString())
                    .taxi_kind(data.get("taxi_kind") == null ? "" : data.get("taxi_kind").toString())
                    .vertical_code(data.get("vertical_code") == null ? "" : data.get("vertical_code").toString())
                    .item_id(Integer.valueOf(data.get("item_id")  == null ? "0" : data.get("item_id").toString()))
                    .total_distance(Integer.valueOf(data.get("total_distance") == null ? "0" : data.get("total_distance").toString()))
                    .dropoff_location_gap(Integer.valueOf(data.get("dropoff_location_gap") == null ? "0" : data.get("dropoff_location_gap").toString()))
                    .reason("")
                    .build();
            System.out.println(taxi.toString());
            listKakao.add(taxi);
        }
        this.insertKakaoTaxi(listKakao);
    }

}
