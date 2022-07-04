<template>
  <footer class="footer">
    <div class="footer-top-content">
      <div class="footer-right">
        <div class="footer-right-top">
          <div class="footer-link" @click="toAbout">About Us</div>
        </div>
        <div class="footer-right-bottom">
          <div class="footer-right-bottom-content">
            <div>(SSAFY) 서울시 강남구 테헤란로 멀티스퀘어</div>
          </div>
          <div class="footer-right-bottom-content">
            <div>1544-9001</div>
          </div>
          <div class="footer-right-bottom-content">
            <div>admin@ssafy.com</div>
          </div>
        </div>
      </div>
    </div>
    <div class="footer-bottom-content">
      <div class="footer-botton-content-text">
        Copyright by SSAFY. All rights reserved
      </div>
    </div>
  </footer>
</template>

<script>
export default {
  methods: {
    toAbout() {
      this.$router.push("/about");
    },
  },
};
</script>

<style scoped>
.footer {
  background-color: #fbfbfb;
  position: absolute;
  width: 100%;
  height: 120px;
}

.footer-top-content {
  height: 100px;
  width: 100%;
}

.footer-right {
  float: left;
  height: 100px;
  width: auto;
}

.footer-right-top {
  height: 20px;
  widows: 100%;
  font-size: 18px;
  padding-left: 10px;
}

.footer-right-bottom {
  height: 80px;
  padding: 10px;
}

.footer-link:hover {
  cursor: pointer;
}

.footer-bottom-content {
  height: 20px;
  background-color: #ececec;
}

.footer-botton-content-text {
  text-align: center;
}
</style>
