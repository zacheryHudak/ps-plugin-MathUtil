package com.appiancorp.ps.plugins;

import org.apache.commons.math3.util.Precision;
import org.apache.log4j.Logger;

import com.appiancorp.suiteapi.expression.annotations.Function;
import com.appiancorp.suiteapi.expression.annotations.Parameter;

@MathUtilCategory
public class MathUtil {

  private static final Logger LOG = Logger.getLogger(MathUtil.class);

  @Function
  public double roundV2(@Parameter double input, @Parameter int precision) {

    return Precision.round(input, precision);

  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    MathUtil obj = new MathUtil();
    System.out.println(obj.roundV2(1024.495, 2)); // does NOT work in Appian or with java Math or DecimalFormat API
    System.out.println(obj.roundV2(1020.495, 2)); // does work in Appian or with java Math or DecimalFormat API

  }

}
