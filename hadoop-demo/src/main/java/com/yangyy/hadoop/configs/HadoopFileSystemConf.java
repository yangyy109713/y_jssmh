package com.yangyy.hadoop.configs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HadoopFileSystemConf {

    private Configuration conf = new Configuration();
    private FileSystem fileSystem = null;

    @Autowired(required = false)
    ConfProperties confProperties;

    //设置hdfs文件系统配置信息
    public FileSystem setConfs(FileSystem fileSystem){
        conf.set("fs.defaultFS", confProperties.defaultFs);//hdfs文件系统地址
        conf.set("fs.hdfs.impl",confProperties.hdfsImpl);//实现方式：使用FileSystem访问hdfs系统
        conf.set(confProperties.hdfsPolicyName, confProperties.hdfsPolicyValue);
        conf.set(confProperties.hdfHostName, confProperties.hdfHostValue);
        try {
            fileSystem = FileSystem.get(conf);
        }catch (IOException i){
            i.printStackTrace();
        }
        return fileSystem;
    }

    //连接hdfs文件系统是否成功
    public boolean isConnected(){
        if(fileSystem != null){
            return true;
        } else return false;
    }

    //关闭hdfs文件系统的连接
    public void closeHdfs(){
        if(fileSystem != null){
            try {
                fileSystem.close();
            }catch (IOException i){
                i.printStackTrace();
            }
        }
    }
}
