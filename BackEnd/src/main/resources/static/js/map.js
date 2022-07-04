var map;
$(document).ready(function () {
		//  카카오 지도 설정.
        var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
        var options = {
          //지도를 생성할 때 필요한 기본 옵션
          center: new kakao.maps.LatLng(37.5012743, 127.039585), //지도의 중심좌표. (멀티캠퍼스)
          level: 6, //지도의 레벨(확대, 축소 정도)
        };

        map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

        // 마커가 표시될 위치입니다
        var markerPosition = new kakao.maps.LatLng(37.5012743, 127.039585);

        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
          position: markerPosition,
        });

        // 마커가 지도 위에 표시되도록 설정합니다
        marker.setMap(map);

        var iwContent =
            '<div style="padding:5px;">멀티캠퍼스 <br><a href="https://map.kakao.com/link/map/멀티캠퍼스,37.5012743, 127.039585" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/멀티캠퍼스,37.5012743, 127.039585" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
          iwPosition = new kakao.maps.LatLng(33.450701, 126.570667); //인포윈도우 표시 위치입니다

        // 인포윈도우를 생성합니다
        var infowindow = new kakao.maps.InfoWindow({
          position: iwPosition,
          content: iwContent,
        });

        // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
        infowindow.open(map, marker);
        // HTML5의 geolocation으로 사용할 수 있는지 확인합니다
        if (navigator.geolocation) {
          // GeoLocation을 이용해서 접속 위치를 얻어옵니다
          navigator.geolocation.getCurrentPosition(function (position) {
              var lat = position.coords.latitude, // 위도
              lon = position.coords.longitude; // 경도
            
            var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
              message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
            // 마커와 인포윈도우를 표시합니다
            displayMarker(locPosition, message);
            // 현재 위치 기준 근처 매물 가져오기
            getNearApt(lat, lon);
          });
        } else {
          // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다

          var locPosition = new kakao.maps.LatLng(37.5012743, 127.039585),
            message = "geolocation을 사용할수 없어요..";

          displayMarker(locPosition, message);
        }
        
        // 근처 매물 N개 가져오기
        function getNearApt(lat, lon) {
        	console.log(lat, lon);
        	$.ajax({
   			 url:'/location/getNearApt/'+lat+'/'+lon,
   			 type:'GET',
   			 contentType:'application/json;charset=utf-8',
   			 dataType:'json',
   			 success:function(list) {
   				 // 성공 후 실행할 메소드 작성
   				 makeSlide(list);
   				 makeMarker(list);
   			 },
   			 error:function(xhr, status, error){
   				 console.log("상태값 : " + xhr.status + "\tHttp 에러메시지 : " + xhr.responseText);
   			 },
   			 statusCode: {
   				 500: function() {
   					 alert("서버에러.");
   				 },
   			 	 404: function() {
   			 		 alert("페이지없다.");
   			 	 }
   			 }
   		 });
        }
        
        // list의 내용물 apt_name, apt_dong_ga, apt_jibun, apt_con_year, lat, lng
        function makeSlide(list){
        	let tags = ["carousel-item active", "carousel-item"];
        	
        	$("#slide_inner").empty();
        	$(list).each(function(index, aptNameLocCon) {
        		let str = `
        			<div class="${index==0?tags[0]:tags[1]}">
        				<div class="card align-middle text-center">
						  <div class="card-header align-middle">
						    <h5>${aptNameLocCon.apt_name}</h5>
						  </div>
						  <div class="card-body" style="height:200px">
						  <table class="table table-sm">
							  <tbody>
							    <tr>
							      <th scope="row">아파트명</th>
							      <td colspan=3>${aptNameLocCon.apt_name} 아파트</td>
							    </tr>
							    <tr>
							      <th scope="row">동/가</th>
							      <td colspan=3>${aptNameLocCon.apt_dong_ga}</td>
							    </tr>
							    <tr>
							      <th scope="row">지번</th>
							      <td colspan=3>${aptNameLocCon.apt_jibun}</td>
							    </tr>
			        			<tr>
				        		  <th scope="row">건축년도</th>
				        		  <td colspan=3>${aptNameLocCon.apt_con_year}</td>
			        			</tr>
							  </tbody>
							</table>
						  </div>
						</div>
        			</div>
        		`;
        		$("#slide_inner").append(str);
        	}); // end of each 
        } // end of makeSlide

        // 지도에 마커와 인포윈도우를 표시하는 함수입니다
        function displayMarker(locPosition, message) {
          // 마커를 생성합니다
          var marker = new kakao.maps.Marker({
            map: map,
            position: locPosition,
          });

          var iwContent = message, // 인포윈도우에 표시할 내용
            iwRemoveable = true;

          // 인포윈도우를 생성합니다
          var infowindow = new kakao.maps.InfoWindow({
            content: iwContent,
            removable: iwRemoveable,
          });

          // 인포윈도우를 마커위에 표시합니다
          infowindow.open(map, marker);

          // 지도 중심좌표를 접속위치로 변경합니다
          map.setCenter(locPosition);
        }
        
        function makeMarker(list){
        	var positions = [];
        	$(list).each(function(index, info){
        		let addInfo = {
        			"apt_name": info.apt_name,
        			"latlng": new kakao.maps.LatLng(info.lat, info.lng)
        		};
        		positions.push(addInfo);
        	});
        	
//        	var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
        	var imageSrc = "../img/home.png"; 
        	
        	for (var i = 0; i < positions.length; i ++) {
        		
        		// 마커 이미지의 이미지 크기 입니다
        		var imageSize = new kakao.maps.Size(32, 32); 
        		
        		// 마커 이미지를 생성합니다    
        		var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
        		
        		// 마커를 생성합니다
        		var marker = new kakao.maps.Marker({
        			map: map, // 마커를 표시할 지도
        			position: positions[i].latlng, // 마커를 표시할 위치
        			title : positions[i].apt_name, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        			image : markerImage // 마커 이미지 
        		});
        		
        	} // end of for positions
        	 
        } // end of makeMarker
        
        // dropdown의 동이 변경되면 다시 실행.
        
        
        // 리뷰 순 정렬
        
        
        
        
        
      }); // end of document function







