# Kaptcha Spring Boot Starter

Kaptcha Spring Boot Starter can help you use [Google Kaptcha](http://code.google.com/p/kaptcha/) with [Spring Boot](https://github.com/spring-projects/spring-boot) easier.

## Usage

Declare `kaptcha-spring-boot-starter` dependency in your `pom.xml` file.

```xml
<dependency>
    <groupId>com.oopsguy.kaptcha</groupId>
    <artifactId>kaptcha-spring-boot-starter</artifactId>
    <version>1.0.0-beta-2</version>
</dependency>
```

## Properties

You can use some properties to custom your captcha without Java code as following:

```yaml
# for kaptcha
kaptcha:
  border:
    enabled: true
    color: '200,200,200'
    thickness: 1
  noise:
    color: '239,166,131'
    # you can specify your own implementation class
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
  # You can configure multiple separate captcha
  # and configure properties for each, the configuration will 
  # override the parent configuration
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
    # more items ...
```

## Examples

### YAML

The following yaml configure some common kaptcha properties 
and define two kaptcha servlets(`home` and `admin`),
you can configure them in your `application.yml`:

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

Then browse [http://localhost:8080/home/capthca](http://localhost:8080/home/capthca) and [http://localhost:8080/admin/capthca](http://localhost:8080/admin/capthca)

### Java Code

You can also inject a `Producer` bean directly by annotation to generate captcha.

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
        // Save the captcha code to the session
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

For more examples, please see [kaptcha-spring-boot-starter-example](https://github.com/12software/kaptcha-spring-boot/tree/master/kaptcha-spring-boot-starter-example)

## Notice

If you custom your own `Producer` bean, it will instead of default. But the separate configuration is still apply.

## License

MIT License

