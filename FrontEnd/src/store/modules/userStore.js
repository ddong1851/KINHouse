import { login, getUserLikedList } from "@/api/user.js";
import {
  getAuthFromCookie,
  getUserFromCookie,
  getUserNameFromCookie,
  saveAuthToCookie,
  saveUserToCookie,
  saveUserNameToCookie,
  clearAllCookies,
} from "@/utils/cookies";

const userStore = {
  namespaced: true,
  state: {
    registerUser: false,
    token: getAuthFromCookie() || "",
    id: getUserFromCookie() || "",
    name: getUserNameFromCookie() || "",
    liked_list: [],
  },
  getters: {
    isLogin(state) {
      return state.token !== "";
    },
    isAdmin(state) {
      if (state.id === "admin") return true;
      return false;
    },
    getUserId(state) {
      return state.id;
    },
    getUserName(state) {
      return state.name;
    },
    getToken(state) {
      return state.token;
    },
    getLikedList(state) {
      return state.liked_list;
    },
  },
  mutations: {
    SET_TOKEN(state, token) {
      state.token = token;
    },
    SET_ID(state, id) {
      state.id = id;
    },
    SET_NAME(state, name) {
      state.name = name;
    },
    SET_LIKED(state, list) {
      state.liked_list = list;
    },
    REMOVE_TOKEN(state) {
      state.token = "";
    },
    REMOVE_ID(state) {
      state.id = "";
    },
    REMOVE_NICKNAME(state) {
      state.name = "";
    },
    REMOVE_ALL(state) {
      state.token = "";
      state.name = "";
      state.id = "";
      state.liked_list = [];
    },
  },
  actions: {
    async userlogin({ commit }, user) {
      await login(
        user,
        ({ data }) => {
          if (data.message === "success") {
            clearAllCookies();
            commit("REMOVE_ALL");
            commit("SET_TOKEN", data.token);
            commit("SET_ID", data.id);
            commit("SET_NAME", data.name);
            commit("SET_LIKED", data.liked);

            saveAuthToCookie(data.token);
            saveUserToCookie(data.id);
            saveUserNameToCookie(data.name);
          }
        },
        () => {}
      );
    },
    logout({ commit }) {
      commit("REMOVE_ALL");
      clearAllCookies();
    },
    getLikedList({ commit }) {
      getUserLikedList(getUserFromCookie(), ({ data }) => {
        commit("SET_LIKED", data);
      });
    },
  },
};

export default userStore;
