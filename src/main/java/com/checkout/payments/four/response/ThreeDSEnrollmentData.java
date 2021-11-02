package com.checkout.payments.four.response;

import com.checkout.common.ThreeDSEnrollmentStatus;
import com.checkout.payments.Exemption;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class ThreeDSEnrollmentData {

    private boolean downgraded;

    private ThreeDSEnrollmentStatus enrolled;

    @SerializedName("signature_valid")
    private String signatureValid;

    @SerializedName("authentication_response")
    private String authenticationResponse;

    private String cryptogram;

    private String xid;

    private String version;

    private Exemption exemption;

}