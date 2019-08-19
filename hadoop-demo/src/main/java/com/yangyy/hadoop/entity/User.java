package com.yangyy.hadoop.entity;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 用户实体类
 * @author yuanyuanyang
 */
public class User implements Writable {

    private String username;

    private Integer age;

    private String address;

    public User(){
        super();
    }

    public User(String username, Integer age, String address){
        super();
        this.username = username;
        this.address = address;
        this.age = age;
    }

    @Override
    public void write(DataOutput output){
        try {
            //把对象序列化
            output.writeChars(username);
            output.writeInt(age);
            output.writeChars(address);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void readFields(DataInput input){
        try {
            //把序列化的对象读取到内存中
            username = input.readUTF();
            age = input.readInt();
            address = input.readUTF();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return "User [username=" + username + ", age=" + age + ", address=" + address + "]";
    }
}
