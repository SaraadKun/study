package cn.freemud.demo;

import cn.freemud.demo.po.User;
import cn.freemud.demo.zookeeper.Q;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by chenwenshun on 2018/9/27.
 */

public class GuavaTests {


    @Test
    public void testSplit(){

        String mock = ",,a, b,c,,d,,";
        String[] mocks = mock.split(",");
        for (int i = 0; i < mocks.length; i++) {
            System.out.println(mocks[i]);
        }
        List<String> list = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(mock);
        System.out.println(list.toString());
        Joiner joiner = Joiner.on("/").skipNulls();
        String result = joiner.join("a", 1, null, 'c');
        System.out.println(result);
        String[] names = new String[]{"bella", "tina", "ashun"};
        System.out.println(joiner.join(names));
        List<String> time = Splitter.on(":").splitToList("10:56");
        System.out.println(time);
    }

    @Test
    public void testRateLimite(){
        RateLimiter limiter = RateLimiter.create(3);
//        RateLimiter limiter = RateLimiter.create(10, 5, TimeUnit.SECONDS);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        for (; ; ) {
            limiter.acquire();
            System.out.println(df.format(new Date()));
        }
    }


    @Test
    public void testMultimap(){
        ListMultimap<Integer, String> listMutilMap = ArrayListMultimap.create();
        listMutilMap.put(100, "1001");
        listMutilMap.put(2, "21");
        listMutilMap.put(2, "22");
        listMutilMap.put(1, "1");
        listMutilMap.put(1, "2");
        listMutilMap.put(43, "431");
        System.out.println(listMutilMap.keySet());//
        System.out.println(listMutilMap.get(2));
    }

    /**
     * 不可变集合
     */
    @Test
    public void test4(){
        List<String> list = Lists.newArrayList("a", "b", "c");
        Collection<String> unmodifiableCollection = Collections.unmodifiableCollection(list);

        ImmutableList<String> immutableList = ImmutableList.copyOf(list);

        list.add("e");
        System.out.println(unmodifiableCollection);
        System.out.println(immutableList);
        immutableList.add("a");

    }

    /**
     * 集合 索引
     */
    @Test
    public void test5(){
        List<User> users = Lists.newArrayList();
        users.add(new User(1L,"haha"));
        users.add(new User(2L,"bella"));
        users.add(new User(3L,"tina"));
        users.add(new User(4L,"tom"));
        users.add(new User(5L,"jerry"));
        users.add(new User(6L,"tony"));
        users.add(new User(7L,"tony"));

        /**
         * 对集合添加唯一索引
         */
        ImmutableMap<Long, User> uniqueIndex = FluentIterable
                .from(users).uniqueIndex(new Function<User, Long>() {
            @Override
            public Long apply(User user) {
                return user.getId();
            }
        });
        User user = uniqueIndex.get(3L);
        System.out.println(user);


        /**
         * 对集合添加非唯一索引
         */
        ImmutableListMultimap<String, User> index = FluentIterable
                .from(users).index(new Function<User,String>() {
            @Override
            public String apply(User user) {
                return user.getUsername();
            }
        });
        List<User> userList = index.get("tony");
        System.out.println(userList);


    }


    /**
     * 集合运算主要有：并集、交集、差集。
     */
    @Test
    public void test6() {
        List<Integer> list1 = Lists.newArrayList(1, 2, 2, 1, 4, 5, 4, 3);
        List<Integer> list2 = Lists.newArrayList(1, 2, 3, 7, 8, 9);
        Set set = new HashSet(list1);

        Sets.SetView<Integer> union = Sets.union(Sets.newHashSet(list1), Sets.newHashSet(list2));
        Sets.SetView<Integer> difference = Sets.difference(Sets.newHashSet(list1), Sets.newHashSet(list2));
        Sets.SetView<Integer> intersection = Sets.intersection(Sets.newHashSet(list1), Sets.newHashSet(list2));
        System.out.println(union);
        System.out.println(difference);
        System.out.println(intersection);

        list1.parallelStream().forEach(System.out::println);
        list1.stream().forEach(System.out::println);
        int a = list1.stream().max(Comparator.comparing(e -> e)).get();
        int sum = list1.stream().mapToInt(e -> e).sum();
        System.out.println(sum);
    }


    /**
     * java 8 Stream
     */
    @Test
    public void test7(){
        List<User> users = Lists.newArrayList();
        users.add(new User(1L,"haha"));
        users.add(new User(2L,"bella"));
        users.add(new User(3L,"tina"));
        users.add(new User(4L,"tom"));
        users.add(new User(5L,"jerry"));
        users.add(new User(6L,"tony"));
        users.add(new User(7L,"tony"));

        List<Q> names = users.parallelStream()
//                .filter(u -> u.getUsername().equals("tony"))
//                .sorted(Comparator.comparing(User::getId).reversed())
                .sorted((user1,user2) -> user1.getId().compareTo(user2.getId()))
                .map(user -> {
                    Q q = new Q(user.getId().intValue());
                    return q;
                })
                .collect(Collectors.toList());

        System.out.println(names);
        Map<Long,User> userMap = users.stream().collect(Collectors.toMap(user -> user.getId(),user -> user)) ;
        System.out.println(userMap);


        /**
         * 非唯一索引
         */
        Map<Integer, List<User>> integerListMap =
                Stream.generate(new UserSupplier())
                .limit(100)
                .collect(Collectors.groupingBy(User::getAge));
        System.out.println(integerListMap);




    }

    private class UserSupplier implements Supplier<User>{
        private long index = 0;
        private Random random = new Random();
        @Override
        public User get() {
            return new User(index++, "StormTestUser"+random.nextInt(1000), random.nextInt(100));
        }
    }



}
