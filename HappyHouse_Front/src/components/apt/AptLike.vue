<template>
  <b-container class="bv-example-row mt-3 col-10 text-center">
    <pre></pre>
    <pre></pre>
    <pre></pre>
    <pre></pre>
    <ka-kao-map></ka-kao-map>
    <b-container class="mt-3">
      <b-row>
        <b-col cols="6" align="left">
          <div class="overflow-auto">
            <b-table
              class="styled-table"
              id="my-table"
              :items="apts_like"
              :per-page="perPage"
              :current-page="currentPage"
              :fields="fields"
              small
              @row-clicked="rowClick"
            >
              <template #cell(like)="data">
                <input
                  :value="data"
                  type="checkbox"
                  v-model="likes"
                  @change="add()"
                />
              </template>
            </b-table>

            <b-pagination
              class="pagination"
              v-model="currentPage"
              :total-rows="rows"
              :per-page="perPage"
              aria-controls="my-table"
              align="center"
            ></b-pagination>
          </div>
        </b-col>
        <b-col cols="6">
          <apt-detail></apt-detail>
        </b-col>
      </b-row>
    </b-container>
  </b-container>
</template>

<script>
import { mapActions, mapMutations, mapState } from "vuex";
import { eventBus } from "@/main";
import KaKaoMap from "@/components/apt/KaKaoMap.vue";

import AptDetail from "@/components/apt/AptDetail.vue";
const aptStore = "aptStore";

export default {
  components: { KaKaoMap, AptDetail },
  name: "AptLike",
  component: {
    KaKaoMap,
    AptDetail,
  },
  data() {
    return {
      likes: [],
      perPage: 3,
      currentPage: 1,
      fields: [
        {
          key: "apartmentName",
          label: "아파트명",
        },
        {
          key: "dealAmount",
          label: "가격(만원)",
          sortable: true,
        },
        {
          key: "dealYear",
          label: "거래연도",
        },
        {
          key: "like",
          label: "관심사항",
        },
      ],
    };
  },
  created() {
    this.likes = this.apts_like_origin;
  },
  computed: {
    ...mapState(aptStore, ["apts_like", "apts_like_origin"]),
    rows() {
      return this.apts_like.length;
    },
  },
  methods: {
    ...mapActions(aptStore, ["getAptLike", "getAptDetail"]),
    ...mapMutations(aptStore, ["CLEAR_APT_DETAIL"]),
    add() {
      const arrDup = this.likes;
      const map = new Map();
      for (const character of arrDup) {
        map.set(JSON.stringify(character), character); // name, company가 모두 같은 객체 요소는 제외한 맵 생성
      }
      this.likes = [...map.values()];
      this.getAptLike(this.likes);
      eventBus.$emit("like");
      this.CLEAR_APT_DETAIL();
    },
    rowClick(item) {
      console.log(item);
      this.getAptDetail(item);
      //eventBus.$emit("detail");
    },
  },
};
</script>

<style>
.styled-table {
  border-collapse: collapse;
  margin: 25px 0;
  font-size: 0.9em;
  font-family: sans-serif;
  /* min-width: 400px; */
  box-shadow: 0 0 20px rgba(255, 255, 255, 0.15);
  text-align: center;
}

.styled-table thead tr {
  background-color: #34495e;
  color: #ffffff;
  text-align: center;
}

.styled-table tbody tr td {
  color: #000000;
  text-align: center;
}

.styled-table th,
.styled-table td {
  padding: 12px 15px;
}

.styled-table tbody tr {
  border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
  background-color: #f3f3f3;
  font-family: sans-serif;
  text-align: center;
}

.styled-table tbody tr:last-of-type {
  border-bottom: 2px solid #34495e;
}

.styled-table tbody tr.active-row {
  font-weight: bold;
  color: #34495e;
}

.page-item.active .page-link {
  z-index: 3;
  color: #fff;
  background-color: #34495e;
  border-color: #34495e;
}
</style>
