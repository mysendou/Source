package com.jeff.memcache.demo;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

public class HelloMemcache {
    public static void main(String[] args) throws Exception {
        // 本地连接 Memcached 服务
        MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));

        System.out.println("Connection to server sucessfully");
        // 存储数据
        Future fo = mcc.set("jeff", 900, "Hello Memcache");

        // 查看存储状态
        System.out.println("set status:" + fo.get());

        // 输出值
        System.out.println("jeff value in cache - " + mcc.get("jeff"));

        fo = mcc.set("jeff", 900, "Memcache");

        // 查看存储状态
        System.out.println("set status:" + fo.get());

        // 输出值
        System.out.println("jeff value in cache - " + mcc.get("jeff"));

        /** 测试添加 **/
        // 添加新key
        fo = mcc.add("jeff1", 900, "Jeff1 test memcache");

        // 打印状态
        System.out.println("add status:" + fo.get());

        // 输出
        System.out.println("jeff1 value in cache - " + mcc.get("jeff1"));

        /** 测试替换 **/
        // 替换key
        fo = mcc.replace("jeff1", 900, "Jeff1 test memcache replace");

        // 打印状态
        System.out.println("add status:" + fo.get());

        // 输出
        System.out.println("jeff1 value in cache - " + mcc.get("jeff1"));

        // 清除
        mcc.flush().isDone();
        // 关闭连接
        mcc.shutdown();
    }
}
