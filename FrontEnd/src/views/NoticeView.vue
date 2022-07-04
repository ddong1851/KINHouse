<template>
  <b-container>
    <notice-header />
    <router-view />
  </b-container>
</template>

<script>
import NoticeHeader from "@/components/community/notice/NoticeHeader.vue";
export default {
  name: "NoticeView",
  components: {
    NoticeHeader,
  },
};
</script>

<style></style>
