package com.checkout;

import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import org.apache.http.impl.client.HttpClientBuilder;

public abstract class AbstractCheckoutSdkBuilder<T extends CheckoutApiClient> {

    protected HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
    private IEnvironment environment;
    private Executor executor = ForkJoinPool.commonPool();
    private TransportConfiguration transportConfiguration;

    public AbstractCheckoutSdkBuilder<T> environment(final IEnvironment environment) {
        this.environment = environment;
        return this;
    }

    public AbstractCheckoutSdkBuilder<T> httpClientBuilder(final HttpClientBuilder httpClientBuilder) {
        this.httpClientBuilder = httpClientBuilder;
        return this;
    }

    public AbstractCheckoutSdkBuilder<T> executor(final Executor executor) {
        this.executor = executor;
        return this;
    }

    public AbstractCheckoutSdkBuilder<T> transportConfiguration(final TransportConfiguration transportConfiguration) {
        this.transportConfiguration = transportConfiguration;
        return this;
    }

    protected IEnvironment getEnvironment() {
        return environment;
    }

    protected abstract SdkCredentials getSdkCredentials();

    protected CheckoutConfiguration getCheckoutConfiguration() {
        if (environment == null) {
            throw new CheckoutArgumentException("environment must be specified");
        }
        final SdkCredentials sdkCredentials = getSdkCredentials();
        if (transportConfiguration == null) {
            transportConfiguration = new DefaultTransportConfiguration();
        }
        return buildCheckoutConfiguration(sdkCredentials);
    }

    private CheckoutConfiguration buildCheckoutConfiguration(final SdkCredentials sdkCredentials) {
        return new DefaultCheckoutConfiguration(sdkCredentials, getEnvironment(), httpClientBuilder, executor, transportConfiguration);
    }

    public abstract T build();

}
