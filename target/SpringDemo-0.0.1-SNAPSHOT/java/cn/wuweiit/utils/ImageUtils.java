package cn.wuweiit.utils;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
 

/**
 * 图片工具类
 * 
 * @author marker
 * @version 1.0
 */
public class ImageUtils {
 

	/**
	 * 将原图片的BufferedImage对象生成缩略图
	 * 
	 * source：原图片的BufferedImage对象 
	 * targetW:缩略图的宽
	 * targetH:缩略图的高
	 * @param equalProportion false拉伸
	 */
	public static BufferedImage resize(BufferedImage source, int targetW,
			int targetH, boolean equalProportion) {
		int type = source.getType();
		BufferedImage target = null;
		double sx = (double) targetW / source.getWidth();
		double sy = (double) targetH / source.getHeight();
		// 这里想实现在targetW，targetH范围内实现等比例的缩放
		// 如果不需要等比例的缩放则下面的if else语句注释调即可
		if (equalProportion) {
			if (sx > sy) {
				sx = sy;
				targetW = (int) (sx * source.getWidth());
			} else {
				sy = sx;
				targetH = (int) (sx * source.getHeight());
			}
		}
		if (type == BufferedImage.TYPE_CUSTOM) {
			ColorModel cm = source.getColorModel();
			WritableRaster raster = cm.createCompatibleWritableRaster(targetW,
					targetH);
			boolean alphaPremultiplied = cm.isAlphaPremultiplied();
			target = new BufferedImage(cm, raster, alphaPremultiplied, null);
		} else {
			target = new BufferedImage(targetW, targetH, type);
			Graphics2D g = target.createGraphics();
			g.setRenderingHint(RenderingHints.KEY_RENDERING,
					RenderingHints.VALUE_RENDER_QUALITY);
			g.drawRenderedImage(source,
					AffineTransform.getScaleInstance(sx, sy));
			g.dispose();
		}
		return target;
	}

	
	
	
	
	
	
	
	
	
	
	
	public static void resize(byte[] bytes, String thumbnailPath, int targetW, int targetH,
			boolean equalProportion) { 
		
		try {
			
			BufferedImage source = ImageIO.read(new ByteArrayInputStream(bytes)); 
			BufferedImage target = ImageUtils.resize(source, targetW, targetH, equalProportion);
			
			ImageIO.write(target, FileTools.getSuffix(thumbnailPath), new File(thumbnailPath));
			
		} catch (IOException e) { 
			e.printStackTrace();
		}  
	}

	
    public static void cutImage(InputStream bi2, String dest, int x,int y, int w,int h) throws IOException{   
        Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName("jpeg");   
        ImageReader reader = iterator.next();   
//        InputStream in=new FileInputStream(bi2);  
        ImageInputStream iis = ImageIO.createImageInputStream(bi2); 
         
         
        
        reader.setInput(iis, true);    
        ImageReadParam param = reader.getDefaultReadParam();   
        
        Rectangle rect = new Rectangle(x, y, w, h);    
        param.setSourceRegion(rect);    
        
        
        BufferedImage bi = reader.read(0, param);     
        ImageIO.write(bi, "png", new File(dest));             

    }  
    
    public static void cut2Image(String src, String dest, int x,int y, int w,int h) throws IOException{   
        Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName("jpg");   
        ImageReader reader = iterator.next();   
        InputStream in=new FileInputStream(src);  
        ImageInputStream iis = ImageIO.createImageInputStream(in);   
        reader.setInput(iis, true);   
        ImageReadParam param = reader.getDefaultReadParam();   
        Rectangle rect = new Rectangle(x, y, w, h);    
        param.setSourceRegion(rect);   
        BufferedImage bi = reader.read(0,param);     
        ImageIO.write(bi, "jpg", new File(dest));             

    }  
}
