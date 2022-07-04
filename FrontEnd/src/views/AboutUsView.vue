<template>
  <b-container fluid>
    <div class="heading mx-auto text-center">
      <div class="heading-title mx-auto">ABOUT US</div>
    </div>
    <b-container>
      <div class="about-team" style="text-align: center">Team Members</div>
      <b-row text-center>
        <b-col cols="6" class="about-teammate">
          <about-dong></about-dong>
        </b-col>
        <b-col cols="6" class="about-teammate">
          <about-intae />
        </b-col>
      </b-row>
    </b-container>
    <div class="footer-fixed">
      <b-button
        v-b-tooltip.hover
        id="footer-btn"
        size="sm"
        @click="moveToContact"
        ><b-icon icon="info-circle-fill" variant="info"></b-icon
      ></b-button>
    </div>
  </b-container>
</template>

<script>
import AboutDong from "@/components/about/AboutDong.vue";
import AboutIntae from "@/components/about/AboutIntae.vue";
export default {
  components: { AboutDong, AboutIntae },
  methods: {
    moveToContact() {
      this.$router.push("/contact");
    },
  },
};
</script>

<style scoped>
.heading {
  height: 400px;
  line-height: 400px;
  background-image: url("@/assets/heaven2.jpg");
  color: white;
}

.heading-title {
  font-size: 50px;
}

.about-team {
  font-size: 25px;
  margin: 10px;
  /* font-family: sans-serif; */
  font-weight: 600;
}

.about-teammate {
  text-align: center;
}

.footer-fixed {
  position: fixed;
  bottom: 20px;
}

#footer-btn {
  position: fixed;
  bottom: 20px;
  right: 5px;
  background-color: white;
  border: 0;
  border-radius: 40%;
}
</style>
