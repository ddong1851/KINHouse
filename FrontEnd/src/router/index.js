import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "@/views/HomeView.vue";

import store from "@/store/index.js";
import Swal from "sweetalert2";

Vue.use(VueRouter);

const onlyLoginUser = async (to, from, next) => {
  const getUserInfo = store.getters["userStore/getToken"];
  console.log(getUserInfo);
  if (getUserInfo == null || getUserInfo == "") {
    Swal.fire({
      position: "center",
      width: 350,
      title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">로그인이 필요한 페이지입니다.<div>`,
      showConfirmButton: false,
      timer: 1500,
    }).then(next({ name: "login" }));
  } else {
    next();
  }
};

const onlyAdminUser = async (to, from, next) => {
  const getUserInfo = store.getters["userStore/getToken"];
  const isAdminUser = store.getters["userStore/isAdmin"];
  if (getUserInfo !== null || getUserInfo !== "") {
    if (!isAdminUser) {
      Swal.fire({
        position: "center",
        width: 350,
        title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">관리자만 사용 가능합니다.<div>`,
        showConfirmButton: false,
        timer: 1500,
      }).then(next({ name: "home" }));
    } else {
      next();
    }
  } else {
    Swal.fire({
      position: "center",
      width: 350,
      title: `<div style="font-size: 18px; font-family: "Spoqa Han Sans Neo", "sans-serif"; ">로그인이 필요한 페이지입니다.<div>`,
      showConfirmButton: false,
      timer: 1500,
    }).then(next({ name: "login" }));
  }
};

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/notice",
    name: "notice",
    component: () => import("@/views/NoticeView.vue"),
    redirect: { name: "notice-list" },
    children: [
      {
        path: "list",
        name: "notice-list",
        component: () => import("@/components/community/notice/NoticeList.vue"),
      },
      {
        path: "regist",
        name: "notice-regist",
        component: () =>
          import("@/components/community/notice/NoticeRegister.vue"),
      },
      {
        path: "detail/:no",
        name: "notice-detail",
        component: () =>
          import("@/components/community/notice/NoticeDetail.vue"),
      },
    ],
  },
  {
    path: "/qna",
    name: "qna",
    component: () => import("@/views/QnaView.vue"),
    redirect: "/qna/list",
    children: [
      {
        path: "list",
        name: "qnaList",
        component: () => import("@/components/community/qna/QnaList.vue"),
      },
      {
        path: "regist",
        name: "qnaRegister",
        beforeEnter: onlyLoginUser,
        component: () => import("@/components/community/qna/QnaRegister.vue"),
      },
      {
        path: "detail/:no",
        name: "qnaDetail",
        component: () => import("@/components/community/qna/QnaDetail.vue"),
      },
    ],
  },
  {
    path: "/login",
    name: "login",
    component: () => import("@/views/LoginView.vue"),
  },
  {
    path: "/user_regist",
    name: "user-regist",
    component: () => import("@/views/UserRegisterView.vue"),
  },
  {
    path: "/user_info",
    name: "user-info",
    beforeEnter: onlyLoginUser,
    component: () => import("@/views/UserInfoView.vue"),
    children: [
      {
        path: "info",
        name: "user-info-info",
        beforeEnter: onlyLoginUser,
        component: () => import("@/components/user/UserInfoVue.vue"),
      },
      {
        path: "liked",
        name: "user-info-liked",
        beforeEnter: onlyLoginUser,
        component: () => import("@/components/user/UserLikedVue.vue"),
      },
    ],
  },
  {
    path: "/user_list",
    name: "user-list",
    beforeEnter: onlyAdminUser,
    component: () => import("@/views/UserListView.vue"),
  },
  {
    path: "/findInfo",
    name: "find-id-pass",
    component: () => import("@/views/FindIdPassView.vue"),
  },
  {
    path: "/house",
    name: "house",
    component: () => import("@/views/HouseView.vue"),
  },
  {
    path: "*",
    redirect: "/404",
  },
  {
    path: "/404",
    name: "NotFound",
    component: () => import("@/views/NotFoundPage.vue"),
  },
  {
    path: "/contact",
    name: "contact",
    component: () => import("@/views/ContactView.vue"),
  },
  {
    path: "/about",
    name: "about",
    component: () => import("@/views/AboutUsView.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  scrollBehavior() {
    return {
      y: 0,
    };
  },
  base: process.env.BASE_URL,
  routes,
});

export default router;
