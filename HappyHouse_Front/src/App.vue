<template>
  <div id="app">
    <header-nav-bar></header-nav-bar>
    <router-view />
    <footer-nav></footer-nav>
  </div>
</template>

<script>
import HeaderNavBar from "@/components/layout/HeaderNav.vue";
import FooterNav from "@/components/layout/FooterNav.vue";
export default {
  components: {
    HeaderNavBar,
    FooterNav,
  },
};
</script>

<style></style>
