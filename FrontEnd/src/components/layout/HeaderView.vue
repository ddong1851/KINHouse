<template>
  <b-navbar class="my-nav" type="light" variant="light">
    <!-- <b-navbar-brand href="#">
      <router-link to="/" class="logo">
        <img src="@/assets/logo.png" height="20px" />
      </router-link>
    </b-navbar-brand> -->
    <b-collapse id="nav-collapse" is-nav>
      <!-- left navigation -->
      <b-navbar-nav>
        <b-nav-item :to="{ name: 'home' }" active class="font-strong"
          >KIN 집</b-nav-item
        >
        <b-nav-item-dropdown text="커뮤니티" class="font-strong">
          <b-dropdown-item href="#" class="font-strong" :to="{ name: 'notice' }"
            >공지사항</b-dropdown-item
          >
          <b-dropdown-item href="#" class="font-strong" :to="{ name: 'qna' }"
            >Q&A</b-dropdown-item
          >
        </b-nav-item-dropdown>
        <b-nav-item href="#" class="font-strong" :to="{ name: 'house' }"
          >아파트 둘러보기</b-nav-item
        >
      </b-navbar-nav>
      <!-- right navigation-->
      <b-navbar-nav class="ml-auto">
        <!-- before login -->
        <b-button-group v-if="!isLogin">
          <b-button
            pill
            variant="outline-success"
            class="user-btn"
            size="sm"
            :to="{ name: 'login' }"
            >로그인</b-button
          >
          <b-button
            pill
            variant="outline-primary"
            class="user-btn"
            size="sm"
            :to="{ name: 'user-regist' }"
            >회원가입</b-button
          >
        </b-button-group>
        <!-- right navigation after login -->
        <b-button-group v-else>
          <b-button
            pill
            variant="outline-success"
            class="user-btn"
            size="sm"
            @click="userlogout()"
            >로그아웃</b-button
          >
          <b-button
            pill
            variant="outline-primary"
            class="user-btn"
            size="sm"
            style="width: auto"
            :to="{ name: 'user-info', params: { id: getUserId } }"
            >{{ getUserId }}님</b-button
          >
          <b-button
            pill
            variant="outline-danger"
            class="user-btn"
            size="sm"
            :to="{ name: 'user-list' }"
            v-if="isAdmin"
            >회원관리</b-button
          >
        </b-button-group>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
const userStore = "userStore";

export default {
  computed: {
    ...mapGetters(userStore, ["isLogin", "isAdmin", "getUserId"]),
  },
  methods: {
    ...mapActions(userStore, ["logout"]),
    userlogout() {
      this.logout();
      this.$router.push({ name: "home" }).catch(() => {});
    },
  },
};
</script>

<style scoped>
.my-nav {
  height: 40px;
  line-height: 40px;
  position: sticky;
  top: 0;
}
.user-btn {
  margin: 3px;
  width: 80px;
}
.font-strong {
  font-weight: bold;
}
* {
  font-size: small;
}
</style>
