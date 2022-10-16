<template>
  <div class="container">
    <div
      class="page-header align-items-start min-height-300 m-3 border-radius-xl bg-gray-200"
      style="
        background-image: url('https://images.unsplash.com/photo-1545569341-9eb8b30979d9?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&amp;ixlib=rb-1.2.1&amp;auto=format&amp;fit=crop&amp;w=1950&amp;q=80');
        background-size: cover;
        background-position: center;
      "
      loading="lazy"
    >
      <span class="mask bg-gradient-dark opacity-4"></span>
    </div>
    <pre></pre>
    <div class="row mt-lg-n12 mt-md-n12 mt-n11 justify-content-center">
      <div class="col-xl-5 col-lg-5 col-md-7 mx-auto">
        <div class="card mt-8">
          <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
            <div
              class="bg-gradient-primary shadow-primary border-radius-lg py-3 pe-1 text-center py-4"
            >
              <h4 class="font-weight-bolder text-white mt-1">Join us today</h4>
              <p class="mb-1 text-white text-sm">
                Enter your email and password to register
              </p>
            </div>
          </div>
          <div class="card-body pb-3">
            <form role="form">
              <div class="input-group input-group-static mb-3">
                <label>ID</label>
                <input
                  class="form-control"
                  style="border: none"
                  placeholder="아이디를 입력해주세요."
                  type="text"
                  v-model="user.userId"
                />
              </div>
              <div class="input-group input-group-static mb-3">
                <label>Name</label>
                <input
                  class="form-control"
                  style="border: none"
                  placeholder="이름을 입력해주세요"
                  type="text"
                  v-model="user.userName"
                />
              </div>
              <div class="input-group input-group-static mb-3">
                <label>Email</label>
                <input
                  class="form-control"
                  style="border: none"
                  placeholder="이메일을 입력해 주세요"
                  type="text"
                  v-model="user.userEmail"
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
                  v-model="user.userPwd"
                />
              </div>
              <div class="input-group input-group-static mb-3">
                <label>Cornfirm Password</label>
                <input
                  class="form-control"
                  style="border: none"
                  placeholder="비밀번호를 다시 입력해주세요"
                  type="password"
                  name="password2"
                  v-model="user.userCheckPwd"
                />
              </div>
              <div class="form-check text-left">
                <input
                  class="form-check-input bg-dark border-dark"
                  type="checkbox"
                  value=""
                  id="flexCheckDefault"
                  checked=""
                />
                <label class="form-check-label" for="flexCheckDefault">
                  I agree the
                  <a
                    href="../../pages/privacy.html"
                    class="text-dark font-weight-bolder"
                    >Terms and Conditions</a
                  >
                </label>
              </div>
              <div class="text-center">
                <button
                  type="button"
                  class="btn bg-gradient-primary w-100 mt-4 mb-0"
                  @click="signup"
                >
                  Sign up
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { registMember } from "@/api/member";
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "MemberRegister",
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
      this.$router.push({ name: "signIn" });
    },
    signup() {
      console.log(this.user);
      if (this.user.userId == "") {
        alert("아이디를 입력하세요.");
        return;
      } else if (this.user.userName == "") {
        alert("이름을 입력하세요.");
        return;
      } else if (this.user.userEmail == "") {
        alert("이메일을 입력하세요.");
        return;
      } else if (this.user.userPwd == "") {
        alert("비밀번호를 입력하세요.");
        return;
      } else if (this.user.userCheckPwd == "") {
        alert("확인 비밀번호를 입력하세요.");
        return;
      } else if (this.user.userPwd != this.user.userCheckPwd) {
        alert("비밀번호가 다릅니다.");
        return;
      } else {
        // this.$router.push("/");
      }
      this.signupMember();
    },
    signupMember() {
      registMember(
        {
          userid: this.user.userId,
          username: this.user.userName,
          userpwd: this.user.userPwd,
          email: this.user.userEmail,
        },
        ({ data }) => {
          let msg = "회원 가입시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "회원 가입이 완료되었습니다.";
          }
          alert(msg);
          this.moveLogin();
        },
        (error) => {
          console.log(error);
          // eslint-disable-next-line prettier/prettier
        }
      );
    },
    moveLogin() {
      this.$router.push({ name: "signIn" });
    },
  },
};
</script>

<style scoped></style>
