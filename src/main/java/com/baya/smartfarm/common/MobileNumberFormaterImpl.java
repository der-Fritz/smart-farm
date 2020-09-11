package com.baya.smartfarm.common;//package com.cb.bayah.common;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//@Component
//public class MobileNumberFormaterImpl implements MobileNumberFormater {
//
//  @Value("${mobile.number.minimum.length}")
//  private int minimumMsisdnLength;
//
//  @Value("${mobile.number.validation.regex}")
//  private String msisdnRegexExpression;
//
//  @Value("${mobile.number.international.code}")
//  private String internationalCode;
//
//  @Override
//  public String formatMsisdnMinimum(final String msisdn) {
//    if (StringUtils.isEmpty(msisdn)) {
//      return msisdn;
//    }
//    final String trimmedMsisdn = msisdn.trim();
//    if (trimmedMsisdn.length() <= minimumMsisdnLength) {
//      return trimmedMsisdn;
//    }
//    return trimmedMsisdn.substring(trimmedMsisdn.length() - minimumMsisdnLength);
//  }
//
//  @Override
//  public boolean isValidMsisdn(final String msisdn) {
//    return !StringUtils.isEmpty(msisdn) && msisdn.matches(msisdnRegexExpression);
//  }
//
//  @Override
//  public String formatMobileNumberInternational(String msisdn) {
//    return internationalCode + formatMsisdnMinimum(msisdn);
//  }
//
//}
