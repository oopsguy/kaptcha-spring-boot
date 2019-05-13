# Kaptcha Spring Boot Starter

Kaptcha Spring Boot Starter 可以让你更方便地在 [Spring Boot](https://github.com/spring-projects/spring-boot) 应用中使用 [Google Kaptcha](http://code.google.com/p/kaptcha/).

## 用法

在项目的 `pom.xml` 文件中加入 `kaptcha-spring-boot-starter` 依赖。

```xml
<dependency>
    <groupId>com.oopsguy.kaptcha</groupId>
    <artifactId>kaptcha-spring-boot-starter</artifactId>
    <version>1.0.0-beta-2</version>
</dependency>
```

## Properties

你可以仅使用 properties 来自定义验证码，无需任何 Java 代码:

```yaml
kaptcha:
  border:
    enabled: true
    color: '200,200,200'
    thickness: 1
  noise:
    color: '239,166,131'
    # 可以指定自定义的实现类
    impl:
  obscurificator:
    impl:
  producer:
    impl:
  background:
    impl:
    color-from: '255,0,0'
    color-to: '255,0,0'
  text-producer:
    impl:
    character:
      string: '01234567890ABCDEF'
      length: 4
      space: 10
    font:
      names:
      color: '255,255,255'
      size: 46
  word:
    impl:
  image:
    width: 200
    height: 60
  # 可以配置多个验证码，并为每个验证码单独配置
  # 独立的配置将覆盖上面的公共配置
  items:
    home:
      path: /home/captcha
      session:
        key: homeCaptcha
      background:
        color-from: '255,255,255'
        color-to: '255,255,255'
      text-producer:
        font:
          color: '68,155,44'
    # 更多...
```

## 示例

### YAML 方式

下例使用 yaml 来配置 Kaptcha 的通用属性并定义了两个 Kaptcha servlet（`home` 和 `admin`）。你可以在 `application.yml` 文件中配置：

```yaml
server:
  port: 8080

kaptcha:
  border:
    enbaled: true
    image:
      height: 60
      width: 160
  items:
    # home captcha
    home:
      path: /home/capthca
      text-producer:
        font:
          size: 16
      image:
        height: 40
    # admin captcha
    admin:
      path: /admin/capthca
      text-producer:
        character:
          length: 4
```

配置完成后启动项目，可浏览 [http://localhost:8080/home/capthca](http://localhost:8080/home/capthca) 和 [http://localhost:8080/admin/capthca](http://localhost:8080/admin/capthca) 查看效果。

### Java 代码方式

你可以直接注入一个 `Producer` bean 来生成验证码。

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
        // 将验证码保存到 session 中
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

可查看 [kaptcha-spring-boot-starter-example](https://github.com/oopsguy/kaptcha-spring-boot/tree/master/kaptcha-spring-boot-starter-example) 获取更多示例。

## 注意

如果你定义了自己的 `Producer` bean，它将会代替默认的 `Producer`。但 `items` 下的独立配置不会被覆盖。

## 许可

MIT License

