public class ResizingArrayQueue<T> implements Queue<T> {
    private static final int INITIAL_SIZE = 1;
    private Object[] array = new Object[INITIAL_SIZE];
    private int headPointer = 0;
    private int tailPointer = 0;
    @Override
    public boolean isEmpty() {
        return headPointer == tailPointer;
    }

    @Override
    public void enqueue(T item) {
        System.out.println("Adding element " + item);
        if (headPointer >= array.length-1) {
            Object[] newArray = new Object[array.length*2];
            for (int ii = tailPointer; ii <= headPointer; ii++) {
                newArray[ii - tailPointer] = array[ii];
            }
            headPointer -= tailPointer;
            tailPointer = 0;
            array = newArray;
            System.out.println("Array increased. Size " + array.length);

        }
        array[headPointer++] = item;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        Object item = getAndCleanPointer(tailPointer++);
        if (headPointer - tailPointer < array.length/4) {
            Object[] newArray = new Object[array.length/4 == 0 ? 1 : array.length/4];
            for (int ii = tailPointer; ii <= headPointer; ii++) {
                newArray[ii - tailPointer] = array[ii];
            }
            headPointer -= tailPointer;
            tailPointer = 0;
            array = newArray;
            System.out.println("Array decreased. Size " + array.length);
        }
        return (T) item;
    }

    private Object getAndCleanPointer(int pointer) {
        Object item = array[pointer];
        array[pointer] = null;
        return item;
    }
}
