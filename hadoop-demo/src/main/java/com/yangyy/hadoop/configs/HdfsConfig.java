package com.yangyy.hadoop.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * HDFS配置类
 * @author yuanyuanyang
 *
 */

@Configuration
public class HdfsConfig {
    @Value("${hdfs.path}")
    private String hdfsPath;

    public String getHdfsPath() {
        return hdfsPath;
    }

    public void setHdfsPath(String hdfsPath) {
        this.hdfsPath = hdfsPath;
    }
}
