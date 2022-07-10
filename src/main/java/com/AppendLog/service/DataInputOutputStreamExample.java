package com.AppendLog.service;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamExample {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("./text2.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        System.out.println(fos);


    }
}
