# 백준 Q1026



```java
a = IntStream.of(a)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();
```

이와 같이 오름 차순을 stream으로 구현할 수 있다.





# 백준 Q11279

**PriorityQueue** 를 최대힙으로 만들고 싶다면 queue 선언과 동시에 Collections.reverseOrder()를 설정해주자

그럼 아래와 같이 comparator가 설정된다.

🔐**PriorityQueue<E>**

```
public PriorityQueue(Comparator<? super E> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }
```

```
public PriorityQueue(int initialCapacity,
                         Comparator<? super E> comparator) {
        // Note: This restriction of at least one is not actually needed,
        // but continues for 1.5 compatibility
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }
```




