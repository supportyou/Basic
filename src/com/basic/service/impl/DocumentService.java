package com.basic.service.impl;

import java.util.List;

import com.basic.base.BaseService;
import com.basic.dao.IDocumentDao;
import com.basic.service.IDocumentService;

public class DocumentService extends BaseService implements IDocumentService {
	
	private IDocumentDao documentDao;
	
	public IDocumentDao getDocumentDao() {
		return documentDao;
	}
	public void setDocumentDao(IDocumentDao documentDao) {
		super.setBaseDao(documentDao);
		this.documentDao = documentDao;
	}
	
}
