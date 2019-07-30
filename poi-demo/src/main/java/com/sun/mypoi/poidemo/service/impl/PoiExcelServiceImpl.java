package com.sun.mypoi.poidemo.service.impl;

import com.sun.mypoi.poidemo.entity.ProjectAudi;
import com.sun.mypoi.poidemo.service.PoiExcelService;
import com.sun.mypoi.poidemo.utils.ExcelUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 *@author sunq
 *@date2019/7/29 17:16
 *@Description
 */
@Service
public class PoiExcelServiceImpl implements PoiExcelService {

	/**
	 *  导出表格
	 * @param response
	 * @return
	 */
	@Override
	public String export(HttpServletResponse response) {

		ProjectAudi audi1 = new ProjectAudi("西南区", "重庆完美", "ui设计", "Lucy", "哈士大夫", "UI5班", "第一阶段", 123, new Date(), 100,
				"优", "这是原因", "这是评价", "www.baidu.com");
		ProjectAudi audi2 = new ProjectAudi("京津冀", "北京中关村", "游戏美术", "乔巴", "无", "游戏美术3班", "第一阶段", 123, new Date(), 80,
				"良", "水电费", "水电费", "www.baidu.com");
		ProjectAudi audi3 = new ProjectAudi("京津冀", "北京中关村", "游戏美术", "Bella", "无", "游戏美术3班", "第一阶段", 123, new Date(), 95,
				"优", "水电费", "水电费", "www.baidu.com");
		ProjectAudi audi4 = new ProjectAudi("京津冀", "北京中关村", "游戏美术", "路飞", "无", "游戏场景2班", "第一阶段", 178, new Date(), 50,
				"差", "大飞", "1232131", "www.baidu.com");
		ProjectAudi audi5 = new ProjectAudi("京津冀", "北京中关村", "游戏美术", "萨摩", "123", "游戏场景2班", "第一阶段", 123, new Date(), 90,
				"优", "123213", "", "www.baidu.com");
		ProjectAudi audi6 = new ProjectAudi("京津冀", "北京中关村", "游戏美术", "艾斯", "代", "游戏场景2班", "第一阶段", 0, new Date(), 60, "中",
				"", "", "www.baidu.com");
		ProjectAudi audi7 = new ProjectAudi("京津冀", "北京中关村", "游戏美术", "鹰眼", "123", "游戏美术7班", "第一阶段", 213, new Date(), 56,
				"差", "", "", "www.baidu.com");

		List<ProjectAudi> projectAudiList = new ArrayList<>();
		projectAudiList.add(audi1);
		projectAudiList.add(audi2);
		projectAudiList.add(audi3);
		projectAudiList.add(audi4);
		projectAudiList.add(audi5);
		projectAudiList.add(audi6);
		projectAudiList.add(audi7);

		String fileName = "项目审核表";
		List<Map<String, Object>> list = createExcelRecord(projectAudiList);
		//列名
		String[] columnNames = {"大区", "校区", "专业", "面授教师", "在线教师", "班级", "项目所处阶段", "作品人次", "项目提交日期", "项目得分", "得分等级",
				"原因", "项目评价", "附件"};
		// map的 key
		String[] keys = {"bigArea", "campus", "major", "faceToFaceTeacher", "onlineTeacher", "gradeClass",
				"projectTerm", "worksNumber", "projectCommitTime", "projectScore", "projectLevel", "reason", "comment",
				"eclosure"};

		try {
			ExcelUtil.downloadWorkBook(list, keys, columnNames, fileName, response);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "excel";
	}

	private List<Map<String, Object>> createExcelRecord(List<ProjectAudi> list) {
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sheetName", "sheet1");
			listMap.add(map);
			for (int i = 0; i < list.size(); i++) {
				ProjectAudi projectAudi = list.get(i);
				Map<String, Object> mapValue = new HashMap<>();

				mapValue.put("bigArea", projectAudi.getBigArea());
				mapValue.put("campus", projectAudi.getCampus());
				mapValue.put("major", projectAudi.getMajor());
				mapValue.put("faceToFaceTeacher", projectAudi.getFaceToFaceTeacher());
				mapValue.put("onlineTeacher", projectAudi.getOnlineTeacher());
				mapValue.put("gradeClass", projectAudi.getGradeClass());
				mapValue.put("projectTerm", projectAudi.getProjectTerm());
				mapValue.put("worksNumber", projectAudi.getWorksNumber());
				mapValue.put("projectCommitTime", projectAudi.getProjectCommitTime());
				mapValue.put("projectScore", projectAudi.getProjectScore());
				mapValue.put("projectLevel", projectAudi.getProjectLevel());
				mapValue.put("reason", projectAudi.getReason());
				mapValue.put("comment", projectAudi.getComment());
				mapValue.put("eclosure", projectAudi.getEclosure());

				listMap.add(mapValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMap;
	}

}
