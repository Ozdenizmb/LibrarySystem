import java.io.*;

import javax.swing.JOptionPane;

public class FileIslemler {

	private String title;
	private String author;
	private String category;
	private String year;
	private String price;
	private String dosyaYolu = "C:\\Users\\TOSHIBA\\Desktop\\SOFTWARE\\Software Projects\\Java Denemeleri (Eclipse)\\Odev7\\src\\veritabani";
	
	public FileIslemler(String title, String author, String category, String year, String price) {
		setTitle(title);
		setAuthor(author);
		setCategory(category);
		setYear(year);
		setPrice(price);
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setDosyaYolu(String dosyaYolu) {
		this.dosyaYolu = dosyaYolu;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getCategory() {
		return category;
	}
	public String getYear() {
		return year;
	}
	public String getPrice() {
		return price;
	}
	public String getDosyaYolu() {
		return dosyaYolu;
	}
	
	// Her metoda bu metodu ekleyip, txt dosyasinin olup olmadigini kontrol edecegim. Bu hata alma ihtimalini dusurecektir.
	public void checkDataBase(File file) throws IOException {
		if(!file.exists()) {
			file.createNewFile();
		}
	}
	
	public void writerFile() throws IOException {
		File file = new File(dosyaYolu);
		checkDataBase(file);
		
		FileWriter fWriter = new FileWriter(dosyaYolu, true);
		BufferedWriter bWriter = new BufferedWriter(fWriter);
		
		bWriter.append(title + "\t" + author + "\t" + category + "\t" + year + "\t" + price);
		bWriter.newLine();
		bWriter.close();
	}
	
	// writerFile Metodu Overloading Edildi. Bu metod StringBuilder Icin Yazdirma Islemi Yapacak.
	public void writerFile(Object object) throws IOException {
		FileWriter fWriter = new FileWriter(dosyaYolu);
		BufferedWriter bWriter = new BufferedWriter(fWriter);
		
		bWriter.write(object.toString());
		bWriter.close();
	}
	
	
	public void searchData() throws IOException {
		File file = new File(dosyaYolu);
		checkDataBase(file);
		
		FileReader fReader = new FileReader(dosyaYolu);
		BufferedReader bReader = new BufferedReader(fReader);
		
		String line;
		boolean durum = false;
		
		while((line = bReader.readLine()) != null) {
			String[] array = line.split("\t");
			
			if(title.equalsIgnoreCase(array[0])) {
				String stringData = array[0] + " / " + array[1] + " / " + array[2] + " / " + array[3] + " / " + array[4];
				JOptionPane.showMessageDialog(null, stringData);
				durum = true;
			}
		}
		
		if(!durum) {
			JOptionPane.showMessageDialog(null, "Aradýðýnýz Kitap Sistemde Yer Almamaktadýr!");
		}
		
		bReader.close();
	}
	
	public void updateData(String nPrice) throws IOException {
		File file = new File(dosyaYolu);
		checkDataBase(file);
		
		FileReader fReader = new FileReader(dosyaYolu);
		BufferedReader bReader = new BufferedReader(fReader);
		
		StringBuilder builder = new StringBuilder();
		
		String line;
		String newPrice = nPrice;
		
		boolean durum = false;
		
		while((line = bReader.readLine()) != null) {
			String[] array = line.split("\t");
			
			if(price.equals(array[4])) {
				builder.append(array[0] + "\t" + array[1] + "\t" + array[2] + "\t" + array[3] + "\t" + newPrice + "\n");
				durum = true;
			}
			else {
				builder.append(line + "\n");
			}
			
		}
		
		if(durum) {
			writerFile(builder);
			JOptionPane.showMessageDialog(null, "Sistemdeki Ilgili Ücretler Deðiþtirilmiþtir.");
		}
		else {
			JOptionPane.showMessageDialog(null, "Degiþtirmek Istediðiniz Ücret, Sistemde Bulunamadý.");
		}
		
		bReader.close();
		
	}
	
	public void deleteData() throws IOException {
		File file = new File(dosyaYolu);
		checkDataBase(file);
		
		FileReader fReader = new FileReader(dosyaYolu);
		BufferedReader bReader = new BufferedReader(fReader);
		
		StringBuilder builder = new StringBuilder();
		
		String line;
		boolean durum = false;
		
		while((line = bReader.readLine()) != null) {
			String[] array = line.split("\t");
			
			if(title.equals(array[0])) {
				durum = true;
			}
			else {
				builder.append(line + "\n");
			}
			
		}
		
		if(durum) {
			writerFile(builder);
			JOptionPane.showMessageDialog(null, "Ilgili Kitap Sistemden Silinmistir.");
		}
		else {
			JOptionPane.showMessageDialog(null, "Silmek Istediðiniz Kitap, Sistemde Bulunamadý.");
		}
		
		bReader.close();
	}
	
	public StringBuilder getData() throws IOException {
		
		File file = new File(dosyaYolu);
		checkDataBase(file);
		
		FileReader fReader = new FileReader(dosyaYolu);
		BufferedReader bReader = new BufferedReader(fReader);
		
		StringBuilder builder = new StringBuilder();
		String line;
		
		boolean durum = false;
		
		while((line = bReader.readLine()) != null) {
			
			builder.append(line + "\n");
			durum = true;
			
		}
		
		bReader.close();
		
		if(durum) {
			return builder;
		}
		else {
			builder.append("");
			return builder;
		}
	}
	
	// Created by Mehmet Baran Ozdeniz - baranozdeniz.com
	
}
