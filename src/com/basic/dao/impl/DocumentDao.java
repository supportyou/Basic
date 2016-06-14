package com.basic.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.basic.base.BaseDao;
import com.basic.dao.IDocumentDao;
import com.basic.pojo.Document;
import com.basic.util.ChkUtil;
import com.basic.util.Page;

public class DocumentDao extends BaseDao<Document, Integer> implements IDocumentDao {

}
