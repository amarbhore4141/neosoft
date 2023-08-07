package com.neosoft.demopoc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InstrumentChannelDto {
    private String channel_link;
    private String channel_type;
    private boolean is_default;
    private String name;

}
