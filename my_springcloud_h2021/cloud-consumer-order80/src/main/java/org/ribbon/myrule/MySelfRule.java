package org.ribbon.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiezhou
 * @CalssName: MySelfRule
 * @Package org.ribbon.myrule
 * @Description: 不要将Ribbon配置类与主启动类同包( @ComponentScan所扫描的当前包下以及子包下) 否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，达不到特殊化定制的目的了
 * @date 2021/6/28/13:51
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();//随机
    }

}
