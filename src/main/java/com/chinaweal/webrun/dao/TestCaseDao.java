package com.chinaweal.webrun.dao;

import com.chinaweal.webrun.entity.TestCase;

import java.util.ArrayList;

/**
 * Created by admin on 2016/8/6.
 */
//public interface TestCaseDao extends AbsBaseDao<TestCase,String> {
//}

public interface TestCaseDao {
    public ArrayList<TestCase> getTestCases(String pageIndex);

    public TestCase getTestCaseByID(String testCaseID);
}
