<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>

<section id="index_section">
	<div class="card col-sm-12 mt-1" style="min-height: 850px;">
		<div class="card-body">
			<div class="form-group form-inline justify-content-center">
				<label class="mr-2" for="sido">시도 : </label> <select
					class="form-control" id="sido">
					<option value="0">선택</option>
				</select> <label class="mr-2 ml-3" for="gugun">구군 : </label> <select
					class="form-control" id="gugun">
					<option value="0">선택</option>
				</select> <label class="mr-2 ml-3" for="dong">읍면동 : </label> <select
					class="form-control" id="dong">
					<option value="0">선택</option>
				</select>
				<!-- <button type="button" id="aptSearchBtn">검색</button> -->

				<label class="mr-2 ml-3" for="minPrice">최저금액 : </label> <input
					type="number" id="minPrice" min='0' style="width: 80px" value="0">
				<option value="0">만원</option>
				</input> <label class="mr-2 ml-3" for="maxPrice">최고금액 : </label> <input
					type="number" id="maxPrice" min='0' style="width: 80px">
				<option value="0">만원</option>
				</input>

			</div>
			<table class="table mt-2" id="aptlist">
				<colgroup>
					<col width="100">
					<col width="150">
					<col width="*">
					<col width="120">
					<col width="120">
					<col width="120">
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>아파트이름</th>
						<th class="text-center">주소</th>
						<th>건축연도</th>
						<th>최근거래금액</th>
						<th>버튼</th>
					</tr>
				</thead>
				<tbody id="searchResult"></tbody>
			</table>
			<table class="table mt-2" id="aptdetail">
				<colgroup>
					<col width="100">
					<col width="*">
					<col width="150">
					<col width="120">
					<col width="120">
					<col width="120">
					<col width="120">
				</colgroup>
				<thead>
					<tr>
						<th>아파트이름</th>
						<th class="text-center">주소</th>
						<th>건축연도</th>
						<th>층</th>
						<th>넓이</th>
						<th>거래 날짜</th>
						<th>거래 가격</th>
					</tr>
				</thead>
				<tbody id="detailResult"></tbody>
			</table>
			<div id="map" style="width: 100%; height: 500px;"></div>
			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cf3affd1ac12fbd624932598097784a6&libraries=services"></script>
			-->
			<script type="text/javascript" src="/js/map.js"></script>
			<script type="text/javascript">
				let colorArr = ['table-primary','table-success','table-danger'];
				$(document).ready(function(){					
					$.get(root + "/map/sido"
						,function(data, status){
						$("#aptdetail").hide();
							$.each(data, function(index, vo) {
								$("#sido").append("<option value='"+vo.sidoCode+"'>"+vo.sidoName+"</option>");
							});
						}
						, "json"
					);
				});
				$(document).on("change", "#sido", function() {
					$.get(root + "/map/gugun"
							,{sido: $("#sido").val()}
							,function(data, status){
								$("#aptdetail").hide();
								$("#gugun").empty();
								$("#gugun").append('<option value="0">선택</option>');
								$.each(data, function(index, vo) {
									$("#gugun").append("<option value='"+vo.gugunCode+"'>"+vo.gugunName+"</option>");
								});
							}
							, "json"
					);
				});
				$(document).on("change", "#gugun", function() {
					$.get(root + "/map/dong"
							,{gugun: $("#gugun").val()}
							,function(data, status){
								$("#aptdetail").hide();
								$("#dong").empty();
								$("#dong").append('<option value="0">선택</option>');
								$.each(data, function(index, vo) {
									$("#dong").append("<option value='"+vo.dongCode+"'>"+vo.dongName+"</option>");
								});
							}
							, "json"
					);
				});
				$(document).on("change", "#dong", function() {
					$.get(root + "/map/apt"
							,{dong: $("#dong").val()}
							,function(data, status){
								$("#aptlist").show();
								$("#aptdetail").hide();
								$("tbody").empty();
								$.each(data, function(index, vo) {
									let str = `
										<tr class="\${colorArr[index%3]}">
										<td>\${vo.aptCode}</td>
										<td>\${vo.aptName}</td>
										<td>\${vo.sidoName} \${vo.gugunName} \${vo.dongName} \${vo.jibun}</td>
										<td>\${vo.buildYear}</td>
										<td>\${vo.recentPrice}</td>
										<td><input type="button" class="checkBtn" value="상세정보" /></td>
									`;
									$("tbody").append(str);
								});
								displayMarkers(data);
							}
							, "json"
					);
				});
				$(document).on("click", ".checkBtn", function() {
						var checkBtn = $(this);
						var tr = checkBtn.parent().parent();
						var td = tr.children();
						
						var name = td.eq(1).text();
						$.get(root + "/map/apt/detail"
								,{dong: $("#dong").val()
								,aptName:name}
							,function(data, status) {
								$("#aptlist").hide();
								$("#aptdetail").show();
								$("tbody#detailResult").empty();
								$.each(data, function(index, vo) {
									let str = `
										<tr class="\${colorArr[index%3]}">
										<td>\${vo.aptName}</td>
										<td>\${vo.sidoName} \${vo.gugunName} \${vo.dongName} \${vo.jibun}</td>
										<td>\${vo.buildYear}</td>
										<td>\${vo.floor}</td>
										<td>\${vo.area}</td>
										<td>\${vo.dealMonth}월 \${vo.dealDay}일</td>
										<td>\${vo.dealAmount}</td>										
									`;
									$("tbody#detailResult").append(str);
								});
								
								displayMarkers(data); 
							}
							,"json"
					);
				});
				
				$(document).on("change", "#minPrice, #maxPrice", function() {
					$.get(root + "/map/apt/priceRange"
							,{dong: $("#dong").val(), minPrice: $("#minPrice").val(), maxPrice: $("#maxPrice").val()}
							,function(data, status){
								$("#aptlist").show();
								$("#aptdetail").hide();
								$("tbody").empty();
								$.each(data, function(index, vo) {
									let str = `
										<tr class="\${colorArr[index%3]}">
										<td>\${vo.aptCode}</td>
										<td>\${vo.aptName}</td>
										<td>\${vo.sidoName} \${vo.gugunName} \${vo.dongName} \${vo.jibun}</td>
										<td>\${vo.buildYear}</td>
										<td>\${vo.recentPrice}</td>
										<td><input type="button" class="checkBtn" value="상세정보" /></td>
									`;
									$("tbody").append(str);
								});
								displayMarkers(data);
							}
							, "json"
					);
				});
				
				</script>
		</div>
	</div>
</section>
</div>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>