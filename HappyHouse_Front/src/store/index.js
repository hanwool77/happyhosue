import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

import aptStore from "@/store/modules/AptStore.js";
import boardStore from "@/store/modules/boardStore.js";
import houseStore from "@/store/modules/houseStore.js";
import todoStore from "@/store/modules/todoStore.js";
import memberStore from "@/store/modules/memberStore.js";

const store = new Vuex.Store({
  modules: {
    aptStore,
    memberStore,
    boardStore,
    houseStore,
    todoStore,
  },
  plugins: [
    createPersistedState({
      // 브라우저 종료시 제거하기 위해 localStorage가 아닌 sessionStorage로 변경. (default: localStorage)
      storage: localStorage,
    }),
  ],
});

export default store;
