import { getList } from "@/api/notice";
import { getQnaList } from "@/api/qna";

const communityStore = {
  namespaced: true,
  state: {
    notices: [],
    qnas: [],
  },
  getters: {
    getNotice(state) {
      return state.notices;
    },
    getQnas(state) {
      return state.qnas;
    },
  },
  mutations: {
    SET_NOTICE_LIST(state, data) {
      state.notices = data;
    },
    SET_QNA_LIST(state, data) {
      state.qnas = data;
    },
  },
  actions: {
    async getNoticeList({ commit }) {
      getList(
        ({ data }) => {
          commit("SET_NOTICE_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    async getQnaList({ commit }) {
      getQnaList(
        ({ data }) => {
          commit("SET_QNA_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default communityStore;
