<template>
  <b-row>
    <b-col v-if="qnas.length">
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
          <qna-list-item
            v-for="(qna, index) in qnas"
            :key="index"
            v-bind="qna"
            :index="index"
          />
        </tbody>
      </b-table-simple>
    </b-col>
    <b-col v-else class="text-center">QnA가 없습니다.</b-col>
  </b-row>
</template>

<script>
import QnaListItem from "@/components/community/qna/QnaListItem.vue";
import { mapActions, mapGetters, mapState } from "vuex";
const communityStore = "communityStore";

export default {
  name: "QnaList",
  components: {
    QnaListItem,
  },
  computed: {
    ...mapGetters(communityStore, ["getQna"]),
    ...mapState(communityStore, ["qnas"]),
  },
  watch: {
    qnas: function () {
      this.initList();
    },
  },
  created() {
    this.initList();
  },
  methods: {
    ...mapActions(communityStore, ["getQnaList"]),
    async initList() {
      await this.getQnaList();
    },
  },
};
</script>

<style></style>
