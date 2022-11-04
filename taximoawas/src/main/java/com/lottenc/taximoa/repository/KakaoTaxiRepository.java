package com.lottenc.taximoa.repository;

import com.lottenc.taximoa.domain.KakaoTaxi;

import java.util.List;
import java.util.Optional;

public interface KakaoTaxiRepository {
    List<KakaoTaxi> findAll();
    Optional<KakaoTaxi> findByEmpNo(String empno);
    Optional<KakaoTaxi> findById(String id);
    Optional<KakaoTaxi> findLastData();
    List<KakaoTaxi> findEmptyReasonData();
    void update(KakaoTaxi kakaoTaxi);
    void insert(KakaoTaxi kakaoTaxi);
}
