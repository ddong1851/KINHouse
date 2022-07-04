<template>
  <b-tr>
    <b-td colspan="1">{{ index + 1 }}</b-td>
    <b-th class="text-left" colspan="6">
      <router-link :to="{ name: 'notice-detail', params: { no: no } }">{{
        title
      }}</router-link>
    </b-th>
    <b-td colspan="1">{{ hits }}</b-td>
    <b-td colspan="2">{{ id }}</b-td>
    <b-td colspan="2">{{ regtime | dateFormat }}</b-td>
  </b-tr>
</template>

<script>
import moment from "moment";
export default {
  name: "NoticeListItem",
  props: {
    no: Number,
    id: String,
    title: String,
    hits: Number,
    regtime: String,
    index: Number,
  },
  filters: {
    dateFormat(regtime) {
      return moment(new Date(regtime)).format("YY.MM.DD");
    },
  },
};
</script>

<style></style>
