package org.zj.balancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author jiezhou
 * @InterfaceName: LoadBalancer
 * @Package org.zj.balancer
 * @Description:
 * @date 2021/7/2/10:10
 */
public interface LoadBalancer {

    public ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
