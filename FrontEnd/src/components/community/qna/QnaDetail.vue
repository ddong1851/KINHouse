<template>
  <div class="qnaform mx-auto">
    <b-form style="margin-bottom: 60px">
      <b-form-group label="제목" label-for="title">
        <b-form-input
          id="title"
          v-model="qna.title"
          type="text"
          placeholder="제목"
          required
          v-bind:disabled="!isSameUser"
        ></b-form-input>
      </b-form-group>
      <b-form-group label="내용" label-for="content">
        <b-form-textarea
          id="content"
          v-model="qna.content"
          rows="8"
          max-rows="15"
          required
          v-bind:disabled="!isSameUser"
        ></b-form-textarea>
      </b-form-group>
      <b-button
        v-if="isSameUser"
        class="qna-button"
        type="submit"
        variant="danger"
        @click="remove"
        >삭 제</b-button
      >
      <b-button
        v-if="isSameUser"
        class="qna-button"
        type="submit"
        variant="warning"
        @click="modify"
        >수 정</b-button
      >
    </b-form>
    <!-- 답글 List 표시 -->
    <qna-reply-item
      v-for="reply in replys"
      :key="reply.no"
      v-bind="reply"
    ></qna-reply-item>
    <!-- 답글 작성 Form -->
    <b-form @submit.prevent="replySubmit">
      <b-form-group label="답글" label-for="content">
        <b-form-textarea
          id="content"
          v-model="qna_reply.content"
          rows="2"
          max-rows="5"
          required
        ></b-form-textarea>
      </b-form-group>
      <b-button class="qna-button" type="submit" variant="primary"
        >등 록</b-button
      >
    </b-form>
  </div>
</template>

<script>
import Swal from "sweetalert2";
import { mapGetters } from "vuex";
import { getListItem, removeQnaItem, modifyItem } from "@/api/qna.js";
import { submitReply, getReply } from "@/api/reply.js";
import QnaReplyItem from "@/components/community/qna/QnaReplyItem.vue";

const userStore = "userStore";
export default {
  name: "QnaDetail",
  components: { QnaReplyItem },
  data() {
    return {
      qna: {},
      qna_reply: {
        content: "",
        author: "",
        qna_no: 0,
      },
      replys: [],
    };
  },
  computed: {
    ...mapGetters(userStore, ["getUserId", "isLogin"]),
    isSameUser() {
      if (this.getUserId === this.qna.userid) {
        return true;
      }
      return false;
    },
  },
  created() {
    getListItem(
      this.$route.params.no,
      ({ data }) => {
        this.qna = data;
      },
      () => {}
    );
    getReply(
      this.$route.params.no,
      ({ data }) => {
        this.replys = data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {
    async remove() {
      if (confirm("삭제하시겠습니까?")) {
        try {
          await removeQnaItem(this.$route.params.no);

          Swal.fire({
            position: "center",
            width: 350,
            title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">삭제 완료<div>`,
            showConfirmButton: false,
            timer: 1500,
          });
        } catch (error) {
          this.$router.push({ name: "NotFound" });
          return;
        }
        this.$router.push({ name: "qna" });
        return;
      }
    },
    async modify() {
      try {
        await modifyItem(this.$route.params.no, this.qna);
      } catch (err) {
        this.$router.push({ name: "NotFound" });
        return;
      }
      Swal.fire({
        position: "center",
        width: 350,
        title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">수정 완료<div>`,
        showConfirmButton: false,
        timer: 1500,
      });
      this.$router.go();
    },
    async replySubmit() {
      if (!this.isLogin) {
        alert("로그인 후 이용해주세요.");

        this.$router.push({ name: "login" });
        return;
      }
      this.qna_reply.qna_no = this.$route.params.no;
      this.qna_reply.author = this.getUserId;
      await submitReply(this.qna_reply);

      Swal.fire({
        position: "center",
        width: 350,
        title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">등록 완료<div>`,
        showConfirmButton: false,
        timer: 1500,
      });

      this.$router.go();
    },
  },
};
</script>

<style>
.qnaform {
  margin: auto;
  padding: 60px;
  border: 2px solid gainsboro;
  border-radius: 3px;
}
.qna-button {
  float: right;
  width: 100px;
  margin-right: 5px;
}
</style>
