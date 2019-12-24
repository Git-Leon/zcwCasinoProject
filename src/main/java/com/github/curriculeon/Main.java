package com.github.curriculeon;

import com.github.curriculeon.casino.Casino;
import com.github.curriculeon.casino.CasinoInterface;

/**
 * Created by leon.hunter on 1/29/2017.
 */
public class Main {
    public static void main(String[] args) {
        CasinoInterface myCasino = new Casino();
        myCasino.start();
    }
}
