package com.sys.yang.standard.factory;

/**
 * @author yangLongFei 2020-12-24-20:36
 */
public class FactherFactory {

    public Father getSoon1() {
        return new Soon1();
    }

    public Father getSoon2() {
        return new Soon2();
    }

}
