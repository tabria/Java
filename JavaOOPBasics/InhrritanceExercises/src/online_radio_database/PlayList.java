package online_radio_database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayList {

    private List<Song> songsPlayList;
    private long playListDuration;

    public PlayList() {
        this.songsPlayList = new ArrayList<>();
        this.playListDuration = 0;
    }

    private void setSongsPlayList(Song song) {
        this.songsPlayList.add(song) ;
    }

    private void setPlayListDuration(long playListDuration) {
        this.playListDuration += playListDuration;
    }

    void addSongToPlayList(Song song){
        setSongsPlayList(song);
        setPlayListDuration(song.getSongLength());
    }

    private List<Song> getSongsPlayList() {
       return Collections.unmodifiableList(this.songsPlayList);
    }

    private long getPlayListDuration() {
        return this.playListDuration;
    }

    @Override
    public String toString() {
        long hours = getPlayListDuration() / 3600;
        long min = (getPlayListDuration() % 3600) / 60;
        long sec = getPlayListDuration() % 60;
        StringBuilder sb = new StringBuilder();
        sb.append("Songs added: ")
                .append(getSongsPlayList().size())
                .append(System.lineSeparator())
                .append("Playlist length: ")
                .append(hours)
                .append("h ")
                .append(min)
                .append("m ")
                .append(sec)
                .append("s");
        return sb.toString();
    }
}
