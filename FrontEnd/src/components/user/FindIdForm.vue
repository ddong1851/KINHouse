<template>
  <b-form @submit.prevent="onSubmit">
    <b-form-group label="Email address:" description="이메일을 입력해주세요...">
      <b-form-input
        v-model="user.email"
        type="email"
        placeholder="Enter email"
        required
      ></b-form-input>
    </b-form-group>

    <b-form-group label="Your Name:">
      <b-form-input
        v-model="user.name"
        placeholder="Enter name"
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
        <span v-if="id !== ''">ID: {{ id }}</span>
        <span v-else>아이디 조회 실패!!</span>
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
import { findId } from "@/api/user.js";
export default {
  name: "FindIdForm",
  data() {
    return {
      user: {
        email: "",
        name: "",
      },
      id: "",
      show: false,
    };
  },
  methods: {
    onSubmit() {
      if (this.user.email && this.user.name) {
        findId(
          this.user,
          ({ data }) => {
            this.id = data;
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
