package xdx.note.framework.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "framework.redis")
public class RedisConfigProperties {

    private String mode;
    private String nodeAddresses;
    private Integer scanInterval;
    private Integer slots;
    private String readMode;
    private String subscriptionMode;
    private String loadBalancer;
    private Integer subscriptionConnectionMinimumIdleSize;
    private Integer subscriptionConnectionPoolSize;
    private Integer slaveConnectionMinimumIdleSize;
    private Integer slaveConnectionPoolSize;
    private Integer masterConnectionMinimumIdleSize;
    private Integer masterConnectionPoolSize;
    private Integer idleConnectionTimeout;
    private Integer connectTimeout;
    private Integer timeout;
    private Integer retryAttempts;
    private Integer retryInterval;
    private String password;
    private Integer subscriptionsPerConnection;
    private String clientName;
    private String sslEnableEndpointIdentification;
    private String sslProvider;
    private String sslTruststore;
    private String sslTruststorePassword;
    private String sslKeystore;
    private String sslKeystorePassword;


    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getNodeAddresses() {
        return nodeAddresses;
    }

    public void setNodeAddresses(String nodeAddresses) {
        this.nodeAddresses = nodeAddresses;
    }

    public Integer getScanInterval() {
        return scanInterval;
    }

    public void setScanInterval(Integer scanInterval) {
        this.scanInterval = scanInterval;
    }

    public Integer getSlots() {
        return slots;
    }

    public void setSlots(Integer slots) {
        this.slots = slots;
    }

    public String getReadMode() {
        return readMode;
    }

    public void setReadMode(String readMode) {
        this.readMode = readMode;
    }

    public String getSubscriptionMode() {
        return subscriptionMode;
    }

    public void setSubscriptionMode(String subscriptionMode) {
        this.subscriptionMode = subscriptionMode;
    }

    public String getLoadBalancer() {
        return loadBalancer;
    }

    public void setLoadBalancer(String loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    public Integer getSubscriptionConnectionMinimumIdleSize() {
        return subscriptionConnectionMinimumIdleSize;
    }

    public void setSubscriptionConnectionMinimumIdleSize(Integer subscriptionConnectionMinimumIdleSize) {
        this.subscriptionConnectionMinimumIdleSize = subscriptionConnectionMinimumIdleSize;
    }

    public Integer getSubscriptionConnectionPoolSize() {
        return subscriptionConnectionPoolSize;
    }

    public void setSubscriptionConnectionPoolSize(Integer subscriptionConnectionPoolSize) {
        this.subscriptionConnectionPoolSize = subscriptionConnectionPoolSize;
    }

    public Integer getSlaveConnectionMinimumIdleSize() {
        return slaveConnectionMinimumIdleSize;
    }

    public void setSlaveConnectionMinimumIdleSize(Integer slaveConnectionMinimumIdleSize) {
        this.slaveConnectionMinimumIdleSize = slaveConnectionMinimumIdleSize;
    }

    public Integer getSlaveConnectionPoolSize() {
        return slaveConnectionPoolSize;
    }

    public void setSlaveConnectionPoolSize(Integer slaveConnectionPoolSize) {
        this.slaveConnectionPoolSize = slaveConnectionPoolSize;
    }

    public Integer getMasterConnectionMinimumIdleSize() {
        return masterConnectionMinimumIdleSize;
    }

    public void setMasterConnectionMinimumIdleSize(Integer masterConnectionMinimumIdleSize) {
        this.masterConnectionMinimumIdleSize = masterConnectionMinimumIdleSize;
    }

    public Integer getMasterConnectionPoolSize() {
        return masterConnectionPoolSize;
    }

    public void setMasterConnectionPoolSize(Integer masterConnectionPoolSize) {
        this.masterConnectionPoolSize = masterConnectionPoolSize;
    }

    public Integer getIdleConnectionTimeout() {
        return idleConnectionTimeout;
    }

    public void setIdleConnectionTimeout(Integer idleConnectionTimeout) {
        this.idleConnectionTimeout = idleConnectionTimeout;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getRetryAttempts() {
        return retryAttempts;
    }

    public void setRetryAttempts(Integer retryAttempts) {
        this.retryAttempts = retryAttempts;
    }

    public Integer getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(Integer retryInterval) {
        this.retryInterval = retryInterval;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSubscriptionsPerConnection() {
        return subscriptionsPerConnection;
    }

    public void setSubscriptionsPerConnection(Integer subscriptionsPerConnection) {
        this.subscriptionsPerConnection = subscriptionsPerConnection;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getSslEnableEndpointIdentification() {
        return sslEnableEndpointIdentification;
    }

    public void setSslEnableEndpointIdentification(String sslEnableEndpointIdentification) {
        this.sslEnableEndpointIdentification = sslEnableEndpointIdentification;
    }

    public String getSslProvider() {
        return sslProvider;
    }

    public void setSslProvider(String sslProvider) {
        this.sslProvider = sslProvider;
    }

    public String getSslTruststore() {
        return sslTruststore;
    }

    public void setSslTruststore(String sslTruststore) {
        this.sslTruststore = sslTruststore;
    }

    public String getSslTruststorePassword() {
        return sslTruststorePassword;
    }

    public void setSslTruststorePassword(String sslTruststorePassword) {
        this.sslTruststorePassword = sslTruststorePassword;
    }

    public String getSslKeystore() {
        return sslKeystore;
    }

    public void setSslKeystore(String sslKeystore) {
        this.sslKeystore = sslKeystore;
    }

    public String getSslKeystorePassword() {
        return sslKeystorePassword;
    }

    public void setSslKeystorePassword(String sslKeystorePassword) {
        this.sslKeystorePassword = sslKeystorePassword;
    }
}
