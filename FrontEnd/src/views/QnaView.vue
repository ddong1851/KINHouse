<template>
  <b-container>
    <qna-header />
    <router-view />
  </b-container>
</template>
<script>
import QnaHeader from "@/components/community/qna/QnaHeader.vue";
export default {
  name: "QnaView",
  components: {
    QnaHeader,
  },
};
</script>

<style></style>
