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
          label="작성자:"
          label-for="userid"
          description="작성자를 입력하세요."
        >
          <b-form-input
            id="userid"
            :disabled="isUserid"
            v-model="board.userId"
            type="text"
            required
            placeholder="작성자 입력..."
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="subject-group"
          label="제목:"
          label-for="subject"
          description="제목을 입력하세요."
        >
          <b-form-input
            id="subject"
            v-model="board.title"
            type="text"
            required
            placeholder="제목 입력..."
          ></b-form-input>
        </b-form-group>

        <b-form-group id="content-group" label="내용:" label-for="content">
          <b-form-textarea
            id="content"
            v-model="board.content"
            placeholder="내용 입력..."
            rows="10"
            max-rows="15"
          ></b-form-textarea>
        </b-form-group>

        <b-button type="submit" variant="primary" class="m-1">글수정</b-button>
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
        boardId: 0,
        userid: "",
        title: "",
        content: "",
      },
      isUserid: false,
    };
  },
  props: {
    type: { type: String },
  },

  created() {
    const url = `board/detail/${this.$route.params.boardId}`;
    http.get(url).then(({ data }) => {
      this.board.boardId = data.boardId;
      this.board.userid = data.userid;
      this.board.title = data.title;
      this.board.content = data.content;
      this.board = data;
    });
    this.isUserid = true;
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";
      !this.board.userId &&
        ((msg = "작성자 입력해주세요"),
        (err = false),
        this.$refs.userId.focus());
      err &&
        !this.board.title &&
        ((msg = "제목 입력해주세요"),
        (err = false),
        this.$refs.subject.focus());
      err &&
        !this.board.content &&
        ((msg = "내용 입력해주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      else this.type === this.modifyBoard();
    },
    onReset(event) {
      event.preventDefault();
      this.board.boardId = 0;
      this.board.title = "";
      this.board.content = "";
      this.$router.push({ name: "boardList" });
    },
    modifyBoard() {
      http
        .put(`/board/${this.board.boardId}`, {
          boardId: this.board.boardId,
          title: this.board.title,
          userId: this.board.userId,
          content: this.board.content,
        })
        .then(({ data }) => {
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);
          // 현재 route를 /list로 변경.
          this.$router.push({ name: "boardList" });
        });
    },
    moveList() {
      this.$router.push({ name: "boardList" });
    },
  },
};
</script>

<style></style>
