<template>
  <b-container style="padding: 0px">
    <b-jumbotron style="margin-top: 10px; background-color: white">
      <div class="text-center head-title">Notice</div>
    </b-jumbotron>
    <div class="head-row">
      <b-button
        class="notice-register-button"
        variant="primary"
        @click="register"
        v-if="isAdmin"
        >등록</b-button
      >
    </div>
  </b-container>
</template>

<script>
import { mapGetters } from "vuex";
const userStore = "userStore";
export default {
  name: "NoticeHeader",
  computed: {
    ...mapGetters(userStore, ["isAdmin"]),
  },
  methods: {
    register() {
      this.$router.push({ name: "notice-regist" });
    },
  },
};
</script>

<style scoped>
.notice-register-button {
  float: right;
  width: 100px;
  /* margin-left: 5px; */
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
