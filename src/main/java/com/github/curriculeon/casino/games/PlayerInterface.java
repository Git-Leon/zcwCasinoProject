package com.github.curriculeon.casino.games;

import com.github.curriculeon.casino.profile.ProfileInterface;

/**
 * Created by leon on 2/25/18.
 */
public interface PlayerInterface {
    ProfileInterface getProfile();
    String getName();
}