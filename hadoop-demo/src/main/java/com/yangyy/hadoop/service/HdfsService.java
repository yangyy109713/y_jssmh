package com.yangyy.hadoop.service;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.hdfs.web.JsonUtil;
import org.apache.hadoop.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class HdfsService {
    @Value("${hdfs.path}")
    private String path;

    @Value("${hdfs.username}")
    private String username;

    private static String hdfsPath;

    private static String hdfsName;

    private static final int buffersize = 1024*1024*64;


    /**
     * 获取HDFS配置信息
     * @return
     */
    public static Configuration getConfiguration(){
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", hdfsPath);
        return configuration;
    }

    /**
     * 获取HDFS文件系统对象
     * @return
     * @throws Exception
     */
    public static FileSystem getFileSystem() throws Exception{
        //客户端去操作hdfs时需要一个用户身份，默认情况下hdfs客户端api会从jvm中获取一个参数作为自己的用户身份
        //HADOOP_USER_NAME = hadoop
        //也可以在构造客户端fs对象时，通过参数传过去
        FileSystem fileSystem = fileSystem = FileSystem.get(new URI(hdfsPath), getConfiguration(), hdfsName);
        return fileSystem;
    }

    /**
     * 在HDFS创建文件夹
     * @param path
     * @return
     * @throws Exception
     */
    public static boolean mkdir(String path) throws Exception{
        if (StringUtils.isEmpty(path)){
            return false;
        }
        if (existFile(path)){
            return true;
        }
        FileSystem fileSystem = getFileSystem();
        //目标路径
        Path srcPath = new Path(path);
        boolean isOk = fileSystem.mkdirs(srcPath);
        fileSystem.close();
        return isOk;
    }

    /**
     * HDFS文件是否存在
     * @param path
     * @return
     * @throws Exception
     */
    public static boolean existFile(String path) throws Exception{
        if (StringUtils.isEmpty(path)){
            return false;
        }
        FileSystem fileSystem = getFileSystem();
        //目标路径
        Path srcPath = new Path(path);
        boolean isExist = fileSystem.exists(srcPath);
        fileSystem.close();
        return isExist;
    }

    /**
     * 读取HDFS文件目录信息
     * @param path
     * @return
     * @throws Exception
     */
    public static List<Map<String, Object>> readPathInfo(String path) throws Exception{
        if (StringUtils.isEmpty(path))  return null;
        if (!existFile(path))   return null;
        FileSystem fileSystem = getFileSystem();
        //目标路径
        Path newPath = new Path(path);
        FileStatus[] statusList = fileSystem.listStatus(newPath);
        List<Map<String, Object>> list = new ArrayList<>();
        if(null != statusList && statusList.length > 0){
            for(FileStatus fileStatus : statusList){
                Map<String, Object> map = new HashMap<>();
                map.put("filePath", fileStatus.getPath());
                map.put("fileStatus", fileStatus.toString());
                list.add(map);
            }
            return list;
        }else
            return null;
    }

    /**
     * 在HDFS创建文件
     * @param path
     * @param file
     * @throws Exception
     */
    public static void createFile(String path, MultipartFile file) throws Exception{
        if(StringUtils.isEmpty(path) || null == file.getBytes()) return;
        String fileName = file.getOriginalFilename();
        FileSystem fileSystem = getFileSystem();
        //上传时默认当前目录，后面自动拼接文件的目录
        Path newPath = new Path(path+ "/"+ fileName);
        //打开一个输出流
        FSDataOutputStream outputStream = fileSystem.create(newPath);
        outputStream.write(file.getBytes());
        outputStream.close();
        fileSystem.close();
    }

    /**
     * 读取HDFS中文件内容
     * @param path
     * @return
     * @throws Exception
     */
    public static String readFile(String path) throws Exception{
        if (StringUtils.isEmpty(path))  return null;
        if (!existFile(path))   return null;
        FileSystem fileSystem = getFileSystem();
        //目标路径
        Path srcPath = new Path(path);

        FSDataInputStream inputStream = null;
        try {
            inputStream = fileSystem.open(srcPath);
            //防止中文乱码
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String lineTxt = "";
            StringBuilder builder = new StringBuilder();
            while ((lineTxt = reader.readLine()) != null){
                builder.append(lineTxt);
            }
            return builder.toString();
        }finally {
            inputStream.close();
            fileSystem.close();
        }

    }

    /**
     * 读取HDFS中文件列表
     * @param path
     * @return
     * @throws Exception
     */
    public static List<Map<String, String>> listFile(String path) throws Exception{
        if (StringUtils.isEmpty(path))  return null;
        if (!existFile(path))   return null;
        FileSystem fileSystem = getFileSystem();
        //目标路径
        Path srcPath = new Path(path);

        //递归找到所有文件
        RemoteIterator<LocatedFileStatus> fileList = fileSystem.listFiles(srcPath, true);
        List<Map<String, String>> returnList = new ArrayList<>();
        while (fileList.hasNext()){
            LocatedFileStatus next = fileList.next();
            Map<String, String> map = new HashMap<>();
            map.put("FileName", next.getPath().getName());
            map.put("FilePath", next.getPath().toString());
            map.put("Permission ", next.getPermission().toString());
            map.put("Owner", next.getOwner());
            map.put("Group", next.getGroup());
            map.put("Length", String.valueOf(next.getLen()));
            map.put("IsDir", String.valueOf(next.isDirectory()));
            returnList.add(map);
        }
        fileSystem.close();
        return returnList;
    }

    /**
     * HDFS中重命名文件
     * @param oldName
     * @param newName
     * @return
     * @throws Exception
     */
    public static boolean renameFile(String oldName, String newName) throws Exception{
        if(StringUtils.isEmpty(oldName) || StringUtils.isEmpty(newName)) return false;
        FileSystem fileSystem = getFileSystem();
        //源文件目标路径
        Path oldPath = new Path(oldName);
        //重命名文件目标路径
        Path newPath = new Path(newName);
        boolean isOk = fileSystem.rename(oldPath, newPath);
        fileSystem.close();
        return isOk;
    }

    /**
     * 从HDFS中删除文件
     * @param path
     * @return
     * @throws Exception
     */
    public static boolean deleteFile(String path) throws Exception{
        if(StringUtils.isEmpty(path)) return false;
        if(!existFile(path)) return false;
        FileSystem fileSystem = getFileSystem();
        Path srcPath = new Path(path);
        boolean isOk = fileSystem.deleteOnExit(srcPath);
        fileSystem.close();
        return isOk;
    }

    /**
     * 上传文件至HDFS
     * @param path
     * @param uploadPath
     * @return
     * @throws Exception
     */
    public static void uploadFile(String path, String uploadPath) throws Exception{
        if(StringUtils.isEmpty(path) || StringUtils.isEmpty(uploadPath)) return;
        FileSystem fileSystem = getFileSystem();
        //待上传文件路径
        Path from = new Path(path);
        //上传至的目标路径
        Path to = new Path(uploadPath);
        //调用文件系统的文件复制方法，第一个参数表示是否删除原文件，默认为false
        fileSystem.copyFromLocalFile(false, from, to);
    }

    /**
     * 从HDFS下载文件
     * @param path
     * @param dowloadPath
     * @return
     * @throws Exception
     */
    public static void downloadFile(String path, String dowloadPath) throws Exception{
        if(StringUtils.isEmpty(path) || StringUtils.isEmpty(dowloadPath)) return;
        FileSystem fileSystem = getFileSystem();
        //下载路径
        Path from = new Path(path);
        //下载至的目标路径
        Path to = new Path(dowloadPath);
        //调用文件系统的文件复制方法，第一个参数表示是否删除原文件，默认为false
        fileSystem.copyToLocalFile(false, from, to);
    }

    /**
     * HDFS文件复制
     * @param sourcePath
     * @param targetPath
     * @throws Exception
     */
    public static void copyFile(String sourcePath, String targetPath) throws Exception{
        if(StringUtils.isEmpty(sourcePath) || StringUtils.isEmpty(targetPath)) return;
        FileSystem fileSystem = getFileSystem();
        FSDataInputStream inputStream = null;
        FSDataOutputStream outputStream = null;
        //被复制路径
        Path from = new Path(sourcePath);
        //复制至目标路径
        Path to = new Path(targetPath);

        try {
            inputStream = fileSystem.open(from);
            outputStream = fileSystem.create(to);
            IOUtils.copyBytes(inputStream, outputStream, buffersize, false);
        }finally {
            inputStream.close();
            outputStream.close();
            fileSystem.close();
        }
    }

    /**
     * 打开HDFS上的文件并返回byte数组
     * @param path
     * @return
     * @throws Exception
     */
    public static byte[] openFileToBytes(String path) throws Exception{
        if(StringUtils.isEmpty(path)) return null;
        if(!existFile(path)) return null;
        FileSystem fileSystem = getFileSystem();
        Path srcPath = new Path(path);
        try {
            FSDataInputStream inputStream = fileSystem.open(srcPath);
            return IOUtils.readFullyToByteArray(inputStream);
        }finally {
            fileSystem.close();
        }
    }

    /**
     * 打开HDFS上的文件并返回java对象
     * @param path
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T extends Object> T openFileToObject(String path, Class<T> clazz) throws Exception{
        if(StringUtils.isEmpty(path)) return null;
        if(!existFile(path)) return null;
        String jsonStr = readFile(path);
        //TODO JsonUtil需要 import com.util.JsonUtil; 需要自定义JsonUtil的实现方式
        //return JsonUtil.fromObject(jsonStr, clazz);
        return null;
    }

    /**
     * 获取某个文件在HDFS的集群位置
     * @param path
     * @return
     * @throws Exception
     */
    public static BlockLocation[] getFileBlockLocations(String path) throws Exception{
        if(StringUtils.isEmpty(path)) return null;
        if(!existFile(path)) return null;
        FileSystem fileSystem = getFileSystem();
        Path p = new Path(path);
        FileStatus fileStatus = fileSystem.getFileStatus(p);
        return fileSystem.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());
    }

    @PostConstruct
    public void getPath(){
        hdfsPath = this.path;
    }

    @PostConstruct
    public void getName(){
        hdfsName = this.username;
    }

    public static String getHdfsPath() {
        return hdfsPath;
    }

    public String getUsername() {
        return username;
    }
}
