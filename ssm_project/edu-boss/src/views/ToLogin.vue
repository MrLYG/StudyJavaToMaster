<template></template>
  <!-- <section class="error">
    <h1>未登录</h1>
    <h2>请点击进入登录页面,完成登录操作</h2>

    <el-button type="success" @click="toLogin('Login')">点击跳转到登录页面</el-button>
  </section> -->
<script>
export default {
  name: "Error",
  title: "Not Found",
  data() {
    return {
      name: process.env.VUE_APP_NAME
    };
  },
  created() {
    this.$router.replace({ name: "Login" });
  },
  methods: {
    toLogin() {
      this.$router.replace({ name: "Login" });
    }
  }
};
</script>

<style lang="scss" scoped>
.error {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
}

h1,
h2 {
  margin: 0;
  font-size: 2.5rem;
  font-weight: 300;
  letter-spacing: 0.125rem;
}

h1 {
  font-size: 15rem;
}

footer {
  margin: 5rem;
  padding: 0.625rem;
  border: 0.0625rem solid rgba(0, 0, 0, 0.1);
  width: 22rem;
  font-size: 0.75rem;
  text-align: center;
  color: rgba(0, 0, 0, 0.6);

  a {
    color: inherit;
    text-decoration: none;

    &:hover {
      text-decoration: underline;
    }
  }
}
</style>
