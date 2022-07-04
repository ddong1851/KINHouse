<template>
  <b-container fluid class="mt-3">
    <b-container fluid>
      <house-search-form></house-search-form>
    </b-container>
    <b-container fluid>
      <b-container fluid>
        <b-row>
          <b-col lg="4" class="mt-3">
            <house-list></house-list>
            <house-list-pagination-nav></house-list-pagination-nav>
          </b-col>
          <b-col lg="8">
            <house-map></house-map>
          </b-col>
        </b-row>
      </b-container>
    </b-container>
  </b-container>
</template>

<script>
import HouseSearchForm from "@/components/house/HouseSearchForm.vue";
import HouseList from "@/components/house/HouseList.vue";
import HouseListPaginationNav from "@/components/house/HouseListPaginationNav.vue";
import HouseMap from "@/components/house/HouseMap.vue";
import { mapMutations } from "vuex";

const houseStore = "houseStore";
export default {
  name: "HouseView",
  components: {
    HouseSearchForm,
    HouseList,
    HouseListPaginationNav,
    HouseMap,
  },
  created() {
    this.initHouseList();
  },
  methods: {
    ...mapMutations(houseStore, ["INIT_STATE"]),
    initHouseList() {
      this.INIT_STATE();
    },
  },
};
</script>

<style></style>
