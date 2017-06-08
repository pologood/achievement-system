/*
 * Copyright (C) 2009-2017 Hangzhou 2Dfire Technology Co., Ltd.All rights reserved
 */

import java.util.HashMap;
import java.util.Map;

/**
 * CaiTest
 *
 * @author shinan
 * @since 2017-05-24
 */
public class CaiTest {

    public static void main(String args[]){
        String a = null;
        Map<String, String> map = new HashMap<String, String>();
        map.put(a,a);
        System.out.println(map.get(a));

    }
}
