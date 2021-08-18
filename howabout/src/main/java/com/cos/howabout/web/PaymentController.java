package com.cos.howabout.web;

import javax.servlet.http.HttpSession;

import com.cos.howabout.post.Post;
import com.cos.howabout.reservation.Reservation;
import com.cos.howabout.reservation.ReservationRepository;
import com.cos.howabout.rest.Rest;
import com.cos.howabout.rest.RestRepository;
import com.cos.howabout.rooms.Rooms;
import com.cos.howabout.rooms.RoomsRepository;
import com.cos.howabout.user.User;
import com.cos.howabout.user.UserRepository;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PaymentController {
  private final RoomsRepository roomsRepository;

  private final RestRepository restRepository;
  private final UserRepository userRepository;
  private final ReservationRepository reservationRepository;
  private final HttpSession session;

  // 예약 내역 페이지
  @GetMapping("/reservation")
  public String rvt(Model model) {

    User principal = (User) session.getAttribute("principal");

    model.addAttribute("reservationEntity", reservationRepository.mFindUserReservation(principal.getId()));
    
    return "/payment/reservation";
  }
  
 @PostMapping("/payment/save")
  public String paymentsave(Reservation reservation) {
	  //db저장
	    User principal = (User) session.getAttribute("principal");
	    // User u = new User();
	    // u.setId(1);
	    if (principal == null) {
	      return "redirect:/login";
	    }

	    // reservation.setUser(u);
	    reservation.setUser(principal);
	    
	    reservationRepository.save(reservation);
	    return "redirect:/reservation";     
  		}
 

  
  // 결제시작창
  @GetMapping("/payMain/{id}")
  public String payMain(@PathVariable int id, Model model) {
    // Rooms rooms = roomsRepository.mFindAll(id).get(1);
    Rooms roomsEntity = roomsRepository.findById(id).get();
    // model.addAttribute("rooms", rooms);
    model.addAttribute("roomsEntity", roomsEntity);

    return "/payment/payMain";
  }

  // 결제오류창
  @GetMapping("/pay/payFail")
  public String payFail() {
    return "/payment/payFail";
  }

  // 결제(카카오)
  @GetMapping("/pay/{id}")
  public String pay(@PathVariable int id, Model model) {

    Rooms rooms = roomsRepository.findById(id).get();
    model.addAttribute("rooms", rooms);
    return "/payment/pay";
  }

  // 결제성공창
  @GetMapping("/paySuccess/{id}")
  public String paysuccess(@PathVariable int id, Model model) {
    Rooms rooms = roomsRepository.findById(id).get();
    model.addAttribute("rooms", rooms);
    return "/payment/paySuccess";
  }

}
