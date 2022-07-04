<template>
  <b-row
    class="m-1 list-item"
    @click="selectHouse"
    @mouseover="colorChange(true)"
    @mouseout="colorChange(false)"
    :class="{ 'mouse-over-bgcolor': isColor }"
  >
    <b-col cols="2" class="text-center align-self-center">
      <b-img
        thumbnail
        src="https://picsum.photos/250/250/?image=58"
        alt="Image 1"
      ></b-img>
    </b-col>
    <b-col cols="8" class="align-self-center">
      [{{ house.apartmentName }}] {{ house.dong }} {{ house.jibun }}
      {{ house.buildYear }}년 {{ house.dealAmount }}
    </b-col>
    <b-col v-if="isLogin" cols="2" class="align-self-center">
      <b-button
        v-if="house.userCheckNo == 0 && house.userId == null"
        @click="addLike"
        class="heart-btn"
      >
        <img src="@/assets/heart_empty.png" style="width: 30px; height: 30px" />
      </b-button>
      <b-button v-else @click="removeLike" class="heart-btn">
        <img src="@/assets/heart_fill.png" style="width: 30px; height: 30px" />
      </b-button>
    </b-col>
  </b-row>
</template>

<script>
import { mapActions, mapGetters, mapState } from "vuex";
const userStore = "userStore";
const houseStore = "houseStore";
export default {
  name: "HouseListItem",
  data() {
    return {
      isColor: false,
    };
  },
  props: {
    house: Object,
  },
  methods: {
    ...mapActions(houseStore, [
      "detailHouse",
      "addUserLike",
      "removeUserLike",
      "getHouseListIsLogin",
      "findByAddressIsLogin",
    ]),
    selectHouse() {
      this.detailHouse(this.house);
    },
    colorChange(flag) {
      this.isColor = flag;
    },
    async addLike() {
      // this.detailHouse(this.house);
      let like_data = {
        userId: this.id,
        aptCode: this.house.aptCode,
        no: this.house.no,
        apartmentName: this.house.apartmentName,
      };
      await this.addUserLike(like_data);
      if (this.bcode) {
        let params = {
          bcode: this.bcode,
          pg: this.currentPage,
          userId: this.id,
        };
        await this.findByAddressIsLogin(params);
      } else {
        let params = {
          s: this.s,
          key: this.key,
          word: this.word,
          userId: this.id,
          pg: this.currentPage,
        };
        await this.getHouseListIsLogin(params);
      }
    },
    async removeLike() {
      let like_data = {
        userId: this.id,
        no: this.house.no,
      };
      await this.removeUserLike(like_data);
      if (this.bcode) {
        let params = {
          bcode: this.bcode,
          pg: this.currentPage,
          userId: this.id,
        };
        await this.findByAddressIsLogin(params);
      } else {
        let params = {
          s: this.s,
          key: this.key,
          word: this.word,
          userId: this.id,
          pg: this.currentPage,
        };
        await this.getHouseListIsLogin(params);
      }
    },
  },
  computed: {
    ...mapGetters(userStore, ["isLogin"]),
    ...mapState(userStore, ["id", "houses"]),
    ...mapState(houseStore, ["key", "word", "s", "currentPage", "bcode"]),
  },
};
</script>

<style scope>
.list-item {
  height: 80px;
  border-top-color: #dadadb;
  border-top-style: solid;
}
.heart-btn {
  color: #fff;
  background-color: #fff;
  border-color: #fff;
  transition: all 0.2s linear;
}
.heart-btn:hover {
  color: #fff;
  background-color: #fff;
  border-color: #fff;
  transform: scale(1.3);
}
</style>
