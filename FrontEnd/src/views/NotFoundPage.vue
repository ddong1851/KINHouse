<template>
  <div class="thispage">
    <div class="inner-bg">
      <div class="inner-text mx-auto ml-auto text-center">
        <div class="inner-title">404 NOT FOUND</div>
        <b-button variant="outline-dark" class="inner-btn" @click="home"
          >HOME</b-button
        >
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    home() {
      this.$router.replace("/");
    },
  },
};
</script>

<style scoped>
.thispage {
  margin: 0;
  padding: 0;
  height: 1000px;
  max-height: 100%;
}

.inner-bg {
  border: 0;
  padding: 0;
  min-height: 100%;
  background-image: linear-gradient(black, darkgray, white);
}

.inner-text {
  padding-top: 25%;
}

.inner-title {
  font-size: 60px;
  font-weight: 1000;
}

.inner-btn {
  width: 490px;
  height: 60px;
  font-size: 30px;
  font-weight: 1000;
}
</style>
