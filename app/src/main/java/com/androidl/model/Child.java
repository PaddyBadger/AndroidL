
package com.androidl.model;

import android.graphics.Bitmap;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "data"
})
public class Child {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("data")
    private Data_ data;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private Bitmap bm;
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    public Child withKind(String kind) {
        this.kind = kind;
        return this;
    }

    @JsonProperty("data")
    public Data_ getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data_ data) {
        this.data = data;
    }

    public Child withData(Data_ data) {
        this.data = data;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Bitmap getBm()
    {
        return bm;
    }

    public void setBm(Bitmap bm)
    {
        this.bm = bm;
    }
}
