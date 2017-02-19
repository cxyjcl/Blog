package org.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.dao.impl.PhotoDao;
import org.entity.PageDivide;
import org.entity.PhotoDivide;

import cn.itcast.commons.CommonUtils;

public class PhotoService {
	
	PhotoDao dao = new PhotoDao();
	
	public PhotoDivide getPhotoDivide(Map<String, String[]> map) throws SQLException {
		PhotoDivide divide =CommonUtils.toBean(map, PhotoDivide.class);
		List photoList =dao.limitTitle(divide.getPhotoCode());
		long total = dao.countPage();
		divide.setTotalPhoto(total);
		divide.setPhotoList(photoList);
		return divide;
	}


}
