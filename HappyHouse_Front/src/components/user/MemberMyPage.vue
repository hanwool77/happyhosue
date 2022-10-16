<template>
  <section>
    <pre></pre>
    <pre></pre>
    <pre></pre>
    <pre></pre>
    <pre></pre>
    <div class="container py-4">
      <div class="row">
        <div class="col-lg-7 mx-auto d-flex justify-content-center flex-column">
          <div class="card d-flex justify-content-center p-4 shadow-lg">
            <div class="text-center">
              <h3 class="text-gradient text-primary">My Info</h3>
              <p class="mb-0">
                이용 중인 Happy House 서비스를 마이페이지에서 확인하세요.
              </p>
            </div>
            <div class="card card-plain" style="border: none">
              <form
                role="form"
                id="contact-form"
                method="post"
                autocomplete="off"
              >
                <div class="card-body pb-2">
                  <div class="row">
                    <div class="col-md-6">
                      <div class="input-group input-group-static mb-4">
                        <label>ID</label>
                        <input
                          class="form-control"
                          placeholder="eg. John Mitch"
                          aria-label="Full Name"
                          type="text"
                          style="
                            border: none;
                            pointer-events: none;
                            background: rgb(255, 255, 255);
                            border-bottom: solid;
                            border-bottom-color: grey;
                            border-bottom-width: thin;
                          "
                          v-model="userInfo.userid"
                        />
                      </div>
                    </div>
                    <div class="col-md-6 ps-md-2">
                      <div class="input-group input-group-static">
                        <label>Name</label>
                        <input
                          type="name"
                          class="form-control"
                          placeholder="name"
                          style="
                            border: none;
                            pointer-events: none;
                            background: rgb(255, 255, 255);
                            border-bottom: solid;
                            border-bottom-color: grey;
                            border-bottom-width: thin;
                          "
                          v-model="userInfo.username"
                        />
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="input-group input-group-static mb-4">
                        <label>Email</label>
                        <input
                          class="form-control"
                          placeholder="eg. John Mitch"
                          aria-label="Full Name"
                          type="text"
                          style="
                            border: none;
                            pointer-events: none;
                            background: rgb(255, 255, 255);
                            border-bottom: solid;
                            border-bottom-color: grey;
                            border-bottom-width: thin;
                          "
                          v-model="userInfo.email"
                        />
                      </div>
                    </div>
                    <div class="col-md-6 ps-md-2">
                      <div class="input-group input-group-static">
                        <label>Signup Date</label>
                        <input
                          type="Signup Date"
                          class="form-control"
                          placeholder="hello@creative-tim.com"
                          style="
                            border: none;
                            pointer-events: none;
                            background: rgb(255, 255, 255);
                            border-bottom: solid;
                            border-bottom-color: grey;
                            border-bottom-width: thin;
                          "
                          v-model="userInfo.joindate"
                        />
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-12 text-center">
                      <b-button
                        class="btn bg-gradient-info mt-3 mb-0 float-left"
                        @click="moveModifyMember"
                      >
                        정보 수정
                      </b-button>
                      <b-button
                        class="btn bg-gradient-primary mt-3 mb-0 float-right"
                        @click="secessionMember"
                      >
                        회원 탈퇴
                      </b-button>
                    </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { mapState, mapMutations } from "vuex";
import { secessionMember } from "@/api/member";

const memberStore = "memberStore";

export default {
  name: "MemberMyPage",
  components: {},
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  data() {
    return {
      user: {
        userId: "",
        userName: "",
        userPwd: "",
        userCheckPwd: "",
        userEmail: "",
      },
    };
  },
  methods: {
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    onClickLogout() {
      // console.log("memberStore : ", ms);
      this.SET_IS_LOGIN(false);
      this.SET_USER_INFO(null);
      sessionStorage.removeItem("access-token");
      if (this.$route.path != "/") this.$router.push({ name: "home" });
    },
    moveModifyMember() {
      this.$router.push({ name: "myinfoModify" });
    },
    moveModifyArticle() {
      this.$router.replace({
        name: "boardModify",
        params: { articleno: this.article.articleno },
      });
      //   this.$router.push({ path: `/board/modify/${this.article.articleno}` });
    },
    secessionMember() {
      if (confirm("정말로 탈퇴하시겠습니까?")) {
        console.log("yes");
        secessionMember(
          {
            userid: this.userInfo.userid,
          },
          ({ data }) => {
            let msg = "회원 탈퇴시 문제가 발생했습니다.";
            if (data === "success") {
              msg = "회원 탈퇴가 완료되었습니다.";
            }
            alert(msg);
            this.onClickLogout();
            this.moveLogin();
          },
          (error) => {
            console.log(error);
            // eslint-disable-next-line prettier/prettier
          },
        );
      }
    },
    moveLogin() {
      this.$router.push({ name: "signIn" });
    },
  },
};
</script>

<style></style>
