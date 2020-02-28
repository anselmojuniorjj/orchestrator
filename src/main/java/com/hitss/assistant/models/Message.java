package com.hitss.assistant.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ibm.watson.developer_cloud.assistant.v1.model.Context;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {

    private String text;
    private Context context;
    private String response;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
