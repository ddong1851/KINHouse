<template>
  <b-container>
    <b-jumbotron style="background-color: white">
      <div class="text-center head-title">회원 정보 찾기</div>
    </b-jumbotron>
    <b-tabs justified>
      <b-tab>
        <template #title>
          <b-spinner type="grow" small></b-spinner>ID
        </template>
        <!-- Find ID Form -->
        <find-id-form-vue></find-id-form-vue>
      </b-tab>

      <b-tab>
        <template #title>
          <b-spinner type="grow" small></b-spinner>PASSWORD
        </template>
        <!-- Find ID Form -->
        <find-pass-form-vue></find-pass-form-vue>
      </b-tab>
    </b-tabs>
  </b-container>
</template>

<script>
import FindIdFormVue from "@/components/user/FindIdForm.vue";
import FindPassFormVue from "@/components/user/FindPassForm.vue";
export default {
  components: {
    FindIdFormVue,
    FindPassFormVue,
  },
};
</script>

<style scoped>
.head-title {
  font-size: 50px;
  font-weight: 800;
}
</style>
