package com.bjpowernode;

import org.junit.Assert;
import org.junit.Test;

public class TestCases {
    @Test
    public void testAdd() {
        System.out.println("============ test add ===========");
        TestJunit program = new TestJunit();
        int res = program.add(10,20);
        Assert.assertEquals(res, 30);
    }

    @Test
    public void testSub() {
        System.out.println("============ test sub ============");
        TestJunit program = new TestJunit();
        int res = program.sub(50, 10);
        Assert.assertEquals(40, res);
    }
}
