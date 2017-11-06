package online_radio_database;

public class Song {

    private String artistName;
    private String songName;
    private long songLength;

    public Song(String artistName, String songName, String songLength) throws InvalidArtistNameException, InvalidSongNameException, InvalidSongLengthException {
        setArtistName(artistName);
        setSongName(songName);
        setSongLength(songLength);
    }

    private void setArtistName(String artistName) throws InvalidArtistNameException {
        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) throws InvalidSongNameException {
        if (songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
        this.songName = songName;
    }

    private void setSongLength(String songLength) throws InvalidSongLengthException {
        String[] songTime = songLength.split(":");
        long songMinutes;
        long songSeconds;
    try {
            songMinutes = Long.parseLong(songTime[0]);
            songSeconds = Long.parseLong(songTime[1]);
        } catch (Exception e) {
            throw new InvalidSongLengthException("Invalid song length.");
        }

        if (songMinutes < 0 || songMinutes > 14) {
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        if (songSeconds < 0 || songSeconds > 59) {
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }

        this.songLength = songSeconds + songMinutes * 60;

    }

    long getSongLength() {
        return this.songLength;
    }
}
