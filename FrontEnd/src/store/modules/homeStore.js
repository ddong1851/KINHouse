import { getLocalList, getHotList } from "@/api/home";

const homeStore = {
  namespaced: true,
  state: {
    local_list: [],
    hot_list: [],
  },
  getters: {
    getlocal(state) {
      return state.local_list;
    },
    setHotList(state) {
      return state.hot_list;
    },
  },
  mutations: {
    SET_LOCAL_LIST(state, data) {
      state.local_list = data;
    },
    SET_HOT_LIST(state, list) {
      state.hot_list = list;
    },
  },
  actions: {
    initStates({ commit }) {
      if (!("geolocation" in navigator)) {
        const map = {
          lat: 37.5012743,
          lng: 127.039585,
        };
        getLocalList(
          map,
          ({ data }) => {
            commit("SET_LOCAL_LIST", data);
          },
          () => {}
        );
      } else {
        navigator.geolocation.getCurrentPosition(
          (pos) => {
            const map = {
              lat: pos.coords.latitude,
              lng: pos.coords.longitude,
            };
            getLocalList(
              map,
              ({ data }) => {
                commit("SET_LOCAL_LIST", data);
              },
              () => {}
            );
          },
          () => {}
        );
      }
    },
    setHotList({ commit }) {
      getHotList(
        ({ data }) => {
          commit("SET_HOT_LIST", data);
        },
        () => {}
      );
    },
  },
};

export default homeStore;
