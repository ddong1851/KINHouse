<template>
  <div class="team-card">
    <img src="@/assets/dong.jpg" class="team-img" />
    <div class="team-card-body">
      <div class="team-card-detail detail-name">김인태</div>
      <div class="team-card-detail" id="detail-email1" @click="copyEmail">
        kit938639@ssafy.com
      </div>
      <div class="team-card-detail">SSAFY 7기 17반</div>
    </div>

    <b-tooltip target="detail-email1" title="click to copy"></b-tooltip>
  </div>
</template>

<script>
export default {
  methods: {
    copyEmail() {
      navigator.clipboard.writeText("kit938639@ssafy.com");
    },
  },
};
</script>

<style scoped>
.team-card {
  margin-top: 10px;
  height: 300px;
}
.team-img {
  display: flex;
  justify-content: center;
  text-align: center;
  overflow: hidden;
  width: 260px;
  height: 180px;
  margin: 0px auto;
  transition: all 0.1s linear;
}
.team-img:hover {
  transform: scale(1.05);
}
.team-card-detail {
  width: 260px;
  margin: 4px auto;
  text-align: left;
  padding-left: 2px;
}
.detail-name {
  font-size: 20px;
  font-weight: 500;
}
#detail-email1:hover {
  cursor: pointer;
}
</style>
