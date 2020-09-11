package com.baya.smartfarm.common;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class PaginationResult<T> implements Serializable {

  private int pageNumber = 1;
  private int totalPages = 1;
  private long totalRecords = 0;

  private List<T> data;

  public static <T> PaginationResult<T> pagination(List<T> data) {
    return pagination(data, 1);
  }

  public static <T> PaginationResult<T> pagination(List<T> data, long totalRecord) {
    return pagination(data, totalRecord, 1);
  }

  public static <T> PaginationResult<T> pagination(List<T> data, long totalRecord, int pageNumber) {
    return pagination(data, totalRecord, pageNumber, 10);
  }

  public static <T> PaginationResult<T> pagination(List<T> data, long totalRecord, int pageNumber, int pageSize) {
    PaginationResult<T> paginationResult = new PaginationResult<>();
    if (pageNumber < 1) {
      pageNumber = 1;
    }
    paginationResult.pageNumber = pageNumber;
    paginationResult.totalRecords = totalRecord;
    if (totalRecord == 0) {
      paginationResult.totalPages = 1;
    } else {
      if (totalRecord % pageSize == 0) {
        paginationResult.totalPages = (int) totalRecord / pageSize;
      } else {
        paginationResult.totalPages = (int) totalRecord / pageSize + 1;
      }
    }
    paginationResult.data = data;
    return paginationResult;
  }

}
