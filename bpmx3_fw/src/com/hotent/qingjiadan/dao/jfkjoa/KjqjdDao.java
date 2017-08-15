
package com.hotent.qingjiadan.dao.jfkjoa;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.hotent.core.db.BaseDao;

import com.hotent.core.db.BaseDao;

import com.hotent.qingjiadan.model.jfkjoa.Kjqjd;

@Repository
public class KjqjdDao extends BaseDao<Kjqjd>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Kjqjd.class;
	}

}