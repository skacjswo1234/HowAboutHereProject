<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<c:if test="${sessionScope.principal.id == afterEntity.user.id}">
		<a href="/after/${afterEntity.id}/updateAfter" class="btn btn-warning" style="margin-top: 30px;">수정</a>
		
		<form style="display: inline-block" onsubmit="deleteAfter(${afterEntity.id})">
			<button id="btn-delete" class="btn btn-danger" type="submit" style="margin-top: 30px;">삭제</button>
		</form>
		
	</c:if>

	<br />
	<br />
	<div>
		<span>글 번호 : ${afterEntity.id}</span> 작성자 : <span><i>${afterEntity.user.username} </i></span>
	</div>
	<br />
	<div>
		<h3>${afterEntity.title}</h3>
	</div>
	<hr />
	<div>
		<div>${afterEntity.content}</div>
	</div>
	<hr />

	<div class="card">
		<form onsubmit="saveComment1(${afterEntity.id})">
			<div class="card-body">
				<textarea id="reply-text" class="form-control" rows="1"></textarea>
			</div>
			<div class="card-footer">
				<button class="btn btn-primary" style="background-color: #f7323f; border-color: #f7323f">등록</button>
			</div>
		</form>
	
	</div>
	<br />

	<div class="card">
		<div class="card-header">
			<b>댓글 리스트</b>
		</div>
		
		<ul id="reply-box" class="list-group">
		
			<c:forEach var="comment" items="${commentsEntity}">
				
				<li id="reply-${comment.id}" class="list-group-item d-flex justify-content-between">
					<div>${comment.text}</div>
					<div class="d-flex">
						<div class="font-italic">작성자 : ${comment.user.username} &nbsp;</div>
						<c:if test="${principal.id == comment.user.id}">
							<button class="badge" onclick="deleteComment1(${comment.id})">삭제</button>
						</c:if>
						
					</div>
				</li>
				
			</c:forEach>
			
		</ul>
		
	</div>
	<br />
</div>

<script src="/js/detail.js"></script>

<%@ include file="../layout/footer.jsp"%>


