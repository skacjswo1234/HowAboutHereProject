<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


 
  
    <style>
      * {
        font-size: 16px;
        font-family: Consolas, sans-serif;
      }
    </style>
<main id="main">

	<!-- ======= Portfolio Details Section ======= -->
	<section id="resrvation_card" class="resrvation_card"
		style="height: 660px; margin-left: 60px;">
		<div class="container">
			<div class="row" style="width: 800px; height: 530px;">
				
   				
				<div class="col-lg-4 portfolio-info">
				
					<div class="text-box-detail" style="background-color:#FDFCFA; width: 350px; height: 530px; margin-left: 350px;">
					<input type="submit" class="btn_pay gra_left_right_black" data-v-2d73460d="" value="결제 내역">
						 
						<br>
						<p>
							<strong style="margin-left: 10%;">숙박 시설명</strong>
						</p>
						<p style="margin-left: 10%; color:black;">${rooms.rest.name}</p>
						<p style="margin-left: 10%; color:black;">${rooms.name}</p>
						<hr align="center" width="90%">
						    <strong style="margin-left: 10%; font-weight: bold;" >총 예약가</strong>
						    <font style="margin-left: 30%; margin-top: 10px; color: #f7323f;" ><strong>${rooms.price}</strong></font>
						    <ul style="margin-top: 20%;">
						    <li>해당 객실가는 세금, 봉사료가 포함된 금액입니다</li>
						   	<li style="margin-top: 3%;">결제완료 후<font color="red"> 예약자 이름</font>으로 바로 <font color="red">체크인</font> 하시면 됩니다</li>
						    <li style="margin-top: 3%;">해당 상품은 <font color="red">취소</font> 및 <font color="red">환불 불가</font>합니다</li>
						    </ul>
						<form method="POST" action="/payment/save">	
							<input type="hidden" name="restName" value="${rooms.rest.name}"/>
							<input type="hidden" name="roomName" value="${rooms.name}"/>
							<input type="hidden" name="roomPrice" value="${rooms.price}"/>
						 <input type="submit"  class="btn_pay gra_left_right_red" data-v-2d73460d="" value="확인">
						 </form>
					
						 
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Portfolio Details Section -->
	
</main>
<!-- End #main -->
<%@ include file="../layout/footer.jsp"%>