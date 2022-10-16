<template>
  <b-container v-if="apt" class="bv-example-row">
    <section>
      <div>
        <div class="row justify-content-center">
          <div>
            <div class="card" style="margin-top: 1.5em">
              <div class="table-responsive">
                <table class="table align-items-center mb-0">
                  <thead>
                    <tr>
                      <th
                        class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"
                      >
                        <h6 class="mb-0 text-xs float-left">항목</h6>
                      </th>
                      <th
                        class="text-uppercase text-secondary text-xs font-weight-bolder opacity-7"
                      >
                        <h6 class="mb-0 text-xs">매매 상세 정보</h6>
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>
                        <div class="d-flex px-2">
                          <div class="my-auto">
                            <h6 class="mb-0 text-xs">아파트 이름</h6>
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">
                          {{ apt.apartmentName }}
                        </p>
                      </td>
                    </tr>

                    <tr>
                      <td>
                        <div class="d-flex px-2">
                          <div class="my-auto">
                            <h6 class="mb-0 text-xs">주소</h6>
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">
                          {{ apt.sidoName }} {{ apt.gugunName }} <br />
                          {{ apt.dongName }} {{ apt.roadName }}
                        </p>
                      </td>
                    </tr>

                    <tr>
                      <td>
                        <div class="d-flex px-2">
                          <div class="my-auto">
                            <h6 class="mb-0 text-xs">거래 일자</h6>
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">
                          {{ apt.dealYear }}년 {{ apt.dealMonth }}월
                          {{ apt.dealDay }}일
                        </p>
                      </td>
                    </tr>

                    <tr>
                      <td>
                        <div class="d-flex px-2">
                          <div class="my-auto">
                            <h6 class="mb-0 text-xs">면적</h6>
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">
                          {{ apt.area }}m<sup>2</sup>
                        </p>
                      </td>
                    </tr>

                    <tr>
                      <td>
                        <div class="d-flex px-2">
                          <div class="my-auto">
                            <h6 class="mb-0 text-xs">건축년도 / 층수</h6>
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">
                          {{ apt.buildYear }}년 / {{ apt.floor }}층
                        </p>
                      </td>
                    </tr>

                    <tr>
                      <td>
                        <div class="d-flex px-2">
                          <div class="my-auto">
                            <h6 class="mb-0 text-xs">거래금액</h6>
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">
                          {{
                            (parseInt(apt.dealAmount.replace(",", "")) * 10000)
                              | price
                          }}원
                        </p>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </b-container>
</template>

<script>
import { mapState } from "vuex";

const aptStore = "aptStore";

export default {
  name: "AptDetail",
  computed: {
    ...mapState(aptStore, ["apt"]),
    // house() {
    //   return this.$store.state.house;
    // },
  },
  filters: {
    price(value) {
      if (!value) return value;
      return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
};
</script>

<style>
.text-xs {
  font-size: 1rem !important;
  font-family: sans-serif;
}
</style>
