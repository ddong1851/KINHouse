<template>
  <b-container fluid>
    <h4>주변 매물</h4>
    <b-carousel
      id="carousel-1"
      v-model="slide"
      :interval="4000"
      controls
      indicators
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >
      <b-carousel-slide v-for="n in 4" :key="n" img-blank style="height: 300px">
        <home-local-slide :n="n"></home-local-slide>
      </b-carousel-slide>
    </b-carousel>
  </b-container>
</template>

<script>
import HomeLocalSlide from "./HomeLocalSlide.vue";
export default {
  components: { HomeLocalSlide },
  name: "HomeLocalContent",
  data() {
    return {
      slide: 0,
      sliding: null,
    };
  },
  methods: {
    onSlideStart() {
      this.sliding = true;
    },
    onSlideEnd() {
      this.sliding = false;
    },
  },
};
</script>

<style scoped>
#carousel-1 {
  margin-left: 70px;
  margin-right: 70px;
}
</style>
