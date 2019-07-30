package com.sun.mypoi.poidemo.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 *@author sunq
 *@date2019/7/29 16:22
 *@Description 工具类
 */
public class ExcelUtil {

	/**
	 *  创建Excel文档
	 *
	 * @param list 数据
	 * @param keys list中的map的key数组集合
	 * @param columnNames Excel的列名
	 * @return
	 */
	public static HSSFWorkbook createWorkBook(List<Map<String, Object>> list, String[] keys, String[] columnNames){
		// 创建Excel 工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建第一个sheet页，并命名
		HSSFSheet sheet = wb.createSheet(list.get(0).get("sheetName").toString());

		// 设置列宽
		for (int i = 0; i<keys.length; i++){
			// 把最后一列设置的宽一点
			if (i == keys.length - 1){
				sheet.setColumnWidth((short) i, (short)(200 * 120));
			}else {
				sheet.setColumnWidth((short) i, (short)(50 * 60));
			}

		}

		// 创建第一行，并设置其单元格格式
		HSSFRow row = sheet.createRow(0);
		row.setHeight((short)500);

		// 单元格格式（用于列名）
		HSSFCellStyle cs = wb.createCellStyle();
		HSSFFont f = wb.createFont();;
		f.setFontName("宋体");						// 字体
		f.setFontHeightInPoints((short)10);		// 字体大小
		f.setBold(true);							// 加粗
		cs.setFont(f);								// 单元格设置字体
		cs.setAlignment(HorizontalAlignment.CENTER);		// 水平居中
		cs.setVerticalAlignment(VerticalAlignment.CENTER);	// 垂直居中
		cs.setLocked(true);						// 设置不可编辑
		cs.setWrapText(true);						// 自动换行

		// 设置列名
		for (int i =0; i<columnNames.length; i++){
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(columnNames[i]);
			cell.setCellStyle(cs);
		}

		// 设置首行外，每行每列的值 （row和cell都是从0 开始）
		for (int i = 1; i < list.size(); i++){
			HSSFRow row1 = sheet.createRow((short) i);
			String flag = "";

			// 在row行创建单元格
			for (int  j = 0; j < keys.length; j++){
				HSSFCell cell = row1.createCell(j);
				Object obj = list.get(i).get(keys[j]);
				cell.setCellValue(obj == null ? " " : obj.toString());
				if (obj != null){
					if ("优".equals(obj.toString())){
						flag = "优";
					}else if ("差".equals(obj.toString())){
						flag = "差";
					}
				}
			}

			// 设置该行的样式
			HSSFFont f2 = wb.createFont();
			f2.setFontName("宋体");
			f2.setFontHeightInPoints((short) 10);
			if ("优".equals(flag)){
				HSSFCellStyle cellStyle = wb.createCellStyle();
				cellStyle.setFont(f2);
				cellStyle.setAlignment(HorizontalAlignment.CENTER);// 左右居中
				cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
				cellStyle.setLocked(true);
				cellStyle.setWrapText(true);//自动换行
				cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.YELLOW.getIndex());// 设置背景色
				cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				//依次为每个单元格设置样式
				for(int m=0;m<keys.length;m++){
					HSSFCell hssfCell = row1.getCell(m);
					hssfCell.setCellStyle(cellStyle);
				}
			}else if ("差".equals(flag)){
				HSSFCellStyle cellStyle2 = wb.createCellStyle();
				cellStyle2.setFont(f2);
				cellStyle2.setAlignment(HorizontalAlignment.CENTER);// 左右居中
				cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
				cellStyle2.setLocked(true);
				cellStyle2.setWrapText(true);//自动换行
				cellStyle2.setFillForegroundColor(HSSFColor.HSSFColorPredefined.RED.getIndex());// 设置背景色
				cellStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				for(int m=0;m<keys.length;m++){
					HSSFCell hssfCell = row1.getCell(m);
					hssfCell.setCellStyle(cellStyle2);
				}
			}else {
				HSSFCellStyle cs2 = wb.createCellStyle();
				cs2.setFont(f2);
				cs2.setAlignment(HorizontalAlignment.CENTER);// 左右居中
				cs2.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
				cs2.setLocked(true);
				cs2.setWrapText(true);//自动换行
				for(int m=0;m<keys.length;m++){
					HSSFCell hssfCell = row1.getCell(m);
					hssfCell.setCellStyle(cs2);
				}
			}


		}

		return wb;
	}

	/**
	 *  生成并下载 Excel
	 * @param list
	 * @param keys
	 * @param columnNames
	 * @param fileName
	 * @param response
	 * @throws IOException
	 */
	public static void downloadWorkBook(List<Map<String, Object>> list, String[] keys, String[] columnNames, String fileName, HttpServletResponse response) throws IOException{

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(list,keys,columnNames).write(os);
		}catch (IOException e){
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);

		// 设置response 参数
		response.reset();
		response.setContentType("application/vmd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xls").getBytes(),"iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);

			byte[] buff = new byte[2048];
			int byteRead;
			while(-1 != (byteRead = bis.read(buff, 0, buff.length))){
				bos.write(buff, 0, byteRead);
			}
		}catch (final IOException e){
			throw e;
		}finally {
			if (bis != null){
				bis.close();
			}
			if (bos != null){
				bos.close();
			}
		}
	}




}
