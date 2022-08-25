package com.example.etorobackend.auth.models;

import com.example.etorobackend.common.codes.ErrorCodes;

public record ErrorResponse(String message, ErrorCodes code, Integer status) {
}
