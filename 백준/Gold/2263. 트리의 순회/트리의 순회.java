import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] inOrder;
    static int[] postOrder;
    static int[] preOrder;
    static int inIdx[];
    static int N;
    static int preIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inOrder = new int[N];
        postOrder = new int[N];
        preOrder = new int[N];
        inIdx = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            inIdx[inOrder[i]] = i;
        }

        preIdx = 0;
        getPreOrder(0, N - 1, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(preOrder[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

    static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;

        int root = postOrder[postEnd];
        preOrder[preIdx++] = root;

        int rootIndex = inIdx[root];
        int leftTreeSize = rootIndex - inStart;

        getPreOrder(inStart, rootIndex - 1, postStart, postStart + leftTreeSize - 1);
        getPreOrder(rootIndex + 1, inEnd, postStart + leftTreeSize, postEnd - 1);
    }
}