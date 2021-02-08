//package hs.dcl.test.controller.lambda;
//
//
//import java.io.*;
//
//public class Html2PdfTool {
//	/**
//	 * windows运行环境需要处理第一个/,根据自身环境决定是否执行该方法
//	 */
//	public static final String PATH = Html2PdfTool.class.getResource("/").getPath();
//	// .replaceFirst("/", "");
//
//	/**
//	 *  @Description    ：htmlFile2pdfFile  @Method_Name    ：html2Pdf 
//	 *
//	 * @param htmlPath
//	 *            html文件地址
//	 * @param pdfPath 
//	 *            pdf文件地址
//	 */
//	public static void html2Pdf(String htmlPath, String pdfPath) {
//		// 读取的html文件地址
//		File htmlFile = new File(PATH + htmlPath);
//		// 生成的pdf地址
//		File pdfFile = new File(PATH + pdfPath);
//		try {
//			// HtmlFile TO PdfFile
//			HtmlConverter.convertToPdf(htmlFile, pdfFile);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 *  @Description    ：html字符串转换为pdf文件   @Method_Name    ：htmlStr2Pdf 
//	 *
//	 * @param htmlStr
//	 *            字符串格式的html
//	 * @param pdfPath
//	 *            pdf文件地址
//	 * @param converterProperties 
//	 */
//	public static void htmlStr2Pdf(String htmlStr, String pdfPath, ConverterProperties converterProperties) {
//		File pdfFile = new File(pdfPath);
//		try (OutputStream outputStream = new FileOutputStream(pdfFile)) {
//			HtmlConverter.convertToPdf(htmlStr, outputStream, converterProperties);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void htmlStr2Pdf(String htmlStr, PdfWriter pdfWriter) {
//		try {
//			HtmlConverter.convertToPdf(htmlStr, pdfWriter);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//
//	/**
//	 *  @Description    ：获取设置了中文ttf字体的converterProperties
//	 */
//	public static ConverterProperties getCnConverterProperties() {
//		ConverterProperties converterProperties = new ConverterProperties();
//		// 设置中文字体，ttf文件夹下SimSum-01和Dengb分别支持细字体和粗字体，缺一不可
//		FontProvider fontProvider = new FontProvider();
//		fontProvider.addDirectory(Html2PdfTool.PATH + "ttf/");
//		converterProperties.setFontProvider(fontProvider);
//		return converterProperties;
//	}
//}
