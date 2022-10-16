<template>
  <div>
    <b-jumbotron>
      <h3>{{ board.title }}</h3>

      <h6>작성자: {{ board.userId }}, 작성 시간: {{ board.regtime }}</h6>

      <hr class="my-4" />

      <p>{{ board.content }}</p>

      <b-button type="submit" variant="primary" class="m-1" @click="modifyBoard"
        >글수정</b-button
      >
      <b-button type="reset" variant="danger" class="m-1" @click="deleteBoard"
        >글삭제</b-button
      >
    </b-jumbotron>
  </div>
</template>

<script>
import http from "@/api/http";
export default {
  data() {
    return {
      board: {},
    };
  },
  created() {
    http.get(`board/detail/${this.$route.params.boardId}`).then(({ data }) => {
      this.board = data;
    });
  },
  methods: {
    modifyBoard() {
      this.$router.push(`/board/modify/${this.board.boardId}`);
    },
    deleteBoard() {
      if (confirm("정말로 삭제하시겠습니까?")) {
        this.$router.push(`/board/delete/${this.board.boardId}`);
      }
    },
  },
};
</script>

<style></style>
