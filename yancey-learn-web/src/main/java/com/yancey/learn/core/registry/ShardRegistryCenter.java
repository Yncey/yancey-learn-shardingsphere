package com.yancey.learn.core.registry;

import org.apache.shardingsphere.orchestration.reg.api.RegistryCenter;
import org.apache.shardingsphere.orchestration.reg.listener.DataChangedEventListener;

/**
 * 动态刷新分片表
 *
 * @author yaxuany
 * @date 2019/11/11 下午 5:00
 */
public abstract class ShardRegistryCenter implements RegistryCenter {


    /**
     * Watch key or path of the registry.
     *
     * @param key                      key of data
     * @param dataChangedEventListener data changed event listener
     */
    @Override
    public void watch(String key, DataChangedEventListener dataChangedEventListener) {

    }
}
