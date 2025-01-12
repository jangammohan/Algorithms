package com.example.september.array;




import java.util.*;

public class AccountsMerge_721 {

    public static void main(String[] args) {
        AccountsMerge_721 merge = new AccountsMerge_721();

        List<List<String>> accounts = new ArrayList<>();

        accounts.add(new ArrayList<String>() {{
            add("John");
            add("johnsmith@mail.com");
            add("john_newyork@mail.com");
        }});

        accounts.add(new ArrayList<String>() {{
            add("John");
            add("johnsmith@mail.com");
            add("john00@mail.com");
        }});

        accounts.add(new ArrayList<String>() {{
            add("Mary");
            add("mary@mail.com");
        }});

        accounts.add(new ArrayList<String>() {{
            add("John");
            add("johnnybravo@mail.com");
        }});
        List<List<String>> mergeList = merge.accountsMerge(accounts);
        System.out.println(merge.toString());
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        HashMap<String, List<Integer>> map = new HashMap<>();
        int index = 0;
        for(List<String> list : accounts) {

            for (int i =1; i< list.size(); i++) {
                map.computeIfAbsent(list.get(i), key->new ArrayList<>()).add(index);
            }

            index++;

        }

        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[accounts.size()];

        for (int i =0; i<accounts.size(); i++) {
            Set<String> set = new TreeSet<>();
               dfs(accounts, visited, i, set, map);

               if(!set.isEmpty()) {
                   List<String> list = new LinkedList<>(set);
                   list.add(0, accounts.get(i).get(0));
                   result.add(list);
               }


        }

        return result;

    }

    private void dfs(List<List<String>> accounts, boolean[] visited, int ind, Set<String> set, Map<String, List<Integer>> map) {
        if(visited[ind]) {
            return;
        }
        visited[ind] = true;
        for(int i =1; i<accounts.get(ind).size();i++) {
            String email = accounts.get(ind).get(i);
            set.add(accounts.get(ind).get(i));

            List<Integer> maplist = map.get(email);
            if(maplist.size() > 1) {
                for(Integer currInd :  maplist) {
                    dfs(accounts, visited, currInd, set, map);
                }
            }

        }
    }
}
