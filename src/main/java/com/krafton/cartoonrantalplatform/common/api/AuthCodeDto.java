package com.krafton.cartoonrantalplatform.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@ToString
public class AuthCodeDto {

	private String code;
	private int state;
}
