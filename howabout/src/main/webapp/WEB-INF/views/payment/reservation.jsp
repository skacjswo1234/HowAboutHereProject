<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../layout/header.jsp"%>
<main id="main">
<script>
function rowDel(obj)
{
    var tr = obj.parentNode.parentNode;
    tr.parentNode.removeChild(tr);
}


</script>
    <table class="table table-striped">
    <thead>
        <tr>
            <th><h4><strong>예약숙소</strong></h4></th>
            <th><h4><strong>예약방번호</strong></h4></th>
            <th><h4><strong>예약번호</strong></h4></th>
            <th><h4><strong>예약자</strong></h4></th>

        </tr>
    </thead>
    <c:forEach var="reservation" items="${reservationEntity}">
    <tbody>
        <tr>
            <td>${reservation.restName}</td>
            <td>${reservation.roomName}</td>
            <td>${reservation.user.id}</td>
            <td>${reservation.user.username}</td>
         <td>
     
			<button id="btn-delete" class="btn btn-danger" type="submit" style="background-color: #f7323f; border-color: #f7323f; color: #fff;" onclick="javascript:rowDel(this);">예약삭제</button>
    
         
         </td> 	 
        </tr>
             
    </tbody> 
    </c:forEach>
    </table>
</main>
<!-- End #main -->
<%@ include file="../layout/footer.jsp"%>