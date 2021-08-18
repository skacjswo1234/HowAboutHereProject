package com.cos.howabout.image;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cos.howabout.rest.Rest;
import com.cos.howabout.rooms.Rooms;

import lombok.Data;

@Data
@Entity
public class RoomsImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 프라이머리키 (기본키)
	
	private String imageUrl;

	@JoinColumn(name = "rooms_id")
	@ManyToOne
	private Rooms rooms;
	
}
