package com.github.dozermapper.extra.converters;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.dozermapper.extra.converters.number.BigDecimalStringConverter;
import com.github.dozermapper.extra.converters.number.BigIntegerStringConverter;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class ConverterContractTest {

    @Test
    public void booleanRoundTrip() {
        BooleanStringConverter converter = new BooleanStringConverter();
        assertEquals("true", converter.convertTo(Boolean.TRUE, null));
        assertEquals(Boolean.TRUE, converter.convertFrom("true", null));
        assertEquals(Boolean.FALSE, converter.convertFrom("false", null));
    }

    @Test
    public void jsonObjectRoundTrip() {
        JSONObjectStringConverter converter = new JSONObjectStringConverter();
        JSONObject value = JSONObject.parseObject("{\"name\":\"订单\"}");
        assertEquals(value, converter.convertFrom(converter.convertTo(value, null), null));
    }

    @Test
    public void jsonArrayRoundTrip() {
        JSONArrayStringConverter converter = new JSONArrayStringConverter();
        JSONArray value = JSONArray.parseArray("[1,\"订单\"]");
        assertEquals(value, converter.convertFrom(converter.convertTo(value, null), null));
    }

    @Test
    public void bigDecimalPlainStringRoundTrip() {
        BigDecimalStringConverter converter = new BigDecimalStringConverter();
        BigDecimal value = new BigDecimal("12345.6700");
        assertEquals("12345.6700", converter.convertTo(value, null));
        assertEquals(value, converter.convertFrom("12345.6700", null));
    }

    @Test
    public void bigIntegerRoundTrip() {
        BigIntegerStringConverter converter = new BigIntegerStringConverter();
        BigInteger value = new BigInteger("123456789012345678901234567890");
        assertEquals(value.toString(), converter.convertTo(value, null));
        assertEquals(value, converter.convertFrom(value.toString(), null));
    }
}
