package com.cos.howabout.rooms;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class RoomsDto {
	    private String name;
	    private int price;
	    private List<MultipartFile> files;
}
