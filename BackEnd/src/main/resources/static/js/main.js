$(function() {
//	// 1 로그인 확인하기
//	let login = localStorage.getItem("user");
//	// 로그인 이전 화면
//	if(!login){
//		$('.nav-login-menu-options:eq(0)').css("display", "");
//		$('.nav-login-menu-options:eq(1)').css("display", "");
//		$('.nav-login-menu-options:eq(2)').css("display", "none");
//		$('.nav-login-menu-options:eq(3)').css("display", "none");
//	} 
//	// 로그인 이후 화면
//	else {
//		$('.nav-login-menu-options:eq(0)').css("display", "none");
//		$('.nav-login-menu-options:eq(1)').css("display", "none");
//		$('.nav-login-menu-options:eq(2)').css("display", "");
//		$('.nav-login-menu-options:eq(3)').css("display", "");
//	}
//	// 회원가입 버튼 클릭 시 이동
//	$('.nav-login-menu-options:eq(0)').on('click', function() {
//		window.location.replace("register.html");
//	});
//	
//	// 로그인 버튼 클릭 시 이동
//	$('.nav-login-menu-options:eq(1)').on('click', function() {
//		window.location.replace("login.html");
//	});
//	
//	// 로그아웃 버튼 클릭 시 이동
//	$('.nav-login-menu-options:eq(2)').on('click', function() {
//		logout();
//	});
//
//	// 회원정보 버튼 클릭 시 이동
//	$('.nav-login-menu-options:eq(3)').on('click', function() {
//		window.location.replace("register2.html");
//	});
//	
	// 선택한 도시정보 저장 
	var selected_city;
	var selected_district;
	var selected_unit;
	$('.dropdown-menu1 div').on('click', function(){
		selected_city = $(this)[0].innerHTML;
		$('.dropdown-div1').text(selected_city);
		console.log(selected_city);
		if (selected_city != null && selected_district != null && selected_unit != null) {
			let cityInfo = {
                "시" : selected_city,
                "구" : selected_district,
                "동" : selected_unit
        	};
        	sessionStorage.setItem("cityInfo", JSON.stringify(cityInfo));
			window.location.replace("houseView.html");
			console.log(selected_city)
		}
	});
	$('.dropdown-menu2 div').on('click', function(){
		selected_district = $(this)[0].innerHTML;
		$('.dropdown-div2').text(selected_district);
		console.log(selected_district);
		if (selected_city != null && selected_district != null && selected_unit != null) {
			let cityInfo = {
                "시" : selected_city,
                "구" : selected_district,
                "동" : selected_unit
        	};
        	sessionStorage.setItem("cityInfo", JSON.stringify(cityInfo));
			window.location.replace("houseView.html");
			console.log(selected_city)
		}
	});
	$('.dropdown-menu3 div').on('click', function(){
		selected_unit = $(this)[0].innerHTML;
		$('.dropdown-div3').text(selected_unit);
		console.log(selected_unit);
		if (selected_city != null && selected_district != null && selected_unit != null) {
			let cityInfo = {
                "시" : selected_city,
                "구" : selected_district,
                "동" : selected_unit
        	};
        	sessionStorage.setItem("cityInfo", JSON.stringify(cityInfo));
			window.location.replace("houseView.html");
			console.log(selected_city)
		}
	});
	
	// 검색 기능
	let search = false;
	$('#search-button').on('click', function() {
		if(!search)	{
			$('#search-form').css('display', "block");
			search = true;
		}
		else {
			let inputValue = $('#search-text').val();
			if(inputValue) console.log("검색한 내용: "+ inputValue);
			else {
				alert("검색할 항목을 입력하세요");
			}
		}
	});
	
})

window.onload = function () {
    if (!document.querySelector(".main-apartsection-left")) return;
    // 비동기 통신을 위해 새로운 xmlhttp 요청 생성
    const xhr = new XMLHttpRequest();
    // 요청 method
    const method = "GET";
    // 파일 위치
    const url = "./data/AptDealHistory.xml";

	let dong = JSON.parse(sessionStorage.getItem("cityInfo"))["동"];

    // 위의 method 와 url 로 비동기 요청 초기화
    xhr.open(method, url);
    // 요청 헤더 설정
    xhr.setRequestHeader("Content-Type", "application/text");
    // 요청 동작 설정
    xhr.onreadystatechange = function () {
        if (xhr.readyState === xhr.DONE) {
            // 요청 상태가 OK 이면
            if (xhr.status === 200) {
                const xml = xhr.responseXML;
                
                var dongs = xml.getElementsByTagName("법정동");
                var name = xml.getElementsByTagName("아파트");
                var buildy = xml.getElementsByTagName("건축년도");
                var cost = xml.getElementsByTagName("거래금액");
                var mm = xml.getElementsByTagName("월");
                var dd = xml.getElementsByTagName("일");
                var area = xml.getElementsByTagName("전용면적");
                //var jiban = xml.getElementsByTagName("지번");
                //var floor = xml.getElementsByTagName("층");
                
                let List = document.querySelector(".main-apartsection-left");
                for (let i = 0; i < dongs.length; i++) {
                    if (dongs[i].childNodes[0].nodeValue.trim() == dong) {
                        var item =`
                        <div class="apt-info" onclick = "">
                            <div class="apt-name"> ${name[i].childNodes[0].nodeValue} </div>
                            <div class="apt-cost"> 거래 금액 : ${cost[i].childNodes[0].nodeValue} </div>
                            <div class="apt-area"> 전용 면적 : ${area[i].childNodes[0].nodeValue} </div>
                            <div class="apt-mmdd"> 2019.${mm[i].childNodes[0].nodeValue}.${dd[i].childNodes[0].nodeValue} </div>
                        </div>`
                        List.innerHTML += item;
                    }
                }
				document.querySelector(".main-apartsection-right").innerHTML += `<img class="apt-img" src = "img/경희궁의아침.jpg" / >`
            }
        }
    };

    // 요청 보내기
    xhr.send();
};
