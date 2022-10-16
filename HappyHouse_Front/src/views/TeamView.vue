<template>
  <b-container class="bv-example-row mt-3 col-12 text-center">
    <pre></pre>
    <pre></pre>
    <section class="py-5">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-md-7 mb-5">
            <div
              class="icon icon-shape icon-md bg-gradient-primary shadow text-center mb-3"
            >
              <i class="material-icons opacity-10">supervisor_account</i>
            </div>
            <h3>만들어조 ( Makers )</h3>
            <p>
              안녕하세요 👋, SSAFY 서울 17반 13조 "만들어조" 입니다. <br />
              잠시만&#128591; 저희를 소개할게요.
            </p>
          </div>
        </div>
        <div class="row mt-5 pl-10">
          <div
            class="col-lg-4 col-md-6 mt-md-0 mt-5"
            style="margin-left: 125px"
          >
            <div class="card card-profile card-plain">
              <div class="text-start mt-n5 z-index-1">
                <div class="position-relative w-25">
                  <div class="blur-shadow-avatar">
                    <img
                      class="avatar avatar-xxl border-radius-xl"
                      src="../../public/assets/img/team-5.png"
                    />
                  </div>
                </div>
              </div>
              <div class="card-body ps-0" style="margin-left: 25px">
                <h5 class="mb-0">전한울</h5>
                <p class="text-muted">Leader / Developer</p>
                <p>
                  아파트 및 게시판 관련 전반적인 <br />
                  백엔드, 프론트엔드 개발
                </p>
                <button
                  type="button"
                  class="btn-icon-only btn-simple btn btn-lg btn-twitter"
                  data-toggle="tooltip"
                  data-placement="bottom"
                  title="Follow me!"
                >
                  <i class="fab fa-twitter"></i>
                </button>
                <button
                  type="button"
                  class="btn-icon-only btn-simple btn btn-lg btn-dribbble"
                  data-toggle="tooltip"
                  data-placement="bottom"
                  title="Follow me!"
                >
                  <i class="fab fa-dribbble"></i>
                </button>
                <button
                  type="button"
                  class="btn-icon-only btn-simple btn btn-lg btn-linkedin"
                  data-toggle="tooltip"
                  data-placement="bottom"
                  title="Follow me!"
                >
                  <i class="fab fa-linkedin"></i>
                </button>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 mx-md-auto mt-md-0 mt-5">
            <div class="card card-profile card-plain">
              <div class="mt-n5 z-index-1">
                <div class="position-relative w-25">
                  <div class="blur-shadow-avatar">
                    <img
                      class="avatar avatar-xxl border-radius-xl"
                      src="../../public/assets/img/team-5.png"
                    />
                  </div>
                </div>
              </div>
              <div class="card-body ps-0" style="margin-left: 25px">
                <h5 class="mb-0">권혁호</h5>
                <p class="text-muted">Follower / Developer</p>
                <p>
                  회원 관련 백엔드 개발 및 <br />
                  전반적인 프론트엔드 개발
                </p>
                <button
                  type="button"
                  class="btn-icon-only btn-simple btn btn-lg btn-twitter"
                  data-toggle="tooltip"
                  data-placement="bottom"
                  title="Follow me!"
                >
                  <i class="fab fa-twitter"></i>
                </button>
                <button
                  type="button"
                  class="btn-icon-only btn-simple btn btn-lg btn-dribbble"
                  data-toggle="tooltip"
                  data-placement="bottom"
                  title="Follow me!"
                >
                  <i class="fab fa-dribbble"></i>
                </button>
                <button
                  type="button"
                  class="btn-icon-only btn-simple btn btn-lg btn-linkedin"
                  data-toggle="tooltip"
                  data-placement="bottom"
                  title="Follow me!"
                >
                  <i class="fab fa-linkedin"></i>
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </b-container>
</template>

<script>
export default {
  name: "TeamView",
};
</script>

<style scoped></style>
