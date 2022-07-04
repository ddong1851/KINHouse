<template>
  <div id="app">
    <header-view></header-view>
    <router-view style="padding: 0px; min-height: 1000px" />
    <footer-view />
  </div>
</template>

<script>
import HeaderView from "@/components/layout/HeaderView.vue";
import FooterView from "./components/layout/FooterView.vue";

export default {
  components: {
    HeaderView,
    FooterView,
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Nanum+Brush+Script&family=Nanum+Gothic&display=swap");
@import url("https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@600&display=swap");
#app {
  font-family: "Nanum Brush Script", cursive;
  font-family: "Nanum Gothic", sans-serif;
  font-family: "Noto Serif KR", serifKR;
}
</style>
