<template>
  <b-container style="padding: 0px">
    <b-jumbotron style="margin-top: 10px; background-color: white">
      <div class="text-center head-title">Q & A</div>
    </b-jumbotron>
    <div class="head-row">
      <!-- <b-form-select
        v-model="selected"
        :options="options"
        class="qnanavbar"
      ></b-form-select> -->
      <b-button class="qnanavbar" variant="primary" @click="register"
        >등록</b-button
      >
    </div>
  </b-container>
</template>

<script>
import { mapGetters } from "vuex";
const userStore = "userStore";
export default {
  name: "QnaHeader",
  data() {
    return {
      // selected: null,
      // options: [
      //   { value: null, text: "정렬" },
      //   { value: "visited", text: "조회순" },
      //   { value: "resent", text: "최신순" },
      // ],
    };
  },
  computed: {
    ...mapGetters(userStore, ["isLogin"]),
  },
  methods: {
    register() {
      if (!this.isLogin) {
        alert("로그인 후 이용 가능합니다.");

        this.$router.push({ name: "login" });
        return;
      }
      this.$router.push({ name: "qnaRegister" });
    },
  },
};
</script>

<style scoped>
.qnanavbar {
  float: right;
  width: 100px;
  margin-left: 5px;
}
.head-title {
  font-size: 50px;
  font-weight: 800;
}
.head-row {
  height: 50px;
  width: 100%;
}
</style>
