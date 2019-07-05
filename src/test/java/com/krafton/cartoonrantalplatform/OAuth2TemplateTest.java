package com.krafton.cartoonrantalplatform;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OAuth2TemplateTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getCode() throws Exception {
		mockMvc.perform(get("/code"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("hello"))
				;
	}
	
	@Test
	public void apiCallTest() throws Exception {
		this.mockMvc.perform(get("https://login.microsoftonline.com/1a27bdbf-e6cc-4e33-85d2-e1c81bad930a/oauth2/v2.0/authorize")
				.param("client_id", "62a7390a-3ad0-4221-a811-4fa0bf9f4e80")
				.param("scope", "openId")
				.param("response_type", "code")
				.param("redirect_uri", "localhost:3000/azure/callback"))
				.andDo(print())
				.andExpect(status().isOk());
		
		/*
		 * https://login.microsoftonline.com/1a27bdbf-e6cc-4e33-85d2-e1c81bad930a/oauth2/v2.0/authorize?
		 * client_id=62a7390a-3ad0-4221-a811-4fa0bf9f4e80
		 * &response_type=code
		 * &redirect_uri=http://localhost:3000/azure/callback
		 * &scope=openid
		 */
	}
}
