package com.thinkgem.jeesite.modules.met.service.metrecord;

import com.thinkgem.jeesite.common.test.SpringTransactionalContextTests;
import com.thinkgem.jeesite.modules.met.entity.metrecord.MetRecord;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * MetRecordService Tester.
 *
 * @author <wzp>
 * @since <pre>06/24/2018</pre>
 * @version 1.0
 */
public class MetRecordServiceTest extends SpringTransactionalContextTests {

    @Autowired
    private MetRecordService service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: get(String id)
     *
     */
    @Test
    public void testGet() throws Exception {
    }

    /**
     *
     * Method: findList(MetRecord metRecord)
     *
     */
    @Test
    public void testFindList() throws Exception {

    }

    /**
     *
     * Method: findPage(Page<MetRecord> page, MetRecord metRecord)
     *
     */
    @Test
    public void testFindPage() throws Exception {
        MetRecord metRecord = new MetRecord();
        metRecord.setType("1");
        service.findList(metRecord);
    }

    /**
     *
     * Method: save(MetRecord metRecord)
     *
     */
    @Test
    public void testSave() throws Exception {
//TODO: Test goes here... 
    }

    /**
     *
     * Method: delete(MetRecord metRecord)
     *
     */
    @Test
    public void testDelete() throws Exception {
//TODO: Test goes here... 
    }


} 
