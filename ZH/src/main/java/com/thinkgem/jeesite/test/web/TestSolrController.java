package com.thinkgem.jeesite.test.web;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrException;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class TestSolrController {


    @Test
    public void testSolr() {
        // 连接solr
        SolrClient sc = new HttpSolrClient("http://39.106.214.184:2005/solr");
        // 执行操作
        SolrInputDocument doc = new SolrInputDocument();
        doc.setField("id", 2);
        doc.setField("name", "111");

        try {
//            sc.add(doc,1);
            sc.deleteById("2", 1000);
//            sc.d
//            sc.deleteByQuery("*:*");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSolrCloud() throws Exception {
        // 连接集群
        CloudSolrClient cloudSolrServer = new CloudSolrClient("39.106.214.184:2181,....");
        // 设置solr集群的总数据名称
        cloudSolrServer.setDefaultCollection("myTest2");
        // 执行操作
        SolrInputDocument doc = new SolrInputDocument();
        doc.setField("id", 2);
        doc.setField("name", "111");

        cloudSolrServer.add(doc, 1000);
    }
}
