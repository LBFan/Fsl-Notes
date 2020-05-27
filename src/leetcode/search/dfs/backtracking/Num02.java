package leetcode.search.dfs.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  PF_23
 * @Description : IP 地址划分
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"].
 * @date : 2020/02/23.
 */

public class Num02 {
    public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<>();
        StringBuilder tempAddress = new StringBuilder();
        doRestore(0, tempAddress, addresses, s);
        return addresses;
    }

    private void doRestore(int k, StringBuilder tempAddress, List<String> addresses, String s) {
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {
                addresses.add(tempAddress.toString());
            }
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            String part = s.substring(0, i + 1);
            if (Integer.parseInt(part) <= 255) {
                if (tempAddress.length() != 0) {
                    part += '.' + part;
                }
                tempAddress.append(part);
                doRestore(k + 1, tempAddress, addresses, s);
                tempAddress.delete(tempAddress.length() - part.length(),
                        tempAddress.length());
            }
        }
    }
}

