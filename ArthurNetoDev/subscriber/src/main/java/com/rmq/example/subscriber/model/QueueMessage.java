package com.rmq.example.subscriber.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QueueMessage {

    @JsonProperty(value = "key1")
    private String key1;

    @JsonProperty(value = "key2")
    private String key2;
}
