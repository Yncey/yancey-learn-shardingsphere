package com.yancey.learn.core.registry;

import org.apache.shardingsphere.orchestration.reg.api.RegistryCenter;
import org.apache.shardingsphere.orchestration.reg.api.RegistryCenterConfiguration;
import org.apache.shardingsphere.orchestration.reg.listener.DataChangedEventListener;

import java.util.List;
import java.util.Properties;

/**
 * 动态刷新分片表
 *
 * @author yaxuany
 * @date 2019/11/11 下午 5:00
 */
public class ShardRegistryCenter implements RegistryCenter {


    @Override
    public void init(RegistryCenterConfiguration registryCenterConfiguration) {

    }

    /**
     * Get data from registry center.
     *
     * <p>Maybe use cache if existed.</p>
     *
     * @param key key of data
     * @return value of data
     */
    @Override
    public String get(String key) {
        return null;
    }

    /**
     * Get data from registry center directly.
     *
     * <p>Cannot use cache.</p>
     *
     * @param key key of data
     * @return value of data
     */
    @Override
    public String getDirectly(String key) {
        return null;
    }

    /**
     * Judge data is existed or not.
     *
     * @param key key of data
     * @return data is existed or not
     */
    @Override
    public boolean isExisted(String key) {
        return false;
    }

    /**
     * Get node's sub-nodes list.
     *
     * @param key key of data
     * @return sub-nodes name list
     */
    @Override
    public List<String> getChildrenKeys(String key) {
        return null;
    }

    /**
     * Persist data.
     *
     * @param key   key of data
     * @param value value of data
     */
    @Override
    public void persist(String key, String value) {

    }

    /**
     * Update data.
     *
     * @param key   key of data
     * @param value value of data
     */
    @Override
    public void update(String key, String value) {

    }

    /**
     * Persist ephemeral data.
     *
     * @param key   key of data
     * @param value value of data
     */
    @Override
    public void persistEphemeral(String key, String value) {

    }

    /**
     * Watch key or path of the registry.
     *
     * @param key                      key of data
     * @param dataChangedEventListener data changed event listener
     */
    @Override
    public void watch(String key, DataChangedEventListener dataChangedEventListener) {
        System.out.println();
    }

    /**
     * Close.
     */
    @Override
    public void close() {

    }

    /**
     * Initialize the lock of the key.
     *
     * @param key key of data
     */
    @Override
    public void initLock(String key) {

    }

    /**
     * Try to get the lock of the key.
     *
     * @return get the lock or not
     */
    @Override
    public boolean tryLock() {
        return false;
    }

    /**
     * Try to release the lock of the key.
     */
    @Override
    public void tryRelease() {

    }

    /**
     * Get algorithm type.
     *
     * @return type
     */
    @Override
    public String getType() {
        return "shardRegistryCenter";
    }

    /**
     * Get properties.
     *
     * @return properties of algorithm
     */
    @Override
    public Properties getProperties() {
        return null;
    }

    /**
     * Set properties.
     *
     * @param properties properties of algorithm
     */
    @Override
    public void setProperties(Properties properties) {

    }
}
