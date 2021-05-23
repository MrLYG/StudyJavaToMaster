/**
 * Check login state
 * Some middleware to help us ensure the user is authenticated.
 */

import router from "../router";
import store from "../store";

export default Vue => {
  //导航守卫 to要访问的url, from从哪个路径跳转过来, next() 放行
  // Authorize (Make sure that is the first hook.)
  router.beforeHooks.unshift((to, from, next) => {
    
    // don't need authorize
    if (!to.meta.requireAuth) return next();

    // check login state
    store.dispatch("checkToken").then(valid => {
      // authorized
      if (valid) {
        store.dispatch("getUserPermissions").then(res => {
          //判断用户token是否失效
          if (!res) {
            //失效 清除token
            store.dispatch("deleteToken");

            //跳转到 ToLogin.vue
            return next({ name: "ToLogin" });
          }

          const { memusMap } = res;
          if (memusMap.Courses && to.name === "Home") {
            return next();
          } else if (memusMap[to.name]) {
            return next();
          } else if (Object.keys(memusMap).length > 0) {
            return next({ name: memusMap[Object.keys(memusMap)[0]].name });
          } else {
            next({ name: "PermissionDenied" });
          }
        });
        return next();
      }
      // unauthorized
      console.log("Unauthorized");

      //用户没有登录 跳转到登录页面
      next({ name: "Login", query: { redirect: to.fullPath } });
    });
  });

  // login page visiable
  router.beforeEach((to, from, next) => {
    if (to.name !== "Login") return next();
    // check login state
    store.dispatch("checkToken").then(valid => {
      if (!valid) return next();
      // when logged in
      console.log("Authorized");
      next({ path: to.query.redirect || "/" });
    });
  });
};
