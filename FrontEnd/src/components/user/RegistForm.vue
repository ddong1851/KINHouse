<template>
  <div class="registform mx-auto">
    <b-form @submit.prevent="regist">
      <b-form-group id="input-group-1" label="ID" label-for="id">
        <b-input-group class="mt-3">
          <b-form-input
            id="id"
            v-model="user.id"
            type="text"
            placeholder="아이디를 입력하세요"
            required
          ></b-form-input>
          <b-input-group-append>
            <b-button variant="outline-success" @click="checkDuplicate('id')"
              >중복확인</b-button
            >
          </b-input-group-append>
        </b-input-group>
        <b-form-text>{{ msgId }}</b-form-text>
      </b-form-group>
      <b-form-group id="input-group-3" label="Email" label-for="email">
        <b-input-group class="mt-3">
          <b-form-input
            id="email"
            v-model="user.email"
            type="email"
            placeholder="이메일을 입력하세요"
            required
          ></b-form-input>
          <b-input-group-append>
            <b-button variant="outline-success" @click="checkDuplicate('email')"
              >중복확인</b-button
            >
          </b-input-group-append>
        </b-input-group>
        <b-form-text>{{ msgEmail }}</b-form-text>
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
      <b-form-group id="input-group-4" label="Name" label-for="name">
        <b-form-input
          id="name"
          v-model="user.name"
          type="text"
          placeholder="ex 김동률"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group id="input-group-5" label="Phone Number" label-for="phone">
        <b-form-input
          id="phone"
          v-model="user.phone"
          type="text"
          placeholder="xxx-xxxx-xxxx"
          required
        ></b-form-input>
      </b-form-group>
      <b-button class="regist-button" type="submit" variant="outline-success"
        >회원가입</b-button
      >
      <b-button
        class="regist-button"
        type="reset"
        variant="outline-warning"
        @click="refresh"
        >초기화</b-button
      >
    </b-form>
  </div>
</template>

<script>
import { checkDuplicated, register } from "@/api/user.js";
import { mapGetters } from "vuex";
const userStore = "userStore";
export default {
  name: "UserRegistForm",
  data() {
    return {
      user: {
        id: null,
        password: null,
        email: null,
        name: null,
        phone: null,
      },
      checkEmail: false,
      checkId: false,
      msgEmail: "",
      msgId: "",
    };
  },
  computed: {
    ...mapGetters(userStore, ["isLogin"]),
  },
  methods: {
    async regist() {
      // raw valid check
      if (this.checkId && this.checkEmail) {
        try {
          await register(this.user);

          alert("회원 가입 성공!");
          if (!this.isLogin) {
            this.$router.push({ name: "login" });
          } else {
            this.$router.push({ name: "user-list" });
          }
        } catch (error) {
          alert(error);
        }
      } else {
        alert("ID, EMAIL 중복 확인 요함");
      }
    },
    refresh() {
      this.msgEmail = "";
      this.msgId = "";
    },
    checkDuplicate(checkval) {
      if (checkval === "id") {
        if (this.user.id) {
          // 메서드 실행
          checkDuplicated(
            this.user,
            ({ data }) => {
              if (data === "Y") {
                this.msgId = "아이디가 중복되었습니다.";
                this.checkId = false;
              } else {
                this.msgId = "사용할 수 있는 아이디입니다!";
                this.checkId = true;
              }
            },
            () => {}
          );
        } else {
          alert("아이디를 입력하세요.");
        }
      } else {
        if (this.user.email) {
          // 메서드 실행
          checkDuplicated(
            this.user,
            ({ data }) => {
              if (data === "Y") {
                this.msgEmail = "이메일이 중복되었습니다.";
                this.checkEmail = false;
              } else {
                this.msgEmail = "사용할 수 있는 이메일입니다!";
                this.checkEmail = true;
              }
            },
            () => {}
          );
        } else {
          alert("이메일을 입력하세요.");
        }
      }
    },
  },
};
</script>

<style>
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
