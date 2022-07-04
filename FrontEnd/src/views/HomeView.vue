<template>
  <b-container
    fluid
    class="bv-example-row mt-3 text-center"
    style="margin-bottom: 100px"
  >
    <home-header></home-header>
    <home-hot-content></home-hot-content>
    <div style="height: 20px"></div>
    <home-local-content></home-local-content>
    <div class="footer-fixed">
      <b-button
        v-b-tooltip.hover
        id="footer-btn"
        size="sm"
        @click="moveToContact"
        ><b-icon icon="info-circle-fill" variant="info"></b-icon
      ></b-button>
      <b-tooltip target="footer-btn" title="Contact Us"></b-tooltip>
    </div>
  </b-container>
</template>

<script>
import HomeHeader from "@/components/home/HomeHeader.vue";
import HomeHotContent from "@/components/home/HomeHotContent.vue";
import HomeLocalContent from "@/components/home/HomeLocalContent.vue";
import { mapActions } from "vuex";

const homeStore = "homeStore";
export default {
  name: "HomeView",
  components: {
    HomeHeader,
    HomeHotContent,
    HomeLocalContent,
  },
  data() {
    return {
      latitude: "",
      longitude: "",
      show_modal: false,
    };
  },
  created() {
    this.initLocalList();
  },
  methods: {
    ...mapActions(homeStore, ["initStates"]),
    initLocalList() {
      this.initStates();
    },
    moveToContact() {
      this.$router.push("/contact");
    },
  },
};
</script>

<style scoped>
.footer-fixed {
  position: sticky;
  bottom: 20px;
}

#footer-btn {
  margin-left: 95%;
  background-color: white;
  border: 0;
  border-radius: 40%;
}
</style>
