<template>
  <div class="home-heading">
    <div class="home-heading-inner mx-auto">
      <div class="text-center home-heading-inner-subtitle">
        피할 수 없으면 즐겨라
      </div>
      <div class="text-center home-heading-inner-title brush">KIN 家</div>
    </div>
  </div>
</template>
<script>
export default {
  name: "HomeHeader",
};
</script>

<style scoped>
.home-heading {
  height: 600px;
  max-width: 100%;
  min-width: 900px;
  background-image: url("@/assets/heaven2.jpg");
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
  margin-bottom: 30px;
}

.home-heading-inner {
  padding-top: 250px;
  max-width: 1100px;
  min-width: 900px;
  height: 600px;
  margin: 0 auto;
}

.home-heading-inner-title {
  font-size: 60px;
  font-weight: 300;
}

.home-heading-inner-subtitle {
  font-size: 24px;
  /* font-family: ; */
  font-weight: 600;
}

.brush {
  font-family: sans-serif;
}
</style>
