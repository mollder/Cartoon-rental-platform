package com.krafton.cartoonrantalplatform.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/hello")
	public String hello() {
		/*
		String url = "https://login.microsoftonline.com/1a27bdbf-e6cc-4e33-85d2-e1c81bad930a/oauth2/v2.0/authorize";
		
		HttpHeaders httpheader = new HttpHeaders();
		httpheader.add("client_id", "62a7390a-3ad0-4221-a811-4fa0bf9f4e80");
		httpheader.add("response_type", "code");
		httpheader.add("redirect_uri", "http://localhost:3000/azure/callback");
		httpheader.add("scope", "openid");
		
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(httpheader);
		
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
		
		--> 참고용 ( 예전에 restTemplate 으로 보내려다가 실패한 코드
		*/
		
		//아래 url은 URIBuilder를 사용해서 리팩토링 ( property를 통해서 저장도 적용 )
		return "redirect:https://login.microsoftonline.com/1a27bdbf-e6cc-4e33-85d2-e1c81bad930a/oauth2/v2.0/authorize?client_id=62a7390a-3ad0-4221-a811-4fa0bf9f4e80&response_type=code&redirect_uri=http://localhost:3000/azure/callback&scope=openid";
	}
	
	@GetMapping("/azure/callback")
	@ResponseBody
	public String getCode(@RequestParam String code) {
		return code;
	}
}
