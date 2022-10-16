<template>
  <div class="container">
    <div
      class="page-header align-items-start min-height-300 m-3 border-radius-xl bg-gray-200"
      style="
        background-image: url('https://user-images.githubusercontent.com/40727085/170234930-4710f325-7a08-4e0a-8607-f330f5eb2a02.jpg');
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
              <h4 class="font-weight-bolder text-white mt-1">Modify Info</h4>
              <p class="mb-1 text-white text-sm">개인 정보를 수정해 주세요.</p>
            </div>
          </div>
          <div class="card-body pb-3">
            <form role="form">
              <div class="input-group input-group-static mb-3">
                <label>ID</label>
                <input
                  class="form-control"
                  placeholder="아이디를 입력해주세요."
                  style="
                    border: none;
                    pointer-events: none;
                    background: rgb(205, 205, 205);
                  "
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
              <div class="text-center">
                <button
                  type="button"
                  class="btn bg-gradient-primary w-100 mt-4 mb-0"
                  @click="modify"
                >
                  Modify
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
import { modifyMember } from "@/api/member";
import { mapState, mapMutations } from "vuex";
const memberStore = "memberStore";

export default {
  name: "MemberModify",
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
  created() {
    this.user.userId = this.userInfo.userid;
    this.user.userName = this.userInfo.username;
    this.user.userEmail = this.userInfo.email;
  },
  components: {},
  computed: {
    ...mapState(memberStore, ["userInfo"]),
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
    modify() {
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
      // console.log(this.user);
      this.modifyMember();
    },
    modifyMember() {
      modifyMember(
        {
          userid: this.user.userId,
          username: this.user.userName,
          userpwd: this.user.userPwd,
          email: this.user.userEmail,
        },
        ({ data }) => {
          let msg = "정보 수정시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "정보 수정이 완료되었습니다.";
          }
          alert(msg);
          this.onClickLogout();
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
<style scoped>
.main_container {
  border: 0px solid;
}

.login_container {
  width: 380px;
  height: 550px;
  margin: auto;
  border-radius: 3px;
  box-shadow: 0px 0px 20px rgb(87, 87, 87);
}

.form_container {
  width: 300px;
  margin: auto;
}

.form_title_div {
  margin: auto;
  text-align: center;
}

.form_title_p {
  font-weight: bold;
  font-size: 22px;
  display: inline-block;
  padding-top: 8px;
}

.form_input {
  width: 98%;
  height: 30px;
  border: 1px solid;
  border-radius: 3px;
  border-color: gray;
}

.form_item_name {
  float: left;
  color: gray;
}

.form_item_name:hover {
  text-decoration: none;
  font-weight: normal;
}

.form_text_alert {
  height: 20px;
}

.form_text_alert_padding {
  padding-bottom: 10px;
}

.form_submit_button {
  width: 100%;
  height: 44px;
  background-color: rgb(83, 154, 236);
  background: linear-gradient(
    90deg,
    rgb(202, 255, 255),
    rgb(124, 204, 236) 15%,
    deepSkyBlue 50%
  );
  border: 1px;
  border-radius: 5px;
  color: white;
  font-size: 17px;
  font-weight: 500;
}
</style>
