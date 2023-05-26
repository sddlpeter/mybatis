package com.powernode.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestBank {

    public static void main(String[] args) {

    }
    @Test
    public static Object getMapper(SqlSession sqlSession, Class daoInterface) {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass(daoInterface.getPackageName() + ".impl." + daoInterface.getSimpleName() + "Impl");
        System.out.println(ctClass.getName());
        return null;
    }
}
