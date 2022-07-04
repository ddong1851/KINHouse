<template>
  <b-container class="slides">
    <div v-for="i in 3" :key="i" class="slide-items">
      <div class="slide-img">
        <img
          :src="img_path[hot_list[(n - 1) * 3 + (i - 1)].img_num]"
          alt="homeImg"
        />
      </div>
      <div class="slide-text">
        <p>{{ hot_list[(n - 1) * 3 + (i - 1)].apartmentName }}</p>
        <p>{{ hot_list[(n - 1) * 3 + (i - 1)].dong }}</p>
        <p>
          <b-icon
            icon="lightning-charge-fill"
            variant="warning"
            v-if="hot_list[(n - 1) * 3 + (i - 1)].cnt > 10"
          ></b-icon
          >관심 등록 {{ hot_list[(n - 1) * 3 + (i - 1)].cnt }}
        </p>
      </div>
    </div>
  </b-container>
</template>

<script>
import { mapState } from "vuex";
const homeStore = "homeStore";
export default {
  name: "HomeHotSlide",
  props: {
    n: Number,
  },
  data() {
    return {
      img_path: [
        require("@/assets/home1.jpg"),
        require("@/assets/home2.jpeg"),
        require("@/assets/home3.jpg"),
        require("@/assets/home4.jpg"),
        require("@/assets/home5.jpg"),
        require("@/assets/home6.jpg"),
        require("@/assets/home7.jpg"),
        require("@/assets/home8.jpg"),
        require("@/assets/home9.jpg"),
        require("@/assets/home10.jpg"),
      ],
    };
  },
  computed: {
    ...mapState(homeStore, ["hot_list"]),
  },
};
</script>

<style scoped>
.slides {
  display: flex;
  justify-content: center;
}
.slide-img {
  display: flex;
  justify-content: center;
  text-align: center;
  overflow: hidden;
  width: 260px;
  height: 180px;
  margin: 0px auto;
  transition: all 0.1s linear;
}
.slide-img:hover {
  transform: scale(1.05);
}

.slide-items {
  overflow: hidden;
  width: 260px;
  margin: 0 10px;
  cursor: pointer;
}
.slide-text {
  text-align: left;
}
.slide-text > p {
  margin: 0;
  color: black;
}

@media screen and (max-width: 1000px) {
  .slide-img {
    width: 240px;
  }
}
</style>
