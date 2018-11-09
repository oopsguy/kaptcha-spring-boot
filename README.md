# Kaptcha Spring Boot Starter

Kaptcha Spring Boot Starter

## 使用方式

由于本库还没有发布 jar 包到中央仓库，请使用 `mvn install` 安装到本地。 

在 `pom.xml` 文件中加入 kaptcha-spring-boot-starter 依赖声明

```xml
<dependency>
    <groupId>com.software12</groupId>
    <artifactId>kaptcha-spring-boot-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

## 示例配置

### YAML 配置方式

```yaml
server:
  port: 8080

kaptcha:
  border:
    enbaled: true
    image:
      height: 60
      width: 160
  # 配置验证码 servlet 并设置独立配置，配置将覆盖以上的公共配置
  servlets:
    # OA 端验证码配置
    oa:
      sevlet: /oa/capthca
      text-producer:
        font:
          size: 16
      image:
        height: 40
    # 管理端验证码配置
    admin:
      servlet: /admin/capthca
      text-producer:
        character:
          length: 4
```

访问 [http://localhost:8080/oa/capthca](http://localhost:8080/oa/capthca) 和 [http://localhost:8080/admin/capthca](http://localhost:8080/admin/capthca)

### 代码方式

```java
@Controller
@RequestMapping("/sys")
class SystemController {
    
    @Resource
    private Producer captchaProducer;

    @GetMapping("/captcha")
    public void getKaptchaImage(HttpServletResponse response) throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText();
        // 将验证码存到 session
        ShiroKit.setSessionAttr(AdminConst.SESSION_KEY_CAPTCHA_LOGIN, capText);
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }
}
```

## LICENSE

MIT License

