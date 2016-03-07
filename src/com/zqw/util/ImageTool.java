package com.zqw.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageTool {
	private static final int WIDTH = 284;
	private static final int HEIGHT = 155;

//	public static void main(String[] args) {
//		File main = new File("C:/Users/Administrator/Desktop/�½��ļ��� (2)");
//		File[] fs = main.listFiles();
//		File f1 = new File(fs[0].getAbsolutePath());
//		File f2 = new File("C:/Users/Administrator/Desktop/�½��ļ���/" + 0 + ".jpg");
//		ImageTool.getPreviewImage(f1, f2, "jpg", 1);
//		// for (int i = 0; i < fs.length; i++) {
//		// File f1 = new File(fs[i].getAbsolutePath());
//		// File f2 = new File("C:/Users/Administrator/Desktop/�½��ļ���/"+i+".jpg");
//		// ImageTool.getPreviewImage(f1, f2, "jpg", 1);
//		// }
//
//	}

	public static void getPreviewImage(File sourceImg, File prevImg,
			String type, int colour) {
		try {
			BufferedImage newImage = zoomPicture(sourceImg, colour);
			ImageIO.write(newImage, type, prevImg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static BufferedImage zoomPicture(File sourceImg, int colour) {
		// TODO Auto-generated method stub
		BufferedImage srcImg;
		BufferedImage newImage = null;
		try {
			srcImg = ImageIO.read(sourceImg);

			int x = srcImg.getWidth();
			int y = srcImg.getHeight();
			int x1 = WIDTH;
			int y1 = HEIGHT;
			if (WIDTH * y < HEIGHT * x) {
				y1 = y * WIDTH / x;
			}

			if (WIDTH * y > HEIGHT * x) {
				x1 = HEIGHT * x / y;
			}

			newImage = new BufferedImage(WIDTH, HEIGHT,
					BufferedImage.SCALE_SMOOTH);
			Graphics2D g = newImage.createGraphics();
			if (colour == 1) {
				g.setColor(new Color(255, 255, 255));
			} else if (colour == 2) {
				g.setColor(new Color(0, 0, 0));
			}
			g.fillRect(0, 0, WIDTH, HEIGHT);

			Image scale = srcImg.getScaledInstance(x1, y1,
					BufferedImage.SCALE_SMOOTH);
			g.drawImage(scale, (WIDTH - x1) / 2, (HEIGHT - y1) / 2, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newImage;
	}
}
