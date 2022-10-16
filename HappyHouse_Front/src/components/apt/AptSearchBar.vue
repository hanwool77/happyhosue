<template>
  <section class="py-4 min-vh-70">
    <pre></pre>
    <pre></pre>
    <div class="container-fluid">
      <div class="row justify-space-between py-2 min-vh-65">
        <div class="mx-auto">
          <div class="card shadow-lg mt-4">
            <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
              <a class="d-block blur-shadow-image">
                <img
                  src="../../../public/assets/img/city.jpg"
                  alt="img-blur-shadow"
                  class="img-fluid shadow border-radius-lg"
                />
              </a>
            </div>
            <div class="card-body vh-70">
              <h4>Happy House</h4>
              <p>
                검색하고자 하는 지역을 선택하고 "검색" 버튼을 눌러주세요! 필요에
                따라서 년도와 금액대를 지정해서 검색해 주세요. &#128640;
              </p>
              <div class="select w-100">
                <select v-model="sidoCode" :options="sidos" @change="gugunList">
                  <option
                    v-for="(item, index) in sidos"
                    :key="index"
                    :value="item['value']"
                    @change="gugunList"
                  >
                    {{ item["text"] }}
                  </option>
                </select>
              </div>
              <div>
                <div class="select w-45 float-left">
                  <select
                    v-model="gugunCode"
                    :options="guguns"
                    @change="dongList"
                  >
                    <option
                      v-for="(item, index) in guguns"
                      :key="index"
                      :value="item['value']"
                      @change="dongList"
                    >
                      {{ item["text"] }}
                    </option>
                  </select>
                </div>
                <div class="select w-45 float-right">
                  <select v-model="dongCode" :options="dongs">
                    <option
                      v-for="(item, index) in dongs"
                      :key="index"
                      :value="item['value']"
                    >
                      {{ item["text"] }}
                    </option>
                  </select>
                </div>
              </div>
              <div class="select w-100">
                <select v-model="year" :options="yearList">
                  <option
                    v-for="(item, index) in yearList"
                    :key="index"
                    :value="item['value']"
                  >
                    {{ item["text"] }}
                  </option>
                </select>
              </div>
              <div style="margin-bottom: 11px">
                <div class="input-group input-group-static w-45 float-left">
                  <input
                    class="form-control"
                    style="border: none; font-size: small"
                    placeholder="최소(만원)"
                    v-model="min"
                    ref="min"
                  />
                </div>
                <div class="input-group input-group-static w-45 float-right">
                  <input
                    class="form-control"
                    style="border: none; font-size: small"
                    placeholder="최대(만원)"
                    v-model="max"
                    ref="max"
                  />
                </div>
              </div>
              <b-button
                class="btn w-auto me-2"
                @click="searchApt"
                variant="outline-primary"
                style="
                  margin-top: 11px;
                  background-color: rgb(98, 118, 139);
                  color: #ffffff;
                "
                >검색</b-button
              >
              <router-link class="text-primary icon-move-right" to="/aptlike"
                >My favorite House
                <i class="fas fa-arrow-right ms-1" aria-hidden="true"> </i
              ></router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
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
  width: 100px;
  height: 400px;
}
:root {
  /* --background-gradient: linear-gradient(30deg, #f39c12 30%, #f1c40f); */
  --gray: #6e88a1;
  --darkgray: #6e88a1;
}

select {
  /* Reset Select */
  appearance: none;
  outline: 0;
  border: 0;
  box-shadow: none;
  /* Personalize */
  flex: 1;
  padding: 0 1em;
  color: #fff;
  /* background-color: var(--darkgray); */
  background-color: #34495e;
  background-image: none;
  cursor: pointer;
}
/* Remove IE arrow */
select::-ms-expand {
  display: none;
}
/* Custom Select wrapper */
.select {
  position: relative;
  display: flex;
  width: 18em;
  height: 3em;
  border-radius: 0.4em;
  background-color: #34495e;
  overflow: hidden;
  margin-bottom: 0.5em;
}
/* Arrow */
.select::after {
  content: "\25BC";
  position: absolute;
  top: 0;
  right: 0;
  padding: 1em;
  background-color: #34495e;
  transition: 0.25s all ease;
  pointer-events: none;
}
/* Transition */
.select:hover::after {
  color: #f39c12;
}

/* Other styles*/
body {
  color: #fff;
  background: var(--background-gradient);
}
h1 {
  margin: 0 0 0.25em;
}
a {
  font-weight: bold;
  color: var(--gray);
  text-decoration: none;
  padding: 0.25em;
  border-radius: 0.25em;
  /* background: white; */
}
</style>
