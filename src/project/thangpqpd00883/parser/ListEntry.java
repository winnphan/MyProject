package project.thangpqpd00883.parser;

import java.util.ArrayList;
import java.util.List;

public class ListEntry {
	private List<Entry> listEntry = new ArrayList<Entry>();

	public List<Entry> getListEntry() {
		return listEntry;
	}

	public void setListEntry(Entry _entry) {
		this.listEntry.add(_entry);
	}

	public ListEntry listEntryCopy() {
		// Copy danh sách entry vào ListEntry
		ListEntry copy = new ListEntry();
		copy.listEntry = listEntry;
		return copy;
	}
}
