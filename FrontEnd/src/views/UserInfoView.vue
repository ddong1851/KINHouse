<template>
  <b-container>
    <div class="user-info-header mx-auto">
      <div class="user-info-header-inner text-center">
        <div class="user-info-header-title">회원 정보 조회</div>
      </div>
    </div>
    <b-tabs class="mx-auto info-nav" justified>
      <b-tab>
        <template #title> 회원 정보 </template>
        <user-info-vue />
      </b-tab>
      <b-tab>
        <template #title> 관심 목록 </template>
        <user-liked-vue />
      </b-tab>
    </b-tabs>
  </b-container>
</template>

<script>
import UserInfoVue from "@/components/user/UserInfoVue.vue";
import UserLikedVue from "@/components/user/UserLikedVue.vue";

export default {
  components: { UserInfoVue, UserLikedVue },
  name: "UserView",
};
</script>

<style scoped>
.info-nav {
  max-width: 600px;
}

.user-info-header {
  max-width: 600px;
  height: 150px;
}

.user-info-header-inner {
  padding-top: 35px;
}
.user-info-header-title {
  font-size: 46px;
  font-weight: 600;
}
</style>
