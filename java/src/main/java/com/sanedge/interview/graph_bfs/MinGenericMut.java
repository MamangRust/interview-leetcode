package com.sanedge.interview.graph_bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinGenericMut {

    private static class GeneMutation {

        String gene;
        int steps;

        GeneMutation(String gene, int steps) {
            this.gene = gene;
            this.steps = steps;
        }
    }

    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        if (!bankSet.contains(end)) {
            return -1;
        }

        char[] genes = { 'A', 'C', 'G', 'T' };

        Queue<GeneMutation> queue = new LinkedList<>();
        queue.offer(new GeneMutation(start, 0));

        while (!queue.isEmpty()) {
            GeneMutation current = queue.poll();

            if (current.gene.equals(end)) {
                return current.steps;
            }

            for (int i = 0; i < current.gene.length(); i++) {
                for (char g : genes) {
                    char[] mutatedGene = current.gene.toCharArray();

                    mutatedGene[i] = g;

                    String mutated = new String(mutatedGene);

                    if (bankSet.contains(mutated)) {
                        queue.offer(
                            new GeneMutation(mutated, current.steps + 1)
                        );
                        bankSet.remove(mutated);
                    }
                }
            }
        }

        return -1;
    }
}
