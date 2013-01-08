/**
 *  Copyright 2013 Sven Ewald
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.xmlbeam.types;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://github.com/SvenEwald">Sven Ewald</a>
 */
@SuppressWarnings("serial")
public  class DefaultTypeConverter implements TypeConverter {

    private final Map<Class<?>, Conversion<?>> CONVERSIONS = new HashMap<Class<?>, Conversion<?>>();

    public DefaultTypeConverter() {
        CONVERSIONS.put(Boolean.class, new ConversionWithDefault<Boolean>(false) {
            @Override
            public Boolean convert(final String data) {
                return Boolean.valueOf(data);
            }
        });
        CONVERSIONS.put(Boolean.TYPE, CONVERSIONS.get(Boolean.class));
        CONVERSIONS.put(Byte.class, new ConversionWithDefault<Byte>((byte) 0) {
            @Override
            public Byte convert(final String data) {
                return Byte.valueOf(data);
            }
        });
        CONVERSIONS.put(Byte.TYPE, CONVERSIONS.get(Byte.class));
        CONVERSIONS.put(Float.class, new ConversionWithDefault<Float>(0F) {
            @Override
            public Float convert(final String data) {
                return Float.valueOf(data);
            }
        });
        CONVERSIONS.put(Float.TYPE, CONVERSIONS.get(Float.class));
        CONVERSIONS.put(Double.class, new ConversionWithDefault<Double>(0D) {
            @Override
            public Double convert(final String data) {
                return Double.valueOf(data);
            }
        });
        CONVERSIONS.put(Double.TYPE, CONVERSIONS.get(Double.class));
        CONVERSIONS.put(Short.class, new ConversionWithDefault<Short>((short) 0) {
            @Override
            public Short convert(final String data) {
                return Short.valueOf(data);
            }
        });
        CONVERSIONS.put(Short.TYPE, CONVERSIONS.get(Short.class));
        CONVERSIONS.put(Integer.class, new ConversionWithDefault<Integer>(0) {
            @Override
            public Integer convert(final String data) {
                return Integer.valueOf(data);
            }
        });
        CONVERSIONS.put(Integer.TYPE, CONVERSIONS.get(Integer.class));
        CONVERSIONS.put(Long.class, new ConversionWithDefault<Long>(0L) {
            @Override
            public Long convert(final String data) {
                return Long.valueOf(data);
            }
        });
        CONVERSIONS.put(Long.TYPE, CONVERSIONS.get(Long.class));
        CONVERSIONS.put(String.class, new ConversionWithDefault<String>("") {
            @Override
            public String convert(final String data) {
                return data;
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T convertTo(Class<T> targetType, String data) {
        assert data != null;

        Conversion<?> conversion = CONVERSIONS.get(targetType);
        assert conversion != null : "Method caller must check existence of conversion.";

        if (data.isEmpty()) {
            return (T) conversion.getDefaultValue();
        }

        return (T) conversion.convert(data);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> boolean isConvertable(Class<T> targetType) {
        return CONVERSIONS.containsKey(targetType);
    }


    /**
     * @return the conversions
     */
    protected Map<Class<?>, Conversion<?>> getConversions() {
        return CONVERSIONS;
    }

}