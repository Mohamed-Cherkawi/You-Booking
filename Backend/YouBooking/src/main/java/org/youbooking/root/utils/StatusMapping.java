package org.youbooking.root.utils;

import org.youbooking.root.enums.BedRoomStateEnum;

public class StatusMapping<T>{
    private T id;

    private BedRoomStateEnum status;

    private StatusMapping() {}


    public T getId() {
        return id;
    }

    public BedRoomStateEnum getStatus() {
        return status;
    }
}
