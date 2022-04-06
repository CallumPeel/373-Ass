package SupplimentServices;

public class Record {

	private String recordName;
	private String artistName;
	private String yearCreated;
	private String trackLength;
	private String isRecordPlaying;

	public Record(String recordName, String artistName, String yearCreated, String trackLength,
			String isRecordPlaying) {
		this.recordName = recordName;
		this.artistName = artistName;
		this.yearCreated = yearCreated;
		this.trackLength = trackLength;
		this.isRecordPlaying = isRecordPlaying;
	}
}
