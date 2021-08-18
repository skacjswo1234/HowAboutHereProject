package com.cos.howabout.web;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cos.howabout.image.RestImage;
import com.cos.howabout.image.RestImageRepository;
import com.cos.howabout.image.RoomsImage;
import com.cos.howabout.image.RoomsImageRepository;
import com.cos.howabout.rest.Rest;
import com.cos.howabout.rest.RestDto;
import com.cos.howabout.rest.RestRepository;
import com.cos.howabout.rooms.RoomsDto;
import com.cos.howabout.rooms.Rooms;
import com.cos.howabout.rooms.RoomsRepository;
import com.cos.howabout.util.MyPath;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MasterController {
	// master(관리자) 페이지-------------------------------

	private final RestRepository restRepository;
	private final RestImageRepository restImageRepository;
	private final RoomsRepository roomsRepository;
	private final RoomsImageRepository roomsImageRepository;

	//방등록
    @GetMapping("/master/mRoom")
    public String mRoom() {
    	return "/master/m-roomWrite";
    }
    
	// 모텔등록
	@GetMapping("/master/motel-write")
	public String motelWrite() {
		return "/master/m-motelWrite";
	}

	// 수정
	@GetMapping("/master/detailModify")
	public String mModigy() {
		return "/master/m-detailModify";
	}
	

    
	// 방등록
	@PostMapping("/master/roomswrite/{name}")
	public @ResponseBody String save(RoomsDto roomsDto, @PathVariable String name) {
		
		System.out.println("roomDto : " + roomsDto.getFiles().size());
		System.out.println(roomsDto.getFiles().get(0).getOriginalFilename());
		
		System.out.println(roomsDto.getName());
		
		//1.Room담기
		
		Rooms rooms = new Rooms();
		rooms.setName(roomsDto.getName());
		rooms.setPrice(roomsDto.getPrice());
		Rooms roomsEntity = roomsRepository.save(rooms);
		

		// 2. RestImage 담기
		UUID uuid = UUID.randomUUID(); // uuid
		for (MultipartFile file : roomsDto.getFiles()) {
			String imageFileName = uuid + "_" + file.getOriginalFilename();
			
			// 3. 파일 저장
			Path imageFilePath = Paths.get(MyPath.path + imageFileName);
		    try {
		      Files.write(imageFilePath, file.getBytes());
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
			
			// 4. DB 넣기
		    RoomsImage ri = new RoomsImage();
			
			//테스트 데이터
//			Rest r = new Rest();
//			r.setId(3);
//			ri.setRest(r);
			
			ri.setRooms(roomsEntity);
			ri.setImageUrl(imageFileName);
			
			roomsImageRepository.save(ri);
		}
		
//	    UUID uuid = UUID.randomUUID(); // uuid
//	    String imageFileName = uuid + "_" + restDto.getFile().getOriginalFilename(); // ㄹㅇㄴㅁㄻㄴㅇㄹㅇㅁㄴㄻㅇㄴㄻㄴㄹㅇㄴ_1.jpg
//	    System.out.println("이미지 파일이름 : " + imageFileName);
	//
//	    Path imageFilePath = Paths.get("C:/Users/90788/OneDrive/바탕 화면/howabout(2)/src/main/resources/static/upload/" + imageFileName);
	//
//	    // 통신, I/O -> 예외가 발생할 수 있다.
//	    try {
//	      Files.write(imageFilePath, restDto.getFile().getBytes());
//	    } catch (Exception e) {
//	      e.printStackTrace();
//	    }
	//
//	    Rest rest = new Rest();
//	    rest.setName(restDto.getName());
//	    rest.setLocation(restDto.getLocation());
//	    rest.setLevel(restDto.getLevel());
//	    rest.setComment(restDto.getComment());
	//
//	    restRepository.save(rest);

			return "ok";
		}

	
	
	
	//호텔,모텔,리조트 rest 설정
	@PostMapping("/master/write/{name}")
	public @ResponseBody String save(RestDto restDto, @PathVariable String name) {

		System.out.println("restDto : " + restDto.getFiles().size());
		System.out.println(restDto.getFiles().get(0).getOriginalFilename());
		
		System.out.println(restDto.getName());

		// 1. Rest 담기
		Rest rest = new Rest();
		rest.setName(restDto.getName());
		rest.setLocation(restDto.getLocation());
		rest.setLevel(restDto.getLevel());
		rest.setComment(restDto.getComment());
		Rest restEntity =  restRepository.save(rest);

		// 2. RestImage 담기
		UUID uuid = UUID.randomUUID(); // uuid
		for (MultipartFile file : restDto.getFiles()) {
			String imageFileName = uuid + "_" + file.getOriginalFilename();
			
			// 3. 파일 저장
			Path imageFilePath = Paths.get(MyPath.path + imageFileName);
		    try {
		      Files.write(imageFilePath, file.getBytes());
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
			
			// 4. DB 넣기
			RestImage ri = new RestImage();
			
			//테스트 데이터
//			Rest r = new Rest();
//			r.setId(3);
//			ri.setRest(r);
			
			ri.setRest(restEntity);
			ri.setImageUrl(imageFileName);
			
			restImageRepository.save(ri);
		
		}

//    UUID uuid = UUID.randomUUID(); // uuid
//    String imageFileName = uuid + "_" + restDto.getFile().getOriginalFilename(); // ㄹㅇㄴㅁㄻㄴㅇㄹㅇㅁㄴㄻㅇㄴㄻㄴㄹㅇㄴ_1.jpg
//    System.out.println("이미지 파일이름 : " + imageFileName);
//
//    Path imageFilePath = Paths.get("C:/Users/90788/OneDrive/바탕 화면/howabout(2)/src/main/resources/static/upload/" + imageFileName);
//
//    // 통신, I/O -> 예외가 발생할 수 있다.
//    try {
//      Files.write(imageFilePath, restDto.getFile().getBytes());
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//
//    Rest rest = new Rest();
//    rest.setName(restDto.getName());
//    rest.setLocation(restDto.getLocation());
//    rest.setLevel(restDto.getLevel());
//    rest.setComment(restDto.getComment());
//
//    restRepository.save(rest);

		return "ok";
	}

}
