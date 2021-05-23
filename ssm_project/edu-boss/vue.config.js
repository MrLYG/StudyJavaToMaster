/**
 * Override convention configuration
 * https://cli.vuejs.org/config/
 */

module.exports = {
  publicPath: process.env.NODE_ENV === "production" ? "/edu-boss/" : "/",
  indexPath: "index.html",
  assetsDir: "static",
  lintOnSave: process.env.NODE_ENV !== "production",
  productionSourceMap: false,
  devServer: {
    open: true,
    port: 8080
  }
};
