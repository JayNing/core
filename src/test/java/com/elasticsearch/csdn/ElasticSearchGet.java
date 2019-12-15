package com.elasticsearch.csdn;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;

import static org.elasticsearch.index.query.QueryBuilders.termQuery;

public class ElasticSearchGet {

    TransportClient client = null;

    public static final String INDEX = "blog";

    public static final String TYPE = "article";

    @Before
    public void beforeClient() throws Exception {
        client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
    }

    @Test
    public void queryTest() throws Exception {
        QueryBuilder qb1 = termQuery("title", "hibernate");
        QueryBuilder qb2= QueryBuilders.multiMatchQuery("git", "title","content");


        SearchResponse response = client.prepareSearch(INDEX).setTypes(TYPE).setQuery(qb1).execute()
                .actionGet();

        SearchHits hits = response.getHits();
        if (hits.getHits().length > 0) {
            for (SearchHit hit : hits) {
                System.out.println("score:"+hit.getScore()+":\t"+hit.getSourceAsString());// .get("title")
            }
        } else {
            System.out.println("搜到0条结果");
        }
    }

}
