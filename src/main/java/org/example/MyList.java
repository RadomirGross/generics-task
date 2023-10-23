  package org.example;

  import java.util.function.Function;


    public class MyList<T extends Number> {
      private final int STARTING_CAPACITY=10;
      private Object[] data;
      private int size;

      public MyList() {
        this.data = new Object[STARTING_CAPACITY]; // начальная емкость
        this.size = 0;
      }
      public void add(T element) {
        if (size == data.length) {
          resize();
        }
        data[size++] = element;
      }
    public Object get(int index) {
      throw new RuntimeException("Not implemented");
    }

    private void resize() {
      throw new RuntimeException("Not implemented");
    }

    public Object remove(int index) {
      throw new RuntimeException("Not implemented");
    }

    public MyList map(Function f) {
      throw new RuntimeException("Not implemented");
    }

    public int size() {
      throw new RuntimeException("Not implemented");
    }
  }
