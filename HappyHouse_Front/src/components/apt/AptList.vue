<template>
  <b-container>
    <b-container v-if="apts && apts.length != 0" class="bv-example-row mt-3">
      <b-table
        class="styled-table"
        striped
        hover
        :items="apts"
        :per-page="perPage"
        :current-page="currentPage"
        :fields="fields"
        @row-clicked="rowClick"
      >
        <template #cell(like)="data">
          <input
            :value="data"
            type="checkbox"
            v-model="checkedApt"
            @change="add()"
          />
        </template>
      </b-table>
      <b-pagination
        class="pagination"
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        align="center"
      ></b-pagination>
    </b-container>
    <b-container v-else class="bv-example-row mt-3">
      <b-row>
        <div
          class="alert alert-primary text-white font-weight-bold"
          role="alert"
          show
          align="center"
        >
          주택을 조회해 주세요!
        </div>
      </b-row>
    </b-container>
  </b-container>
</template>

<script>
/* eslint-disable */
import { mapActions, mapMutations, mapState } from "vuex";
import { eventBus } from "@/main";
const aptStore = "aptStore";
export default {
  name: "AptList",
  components: {},
  data() {
    return {
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
      currentPage: 1, // 현재 페이지
      perPage: 8, // 페이지당 보여줄 갯수
      checkedApt: [],
    };
  },
  mounted() {
    this.checkedApt = this.apts_like_origin;
    const arrDup = this.checkedApt;
    const map = new Map();
    for (const character of arrDup) {
      map.set(JSON.stringify(character), character); // name, company가 모두 같은 객체 요소는 제외한 맵 생성
    }
    this.checkedApt = [...map.values()];
  },
  computed: {
    ...mapState(aptStore, ["apts", "apts_like_origin", "apts_like"]),
    rows() {
      return this.apts.length;
    },
  },
  filters: {
    money: function (value) {
      return `${value} 원`;
    },
  },
  methods: {
    ...mapActions(aptStore, ["getAptDetail", "getAptLike"]),
    rowClick(item) {
      this.getAptDetail(item);
      eventBus.$emit("detail");
    },
    add() {
      const arrDup = this.checkedApt;
      const map = new Map();
      for (const character of arrDup) {
        map.set(JSON.stringify(character), character); // name, company가 모두 같은 객체 요소는 제외한 맵 생성
      }
      this.checkedApt = [...map.values()];
      this.getAptLike(this.checkedApt);
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
