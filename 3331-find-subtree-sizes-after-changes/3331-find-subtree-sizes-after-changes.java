class Solution {
    int[] ans;
    List<Integer>[] children;
    int[] newParent;
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        children = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        newParent = parent.clone();
        int[] last = new int[26];
        Arrays.fill(last, -1);

        dfs1(0, s, last);

        for (int i = 0; i < n; i++) {
            children[i].clear();
        }
        for (int i = 1; i < n; i++) {
            children[newParent[i]].add(i);
        }

        ans = new int[n];
        dfs2(0);
        return ans;
    }

    void dfs1(int node, String s, int[] last) {
        int c = s.charAt(node) - 'a';

        int previous = last[c];

        if (previous != -1) {
            newParent[node] = previous;
        }

        last[c] = node;

        for (int child : children[node]) {
            dfs1(child, s, last);
        }

        last[c] = previous;
    }

    int dfs2(int node) {
        int size = 1;

        for (int child : children[node]) {
            size += dfs2(child);
        }

        ans[node] = size;
        return size;
    }
}
