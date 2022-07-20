package com.sks.boardserver.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class reactController {
    /**
     *
     */
    @GetMapping(value = "/api/test")
    public String indexPage(){
        return "index.html";
    }
}
