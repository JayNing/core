package com.elasticsearch;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

public class CreateDocumentTest {

    TransportClient client = null;

    public static final String INDEX = "local";

    public static final String TYPE = "demodate";

    @Before
    public void beforeClient() throws Exception {
        client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
    }


    @Test
    public void createIndexAndAddDocument() throws Exception {
        IndexResponse response = client.prepareIndex("blog","article", "1")
                .setSource(jsonBuilder()
                        .startObject()
                        .field("id", "Jay")
                        .field("title", "title")
                        .field("posttime", "posttime")
                        .field("content", "content")
                        .endObject()
                )
                .get();
        System.out.println("response =》 ");
        System.out.println("索引名称：" + response.getIndex() + ", 类型名称：" + response.getType() + ", 文档id:" + response.getId());
    }

    @Test
    public void deleteIndex() throws Exception {
        AcknowledgedResponse acknowledgedResponse = client.admin().indices().prepareDelete(INDEX)
                .execute().actionGet();
        System.out.println(acknowledgedResponse);
    }

}
