package com.example.ffmpeg.avr.application.controller;

import com.example.ffmpeg.avr.domain.record.repositories.dto.RemoveUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyanqun
 * @version TODO
 * @see
 */
@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {

    @PostMapping("/getCode")
    public Object getCode(@RequestBody RemoveUserDTO dto) {
        log.info("dto:{}", dto);
        return "sucess";
    }

}
