package com.example.november;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RemoveSubFolders_1233 {

    public static void main(String[] args) {
        RemoveSubFolders_1233 rem = new RemoveSubFolders_1233();
        System.out.println(rem.removeSubfolders(new String[]{"/ah/al/am", "/ah/al"}));
    }

    public List<String> removeSubfolders(String[] folder) {

        List<String> res = new ArrayList<>();

        Arrays.sort(folder, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        for (int i = 0; i < folder.length; i++) {
            String temp = folder[i];
            for (int j = i + 1; j < folder.length; j++) {

                if (folder[j].length() > temp.length() && folder[j].startsWith(temp)
                        && folder[j].charAt(temp.length()) == '/') {
                    folder[j] = "@";
                }
            }

        }

        for (String st : folder) {
            if (!st.equals("@")) {
                res.add(st);
            }
        }
        return res;
    }


    //leetcode solution
   public  List<String> removeSubfoldersleet(String[] folder) {
        List<String> res = new ArrayList<>();
        Arrays.sort(folder);


        res.add(folder[0]);

        for(int i =1; i<folder.length; i++) {
            String last = res.get(res.size()-1)+"/";

            if(!folder[i].startsWith(last)) {
                res.add(folder[i]);
            }

        }
        return res;
    }
}
