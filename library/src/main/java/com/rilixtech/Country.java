package com.rilixtech;

/**
 * Created by hbb20 on 11/1/16.
 *
 * Clean up and moving all Country related code to {@link CountryUtils}.
 * a pojo should be a pojo and no more.
 * Updated by Joielechong 13 May 2017
 *
 */
public class Country {
  private String iso;
  private String phoneCode;
  private String name;

  public Country(String iso, String phoneCode, String name) {
    this.iso = iso;
    this.phoneCode = phoneCode;
    this.name = name;
  }

  public String getIso() {
    return iso;
  }

  public void setIso(String iso) {
    this.iso = iso;
  }

  public String getPhoneCode() {
    return phoneCode;
  }

  public void setPhoneCode(String phoneCode) {
    this.phoneCode = phoneCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * If country have query word in name or name code or phone code, this will return true.
   */
  boolean isEligibleForQuery(String query) {
    query = query.toLowerCase();
    return getName().toLowerCase().contains(query)
        || getIso().toLowerCase().contains(query)
        || getPhoneCode().toLowerCase().contains(query);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Country country = (Country) o;

    if (!iso.equals(country.iso)) return false;
    if (!phoneCode.equals(country.phoneCode)) return false;
    return name.equals(country.name);
  }

  @Override
  public int hashCode() {
    int result = iso.hashCode();
    result = 31 * result + phoneCode.hashCode();
    result = 31 * result + name.hashCode();
    return result;
  }
}
