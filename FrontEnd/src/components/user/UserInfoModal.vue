<template>
  <b-container fluid>
    <b-row class="mb-1">
      <b-col cols="4">ID</b-col>
      <b-col>{{ showuser.id }}</b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col cols="4">PASSWORD</b-col>
      <b-col>{{ showuser.password }}</b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col cols="4">NAME</b-col>
      <b-col>{{ showuser.name }}</b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col cols="4">EMAIL</b-col>
      <b-col>{{ showuser.email }}</b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col cols="4">RECENT_LOGIN</b-col>
      <b-col>{{ showuser.login_log }}</b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col cols="4">REGISTER_DATE</b-col>
      <b-col>{{ showuser.register_log }}</b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
  name: "UserInfoView",
  props: {
    showuser: Object,
  },
};
</script>

<style></style>
