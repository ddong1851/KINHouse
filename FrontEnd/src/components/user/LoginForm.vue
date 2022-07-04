<template>
  <div class="loginform mx-auto">
    <b-form @submit.prevent="login">
      <b-form-group id="input-group-1" label="ID" label-for="id">
        <b-form-input
          id="id"
          v-model="user.id"
          type="text"
          placeholder="아이디를 입력하세요"
          required
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
      <b-button class="login-button" type="submit" variant="outline-primary"
        >로그인</b-button
      >
      <b-button
        class="login-button"
        type="submit"
        variant="outline-success"
        @click="moveRegister()"
        >회원가입</b-button
      >
      <b-button
        class="login-button"
        type="reset"
        variant="outline-warning"
        :to="{ name: 'find-id-pass' }"
        >아이디 / 비밀번호 찾기</b-button
      >
    </b-form>
  </div>
</template>

<script>
import Swal from "sweetalert2";
import { getUserFromCookie } from "@/utils/cookies";
import { mapActions, mapGetters } from "vuex";

const userStore = "userStore";

export default {
  name: "LoginForm",
  data() {
    return {
      user: {
        id: getUserFromCookie() || "",
        password: "",
      },
    };
  },
  computed: {
    ...mapGetters(userStore, ["isLogin"]),
  },
  methods: {
    ...mapActions(userStore, ["userlogin"]),
    async login() {
      try {
        await this.userlogin(this.user);
        if (this.isLogin) {
          Swal.fire({
            position: "center",
            icon: "success",
            width: 350,
            title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">로그인 완료<div>`,
            showConfirmButton: false,
            timer: 1500,
          });
          this.$router.replace({ name: "home" });
        } else {
          Swal.fire({
            position: "center",
            icon: "warning",
            width: 350,
            title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">아이디 또는 비밀번호가 일치하지 않습니다.<div>`,
            showConfirmButton: false,
            timer: 1500,
          });
          this.initForm();
        }
      } catch (error) {
        Swal.fire({
          position: "center",
          icon: "warning",
          width: 350,
          title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">다시 시도해주세요.<div>`,
          showConfirmButton: false,
          timer: 1500,
        });
        this.initForm();
      }
    },
    moveRegister() {
      this.$router.push({ name: "user-regist" });
    },
    initForm() {
      this.id = "";
      this.password = "";
    },
  },
};
</script>

<style>
.loginform {
  margin: auto;
  padding: 60px;
  max-width: 600px;
  border: 2px solid gainsboro;
  border-radius: 3px;
}
.login-button {
  margin-right: 3px;
}
</style>
