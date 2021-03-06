/*******************************************************************************
 * ~ Copyright (c) 2018 [jasonandy@hotmail.com | https://github.com/Jasonandy] *
 * ~                                                                           *
 * ~ Licensed under the Apache License, Version 2.0 (the "License”);           *
 * ~ you may not use this file except in compliance with the License.          *
 * ~ You may obtain a copy of the License at                                   *
 * ~                                                                           *
 * ~    http://www.apache.org/licenses/LICENSE-2.0                             *
 * ~                                                                           *
 * ~ Unless required by applicable law or agreed to in writing, software       *
 * ~ distributed under the License is distributed on an "AS IS" BASIS,         *
 * ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  *
 * ~ See the License for the specific language governing permissions and       *
 * ~ limitations under the License.                                            *
 ******************************************************************************/
package cn.ucaner.skeleton.webapp.security.auth;

import cn.ucaner.skeleton.webapp.security.detail.SkeletonUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @projectName：Skeleton-X
 * @Package：cn.ucaner.skeleton.webapp.security.auth
 * @Description： <p> SkeletonAuthenticationProvider 默认实现为 DaoAuthenticationProvider </p>
 * @Author： - Jason
 * @CreatTime：2019/7/19 - 11:09
 * @Modify By：
 * @ModifyTime： 2019/7/19
 * @Modify marker：
 */
@Service("skeletonAuthenticationProvider")
public class SkeletonAuthenticationProvider implements AuthenticationProvider {

    private final static Logger logger = LoggerFactory.getLogger(SkeletonAuthenticationProvider.class);

    @Autowired
    private SkeletonUserDetailService skeletonUserDetailService;

    /**
     * 对密码进行校验匹配
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        logger.info("== SkeletonAuthenticationProvider:username:{} ==",username);
        UserDetails userDetails = skeletonUserDetailService.loadUserByUsername(username);
        logger.info("=== password:{} ===",password);
        if (userDetails != null) {
            //数据库里面的密码
            String realPassword = userDetails.getPassword();
            //登录的密码 [数据库存的MD5后的数据 - 传入的为明文]
            String loginPassword = password;
            logger.info("=== 真实密码为:{},提交的密码为:{} ===",realPassword,loginPassword);
            if (!realPassword.equals(loginPassword)){
                logger.info("Sorry please check your password or account.");
                throw new BadCredentialsException("Sorry please check your password or account.");
            }
            return new UsernamePasswordAuthenticationToken(userDetails, password,userDetails.getAuthorities());
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
