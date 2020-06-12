package com.saury.mockito.demo;

import static org.mockito.Mockito.*;

import java.util.LinkedList;

/**
 * 怎么存根
 * 
 * @author yase
 * @since 2019/7/8 下午2:05
 */
public class Demo2 {

    public static void main(String[] args) {
        LinkedList mockedList = mock(LinkedList.class);

        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedList.get(0));// 打印的是“first”
        System.out.println(mockedList.get(999));// 打印“null”，因为GET(999)没有存根
        System.out.println(mockedList.get(1));// 抛出运行时异常
        verify(mockedList).get(0);      //验证是否调用过get(0)

    }

}
