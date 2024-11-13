package messenging.pojos;

import ai.Model;
import ai.pojo.Message;
import ai.pojo.ResponseFormat;
import ai.pojo.perplexity.PerplexityRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PojoTest {
    @Test
    public void testMessage() {
        Message message = new Message("testRole", "testContent");
        Assertions.assertEquals(message.getRole(),"testRole");
        Assertions.assertEquals(message.getContent(),"testContent");
        message.setRole("updatedRole");
        message.setContent("updatedContent");
        Assertions.assertEquals(message.getRole(),"updatedRole");
        Assertions.assertEquals(message.getContent(),"updatedContent");
    }

    @Test
    public void testResponseFormat() {
        ResponseFormat format = new ResponseFormat("testType");
        Assertions.assertEquals(format.getType(),"testType");
        format.setType("updatedType");
        Assertions.assertEquals(format.getType(),"updatedType");
    }

    @Test
    public void testPerplexityRequest() {
        List<Message> messages = new ArrayList<>();
        Message message1 = new Message("testRole1", "testContent1");
        Message message2 = new Message("testRole2", "testContent2");
        messages.add(message1);
        messages.add(message2);

        ResponseFormat format = new ResponseFormat("testType");

        PerplexityRequest request = new PerplexityRequest(Model.LLAMA_S, messages, format);
        Assertions.assertEquals(request.getMessages().getFirst().getContent(), "testContent1");
        Assertions.assertEquals(request.getMessages().getLast().getContent(), "testContent2");
        Assertions.assertEquals(request.getModel(), Model.LLAMA_S.getName());
        Assertions.assertEquals(request.getResponseFormat().getType(), "testType");

        List<Message> newMessages = new ArrayList<>();
        Message newMessage = new Message("newRole", "newContent");
        newMessages.add(newMessage);

        ResponseFormat newFormat = new ResponseFormat("newType");

        request.setModel(Model.LLAMA_L);
        request.setMessages(newMessages);
        request.setResponseFormat(newFormat);
        Assertions.assertEquals(request.getMessages().getFirst().getContent(), "newContent");
        Assertions.assertEquals(request.getModel(), Model.LLAMA_L.getName());
        Assertions.assertEquals(request.getResponseFormat().getType(), "newType");
    }
}
