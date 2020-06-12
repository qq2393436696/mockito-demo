package com.saury.mockito.demo;

import static org.mockito.Mockito.*;

import java.util.LinkedList;

/**
 * 查找冗余调用
 * 
 * @author yase
 * @since 2019/7/8 下午3:40
 */
public class demo5 {

    public static void main(String[] args) {
        LinkedList mockList = mock(LinkedList.class);

        mockList.add("1");
        mockList.add("2");
        verify(mockList).add("1");
         /*verifyNoMoreInteractions()方法可以传入多个
         mock对象作为参数，用来验证传入的这些mock对象是否存在没有验证过的调用方法。*/
        verifyNoMoreInteractions(mockList);// 这里因为没有对add("two")进行验证，所以这里会报错
    }

}
