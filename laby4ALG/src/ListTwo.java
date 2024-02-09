import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListTwo<T> implements Iterable<T>, IList<T> {

    private ElemTwo<T> first;
    private ElemTwo<T> last;
    private int counter;

    public ListTwo() {
        counter = 0;
    }

    public void print() {
        if (first != null) {
            ElemTwo<T> temp = first;
            while (temp != null) {
                System.out.print(temp.getData() + ", ");
                temp = temp.getNext();
            }
            System.out.println();
        }
    }

    @Override
    public void addFirst(T newData) {
        ElemTwo<T> nd = new ElemTwo<T>(newData);
        if (first == null) {
            first = nd;
            last = nd;
        } else {
            ElemTwo<T> temp = first;
            first = nd;
            first.setNext(temp);
            temp.setPrev(nd);
        }
        counter++;
    }

    @Override
    public void addLast(T newData) {
        ElemTwo<T> nd = new ElemTwo<T>(newData);
        if (first == null) {
            first = nd;
            last = nd;
        } else {
            ElemTwo<T> temp = last;
            last = nd;
            last.setPrev(temp);
            temp.setNext(last);
        }
        counter++;
    }

    @Override
    public void addAtPosition(T newData, int position) throws ListException {
        if (position > counter)
            throw new ListException("Cannot add on position: " + position + ", when size of list is: " + counter);
        if (position < 0)
            throw new ListException("Cannot add on negative position");
        if (first == null) {
            throw new ListException("Cannot add on position when list is empty");
        }
        if (position == 0)
            addFirst(newData);
        else if (position == counter)
            addLast(newData);
        else {
            int count = 0;
            ElemTwo<T> nd = new ElemTwo<T>(newData);
            ElemTwo<T> temp = first;
            while ((count + 1) != position) {
                temp = temp.getNext();
                count++;
            }
            ElemTwo<T> temp1 = temp.getNext();
            ElemTwo<T> nData = nd;
            temp.setNext(nData);
            nData.setPrev(temp);
            nData.setNext(temp1);
            temp1.setPrev(nData);
        }
        counter++;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public T get(int position) throws ListException {
        if (position > counter)
            throw new ListException("Cannot get on position: " + position + ", when size of list is: " + counter);
        if (position < 0)
            throw new ListException("Cannot get on negative position");
        if (first == null) {
            throw new ListException("Cannot get on position when list is empty");
        }
        ElemTwo<T> returned;
        if (position == 0)
            returned = first;
        else if (position == counter)
            returned = last;
        else {
            int count = 0;
            ElemTwo<T> temp = first;
            while (count != position) {
                temp = temp.getNext();
                count++;
            }
            returned = temp;
        }

        return returned.getData();
    }

    @Override
    public T removeFirst() throws ListException {
        if (first == null)
            throw new ListException("Cannot remove first when list is empty.");
        ElemTwo<T> returned = first;
        ElemTwo<T> temp = first;
        first = first.getNext();
        first.setPrev(null);
        temp.setPrev(null);
        counter--;
        return returned.getData();
    }

    @Override
    public T removeLast() throws ListException {
        if (last == null)
            throw new ListException("Cannot remove last when list is empty");
        ElemTwo<T> returned = last;
        last = last.getPrev();
        last.setNext(null);
        counter--;
        return returned.getData();
    }

    @Override
    public T remove(int position) throws ListException {
        if (position > counter)
            throw new ListException("Cannot get on position: " + position + ", when size of list is: " + counter);
        if (position < 0)
            throw new ListException("Cannot get on negative position");
        if (first == null) {
            throw new ListException("Cannot get on position when list is empty");
        }
        ElemTwo<T> returned;
        if (position == 0)
            returned = first;
        else if (position == counter)
            returned = last;
        else {
            int count = 0;
            ElemTwo<T> temp = first;
            while ((count + 1) != position) {
                temp = temp.getNext();
                count++;
            }
            returned = temp.getNext();
            temp.setNext(temp.getNext().getNext());
            temp.getNext().getNext().setPrev(temp);
        }

        return returned.getData();
    }

    @Override
    public int find(T dataToFind) {
        int returned = -1;
        int count = 0;
        ElemTwo<T> temp = first;
        while (temp != null) {
            if (temp.getData() == dataToFind)
                break;
            temp = temp.getNext();
            count++;
        }
        if (temp != null)
            if (temp.getData() == dataToFind)
                returned = count;
        return returned;
    }

    @Override
    public boolean contains(T data) {
        int count = 0;
        ElemTwo<T> temp = first;
        while (temp != null) {
            if (temp.getData() == data)
                return true;
            temp = temp.getNext();
            count++;
        }
        return false;
    }

    @Override

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private ElemTwo<T> current = first;

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
        ListTwo<T> returned = new ListTwo<T>();
        for (T t : this) {
            returned.addLast(t);
        }
        for (T t : (ListTwo<T>) druga) {
            returned.addLast(t);
        }
        return returned;
    }

    @Override
    public boolean similar(IList<T> druga) {
        if (counter != druga.size())
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
}
