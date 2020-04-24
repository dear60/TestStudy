package com.mingful.www.testshiro.tool;

import com.mingful.www.testshiro.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;


/**
 * @author fmf
 * @version 1.0
 * @className PasswordHelper
 * @description 密码加密解密器
 * @date 2020/4/24 16:14
 **/
@Component
public class PasswordHelper {
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    /**
     * 基础散列算法
     */
    public static final String ALGORITHM_NAME = "md5";
    /**
     * 自定义散列次数
     */
    public static final int HASH_ITERATIONS = 2;

    public void encryptPassword(User user) {
        // 随机字符串作为salt因子，实际参与运算的salt我们还引入其它干扰因子
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(ALGORITHM_NAME, user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()), HASH_ITERATIONS).toHex();
        user.setPassword(newPassword);
    }
}
