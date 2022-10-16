<template>
  <b-container class="mt-3 col-10 text-center min-vh-70">
    <b-row>
      <b-col cols="3" align="left">
        <apt-search-bar></apt-search-bar>
      </b-col>
      <b-col cols="9" align="right">
        <div class="min-vh-50">
          <pre></pre>
          <pre></pre>
          <pre></pre>
          <pre></pre>
          <pre></pre>
          <ka-kao-map></ka-kao-map>
        </div>
      </b-col>
    </b-row>
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
import KaKaoMap from "@/components/apt/KaKaoMap.vue";
import AptList from "@/components/apt/AptList.vue";
import AptDetail from "@/components/apt/AptDetail.vue";

export default {
  name: "AptView",
  components: {
    AptSearchBar,
    KaKaoMap,
    AptList,
    AptDetail,
  },
  KaKaoMaped: {
    ...mapState(aptStore, ["apts"]),
  },
};
</script>

<style></style>
