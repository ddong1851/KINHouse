<template>
  <b-container>
    <user-list-header @register="register"></user-list-header>
    <b-table-simple hover responsive style="text-align: center">
      <b-thead head-variant="dark">
        <b-tr>
          <b-th>ID</b-th>
          <b-th>EMAIL</b-th>
          <b-th>NAME</b-th>
          <b-th>SELECT</b-th>
        </b-tr>
      </b-thead>
      <b-tbody>
        <user-list-item
          v-for="user in users"
          :key="user.id"
          v-bind="user"
          @viewUser="viewUser"
        ></user-list-item>
      </b-tbody>
    </b-table-simple>
    <b-modal
      id="modal-no-backdrop"
      hide-backdrop
      content-class="shadow"
      title="회원 정보"
      centered
      v-model="show_info_modal"
    >
      <user-info-modal-vue :showuser="showuser"></user-info-modal-vue>
    </b-modal>
  </b-container>
</template>

<script>
import UserListHeader from "@/components/user/UserListHeader.vue";
import UserListItem from "@/components/user/UserListItem.vue";
import UserInfoModalVue from "@/components/user/UserInfoModal.vue";

import { getUserList, findById } from "@/api/user";
export default {
  name: "UserListView",
  data() {
    return {
      users: [],
      showuser: {},
      show_info_modal: false,
    };
  },
  components: {
    UserListHeader,
    UserListItem,
    UserInfoModalVue,
  },
  created() {
    getUserList(
      ({ data }) => {
        this.users = data;
      },
      (error) => {
        alert(error);
      }
    );
  },
  methods: {
    viewUser(id) {
      findById(id, ({ data }) => {
        this.showuser = data.userInfo;
        this.show_info_modal = true;
      });
    },
    register() {
      this.$router.push({ name: "user-regist" });
    },
  },
};
</script>

<style></style>
