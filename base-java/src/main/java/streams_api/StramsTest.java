package streams_api;

import domain.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * java8 集合之流式Streams操作
 * list.stream().map()生成的是个1:1映射，每个输入元素，都按照规则转换成另一个元素
 * flatMap()：一对多映射关系
 */
public class StramsTest {

    private static List<Integer> list = new ArrayList<>();
    private static List<Person> people = new ArrayList<>();

    //筛选数组中的偶数
    public static void filter() {
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens = Stream.of(sixNums).filter(n -> n % 2 == 0).toArray(Integer[]::new);
        System.out.println("筛选，保留偶数：" + evens);
    }

    /**
     * 一对多
     * flatMap把inputStream中的层级结构扁平化
     * 即将底层元素抽出来放到一起，最终新的outputStream中没有list，都是直接数字
     */
    public static void oneToMany() {
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.flatMap(childList -> childList.stream());
        //outputStream.forEach(System.out::println);//直接通过流 打印流中的内容
        List<Integer> outputList = outputStream.collect(Collectors.toList());//元素Integer类型
        System.out.println("outputStream to List：" + outputList);
    }

    /**
     * 计算平方数
     */
    public static void calSquare() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> listS = list.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("数值：" + list);
        System.out.println("计算平方数：：" + listS);
    }

    /**
     * 转换大写
     */
    public static List<String> changetoUpper() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        return list.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public static void createStreamAndChange() {
        /*
         * 构造流的常用方法
         */
        //1.Individual values
        Stream stream = Stream.of("a", "b", "c");

        //2.Arrays
        String[] strArray = new String[]{"a1", "b1", "c1"};
        Stream stream1 = Stream.of(strArray);
        Stream stream2 = Arrays.stream(strArray);

        //3.Collections
        List<String> stringList = Arrays.asList(strArray);
        Stream stream3 = stringList.stream();

        /*
         * 流转换为其他数据结构
         * Ps：一个流只可以使用一次，否则会报错stream has already been operated upon or closed
         */
        //1.Array
        String[] strArray1 = (String[]) stream.toArray(String[]::new);

        //2.Collection
        List<String> list1 = (List<String>) stream1.collect(Collectors.toList());
        List<String> list2 = (List<String>) stream2.collect(Collectors.toCollection(ArrayList::new));
        Set set = (Set) stream3.collect(Collectors.toSet());

        Stream stream4 = Stream.of("11", "22", "33");
        Stack stack = (Stack) stream4.collect(Collectors.toCollection(Stack::new));

        //3.String
        Stream stream5 = Stream.of("111", "222", "333");
        String str = stream5.collect(Collectors.joining()).toString();
    }

    /**
     * 数值流的构造
     * 对于基本数值类型，有三种对应的包装类型流：
     * IntStream
     * LongStream
     * DoubleStream
     * 也可以用Stream<Integer>、Stream<Long> >、Stream<Double>
     * 但是boxing和unboxing会很耗时，所以为这三种基本数值型提供了对应的Stream
     */
    public static void createStream() {
        System.out.println("===IntStream.of===");
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);

        System.out.println("===IntStream.range===");
        IntStream.range(1, 3).forEach(System.out::println);

        System.out.println("===IntStream.rangeClosed===");
        IntStream.rangeClosed(1, 3).forEach(System.out::println);

    }

    /**
     * filter
     * 对原始Stream进行测试，通过测试的元素保留，生成一个新的Stream
     */
    //改变集合中某一个数字
    public static List<Integer> changeList(List<Integer> list) {
        List<Integer> list1 = list.stream().map(n -> n == 2 ? 20 : n).collect(Collectors.toList());
        return list1;
    }

    //从list中筛选大于1的数据：使用stream
    public static List<Integer> getNewList1(List<Integer> list) {
        return list.stream().filter(n -> n > 1).collect(Collectors.toList());
    }

    //从list中筛选大于1的数据：未使用stream
    public static List<Integer> getNewList(List<Integer> list) {
        List<Integer> list1 = new ArrayList<>();
        for (Integer i : list) {
            if (i > 1) {
                list1.add(i);
            }
        }
        return list1;
    }

    private static List<Person> createPersons() {
        people.add(new Person("yyy", 11));
        people.add(new Person("yyy1", 10));
        people.add(new Person("yyy2", 18));
        people.add(new Person("yyy3", 15));
        people.add(new Person("sxfy", 3));
        return people;
    }

    private static List<Integer> createList() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        return list;
    }

    //计算所有name包含"yyy"的年龄之和
    public static int calAge() {
        return people.stream()
                .filter(p -> p.getName().contains("yyy"))
                .mapToInt(p -> p.getAge()).sum();
    }

    /**
     * forEach
     * 接收一个Lambda表达式，然后在Stream的每一个元素上执行表达式
     * Ps：
     * 1.forEach()是为Lambda表达式设计的，保持了最紧凑的风格
     * 2.Lambda表达式可以重用
     * 3.当需要为多核系统优化时，可以parallelStream().forEach()
     * 此时原有元素的次序没法保证，并行的情况下将改变串行时操作的行为
     * 4.forEach是terminal操作，执行后Stream即被销毁，无法再对Stream进行terminal运算
     * 错误代码：
     * stream.forEach(element -> doOneThing(element));
     * stream.forEach(element -> doAnotherThing(element));
     * <p>
     * 5.forEach 不能修改自己包含的本地变量值，也不能用 break/return 之类的关键字提前结束循环
     * <p>
     * 示例：打印所有名字不包含"yyy"的用户名
     */
    public static void forEach() {
        people.stream().filter(p -> !p.getName().contains("yyy"))
                .forEach(p -> System.out.println("forEach test：" + p.getName()));
    }

    /**
     * findFirst()
     * terminal和short-circuiting操作，总是返回Stream的第一个元素，或者空
     * 返回值类型：Optional，目的是尽可能避免NullPointerException
     * 使用Optional代码可读性更好，并且是编译时检查，能降低运行时NullPointerException对程序的影响
     * 迫使开发者在编码阶段处理空值问题
     * <p>
     * Stream 中的 findAny、max/min、reduce 等方法 也返回 Optional 值
     * 还有例如 IntStream.average() 返回 OptionalDouble 等
     */
    public static void optionalTest() {
        System.out.println("optional test：");
        String strA = " abcd ", strB = null;
        print(strA);
        print("");
        print(strB);

        System.out.println(strA + " length：" + getLen(strA));
        System.out.println("" + " length：" + getLen(""));
        System.out.println(strB + " length：" + getLen(strB));
    }

    public static void print(String text) {
        Optional.ofNullable(text).ifPresent(System.out::println);
        //java8之前的实现方式
        //if(text != null) System.out.println(text);
    }

    public static int getLen(String text) {
        return Optional.ofNullable(text).map(String::length).orElse(-1);
        //java8之前的实现方式
        //return text != null ? text.length() : -1;
    }

    /**
     * reduce
     * 把Stream元素组合起来
     * reduce提供一个初始值，然后依照运算规则BinaryOptional，和前面的第1、2...n个元素组合
     * 字符串拼接，数值的sum、min、max、average都是特殊的reduce
     * 例：Stream的sum相当于
     * Integer sum = integers.reduce(0, (a, b) -> a+b); 或
     * Integer sum = integers.reduce(0, Integer::sum);
     * Ps：对于没有起始值的情况，这时会把 Stream 的前面两个元素组合起来，返回的是 Optional
     */
    public static void reduceTest() {
        //字符串连接
        String concat = Stream.of("A", "B", "C").reduce("", String::concat);
        System.out.println("字符串连接：" + concat);
        //求最小值
        double d = Stream.of(-1.5, 1.3, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println("求最小值：" + d);

        //求和：有初始值0
        int sum = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println("求和：有初始值0：" + sum);
        //求和：无初始值
        int sum1 = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println("求和：无初始值：" + sum1);

        //过滤，字符串连接
        concat = Stream.of("a", "B", "c", "D", "e", "F")
                .filter(x -> x.compareTo("Z") > 0)
                .reduce("", String::concat);
        System.out.println("过滤，字符串连接：" + concat);
    }

    /**
     * limit：返回Stream前面n个元素
     * skip：跳过Stream前面n个元素
     */
    public static void limitAndkipTest() {
        List<Person> people1 = new ArrayList<>();
        for (int i = 1; i < 1000; i++) {
            Person person = new Person("pls" + i, i);
            people1.add(person);
        }
        //返回值：取前10个people的name，跳过前3个
        List<String> peopleNameList = people1.stream().map(Person::getName).limit(10).skip(3).collect(Collectors.toList());
        System.out.println("取前10个people的name，跳过前3个：" + peopleNameList);
    }

    //把limit和skip放在Stream的排序操作后，无法达到 short-circuiting 目的
    //原因：跟 sorted 这个 intermediate 操作有关：此时系统并不知道 Stream 排序后的次序如何，所以 sorted 中的操作看上去就像完全没有被 limit 或者 skip 一样
    public static void limitAndSkipTest1() {
        List<Person> people1 = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            Person person = new Person("pls" + i, i);
            people1.add(person);
        }
        List<Person> pepleNameList = people1.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .limit(2).collect(Collectors.toList());
        System.out.println("pepleNameList：" + pepleNameList);
    }

    /**
     * 对Stream排序 通过sorted进行，比数组排序强大
     * 可以先对Stream进行各类map、filter、limit、skip甚至distinct来减少元素数量，在排序
     * 缩短执行时间
     * 以优化limitAndSkipTest为例
     */
    public static void sortedTest() {
        List<Person> people1 = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            Person person = new Person("pls" + i, i);
            people1.add(person);
        }
        //返回值：取前10个people的name，跳过前3个
        List<Person> peopleList = people1.stream().limit(4).skip(2)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toList());//x.compareTo(Y)：默认升序
        System.out.println("先limit、skip，再sorted：" + peopleList);
    }

    /**
     * min / max / distinct
     * 最小 / 最大 /去重
     */
    //获取最长一行的长度
    public static void minMaxDistinctTest() {
        try {
            String path = "/Users/yuanyuanyang/Documents/IdeaProjects/yyy's java/base-java/src/main/resources/streamTest.txt";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            int longest = bufferedReader.lines().mapToInt(String::length).max().getAsInt();
            bufferedReader.close();
            System.out.println("最长的一行的长度：" + longest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //去重：找出全部单词，转小写，并排序
    public static void distinctTest() {
        String path = "/Users/yuanyuanyang/Documents/IdeaProjects/yyy's java/base-java/src/main/resources/streamTest.txt";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            List<String> words = bufferedReader.lines()
                    .flatMap(line -> Stream.of(line.split(" ")))
                    .filter(word -> word.length() > 0)
                    .map(String::toLowerCase)
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
            bufferedReader.close();
            System.out.println(words);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * match
     * allMatch：Stream 中全部元素符合传入的 predicate，返回 true
     * anyMatch：Stream 中只要有一个元素符合传入的 predicate，返回 true
     * noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true
     */
    public static void matchTest() {
        boolean isAllAdult = people.stream().
                allMatch(p -> p.getAge() > 18);
        System.out.println("All are adult? " + isAllAdult);
        boolean isThereAnyChild = people.stream().
                anyMatch(p -> p.getAge() < 12);
        System.out.println("Any child? " + isThereAnyChild);
        boolean nonOld = people.stream().noneMatch(p -> p.getAge() > 60);
        System.out.println("none is Old ? " + nonOld);
    }

    public static void main(String[] args) {
        list = createList();
        System.out.println("List:" + list);

        people = createPersons();

        //list = getNewList(list);
        List<Integer> list0 = getNewList1(list);
        System.out.println("ListNew:" + list0);

        List<Integer> list1 = changeList(list);//打印结果还是原list，Why？==》没有重新生成新的List
        System.out.println("ListChanged:" + list1);

        createStreamAndChange();//构造流的方法和流转换为其他数据结构
        createStream();//数值流的构造

        System.out.println("SumAge = " + calAge());

        System.out.println("小写字母转为大写" + changetoUpper());

        calSquare();//计算平方数

        oneToMany();//一对多转换

        forEach();

        optionalTest();

        reduceTest();

        limitAndkipTest();

        limitAndSkipTest1();//执行后的返回元素数量是 2，但整个管道中的 sorted 表达式执行次数没有像limitAndkipTest一样相应减少

        sortedTest();

        minMaxDistinctTest();

        distinctTest();

        matchTest();
    }
}
