package com.elasticsearch;

import com.detaildemo.DetailListTest;
import com.detaildemo.entity.DetailEntity;
import org.apache.poi.ss.formula.functions.T;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

public class DetailESTest {

    TransportClient client = null;

    public static final String INDEX = "local";

    public static final String TYPE = "demodate";

    private List<Map<String, Object>> dataList = null;

    @Before
    public void beforeClient() throws Exception {
        client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        //初始化数据到ES
//        List<DetailEntity> detailEntities = DetailListTest.dataList(300000);
//        dataList = DetailListTest.groupBy(detailEntities);
    }

    @Test
    public void queryTest() throws Exception {
        QueryBuilder qb1 = matchQuery("name", "和0");
        QueryBuilder qb2= QueryBuilders.multiMatchQuery("和", "name","addr");
        SearchResponse response = client.prepareSearch(INDEX).setTypes(TYPE).setQuery(qb1).execute()
                .actionGet();
        System.out.println(response);
    }

    @Test
    public void createIndexAndAddDocument() throws Exception {
        for (Map<String, Object> objectMap : dataList) {
            String dataId = (String) objectMap.get("dataId");
            IndexResponse response = client.prepareIndex(INDEX,TYPE, dataId)
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("name", objectMap.get("name"))
                            .field("age", objectMap.get("age"))
                            .field("addr", objectMap.get("addr"))
                            .endObject()
                    )
                    .get();
            System.out.println("插入结果 response =》 ");
            System.out.println(response.getResult());
//            System.out.println("索引名称：" + response.getIndex() + ", 类型名称：" + response.getType() + ", 文档id:" + response.getId());
        }
    }



}
