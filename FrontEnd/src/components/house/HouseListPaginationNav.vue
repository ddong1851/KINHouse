<template>
  <b-container v-if="houses && houses.length != 0" class="overflow-auto">
    <b-pagination
      v-model="currentPage"
      @page-click="pageClick"
      :number-of-pages="10"
      :total-rows="getTotalCount"
      limit="10"
    ></b-pagination>
  </b-container>
</template>

<script>
import { mapActions, mapGetters, mapState } from "vuex";
const houseStore = "houseStore";
const userStore = "userStore";
export default {
  name: "HouseListPaginationNav",
  data() {
    return {
      // currentPage: 1,
    };
  },
  methods: {
    ...mapActions(houseStore, [
      "getHouseList",
      "getHouseListIsLogin",
      "findByAddress",
      "findByAddressIsLogin",
    ]),
    async pageClick(button, page) {
      if (this.isLogin) {
        if (this.bcode !== "") {
          let params = {
            bcode: this.bcode,
            pg: page,
            userId: this.id,
          };
          await this.findByAddressIsLogin(params);
        } else {
          let params = {
            key: this.getKey,
            word: this.getWord,
            s: this.getS,
            pg: page,
            userId: this.id,
          };
          await this.getHouseListIsLogin(params);
        }
      } else {
        if (this.bcode !== "") {
          let params = {
            bcode: this.bcode,
            pg: page,
          };
          await this.findByAddress(params);
        } else {
          let params = {
            key: this.getKey,
            word: this.getWord,
            s: this.getS,
            pg: page,
          };
          await this.getHouseList(params);
        }
      }
    },
  },
  computed: {
    ...mapGetters(houseStore, ["getKey", "getWord", "getS", "getTotalCount"]),
    ...mapState(houseStore, ["houses", "bcode", "currentPage"]),
    ...mapGetters(userStore, ["isLogin"]),
    ...mapState(userStore, ["id"]),
  },
};
</script>

<style></style>
