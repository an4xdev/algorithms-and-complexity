import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListOne<T extends Comparable<T>> implements Iterable<T>, IList<T> {
    private ElemOne<T> first;
    private ElemOne<T> last;
    private int count;

    public ListOne() {
        count = 0;
    }

    public void print() {
        if (first != null) {
            ElemOne<T> temp = first;
            while (temp != null) {
                System.out.print(temp.getData() + ", ");
                temp = temp.getNext();
            }
            System.out.println();
        }

    }

    @Override
    public void addFirst(T newData) {
        ElemOne<T> nd = new ElemOne<T>(newData);
        if (first == null) {
            first = nd;
            last = nd;
        } else {
            ElemOne<T> temp = first;
            first = nd;
            nd.setNext(temp);
        }
        count++;
    }

    @Override
    public void addLast(T newData) {
        ElemOne<T> nd = new ElemOne<T>(newData);
        if (first == null) {
            first = nd;
            last = nd;
        } else {
            ElemOne<T> temp = first;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(nd);
            last = nd;
        }
        count++;
    }

    @Override
    public void addAtPosition(T newData, int position) throws ListException {
        if (position > count)
            throw new ListException("Cannot add on position: " + position + ", when size of list is: " + count);
        if (position < 0)
            throw new ListException("Cannot add on negative position");
        if (first == null) {
            throw new ListException("Cannot add on position when list is empty");
        }
        if (position == 0)
            addFirst(newData);
        else if (position == count)
            addLast(newData);
        else {
            int coutner = 0;
            ElemOne<T> temp = first;
            while ((coutner + 1) != position) {
                temp = temp.getNext();
                coutner++;
            }
            ElemOne<T> nd = new ElemOne<T>(newData);
            ElemOne<T> temp1 = temp.getNext();
            temp.setNext(nd);
            nd.setNext(temp1);
        }
        count++;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public T get(int position) throws ListException {
        if (position > count)
            throw new ListException("Cannot get on position: " + position + ", when size of list is: " + count);
        if (position < 0)
            throw new ListException("Cannot get on negative position");
        if (first == null) {
            throw new ListException("Cannot get on position when list is empty");
        }
        T returned;
        if (position == 0)
            returned = first.getData();
        else if (position == count)
            returned = last.getData();
        else {
            int coutner = 0;
            ElemOne<T> temp = first;
            while (coutner != position) {
                temp = temp.getNext();
                coutner++;
            }
            returned = temp.getData();
        }

        return returned;
    }

    @Override
    public T removeFirst() throws ListException {

        if (first == null)
            throw new ListException("Cannot remove first when list is empty.");
        ElemOne<T> returned = first;
        first = first.getNext();
        count--;
        return returned.getData();
    }

    @Override
    public T removeLast() throws ListException {
        if (last == null)
            throw new ListException("Cannot remove last when list is empty");
        ElemOne<T> returned = last;
        ElemOne<T> temp = first;
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(null);
        count--;
        return returned.getData();
    }

    @Override
    public T remove(int position) throws ListException {
        if (position > count)
            throw new ListException("Cannot get on position: " + position + ", when size of list is: " + count);
        if (position < 0)
            throw new ListException("Cannot get on negative position");
        if (first == null) {
            throw new ListException("Cannot get on position when list is empty");
        }
        ElemOne<T> returned;
        if (position == 0)
            returned = first;
        else if (position == count)
            returned = last;
        else {
            int coutner = 0;
            ElemOne<T> temp = first;
            while ((coutner + 1) != position) {
                temp = temp.getNext();
                coutner++;
            }

            returned = temp.getNext();
            temp.setNext(temp.getNext().getNext());
        }
        count--;
        return returned.getData();
    }

    @Override
    public int find(T dataToFind) {
        int returned = -1;
        int counter = 0;
        ElemOne<T> temp = first;
        while (temp != null) {
            if (temp.getData() == dataToFind)
                break;
            temp = temp.getNext();
            counter++;
        }
        if (temp != null)
            if (temp.getData() == dataToFind)
                returned = counter;
        return returned;
    }

    @Override
    public boolean contains(T data) {
        int counter = 0;
        ElemOne<T> temp = first;
        while (temp != null) {
            if (temp.getData() == data)
                return true;
            temp = temp.getNext();
            counter++;
        }
        return false;
    }

    @Override

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private ElemOne<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.getData();
            current = current.getNext();
            return data;
        }
    }

    @Override
    public IList<T> join(IList<T> druga) {
        ListOne<T> returned = new ListOne<T>();
        for (T t : this) {
            returned.addLast(t);
        }
        for (T t : (ListOne<T>) druga) {
            returned.addLast(t);
        }
        return returned;
    }

    @Override
    public boolean similar(IList<T> druga) {
        if (count != druga.size())
            return false;
        boolean isSimilar = true;
        for (T t : this) {
            if (!druga.contains(t)) {
                isSimilar = false;
                break;
            }
        }
        return isSimilar;
    }

    public void addSorted(T data) {
        if (first == null) {
            addFirst(data);
        } else if (data.compareTo(first.getData()) < 0) {
            addFirst(data);
        } else if (data.compareTo(last.getData()) > 0) {
            addLast(data);
        } else {
            int counter = 0;
            for (T element : this) {
                if (data.compareTo(element) > 0) {
                    break;
                }
                counter++;
            }
            try {
                addAtPosition(data, counter + 1);
            } catch (ListException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
