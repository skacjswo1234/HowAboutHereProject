
	// 문의댓글달기
	let saveComment =  async (postId) =>  {
		event.preventDefault(); // form 액션 타지마!!
		
		let commentReqDto = {
				text: document.querySelector("#reply-text").value,
				postId: postId
		};
		
		// JSON.parse(제이슨문자열);
		//console.log(JSON.stringify(commentReqDto));
		//let test = JSON.stringify(commentReqDto);
		//console.log(JSON.parse(test));
		
		let response = await fetch("/comment", {
			method: "post",
			body: JSON.stringify(commentReqDto),
			headers: {
				"Content-Type": "application/json; charset=utf-8"
			}
		});
		
		let parseResponse = await response.json();
		
		console.log(parseResponse);
		
		if(parseResponse.code === 1){
			let replyBoxEL = document.querySelector("#reply-box");
		
			let replyItem = document.createElement("li");
			replyItem.id = "reply-"+parseResponse.data.id;
			replyItem.className = "list-group-item d-flex justify-content-between";
			
			let temp = `
				<div>${parseResponse.data.text}</div>
					<div class="d-flex">
						<div class="font-italic">작성자 : ${parseResponse.data.user.username} &nbsp;</div>
							<button class="badge" onclick="deleteComment(${parseResponse.data.id})">삭제</button>	
					</div>
			`;
			
			replyItem.innerHTML = temp;
			replyBoxEL.prepend(replyItem);
		}
	}
	
	// 후기댓글달기
	let saveComment1 =  async (afterId) =>  {
		event.preventDefault(); // form 액션 타지마!!
		
		let commentReqDto = {
				text: document.querySelector("#reply-text").value,
				afterId: afterId
		};
		
		// JSON.parse(제이슨문자열);
		//console.log(JSON.stringify(commentReqDto));
		//let test = JSON.stringify(commentReqDto);
		//console.log(JSON.parse(test));
		
		let response = await fetch("/comment/after", {
			method: "post",
			body: JSON.stringify(commentReqDto),
			headers: {
				"Content-Type": "application/json; charset=utf-8"
			}
		});
		
		let parseResponse = await response.json();
		
		console.log(parseResponse);
		
		if(parseResponse.code === 1){
			let replyBoxEL = document.querySelector("#reply-box");
		
			let replyItem = document.createElement("li");
			replyItem.id = "reply-"+parseResponse.data.id;
			replyItem.className = "list-group-item d-flex justify-content-between";
			
			let temp = `
				<div>${parseResponse.data.text}</div>
					<div class="d-flex">
						<div class="font-italic">작성자 : ${parseResponse.data.user.username} &nbsp;</div>
							<button class="badge" onclick="deleteComment(${parseResponse.data.id})">삭제</button>	
					</div>
			`;
			
			replyItem.innerHTML = temp;
			replyBoxEL.prepend(replyItem);
		}
	}

	// 문의 댓글지우기
	async function deleteComment(commentId){
		
		let response = await fetch("/comment/"+commentId, {
			method: "delete"
		});
		
		let parseResponse = await response.text();
		
		if(parseResponse === "ok"){
			//location.reload();
			let deleteEL = document.querySelector("#reply-"+commentId);
			deleteEL.remove();
			console.log(deleteEL);
		}
	}
	
	// 후기 댓글지우기
	async function deleteComment1(commentId){
		
		let response = await fetch("/comment/"+commentId, {
			method: "delete"
		});
		
		let parseResponse = await response.text();
		
		if(parseResponse === "ok"){
			//location.reload();
			let deleteEL = document.querySelector("#reply-"+commentId);
			deleteEL.remove();
			console.log(deleteEL);
		}
	}
	
	

	// 문의게시판지우기
	async function deletePost(postId){
		event.preventDefault();
		
		let response = await fetch("/post/"+postId, {
			method: "delete"
		});
		
		let parseResponse = await response.text();
		
		if(parseResponse === "ok"){
			location.href = "/home";
		}else{
			alert("삭제실패");
		}
		}
	
	// 후기게시판 지우기
	async function deleteAfter(afterId){
		event.preventDefault();
		
		let response = await fetch("/after/"+afterId, {
			method: "delete"
		});
		
		let parseResponse = await response.text();
		
		if(parseResponse === "ok"){
			location.href = "/after";
		}else{
			alert("삭제실패");
		}
		
		
		}
		
		
