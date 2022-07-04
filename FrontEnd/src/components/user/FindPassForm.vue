<template>
  <b-form @submit.prevent="onSubmit">
    <b-form-group label="Your Id:">
      <b-form-input
        v-model="user.id"
        placeholder="Enter ID"
        required
      ></b-form-input>
    </b-form-group>

    <b-form-group label="Email Address:">
      <b-form-input
        v-model="user.email"
        placeholder="Enter email"
        type="email"
        required
      ></b-form-input>
    </b-form-group>

    <b-button type="submit" variant="primary" style="width: 80px"
      >찾기</b-button
    >

    <b-modal id="modal-scoped" v-model="show">
      <template #modal-header="{ close }">
        <h5>조회 결과</h5>
        <b-button size="sm" variant="outline-danger" @click="close()">
          Close
        </b-button>
      </template>

      <template>
        <span v-if="password !== ''">비밀번호: {{ password }}</span>
        <span v-else>비밀번호 조회 실패!!</span>
      </template>

      <template #modal-footer="{ ok, cancel }">
        <b-button size="sm" variant="success" @click="ok()"> OK </b-button>
        <b-button size="sm" variant="danger" @click="cancel()">
          Cancel
        </b-button>
      </template>
    </b-modal>
  </b-form>
</template>

<script>
import { findPass } from "@/api/user.js";
export default {
  data() {
    return {
      user: {
        id: "",
        email: "",
      },
      password: "",
      show: false,
    };
  },
  methods: {
    onSubmit() {
      if (this.user.id && this.user.email) {
        findPass(
          this.user,
          ({ data }) => {
            // 결과 창으로 이동
            this.password = data;
          },
          () => {},
          (this.show = !this.show)
        );
      }
    },
  },
};
</script>

<style></style>
