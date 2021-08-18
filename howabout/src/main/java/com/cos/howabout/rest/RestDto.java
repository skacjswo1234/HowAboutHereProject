package com.cos.howabout.rest;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;



@Data
public class RestDto {
	
    private String name;
    private String location;
    private String level;
    private String comment;
    private List<MultipartFile> files;
    
}

