import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

import userStore from "@/store/modules/userStore";
import houseStore from "@/store/modules/houseStore";
import communityStore from "@/store/modules/communityStore";
import homeStore from "./modules/homeStore";

const store = new Vuex.Store({
  modules: {
    userStore,
    houseStore,
    communityStore,
    homeStore,
  },
  plugins: [
    createPersistedState({
      storage: sessionStorage,
    }),
  ],
});

export default store;
