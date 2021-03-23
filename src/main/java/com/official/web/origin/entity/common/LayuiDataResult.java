package com.official.web.origin.entity.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LayuiDataResult {

    private int code = 0;
    private String msg;
    private int count = 0;
    private List data = new ArrayList<>();
    private int curr = 0;
    private int length = 10;
    private int offset;

}
