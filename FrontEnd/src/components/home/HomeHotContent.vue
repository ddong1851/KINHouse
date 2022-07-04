<template>
  <b-container fluid>
    <h4>실시간 인기 매물</h4>
    <b-carousel
      id="carousel-1"
      v-model="slide"
      :interval="4000"
      controls
      indicators
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >
      <b-carousel-slide
        v-for="n in 4"
        :key="n"
        style="height: 300px"
        class="my-carousel-slide"
      >
        <home-hot-slide :n="n"></home-hot-slide>
      </b-carousel-slide>
    </b-carousel>
  </b-container>
</template>
<script>
import { mapActions, mapState } from "vuex";
import HomeHotSlide from "./HomeHotSlide.vue";
const homeStore = "homeStore";
export default {
  name: "HomeHotContent",
  components: {
    HomeHotSlide,
  },
  data() {
    return {
      slide: 0,
      sliding: null,
    };
  },
  methods: {
    ...mapActions(homeStore, ["setHotList"]),
    onSlideStart() {
      this.sliding = true;
    },
    onSlideEnd() {
      this.sliding = false;
    },
    initHotList() {
      console.log("updated");
      setInterval(() => {
        this.getList();
      }, 600000);
    },
    getList() {
      try {
        this.setHotList();
      } catch (error) {
        alert(error);
      }
    },
  },
  mounted() {
    this.initHotList();
  },
  created() {
    this.getList();
  },
  computed: {
    ...mapState(homeStore, ["hot_list"]),
  },
  watch: {},
};
</script>

<style scoped>
.my-carousel-slide > a {
  width: 10%;
}

#carousel-1 {
  margin-left: 70px;
  margin-right: 70px;
}
</style>
