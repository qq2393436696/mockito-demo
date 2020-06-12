package com.saury.mockito.demo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 连续调用(迭代器式存根)
 * 
 * @author test
 * @since 2019/7/8 下午3:56
 */
public class Demo6 {

    public static void main(String[] args) {

        Demo6 mock = mock(Demo6.class);
        
		when(mock.sayHello("test")).thenThrow(new RuntimeException("error")).thenReturn("test -- 你好");
        try {
            String result = mock.sayHello("test");// 第一次调用: 抛出异常
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("第一次调用抛出异常"+"error:" + e.getMessage());
        }

        System.out.println(mock.sayHello("test"));// 第二次调用 : 返回 test -- 你好
        System.out.println(mock.sayHello("test")); // 第三次调用 : 返回 test -- 你好

        System.out.println("========================");
        // 优化后：
        when(mock.sayHello("test2")).thenReturn("one", "two", "three");
        System.out.println(mock.sayHello("test2"));
        System.out.println(mock.sayHello("test2"));
        System.out.println(mock.sayHello("test2"));

        System.out.println("========================");
        // 如果 .thenReturn() 使用具有相同匹配器或参数的多个存
        // 根而不是链接调用则每个存在将覆盖前一个存根
        when(mock.sayHello("test3")).thenReturn("one");
        when(mock.sayHello("test3")).thenReturn("two");

        // 都返回two
        System.out.println(mock.sayHello("test3"));
        System.out.println(mock.sayHello("test3"));

    }

    public String sayHello(String name) {
        return name + " hello";
    }

}
