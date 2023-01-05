package org.youbooking.root.utils;

import lombok.Getter;
import org.youbooking.root.enums.BedRoomStateEnum;

@Getter
public class StatusMapping<T>{
    private T id;

    private BedRoomStateEnum status;

    private StatusMapping() {}

}
