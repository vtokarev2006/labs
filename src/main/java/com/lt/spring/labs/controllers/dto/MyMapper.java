package com.lt.spring.labs.controllers.dto;

import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MyMapper {
    public <T, U> U map(T s, Class<U> d, String ... excludedFields) {
        Set<String> exFields = Arrays.stream(excludedFields)
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

        try {
            Class<?> sClass = s.getClass();
            Constructor<U> dConstructor = d.getConstructor();
            U dInst = dConstructor.newInstance();
            for (Method getter : Arrays.stream(sClass.getDeclaredMethods()).filter(m -> m.getName().startsWith("get")).toList()) {
                String getterName = getter.getName().substring("get".length());
                if (exFields.contains(getterName.toUpperCase())) {
                    continue;
                }
                Optional<Method> setter = Arrays.stream(d.getDeclaredMethods()).filter(m -> m.getName().equals("set" + getterName)).findFirst();
                if (setter.isPresent()) {
                    setter.get().invoke(dInst, getter.invoke(s));
                }
            }
            return dInst;
        } catch (Exception e) {
            return null;
        }
    }
}