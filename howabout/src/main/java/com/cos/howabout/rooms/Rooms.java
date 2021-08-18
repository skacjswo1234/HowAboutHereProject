package com.cos.howabout.rooms;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.cos.howabout.image.RestImage;
import com.cos.howabout.image.RoomsImage;
import com.cos.howabout.rest.Rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Rooms {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private String name;
  private int price;

  @OneToMany(mappedBy = "rooms")
  private List<RoomsImage> roomsImages;
  
  @JoinColumn(name = "rest_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Rest rest;
}
