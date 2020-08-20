package com.pps.core.generate;

/**
 * @author
 * @discription;
 * @time 2020/8/20 15:59
 */

public class MyIdStrategy extends IdStrategy {
    @Override
    public Object product() {
        return ((Long)super.product()).intValue();
    }
}
