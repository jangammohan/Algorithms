package com.example.August.BFS;

import java.util.*;

public class DivisionEvaluateDFS {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> map = new HashMap<>();

        for(int i=0; i<equations.size(); i++) {
            List<String> eq = equations.get(i);
            String start = eq.get(0);
            String end = eq.get(1);
            map.putIfAbsent(start, new HashMap<>());
            map.get(start).put(end, values[i]);
            map.putIfAbsent(end, new HashMap<>());
            map.get(end).put(start, 1.0 / values[i]);
        }
        double[] result = new double[values.length];

       // Set<String> visited = new HashSet<>();
        for(int j=0; j<  queries.size();j++) {
            List<String> query = queries.get(j);
            result[j] = calcEq(map, query.get(0), query.get(1), new HashSet<>());
        }

        return result;
    }

    public double calcEq(Map<String, Map<String, Double>> map, String start, String end, Set<String> visit  ) {


        if(map.get(start) == null ) {
            return -1.0;
        }
        if(map.get(start).containsKey(end)) {
            return map.get(start).get(end);
        }

        visit.add(start);

        for ( Map.Entry<String, Double> curr : map.get(start).entrySet()  ) {
            if(visit.contains(curr.getKey())) {
                continue;
            }
            double res = calcEq(map, curr.getKey(), end, visit);
            if(res == -1.0) {
                return -1.0;
            }
            return res * curr.getValue();
        }

        return -1.0;
    }
}
