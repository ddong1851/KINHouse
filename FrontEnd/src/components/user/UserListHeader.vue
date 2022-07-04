<template>
  <b-container style="padding: 0px">
    <b-jumbotron style="margin-top: 10px; background-color: white">
      <div class="text-center head-title">회원 관리</div>
    </b-jumbotron>
    <div class="head-row">
      <b-button variant="primary" @click="register" class="list-btn"
        >등록</b-button
      >
      <!-- <b-form-select
        v-model="selected"
        :options="options"
        class="userlist-select"
      ></b-form-select> -->
    </div>
  </b-container>
</template>

<script>
export default {
  name: "UserListHeader",
  data() {
    return {
      // selected: null,
      // options: [
      //   { value: null, text: "정렬" },
      //   { value: "recent_register", text: "가입일 오름차순" },
      //   { value: "late_register", text: "가입일 내림차순" },
      //   { value: "recent_login", text: "로그인 오름차순" },
      //   { value: "late_login", text: "로그인 내림차순" },
      // ],
    };
  },
  methods: {
    register() {
      this.$emit("register");
    },
  },
};
</script>

<style scoped>
.head-title {
  font-size: 50px;
  font-weight: 800;
}
.head-row {
  height: 50px;
  width: 100%;
}
.list-btn {
  float: right;
  width: 100px;
  margin-left: 5px;
}
.userlist-select {
  float: right;
  width: 100px;
  margin-left: 5px;
}
</style>
