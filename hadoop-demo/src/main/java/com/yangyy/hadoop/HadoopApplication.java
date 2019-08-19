package com.yangyy.hadoop;

import org.apache.hadoop.fs.FsShell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HadoopApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HadoopApplication.class, args);
    }

    @Autowired(required = false)
    FsShell fsShell;

    @Override
    public void run(String ... strings) throws Exception {
        System.out.println("....hadoop test run start...");
        /*for (FileStatus fileStatus : fsShell.ls("/data")){
            System.out.println("> " + fileStatus.getPath());
        }*/
        System.out.println("....hadoop test run end...");
    }
}
