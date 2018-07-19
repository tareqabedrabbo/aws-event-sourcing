package ps.mytakeaway.httpapi;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "aws.kinesis.producer", ignoreUnknownFields = false)
public class AwsKinesisProducerConfig {

    private int recordMaxBufferedTime;

    private String region;

    private int maxConnections;

    private int requestTimeout;

    private String commandInputStream;

    public int getRecordMaxBufferedTime() {
        return recordMaxBufferedTime;
    }

    public void setRecordMaxBufferedTime(int recordMaxBufferedTime) {
        this.recordMaxBufferedTime = recordMaxBufferedTime;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public int getRequestTimeout() {
        return requestTimeout;
    }

    public void setRequestTimeout(int requestTimeout) {
        this.requestTimeout = requestTimeout;
    }

    public String getCommandInputStream() {
        return commandInputStream;
    }

    public void setCommandInputStream(String commandInputStream) {
        this.commandInputStream = commandInputStream;
    }

    @Override
    public String toString() {
        return "AwsKinesisProducerConfig{" +
                "recordMaxBufferedTime=" + recordMaxBufferedTime +
                ", region='" + region + '\'' +
                ", maxConnections=" + maxConnections +
                ", requestTimeout=" + requestTimeout +
                ", commandInputStream='" + commandInputStream + '\'' +
                '}';
    }
}
