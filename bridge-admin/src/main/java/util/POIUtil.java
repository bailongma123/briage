package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.ande.bridge.common.DateUtil;

/**
 * <pre>
 * <b> Excl文件解析工具类.</b> 
 * <b>Author: tianhua.lan@la-inc.cn </b> 
 * <b>date:
 * 2018年5月24日 下午1:48:01 </b>
 * ----------------------------------------------------------------------------
 * ----------------------------------------------------------------------------
 * 
 * <pre>
 */
public class POIUtil {

	private final static String xls = "xls";
	private final static String xlsx = "xlsx";

	/**
	 * 读excle 文件的内容
	 * 
	 * @param file
	 *            （文件的内容）
	 * @throws IOException
	 */
	public static List<String[]> readExcel(MultipartFile file ) throws IOException {
		// 判断文件
		checkFile(file);
		// 创建excle
		Workbook workbook = getWorkBook(file);
		// 存放读取数据的集合
		List<String[]> list = new ArrayList<String[]>();
		if (workbook != null) {
			for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
				// 创建工作表
				Sheet sheet = workbook.getSheetAt(sheetNum);
				if (sheet == null) {
					continue;
				}
				// 第一行
				int firstRowNum = 5;
				// 最后一行�
				int lastRowNum = sheet.getLastRowNum();
				for (int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++) {
					// 总列数
					Row row = sheet.getRow(rowNum);
					if (row == null) {
						continue;
					}
					// 第一列
					int firstCellNum = 1;
					// 最后一列
					int lastCellNum = row.getPhysicalNumberOfCells();
					String[] cells = new String[row.getPhysicalNumberOfCells()];
					for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
						Cell cell = row.getCell(cellNum);
						
						cells[cellNum-1] = getCellValue(cell);
					}
					list.add(cells);
				}
			}
			workbook.close();
		}
		return list;
	}

	/**
	 * @author tingzhanGuo@la-inc.cn
	 * @title getMapList
	 * @param list
	 * @return
	 * @Description 转换表格解析后的List<String[]> 为 List<Map<String, Object>>
	 */
	public static List<Map<String, Object>> getMapList(List<String[]> list) {
		// 初始化集合容器
		List<Map<String, Object>> mapList = null;
		// 确定有几个有效实体类
		String[] ss = list.get(1);
		int count = -1;
		for (String s : ss) {
			if (StringUtils.isNotEmpty(s) && StringUtils.isNotBlank(s)) {
				count++;
			}
		}
		// 遍历String[]的List集合>>>获取属性值的Map集合的List集合
		for (int i = 1; i <= count; i++) {
			Map<String, Object> map = null;
			// 获取每一列数据的数组
			for (String[] string : list) {
				// 数组第一个元素为属性名称
				map.put(string[0], string[i]);
			}
			mapList.set(i - 1, map);
		}
		return mapList;
	}

	public static void checkFile(MultipartFile file) throws IOException {
		if (null == file) {
			throw new FileNotFoundException("文件不存在");
		}
		// 获取文件名
		String fileName = file.getOriginalFilename();
		// 判断文件后缀名
		if (!fileName.endsWith(xls) && !fileName.endsWith(xlsx)) {
			throw new IOException(fileName + "该文件不属于excel文件");
		}
	}

	public static Workbook getWorkBook(MultipartFile file) {
		// 获取文件名
		String fileName = file.getOriginalFilename();
		Workbook workbook = null;
		try {
			// 开启输入流
			FileInputStream is = (FileInputStream)file.getInputStream();
			// 根据后缀名，分别方法
			if (fileName.endsWith(xls)) {
				// 2003
				workbook = new HSSFWorkbook(is);
			} else if (fileName.endsWith(xlsx)) {
				// 2007
				workbook = new XSSFWorkbook(is);
			}
		} catch (IOException e) {
		}
		return workbook;
	}

	public static String getCellValue(Cell cell) {
		String cellValue = "";
		if (cell == null) {
			return cellValue;
		}
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
		}
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_STRING:
			cellValue = String.valueOf(cell.getStringCellValue());
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA:
			cellValue = String.valueOf(cell.getCellFormula());
			break;
		case Cell.CELL_TYPE_BLANK:
			cellValue = "";
			break;
		case Cell.CELL_TYPE_ERROR:
			cellValue = "非法字符";
			break;
		default:
			cellValue = "未知类型";
			break;
		}
		return cellValue;
	}

	/*
	 * //*** 写入excle
	 * 
	 * @param dataList 内容
	 * 
	 * @param cloumnCount
	 * 
	 * @param finalXlsxPath
	 *//*
		*/ public static void writeExcel(List<String[]> dataList, String finalXlsxPath) {
		OutputStream out = null;
		if (ObjectUtil.isEmpty(finalXlsxPath)) {
			finalXlsxPath = "D:/writeExcel.xlsx";
		}
		try {
			// 读取Excel文档
			File finalXlsxFile = new File(finalXlsxPath);
			Workbook workBook = getWorkbok(finalXlsxFile);
			// sheet 对应一个工作页
			Sheet sheet = workBook.getSheetAt(0);

			int rowNumber = sheet.getLastRowNum();
			for (int i = 1; i <= rowNumber; i++) {
				Row row = sheet.getRow(i);
				sheet.removeRow(row);
			}
			out = new FileOutputStream(finalXlsxPath);
			workBook.write(out);

			for (int j = 0; j < dataList.size(); j++) {
				Row row = sheet.createRow(j);
				String[] dataMap = dataList.get(j);
				int len = dataMap.length;
				for (int k = 0; k <= len - 1; k++) {
					Cell first = row.createCell(k);

					first.setCellValue(dataMap[k]);
				}
			}
			out = new FileOutputStream(finalXlsxPath);
			workBook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("数据导出成功");
	}

	public static Workbook getWorkbok(File file) throws IOException {
		Workbook wb = null;
		FileInputStream in = new FileInputStream(file);
		if (file.getName().endsWith(xls)) { // Excel&nbsp;2003
			wb = new HSSFWorkbook(in);
		} else if (file.getName().endsWith(xlsx)) { // Excel 2007/2010
			wb = new XSSFWorkbook(in);
		}
		return wb;
	}

	/**
	 * 执行excel 文件上传
	 * 
	 * @param file
	 * @return
	 */
	public static String upExcel(MultipartFile file) {
		String msg = "";
		if (null == file) {
			return "文件保存失败";
		} else {
			String OriginalfileName = file.getOriginalFilename();
			String fileFix = OriginalfileName.substring(OriginalfileName.lastIndexOf(".") + 1);
			if (file.getSize() > 5242880) {
				msg = "文件超过5M";
			} else {
				String sdf = DateUtil.getCurrTime();
				String fileDirPath = "D:/" + sdf;
				try {
					String fileName = saveFile(file.getBytes(), fileFix, fileDirPath);
					msg = fileDirPath + "/" + fileName;
				} catch (IOException e) {
				}
			}
		}
		return msg;
	}

	public static String saveFile(byte[] content, String fileFix, String path) throws IOException {
		File fileDir = new File(path);
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
		String saveFileName = System.currentTimeMillis() + "." + fileFix;
		FileOutputStream fo = new FileOutputStream(new File(path) + "/" + saveFileName);
		try {
			fo.write(content);
		} catch (Exception e) {
			throw new IOException(e);
		} finally {
			fo.flush();
			fo.close();
		}
		return saveFileName;
	}

	public static void main(String[] args) {
//		 File file = new File("D:/aa.xlsx");
//		
//		 try {
//		 List<String[]> list = POIUtil.readExcel(file);
//		
//		System.out.println(JsonUtil.toJson(list.get(0)));
////		 for(int i=0;i<list.size();i++){
////		 System.out.println(JsonUtil.toJson(list.get(i)));
////		 }
//		// for(String[] s : list){
//		// System.out.println(JsonUtil.toJson(s[0]));
//		// }
//		 } catch (IOException e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 }
//		

	}

	//
	// BrigeEntity entity = new BrigeEntity();
	// entity.setManageObjectId(list.get(i)[0]);
	// entity.setBridgeId(list.get(i)[1]);
	// entity.setBridgeCode(list.get(i)[2]);
	// entity.setBridgeName(list.get(i)[3]);
	// entity.setBridgeType(list.get(i)[4]);
	// entity.setBridgeMidStakeNumber(list.get(i)[5]);
	// entity.setBridgeSize(list.get(i)[6]);
	// entity.setBridgeLength(list.get(i)[7]);
	// entity.setBridgeSpanCombination(list.get(i)[8]);
	// entity.setBridgeWidthConbination(list.get(i)[9]);
	// entity.setBridgeHeight(list.get(i)[10]);
	// entity.setBridgeConstructDate(list.get(i)[11]);
	// bru.insert(entity);

}
