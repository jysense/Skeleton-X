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
package cn.ucaner.skeleton.gateway.controller.api;

import cn.ucaner.skeleton.common.vo.RespBody;
import cn.ucaner.skeleton.gateway.annotation.LoginUser;
import cn.ucaner.skeleton.gateway.jwt.utils.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @projectName：Skeleton-X
 * @Package：cn.ucaner.skeleton.gateway.controller.api
 * @Description： <p> ApiController  </p>
 * @Author： - Jason
 * @CreatTime：2019/4/27 - 9:48
 * @Modify By：
 * @ModifyTime： 2019/4/27
 * @Modify marker：
 */
@RestController
@RequestMapping(value = "/v1/api")
public class ApiController {

    private Logger logger = LoggerFactory.getLogger(ApiController.class);

    /**
     * @Description: login
     * @param username
     * @param password
     * @return RespBody
     * @Autor: Jason
     */

    @PostMapping("/getToken")
    public RespBody login(@LoginUser String flag,@RequestParam("username") String username, @RequestParam("password") String password) {
        HashMap<String, Object> tokenMap = new HashMap<>(1);
        RespBody respBody = new RespBody();
        logger.info("=== flag:{} - username:{} - password:{} ===",flag,username,password);
        if (StringUtils.isEmpty(username)) {
            respBody.addError("username不存在!");
        }else {
            /**
             * jwt生成签名
             */
            tokenMap.put("jwtToken", JwtUtil.sign(username, password));
            respBody.addOK(tokenMap, "JwtToken");
        }
        return respBody;
    }

}
