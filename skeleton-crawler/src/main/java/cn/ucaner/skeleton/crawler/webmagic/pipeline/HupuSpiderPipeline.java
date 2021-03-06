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
package cn.ucaner.skeleton.crawler.webmagic.pipeline;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

/**
 * @projectName：Skeleton-X
 * @Package：cn.ucaner.skeleton.crawler.webmagic.pipeline
 * @Description： <p> HupuSpiderPipeline  </p>
 * <docs>
 *     http://webmagic.io/docs/zh/posts/ch6-custom-componenet/pipeline.html
 * </docs>
 * @Author： - Jason
 * @CreatTime：2019/4/28 - 9:58
 * @Modify By：
 * @ModifyTime： 2019/4/28
 * @Modify marker：
 */
@Component
public class HupuSpiderPipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {

        for(Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {

            if(entry.getKey().equals("postInfo")) {

            }
            if(entry.getKey().equals("commentInfo")) {

            }
            if(entry.getKey().equals("titleWordInfo")) {

            }
            if(entry.getKey().equals("userInfo")) {

            }
        }

    }
}
