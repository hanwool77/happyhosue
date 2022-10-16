<template>
  <b-row class="mb-1">
    <pre></pre>
    <pre></pre>
    <pre></pre>
    <pre></pre>
    <pre></pre>
    <b-col style="text-align: left">
      <b-form @submit="onSubmit" @reset="onReset">
        <b-form-group
          id="userid-group"
          label="작성자 입력:"
          label-for="userid"
          description="작성자를 입력하세요."
        >
          <b-form-input
            id="userid"
            v-model="board.userid"
            type="text"
            placeholder="작성자 입력.."
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="title-group"
          label="제목:"
          label-for="title"
          description="제목을 입력하세요."
        >
          <b-form-input
            id="title"
            v-model="board.title"
            placeholder="제목 입력.."
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="content-group" label="내용:" label-for="content">
          <b-form-textarea
            id="content"
            v-model="board.content"
            placeholder="내용 입력..."
            rows="10"
            max-rows="15"
            required
          ></b-form-textarea>
        </b-form-group>

        <b-button type="submit" variant="primary" class="m-1">글작성</b-button>
        <b-button type="reset" variant="danger" class="m-1">초기화</b-button>
      </b-form>
    </b-col>
  </b-row>
</template>

<script>
import http from "@/api/http";
export default {
  data() {
    return {
      board: {
        userid: "",
        title: "",
        content: "",
      },
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      this.registBoard();
    },
    onReset(event) {
      event.preventDefault();
    },
    registBoard() {
      http
        .post("/board", {
          userId: this.board.userid,
          title: this.board.title,
          content: this.board.content,
        })
        .then(({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        });
    },
    moveList() {
      this.$router.push({ name: "boardList" });
    },
  },
};
</script>
