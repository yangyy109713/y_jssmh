package java_8_stream;


import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {

    }


    public static void java7SortValue(List<Double> doubles, List<Integer> integers) {
        //判断 值非0
        //List<Double> doubleList = new ArrayList<>();
        for (Double d : doubles) {
            if (d.doubleValue() != 0) {
                doubles.add(d);
            }
        }

        //排序 从小到大？
        Collections.sort(doubles, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o2.compareTo(o1);
            }
        });

        //取值 转成int，结果插入新的list赋值
        //List<Integer> integerList = new ArrayList<>();
        for (Double d : doubles) {
            integers.add(d.intValue());
        }
    }

    public static void java8SortValue(List<Double> doubles, List<Integer> integers) {
        integers = doubles.parallelStream().
                filter(t -> t.doubleValue() != 0).
                sorted(Comparator.comparing(Double::doubleValue).reversed()).
                map(Double::intValue).
                collect(Collectors.toList());
    }
}
