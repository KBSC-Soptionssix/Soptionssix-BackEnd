package com.soptionssix.domain.error;

import com.soptionssix.domain.util.ErrorMessage;

public class ExpiredTokenException extends IllegalStateException {
    public ExpiredTokenException() {
        super(ErrorMessage.EXPIRED_TOKEN);
    }
}
