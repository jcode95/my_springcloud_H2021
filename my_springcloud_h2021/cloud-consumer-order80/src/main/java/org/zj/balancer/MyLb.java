package org.zj.balancer;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiezhou
 * @CalssName: MyLb
 * @Package org.ribbon.myrule
 * @Description: 自定义轮询负载均衡
 * @date 2021/7/2/10:11
 */
@Component
public class MyLb implements LoadBalancer {

    AtomicInteger count=new AtomicInteger(0);//计数请求次数

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int current;
        int next;
        do {
            current = this.count.get();
            next = (current + 1) %  serviceInstances.size();
        } while(!this.count.compareAndSet(current, next));
        System.out.println("当前 是第 " + next+" 次请求...");
        ServiceInstance serviceInstance = serviceInstances.get(next);
        return serviceInstance;
    }
}
