function regist() {
  let id = document.getElementById("id").value;
  let password = document.getElementById("password").value;
  let name = document.getElementById("name").value;
  let email = document.getElementById("email").value;
  let tel = document.getElementById("tel").value;

  console.log("ID :" + id);
  console.log("Password :" + password);
  console.log("이름 :" + name);
  console.log("이메일 :" + email);
  console.log("전화번호 :" + tel);

  if (!id || !password || !name || !email || !tel) {
    alert("빈칸이 없도록 입력해주세요.");
    return;
  } else {
    const user = {
      id: id,
      password: password,
      name: name,
      email: email,
      tel: tel
    };
    localStorage.removeItem("user");
    for (i = 0; i < localStorage.length; i++) {
      const userdata = JSON.parse(localStorage.getItem(i));
      if (userdata.id === id) {
        alert("이미 사용중인 ID입니다.");
        return;
      }   
    }
    localStorage.setItem(localStorage.length, JSON.stringify(user));
    console.log("회원가입 완료")
    alert("회원가입이 완료되었습니다.");
    window.location.replace("login.html");
  }
}

function regist2() {
  const num = localStorage.getItem("user");
  if (num == null) {
    alert("로그인이 필요합니다.")
    return;
  }
  let id = document.getElementById("id").value;
  let password = document.getElementById("password").value;
  let name = document.getElementById("name").value;
  let email = document.getElementById("email").value;
  let tel = document.getElementById("tel").value;

  var check = confirm(
    "아이디 : " + id + '\n' +
    "비밀번호 : " + password + '\n' +
    "이름 : " + name + '\n' +
    "이메일 : " + email + '\n' +
    "전화번호 : " + tel + '\n' +
    "입력하신 정보가 맞습니까 ? (빈칸일 시 변경 안함)");
  
  var user = JSON.parse(localStorage.getItem(num));

  for (var i = 0; i < localStorage.length-1; i++) {
    const userinfo = JSON.parse(localStorage.getItem(i));
    if (userinfo.id === id) {
      alert("이미 사용중인 ID입니다.");
      return;
    }   
  }

  if (check) {
    if (id != '') {
      user.id = id;
    }
    if (password != '') {
      user.password = password;
    }
    if (name != '') {
      user.name = name;
    }
    if (email != '') {
      user.email = email;
    }
    if (tel != '') {
      user.tel = tel;
    }
    localStorage.setItem(num, JSON.stringify(user));
    alert("수정이 완료되었습니다.");
  } else {
    alert("취소되었습니다.");
  }
}

function findPass() {
  let id = document.getElementById("id").value;
  let name = document.getElementById("name").value;
  let tel = document.getElementById("tel").value;

  if (!id || !name || !tel) {
    alert("아이디 이름 전화번호를 모두 입력해주세요");
    return;
  }
  localStorage.removeItem("user");
  for (var i = 0; i < localStorage.length; i++) {
    const userinfo = JSON.parse(localStorage.getItem(i));
    if (userinfo.id === id) {
      if (userinfo.name === name && userinfo.tel === tel) {
        var newPass = prompt("비밀번호를 재설정 합니다.", "");
        var newPass2 = prompt("비밀번호확인.", "");
        if (newPass === newPass2) {
          userinfo.password = newPass;
          localStorage.setItem(i, JSON.stringify(userinfo));
          alert("비밀번호 변경이 완료되었습니다.");
          location.replace("login.html");
          return;
        } else {
          alert("비밀번호가 일치하지 않습니다.");
          return;
        }
      }
    }   
  }
  alert("입력된 정보를 찾을 수 없습니다.")
}

function login() {
  let id = document.getElementById("id").value;
  let password = document.getElementById("password").value;
  console.log("ID : " + id)
  console.log("Password : " + password )

  if (id == '') {
    alert("아이디를 입력해주세요.");
    return;
  }
  if (password == '') {
    alert("비밀번호를 입력해주세요.");
    return;
  }
  localStorage.removeItem("user");
  for (i = 0; i < localStorage.length; i++) {
    const user = JSON.parse(localStorage.getItem(i));
    if (user.id && user.password && user.id === id && user.password === password) {
      console.log("login")
      alert("로그인 되었습니다.");
      localStorage.setItem("user", i);
      window.location.replace("Main.html");
      return;
    }
  }
  alert("아이디와 비밀번호를 확인해주세요.");
}

function check() {
  let num = localStorage.getItem("user");
  if (num == null) {
    alert("로그인이 필요합니다.")
    return;
  }
  const user = JSON.parse(localStorage.getItem(num));
  alert(
    "아이디 : " + user.id + '\n' +
    "비밀번호 : " + user.password + '\n' +
    "이름 : " + user.name + '\n' +
    "이메일 : " + user.email + '\n' +
    "전화번호 : " + user.tel
  )
}

function userRemove() {
  let num = localStorage.getItem("user");
  if (num == null) {
    alert("로그인이 필요합니다.")
    return;
  }
  var removeConfilm = confirm("정말로 탈퇴하시겠습니까?");

  if (removeConfilm) {
    logout();
    localStorage.setItem(num, localStorage.getItem(localStorage.length - 1));
    localStorage.removeItem(localStorage.length - 1);
    alert("회원탈퇴가 완료되었습니다. 이용해 주셔서 감사합니다.");
  } else {
    alert("취소되었습니다.");
  }
}

function logout() {
  localStorage.removeItem("user");
  console.log("logout")
  alert("로그아웃 되었습니다.");
  location.href = "Main.html";
}
