<template>
  <div class="qnaform mx-auto">
    <b-form @submit.prevent="regist">
      <b-form-group label="제목" label-for="title">
        <b-form-input
          id="title"
          v-model="title"
          type="text"
          placeholder="제목"
          required
        ></b-form-input>
      </b-form-group>
      <b-form-group label="내용" label-for="content">
        <b-form-textarea
          id="content"
          v-model="content"
          placeholder="내용을 입력하세요..."
          rows="8"
          max-rows="15"
          required
        ></b-form-textarea>
      </b-form-group>
      <b-button class="qna-button" type="submit" variant="success"
        >등 록</b-button
      >
      <b-button class="qna-button" type="submit" variant="danger" @click="reset"
        >초기화</b-button
      >
    </b-form>
  </div>
</template>

<script>
import Swal from "sweetalert2";
import { register } from "@/api/qna.js";
import { mapGetters } from "vuex";
const userStore = "userStore";
export default {
  name: "QnaRegister",
  data() {
    return {
      title: "",
      content: "",
    };
  },
  computed: {
    ...mapGetters(userStore, ["getUserId", "isLogin"]),
  },
  methods: {
    reset() {
      if (confirm("초기화 하시겠습니까?")) {
        this.title = "";
        this.content = "";
      }
    },
    async regist() {
      if (!this.isLogin) {
        Swal.fire({
          position: "center",
          width: 350,
          title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">로그인 후에 이용해주세요.<div>`,
          showConfirmButton: false,
          timer: 1500,
        });

        this.$router.push({ name: "login" });
        return;
      }
      try {
        const qna = {
          title: this.title,
          content: this.content,
          userid: this.getUserId,
        };

        await register(qna);

        Swal.fire({
          position: "center",
          icon: "success",
          width: 350,
          title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">등록 완료<div>`,
          showConfirmButton: false,
          timer: 1500,
        });
        this.$router.replace({ name: "qna" });
      } catch (error) {
        alert(error);
      }
    },
  },
};
</script>

<style scoped>
.qnaform {
  margin: auto;
  padding: 60px;
  border: 2px solid gainsboro;
  border-radius: 3px;
}
.qna-button {
  width: 100px;
  margin-right: 5px;
}
</style>
