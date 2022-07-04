<template>
  <b-tr>
    <b-td>{{ id }}</b-td>
    <b-td>{{ email }}</b-td>
    <b-td>{{ name }}</b-td>
    <b-td>
      <b-button
        class="userlist-btn"
        size="sm"
        variant="success"
        @click="lookUser"
        >조회</b-button
      >
      <b-button
        class="userlist-btn"
        size="sm"
        variant="warning"
        @click="dropUser"
        >삭제</b-button
      >
    </b-td>
  </b-tr>
</template>

<script>
import Swal from "sweetalert2";
import { deleteUser } from "@/api/user";
export default {
  name: "UserListItem",
  props: {
    id: String,
    password: String,
    email: String,
    name: String,
    phone: String,
    login_log: String,
    register_log: String,
  },
  methods: {
    dropUser() {
      Swal.fire({
        title: "회원 탈퇴하시겠습니까?",
        text: `${this.id}님의 정보가 삭제됩니다.`,
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Yes, delete it!",
      }).then((result) => {
        if (result.isConfirmed) {
          deleteUser(this.id);
          Swal.fire("Deleted!", "Your file has been deleted.", "success");

          setTimeout(function () {
            this.$router.go();
          }, 1000);
        }
      });
    },
    lookUser() {
      this.$emit("viewUser", this.id);
    },
  },
};
</script>

<style scoped>
.userlist-btn {
  margin: 0 2px 0;
}
</style>
