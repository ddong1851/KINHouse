<template>
  <div class="notice-form mx-auto">
    <b-form style="margin-bottom: 60px">
      <b-form-group label="제목" label-for="title">
        <b-form-input
          id="title"
          v-model="notice.title"
          type="text"
          placeholder="제목"
          required
          v-bind:disabled="!isAdmin"
        ></b-form-input>
      </b-form-group>
      <b-form-group label="내용" label-for="content">
        <b-form-textarea
          id="content"
          v-model="notice.content"
          rows="8"
          max-rows="15"
          required
          v-bind:disabled="!isAdmin"
        ></b-form-textarea>
      </b-form-group>
      <b-button
        v-if="isAdmin"
        class="notice-button"
        type="submit"
        variant="danger"
        @click="remove"
        >삭 제</b-button
      >
      <b-button
        v-if="isAdmin"
        class="notice-button"
        type="submit"
        variant="warning"
        @click="modify"
        >수 정</b-button
      >
    </b-form>
  </div>
</template>

<script>
import Swal from "sweetalert2";
import { getListItem, removeItem, modifyItem } from "@/api/notice";
import { mapGetters } from "vuex";

const userStore = "userStore";

export default {
  name: "NoticeDetail",
  data() {
    return {
      notice: {},
    };
  },
  computed: {
    ...mapGetters(userStore, ["isAdmin", "getUserId"]),
  },
  created() {
    getListItem(
      this.$route.params.no,
      ({ data }) => {
        this.notice = data;
      },
      () => {}
    );
  },
  methods: {
    async remove() {
      if (confirm("삭제하시겠습니까?")) {
        try {
          await removeItem(this.$route.params.no);

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
        this.$router.push({ name: "notice" });
        return;
      }
    },
    async modify() {
      this.notice.id = this.getUserId;
      try {
        await modifyItem(this.$route.params.no, this.notice);
      } catch (error) {
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
  float: right;
  width: 100px;
  margin-right: 5px;
}
</style>
