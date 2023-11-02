  package org.example;

  import java.util.Arrays;
  import java.util.Iterator;
  import java.util.NoSuchElementException;
  import java.util.Objects;
  import java.util.function.Function;


    public class MyList<T extends Number> implements Iterable{
      private final int STARTING_CAPACITY=10;
      private final int MULTIPLY_FOR_INCREASE_ARRAY=2;
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

       Object[] newdata=new Object[size*MULTIPLY_FOR_INCREASE_ARRAY];
       System.arraycopy(data,0,newdata,0,data.length);
       data=newdata;
    }

    public T remove(int index) {
     if (index<0||index>=data.length)
     {IndexOutOfBoundsException exception=new IndexOutOfBoundsException();
     exception.printStackTrace();
     throw exception;}
     T removed=(T) data[index];
     System.arraycopy(data,index+1,data,index,size-index-1);
     data[--size]=null;
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
        /** Статическим NestedClass просто показывает принадлежность к внешнему классу
         *  и имеет доступ только к статическим переменным внешнего класса.
         *  Не статический InnerClass уместно использовать для обслуживания внешнего класса, но нужно контролировать
         *  соблюдение принципа единственной ответственности (Single Responsibility Principle).*/

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

        @Override
        public String toString() {
            return  Arrays.toString(data);

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MyList<?> list = (MyList<?>) o;


        if (size != list.size) return false;
        for (int i = 0; i <size ; i++) {
                if (!list.get(i).equals(this.get(i)))
                    return false;
            }
            return true;
        }

        @Override
        public int hashCode() {

            if (data==null) return 0;
            int result = Arrays.hashCode(data);
            result = 31 * result + size;
            return result;
        }

        public static void main(String[] args) {

        }

  }
