import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import store from "@/store/index.js";

Vue.use(VueRouter);

// https://router.vuejs.org/kr/guide/advanced/navigation-guards.html
const onlyAuthUser = async (to, from, next) => {
  // console.log(store);
  const checkUserInfo = store.getters["memberStore/checkUserInfo"];
  const getUserInfo = store._actions["memberStore/getUserInfo"];
  let token = sessionStorage.getItem("access-token");
  if (checkUserInfo == null && token) {
    await getUserInfo(token);
  }
  if (checkUserInfo === null) {
    alert("로그인이 필요한 페이지입니다..");
    next({ name: "signIn" });
    // router.push({ name: "signIn" });
  } else {
    // console.log("로그인 했다.");
    next();
  }
};

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/user",
    name: "user",
    component: () => import("@/views/MemberView.vue"),
    children: [
      {
        path: "signin",
        name: "signIn",
        component: () => import("@/components/user/MemberLogin.vue"),
      },
      {
        path: "signup",
        name: "signUp",
        component: () => import("@/components/user/MemberRegister.vue"),
      },
      {
        path: "mypage",
        name: "mypage",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/user/MemberMyPage.vue"),
      },
      {
        path: "myinfomodify",
        name: "myinfoModify",
        beforeEnter: onlyAuthUser,
        component: () => import("@/components/user/MemberModify.vue"),
      },
    ],
  },
  {
    path: "/aptlike",
    name: "aptLike",
    component: () => import("@/components/apt/AptLike.vue"),
  },
  {
    path: "/apt",
    name: "aptView",
    component: () => import("@/views/AptView.vue"),
  },
  {
    path: "/board",
    name: "board",
    component: () => import("@/views/BoardView.vue"),
    redirect: "/board/list",
    children: [
      {
        path: "list",
        name: "boardList",
        component: () => import("@/components/board/BoardList.vue"),
      },
      {
        path: "write",
        name: "boardRegist",
        component: () => import("@/components/board/BoardRegist.vue"),
      },
      {
        path: "detail/:boardId",
        name: "boardDetail",
        component: () => import("@/components/board/BoardDetail.vue"),
      },
      {
        path: "modify/:boardId",
        name: "boardModify",
        component: () => import("@/components/board/BoardModify.vue"),
      },
      {
        path: "delete/:boardId",
        name: "boardDelete",
        component: () => import("@/components/board/BoardDelete.vue"),
      },
    ],
  },
  {
    path: "/team",
    name: "team",
    component: () => import("@/views/TeamView.vue"),
  },
  {
    path: "/notice",
    name: "notice",
    component: () => import("@/views/NoticeView.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
