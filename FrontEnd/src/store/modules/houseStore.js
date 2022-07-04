import axios from "axios";

const houseStore = {
  namespaced: true,
  state: {
    houses: [],
    house: null,
    currentPage: "",
    totalPageCount: "",
    totalCount: "",
    key: "",
    word: "",
    s: "",
    housesPosition: [],
    bcode: "",
  },
  getters: {
    getHouses(state) {
      return state.houses;
    },
    getKey(state) {
      return state.key;
    },
    getWord(state) {
      return state.word;
    },
    getS(state) {
      return state.s;
    },
    getHousesPosition(state) {
      return state.housesPosition;
    },
    getTotalCount(state) {
      return state.totalCount;
    },
  },
  mutations: {
    INIT_STATE(state) {
      state.houses = [];
      state.house = null;
      state.currentPage = "";
      state.totalPageCount = "";
      state.totalCount = "";
      state.key = "";
      state.word = "";
      state.s = "";
      state.bcode = "";
    },
    INIT_HOUSES(state) {
      state.houses = [];
    },
    INIT_HOUSESPOSITIONS(state) {
      state.housesPosition = [];
    },
    INIT_BCODE(state) {
      state.bcode = "";
    },
    SET_HOUSES(state, houses) {
      state.houses = houses;
    },
    SET_DETAIL_HOUSE(state, house) {
      state.house = house;
    },
    SET_KEY(state, key) {
      state.key = key;
    },
    SET_WORD(state, word) {
      state.word = word;
    },
    SET_CURRENTPAGE(state, currentPage) {
      state.currentPage = currentPage;
    },
    SET_S(state, s) {
      state.s = s;
    },
    SET_TOTALPAGECOUNT(state, totalPageCount) {
      state.totalPageCount = totalPageCount;
    },
    SET_TOTALCOUNT(state, totalCount) {
      state.totalCount = totalCount;
    },
    SET_HOUSESPOSITIONS(state, houses) {
      state.housesPosition = houses.map((house) => [house.lat, house.lng]);
    },
    SET_BCODE(state, bcode) {
      state.bcode = bcode;
    },
  },
  actions: {
    getHouseList({ commit }, params) {
      commit("INIT_HOUSES");
      commit("INIT_HOUSESPOSITIONS");
      const API_URL = `http://localhost/house/search`;
      axios({
        url: API_URL,
        method: "get",
        params: params,
      })
        .then((res) => {
          commit("SET_HOUSES", res.data.list);
          commit("SET_KEY", res.data.key);
          commit("SET_WORD", res.data.word);
          commit("SET_CURRENTPAGE", res.data.currentPage);
          commit("SET_TOTALPAGECOUNT", res.data.navigation.totalPageCount);
          commit("SET_TOTALCOUNT", res.data.navigation.totalCount);
          commit("SET_HOUSESPOSITIONS", res.data.list);
          commit("INIT_BCODE");
        })
        .catch((error) => {
          alert(error);
        });
    },
    getHouseListIsLogin({ commit }, params) {
      commit("INIT_HOUSES");
      commit("INIT_HOUSESPOSITIONS");
      const API_URL = `http://localhost/house/search/isLogin`;
      axios({
        url: API_URL,
        method: "get",
        params: params,
      })
        .then((res) => {
          commit("SET_HOUSES", res.data.list);
          commit("SET_KEY", res.data.key);
          commit("SET_WORD", res.data.word);
          commit("SET_CURRENTPAGE", res.data.currentPage);
          commit("SET_TOTALPAGECOUNT", res.data.navigation.totalPageCount);
          commit("SET_TOTALCOUNT", res.data.navigation.totalCount);
          commit("SET_HOUSESPOSITIONS", res.data.list);
          commit("INIT_BCODE");
        })
        .catch((error) => {
          alert(error);
        });
    },
    detailHouse({ commit }, house) {
      commit("SET_DETAIL_HOUSE", house);
    },
    addUserLike({ commit }, like_data) {
      console.log(commit);
      const API_URL = `http://localhost/house/liked-apt-code`;
      axios({
        url: API_URL,
        method: "post",
        data: JSON.stringify(like_data),
        headers: {
          "Content-Type": `application/json`,
        },
      }).catch((error) => {
        alert(error);
      });
    },
    removeUserLike({ commit }, like_data) {
      console.log(commit);
      // const API_URL = `http://localhost/house/liked-apt-code/${userId}/${dealno}`;
      const API_URL = `http://localhost/house/liked-apt-code/${like_data.userId}/${like_data.no}`;
      axios({
        url: API_URL,
        method: "delete",
      }).catch((error) => {
        alert(error);
      });
    },
    findByAddress({ commit }, param) {
      const API_URL = `http://localhost/house/findByAddress/${param.bcode}/${param.pg}`;
      axios({
        url: API_URL,
        method: "get",
      })
        .then((res) => {
          commit("SET_HOUSES", res.data.list);
          commit("SET_KEY", res.data.key);
          commit("SET_WORD", res.data.word);
          commit("SET_CURRENTPAGE", res.data.currentPage);
          commit("SET_TOTALPAGECOUNT", res.data.navigation.totalPageCount);
          commit("SET_TOTALCOUNT", res.data.navigation.totalCount);
          commit("SET_HOUSESPOSITIONS", res.data.list);
          commit("SET_BCODE", res.data.list[0].bcode);
        })
        .catch((error) => {
          alert(error);
        });
    },
    findByAddressIsLogin({ commit }, param) {
      const API_URL = `http://localhost/house/findByAddress/${param.bcode}/${param.pg}/${param.userId}`;
      axios({
        url: API_URL,
        method: "get",
      })
        .then((res) => {
          commit("SET_HOUSES", res.data.list);
          commit("SET_KEY", res.data.key);
          commit("SET_WORD", res.data.word);
          commit("SET_CURRENTPAGE", res.data.currentPage);
          commit("SET_TOTALPAGECOUNT", res.data.navigation.totalPageCount);
          commit("SET_TOTALCOUNT", res.data.navigation.totalCount);
          commit("SET_HOUSESPOSITIONS", res.data.list);
          commit("SET_BCODE", res.data.list[0].bcode);
        })
        .catch((error) => {
          alert(error);
        });
    },
  },
};

export default houseStore;
