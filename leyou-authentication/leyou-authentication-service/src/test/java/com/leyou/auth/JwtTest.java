package com.leyou.auth;

import com.leyou.auth.entity.UserInfo;
import com.leyou.auth.utils.JwtUtils;
import com.leyou.auth.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *  原文链接  https://blog.csdn.net/lyj2018gyq/article/details/83311809
 * @Description TODO
 * @Author yk
 * @Date 2019/8/25 13:31
 */
public class JwtTest {

    private static final String pubKeyPath = "C:\\tmp\\rsa\\rsa.pub";

    private static final String priKeyPath = "C:\\tmp\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU2NzE0Mzg4Mn0.dKl5tAu37R7OyqOfM9-A9IdQCLJgXTCBt92WS6McxmP2b-UWvVl8RcuIS9R8DexWLdDmMwQaQ2vdZL1YdSa8_8HKPfVEEJrSoZMvcDvs23T_5F2ZW-8NDPwd9LfI1jy97jdCrCPy64rpG3wfeKi2zuS4wk2ukmJaPH2q1M8_7MU";

        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }

}
