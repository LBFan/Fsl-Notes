package com.fan.focusoffer2.weekexam.week7;

/**
 * @author : PF_23
 * @Description : TODO
 * @date : 2022/4/16 10:29.
 */

public class Trie {

    Trie[] children;
    boolean isEnd;

    public Trie() {
        // 这里是26个小写字母，其他情况需要按需设置
        children = new Trie[26];
        // 这一句写不写都可以，因为默认就是false
        isEnd = false;
    }

}

