<template>
  <b-form class="reply-item">
    <label>{{ author }} ({{ dateMsg }})</label>
    <b-button
      size="sm"
      v-show="isAuthUser"
      v-if="!modifyMode"
      class="reply-icons"
      variant="outline-danger"
      @click="removeItem"
    >
      <b-icon icon="x-square"></b-icon>
    </b-button>
    <b-button
      size="sm"
      v-show="isAuthUser"
      v-if="!modifyMode"
      variant="outline-warning"
      class="reply-icons"
      @click="changeMode"
    >
      <b-icon icon="pencil-square"></b-icon>
    </b-button>
    <b-button
      size="sm"
      v-show="isAuthUser"
      v-if="modifyMode"
      variant="outline-primary"
      class="reply-icons"
      @click="modifyItem"
    >
      <b-icon icon="check-square"></b-icon>
    </b-button>
    <div v-if="!modifyMode">{{ content }}</div>
    <b-form-textarea rows="2" v-model="mod_content" ref="mod_text" v-else />
    <!-- content를 띄우면 됨 -->
  </b-form>
</template>

<script>
import Swal from "sweetalert2";
import { mapGetters } from "vuex";
import { deleteReplyItem, modifyReplyItem } from "@/api/reply";
const userStore = "userStore";
export default {
  name: "QnaReplyItem",
  props: {
    author: String,
    content: String,
    regtime: String,
    no: Number,
  },
  data() {
    return {
      dateMsg: "",
      mod_content: "",
      modifyMode: false,
    };
  },
  computed: {
    ...mapGetters(userStore, ["isAdmin", "getUserId", "isLogin"]),
    isAuthUser() {
      if (this.isLogin && (this.isAdmin || this.getUserId === this.author))
        return true;
      return false;
    },
  },
  created() {
    this.dateMsg = this.timeForToday();
  },
  methods: {
    timeForToday() {
      const today = new Date();
      const betweenTime = Math.floor(
        (today.getTime() - (Date.parse(this.regtime) - 32400000)) / 60000
      );

      if (betweenTime < 1) return "방금전";
      if (betweenTime < 60) {
        return `${betweenTime}분전`;
      }

      const betweenTimeHour = Math.floor(betweenTime / 60);
      if (betweenTimeHour < 24) {
        return `${betweenTimeHour}시간전`;
      }

      const betweenTimeDay = Math.floor(betweenTime / 60 / 24);
      if (betweenTimeDay < 365) {
        return `${betweenTimeDay}일전`;
      }

      return `${Math.floor(betweenTimeDay / 365)}년전`;
    },
    async removeItem() {
      if (confirm("정말 삭제하시겠습니까?")) {
        try {
          await deleteReplyItem(this.no);

          Swal.fire({
            position: "center",
            width: 350,
            title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">삭제 완료<div>`,
            showConfirmButton: false,
            timer: 1500,
          });
          this.$router.go();
          return;
        } catch (error) {
          alert(error);
        }
      }
    },
    async modifyItem() {
      if (this.mod_content === "") {
        Swal.fire({
          position: "center",
          width: 350,
          title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">수정할 내용을 작성하세요.<div>`,
          showConfirmButton: false,
          timer: 1500,
        });
        this.$refs.mod_text.focus();
      } else {
        try {
          const reply = {
            content: this.mod_content,
          };
          await modifyReplyItem(this.no, reply);

          Swal.fire({
            position: "center",
            width: 350,
            title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">수정 완료<div>`,
            showConfirmButton: false,
            timer: 1500,
          });
          this.$router.go();
          return;
        } catch (error) {
          alert(error);
        }
      }
    },
    changeMode() {
      this.modifyMode = !this.modifyMode;
    },
  },
};
</script>

<style scoped>
.reply-item {
  margin-bottom: 30px;
}
.reply-icons {
  margin-left: 5px;
  float: right;
  cursor: pointer;
}
</style>
