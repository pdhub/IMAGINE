package HackerRank.DisjointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by PDeb on 10/4/2017.
 */
public class MergingCommunities {
    public static void main(String[] args) throws IOException {
        Integer numPersons = new Integer(0);
        Integer numQueries = new Integer(0);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputo[] = br.readLine().split(" ");
        numPersons = Integer.valueOf(inputo[0]);
        numQueries = Integer.valueOf(inputo[1]);
        int persons[] = new int[numPersons+1];
        int size[] = new int[numPersons+1];
        initializePersonsAndSize(persons, size);

        for (int i = 0; i < numQueries; i++) {
            String input[] = br.readLine().split(" ");
            if(isToMerge(input))
            {
                int leftnode = Integer.valueOf(input[1]);
                int rightnode = Integer.valueOf(input[2]);
                union(leftnode, rightnode, size, persons);
            }
            else if(showSize(input))
            {
                System.out.println(size[findRoot(Integer.valueOf(input[1]),persons)]);
            }
        }
    }

    private static void union(int leftnode, int rightnode, int[] size, int[] persons) {
        int rootLeft = findRoot(leftnode, persons);
        int rootRight = findRoot(rightnode, persons);
        if(size[rootLeft] > size[rootRight])
        {
            persons[rootRight] = persons[rootLeft];
            size[rootLeft] += size[rootRight];
        }
        else
        {
            persons[rootLeft] = persons[rootRight];
            size[rootRight] += size[rootLeft];
        }
    }

    private static int findRoot(int node, int[] persons) {
        while (persons[node]!=node)
        {
            node = persons[node];
        }
        return node;
    }

    private static void initializePersonsAndSize(int[] persons, int[] size) {
        for (int i = 0; i < persons.length; i++) {
            persons[i] = i;
            size[i] = 1;
        }
    }

    private static boolean isToMerge(String[] input) {
        return input[0].equals("M");
    }

    private static boolean showSize(String[] input) {
        return input[0].equals("Q");
    }

}
