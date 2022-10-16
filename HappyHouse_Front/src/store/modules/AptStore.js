//import http from "@/api/http";
import { eventBus } from "@/main";
import http from "@/api/http";

const aptStore = {
  namespaced: true,
  state: {
    sidos: [{ value: null, text: "시도 선택" }],
    guguns: [{ value: null, text: "구군 선택" }],
    dongs: [{ value: null, text: "읍면동 선택" }],
    apts: [],
    apt: null,
    apts_like: null,
    apts_like_origin: null,
  },

  getters: {},

  mutations: {
    CLEAR_SIDO_LIST: (state) => {
      state.sidos = [{ value: null, text: "시도 선택" }];
      state.apt = null;
    },
    CLEAR_GUGUN_LIST: (state) => {
      state.guguns = [{ value: null, text: "구군 선택" }];
      state.apt = null;
    },
    CLEAR_DONG_LIST: (state) => {
      state.dongs = [{ value: null, text: "읍면동 선택" }];
      state.apt = null;
    },
    CLEAR_APT_LIST: (state) => {
      state.apts = null;
    },
    CLEAR_APT_DETAIL: (state) => {
      state.apt = null;
    },
    SET_SIDO_LIST: (state, sidos) => {
      sidos.forEach((sido) => {
        state.sidos.push({ value: sido.sidoCode, text: sido.sidoName });
      });
    },
    SET_GUGUN_LIST: (state, guguns) => {
      guguns.forEach((gugun) => {
        state.guguns.push({ value: gugun.gugunCode, text: gugun.gugunName });
      });
    },
    SET_DONG_LIST: (state, dongs) => {
      dongs.forEach((dong) => {
        state.dongs.push({ value: dong.dongCode, text: dong.dongName });
      });
    },
    SET_APT_LIST(state, apts) {
      state.apts = apts;
      eventBus.$emit("test");
    },
    SET_APT_DETAIL(state, apt) {
      state.apt = apt;
      //  console.log(apt);
    },
    SET_APT_LIKE(state, apts) {
      state.apts_like.push(apts.item);
      state.apts_like_origin.push(apts);
      const arrDup = state.apts_like;
      const map = new Map();
      for (const character of arrDup) {
        map.set(JSON.stringify(character), character); // name, company가 모두 같은 객체 요소는 제외한 맵 생성
      }
      state.apts_like = [...map.values()];

      const arrDup2 = state.apts_like_origin;
      const map2 = new Map();
      for (const character of arrDup2) {
        map2.set(JSON.stringify(character), character); // name, company가 모두 같은 객체 요소는 제외한 맵 생성
      }
      state.apts_like_origin = [...map2.values()];
    },
    CLEAR_APT_LIKE: (state) => {
      state.apts_like = [];
      state.apts_like_origin = [];
    },
  },

  actions: {
    getSido: ({ commit }) => {
      http.get("/map/sido").then(({ data }) => {
        commit("SET_SIDO_LIST", data);
      });
    },
    getGugun({ commit }, sidoCode) {
      const params = { sido: sidoCode };
      http
        .get(`/map/gugun`, { params })
        .then(({ data }) => {
          // console.log(commit, response);
          commit("SET_GUGUN_LIST", data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getDong({ commit }, gugunCode) {
      const params = { gugun: gugunCode };
      http
        .get(`/map/dong`, { params })
        .then(({ data }) => {
          commit("SET_DONG_LIST", data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getAptList({ commit }, data) {
      const params = data;
      //  const params = { dong: dongCode, year: year };
      http
        .get(`/map/apt`, { params })
        .then(({ data }) => {
          commit("SET_APT_LIST", data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getAptDetail({ commit }, data) {
      //  console.log(data);
      commit("SET_APT_DETAIL", data);
    },
    getAptLike({ commit }, data) {
      commit("CLEAR_APT_LIKE");
      for (let i = 0; i < data.length; i++) {
        commit("SET_APT_LIKE", data[i]);
      }
    },
  },
};

export default aptStore;
