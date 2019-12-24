package com.github.curriculeon.casino.profile;

public interface ProfileManagerInterface {
    ProfileInterface createProfile();

    ProfileInterface[] createProfiles(int numberOfPlayers);

    ProfileInterface[] getProfiles(int numberOfPlayers);

    ProfileInterface selectProfile();

    void printProfilesInformation();

    void registerPlayer(ProfileInterface someDude);

    boolean contains(ProfileInterface someDude);
}
