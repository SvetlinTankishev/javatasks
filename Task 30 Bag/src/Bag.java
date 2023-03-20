import java.util.*;

public class Bag<T> implements Iterable<T> {
    private Object[] items;
    private int size;
    private Random random;

    public Bag() {
        items = new Object[10];
        size = 0;
        random = new Random();
    }

    public T grab() {
        if (isEmpty()) {
            throw new NoSuchElementException("Bag is empty");
        }
        return (T) items[random.nextInt(size)];
    }

    public T grab(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return (T) items[index];
    }

    public boolean add(T item) {
        if (size == items.length) {
            Object[] newItems = new Object[size * 2];
            System.arraycopy(items, 0, newItems, 0, size);
            items = newItems;
        }
        items[size++] = item;
        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        items[--size] = null;
        return true;
    }

    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, items[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, items[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(items, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            public boolean hasNext() {
                return index < size;
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) items[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public T[] toArray() {
        return Arrays.copyOf(items, size, (Class<? extends T[]>) items.getClass());
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(items[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}