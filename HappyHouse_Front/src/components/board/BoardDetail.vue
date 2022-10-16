<template>
  <section class="py-7">
    <div class="container">
      <div class="row">
        <div class="col-md-8 ms-auto me-auto">
          <div>
            <h4 class="text-center mb-5"></h4>
            <div class="d-flex justify-content-center">
              <div>
                <a href="javascript:;">
                  <div class="position-relative">
                    <div class="blur-shadow-avatar rounded-circle">
                      <img
                        class="avatar"
                        src="../../../public/assets/img/RyanFlex.png"
                        alt="..."
                      />
                    </div>
                  </div>
                </a>
              </div>
              <div class="ms-3">
                <h6>
                  {{ board.userId }}
                  <span class="text-muted text-xs">· {{ board.regtime }}</span>
                </h6>

                <p>
                  {{ board.title }}
                </p>
                <p>
                  {{ board.content }}
                </p>

                <div class="ms-auto text-end">
                  <a
                    href="javascript:;"
                    class="btn text-dark px-2 btn-link"
                    rel="tooltip"
                    title=""
                    data-original-title="Reply to Comment"
                  >
                    <i class="fa fa-reply"></i> Reply
                  </a>
                  <a href="javascript:;" class="btn text-danger px-2 btn-link">
                    <i class="fas fa-heart"></i> 243
                  </a>
                </div>
                <div class="col-md-12 text-center">
                  <b-button
                    class="btn bg-gradient-info mt-3 mr-3 mb-0 float-left"
                    @click="modifyBoard"
                  >
                    글수정
                  </b-button>
                  <b-button
                    class="btn bg-gradient-primary mt-3 ml-3 mb-0 float-right"
                    @click="deleteBoard"
                  >
                    글삭제
                  </b-button>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- end media-post -->
      </div>
    </div>
  </section>
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
