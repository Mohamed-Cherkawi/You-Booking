package org.youbooking.root.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class StatusMapping<T,E extends Enum<E>> {
    private T id;

    private E status;

    private StatusMapping() {}
}