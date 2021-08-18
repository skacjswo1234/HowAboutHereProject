package com.cos.howabout.rest;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.cos.howabout.image.RestImage;
import com.cos.howabout.rooms.Rooms;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Rest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;
    private String location;
    private String level;
    private String comment;
    private String image;
    
    
    @OneToMany(mappedBy = "rest")
    private List<RestImage> restImages;

    // has (room)
    @JsonIgnoreProperties({ "rest" })
    @OneToMany(mappedBy = "rest")
    private List<Rooms> roomsList;
}
