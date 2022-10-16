<template>
  <b-container class="bv-example-row mt-3 text-center">
    <h3 class="underline-orange">
      <b-icon icon="house-fill"></b-icon> Apt View
    </h3>
    <b-row>
      <b-col>
        <apt-search-bar></apt-search-bar>
      </b-col>
    </b-row>
    <ka-kao-map></ka-kao-map>
    <b-row>
      <b-col cols="8" align="left">
        <apt-list></apt-list>
      </b-col>
      <b-col cols="4">
        <apt-detail></apt-detail>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapState } from "vuex";

const aptStore = "aptStore";
import AptSearchBar from "@/components/apt/AptSearchBar.vue";
import AptList from "@/components/apt/AptList.vue";
import KaKaoMap from "@/components/apt/KaKaoMap.vue";
import AptDetail from "@/components/apt/AptDetail.vue";

export default {
  name: "AptView",
  components: {
    AptSearchBar,
    AptList,
    KaKaoMap,
    AptDetail,
  },
  KaKaoMaped: {
    ...mapState(aptStore, ["apts"]),
  },
};
</script>

<style></style>
