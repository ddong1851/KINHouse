<template>
  <div class="registform mx-auto">
    <b-form>
      <b-form-group id="input-group-1" label="ID" label-for="id">
        <b-form-input
          id="id"
          v-model="user.id"
          type="text"
          required
          disabled
        ></b-form-input>
      </b-form-group>
      <b-form-group id="input-group-2" label="Password" label-for="password">
        <b-form-input
          id="password"
          v-model="user.password"
          type="password"
          placeholder="비밀번호를 입력하세요"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group id="input-group-3" label="Email" label-for="email">
        <b-form-input
          id="email"
          v-model="user.email"
          type="email"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group id="input-group-4" label="Name" label-for="name">
        <b-form-input
          id="name"
          v-model="user.name"
          type="text"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group id="input-group-5" label="Phone Number" label-for="phone">
        <b-form-input
          id="phone"
          v-model="user.phone"
          type="text"
          required
        ></b-form-input>
      </b-form-group>
      <b-button
        class="regist-button"
        type="submit"
        variant="outline-warning"
        @click="modify"
        >수정</b-button
      >
      <b-button
        class="regist-button"
        type="submit"
        variant="outline-danger"
        @click="dropUser"
        >탈퇴</b-button
      >
    </b-form>
  </div>
</template>

<script>
import Swal from "sweetalert2";
import { mapActions, mapGetters } from "vuex";
import { modifyUser, deleteUser, findById } from "@/api/user.js";
const userStore = "userStore";
export default {
  name: "UserRegistForm",
  data() {
    return {
      user: [],
    };
  },
  computed: {
    ...mapGetters(userStore, ["getUserId", "isLogin"]),
  },
  created() {
    if (this.isLogin) {
      findById(this.getUserId, (response) => {
        console.log(response.data.userInfo);
        this.user = response.data.userInfo;
      });
    } else {
      Swal.fire({
        icon: "error",
        title: "비회원",
        text: "로그인이 필요합니다!",
      });
      this.$router.push({ name: "login" });
    }
  },
  methods: {
    ...mapActions(userStore, ["logout"]),
    modify() {
      modifyUser(this.user).then(({ data }) => {
        console.log(data);
      });
      Swal.fire({
        position: "center",
        icon: "success",
        width: 350,
        title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">수정 완료<div>`,
        showConfirmButton: false,
        timer: 1500,
      });
      this.$router.push({ name: "home" });
    },
    dropUser() {
      if (confirm("정말 탈퇴하시겠습니까?")) {
        deleteUser(
          this.user.id,
          ({ data }) => {
            console.log(data);
          },
          () => {}
        );
        Swal.fire({
          position: "center",
          icon: "success",
          width: 350,
          title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">이용해주셔서 감사합니다.<div>`,
          showConfirmButton: false,
          timer: 1500,
        });

        this.logout();
        this.$router.push({ name: "home" });
      }
    },
  },
};
</script>

<style scoped>
.registform {
  margin: auto;
  padding: 60px;
  max-width: 600px;
  border: 2px solid gainsboro;
  border-radius: 3px;
}
.regist-button {
  margin-right: 3px;
}
</style>
