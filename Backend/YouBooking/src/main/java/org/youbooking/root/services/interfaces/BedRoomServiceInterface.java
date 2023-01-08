package org.youbooking.root.services.interfaces;

import org.youbooking.root.enums.BedRoomStateEnum;
import org.youbooking.root.services.dtos.BedRoomDto;
import org.youbooking.root.utils.StatusMapping;

public interface BedRoomServiceInterface {
    BedRoomDto updateStatus(StatusMapping<Long,BedRoomStateEnum> statusMapping);
}
