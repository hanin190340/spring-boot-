package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Random;

@RestController
public class HelloController {
    @GetMapping("/hello")

    public String hello(@RequestParam (defaultValue = " Guest") String name) {
        return "Hello " + name;
    }
    @GetMapping("/sum")
    public Integer sumEndpoint (@RequestParam Integer  b , Integer a) {
        return b + a ;
    }
    @GetMapping("/info")
    public HashMap<String,String> info (@RequestParam String name , String city, String language){
        HashMap<String,String> info = new HashMap();
        info.put("name" ,name );
        info.put ("city", city);
        info.put("language",language);
        return info;
    }
    @GetMapping("/greet")
public String greet (@RequestParam String name){
        return "Welcome, " + name + "!" ;
    }
@GetMapping ("/upper")
    public String upper (@RequestParam String text ){
        return text.toUpperCase();
}
@GetMapping ("/random")
    public  Integer random (@RequestParam Integer max, Integer min ){
    Random random = new Random();
  return   random.nextInt((max - min) + 1) + min;
}



}
