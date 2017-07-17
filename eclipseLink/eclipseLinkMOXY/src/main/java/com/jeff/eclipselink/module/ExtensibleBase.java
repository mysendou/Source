package com.jeff.eclipselink.module;

import org.eclipse.persistence.oxm.annotations.XmlVirtualAccessMethods;

import javax.xml.bind.annotation.XmlTransient;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeff.Ma on 7/13/2017.
 */
@XmlTransient
@XmlVirtualAccessMethods(setMethod="put")
public class ExtensibleBase {
    private Map<String, Object> extensions = new HashMap<String, Object>();

    public <T> T get (String property) {
        return (T) extensions.get(property);
    }

    public void put (String property, Object value) {
        extensions.put(property, value);
    }
}
