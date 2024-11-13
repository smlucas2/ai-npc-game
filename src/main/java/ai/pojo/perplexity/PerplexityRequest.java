package ai.pojo.perplexity;

import ai.Model;
import ai.pojo.Message;
import ai.pojo.ResponseFormat;

import java.util.List;

public class PerplexityRequest {
    private String model;
    private List<Message> messages;
    private ResponseFormat response_format;

    public PerplexityRequest() {
    }

    public PerplexityRequest(Model model, List<Message> messages, ResponseFormat response_format) {
        this.model = model.getName();
        this.messages = messages;
        this.response_format = response_format;
    }

    public String getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model.getName();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public ResponseFormat getResponseFormat() {
        return response_format;
    }

    public void setResponseFormat(ResponseFormat response_format) {
        this.response_format = response_format;
    }
}
