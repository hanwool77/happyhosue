<template>
  <div class="page-header min-vh-100">
    <div class="container">
      <div class="row" style="width: 120%">
        <div
          class="col-6 d-lg-flex d-none h-100 my-auto pe-0 position-absolute top-0 start-0 text-center justify-content-center flex-column"
        >
          <div
            class="position-relative h-100 m-3 px-7 border-radius-lg d-flex flex-column justify-content-center"
            style="
              background-image: url('../../assets/img/illustrations/illustration-signin.jpg');
              background-size: cover;
            "
            loading="lazy"
          ></div>
        </div>
        <div
          class="col-xl-4 col-lg-5 col-md-7 d-flex flex-column ms-auto me-auto ms-lg-auto me-lg-5"
        >
          <div class="card card-plain" style="border: none">
            <div
              class="card-header text-center"
              style="background-color: #ffffff; border: none"
            >
              <h4 class="font-weight-bolder">Sign In</h4>
              <p class="mb-0">Happy House에 오신것을 환영합니다.</p>
            </div>
            <div class="card-body mt-2">
              <form role="form">
                <div class="input-group input-group-static mb-3">
                  <label>ID</label>
                  <input
                    class="form-control"
                    style="border: none"
                    placeholder="아이디를 입력해주세요."
                    type="text"
                    v-model="user.userid"
                    @keyup.enter="confirm"
                  />
                </div>
                <div class="input-group input-group-static mb-3">
                  <label>Password</label>
                  <input
                    class="form-control"
                    style="border: none"
                    placeholder="비밀번호를 입력해주세요."
                    type="password"
                    name="password"
                    v-model="user.userpwd"
                    @keyup.enter="confirm"
                  />
                </div>
                <div
                  class="form-check form-switch d-flex align-items-center mb-3"
                >
                  <input
                    class="form-check-input"
                    type="checkbox"
                    id="rememberMe"
                    style="margin-left: 0"
                  />
                  <label class="form-check-label mb-0 ms-3" for="rememberMe"
                    >Remember me</label
                  >
                </div>
                <div class="text-center">
                  <button
                    type="button"
                    class="btn btn-lg bg-gradient-primary btn-lg w-100 mt-4 mb-0"
                    style="margin-top: 0.5rem !important"
                    @click="confirm"
                  >
                    Sign in
                  </button>
                </div>
              </form>
            </div>
            <div
              class="card-footer text-center pt-0 px-lg-2 px-1"
              style="border: none"
            >
              <p class="mb-4 text-sm mx-auto">
                Don't have an account?
                <a
                  href="javascript:;"
                  class="text-primary text-gradient font-weight-bold"
                  @click="movePage"
                  >Sign up</a
                >
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "MemberLogin",
  data() {
    return {
      user: {
        userid: null,
        userpwd: null,
      },
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError"]),
  },
  methods: {
    ...mapActions(memberStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");
      if (this.isLogin) {
        await this.getUserInfo(token);
        this.$router.push({ name: "home" });
      }
    },
    movePage() {
      this.$router.push({ name: "signUp" });
    },
  },
};
</script>

<style></style>
