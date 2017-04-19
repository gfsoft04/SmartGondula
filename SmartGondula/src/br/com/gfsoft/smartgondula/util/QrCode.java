package br.com.gfsoft.smartgondula.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.ByteMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QrCode {

	private String nomeQrCodeGerado;
	private static final String formatoQrCodeGerado = "png";

	public void gerarQrCode(String nomeImg, String texto) {
		if (texto == null || texto.isEmpty()) {
			JOptionPane.showMessageDialog(null, "O texto a ser codificado é obrigatório", "Erro",
					JOptionPane.ERROR_MESSAGE);
		} else {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				String path = chooser.getSelectedFile().getAbsolutePath();
				gerarComZXing(nomeImg, path, texto);
			}
		}
	}

	private void gerarComZXing(String nomeImg, String path, String texto) {
		try {
			nomeQrCodeGerado = nomeImg;

			File myFile = new File(path + "/" + nomeQrCodeGerado + "." + formatoQrCodeGerado);
			Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			
			//Alterado
			//BitMatrix byteMatrix = qrCodeWriter.encode(texto, BarcodeFormat.QR_CODE, 100, 100, hintMap);
			ByteMatrix byteMatrix = qrCodeWriter.encode(texto, BarcodeFormat.QR_CODE, 500, 500, hintMap);
			
			int CrunchifyWidth = byteMatrix.getWidth();
			BufferedImage image = new BufferedImage(CrunchifyWidth, CrunchifyWidth, BufferedImage.TYPE_INT_RGB);
			image.createGraphics();

			Graphics2D graphics = (Graphics2D) image.getGraphics();
			graphics.setColor(Color.WHITE);
			graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
			graphics.setColor(Color.BLACK);

			for (int i = 0; i < CrunchifyWidth; i++) {
				for (int j = 0; j < CrunchifyWidth; j++) {
					//Alterado
					//if (byteMatrix.get(i, j)) {
					if (byteMatrix.get(i, j) != 0) {
						graphics.fillRect(i, j, 1, 1);
					}
				}
			}
			ImageIO.write(image, formatoQrCodeGerado, myFile);
			JOptionPane.showMessageDialog(null, "QRCode gerado em: " + myFile.getAbsolutePath(), "QRCode Gerado", JOptionPane.INFORMATION_MESSAGE);
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
