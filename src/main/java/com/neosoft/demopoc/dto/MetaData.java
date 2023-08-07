package com.neosoft.demopoc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MetaData {
    private int total_pages;
    private int total_items;
    private int current_page;
    private boolean has_more;

}
