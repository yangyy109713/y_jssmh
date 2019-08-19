package com.yangyy.hadoop.configs;

/**
 * 对hdfs的操作包含：
 * 1.Configuration 封装客户端或服务器的配置信息
 * 2.FileSystem 该类的对象是一个文件系统，可以用对象的一些方法来对文件进行操作
 *  通过FileSystem.get(conf);获取对象
 *  例子：FileSystem fs = FileSystem.get(conf);
 * 3.FSDataInputStream hdfs中的输入流，通过FileSystem的open方法获取
 * 4.FSDataOutputStream hdfs中的输出流，通过FileSystem的create方法获取
 **/