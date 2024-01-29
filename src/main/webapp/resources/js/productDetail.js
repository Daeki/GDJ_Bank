/**
 * 
 */
 const frm = document.getElementById("frm");
 const up = document.getElementById("up");
 const dele = document.getElementById("del");
 const create = document.getElementById("create");
 const more = document.getElementById("more")
 const replyList = document.getElementById("replyList");
 const replyAdd = document.getElementById("replyAdd");



getReplyList(1, up.getAttribute("data-product-num"));

//삭제 버튼
$("#replyList").on("click", ".del", function(){
	let n = $(this).attr("data-replyNum")
	console.log("replyNum : ", n)

	
	fetch("../reply/delete",{
		method:"post",
		headers : {"Content-type": 'application/x-www-form-urlencoded;charset=utf-8'},
		body:"replyNum="+n+"&productNum="+ up.getAttribute("data-product-num")
	})
	.then(r=>r.json())
	.then(r=>{
		replyList.innerHTML="";
		makeList(r);
	})
})


//더보기 
more.addEventListener("click", ()=>{
	let p = more.getAttribute("data-replyList-page");//현재 페이지 번호
	let a = more.getAttribute("data-replyList-totalPage");//전체 페이지 번호
	
	if(p>a){
		alert('마지막 페이지 입니다');
	}
	
	getReplyList(p, up.getAttribute("data-product-num"))
})

// list 가져 오는 함수
function getReplyList(page, num){
	fetch("../reply/list?page="+page+"&productNum="+num, {
		method:"GET"
	})
	.then(r => r.json())
	.then(r => {
		makeList(r);
	})
	;

}

function makeList(r){
	more.setAttribute("data-replyList-page", r.pager.page*1+1);
	more.setAttribute("data-replyList-totalPage", r.pager.totalPage);
	let userName = replyList.getAttribute("data-user");
	r=r.datas;
	for(let i=0;i<r.length;i++){
		let tr = document.createElement("tr");

		let td = document.createElement("td");
		td.innerHTML=r[i].replyContents;
		tr.append(td);

		td = document.createElement("td");
		td.innerHTML=r[i].userName;
		tr.append(td);

		td = document.createElement("td");
		let d = new Date(r[i].replyDate);
		td.innerHTML=d.getFullYear()+"."+(d.getMonth()+1)+"."+d.getDate();
		tr.append(td);

		if(userName == r[i].userName){
			td = document.createElement("td");
			let b = document.createElement("button")
			b.innerHTML="삭제";
			b.setAttribute("class", "del")
			b.setAttribute("data-replyNum", r[i].replyNum)
			td.append(b);
			tr.append(td)

			td = document.createElement("td");
			b = document.createElement("button")
			b.innerHTML="수정";
			b.setAttribute("class", "update")
			b.setAttribute("data-replyNum", r[i].replyNum)
			td.append(b);
			tr.append(td)
		}
		replyList.append(tr);
	}
}





//댓글등록
replyAdd.addEventListener("click", ()=>{
	const replyForm = document.getElementById("replyForm");
	let form = new FormData(replyForm);

	fetch("../reply/add", {
		method:"POST",
		body:form
	})
	.then(r=>r.json())
	.then(r=>{
		replyList.innerHTML="";
		makeList(r);
		replyForm.reset();
		
	})
})


 
 	up.addEventListener("click", function(){
 		frm.submit();
 	});
 	
 	create.addEventListener("click", function(){
 		frm.setAttribute("action","../account/add");
 		frm.setAttribute("method","get");
 		frm.submit();
 		
 	});

 	dele.addEventListener("click", function(){
 		let result = confirm("정말 삭제하시겠습니까?");
 		if(result){
 		frm.setAttribute("action","./delete");
 		frm.setAttribute("method","post");
 		frm.submit(); 		
 		}
 	});

	 $("#wishList").click(function(){
		// fetch("../wishlist/add?productNum="+$("#up").attr("data-product-num"),{
		// 	method:"GET"
		// })
		// .then(response=>response.text())
		// .then(response=>{
		// 	console.log(response);
		// })
		let productNum = $("#up").attr("data-product-num");
		$.ajax({
			url:"../wishlist/add",
			method:"GET",
			data:{
				productNum:productNum
			},
			success:function(result){
				if(result==1){
					let r=confirm("관심목록으로 이동");
					if(r){
						location.href="../wishlist/list"
					}
				}else {
					alert('등록 실패');
				}
				
			},
			error:function(){
				alert("관심상품 추가에 실패하였습니다");
			}
		});

	});