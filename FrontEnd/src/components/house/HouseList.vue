<template>
  <b-container
    v-if="houses && houses.length != 0"
    class="bv-example-row mt-3 mb-3"
  >
    <house-list-item
      v-for="(house, index) in houses"
      :key="index"
      :house="house"
    />
  </b-container>
  <b-container v-else class="bv-example-row mt-3">
    <b-row>
      <b-col class="col-lg-12"
        ><b-alert show>검색 결과가 없습니다.</b-alert></b-col
      >
    </b-row>
    <b-row>
      <b-col class="col-lg-12">
        <b-alert show>이런 뉴스 어떠세요?</b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col class="col-lg-12">
        <house-news></house-news>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import HouseListItem from "@/components/house/HouseListItem.vue";
import HouseNews from "@/components/house/HouseNews.vue";

import { mapState } from "vuex";
const houseStore = "houseStore";
export default {
  name: "HouseList",
  components: {
    HouseListItem,
    HouseNews,
  },
  data() {
    return {};
  },
  computed: {
    ...mapState(houseStore, ["houses"]),
  },
};
</script>

<style></style>
