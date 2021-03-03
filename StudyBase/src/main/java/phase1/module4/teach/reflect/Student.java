package phase1.module4.teach.reflect;

import java.io.Serializable;

@MyAnnotation
public class Student<T, E> extends Person implements Comparable, Serializable {

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
