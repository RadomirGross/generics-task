  package org.example;

  import java.util.Iterator;
  import java.util.NoSuchElementException;
  import java.util.function.Function;


    public class MyList<T extends Number> implements Iterable{
      private final int STARTING_CAPACITY=10;
      private Object[] data;
      private int size;

      public MyList() {
        this.data = new Object[STARTING_CAPACITY];
        this.size = 0;
      }
      public void add(T element) {
        if (size == data.length) {
          resize();
        }
        data[size++] = element;
      }
    public T get(int index) {
        if (index<0||index>=size)
        {IndexOutOfBoundsException exception=new IndexOutOfBoundsException();
          exception.printStackTrace();
          throw exception;}
      return (T)data[index];
    }

    private void resize() {

       Object[] newdata=new Object[size*2];
       System.arraycopy(data,0,newdata,0,data.length);
       data=newdata;
    }

    public T remove(int index) {
     if (index<0||index>=data.length)
     {IndexOutOfBoundsException exception=new IndexOutOfBoundsException();
     exception.printStackTrace();
     throw exception;}
     T removed=(T) data[index];
     System.arraycopy(data,index++,data,index,size-index-1);
     data[size--]=null;
     return removed;
    }


        public <R extends Number>MyList<R> map(Function<T, R> f) {
            MyList<R> newMyList = new MyList<>();
            for (int i = 0; i < size; i++) {
                newMyList.add( f.apply(this.get(i)));
            }
            return newMyList;
        }

    public int size() {
      return size;
    }

        @Override
        public Iterator<T> iterator() {
            return new MyListIterator();
        }

        private class MyListIterator implements Iterator<T>{
          private int currentIndex=0;

            @Override
            public boolean hasNext() {
                return currentIndex<size;
            }

            @Override
            public T next() {
                if (hasNext())
                    return (T)data[currentIndex++];else
                        throw new NoSuchElementException();

            }
        }

        public static void main(String[] args) {
            MyList<Integer> list=new MyList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            MyList<Integer> newList = list.map(x -> x * 1000);
            for (Object x:newList) {
                System.out.println(x);
            }
        }
  }
