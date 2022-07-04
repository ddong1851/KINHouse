<template>
  <b-container style="margin-top: 200px">
    <login-form />
  </b-container>
</template>

<script>
import LoginForm from "@/components/user/LoginForm.vue";

export default {
  name: "LoginView",
  components: {
    LoginForm,
  },
};
</script>

<style></style>
