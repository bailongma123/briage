package com.ande.bridge.admin.test;

import com.ande.bridge.common.ParamsCashe;

public class TestConfig {
	
	public static void main(String[] args) {
		String s = ParamsCashe.getProperty("area");
		System.out.println(s);
	}

}
