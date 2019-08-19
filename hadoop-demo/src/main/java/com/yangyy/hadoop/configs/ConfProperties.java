package com.yangyy.hadoop.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//类使用@Component注解后，在其他类中可通过@Autowired注解引用
@Component
public class ConfProperties {
    @Value("${hdfs.path}")
    public String defaultFs;

    @Value("${fs.hdfs.impl}")
    public String hdfsImpl;

    @Value("${dfs.policy.name}")
    public String hdfsPolicyName;

    @Value("${dfs.policy.value}")
    public String hdfsPolicyValue;

    @Value("${dfs.host.name}")
    public String hdfHostName;

    @Value("${dfs.host.value}")
    public String hdfHostValue;
}
