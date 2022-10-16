<template>
  <!-- -------- START HEADER 1 w/ text and image on right ------- -->
  <header>
    <nav
      class="navbar navbar-expand-lg navbar-dark navbar-absolute bg-transparent shadow-none"
    ></nav>
    <div
      class="page-header min-vh-100"
      style="
        background-image: url(&#39;https://images.unsplash.com/photo-1520769945061-0a448c463865?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1950&q=80&#39;);
      "
      loading="lazy"
    >
      <span class="mask bg-gradient-dark opacity-5"></span>
      <div class="container">
        <div class="row">
          <div
            class="col-lg-6 col-md-7 d-flex justify-content-center flex-column"
          >
            <h1 class="text-white mb-4">Welcome to Happy House!</h1>
            <p class="text-white opacity-8 lead pe-5 me-5">
              안녕하세요, SSAFY 서울 17반, 전한울, 권혁호의 Happy House 프로젝트
              입니다.
            </p>
            <div class="buttons">
              <button
                type="button"
                class="btn btn-white mt-4"
                style="background-color: #ffffff"
              >
                Get Started
              </button>
              <button type="button" class="btn text-white shadow-none mt-4">
                Read more
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>
  <!-- -------- END HEADER 1 w/ text and image on right ------- -->
</template>

<script>
export default {
  name: "HomeView",
};
</script>
<!-- Channel Plugin Scripts -->
<script>
(function () {
  var w = window;
  if (w.ChannelIO) {
    return (window.console.error || window.console.log || function () {})(
      // eslint-disable-next-line prettier/prettier
      "ChannelIO script included twice.",
    );
  }
  var ch = function () {
    ch.c(arguments);
  };
  ch.q = [];
  ch.c = function (args) {
    ch.q.push(args);
  };
  w.ChannelIO = ch;
  function l() {
    if (w.ChannelIOInitialized) {
      return;
    }
    w.ChannelIOInitialized = true;
    var s = document.createElement("script");
    s.type = "text/javascript";
    s.async = true;
    s.src = "https://cdn.channel.io/plugin/ch-plugin-web.js";
    s.charset = "UTF-8";
    var x = document.getElementsByTagName("script")[0];
    x.parentNode.insertBefore(s, x);
  }
  if (document.readyState === "complete") {
    l();
  } else if (window.attachEvent) {
    window.attachEvent("onload", l);
  } else {
    window.addEventListener("DOMContentLoaded", l, false);
    window.addEventListener("load", l, false);
  }
})();
ChannelIO("boot", {
  pluginKey: "d15b0593-b16e-406b-8187-c2cd90b3f5a6",
});
</script>
<!-- End Channel Plugin -->
<!-- Mandatory init script -->
