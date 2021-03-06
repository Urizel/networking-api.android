package com.roxiemobile.networkingapi.network.rest;

import android.support.annotation.NonNull;

import com.roxiemobile.androidcommons.diagnostics.Guard;
import com.roxiemobile.networkingapi.network.rest.response.ResponseEntity;
import com.roxiemobile.networkingapi.network.rest.response.RestApiError;

public class CallResult<T> extends Result<ResponseEntity<T>, RestApiError, T>
{
// MARK: - Construction

    private CallResult(ResponseEntity<T> success) {
        super(success);
    }

    private CallResult(RestApiError failure) {
        super(failure);
    }

// MARK: - Methods

    public static <T> CallResult<T> success(@NonNull ResponseEntity<T> entity) {
        Guard.notNull(entity, "entity is null");
        return new CallResult<>(entity);
    }

    public static <T> CallResult<T> failure(@NonNull RestApiError error) {
        Guard.notNull(error, "error is null");
        return new CallResult<>(error);
    }
}
