package com.cos.howabout.dto;

import lombok.Data;

//1 MessageConvert는 추상메서드이다. 
// MessageConvert는 자바오브젝트로 파싱한다.

@Data
public class CommentSaveReqDto {
	private String text;
	private int postId;
	private int afterId;
}
