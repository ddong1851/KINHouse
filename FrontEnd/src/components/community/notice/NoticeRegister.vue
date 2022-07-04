<template>
  <div class="notice-form mx-auto">
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
      <b-button class="notice-button" type="submit" variant="success"
        >등 록</b-button
      >
      <b-button
        class="notice-button"
        type="submit"
        variant="danger"
        @click="reset"
        >초기화</b-button
      >
    </b-form>
  </div>
</template>

<script>
import Swal from "sweetalert2";
import { mapGetters } from "vuex";
import { register } from "@/api/notice";

const userStore = "userStore";

export default {
  name: "NoticeRegister",
  data() {
    return {
      title: "",
      content: "",
    };
  },
  computed: {
    ...mapGetters(userStore, ["getUserId", "isAdmin"]),
  },
  methods: {
    reset() {
      if (confirm("초기화 하시겠습니까?")) {
        this.title = "";
        this.content = "";
      }
    },
    async regist() {
      if (!this.isAdmin) {
        alert("관리자가 아니면 이용 불가합니다.");

        this.$router.push({ name: "login" });
        return;
      }
      try {
        const notice = {
          title: this.title,
          content: this.content,
          id: this.getUserId,
        };
        await register(notice);

        Swal.fire({
          position: "center",
          icon: "success",
          width: 350,
          title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">등록 완료<div>`,
          showConfirmButton: false,
          timer: 1500,
        });
      } catch (error) {
        this.$router.push("/404");
      }
      this.$router.push({ name: "notice" });
    },
  },
};
</script>

<style scoped>
.notice-form {
  margin: auto;
  padding: 60px;
  border: 2px solid gainsboro;
  border-radius: 3px;
}
.notice-button {
  width: 100px;
  margin-right: 5px;
}
</style>
