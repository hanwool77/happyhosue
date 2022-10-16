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
										<tr class="${colorArr[index%3]}">
										<td>${vo.aptCode}</td>
										<td>${vo.aptName}</td>
										<td>${vo.sidoName} ${vo.gugunName} ${vo.dongName} ${vo.jibun}</td>
										<td>${vo.buildYear}</td>
										<td>${vo.recentPrice}</td>
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
										<tr class="${colorArr[index%3]}">
										<td>${vo.aptName}</td>
										<td>${vo.sidoName} ${vo.gugunName} ${vo.dongName} ${vo.jibun}</td>
										<td>${vo.buildYear}</td>
										<td>${vo.floor}</td>
										<td>${vo.area}</td>
										<td>${vo.dealMonth}월 ${vo.dealDay}일</td>
										<td>${vo.dealAmount}</td>										
									`;
									$("tbody#detailResult").append(str);
								});
								displayMarkers(data); 
							}
							,"json"
					);
				});