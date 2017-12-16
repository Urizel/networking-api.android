package com.roxiemobile.networkingapi.util;

import android.support.annotation.NonNull;

import com.roxiemobile.androidcommons.diagnostics.Guard;
import com.roxiemobile.networkingapi.network.rest.request.BasicRequestEntity;
import com.roxiemobile.networkingapi.network.rest.request.RequestEntity;

public final class RequestEntityUtils
{
// MARK: - Construction

    private RequestEntityUtils() {
        // Do nothing
    }

// MARK: - Methods

    public static <Ti, To> RequestEntity<To> copy(@NonNull RequestEntity<Ti> entity) {
        Guard.notNull(entity, "entity is null");
        //noinspection unchecked
        return copyWith(entity, (To) entity.body());
    }

    public static <Ti, To> RequestEntity<To> copyWith(RequestEntity<Ti> entity, To body) {
        return new BasicRequestEntity.Builder<>(entity, body).build();
    }
}
