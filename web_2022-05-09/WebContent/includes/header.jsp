<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header class="bg-dark py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-white">
			<h1 class="display-4 fw-bolder" id="header_title">홈</h1>
			<p class="lead fw-normal text-white-50 mb-0">With this shop hompeage template</p>
		</div>
	</div>
</header>
<script src="../js/jquery-3.6.0.min.js"></script>
<script>
	let active = location.search;
	active = active.substr(1);
	active = active.split("=");
	
	if(active[1] == 'home') {
		// header_title 아이디를 사용하는 테그에 홈 텍스트를 출력
		let title = $("#header_title").text("홈");
	} else if(active[1] == 'product_list') {
		// header_title 아이디를 사용하는 테그에 모든 상품 텍스트를 출력
		let title = !$("#header_title").text("모든상품");
	}

</script>
