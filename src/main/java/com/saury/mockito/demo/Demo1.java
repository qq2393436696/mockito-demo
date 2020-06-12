package com.saury.mockito.demo;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author yase
 * @since 2019/7/8 下午2:01
 */
public class Demo1 {

    public static void main(String[] args) {

        List mockedList = mock(List.class);//根据数据模板生成模拟数据
        mockedList.add("1");// 使用模拟对象-它不会抛出任何“意外交互”异常
        System.out.println(mockedList.size());
        mockedList.clear();
        verify(mockedList).add("1");//验证add("1")调用次数是否为1，如果注释掉mockedList.add("1");就会抛出异常
        //verify() 选择性、显式、可读性高的验证(verify验证调用次数，默认为1)
        verify(mockedList).clear();//验证clear()调用次数是否为1，如果注释掉 mockedList.clear();就会抛出异常
    }


}
