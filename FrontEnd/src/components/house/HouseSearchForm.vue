<template>
  <b-container fluid>
    <b-row class="mx-0">
      <b-col lg="2">
        <b-form-select v-model="key" :options="wordOptions"></b-form-select>
      </b-col>
      <b-col lg="5">
        <b-form-input v-model="word"></b-form-input>
      </b-col>
      <b-col lg="1">
        <b-button variant="outline-primary" @click="search">검색</b-button>
      </b-col>
      <b-col lg="1">
        <b-button variant="outline-secondary" @click="execDaumPostcode"
          >주소로 찾기</b-button
        >
      </b-col>
      <b-col lg="2" offset-lg="1">
        <b-form-select v-model="s" :options="sortingOptions"></b-form-select>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapMutations, mapActions, mapState, mapGetters } from "vuex";
const houseStore = "houseStore";
const userStore = "userStore";
export default {
  name: "HouseSearchFrom",
  data() {
    return {
      key: null,
      wordOptions: [
        { value: null, text: "검색유형" },
        { value: "apt", text: "아파트 이름" },
        { value: "dong", text: "동이름" },
      ],
      word: "",
      s: null,
      sortingOptions: [
        { value: null, text: "정렬방식" },
        { value: "1", text: "높은가격순" },
        { value: "2", text: "낮은가격순" },
        { value: "3", text: "최신 건물 순" },
        { value: "4", text: "오래된 건물 순" },
      ],
    };
  },
  methods: {
    ...mapMutations(houseStore, ["SET_S"]),
    ...mapActions(houseStore, [
      "getHouseList",
      "getHouseListIsLogin",
      "findByAddress",
      "findByAddressIsLogin",
    ]),
    search() {
      let params;
      if (this.isLogin) {
        params = {
          s: this.s,
          key: this.key,
          word: this.word,
          userId: this.id,
          pg: 1,
        };
        // console.log(params);
        this.getHouseListIsLogin(params);
      } else {
        params = {
          s: this.s,
          key: this.key,
          word: this.word,
          pg: 1,
        };
        this.getHouseList(params);
      }
    },
    execDaumPostcode() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          console.log(data);
          if (this.isLogin) {
            let params = {
              bcode: data.bcode,
              pg: 1,
              userId: this.id,
            };
            this.findByAddressIsLogin(params);
          } else {
            let params = {
              bcode: data.bcode,
              pg: 1,
            };
            this.findByAddress(params);
          }
        },
      }).open();
    },
  },
  computed: {
    ...mapGetters(userStore, ["isLogin"]),
    ...mapState(userStore, ["id"]),
  },
};
</script>

<style></style>
