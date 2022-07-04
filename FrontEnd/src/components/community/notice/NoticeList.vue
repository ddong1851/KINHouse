<template>
  <b-row>
    <b-col v-if="notices.length">
      <b-table-simple hover responsive>
        <b-thead head-variant="dark">
          <b-tr>
            <b-th colspan="1">글번호</b-th>
            <b-th colspan="6">제목</b-th>
            <b-th colspan="1">조회수</b-th>
            <b-th colspan="2">작성자</b-th>
            <b-th colspan="2">작성일</b-th>
          </b-tr>
        </b-thead>
        <tbody>
          <!-- 하위 component인 ListRow에 데이터 전달(props) -->
          <notice-list-item
            v-for="(notice, index) in notices"
            :key="index"
            v-bind="notice"
            :index="index"
          />
        </tbody>
      </b-table-simple>
    </b-col>
    <b-col v-else class="text-center">공지사항이 없습니다.</b-col>
  </b-row>
</template>

<script>
import NoticeListItem from "@/components/community/notice/NoticeListItem.vue";
import { mapActions, mapGetters, mapState } from "vuex";
const communityStore = "communityStore";
export default {
  name: "NoticeList",
  components: {
    NoticeListItem,
  },
  computed: {
    ...mapGetters(communityStore, ["getNotice"]),
    ...mapState(communityStore, ["notices"]),
  },
  created() {
    this.initList();
  },
  watch: {
    notices: function () {
      this.initList();
    },
  },
  methods: {
    ...mapActions(communityStore, ["getNoticeList"]),
    async initList() {
      await this.getNoticeList();
    },
  },
};
</script>

<style></style>
