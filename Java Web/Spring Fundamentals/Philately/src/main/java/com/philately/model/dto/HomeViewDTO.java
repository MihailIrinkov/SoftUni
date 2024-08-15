package com.philately.model.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomeViewDTO {

    private Set<StampDTO> myStamps;
    private Set<StampDTO> myPurchases;
    private Set<StampDTO> offeredStamps;
    private Set<StampDTO> myWishList;

    public HomeViewDTO() {
        myStamps =new HashSet<>();
        myPurchases = new HashSet<>();
        offeredStamps = new HashSet<>();
        myWishList = new HashSet<>();
    }

    public Set<StampDTO> getMyStamps() {
        return myStamps;
    }

    public HomeViewDTO setMyStamps(Set<StampDTO> myStamps) {
        this.myStamps = myStamps;
        return this;
    }

    public Set<StampDTO> getMyPurchases() {
        return myPurchases;
    }

    public HomeViewDTO setMyPurchases(Set<StampDTO> myPurchases) {
        this.myPurchases = myPurchases;
        return this;
    }

    public Set<StampDTO> getOfferedStamps() {
        return offeredStamps;
    }

    public HomeViewDTO setOfferedStamps(Set<StampDTO> offeredStamps) {
        this.offeredStamps = offeredStamps;
        return this;
    }

    public Set<StampDTO> getMyWishList() {
        return myWishList;
    }

    public HomeViewDTO setMyWishList(Set<StampDTO> myWishList) {
        this.myWishList = myWishList;
        return this;
    }
}
