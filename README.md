# 项目文档地址
https://blog.csdn.net/lyj2018gyq/article/details/81981466
# 项目下载地址
https://github.com/lyj8330328
# 视频地址 
https://www.bilibili.com/video/av54216146/?p=133
#笔记资料地址
https://blog.csdn.net/tian_ci/article/details/85072504
#springboot集成es
https://blog.csdn.net/m0_37738114/article/details/80040666

项目打开后需要需要考虑跨域，
一、niginx 配置
二、网关跨域配置GlobalCorsConfig
三、网关yml配置
  add-host-header: true    # 添加请求头
    sensitive-headers:     # cookie的覆盖