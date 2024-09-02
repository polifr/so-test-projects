package com.example.linewebhookjava.service;

import org.junit.jupiter.api.Test;

class MyNewServiceTest {

    @Test
    void getGoodbye() {
//        int result = solution(new int[]{1, 3, 6, 4, 1, 2});
        boolean result = solution2("ba");
        System.out.println(result);
    }

    public int solution(int[] pos) {
        int x = 1;

        for (int i = 0; i < pos.length; i++) {
            if (pos[i] > 0 && pos[i] > x) {
                return x;
            }
            x = pos[i] + 1;
        }
        return x;
    }

    public boolean solution2(String S) {
        int i = S.lastIndexOf("a");
        int j = S.indexOf("b");
        return i < j;
//        if (!S.contains("a")) {
//            return true;
//        }
//        return false;
    }
}