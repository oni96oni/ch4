package com.fastcampus.ch4.controller;

import com.fastcampus.ch4.domain.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class SimpleRestController {
//    @GetMapping("/ajax")
//    public String ajax() {
//        return "ajax"; // 뷰이름
//    }

    @GetMapping("/test")
    public String test() {
        return "test"; // 뷰이름
    }

    @PostMapping("/send")
//    @ResponseBody 이렇게 메서드마다 붙이는것을 클래스에 붙임으로써 생략 가능
    public Person test(Person p) {
        System.out.println("p = " + p);
        p.setName("ABC");
        p.setAge(p.getAge() + 10);

        return p;
    }

}