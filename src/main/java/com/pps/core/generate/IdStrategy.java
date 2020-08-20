package com.pps.core.generate;


public abstract class IdStrategy {


    private final IdWorker idWorker = new IdWorker(1, 1);

    /**
     * @description: 默认实现 雪花算法
     * @params: length 长度限制
     * @return: java.lang.Object
     * @author:
     * @time: 2020/8/20 15:39
     */

    public Object product() {

        return idWorker.nextId();

    }

}

