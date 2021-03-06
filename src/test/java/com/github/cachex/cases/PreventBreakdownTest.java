package com.github.cachex.cases;

import com.github.cachex.cases.base.TestBase;
import com.github.cachex.domain.User;
import com.github.cachex.service.impl.PreventBreakdownServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author jifang.zjf
 * @since 2017/7/6 上午11:12.
 */
public class PreventBreakdownTest extends TestBase {


    @Autowired
    private PreventBreakdownServiceImpl service;

    @Test
    public void test() throws InterruptedException {
        List<Integer> ids = IntStream.range(0, 3).boxed().collect(Collectors.toList());

        Map<Integer, User> map = service.getMap(ids, "-feiqing");
        System.out.println("first map.size() = " + map.size());

        ids.add(4);
        map = service.getMap(ids, "-feiqing");
        System.out.println("second map.size() = " + map.size());
    }

    @Test
    public void test2() throws InterruptedException {
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < 10; ++i) {
            sets.add(i);
        }

        System.out.println(service.getUsers(sets));
        sets.add(10);
        System.out.println(service.getUsers(sets));
    }

}