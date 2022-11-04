package com.lottenc.taximoa.controller;

import com.lottenc.taximoa.domain.KakaoTaxi;
import com.lottenc.taximoa.dto.KakaoTaxiDto;
import com.lottenc.taximoa.service.KakaoTaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lottenc/kakao")
public class ApiController {
    @Autowired
    private KakaoTaxiService kakaoTaxiService;

    public ApiController(KakaoTaxiService kakaoTaxiService, MessageSource messageSource) {
        this.kakaoTaxiService = kakaoTaxiService;
    }

    @GetMapping()
    public ResponseEntity<List<KakaoTaxi>> getKakaoInfo() throws Exception {
        List<KakaoTaxi> listKakaoTaxi = kakaoTaxiService.findKakaoTaxiAll();
        System.out.println("[getKakaoInfo]\n" + listKakaoTaxi.toString());
        return new ResponseEntity<List<KakaoTaxi>>(listKakaoTaxi, HttpStatus.OK);
    }

    @GetMapping("/sync")
    public ResponseEntity<String> syncKakaoTaxi() throws Exception {
        kakaoTaxiService.syncKakaoTaxiData();
        System.out.println("[syncKakaoTaxi]");
        return new ResponseEntity<String>("성공", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KakaoTaxi> getKakaoInfoById(@PathVariable(name = "id") String id) throws Exception {
        KakaoTaxi kakaoTaxi = kakaoTaxiService.findKakaoTaxiById(id);
        return new ResponseEntity<KakaoTaxi>(kakaoTaxi, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<KakaoTaxi> saveKakaoInfo(@RequestBody KakaoTaxiDto kakaoTaxiDto) throws Exception  {
        System.out.println("[save Data]\n" + kakaoTaxiDto);
        KakaoTaxi kakaoTaxi = kakaoTaxiDto.convertKakaoTaxi();
        kakaoTaxiService.modify(kakaoTaxi);
        System.out.println("[saveKakaoInfo]\n" + kakaoTaxi.toString());
        return new ResponseEntity<KakaoTaxi>(kakaoTaxi, HttpStatus.OK);
    }

    @GetMapping("/empty_reason")
    public ResponseEntity<List<KakaoTaxi>> getKakaoInfoEmptyReason() throws Exception {
        List<KakaoTaxi> listKakaoTaxi = kakaoTaxiService.findEmptyReasonData();
        System.out.println("[getKakaoInfoEmptyReason]\n" + listKakaoTaxi.toString());
        return new ResponseEntity<List<KakaoTaxi>>(listKakaoTaxi, HttpStatus.OK);
    }
}