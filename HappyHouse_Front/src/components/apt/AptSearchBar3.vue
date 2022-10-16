<template>
  <div>
    <!--  <div id="map"></div> -->
    <b-row class="mt-4 mb-4 text-center">
      <b-col class="sm-3">
        <b-form-select
          v-model="sidoCode"
          :options="sidos"
          @change="gugunList"
        ></b-form-select>
      </b-col>
      <b-col class="sm-3">
        <b-form-select
          v-model="gugunCode"
          :options="guguns"
          @change="dongList"
        ></b-form-select>
      </b-col>
      <b-col class="sm-3">
        <b-form-select v-model="dongCode" :options="dongs"></b-form-select>
      </b-col>
    </b-row>
    <b-row class="mt-4 mb-4">
      <b-col sm="2">
        <b-form-select v-model="year" :options="yearList"></b-form-select>
      </b-col>

      <b-col sm="3">
        <b-form-input
          v-model="min"
          ref="min"
          placeholder="최소(만원)"
        ></b-form-input>
      </b-col>
      ~
      <b-col sm="3">
        <b-form-input
          v-model="max"
          ref="max"
          placeholder="최대(만원)"
        ></b-form-input>
      </b-col>
      <b-button
        class="btn bg-gradient-info w-auto me-2"
        @click="searchApt"
        variant="outline-primary"
        >검색</b-button
      >
    </b-row>
  </div>
</template>

<script>
/* eslint-disable */
import { mapState, mapActions, mapMutations } from "vuex";
import { eventBus } from "@/main";
/*
  namespaced: true를 사용했기 때문에 선언해줍니다.
  index.js 에서 modules 객체의 '키' 이름입니다.

  modules: {
    키: 값
    memberStore: memberStore,
    houseStore: houseStore
  }
*/
const aptStore = "aptStore";

export default {
  name: "AptSearchBar",
  data() {
    return {
      yearList: [{ value: null, text: "년도 선택" }],
      year: null,
      sidoCode: null,
      gugunCode: null,
      dongCode: null,
      min: null,
      max: null,
    };
  },
  filters: {
    money: function (value) {
      return `${value} 원`;
    },
  },
  computed: {
    ...mapState(aptStore, ["sidos", "guguns", "dongs", "apts"]),
  },
  created() {
    this.CLEAR_SIDO_LIST();
    this.CLEAR_GUGUN_LIST();
    this.CLEAR_DONG_LIST();
    this.CLEAR_APT_LIST();
    this.getSido();
    const nowYear = new Date().getFullYear();
    for (let i = 0; i < 8; i++) {
      let date = nowYear - i;
      this.yearList.push({ value: date, text: date });
    }
  },

  methods: {
    ...mapActions(aptStore, ["getSido", "getGugun", "getDong", "getAptList"]),
    ...mapMutations(aptStore, [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
      "CLEAR_APT_LIST",
      "CLEAR_APT_DETAIL",
    ]),

    gugunList() {
      this.CLEAR_GUGUN_LIST();
      this.CLEAR_DONG_LIST();
      this.gugunCode = null;
      this.dongCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    dongList() {
      this.CLEAR_DONG_LIST();
      this.dongCode = null;
      if (this.gugunCode) this.getDong(this.gugunCode);
    },
    searchApt() {
      const params = {
        dong: this.dongCode,
        year: this.year,
        minPrice: this.min,
        maxPrice: this.max,
      };
      if (this.dongCode) this.getAptList(params);
      this.CLEAR_APT_DETAIL();
      // setTimeout(() => {
      //   console.log("1");
      //   this.aptinfo = this.apts;
      //   console.log(this.aptinfo);
      //   this.displayMarker(this.aptinfo);
      // }, 100);
      // setTimeout(() => {
      //   eventBus.$emit("test");
      // }, 100);
    },
  },
};
</script>

<style scoped>
#map {
  width: 100%;
  height: 400px;
}
</style>
