<template>
  <div>
    <pre></pre>
    <pre></pre>
    <pre></pre>
    <pre></pre>
    <pre></pre>
    <b-row class="mb-1">
      <b-col class="text-right" style="margin-bottom: 1px">
        <b-button @click="boardRegist()">글쓰기</b-button>
      </b-col>
    </b-row>
    <b-table
      class="styled-table"
      striped
      hover
      :items="items"
      :per-page="perPage"
      :current-page="currentPage"
      :fields="fields"
      @row-clicked="rowClick"
    ></b-table>
    <b-pagination
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      align="center"
    ></b-pagination>
  </div>
</template>

<script>
import http from "@/api/http";
export default {
  data() {
    return {
      items: [],
      fields: [
        {
          key: "boardId",
          label: "번호",
        },
        {
          key: "title",
          label: "제목",
        },
        {
          key: "userId",
          label: "글쓴이",
        },
        {
          key: "regtime",
          label: "작성일",
        },
      ],
      currentPage: 1, // 현재 페이지
      perPage: 10, // 페이지당 보여줄 갯수
    };
  },
  created() {
    http.get("/board").then(({ data }) => {
      this.items = data;
    });
  },
  computed: {
    rows() {
      return this.items.length;
    },
  },
  methods: {
    boardRegist() {
      this.$router.push({ name: "boardRegist" });
    },
    rowClick(item) {
      this.$router.push(`/board/detail/${item.boardId}`);
    },
  },
};
</script>
<style>
.styled-table {
  border-collapse: collapse;
  margin-bottom: 30px;
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
