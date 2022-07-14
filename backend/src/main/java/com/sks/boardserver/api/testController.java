package com.sks.boardserver.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    /**
     * ping 테스트용 api
     */
    @GetMapping(value = "/api/ping")
    public String ping(){
        return "pong";
    }
}
