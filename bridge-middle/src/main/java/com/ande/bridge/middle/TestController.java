package com.ande.bridge.middle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
@RequestMapping("/tt")
public String tt(){
	System.out.println("----------------ggggg-------------");
	return "服务端返回";
}
}
