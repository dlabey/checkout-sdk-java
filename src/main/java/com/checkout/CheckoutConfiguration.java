package com.checkout;

import java.util.concurrent.Executor;

import org.apache.http.impl.client.HttpClientBuilder;

public interface CheckoutConfiguration {

    IEnvironment getEnvironment();

    SdkCredentials getSdkCredentials();

    HttpClientBuilder getHttpClientBuilder();

    Executor getExecutor();

    TransportConfiguration getTransportConfiguration();

}
