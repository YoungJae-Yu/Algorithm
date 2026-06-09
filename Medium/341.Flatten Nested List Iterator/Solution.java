import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    private final Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        pushAll(nestedList);
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            pushAll(stack.pop().getList());
        }
        return !stack.isEmpty();
    }

    private void pushAll(List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
    }
}