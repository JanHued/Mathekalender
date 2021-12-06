package Permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void perm1(String s) {
        List<String> perm = new ArrayList<>();
        perm1("", s, perm);
        System.out.println(perm.size());
        System.out.println(perm.indexOf("ABCDEFGHI") + 1);
    }

    private static void perm1(String prefix, String s, List<String> perm) {
        int n = s.length();
        if (n == 0) {
            perm.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n), perm);
            }
        }
    }

    public static void main(String[] args) {
        String s = "ABCDEFGHI";

        perm1(s);
    }
}
