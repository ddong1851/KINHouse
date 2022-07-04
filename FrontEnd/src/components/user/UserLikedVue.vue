<template>
  <b-list-group class="liked-view" v-if="list_exist">
    <b-list-group-item
      button
      v-for="liked in liked_list"
      :key="liked.id"
      @click="view(liked)"
      >{{ liked.apartmentName }}</b-list-group-item
    >
  </b-list-group>
  <b-row v-else class="mx-auto text-center">
    <b-col></b-col>
    <b-col>
      <b-button variant="outline-primary" @click="moveApt" class="mx-auto">
        지금 등록하기!</b-button
      >
    </b-col>
    <b-col class="m-auto">
      <b-button
        style="float: right"
        size="sm"
        variant="outline-success"
        @click="initList"
      >
        <b-icon icon="arrow-counterclockwise"></b-icon>
      </b-button>
    </b-col>
  </b-row>
</template>

<script>
import Swal from "sweetalert2";
import { mapActions, mapState } from "vuex";
import { deleteUserLikedItem } from "@/api/user";
const userStore = "userStore";
export default {
  name: "UserLiked",
  computed: {
    ...mapState(userStore, ["liked_list"]),
    list_exist() {
      if (this.liked_list.length == 0) {
        return false;
      }
      return true;
    },
  },
  mounted() {
    this.getLikedList();
  },
  methods: {
    ...mapActions(userStore, ["getLikedList"]),
    moveApt() {
      this.$router.push({ name: "house" });
    },
    async initList() {
      await this.getLikedList();
    },
    view(liked) {
      Swal.fire({
        title: liked.apartmentName,
        html:
          `건축년도: ${liked.buildYear} </br> ` +
          `법정동: ${liked.dong} </br>` +
          `도로명 주소: ${liked.roadName}`,
        imageUrl: "https://unsplash.it/400/200",
        imageWidth: 400,
        imageHeight: 200,
        imageAlt: "Custom image",
        showCancelButton: true,
        confirmButtonColor: "#d33",
        cancelButtonColor: "#3085d6",
        confirmButtonText: "delete",
      }).then((result) => {
        if (result.isConfirmed) {
          // 해당 Item 삭제
          deleteUserLikedItem(liked.id, ({ data }) => {
            if (data === "success") this.initList();
          });

          Swal.fire("Deleted!", "Your file has been deleted.", "success");
        }
      });
    },
  },
};
</script>

<style scoped>
.liked-view {
  margin: auto;
  padding: 60px;
  max-width: 600px;
  border: 2px solid gainsboro;
  border-radius: 3px;
}
</style>
