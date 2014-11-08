package project.thangpqpd00883.parser;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.util.Log;
import android.util.Xml;



public class ParserXML {
	
	private URL feedUrl;

	private Entry _entry;
	
	final String RSS = "rss";
	final String CHANNEL = "channel";
	final String ITEM = "item";
	final String TITLE = "title";
	final String pubDate ="pubDate";	
	final String description ="description";
	final String LINK = "link";
	String tag = "xml parser";
	int i = 1;
	
		//================= Lấy URL ====================
		public ParserXML(String feedUrlString) {
			try {
				
				Log.i("URL: ", feedUrlString);
				this.feedUrl = new URL(feedUrlString);
			} catch (MalformedURLException e) {
				throw new RuntimeException(e);
			}
		}
		protected InputStream getInputStream() {
			try {
				return feedUrl.openConnection().getInputStream();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		//================== Lấy file RSS gốc để lấy những đoạn khác =====================
		public ListEntry parseXMNCC() {
			final ListEntry listItemEntry = new ListEntry();
			_entry = new Entry();
	
			RootElement root = new RootElement(RSS);

			Element channel = root.getChild(CHANNEL);
			Element item = channel.getChild(ITEM);
			item.getChild(TITLE).setEndTextElementListener(
					new EndTextElementListener() {
						@Override
						public void end(String body) {						
							Log.i(tag, "item: " + i);						
							Log.i(tag, "Name: " + body);
							_entry.setTitle(body);
							Log.i(tag, "============//get title");
						}
					});
			//=================== Lấy image =========================
			
			
			//=================== Lấy nội dung ======================
//			item.getChild(description).setEndTextElementListener(
//					new EndTextElementListener() {			
//				@Override
//				public void end(String body) {
//					
//					Log.i(tag, "item: " + i);				
//					Log.i(tag, "Decription: " + body);
//					_entry.setDescription(body);
//					Log.i(tag, "============//get decription");
//				}
//			});
			//=================== Lấy ngày của bài báo ======================
			item.getChild(pubDate).setEndTextElementListener(new EndTextElementListener() {
				
				@Override
				public void end(String body) {
			
					Log.i(tag, "item: " + i);
					i++;
					Log.i(tag, "pubDate: " + body);
					_entry.setPubDate(body);
					Log.i(tag, "============//get pudDate");
				}
			});
			//=================== Lấy link của bài báo ======================
			item.getChild(LINK).setEndTextElementListener(new EndTextElementListener() {
				
				@Override
				public void end(String body) {

					Log.i(tag, "item: " + i);
					i++;
					Log.i(tag, "Link: " + body);
					_entry.setLink(body);
					Log.i(tag, "============//get Link");
				}
			});
			//================== đóng lại element ===========================
			item.setEndElementListener(new EndElementListener() {
				
				@Override
				public void end() {
					// Copy từng item vào object Entry
					
					Log.i(tag, "============Entry Copy================");
					listItemEntry.setListEntry(_entry.entryCopy());
					//tạo ra danh sách Entry
				}
			});
	
			// Lấy từng item Entry
			root.setEndElementListener(new EndElementListener() {
				@Override
				public void end() {
					
					Log.i(tag, "============listEntryCopy================");
					// khi lay dc toan bo du lieu no se copy sang 1 list khac va du
					// lieu duoc xu ly tren du lieu tam nay
					listItemEntry.listEntryCopy();
				}
			});
	
			try {
				Xml.parse(this.getInputStream(), Xml.Encoding.UTF_8,
						root.getContentHandler());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			return listItemEntry;
		}
}
