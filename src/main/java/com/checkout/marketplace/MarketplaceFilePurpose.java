package com.checkout.marketplace;

import lombok.Getter;

public enum MarketplaceFilePurpose {

    BANK_VERIFICATION("bank_verification"),
    IDENTIFICATION("identification"),
    COMPANY_VERIFICATION("company_verification");

    @Getter
    private final String purpose;

    MarketplaceFilePurpose(final String purpose) {
        this.purpose = purpose;
    }

}
