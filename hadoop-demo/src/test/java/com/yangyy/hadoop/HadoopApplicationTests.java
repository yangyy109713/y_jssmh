package com.yangyy.hadoop;

import com.yangyy.hadoop.configs.HadoopFileSystemConf;
import com.yangyy.hadoop.utils.DateFormat;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HadoopApplicationTests {

    @Autowired
    HadoopFileSystemConf hadoopConf;

    private FileSystem fileSystem = null;

    @Before
    public void before(){
        fileSystem = hadoopConf.setConfs(fileSystem);
    }

    @After
    public void after(){
        hadoopConf.closeHdfs();
        if (fileSystem == null){
            System.out.println("close hadoop success!");
        }else
            System.out.println("close hadoop fail!");
    }


    @Test
    public void connect(){
        if (hadoopConf.isConnected()){
            System.out.println("connect hadoop success!");
        }else
            System.out.println("connect hadoop fail!");
    }

    @Test
    public void hadoop1() throws Exception{
        //FileStatus对象封装了文件和目录的元数据，包括文件长度，块大小和权限等
        FileStatus fileStatus = fileSystem.getFileStatus(new Path("/output/grepresult/part-r-00000"));
        System.out.println("Permission:\t "+ fileStatus.getPermission());//文件权限
        System.out.println("Owner:\t\t "+ fileStatus.getOwner());//文件拥有者
        System.out.println("Group:\t\t "+ fileStatus.getGroup());//文件所属组
        System.out.println("Length:\t\t "+ fileStatus.getLen()+"B");//文件长度
        System.out.println("IsDir:\t\t "+ fileStatus.isDirectory());//是不是目录
        System.out.println("Last Modified:\t "+ DateFormat.getModificationTimeFormat(fileStatus.getModificationTime()));//文件最后修改时间
        System.out.println("Last Access:\t "+ DateFormat.getModificationTimeFormat(fileStatus.getAccessTime()));//文件最后访问时间
        System.out.println("Block Size:\t "+ fileStatus.getBlockSize()/1024/1024+"MB");//文件块大小
        System.out.println("Block Replication:\t "+ fileStatus.getReplication());//文件块副本数
        System.out.println("Name:\t\t "+ fileStatus.getPath().getName());//文件名
        System.out.println("Path:\t\t "+ fileStatus.getPath());//文件路径-绝对路径
        //System.out.println("Symlink:\t\t "+ fileStatus.getSymlink());//符号链接，若isdir为true那么symlink必为null；否则print报错
    }
}
