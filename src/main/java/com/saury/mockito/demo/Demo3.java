package com.saury.mockito.demo;

import java.util.LinkedList;

import static org.mockito.Mockito.*;

/**
 * 调用次数验证: 确切多少次／至少多少次／从不
 * @author yase
 * @since 2019/7/8 下午3:09
 */
public class Demo3 {

    public static void main(String[] args) {
        LinkedList mockedList = mock(LinkedList.class);

        mockedList.add("1");

        mockedList.add("2");
        mockedList.add("2");

        mockedList.add("3");
        mockedList.add("3");
        mockedList.add("3");

        verify(mockedList).add("1");   //验证增加过1
        verify(mockedList,times(1)).add("1");  //验证增加了一次1

        verify(mockedList,times(2)).add("2");  //验证增加了两次2
        verify(mockedList,times(3)).add("3");  //验证增加了三次3

        verify(mockedList,never()).add("0");  //验证没有增加过0

        verify(mockedList,atMost(1)).add("1");  //验证最多增加一次1
        verify(mockedList,atLeastOnce()).add("3");      //验证最少增加一次3
        verify(mockedList,atLeast(2)).add("3");  //验证最少增加两次3
        verify(mockedList,atMost(5)).add("3");  //验证最多增加五次3
    }

}
