package com.elasticsearch.csdn;

import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

public class ElasticSearchHandler {

    public static void main(String[] args) {
        try {
            /* 创建客户端 */
            // client startup
            Client client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

            List<Blog> jsonData = DataFactory.getInitJsonData();

            for (Blog blog : jsonData) {
                IndexResponse response = client.prepareIndex("demo", "ning",String.valueOf(blog.getId())).setSource(
                        jsonBuilder()
                                .startObject()
                                .field("id", blog.getId())
                                .field("title", blog.getTitle())
                                .field("posttime", blog.getPosttime())
                                .field("content", blog.getContent())
                                .endObject()
                ).get();
                if (response.getResult().compareTo(DocWriteResponse.Result.CREATED) < 0) {
                    System.out.println("创建成功!");
                }
            }
            client.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
