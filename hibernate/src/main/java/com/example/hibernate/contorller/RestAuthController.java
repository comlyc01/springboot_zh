package com.example.hibernate.contorller;

import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.request.AuthAlipayRequest;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 支付宝登录
 */

@RestController
@RequestMapping("/oauth")
public class RestAuthController {
    @RequestMapping("/render")
    public void renderAuth(HttpServletResponse response) throws IOException {
        AuthRequest authRequest = getAuthRequest();
        response.sendRedirect(authRequest.authorize(AuthStateUtils.createState()));
    }

    @RequestMapping("/callback")
    public Object login(AuthCallback callback) {
        AuthRequest authRequest = getAuthRequest();
        return authRequest.login(callback);
    }

    private AuthRequest getAuthRequest() {
        String appKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCeOUEoV5sjA6J6QK+lq6zPdraYm4EavvY5WmI/1cV+Yx3HfQUxJ1EO0RbAtmZeVMhFmZrqmSFFiJjzOD96WtIwgRjWvceMwGZ9cfg7uM4+X7vQZfar6hcp9QhWcqY3vL4vUQ3t7XOwoJ4GncpjWAeJnBxUakczyBA2yruZzZTzpVhqm5egh5LMxP7F2yJYE+Sbf03P2LJRNt3dgE1YbsVrIUsOsKtLkxyggu1zoDaHTb/1z2FNBP2slD9NspiVFNf71xTgf6TR/TmUF4NhAl2suJe1M20HZphxIZhl6EIJZMK0Y7Apq/juPE0PNEM19fr/JFEhD1qynuCcHoDbkW9xAgMBAAECggEAJarXujTw9+r7mUMhDb3LDDDk03vhxm5Dy++aiDvqImaSRlWbENKdV3urgQFraXWhoAArg0IlS5pzXyO66PQKKgXx1d2kTfvX6nFheUZLw0mjOr+rc83s6c4tx/bPX2GNnVIckNIAwsHaHRUfg3sHgFkr3WTXwpoUUhb9hmYM2dvYVOhv1s80hLUC1NUy4DnWCiQY61SLiCKKOhR4trO1PmsZhGxPXQx06u96PxicAGxHHjelYqusVfn1R0WKj78SYNiS8qozU6QXiAYH+z2xYr8jUyoSefcnWIS34pSGrqioCR2Pvvn1cE2yj6GYPuYZhoOpRAZYGodl6lLCw0Gp4QKBgQDop6jp6/4ws9Jxx5MCl4Co1Jg+Wai3AuP/16vl3Vzm9kFXNV1EgxgKVoXxdhHVhhDPKMj+NhaVcT5M9xSMw2lqt/BFRaIiea/X/DwjCQFVipjORpghxWdaR4qlVGm9DGsTw4mNcBzuRjAyVOx7PiDbIAeuNZJG50GaeIgr3nkiVQKBgQCuGaLS/zWdO98p9MwdsbsApHF2UT68H5eUJKH8QChZWf4cnVclZAhx08cD0vq4aRjZqEIWIVERu9btTBpKm7nD957yVksM1RRTxo/M4RVE5uHUF6c+uKq4JWNbCroxDrT8yOvXod7HR77fmotiffJ0j3J8yuAly9T7Bu1xA3RMrQKBgQCfyqeFIoUPRjJ/2ybpXM0NKBb4m/P43o9iJOr3kbZBG1l9YDWS3MciMpMEaKePE+lvnv+NOfEA6ypzCjCfDYfVuEfaDB1zuEhB/AgBuCmmau7QnkPWzhJSO1jKfNOy+FiC1oYfEqWMMcDgkNtrOhyu46zixgCVmjfAtJAyMTbZkQKBgCtLwMxMH18sxoC+mgxAaMruGjFcXweVq7Jxsb7zjZU65hDjqApqaBc2nWV8EFHQARgP2e969Zg9aGO260rmkzoC2IpXn25fhyCWXqiKySlLaZm/EB5u+jW1RpIbhtYwXB4JMW18mdRhKTyeSE+EFsmZ6tTR9xAvMpYC0QWr4D45AoGAGqm477uC2MbibV9Zs2POCokuNAyfgLjgse7SwPM0liqaNcgO0eGCoUVyLb1/YfaWFpGLlzPbn8gJLTDIMVPoLnEzBIpY1wvz6mQO6DMY5k8Iic3cZcf61sVBzMwZOoJxMI6SFYqVXZyS++NR3hCz6gDRAbVv1ZGRj/FE+PVniNM=";
        String appId = "2021001185666706";
        String zfbKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiMuO+lYYskAEQW9magkQe8HimcHWbhDSWZZKgdDfp81XCGF7QEXkpskC/+SpRATS1rnBJ+ZiCgsbv77Fzk+8FhMxtAEnpABCzdcklR1s3PfOx4wYgKWcYw66MeoAbYDDuBtIqSpxs53tjlA+xfUCMwYGyymBeFoVCiWAtlC3lyACLhi+GhP7qSe+PW3FYMn0ddcOWOZGLF4xpUcSHLYAqEU4O6UluoX/rzmXfh8m+bpyL0XQkz7ofCkkyVMHV7MNxLByHcRqTod8/9TicoKg7XQ8OW05XbQpiq+E0PN8SAclryiQNAMfyQOnBaYX3UgydhouCYTaQAoUG/hkX6nfUwIDAQAB";
        return new AuthAlipayRequest(AuthConfig.builder()
                .clientId(appId)
                .clientSecret(appKey)
                .alipayPublicKey(zfbKey)
                .redirectUri("https://www.cnblogs.com/changsu")
                .build());
    }
}
