package com.ande.bridge.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ande.bridge.WebSocketServer;

@Controller
@RequestMapping("/index")
public class IndexController {
	@Resource
	private WebSocketServer webSocketServer;
	@RequestMapping("/tt")
	public ModelAndView index(){
		ModelAndView view=new ModelAndView("index");
		return view;
	}
	@RequestMapping("/send")
	public void send(String userId){
		webSocketServer.sendMessage("我日", userId);
	}

}
