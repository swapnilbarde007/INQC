package com.INQC.DTO.UCIP_LIB.Builder;

import com.INQC.DTO.UCIP_CORE.MethodCall;
import com.INQC.DTO.UCIP_CORE.Params;

public class MethodCallBuilder {
    private String methodName;
    private Params params;

    public MethodCallBuilder setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public MethodCallBuilder setParams(Params params) {
        this.params = params;
        return this;
    }

    public MethodCall build() {
        MethodCall methodCall = new MethodCall();
        methodCall.setMethodName(methodName);
        methodCall.setParams(params);
        return methodCall;
    }
}
