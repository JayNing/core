package com.detaildemo.rule.drools.fact;

import com.detaildemo.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 待校验数据详情
 *
 * @author hawods
 * @version 2018-08-30
 */
public class FactValue {
    private static final Logger logger = LoggerFactory.getLogger(FactValue.class);
    private static final String ARRAY_SEPARATOR = ",";

    private String value;

    public FactValue(String value) {
        if (value == null) {
            value = StringUtils.EMPTY;
        }
        this.value = value;
    }

    public FactValue add(Object object) {
        String thisValue = this.value;
        String thatValue = getValue(object);

        String result = null;
        try {
            BigDecimal numberResult = new BigDecimal(thisValue).add(new BigDecimal(thatValue));
            result = StringUtils.format(numberResult.doubleValue());
        } catch (NumberFormatException e) {
            logger.warn(e.getMessage(), e);
        }

        // 只做数字计算，不处理字符串拼接的情况
//        if (result == null) {
//            result = thisValue + thatValue;
//        }

        return new FactValue(result);
    }

    public FactValue subtract(Object object) {
        String thisValue = this.value;
        String thatValue = getValue(object);

        String result = null;
        try {
            BigDecimal numberResult = new BigDecimal(thisValue).subtract(new BigDecimal(thatValue));
            result = StringUtils.format(numberResult.doubleValue());
        } catch (NumberFormatException e) {
            logger.warn(e.getMessage(), e);
        }

        return new FactValue(result);
    }

    public FactValue multiply(Object object) {
        String thisValue = this.value;
        String thatValue = getValue(object);

        String result = null;
        try {
            BigDecimal numberResult = new BigDecimal(thisValue).multiply(new BigDecimal(thatValue));
            result = StringUtils.format(numberResult.doubleValue());
        } catch (NumberFormatException e) {
            logger.warn(e.getMessage(), e);
        }

        return new FactValue(result);
    }

    public FactValue divide(Object object) {
        String thisValue = this.value;
        String thatValue = getValue(object);

        String result = null;
        try {
            BigDecimal num1 = new BigDecimal(thisValue);
            BigDecimal num2 = new BigDecimal(thatValue);
            num1 = num1.setScale(15, BigDecimal.ROUND_HALF_UP);
            num2 = num2.setScale(15, BigDecimal.ROUND_HALF_UP);
            BigDecimal numberResult = num1.divide(num2, BigDecimal.ROUND_HALF_UP);
            result = StringUtils.format(numberResult.doubleValue());
        } catch (NumberFormatException | ArithmeticException e) {
            // 除以空值会抛数组异常
            logger.warn(e.getMessage(), e);
        }

        return new FactValue(result);
    }

    public FactValue remainder(Object object) {
        String thisValue = this.value;
        String thatValue = getValue(object);

        String result = null;
        try {
            BigDecimal numberResult = new BigDecimal(thisValue).remainder(new BigDecimal(thatValue));
            result = StringUtils.format(numberResult.doubleValue());
        } catch (NumberFormatException | ArithmeticException e) {
            // 除以空值会抛数组异常
            logger.warn(e.getMessage(), e);
        }

        return new FactValue(result);
    }

    public FactValue length() {
        int length = this.value.length();
        return new FactValue(String.valueOf(length));
    }

    public boolean startsWith(String prefix) {
        return this.value.startsWith(prefix);
    }

    public boolean endsWith(String suffix) {
        return this.value.endsWith(suffix);
    }

    public boolean contains(String arg) {
        return this.value.contains(arg);
    }

    public boolean in(String arr) {
        String[] args = arr.split(ARRAY_SEPARATOR);
        for (String arg : args) {
            if (this.value.equals(arg.trim())) {
                return true;
            }
        }

        return false;
    }

    public boolean eq(Object object) {
        Integer compareResult = compareTo(object);
        return compareResult != null && compareResult == 0;
    }

    public boolean ne(Object object) {
        return !eq(object);
    }

    public boolean lt(Object object) {
        Integer compareResult = compareTo(object);
        return compareResult != null && compareResult < 0;
    }

    public boolean le(Object object) {
        Integer compareResult = compareTo(object);
        return compareResult != null && compareResult <= 0;
    }

    public boolean gt(Object object) {
        Integer compareResult = compareTo(object);
        return compareResult != null && compareResult > 0;
    }

    public boolean ge(Object object) {
        Integer compareResult = compareTo(object);
        return compareResult != null && compareResult >= 0;
    }

    private Integer compareTo(Object object) {
        if (object == null) {
            return null;
        }

        String thatValue = getValue(object);

        try {
            Double double1 = Double.valueOf(this.value);
            Double double2 = Double.valueOf(thatValue);
            return double1.compareTo(double2);
        } catch (NumberFormatException e) {
            logger.warn("此处错误不影响运行，只做记录：" + e.getMessage(), e);
        }

        return this.value.compareTo(thatValue);
    }

    private String getValue(Object object) {
        if (object == null) {
            return StringUtils.EMPTY;
        }

        String thatValue;

        if (object instanceof FactValue) {
            FactValue that = (FactValue) object;
            thatValue = that.value;
        } else {
            thatValue = object.toString();
        }

        return thatValue;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
