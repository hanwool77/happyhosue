<template>
  <!-- Navbar -->
  <div class="container position-sticky z-index-sticky top-0">
    <div class="row">
      <div class="col-12">
        <nav
          class="navbar navbar-expand-lg blur border-radius-xl top-0 z-index-fixed shadow position-absolute my-3 py-2 start-0 end-0 mx-4"
        >
          <div class="container-fluid px-0">
            <router-link
              class="navbar-brand font-weight-bolder ms-sm-3"
              data-placement="bottom"
              to="/"
              >Happy House</router-link
            >
            <button
              class="navbar-toggler shadow-none ms-2"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navigation"
              aria-controls="navigation"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span class="navbar-toggler-icon mt-2">
                <span class="navbar-toggler-bar bar1"></span>
                <span class="navbar-toggler-bar bar2"></span>
                <span class="navbar-toggler-bar bar3"></span>
              </span>
            </button>
            <div
              class="collapse navbar-collapse pt-3 pb-2 py-lg-0 w-100"
              id="navigation"
            >
              <ul class="navbar-nav navbar-nav-hover ms-auto">
                <li class="nav-item dropdown dropdown-hover mx-2">
                  <a
                    class="nav-link ps-2 d-flex cursor-pointer align-items-center"
                    id="dropdownMenuPages"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
                  >
                    <i class="material-icons opacity-6 me-2 text-md"
                      >dashboard</i
                    >
                    Pages
                    <img
                      src="../../../public/assets/img/down-arrow-dark.svg"
                      alt="down-arrow"
                      class="arrow ms-auto ms-md-2"
                    />
                  </a>
                  <div
                    class="dropdown-menu dropdown-menu-animation ms-n3 dropdown-md p-3 border-radius-xl mt-0 mt-lg-3"
                    aria-labelledby="dropdownMenuPages"
                  >
                    <div class="d-none d-lg-block">
                      <h6
                        class="dropdown-header text-dark font-weight-bolder d-flex align-items-center px-1"
                      >
                        Landing Pages
                      </h6>
                      <router-link
                        class="dropdown-item border-radius-md"
                        to="/team"
                        >About Us</router-link
                      >
                      <router-link
                        class="dropdown-item border-radius-md"
                        to="/notice"
                        >Notice</router-link
                      >
                      <router-link
                        class="dropdown-item border-radius-md"
                        to="/board"
                        >Q&A</router-link
                      >
                      <h6
                        class="dropdown-header text-dark font-weight-bolder d-flex align-items-center px-1 mt-3"
                      >
                        Account
                      </h6>
                      <div v-if="userInfo">
                        <router-link
                          class="dropdown-item border-radius-md"
                          to="/user/mypage"
                          >MyPage</router-link
                        >
                        <div
                          @click.prevent="onClickLogout"
                          class="dropdown-item border-radius-md"
                        >
                          Sign Out
                        </div>
                      </div>
                      <div v-else>
                        <router-link
                          class="dropdown-item border-radius-md"
                          to="/user/signin"
                          >Sign in</router-link
                        >
                      </div>
                    </div>

                    <div class="d-lg-none">
                      <h6
                        class="dropdown-header text-dark font-weight-bolder d-flex align-items-center px-1"
                      >
                        Landing Pages
                      </h6>
                      <a
                        href="../../../public/pages/about-us.html"
                        class="dropdown-item border-radius-md"
                      >
                        <span>About Us</span>
                      </a>
                      <a
                        href="../../../public/pages/contact-us.html"
                        class="dropdown-item border-radius-md"
                      >
                        <span>Contact Us</span>
                      </a>
                      <a
                        href="../../../public/pages/author.html"
                        class="dropdown-item border-radius-md"
                      >
                        <span>Author</span>
                      </a>

                      <h6
                        class="dropdown-header text-dark font-weight-bolder d-flex align-items-center px-1 mt-3"
                      >
                        Account
                      </h6>
                      <a
                        href="../../../public/pages/sign-in.html"
                        class="dropdown-item border-radius-md"
                      >
                        <span>Sign In</span>
                      </a>
                    </div>
                  </div>
                </li>

                <li
                  class="nav-item dropdown dropdown-hover mx-2"
                  v-if="userInfo"
                >
                  <a
                    class="nav-link ps-2 d-flex cursor-pointer align-items-center"
                    id="dropdownMenuBlocks"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
                  >
                    <i class="material-icons opacity-6 me-2 text-md"
                      >view_day</i
                    >
                    Apartment
                    <img
                      src="../../../public/assets/img/down-arrow-dark.svg"
                      alt="down-arrow"
                      class="arrow ms-auto ms-md-2"
                    />
                  </a>
                  <ul
                    class="dropdown-menu dropdown-menu-end dropdown-menu-animation dropdown-md dropdown-md-responsive p-3 border-radius-lg mt-0 mt-lg-3"
                    aria-labelledby="dropdownMenuBlocks"
                  >
                    <div class="d-none d-lg-block">
                      <li
                        class="nav-item dropdown dropdown-hover dropdown-subitem"
                      >
                        <a
                          class="dropdown-item py-2 ps-3 border-radius-md"
                          href="../../../public/presentation.html"
                        >
                          <div
                            class="w-100 d-flex align-items-center justify-content-between"
                          >
                            <div>
                              <h6
                                class="dropdown-header text-dark font-weight-bolder d-flex justify-content-cente align-items-center p-0"
                              >
                                아파트 매매
                              </h6>
                              <span class="text-sm">See all sections</span>
                            </div>
                            <img
                              src="../../../public/assets/img/down-arrow.svg"
                              alt="down-arrow"
                              class="arrow"
                            />
                          </div>
                        </a>
                        <div class="dropdown-menu mt-0 py-3 px-2 mt-3">
                          <router-link
                            class="dropdown-item ps-3 border-radius-md mb-1"
                            to="/apt"
                            >매매 기록 보기</router-link
                          >
                          <router-link
                            class="dropdown-item ps-3 border-radius-md mb-1"
                            to="/aptlike"
                            @click="like"
                            >관심 매물</router-link
                          >
                        </div>
                      </li>
                    </div>

                    <div class="row d-lg-none">
                      <div class="col-md-12">
                        <div class="d-flex mb-2">
                          <div class="icon h-10 me-3 d-flex mt-1">
                            <i
                              class="ni ni-single-copy-04 text-gradient text-primary"
                            ></i>
                          </div>
                          <div
                            class="w-100 d-flex align-items-center justify-content-between"
                          >
                            <div>
                              <h6
                                class="dropdown-header text-dark font-weight-bolder d-flex justify-content-cente align-items-center p-0"
                              >
                                Page Sections
                              </h6>
                            </div>
                          </div>
                        </div>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/page-sections/hero-sections.html"
                        >
                          Page Headers
                        </a>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/page-sections/features.html"
                        >
                          Features
                        </a>

                        <div class="d-flex mb-2 mt-3">
                          <div class="icon h-10 me-3 d-flex mt-1">
                            <i
                              class="ni ni-laptop text-gradient text-primary"
                            ></i>
                          </div>
                          <div
                            class="w-100 d-flex align-items-center justify-content-between"
                          >
                            <div>
                              <h6
                                class="dropdown-header text-dark font-weight-bolder d-flex justify-content-cente align-items-center p-0"
                              >
                                Navigation
                              </h6>
                            </div>
                          </div>
                        </div>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/navigation/navbars.html"
                        >
                          Navbars
                        </a>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/navigation/nav-tabs.html"
                        >
                          Nav Tabs
                        </a>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/navigation/pagination.html"
                        >
                          Pagination
                        </a>

                        <div class="d-flex mb-2 mt-3">
                          <div class="icon h-10 me-3 d-flex mt-1">
                            <i
                              class="ni ni-badge text-gradient text-primary"
                            ></i>
                          </div>
                          <div
                            class="w-100 d-flex align-items-center justify-content-between"
                          >
                            <div>
                              <h6
                                class="dropdown-header text-dark font-weight-bolder d-flex justify-content-cente align-items-center p-0"
                              >
                                Input Areas
                              </h6>
                            </div>
                          </div>
                        </div>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/input-areas/inputs.html"
                        >
                          Inputs
                        </a>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/input-areas/forms.html"
                        >
                          Forms
                        </a>

                        <div class="d-flex mb-2 mt-3">
                          <div class="icon h-10 me-3 d-flex mt-1">
                            <i
                              class="ni ni-notification-70 text-gradient text-primary"
                            ></i>
                          </div>
                          <div
                            class="w-100 d-flex align-items-center justify-content-between"
                          >
                            <div>
                              <h6
                                class="dropdown-header text-dark font-weight-bolder d-flex justify-content-cente align-items-center p-0"
                              >
                                Attention Catchers
                              </h6>
                            </div>
                          </div>
                        </div>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/attention-catchers/alerts.html"
                        >
                          Alerts
                        </a>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/attention-catchers/modals.html"
                        >
                          Modals
                        </a>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/attention-catchers/tooltips-popovers.html"
                        >
                          Tooltips & Popovers
                        </a>

                        <div class="d-flex mb-2 mt-3">
                          <div class="icon h-10 me-3 d-flex mt-1">
                            <i class="ni ni-app text-gradient text-primary"></i>
                          </div>
                          <div
                            class="w-100 d-flex align-items-center justify-content-between"
                          >
                            <div>
                              <h6
                                class="dropdown-header text-dark font-weight-bolder d-flex justify-content-cente align-items-center p-0"
                              >
                                Elements
                              </h6>
                            </div>
                          </div>
                        </div>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/elements/avatars.html"
                        >
                          Avatars
                        </a>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/elements/badges.html"
                        >
                          Badges
                        </a>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/elements/breadcrumbs.html"
                        >
                          Breadcrumbs
                        </a>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/elements/buttons.html"
                        >
                          Buttons
                        </a>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/elements/dropdowns.html"
                        >
                          Dropdowns
                        </a>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/elements/progress-bars.html"
                        >
                          Progress Bars
                        </a>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/elements/toggles.html"
                        >
                          Toggles
                        </a>
                        <a
                          class="dropdown-item ps-3 border-radius-md mb-1"
                          href="../../../public/sections/elements/typography.html"
                        >
                          Typography
                        </a>
                      </div>
                    </div>
                  </ul>
                </li>
                <li class="nav-item ms-lg-auto">
                  <a
                    class="nav-link nav-link-icon me-2"
                    href="https://github.com/creativetimofficial/material-kit"
                    target="_blank"
                  >
                    <i class="fa fa-github me-1"></i>
                    <p
                      class="d-inline text-sm z-index-1 font-weight-bold"
                      data-bs-toggle="tooltip"
                      data-bs-placement="bottom"
                      title="Star us on Github"
                    >
                      Github
                    </p>
                  </a>
                </li>
                <li class="nav-item my-auto ms-3 ms-lg-0">
                  <a
                    href="https://www.creative-tim.com/product/material-kit-pro"
                    class="btn btn-sm bg-gradient-primary mb-0 me-1 mt-2 mt-md-0"
                    >만들어조</a
                  >
                </li>
              </ul>
            </div>
          </div>
        </nav>
        <!-- End Navbar -->
      </div>
    </div>
  </div>
</template>
<script>
import { mapState, mapMutations } from "vuex";
import { eventBus } from "@/main";
// import ms from "@/store/modules/memberStore";
const aptStore = "aptStore";
const memberStore = "memberStore";

export default {
  name: "HeaderNaviBar",
  data() {
    return {
      isAdmin: "",
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
  },
  methods: {
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    ...mapMutations(aptStore, ["CLEAR_APT_DETAIL"]),
    onClickLogout() {
      // console.log("memberStore : ", ms);
      this.SET_IS_LOGIN(false);
      this.SET_USER_INFO(null);
      // this.CLEAR_APT_LIKE();
      sessionStorage.removeItem("access-token");
      if (this.$route.path != "/") this.$router.push({ name: "home" });
    },
    like() {
      eventBus.$emit("like");
      this.CLEAR_APT_DETAIL();
    },
  },
};
</script>
