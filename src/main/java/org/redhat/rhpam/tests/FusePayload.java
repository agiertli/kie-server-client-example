package org.redhat.rhpam.tests;

import java.util.Map;

public interface FusePayload {

    public void setBag(Map<String,Object> bag);
    public void setPayload(Object payload);
}
