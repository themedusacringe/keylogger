package haemanth;

import static org.junit.Assert.*;

import org.junit.Test;
    public class testdemo {
        @Test
        public void test_JUnit() {
            System.out.println("This is the testcase in this class");
            String str1="This is the testcase in this class";
            assertEquals("This is the testcase in this class", str1);
        }
    }

